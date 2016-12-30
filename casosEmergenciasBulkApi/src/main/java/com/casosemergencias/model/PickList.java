package com.casosemergencias.model;

import java.io.Serializable;

import com.casosemergencias.controller.views.PickListView;
import com.casosemergencias.dao.vo.PickListsVO;

public class PickList extends ObjectLogic implements Serializable {

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
	public Object instantiateTargetView() {
		PickListView picklist = new PickListView();
		return picklist;
	}
	
	@Override
	public Object instantiateTargetVO() {
		PickListsVO picklist = new PickListsVO();
		return picklist;
	}
}