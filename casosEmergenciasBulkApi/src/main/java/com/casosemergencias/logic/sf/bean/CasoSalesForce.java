package com.casosemergencias.logic.sf.bean;

import java.util.Date;

import com.casosemergencias.model.Caso;

public class CasoSalesForce {
	
	private String reason;
	private String status;
	private String inserviceNumber__c;
	private String subStatus__c;
	private Date estimatedStandardizationTime__c;
	private String origin;
	private String ownerId;
	private String parentId;
	private String type;
	private String subject;
	private String cause__c;
	private String subCause__c;
	private String description;
	private String aggravatedCondition__c;
	private String contactId;
	private String notificationChannel__c;
	private String pointOfDelivery__c;
	private String contactPhone__c;
	private String address__c;
	private String notificationEmail__c;
	private String accountId;
	private String idFacebook__c;
	private String twitter__c;
	private Boolean updateContact__c;
	private String ani__c;
	private String mailBody__c;
	private String customerResponse__c;
	private String caseFavorability__c;
	private String heroku_User__c;
	private String unity__c;
	//De momento no hace falta para los casos que se crean ahora, pero si se incluyen más creaciones de casos será necesario implementarlo
	//private String recordtypeid;
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInserviceNumber__c() {
		return inserviceNumber__c;
	}

	public void setInserviceNumber__c(String inserviceNumber__c) {
		this.inserviceNumber__c = inserviceNumber__c;
	}

	public String getSubStatus__c() {
		return subStatus__c;
	}

	public void setSubStatus__c(String subStatus__c) {
		this.subStatus__c = subStatus__c;
	}

	public Date getEstimatedStandardizationTime__c() {
		return estimatedStandardizationTime__c;
	}

