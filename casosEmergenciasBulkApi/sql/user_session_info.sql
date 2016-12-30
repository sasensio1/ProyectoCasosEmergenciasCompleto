CREATE TABLE user_session_info (
		id 					SERIAL			NOT NULL,	
		username 			VARCHAR(255)	NOT NULL,
		password			VARCHAR(255)	NOT NULL,
		access_token		VARCHAR(255)	NOT NULL,
		session_id			VARCHAR(255)	NULL,
		last_connection	TIMESTAMP	   NULL		DEFAULT CURRENT_TIMESTAMP,
		CONSTRAINT pk_session_control_id PRIMARY KEY(id)
);

-- Usuario desarrollo Antigua Org
INSERT INTO salesforce.user_session_info (username, password, access_token) 
	 VALUES ('herokuintegracion@enel.dev', 'heroku123', 'gNjrVGPboZO0WvrSE8P8axaa');
	 
-- Usuario desarrollo Nueva Org
INSERT INTO salesforce.user_session_info (username, password, access_token) 
	 VALUES ('herokuintegracion@enellatam.com.emerchdev', 'Del*Alvaro16', 'ZHmyxlWZa8Hfkjga1jCYiXsA');