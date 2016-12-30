package com.casosemergencias.util.constants;

public class ConstantesHeroku {

	
	/**Contantes del campo _hc_lastop de las tablas de BBDD que indican la sincronización con los objetos de Salesforce*/
	//PENDING - A new row in the database is awaiting sync to Salesforce
	public static final String HEROKU_SYNC_PENDING = "PENDING";
	
	//INSERTED - A new row in the database has been inserted into Salesforce: at this point the sfid will also be populated
	public static final String HEROKU_SYNC_INSERTED = "INSERTED";
	
	//UPDATED - An existing row in the database has been successfully updated in Salesforce
	public static final String HEROKU_SYNC_UPDATED = "UPDATED";
	
	//SYNCED - A new row has been synchronized FROM Salesforce
	public static final String HEROKU_SYNC_SYNCED = "SYNCED";
	
	//FAILED - Salesforce synchronization was unsuccessful
	public static final String HEROKU_SYNC_FAILED = "FAILED";
	
}