	public void setEstimatedStandardizationTime__c(Date estimatedStandardizationTime__c) {
		this.estimatedStandardizationTime__c = estimatedStandardizationTime__c;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubCause__c() {
		return subCause__c;
	}

	public void setSubCause__c(String subCause__c) {
		this.subCause__c = subCause__c;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAggravatedCondition__c() {
		return aggravatedCondition__c;
	}

	public void setAggravatedCondition__c(String aggravatedCondition__c) {
		this.aggravatedCondition__c = aggravatedCondition__c;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getNotificationChannel__c() {
		return notificationChannel__c;
	}

	public void setNotificationChannel__c(String notificationChannel__c) {
		this.notificationChannel__c = notificationChannel__c;
	}

	public String getPointOfDelivery__c() {
		return pointOfDelivery__c;
	}

	public void setPointOfDelivery__c(String pointOfDelivery__c) {
		this.pointOfDelivery__c = pointOfDelivery__c;
	}

	public String getContactPhone__c() {
		return contactPhone__c;
	}

	public void setContactPhone__c(String contactPhone__c) {
		this.contactPhone__c = contactPhone__c;
	}

	public String getAddress__c() {
		return address__c;
	}

	public void setAddress__c(String address__c) {
		this.address__c = address__c;
	}

	public String getNotificationEmail__c() {
		return notificationEmail__c;
	}

	public void setNotificationEmail__c(String notificationEmail__c) {
		this.notificationEmail__c = notificationEmail__c;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getIdFacebook__c() {
		return idFacebook__c;
	}

	public void setIdFacebook__c(String idFacebook__c) {
		this.idFacebook__c = idFacebook__c;
	}

	public String getTwitter__c() {
		return twitter__c;
	}

	public void setTwitter__c(String twitter__c) {
		this.twitter__c = twitter__c;
	}

	public Boolean getUpdateContact__c() {
		return updateContact__c;
	}

	public void setUpdateContact__c(Boolean updateContact__c) {
		this.updateContact__c = updateContact__c;
	}

	public String getAni__c() {
		return ani__c;
	}

	public void setAni__c(String ani__c) {
		this.ani__c = ani__c;
	}

	public String getMailBody__c() {
		return mailBody__c;
	}

	public void setMailBody__c(String mailBody__c) {
		this.mailBody__c = mailBody__c;
	}

	public String getCustomerResponse__c() {
		return customerResponse__c;
	}

	public void setCustomerResponse__c(String customerResponse__c) {
		this.customerResponse__c = customerResponse__c;
	}

	public String getCaseFavorability__c() {
		return caseFavorability__c;
	}

	public void setCaseFavorability__c(String caseFavorability__c) {
		this.caseFavorability__c = caseFavorability__c;
	}

	public String getHeroku_User__c() {
		return heroku_User__c;
	}

	public void setHeroku_User__c(String heroku_User__c) {
		this.heroku_User__c = heroku_User__c;
	}

	public String getUnity__c() {
		return unity__c;
	}

	public void setUnity__c(String unity__c) {
		this.unity__c = unity__c;
	}	
	public String getCause__c() {
		return cause__c;
	}

	public void setCause__c(String cause__c) {
		this.cause__c = cause__c;
	}

	
	//De momento no hace falta para los casos que se crean ahora, pero si se incluyen más creaciones de casos será necesario implementarlo
//	public String getRecordtypeid() {
//		return recordtypeid;
//	}
//
//	public void setRecordtypeid(String recordtypeid) {
//		this.recordtypeid = recordtypeid;
//	}


	public static CasoSalesForce copyFieldsFromHerokuToSalesForceCaseBean(Caso casoHeroku) {
		CasoSalesForce casoSF = new CasoSalesForce();
		if (casoHeroku != null) {
			casoSF.setReason((casoHeroku.getPeticion() != null && !"".equals(casoHeroku.getPeticion()) ? casoHeroku.getPeticion() : ""));
			casoSF.setStatus((casoHeroku.getEstado() != null && !"".equals(casoHeroku.getEstado()) ? casoHeroku.getEstado() : ""));
			casoSF.setInserviceNumber__c((casoHeroku.getNumeroInservice() != null && !"".equals(casoHeroku.getNumeroInservice()) ? casoHeroku.getNumeroInservice() : ""));
			casoSF.setSubStatus__c((casoHeroku.getSubestado() != null && !"".equals(casoHeroku.getSubestado()) ? casoHeroku.getSubestado() : ""));
			casoSF.setEstimatedStandardizationTime__c((casoHeroku.getFechaEstimadaCierre() != null ? casoHeroku.getFechaEstimadaCierre() : null));
			casoSF.setOrigin((casoHeroku.getCanalOrigen() != null && !"".equals(casoHeroku.getCanalOrigen()) ? casoHeroku.getCanalOrigen() : ""));
			casoSF.setOwnerId((casoHeroku.getPropietarioCaso() != null && !"".equals(casoHeroku.getPropietarioCaso()) ? casoHeroku.getPropietarioCaso() : ""));
			casoSF.setParentId((casoHeroku.getParent() != null && !"".equals(casoHeroku.getParent()) ? casoHeroku.getParent() : ""));
			casoSF.setType((casoHeroku.getType() != null && !"".equals(casoHeroku.getType()) ? casoHeroku.getType() : ""));
			casoSF.setSubject((casoHeroku.getAsunto() != null && !"".equals(casoHeroku.getAsunto()) ? casoHeroku.getAsunto() : ""));
			casoSF.setSubCause__c((casoHeroku.getSubmotivo() != null && !"".equals(casoHeroku.getSubmotivo()) ? casoHeroku.getSubmotivo() : ""));
			casoSF.setDescription((casoHeroku.getDescription() != null && !"".equals(casoHeroku.getDescription()) ? casoHeroku.getDescription() : ""));
			casoSF.setAggravatedCondition__c((casoHeroku.getCondicionAgravante() != null && !"".equals(casoHeroku.getCondicionAgravante()) ? casoHeroku.getCondicionAgravante() : ""));
			casoSF.setContactId((casoHeroku.getNombreContacto() != null && !"".equals(casoHeroku.getNombreContacto()) ? casoHeroku.getNombreContacto() : ""));
			casoSF.setNotificationChannel__c((casoHeroku.getCanalNotificacion() != null && !"".equals(casoHeroku.getCanalNotificacion()) ? casoHeroku.getCanalNotificacion() : ""));
			casoSF.setPointOfDelivery__c((casoHeroku.getSuministro() != null && !"".equals(casoHeroku.getSuministroJoin()) ? casoHeroku.getSuministro() : ""));
			casoSF.setContactPhone__c((casoHeroku.getTelefonoContacto() != null && !"".equals(casoHeroku.getTelefonoContacto()) ? casoHeroku.getTelefonoContacto() : ""));
			casoSF.setAddress__c((casoHeroku.getDireccion() != null && !"".equals(casoHeroku.getDireccion()) ? casoHeroku.getDireccion() : ""));
			casoSF.setNotificationEmail__c((casoHeroku.getEmailNotificacion() != null && !"".equals(casoHeroku.getEmailNotificacion()) ? casoHeroku.getEmailNotificacion() : ""));
			casoSF.setAccountId((casoHeroku.getNombreCuenta() != null && !"".equals(casoHeroku.getNombreCuenta()) ? casoHeroku.getNombreCuenta() : ""));
			casoSF.setIdFacebook__c((casoHeroku.getFacebook() != null && !"".equals(casoHeroku.getFacebook()) ? casoHeroku.getFacebook() : ""));
			casoSF.setTwitter__c((casoHeroku.getTwitter() != null && !"".equals(casoHeroku.getTwitter()) ? casoHeroku.getTwitter() : ""));
			casoSF.setUpdateContact__c(Boolean.valueOf(casoHeroku.getActDatosContacto()));
			casoSF.setAni__c((casoHeroku.getAni() != null && !"".equals(casoHeroku.getAni()) ? casoHeroku.getAni() : ""));
			casoSF.setMailBody__c((casoHeroku.getCuerpoMail() != null && !"".equals(casoHeroku.getCuerpoMail()) ? casoHeroku.getCuerpoMail() : ""));
			casoSF.setCustomerResponse__c((casoHeroku.getRespuestaAlCliente() != null && !"".equals(casoHeroku.getRespuestaAlCliente()) ? casoHeroku.getRespuestaAlCliente() : ""));
			casoSF.setCaseFavorability__c((casoHeroku.getFavorabilidadDelCaso() != null && !"".equals(casoHeroku.getFavorabilidadDelCaso()) ? casoHeroku.getFavorabilidadDelCaso() : ""));
			casoSF.setHeroku_User__c((casoHeroku.getHerokuUsername() != null && !"".equals(casoHeroku.getHerokuUsername()) ? casoHeroku.getHerokuUsername() : ""));
			casoSF.setUnity__c((casoHeroku.getCallCenter() != null && !"".equals(casoHeroku.getCallCenter()) ? casoHeroku.getCallCenter() : ""));

			//De momento no hace falta para los casos que se crean ahora, pero si se incluyen más creaciones de casos será necesario implementarlo
			//casoSF.setRecordtypeid((casoHeroku.getRecordtypeId() != null && !"".equals(casoHeroku.getRecordtypeId()) ? casoHeroku.getRecordtypeId() : ""));
		}
		return casoSF;
	}
}