package com.casosemergencias.batch.bean;
public class FieldLabelBatch {
	
	private Integer id;
	private String objeto;
	private String campo;
	private String label;
	
	public FieldLabelBatch(String objeto, String campo, String label){
		this.objeto = objeto;
		this.campo = campo;
		this.label = label;
	}
	
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
	
}
