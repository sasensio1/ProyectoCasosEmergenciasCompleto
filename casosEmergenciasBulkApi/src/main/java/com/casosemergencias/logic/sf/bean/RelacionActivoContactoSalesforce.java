package com.casosemergencias.logic.sf.bean;

import com.casosemergencias.model.CaseComment;

public class RelacionActivoContactoSalesforce {
	
	private String suministroSfid ;
	private String contactoSfid ;

	//Getters y Setters
	
	public String getSuministroSfid() {
		return suministroSfid;
	}
	public void setSuministroSfid(String suministroSfid) {
		this.suministroSfid = suministroSfid;
	}
	public String getContactoSfid() {
		return contactoSfid;
	}
	public void setContactoSfid(String contactoSfid) {
		this.contactoSfid = contactoSfid;
	}
	
	
	public static RelacionActivoContactoSalesforce copyFieldsFromHerokuToSalesForceRelacionActivoContacto(String suministroSfid,String contactoSfid) {
		RelacionActivoContactoSalesforce relacionActivoContactotSF = new RelacionActivoContactoSalesforce();

		relacionActivoContactotSF.setContactoSfid((suministroSfid!= null && !"".equals(suministroSfid) ? suministroSfid: ""));
		relacionActivoContactotSF.setSuministroSfid((contactoSfid!= null && !"".equals(contactoSfid) ? contactoSfid : ""));
		
		return relacionActivoContactotSF;
	}



}
