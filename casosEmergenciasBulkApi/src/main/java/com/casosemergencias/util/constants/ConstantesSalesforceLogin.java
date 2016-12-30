package com.casosemergencias.util.constants;

public class ConstantesSalesforceLogin {
	/** Constantes para el login contra el entorno de desarrollo de SalesForce. */
	public static final String DEV_LOGIN_SALESFORCE_USER_NAME_KEY = "username";
	public static final String DEV_LOGIN_SALESFORCE_USER_PASS_KEY = "password";
	public static final String DEV_LOGIN_SALESFORCE_GRANT_TYPE_KEY = "grant_type";
	public static final String DEV_LOGIN_SALESFORCE_CLIENT_ID_KEY = "client_id";
	public static final String DEV_LOGIN_SALESFORCE_CLIENT_SECRET_KEY = "client_secret";
	public static final String DEV_LOGIN_SALESFORCE_REDIRECT_URI_KEY = "redirect_uri";
	public static final String DEV_LOGIN_SALESFORCE_ACCESS_TOKEN_KEY = "access_token";
	public static final String DEV_LOGIN_SALESFORCE_INSTANCE_URL_KEY = "instance_url";
	public static final Integer DEV_LOGIN_SALESFORCE_TOKEN_CADUCATION_HOUR= 12;
	
	public static final String DEV_LOGIN_SALESFORCE_LOGIN_URI = "https://test.salesforce.com";
	public static final String DEV_LOGIN_SALESFORCE_REDIRECT_URI = "https://localhost:8443/_callback";
	public static final String DEV_LOGIN_SALESFORCE_TOKEN_PATH_URI = "/services/oauth2/token";
	public static final String DEV_LOGIN_SALESFORCE_INSTANCE_URL = "https://cs52.salesforce.com";
	public static final String DEV_LOGIN_SALESFORCE_REST_SERVICE_NEW_CASE_PATH_URI = "/services/apexrest/CreateHerokuCase";
	public static final String DEV_LOGIN_SALESFORCE_REST_SERVICE_SEARCH_DIRECTION_PATH_URI= "/services/apexrest/SearchHerokuAddress";
	
	public static final String DEV_LOGIN_SALESFORCE_GRANT_TYPE_VALUE = "password";
	public static final String DEV_LOGIN_SALESFORCE_CLIENT_ID_VALUE = "3MVG9jfQT7vUue.G57q9YxkeioLB1AE02bGctQ09wjCAcxfXK1OFwgt1YXFGm8HdTaXvIRCmF1pG259r4SsTz";
	public static final String DEV_LOGIN_SALESFORCE_CLIENT_SECRET_VALUE = "4907478524393614560";
	
	public static final String DEV_REST_SALESFORCE_AUTHORIZATION_HEADER_KEY = "Authorization";
	public static final String DEV_REST_SALESFORCE_CONTENT_TYPE_HEADER_KEY = "Content-Type";
	public static final String DEV_REST_SALESFORCE_ACCEPT_HEADER_KEY = "Accept";
	
	public static final String DEV_REST_SALESFORCE_JSON_CONTENT_TYPE = "application/json";
	
	
}