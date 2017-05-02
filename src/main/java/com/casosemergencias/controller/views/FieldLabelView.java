package com.casosemergencias.controller.views;

import java.io.Serializable;

import com.casosemergencias.model.FieldLabel;

public class FieldLabelView extends ObjectView implements Serializable {


	private static final long serialVersionUID = 1L;

	private Integer id;
	private String objeto;
	private String campo;
	private String label;
	
	private String labelFieldLabel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLabelFieldLabel() {
		return labelFieldLabel;
	}
	public void setLabelFieldLabel(String labelFieldLabel) {
		this.labelFieldLabel = labelFieldLabel;
	}
	@Override
	public Object instantiateTargetLogic() {
		FieldLabel fieldLabel = new FieldLabel();
		return fieldLabel;
	}
	
	
}
