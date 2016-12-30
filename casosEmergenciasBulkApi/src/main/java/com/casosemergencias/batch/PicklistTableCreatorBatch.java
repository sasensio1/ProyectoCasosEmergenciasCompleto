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
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.bean.PickListBatch;
import com.casosemergencias.logic.sf.util.SalesforceLoginChecker;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.constants.ConstantesBatch;
import com.force.api.DescribeSObject;
import com.force.api.DescribeSObject.Field;
import com.force.api.DescribeSObject.PicklistEntry;
import com.force.api.ForceApi;
import com.sforce.soap.metadata.FieldType;

@Resource
public class PicklistTableCreatorBatch {
	final static Logger logger = Logger.getLogger(PicklistTableCreatorBatch.class);

	@Autowired
	private SalesforceLoginChecker salesforceLoginChecker;
	
	public void fillHerokuPicklistTable() {
		logger.trace("Comienzo del proceso de carga de los picklists de SalesForce a la base de datos de Heroku");
		
		List<PickListBatch> listaRecuperadaSF;
		
		try {
			UserSessionInfo sessionInfo = new UserSessionInfo();
			sessionInfo.setUsername(ConstantesBatch.SF_USER_NAME_VALUE);
			sessionInfo.setPassword(ConstantesBatch.SF_PASSWORD_VALUE);
			sessionInfo.setAccessToken(ConstantesBatch.SF_USER_TOKEN_VALUE);
			ForceApi api = salesforceLoginChecker.getSalesforceApi(sessionInfo);
			if (api != null) {
				listaRecuperadaSF = getPicklistList(api);
				if (listaRecuperadaSF != null && !listaRecuperadaSF.isEmpty()) {
					loadHerokuData(listaRecuperadaSF);
				}
			}
		} catch (Exception ex) {
			logger.error("Error cargando los picklists: ", ex);
		}
		logger.trace("Proceso de carga de los picklists de SalesForce a la base de datos de Heroku completado");
	}
	
	/**
	 * 
	 * @return
	 */
	private static List<PickListBatch> getPicklistList(ForceApi api) {
		logger.trace("Se van a recuperar las listas de la api");
		List<PickListBatch> listaDatos = null;
		if (api != null) {
			// Recuperar objetos de fichero de configuracion
			Properties props = new Properties();
			try (InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(ConstantesBatch.PICKLIST_PROPERTIES_ARCHIVE_NAME)) {
				props.load(resourceStream);
				if (props != null && props.containsKey(ConstantesBatch.PICKLIST_PROPERTIES_INVOLVED_PICKLISTS_PROPERTY)) {
					String objetos = props.getProperty(ConstantesBatch.PICKLIST_PROPERTIES_INVOLVED_PICKLISTS_PROPERTY);
					if (objetos != null) {
						String[] objCreacion = objetos.split(",");
						listaDatos = new ArrayList<PickListBatch>();
						List<PickListBatch> listAux = null;
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
	private static List<PickListBatch> getDescribeData(ForceApi force, String objetoSalesforce) {
		List<PickListBatch> listaPickList = null;
		PickListBatch objPickList = null;
		DescribeSObject objDescribe = force.describeSObject(objetoSalesforce);
		logger.trace("Recuperando objeto DescribeSObject");
		if (objDescribe != null) {
			logger.info("Nombde del objeto: " + objDescribe.getName());
			List<Field> fields = objDescribe.getFields();
			List<PicklistEntry> picklistValues = null;
			logger.info("Obtenidos " + fields.size() + " campos");
			if(fields != null && !fields.isEmpty()) {
				Field field = null;
				for (int i = 0; i < fields.size(); i++) {
					field = fields.get(i);
					if (field.getType() != null && field.getType().equalsIgnoreCase(FieldType.Picklist.toString())) {
						picklistValues = field.getPicklistValues();
						logger.info("Picklist recuperado: " + picklistValues);
						if (picklistValues != null && !picklistValues.isEmpty()) {
							for (int j = 0; j < picklistValues.size(); j++) {
								if (listaPickList == null) {
									listaPickList = new ArrayList<PickListBatch>();
								}
								objPickList = new PickListBatch();
								objPickList.setObjeto(objetoSalesforce);
								objPickList.setCampo(field.getName());
								objPickList.setCodigo(picklistValues.get(j).getValue());
								objPickList.setValor(picklistValues.get(j).getLabel());
								listaPickList.add(objPickList);
								logger.info("Item de la lista [Valor: " + picklistValues.get(j).getValue() + " | Descripcion: " + picklistValues.get(j).getLabel() + "]");
							}
						}
					}
				}
			}
		}
		return listaPickList;
	}

	/**
	 * 
	 * @param picklistList
	 */
	private static void loadHerokuData(List<PickListBatch> picklistList) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			// Driver de postgree
			Class.forName(ConstantesBatch.HEROKU_DATABASE_DRIVER_CLASS);
			logger.debug("Recuperando conexion");
			// Conexion con los datos de postgree
			// connection =
			// DriverManager.getConnection("jdbc:postgresql://ec2-23-21-102-155.compute-1.amazonaws.com:5432/d5418fkq019rpl","dhtsyocojobsrd",
			// "cjB0mRnKEn8XeK2RBwkjAipxoJ");
			connection = DriverManager.getConnection( System.getenv("DATABASE_URL_JAVA"), System.getenv("DATABASE_USER"), System.getenv("DATABASE_PASSWORD"));
			connection.setAutoCommit(false);
			logger.debug("Conectado correctamente");
			stmt = connection.createStatement();
			Boolean existeTabla = false;
			// Comprobar si ya existe la tabla
			DatabaseMetaData md = connection.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {
				logger.debug("ResultSet name: " + rs.getString(3));
				if ("picklists".equalsIgnoreCase(rs.getString(3))) {
					existeTabla = true;
				}
			}
			
			if (!existeTabla) {
				logger.debug("Inicio creacion tabla.");
				stmt.executeUpdate(createPicklistsTable());
				logger.debug("Tabla creada.");
			} else {
				logger.debug("Inicio borrado datos.");
				stmt.executeUpdate("DELETE FROM salesforce.picklists");
				logger.debug("Fin borrado datos.");
			}
			
			logger.debug("Inicio actualizacion de datos.");
			pstmt = connection.prepareStatement(
					"INSERT INTO salesforce.picklists (id, objeto, campo, codigo, valor) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			PickListBatch obkPickList = null;
			for (Integer i = 0; i < picklistList.size(); i++) {
				obkPickList = picklistList.get(i);
				pstmt.setInt(1, i);
				pstmt.setString(2, obkPickList.getObjeto());
				pstmt.setString(3, obkPickList.getCampo());
				pstmt.setString(4, obkPickList.getCodigo());
				pstmt.setString(5, obkPickList.getValor());
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
	private static String createPicklistsTable() {
		return "CREATE TABLE salesforce.picklists ("
				+ "id integer NOT NULL, " 
				+ "objeto VARCHAR(255), "
				+ "campo VARCHAR(255), " 
				+ "codigo VARCHAR(255), " 
				+ " valor VARCHAR(255), " 
				+ " PRIMARY KEY (id)"
				+ ")";
	}
}
