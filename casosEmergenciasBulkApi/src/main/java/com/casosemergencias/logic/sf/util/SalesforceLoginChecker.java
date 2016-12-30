package com.casosemergencias.logic.sf.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.logic.UserSessionInfoService;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.constants.ConstantesError;
import com.casosemergencias.util.constants.ConstantesSalesforceLogin;
import com.force.api.ApiSession;
import com.force.api.ForceApi;

@Resource
public class SalesforceLoginChecker {
	final static Logger logger = Logger.getLogger(SalesforceLoginChecker.class);

	@Autowired
	private UserSessionInfoService userSessionInfoService;
	
	/**
	 * M&eacute;todo que obtiene la información de sesión de un usuario.
	 * 
	 * @param username
	 *            Nombre del usuario.
	 * @param password
	 *            Contrase&ntilde;a del usuario.
	 * @param token
	 *            Token de conexi&oacute;n del usuario.
	 * @return UserSessionInfo Datos de la sesi&oacute;n del usuario.
	 */
	public UserSessionInfo getUserSessionInfo (UserSessionInfo userSessionInfoToLogin) throws EmergenciasException {
		logger.trace("Entrando en getUserSessionInfo() para obtener los datos de sesión del usuario");
		
		UserSessionInfo userSessionInfoFromDB = null;
		try {
			// Se comprueba que el usuario exista en BBDD.
			userSessionInfoFromDB = userSessionInfoService.readUserSessionInfo(userSessionInfoToLogin);
			if (userSessionInfoFromDB != null) {
				// Si el usuario existe pero no tiene SessionId guardado, se hace login para rellenarlo
				if (userSessionInfoFromDB.getSessionId() == null || "".equals(userSessionInfoFromDB.getSessionId())) {
					logger.info("El sessionId del usuario no es válido. Se procede a hacer login y actualizar los datos de sesion del usuario");
					salesforceLogin(userSessionInfoFromDB);
					userSessionInfoService.updateUserSessionInfo(userSessionInfoFromDB);
				} else if (!isValidToken(userSessionInfoFromDB.getLastConnection())) {
					// Si el usuario existe, se comprueba si la fecha de conexión es mayor o menor de 12 horas.
					// Si la fecha es mayor de 12 horas, se hace login, y se actualiza la información en BBDD antes de devolver los datos del usuario.
					logger.info("El token no es válido. Se procede a hacer login y actualizar los datos de sesion del usuario");
					salesforceLogin(userSessionInfoFromDB);
					userSessionInfoService.updateUserSessionInfo(userSessionInfoFromDB);
				}
				logger.info("El usuario es válido. No es necesario actualizar los datos del usuario");
			} else {
				// Si el usuario no existe, se hace login, se guardan en BBDD y se devuelven los datos del usuario.
				logger.info("El usuario no existe o su sessionId es nulo. Se procede a hacer login y guardar los datos de sesion del usuario");
				salesforceLogin(userSessionInfoFromDB);
				userSessionInfoService.insertUserSessionInfo(userSessionInfoFromDB);
			}
		} catch (JSONException|IOException exception) {
			logger.error(ConstantesError.SALESFORCE_LOGIN_ERROR, exception);
			throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_001, ConstantesError.SALESFORCE_LOGIN_ERROR);
		}
		
		logger.trace("Saliendo de getUserSessionInfo()");
		return userSessionInfoFromDB;
	}	
	
	/**
	 * M&eatuce;todo que realiza el login contra SalesForce.
	 * 
	 * @param userSessionInfo
	 *            Informaci&oacute;n del usuario con el que hacer el login.
	 * 
	 */
	public void salesforceLogin(UserSessionInfo userSessionInfo) throws JSONException, HttpException, IOException {
		logger.trace("Entrando a salesforceLogin() para hacer el login contra SalesForce");
		
		String tokenRequestUri = ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_LOGIN_URI + ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_TOKEN_PATH_URI; 
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(tokenRequestUri);
		
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_GRANT_TYPE_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_GRANT_TYPE_VALUE);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_ID_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_ID_VALUE);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_SECRET_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_SECRET_VALUE);
		//post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_REDIRECT_URI_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_REDIRECT_URI);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_USER_NAME_KEY, userSessionInfo.getUsername());
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_USER_PASS_KEY, userSessionInfo.getPassword() + userSessionInfo.getAccessToken());
		
		logger.info("Intento de llamada POST al servicio " + tokenRequestUri + " para obtener el sessionId del usuario");
		logger.info("Petición: " + post.getRequestEntity());
			
		httpclient.executeMethod(post);
		
		InputStreamReader inputStreamReader = new InputStreamReader(post.getResponseBodyAsStream());
		JSONTokener jsonTokener = new JSONTokener(inputStreamReader);
		JSONObject authResponse = new JSONObject(jsonTokener);

		logger.info("Respuesta: " + authResponse.toString(2));

		Date currentDate = new Date();
		userSessionInfo.setSessionId(authResponse.getString(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_ACCESS_TOKEN_KEY));
		userSessionInfo.setLastConnection(currentDate);
		
		logger.info("Id de sesión: " + userSessionInfo.getSessionId());
		logger.info("Hora de conexión: " + userSessionInfo.getLastConnection());
		post.releaseConnection();
	}
	
	
	public ForceApi getSalesforceApi(UserSessionInfo datosSesion) throws JSONException, HttpException, IOException {
		ForceApi api = null;
		logger.trace("Intentamos recuperar los datos o hacemos login.");
		salesforceLogin(datosSesion);
		//UserSessionInfo datosSesion = this.getUserSessionInfo(username, password, token);
		if (datosSesion != null && !StringUtils.isEmpty(datosSesion.getSessionId())){
			logger.trace("Login correcto.");
			ApiSession s = new ApiSession();
			s.setAccessToken(datosSesion.getSessionId());
			s.setApiEndpoint(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_INSTANCE_URL);
			api = new ForceApi(s);
		}
		return api;
	}
	
	/**
	 * M&eacute;todo que comprueba si la &uacute;ltima fecha de conexi&oacute;n
	 * del usuario es anterior al tiempo de caducidad del token en SalesForce.
	 * 
	 * @param lastConnectionDate
	 *            Fecha de &uacute;ltima conexi&oacute;n del usuario.
	 * @return boolean Se devolv&aacute; un valor <i>true</i> si el token es
	 *         v&aacutelido todav&iacute;a y un valor <i>false</i> si ha
	 *         caducado.
	 */
	private boolean isValidToken(Date lastConnectionDate) {
		logger.trace("Entrando en isValidToken() para comprobar el tiempo que ha pasado desde la última conexión");
		
		boolean isValidToken = false;
		Date currentDate = new Date();
		
		logger.info("Fecha de última conexión: " + lastConnectionDate);
		logger.info("Fecha actual: " + currentDate);
				
		long duration  = currentDate.getTime() - lastConnectionDate.getTime();
		long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);

		logger.info("Diferencia en horas: " + diffInHours);
		
		if (diffInHours < ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_TOKEN_CADUCATION_HOUR) {
			isValidToken = true;
		}
		
		logger.trace("Saliendo de isValidToken()");
		
		return isValidToken;
	}
}