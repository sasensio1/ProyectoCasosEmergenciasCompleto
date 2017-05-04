package com.casosemergencias.dao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.casosemergencias.model.FieldLabel;

@Entity
@Table(name = "salesforce.fieldlabel")
@Where(clause = "objeto='Case'")
public class FieldLabelVO extends ObjectVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "objeto")
	private String objeto;

	@Column(name = "campo")
	private String campo;

	@Column(name = "label")
	private String label;

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

	@Override
	public Object instantiateTargetLogic() {
		FieldLabel fieldLabel = new FieldLabel();
		return fieldLabel;
	}

	
	
}
