package com.casosemergencias.logic.sf.rest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.logic.sf.bean.RelacionActivoContactoSalesforce;
import com.casosemergencias.logic.sf.response.CreateRelacionActivoContactoResponse;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.constants.ConstantesError;
import com.casosemergencias.util.constants.ConstantesSalesforceLogin;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateRelacionActivoContacto {
	final static Logger logger = Logger.getLogger(CreateCase.class);
	
		public static CreateRelacionActivoContactoResponse createCreateRelacionActivoContactoInSalesforce(UserSessionInfo userSessionInfo, String suministroSfid,String contactoSfid) throws EmergenciasException {
			CreateRelacionActivoContactoResponse createRelacionActivoContactoResponse= null;
			HttpClient httpClient = null;
			HttpPost post = null;
			ObjectMapper mapper = new ObjectMapper();			
			try {
				if (userSessionInfo.getSessionId() != null) {
				logger.trace("Inicio buscar direccion");
				httpClient = HttpClientBuilder.create().build();
				post = new HttpPost(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_INSTANCE_URL + ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_REST_SERVICE_NEW_SERVICE_PRODUCT_PATH_URI);
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_AUTHORIZATION_HEADER_KEY, "Bearer " + userSessionInfo.getSessionId());
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_CONTENT_TYPE_HEADER_KEY, ConstantesSalesforceLogin.DEV_REST_SALESFORCE_JSON_CONTENT_TYPE);
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_ACCEPT_HEADER_KEY, ConstantesSalesforceLogin.DEV_REST_SALESFORCE_JSON_CONTENT_TYPE);
				
				RelacionActivoContactoSalesforce relacionActivoContactoSalesforce = RelacionActivoContactoSalesforce.copyFieldsFromHerokuToSalesForceRelacionActivoContacto(suministroSfid,contactoSfid);
				String jsonInString = mapper.writeValueAsString(relacionActivoContactoSalesforce);
				logger.info("Parseo JSON direccion: " + jsonInString);

				StringEntity params = new StringEntity(jsonInString, "UTF-8");
				post.setEntity(params);
				
				logger.info("Intento de llamada POST buscarDireccion");
				
				HttpResponse response = httpClient.execute(post);
				HttpEntity entity = response.getEntity();
				String entityResponse = EntityUtils.toString(entity);
				
				logger.info("Respuesta: " + entityResponse);
				logger.info("Status: " + response.getStatusLine());
				
				createRelacionActivoContactoResponse =mapper.readValue(entityResponse, CreateRelacionActivoContactoResponse.class);
				if (createRelacionActivoContactoResponse != null && !"0".equals(createRelacionActivoContactoResponse.getControlErrores().getCodigoError())) {
					logger.error("Codigo: " + createRelacionActivoContactoResponse.getControlErrores().getCodigoError() + ". Mensaje: " + createRelacionActivoContactoResponse.getControlErrores().getMensajeError());
					throw new EmergenciasException(createRelacionActivoContactoResponse.getControlErrores().getCodigoError(), createRelacionActivoContactoResponse.getControlErrores().getMensajeError());
				}
			} else {
				logger.error(ConstantesError.SALESFORCE__SEARCH_REL_ACTIVO_CONTACTO_ERROR + ". El sessionId es nulo.");
				throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_006, ConstantesError.SALESFORCE__SEARCH_CASE_COMMENT_ERROR);
			}
		} catch(IOException exception) {//Cambiar por IOException
				logger.error(ConstantesError.SALESFORCE__SEARCH_REL_ACTIVO_CONTACTO_ERROR, exception);
				throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_006, ConstantesError.SALESFORCE__SEARCH_REL_ACTIVO_CONTACTO_ERROR);
			} finally {
				if (post != null) {
					post.releaseConnection();
				}
			}
			return createRelacionActivoContactoResponse;
		}
						
}


