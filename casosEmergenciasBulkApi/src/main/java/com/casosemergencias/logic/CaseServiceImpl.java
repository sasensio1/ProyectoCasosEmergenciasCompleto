package com.casosemergencias.logic;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseCommentDAO;
import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.CaseHistoryDAO;
import com.casosemergencias.dao.vo.CaseCommentVO;
import com.casosemergencias.dao.vo.CaseHistoryVO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.logic.sf.response.CreateCaseResponse;
import com.casosemergencias.logic.sf.rest.CreateCase;
import com.casosemergencias.logic.sf.util.SalesforceLoginChecker;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.CaseHistory;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.User;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.constants.ConstantesError;
import com.casosemergencias.util.datatables.DataTableProperties;

public class CaseServiceImpl implements CaseService{

	final static Logger logger = Logger.getLogger(CaseService.class);
	
	@Autowired
	private CaseDAO caseDao;
	
	@Autowired
	private CaseHistoryDAO caseHistoryDao;
	
	@Autowired
	private CaseCommentDAO caseCommentDao;
	
	@Autowired
	private SalesforceLoginChecker salesforceLoginChecker;
	
	/**
	 * Metodo que devuelve una lista con todos los Casos que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<Caso> readAllCase(DataTableProperties propDatatable) {
		
		logger.debug("--- Inicio -- readAllCase ---");
		
		List<Caso> listCaso = new ArrayList<>();
		List<CaseVO> listCasosVO = caseDao.readCaseDataTable(propDatatable);

		logger.debug("--- Inicio -- readAllCase casos en la lista: " + listCasosVO.size() + " ---");
		
		for (CaseVO casoVO : listCasosVO) {
			Caso caso = new Caso();
			ParserModelVO.parseDataModelVO(casoVO, caso);
			listCaso.add(caso);
		}
		
		logger.debug("--- Fin -- readAllCase ---");
		return listCaso;
	}
	
	/**
	 * Metodo que devuelve caso de BBDD por su sfid
	 * 
	 * @return
	 */
	@Override
	public Caso readCaseBySfid(String sfid, Integer numEntradas){
		Caso returnCase = new Caso();
		CaseVO casoVO = caseDao.readCaseBySfid(sfid);
		if (casoVO != null){
			ParserModelVO.parseDataModelVO(casoVO, returnCase);
		}
		
		List<CaseHistoryVO> listaHistorialCasoVO = caseHistoryDao.readCaseHistoryByCaseId(sfid, numEntradas);//inicialmente solo recuperamos 10
		List<CaseHistory> historialCasosRelacionado = parseaYPreparaListaHistorialCasos(listaHistorialCasoVO);
		returnCase.setHistorialCaso(historialCasosRelacionado);
		
		List<CaseCommentVO> listaComentarioCasoVO = caseCommentDao.readCaseCommentByCaseId(sfid);
		List<CaseComment> comentariosCasoRelacionado = parseaYPreparaListaComentariosCasos(listaComentarioCasoVO);
		returnCase.setCommentarioCaso(comentariosCasoRelacionado);
		
		return returnCase;
	}
	
	/**
	 * Metodo que devuelve caso de BBDD por su id
	 * 
	 * @return
	 */
	@Override
	public Caso readCaseById(Integer id){
		Caso returnCase = new Caso();
		CaseVO casoVO = caseDao.readCaseById(id);
		if (casoVO != null){
			ParserModelVO.parseDataModelVO(casoVO, returnCase);
		}
		return returnCase;
	}
	
	public Integer getNumCasos(DataTableProperties propDatatable){
		logger.debug("--- getNumCasos ---");
		return caseDao.getNumCasos(propDatatable);
	}
	
