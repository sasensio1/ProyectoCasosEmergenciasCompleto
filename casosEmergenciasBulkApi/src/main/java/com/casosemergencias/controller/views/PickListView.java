package com.casosemergencias.controller.views;

import java.io.Serializable;

import com.casosemergencias.model.PickList;

public class PickListView extends ObjectView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String objeto;
	private String campo;
	private String codigo;
	private String valor;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public Object instantiateTargetLogic() {
		PickList picklist = new PickList();
		return picklist;
	}
}