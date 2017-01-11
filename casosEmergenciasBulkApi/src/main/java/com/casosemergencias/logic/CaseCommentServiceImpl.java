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
import com.casosemergencias.dao.vo.CaseCommentVO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.logic.sf.response.CreateCaseCommentResponse;
import com.casosemergencias.logic.sf.rest.CreateCaseComment;
import com.casosemergencias.logic.sf.util.SalesforceLoginChecker;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.ConstantesError;

public class CaseCommentServiceImpl implements CaseCommentService{

	final static Logger logger = Logger.getLogger(CaseCommentService.class);
	
	@Autowired
	public CaseCommentDAO caseCommentDAO;
	
	@Autowired CaseDAO caseDAO;
	
	@Autowired
	private SalesforceLoginChecker salesforceLoginChecker;
	
	@Override
	public List<CaseComment> obtenerListaComentariosDeUnCaso(String caseSfid) {
		
		List<CaseCommentVO> listaComentariosVO = caseCommentDAO.readCaseCommentByCaseId(caseSfid);
		List<CaseComment> listaComentarios = parseaYPreparaListaComentariosCasos(listaComentariosVO);
		
		return listaComentarios;
	}

	@Override
	public Caso obtenerDatosCasoParaComentario(String caseSfid) {
		CaseVO caseVO = caseDAO.readCaseForCommentByCaseid(caseSfid);
		Caso casoRetorno = new Caso();
		ParserModelVO.parseDataModelVO(caseVO, casoRetorno);
		
		return casoRetorno;
	}
	
	/*@Override
	public Boolean insertCaseComment(CaseComment caseComment) {
		CaseCommentVO caseCommentVO = new CaseCommentVO();
		
		caseCommentVO.setComment(caseComment.getComment());
		caseCommentVO.setIspublished(false);
		caseCommentVO.setCaseid(caseComment.getCaseid());
		Boolean insert = caseCommentDAO.insertCaseComment(caseCommentVO);
		return insert;
	}*/
	
	
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
	
	
	
	
	
	@Override
	public CaseComment insertSalesforceCaseComment(CaseComment comentarioCaso)throws EmergenciasException {
		
		logger.trace("--- Servicio insertSalesforceComment iniciado ---");
		// 1. Leer usuario de fichero de propiedades
		Properties properties = new Properties();
		String username = null;
		String password = null;
		String token = null;
		UserSessionInfo userSessionInfoFromDB = null;
		CreateCaseCommentResponse respuestaComentarioCaso = null;
		CaseCommentVO caseCommentVO = null;
		

		try (InputStream propsInputStream = getClass().getClassLoader().getResourceAsStream("/environment/dev/config.properties")) {
			properties.load(propsInputStream);
			username = properties.getProperty("heroku.user");
			password = properties.getProperty("heroku.pass");
			token = properties.getProperty("heroku.token");
			
			if (username != null && !"".equals(username) && password != null && !"".equals(password) && token != null && !"".equals(token)) {
				UserSessionInfo sessionInfoToLogin = new UserSessionInfo();
				sessionInfoToLogin.setUsername(properties.getProperty("heroku.user"));
				sessionInfoToLogin.setPassword(properties.getProperty("heroku.pass"));
				sessionInfoToLogin.setAccessToken(properties.getProperty("heroku.token"));
				userSessionInfoFromDB = salesforceLoginChecker.getUserSessionInfo(sessionInfoToLogin);
				if (userSessionInfoFromDB != null) {
					respuestaComentarioCaso = CreateCaseComment.createCaseCommentInSalesforce(userSessionInfoFromDB, comentarioCaso);
					if (respuestaComentarioCaso != null) {
						if (respuestaComentarioCaso.getIdComentarioCaso() != null && !"".equals(respuestaComentarioCaso.getIdComentarioCaso())) {
							comentarioCaso.setSfid(respuestaComentarioCaso.getIdComentarioCaso());
							logger.info("Comentario de caso creado con sfid:" + respuestaComentarioCaso.getIdComentarioCaso());
						}
						if (respuestaComentarioCaso.getIdComentarioCaso() != null && !"".equals(respuestaComentarioCaso.getIdComentarioCaso())) {
							comentarioCaso.setSfid(respuestaComentarioCaso.getIdComentarioCaso());
							logger.info("Comentario de caso creado con sfid:" + respuestaComentarioCaso.getIdComentarioCaso());
						}
						if (respuestaComentarioCaso.getCreatedDate() != null && !"".equals(respuestaComentarioCaso.getCreatedDate())) {
							comentarioCaso.setCreateddate(respuestaComentarioCaso.getCreatedDate());
							logger.info("Comentario de caso creado con CreatedDate:" + respuestaComentarioCaso.getCreatedDate());
						}
												
						caseCommentVO = new CaseCommentVO();
						ParserModelVO.parseDataModelVO(comentarioCaso, caseCommentVO);
						Boolean caseBoolean = caseCommentDAO.insertCaseComment(caseCommentVO);
						if (caseBoolean != null && caseBoolean!=false) {
							logger.info("Comentario insertado correctamente en Heroku");
						} else {
							comentarioCaso = null;
							logger.error("No se ha podido insertar el comentario en Heroku. Ha fallado la inserción en base de datos");
							throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_003, ConstantesError.HEROKU_CASECOMMENT_CCREATION_OK_WITH_ERROR);
						}
					} else {
						comentarioCaso = null;
						logger.warn("Se ha producido un error al insertar el comentario en SalesForce");
						throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_002, ConstantesError.SALESFORCE_CASE_COMMENT_CREATION_ERROR);
					}
				}
			}
		} catch (IOException exception) {
			logger.error("Error obteniendo los datos del usuario: ", exception);
			throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_006, ConstantesError.SALESFORCE__SEARCH_COMMENT_CASE_ERROR);
		}
		logger.trace("--- Servicio insertSalesforceComment completado ---");
		return comentarioCaso;
	}


}
