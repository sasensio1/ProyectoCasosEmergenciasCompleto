package com.casosemergencias.batch;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.casosemergencias.batch.bean.FieldLabelBatch;
import com.casosemergencias.logic.sf.util.SalesforceLoginChecker;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.constants.ConstantesBatch;
import com.force.api.DescribeSObject;
import com.force.api.DescribeSObject.Field;
import com.force.api.ForceApi;

@Resource
public class FieldLabelTableCreatorBatch {
	final static Logger logger = Logger.getLogger(FieldLabelTableCreatorBatch.class);
	
	@Autowired
	private SalesforceLoginChecker salesforceLoginChecker;
	
	public void fillHerokuFieldLabelTable() {
		logger.trace("Comienzo del proceso de carga de los labels de campo de SalesForce a la base de datos de Heroku");
		List<FieldLabelBatch> listaRecuperadaSF;
		try {
			UserSessionInfo sessionInfo = new UserSessionInfo();
			sessionInfo.setUsername(ConstantesBatch.SF_USER_NAME_VALUE);
			sessionInfo.setPassword(ConstantesBatch.SF_PASSWORD_VALUE);
			sessionInfo.setAccessToken(ConstantesBatch.SF_USER_TOKEN_VALUE);
			ForceApi api = salesforceLoginChecker.getSalesforceApi(sessionInfo);
			if (api != null) {
				listaRecuperadaSF = getFieldLabelList(api);
				if (listaRecuperadaSF != null && !listaRecuperadaSF.isEmpty()) {
					loadHerokuData(listaRecuperadaSF);
				}
			}
		} catch (Exception ex) {
			logger.error("Error cargando los labels de campo: ", ex);
		}
		logger.trace("Proceso de carga de los labels de campo de SalesForce a la base de datos de Heroku completado");
	}
	
	/**
	 * 
	 * @return
	 */
	private static List<FieldLabelBatch> getFieldLabelList(ForceApi api) {
		logger.trace("Se van a recuperar las listas de labels de campo de la api");
		List<FieldLabelBatch> listaDatos = null;
		if (api != null) {
			// Recuperar objetos de fichero de configuracion
			Properties props = new Properties();
			try (InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(ConstantesBatch.FIELD_LABEL_PROPERTIES_ARCHIVE_NAME)) {
				props.load(resourceStream);
				if (props != null && props.containsKey(ConstantesBatch.FIELD_LABEL_PROPERTIES_INVOLVED_OBJECTS_PROPERTY)) {
					String objetos = props.getProperty(ConstantesBatch.FIELD_LABEL_PROPERTIES_INVOLVED_OBJECTS_PROPERTY);
					if (objetos != null) {
						String[] objCreacion = objetos.split(",");
						listaDatos = new ArrayList<FieldLabelBatch>();
						List<FieldLabelBatch> listAux = null;
						for (Integer i = 0; i < objCreacion.length; i++) {
							listAux = getDescribeData(api, objCreacion[i]);
							if (listAux != null && !listAux.isEmpty()) {
								listaDatos.addAll(listAux);
							}
						}
					}
				}
			} catch (Exception ex) {
				logger.error("Error recuperando propiedades: ", ex);
			}
		}
		return listaDatos;
	}

