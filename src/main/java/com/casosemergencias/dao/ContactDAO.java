package com.casosemergencias.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.dao.vo.ContactVO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.util.constants.ConstantesBatch;

@Repository
public class ContactDAO {

	final static Logger logger = Logger.getLogger(ContactDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HistoricBatchDAO historicBatchDAO;
	
	/**
	 * Inserta un listado de Contactos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int insertContactListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- insert Listado Contactos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoInsertRecord = null;
		ContactVO contactoToInsert = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {
			historicoInsertRecord = new HistoricBatchVO();
			historicoInsertRecord.setStartDate(new Date());
			historicoInsertRecord.setOperation(ConstantesBatch.INSERT_RECORD);
			historicoInsertRecord.setObject(ConstantesBatch.OBJECT_CONTACT);
			historicoInsertRecord.setProcessId(processId);
			contactoToInsert = new ContactVO();
			
			try {
				contactoToInsert = (ContactVO) object;
				historicoInsertRecord.setSfidRecord(contactoToInsert.getSfid());
				session.save(contactoToInsert);
			
				logger.debug("--- Fin -- insertContacto ---" + contactoToInsert.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en insertContacto: ---" + contactoToInsert.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_INSERT_RECORD;
			}
			
			historicoInsertRecord.setSuccess(processOk);
			historicoInsertRecord.setEndDate(new Date());
			historicoInsertRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoInsertRecord);
		}
		logger.debug("--- Fin -- insert Listado Contactos ---");
		session.close();
		return processedRecords;
	}

	/**
	 * Actualiza un listado de contactos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int updateContactListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- update Listado Contactos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoUpdateRecord = null;
		ContactVO contactoToUpdate = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
				
		for (Object object : objectList) {
			historicoUpdateRecord = new HistoricBatchVO();
			historicoUpdateRecord.setStartDate(new Date());
			historicoUpdateRecord.setOperation(ConstantesBatch.UPDATE_RECORD);
			historicoUpdateRecord.setObject(ConstantesBatch.OBJECT_CONTACT);
			historicoUpdateRecord.setProcessId(processId);
			contactoToUpdate = new ContactVO();
			
			try {
				contactoToUpdate = (ContactVO) object;
				historicoUpdateRecord.setSfidRecord(contactoToUpdate.getSfid());
		
				//1.2-Construimos la query							
				Query sqlUpdateQuery =session.createQuery("UPDATE ContactVO "
													   + "	  SET name = :name"
													   //+ "		, birthdate = :birthdate"
													   + "		, preferredchannelcontact__c = :preferredchannelcontact__c"
													   + "		, associatedaccounttype__c = :associatedaccounttype__c"
													   + "		, motherslastname__c = :motherslastname__c"
													   + "		, identitytype__c = :identitytype__c"
													   + "		, secondaryphone__c = :secondaryphone__c"
													   + "		, secondaryemail__c = :secondaryemail__c"
													   + "		, sf4twitter__fcbk_username__c = :sf4twitter__fcbk_username__c"
													   + "		, repeatedcases__c = :repeatedcases__c"
													   + "		, email = :email"
													   + "		, identitynumber__c = :identitynumber__c"
													   + "		, concatenatecontacaddress__c = :concatenatecontacaddress__c"
													   + "		, sf4twitter__twitter_user_id__c = :sf4twitter__twitter_user_id__c"
													   + "		, sf4twitter__fcbk_user_id__c = :sf4twitter__fcbk_user_id__c"		
													   + "		, sf4twitter__twitter_username__c = :sf4twitter__twitter_username__c"
													   + "		, contacttype__c = :contacttype__c"
													   + "		, phone = :phone"
													   + "		, fatherslastname__c = :fatherslastname__c"
													   + "		, sf4twitter__influencer__c = :sf4twitter__influencer__c"
													   + "		, sf4twitter__twitter_bio__c = :sf4twitter__twitter_bio__c"
													   + "		, sf4twitter__influencer_type__c = :sf4twitter__influencer_type__c"
													   + (contactoToUpdate.getSeguidoresTwitter() != null ? "		, sf4twitter__twitter_follower_count__c = :sf4twitter__twitter_follower_count__c" : "")
													   + "		, accountid = :accountid"
													   + "		, firstname = :firstname"
													   + "		, contactaddress__c = :contactaddress__c"
													   + "  WHERE sfid = :sfidFiltro");
				
				//1.3.1-Seteamos el campos que no filtren la query						
				sqlUpdateQuery.setString("name", contactoToUpdate.getName());
				//sqlUpdateQuery.setTimestamp("birthdate", contactoToUpdate.getFechaNacimiento());
				sqlUpdateQuery.setString("preferredchannelcontact__c", contactoToUpdate.getCanalPreferenteContacto());
				sqlUpdateQuery.setString("associatedaccounttype__c", contactoToUpdate.getTipoCuentaAsociado());
				sqlUpdateQuery.setString("motherslastname__c", contactoToUpdate.getApellidoMaterno());
				sqlUpdateQuery.setString("identitytype__c", contactoToUpdate.getTipoIdentidad());
				sqlUpdateQuery.setString("secondaryphone__c", contactoToUpdate.getTelefonoSecundario());
				sqlUpdateQuery.setString("secondaryemail__c", contactoToUpdate.getEmailSecundario());
				sqlUpdateQuery.setString("sf4twitter__fcbk_username__c", contactoToUpdate.getSf4twitterFcbkUsername());
				sqlUpdateQuery.setBoolean("repeatedcases__c", contactoToUpdate.getCasosReiterados());
				sqlUpdateQuery.setString("email", contactoToUpdate.getEmail());
				sqlUpdateQuery.setString("identitynumber__c", contactoToUpdate.getRun());
				sqlUpdateQuery.setString("concatenatecontacaddress__c", contactoToUpdate.getDirContacto());
				sqlUpdateQuery.setString("sf4twitter__twitter_user_id__c", contactoToUpdate.getSf4twitterTwitterUserId());
				sqlUpdateQuery.setString("sf4twitter__fcbk_user_id__c", contactoToUpdate.getSf4twitterFcbkUserId());
				sqlUpdateQuery.setString("sf4twitter__twitter_username__c", contactoToUpdate.getSf4twitterTwitterUsername());
				sqlUpdateQuery.setString("contacttype__c", contactoToUpdate.getTipoContacto());
				sqlUpdateQuery.setString("phone", contactoToUpdate.getPhone());
				sqlUpdateQuery.setString("fatherslastname__c", contactoToUpdate.getApellidoPaterno());
				sqlUpdateQuery.setString("sf4twitter__influencer__c", contactoToUpdate.getInfluencer());
				sqlUpdateQuery.setString("sf4twitter__twitter_bio__c", contactoToUpdate.getTwitterBio());
				sqlUpdateQuery.setString("sf4twitter__influencer_type__c", contactoToUpdate.getInfluencerType());
				if (contactoToUpdate.getSeguidoresTwitter() != null) {
					sqlUpdateQuery.setDouble("sf4twitter__twitter_follower_count__c", contactoToUpdate.getSeguidoresTwitter());
				}
				sqlUpdateQuery.setString("accountid", contactoToUpdate.getAccountid());
				sqlUpdateQuery.setString("firstname", contactoToUpdate.getFirstname());
				sqlUpdateQuery.setString("contactaddress__c", contactoToUpdate.getIdDirContacto());
				sqlUpdateQuery.setString("sfidFiltro", contactoToUpdate.getSfid());
				
				//1.3-Ejecutamos la actualizacion
				sqlUpdateQuery.executeUpdate();
				logger.debug("--- Fin -- updateContacto ---" + contactoToUpdate.getSfid());
				
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en updateContacto: ---" + contactoToUpdate.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_UPDATE_RECORD;
			} 

			historicoUpdateRecord.setSuccess(processOk);
			historicoUpdateRecord.setEndDate(new Date());
			historicoUpdateRecord.setErrorCause(processErrorCause);
			historicBatchDAO.insertHistoric(historicoUpdateRecord);
		}
		logger.debug("--- Fin -- update Listado Contactos ---");
		session.close();
		return processedRecords;
	}
		
	/**
	 * Borra un listado de contactos venidos de Salesforce en BBDD de Heroku.
	 * 
	 * @param List<Object>
	 * @return
	 */
	@Transactional
	public int deleteContactListSf(List<Object> objectList, String processId) {
		logger.debug("--- Inicio -- delete Listado Contactos ---");
		int processedRecords = 0;
		boolean processOk = false;
		String processErrorCause = null;
		HistoricBatchVO historicoDeleteRecord = null;
		ContactVO contactoToDelete = null;
		
		//Se crea la sesión y se inica la transaccion
		Session session = sessionFactory.openSession();
		
		for (Object object : objectList) {historicoDeleteRecord = new HistoricBatchVO();
			historicoDeleteRecord.setStartDate(new Date());
			historicoDeleteRecord.setOperation(ConstantesBatch.DELETE_RECORD);
			historicoDeleteRecord.setObject(ConstantesBatch.OBJECT_CONTACT);
			historicoDeleteRecord.setProcessId(processId);
			contactoToDelete = new ContactVO();
			
			try {
				contactoToDelete = (ContactVO) object;
				historicoDeleteRecord.setSfidRecord(contactoToDelete.getSfid());
				Query sqlDeleteQuery = session.createQuery("DELETE ContactVO  WHERE sfid = :sfidFiltro");
				//Seteamos el campo por el que filtramos el borrado			
				sqlDeleteQuery.setString("sfidFiltro", contactoToDelete.getSfid());				
				//Ejecutamos la actualizacion				
				sqlDeleteQuery.executeUpdate();
				
				logger.debug("--- Fin -- deleteContacto ---" + contactoToDelete.getSfid());
				processOk = true;
				processedRecords++;
			} catch (HibernateException e) {
				logger.error("--- Error en deleteContacto: ---" + contactoToDelete.getSfid(), e);
				processOk = false;
				processErrorCause = ConstantesBatch.ERROR_DELETE_RECORD;
			} 

			historicoDeleteRecord.setSuccess(processOk);
			historicoDeleteRecord.setErrorCause(processErrorCause);
			historicoDeleteRecord.setEndDate(new Date());
			historicBatchDAO.insertHistoric(historicoDeleteRecord);
		}
		logger.debug("--- Fin -- delete Listado Contactos ---");
		session.close();
		return processedRecords;
	}
}