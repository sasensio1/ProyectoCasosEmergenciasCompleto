package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.DireccionDAO;
import com.casosemergencias.dao.vo.DireccionVO;
import com.casosemergencias.logic.ws.clients.GetCalleWSClient;
import com.casosemergencias.logic.ws.responses.GetCalleWSResponse;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.ConstantesTibcoWS;
import com.casosemergencias.util.datatables.DataTableProperties;


//las transacciones se abren y cierran aqui
public class DireccionServiceImpl implements DireccionService{
	
	final static Logger logger = Logger.getLogger(DireccionService.class);
	
	@Autowired
	private DireccionDAO direccionDao;
	
	@Autowired
	private GetCalleWSClient getCalleWSClient;
		
	/**
	 * Metodo que devuelve una lista de todas las direccions a mostrar en la tabla de nuestra app.
	 * @return listofalldireccions
	 */
	@Override
	public List<Direccion> listOfDireccionesTable() {
		
		List<Direccion> listOfDireccionesTable= new ArrayList<Direccion>();
		List<DireccionVO> listOfAllDirecciones =new ArrayList<DireccionVO>();
		listOfAllDirecciones=direccionDao.readAllDireccion();
		Direccion direccion= null;
		
		
		for(DireccionVO dir:listOfAllDirecciones){
			
			direccion = new Direccion();
			
			ParserModelVO.parseDataModelVO(dir, direccion);
		
			listOfDireccionesTable.add(direccion);
					
		}		
		return listOfDireccionesTable;		
	}
	
	@Override
	public Direccion readDireccionBySfid(String sfid){
		Direccion returnDireccion = new Direccion();
		DireccionVO direccionVO = direccionDao.readDireccionBySfid(sfid);
		if (direccionVO != null){
			ParserModelVO.parseDataModelVO(direccionVO, returnDireccion);
		}
		return returnDireccion;
	}
	
	public List<Direccion> readAllDirecciones(DataTableProperties propDatatable){
		logger.debug("--- Inicio -- readAllDirecciones ---");
		
		List<Direccion> listDirecciones = new ArrayList<>();
		
		List<DireccionVO> listDireccionesVO = direccionDao.readDireccionDataTable(propDatatable);
		logger.debug("--- Inicio -- readAllDirecciones tamano : " + listDireccionesVO.size() + " ---");
		Direccion direccion = null;
		for(DireccionVO direccionVO : listDireccionesVO){
			direccion = new Direccion();
			ParserModelVO.parseDataModelVO(direccionVO, direccion);
			listDirecciones.add(direccion);
			
		}
		
		logger.debug("--- Fin -- readAllDirecciones ---:"+listDirecciones.size());
		
		return listDirecciones;
	}
	
	public Integer getNumDirecciones(DataTableProperties propDatatable){
		return direccionDao.countDireccion(propDatatable);
	}

	
	/**
	 * M&eacute;todo que realiza la llamada a los servicios web de TIBCO para
	 * devolver la informaci&oacute;n de la calle pasa por par&aacute;metro.
	 * 
	 * @param idComuna
	 *            Comuna a la que pertenece la calle.
	 * @param nombreCalle
	 *            Nombre de la calle a buscar.
	 * @return Map<String, Object> Mapa con los objetos devueltos por el
	 *         servicio web.
	 */
	@Override	
	public Map<String, Object> getDatosCalleWS(String idComuna, String nombreCalle) {
		logger.debug("--- Inicio -- getDatosCalleWS ---");
		Map<String, Object> datosWS = new HashMap<String, Object>();
		
		logger.info("------>>>>> Llamando al servicio de consulta de datos de la calle ------>>>>>");
		GetCalleWSResponse datosCalleResponse = getCalleWSClient.getCalleWS(idComuna, nombreCalle.toUpperCase());
		if (datosCalleResponse != null) {
			if (datosCalleResponse.getMapaErrores() != null && !datosCalleResponse.getMapaErrores().containsKey("0")) {
				logger.error("Error en la llamada al servicio: ");
				for (Map.Entry<String,String> entry : datosCalleResponse.getMapaErrores().entrySet()) {
					logger.error("- Error " + entry.getKey() + ": " + entry.getValue());
				}
			} else {
				logger.info("Peticion procesada correctamente");
			}
			
			if (datosCalleResponse.getListadoCalles() != null && !datosCalleResponse.getListadoCalles().getCalle().isEmpty()) {
				logger.info("Se han encontrado " + datosCalleResponse.getListadoCalles().getCalle().size() + " calles que cumplen los requisitos de busqueda");
				datosWS.put(ConstantesTibcoWS.SIEME002_RESPONSE_LIST_NAME, datosCalleResponse.getListadoCalles());
			}
		} else {
			logger.error("El servicio ha devuelto una respuesta vacia");
		}
		logger.info("<<<<<------ Llamada al servicio de consulta de datos de la calle completa <<<<<------");
		logger.debug("--- Fin -- getDatosCalleWS ---");
		return datosWS;
	}

}