	/**
	 * 
	 * @param force
	 * @param objetoSalesforce
	 * @return
	 */
	private static List<FieldLabelBatch> getDescribeData(ForceApi force, String objetoSalesforce) {
		List<FieldLabelBatch> listaFieldLabel = null;
		FieldLabelBatch objFieldLabel = null;
		DescribeSObject objDescribe = force.describeSObject(objetoSalesforce);
		logger.trace("Recuperando objeto DescribeSObject");
		if (objDescribe != null) {
			logger.info("Nombre del objeto: " + objDescribe.getName());
			List<Field> fields = objDescribe.getFields();
			logger.info("Obtenidos " + fields.size() + " campos");
			if(fields != null && !fields.isEmpty()) {
				Field field = null;
				DescribeSObject objDescribeAux = null;
				Map<String, String> mapaAuxReference = null;
				String labelAux = "";
				for (int i = 0; i < fields.size(); i++) {
					field = fields.get(i);
					if (field != null){
						logger.info("Campo recuperado: " + field.getName());
						if (listaFieldLabel == null) {
							listaFieldLabel = new ArrayList<FieldLabelBatch>();
						}
						objFieldLabel = new FieldLabelBatch(objetoSalesforce, field.getName(), field.getLabel());
						listaFieldLabel.add(objFieldLabel);
						if (ConstantesBatch.UTIL_TYPE_REFERENCE.equalsIgnoreCase(field.getType()) && !field.isCustom()){
							try{
								labelAux = "";
								objDescribeAux = null;
								if (ConstantesBatch.UTIL_FIELD_OWNER.equalsIgnoreCase(field.getRelationshipName())){
									labelAux = "Propietario del caso";
								}else if (mapaAuxReference != null && mapaAuxReference.containsKey(field.getReferenceTo().get(0))){
									labelAux = mapaAuxReference.get(field.getReferenceTo().get(0));
								}else{
									objDescribeAux = force.describeSObject(field.getReferenceTo().get(0));
									if (objDescribeAux != null){
										labelAux = objDescribeAux.getLabel();
										logger.info("Item de la lista [Campo: " + field.getRelationshipName() + " | Label: " + objDescribeAux.getLabel() + "]");
										if (mapaAuxReference == null){mapaAuxReference = new HashMap<String, String>();}
										mapaAuxReference.put(field.getReferenceTo().get(0), labelAux);
									}
								}
								if (!StringUtils.isEmpty(labelAux)){
									listaFieldLabel.add(new FieldLabelBatch(objetoSalesforce, field.getRelationshipName(), labelAux));
									logger.info("Item de la lista [Campo: " + field.getRelationshipName() + " | Label: " + labelAux + "]");
								}
							}catch (Exception ex) {
								logger.error("Error recuperando objeto relacionado: ", ex);
							}
						}
						logger.info("Item de la lista [Campo: " + field.getName() + " | Label: " + field.getLabel() + "]");
					}
				}
			}
		}
		return listaFieldLabel;
	}
	
	/**
	 * 
	 * @param picklistList
	 */
	private static void loadHerokuData(List<FieldLabelBatch> fieldLabelList) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			// Driver de postgree
			Class.forName(ConstantesBatch.HEROKU_DATABASE_DRIVER_CLASS);
			logger.debug("Recuperando conexion");
			connection = DriverManager.getConnection(System.getenv("DATABASE_URL_JAVA"), System.getenv("DATABASE_USER"), System.getenv("DATABASE_PASSWORD"));
			connection.setAutoCommit(false);
			logger.debug("Conectado correctamente");
			stmt = connection.createStatement();
			Boolean existeTabla = false;
			// Comprobar si ya existe la tabla
			DatabaseMetaData md = connection.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {
				logger.debug("ResultSet name: " + rs.getString(3));
				if ("fieldlabel".equalsIgnoreCase(rs.getString(3))) {
					existeTabla = true;
					break;
				}
			}

			if (!existeTabla) {
				logger.debug("Inicio creacion tabla.");
				stmt.executeUpdate(createFieldLabelTable());
				logger.debug("Tabla creada.");
			} else {
				logger.debug("Inicio borrado datos.");
				stmt.executeUpdate("DELETE FROM salesforce.fieldlabel");
				logger.debug("Fin borrado datos.");
			}
			logger.debug("Inicio actualizacion de datos.");
			pstmt = connection.prepareStatement(
					"INSERT INTO salesforce.fieldlabel (id, objeto, campo, label) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			FieldLabelBatch objFieldLabel = null;
			for (Integer i = 0; i < fieldLabelList.size(); i++) {
				objFieldLabel = fieldLabelList.get(i);
				pstmt.setInt(1, i);
				pstmt.setString(2, objFieldLabel.getObjeto());
				pstmt.setString(3, objFieldLabel.getCampo());
				pstmt.setString(4, objFieldLabel.getLabel());				
				pstmt.addBatch();
			}
			pstmt.executeBatch();

			connection.commit();
		} catch (SQLException seException) {
			logger.error("Error insertando los datos en la tabla de Heroku: ", seException);
		} catch (Exception exception) {
			logger.error("Error insertando los datos en la tabla de Heroku: ", exception);
		} finally {
			try {
				if (stmt != null) {
					connection.close();
				}
			} catch (SQLException se) {
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	private static String createFieldLabelTable() {
		return "CREATE TABLE salesforce.fieldlabel ("
				+ "id integer NOT NULL, " 
				+ "objeto VARCHAR(255), "
				+ "campo VARCHAR(255), " 
				+ "label VARCHAR(255), "
				+ " PRIMARY KEY (id)"
				+ ")";
	}
}