	public Caso insertCase(Caso caso) throws EmergenciasException {
		logger.trace("--- Servicio insertCase iniciado ---");
		// 1. Leer usuario de fichero de propiedades
		Properties properties = new Properties();
		String username = null;
		String password = null;
		String token = null;
		String userId = null;
		UserSessionInfo userSessionInfoFromDB = null;
		CreateCaseResponse respuestaCaso = null;
		CaseVO casoVO = null;
		
		try (InputStream propsInputStream = getClass().getClassLoader().getResourceAsStream("/environment/dev/config.properties")) {
			properties.load(propsInputStream);
			username = properties.getProperty("heroku.user");
			password = properties.getProperty("heroku.pass");
			token = properties.getProperty("heroku.token");
			userId = properties.getProperty("heroku.userid");
			
			if (username != null && !"".equals(username) && password != null && !"".equals(password) && token != null && !"".equals(token)) {
				UserSessionInfo sessionInfoToLogin = new UserSessionInfo();
				sessionInfoToLogin.setUsername(properties.getProperty("heroku.user"));
				sessionInfoToLogin.setPassword(properties.getProperty("heroku.pass"));
				sessionInfoToLogin.setAccessToken(properties.getProperty("heroku.token"));
				userSessionInfoFromDB = salesforceLoginChecker.getUserSessionInfo(sessionInfoToLogin);
				if (userSessionInfoFromDB != null) {
					caso.setPropietarioCaso(userId);
					respuestaCaso = CreateCase.createCaseInSalesforce(userSessionInfoFromDB, caso);
					if (respuestaCaso != null) {
						if (respuestaCaso.getIdCaso() != null && !"".equals(respuestaCaso.getIdCaso())) {
							caso.setSfid(respuestaCaso.getIdCaso());
							logger.info("Caso creado con sfid:" + respuestaCaso.getIdCaso());
						}
						
						if (respuestaCaso.getNumeroCaso() != null && !"".equals(respuestaCaso.getNumeroCaso())) {
							caso.setNumeroCaso(respuestaCaso.getNumeroCaso());
							logger.info("Caso creado con no. de caso: " + respuestaCaso.getNumeroCaso());
						}
						
						casoVO = new CaseVO();
						ParserModelVO.parseDataModelVO(caso, casoVO);
						Integer id = caseDao.insertCase(casoVO);
						if (id != null && id.intValue() > 0) {
							logger.info("Caso insertado correctamente en Heroku con id: " + id.intValue());
						} else {
							caso = null;
							logger.error("No se ha podido insertar el caso en Heroku. Ha fallado la inserción en base de datos");
							throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_003, ConstantesError.HEROKU_CASE_CREATION_OK_WITH_ERROR + "(N. caso: " + respuestaCaso.getNumeroCaso() + ")");
						}
					} else {
						caso = null;
						logger.warn("Se ha producido un error al insertar el caso en SalesForce");
						throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_002, ConstantesError.SALESFORCE_CASE_CREATION_ERROR);
					}
				}
			}
		} catch (IOException exception) {
			logger.error("Error obteniendo los datos del usuario: ", exception);
			throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_002, ConstantesError.SALESFORCE_CASE_CREATION_ERROR);
		}

		logger.trace("--- Servicio insertCase completado ---");
		return caso;
	}

	@Override
	public Integer updateCase(Caso caso) {
		CaseVO casoVO = new CaseVO();
		casoVO = caseDao.readCaseBySfid(caso.getSfid());
		
		casoVO.setDescription(caso.getDescription());
		Integer id = caseDao.updateCase(casoVO);
		return id;
	}
	
	/**
	 * Metodo que actualiza la BBDD Casos registrando un caso como cancelado
	 * 
	 * Si subestado es VERIFICADO_OK (si):
	 * 		estado = cerrado (ESTA007) y si es alta, motivo_empresa = fuera_zona_conce (FA003)
	 * Con otro subestado:
	 * 		estado = cancelado (ESTA008) y sies alta, motivo_empresa = null
	 * 
	 * Guardamos como comentario del caso la descripcion del subestado.
	 * 
	 * Nota: Un caso es alta si numeroInservice es null o vacio.
	 * 
	 * @return
	 */
	public boolean cancelarCaso(Caso caso, String userName) {
		
		String subestadoCancelacion = caso.getSubestado();
		boolean esAlta;
		boolean canceladoOk = false;
		String comentarioCaso = userName + ": ";

		CaseCommentVO comentario = new CaseCommentVO();
		CaseVO casoVO = new CaseVO();
		
		//Recuperamos el caso que estamos cancelando
		casoVO = caseDao.readCaseBySfid(caso.getSfid());

		//Modificamos el caso para guardarlo como cancelado y preparamos el comentario
		if(casoVO.getNumeroInservice() == null || "".equals(casoVO.getNumeroInservice())){
			esAlta = true;
		}else{
			esAlta = false;
		}

		if((Constantes.COD_CASO_SUBSTATUS_VERIFICADO_OK.equals(subestadoCancelacion))){
			//Cliente con luz			
			casoVO.setEstado(Constantes.COD_CASO_STATUS_CERRADO);
			
			if(esAlta){
				casoVO.setSubmotivo(Constantes.COD_CASO_SUBMOTIVO_CONS_FUERA_ZONA_CONCE);
			}
			
			comentarioCaso += "Ejecutivo Cancela el caso por "+Constantes.COD_CASO_SUBSTATUS_CLIENTE_LUZ_DESC_COMENTARIO;
			
		}else{
			//cliente si luz
			casoVO.setEstado(Constantes.COD_CASO_STATUS_CANCELADO);
			
			if(esAlta){
				casoVO.setSubmotivo(null);
			}			
			
			if((Constantes.COD_CASO_SUBSTATUS_COMUNICACION_INTERRUMPIDA).equals(subestadoCancelacion)){
				comentarioCaso += "Ejecutivo Cancela el caso por "+Constantes.COD_CASO_SUBSTATUS_COMUNICACION_INTERRUMPIDA_DESC;
			}else if((Constantes.COD_CASO_SUBSTATUS_PRUEBA_ERROR_INGRESO).equals(subestadoCancelacion)){
				comentarioCaso += "Ejecutivo Cancela el caso por "+Constantes.COD_CASO_SUBSTATUS_PRUEBA_ERROR_INGRESO_DESC;				
			}else if((Constantes.COD_CASO_SUBSTATUS_ERROR_INGRESO).equals(subestadoCancelacion)){
				comentarioCaso += "Ejecutivo Cancela el caso por "+Constantes.COD_CASO_SUBSTATUS_ERROR_INGRESO_DESC;				
			}
		}

		casoVO.setSubEstado(subestadoCancelacion);
		casoVO.setCancelar(true);
		
		comentario.setCaseid(caso.getSfid());	
		comentario.setIspublished(false);
		comentario.setComment(comentarioCaso);
		
		casoVO.setDescription(caso.getDescription());
		Integer id = caseDao.updateCase(casoVO);
		Boolean insert = false;
		
		if(id > 0){
			insert = caseCommentDao.insertCaseComment(comentario);
			if(insert){
				canceladoOk = true;
			}
		}
		return canceladoOk;
	}
	
	@Override
	public List<CaseHistory> obtenerListaHistorialDeUnCaso(String caseSfid, Integer numEntradas) {

		List<CaseHistoryVO> listaHistorialCasoVO = caseHistoryDao.readCaseHistoryByCaseId(caseSfid, numEntradas);
		List<CaseHistory> listaHistorialCaso  = parseaYPreparaListaHistorialCasos(listaHistorialCasoVO);
		
		return listaHistorialCaso;
	}
	
	public Integer getNumHistorialDeUnCaso(String sfidCase){
		return caseHistoryDao.countHistoriaDeCaso(sfidCase);
	}
	
	/*
	 * Método que parsea una lista de CaseHistoryVO en CaseHistory.
	 * Ademas prepara la lista con los datos listos para mostrar en pantalla:
	 * 		-- 1.- Si 'oldvalue' y 'newvalue' son sfid (no tiene longitud 18, sin espacios ni puntos), si es un sfid no se añade a la lista que devuelve el metodo
	 * 		-- 2.- Si 'labelFieldPickList' no es vacio y termina en punto, guardamos este valor en el campo 'field' y vaciamos el valor de 'labelFieldPickList' (en pantalla tendrá que mostrarse este valor)
	 * 		-- 3.- Si 'labelOldValuePickList' y 'labelNewValuePickList' estan vacios, se almacena el valor de 'oldvalue' y 'newvalue'
	 * 		-- 4.- Si hay varios registros con la misma Fecha, hora y minutos borramos los datos de 'createdate', 'createdbyid' y 'userJoi'n de todos, 
	 * 				excepto el 1º registros
	 * */
	private List<CaseHistory> parseaYPreparaListaHistorialCasos(List<CaseHistoryVO> listaCaseHistoryVO) {
		if(listaCaseHistoryVO!=null && !listaCaseHistoryVO.isEmpty()){
			List<CaseHistory> retorno = new ArrayList<CaseHistory>();

			//def variables auxiliares para las comprobaciones del punto 2
			SimpleDateFormat  dateFormat  = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date fechaModif = null; //guardar 'createddate' que utilizamos para comparar con la iteracion (usaremos formato 'dateFormat')
			Date fechaIteracion; //guardar 'createddate' de cada iteracion
			
			
			for(CaseHistoryVO historiaCasoVO: listaCaseHistoryVO){
				CaseHistory casoRelacionado = new CaseHistory();
				ParserModelVO.parseDataModelVO(historiaCasoVO, casoRelacionado);
	
				//Comrobacion punto 1
				//Comprobamos si 'oldvalue' tiene un sfid
				String value = casoRelacionado.getOldvalue();
				if(value != null && !"".equals(value)){
					//comprobamos 'oldvalue' que no sea sfid, es decir, si tiene 18 caracteres y no contiene espacios ni puntos
					if(value.length()==18 && value.indexOf(" ") == -1 && value.indexOf(".") == -1){
						//pasamos a la siguiente iteracion del for
						continue;						
					}					
				}
				//Repetimos la comprobacion con 'newvalue'
				value = casoRelacionado.getNewvalue();
				if(value != null && !"".equals(value)){
					//comprobamos 'oldvalue' que no sea sfid, es decir, si tiene 18 caracteres y no contiene espacios ni puntos
					if(value.length()==18 && value.indexOf(" ") == -1 && value.indexOf(".") == -1){
						//pasamos a la siguiente iteracion del for
						continue;						
					}					
				}
				
				//Comprobacion punto 2
				//'labelFieldPickList' no es vacio y termina en punto, guardamos este valor en el campo 'field' y vaciamos el valor de 'labelFieldPickList'
				value = casoRelacionado.getLabelFieldPickList();
				if(value != null && value != ""){
					String lastCharValue = value.substring(value.length()-1);
					if(!".".equals(lastCharValue)){
						casoRelacionado.setField(value);
						casoRelacionado.setLabelFieldPickList(null);
					}
				}
				
				//Comprobacion punto 3		
				//'labelOldValuePickList' y 'labelNewValuePickList' no tienen valor, almacenamos oldvalue y newvalue en los campos.
				String oldValuePickList = casoRelacionado.getLabelOldValuePickList();
				if(oldValuePickList == null ||  "".equals(oldValuePickList)){
					if(casoRelacionado.getOldvalue() != null){						
						casoRelacionado.setLabelOldValuePickList(casoRelacionado.getOldvalue());
					}else{
						casoRelacionado.setLabelOldValuePickList("");
					}
				}
				
				String newValuePickList = casoRelacionado.getLabelNewValuePickList();
				if(newValuePickList == null ||  "".equals(newValuePickList)){
					if(casoRelacionado.getNewvalue() != null){
						casoRelacionado.setLabelNewValuePickList(casoRelacionado.getNewvalue());
					}else{
						casoRelacionado.setLabelNewValuePickList("");
					}
				}
				
				//Comprobacion punto 4		
				try {
					fechaIteracion = dateFormat.parse(casoRelacionado.getCreateddate().toString());
				
					if(fechaModif != null && fechaModif.equals(fechaIteracion)){
						casoRelacionado.setCreateddate(null);
						casoRelacionado.setCreatedbyid(null);
						casoRelacionado.setUserJoin(new User());
					}else{
						fechaModif = dateFormat.parse(casoRelacionado.getCreateddate().toString());
					}
				} catch (ParseException e) {
					logger.error("--- parseaYPreparaListaHistorialCasos -- error al parsear una fecha ---");
					logger.error(e.getMessage());					
				}
				
				
				retorno.add(casoRelacionado);
			}
			return retorno;
		}
		return null;
	}
	
	/*
	 * Método que parsea una lista de CaseHistoryVO en CaseComment.
	 * Ademas si 'createdate' coincide con 'lastmodifieddate', elimina el valor de 'lastmodifieddate' y 'lastmodifiedbyid', ya que el comentario no ha sido modificado
	 * */
	private List<CaseComment> parseaYPreparaListaComentariosCasos(List<CaseCommentVO> listaCaseCommentVO) {
		if(listaCaseCommentVO!=null && !listaCaseCommentVO.isEmpty()){
			
			List<CaseComment> retorno = new ArrayList<CaseComment>();
			
			SimpleDateFormat  dateFormat  = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//Definimos el formato para comparar 'createdate' con 'lastmodifieddate'
			
			for(CaseCommentVO comentarioCasoVO: listaCaseCommentVO){
				CaseComment casoRelacionado = new CaseComment();
				ParserModelVO.parseDataModelVO(comentarioCasoVO, casoRelacionado);
				
				try {
					
					Date fechaCreate = null;
					Date fechaModif = null;					
					if(casoRelacionado.getCreateddate() != null){
						fechaModif = dateFormat.parse(casoRelacionado.getCreateddate().toString());
					}
					if(casoRelacionado.getLastmodifieddate() != null){
						fechaCreate = dateFormat.parse(casoRelacionado.getLastmodifieddate().toString());
					}
				
					if(fechaCreate != null && fechaModif != null && fechaCreate.equals(fechaModif)){
						//El comentario ha sido insertado, no ha sido modificado
						casoRelacionado.setLastmodifieddate(null);
						casoRelacionado.setLastmodifiedbyid(null);
					}
				} catch (ParseException e) {
					logger.error("--- parseaYPreparaListaComentariosCasos -- error al parsear una fecha ---");
					logger.error(e.getMessage());					
				}
				
				retorno.add(casoRelacionado);
			}
			return retorno;
		}
		return null;
	}
}
