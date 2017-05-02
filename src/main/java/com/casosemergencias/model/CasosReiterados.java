package com.casosemergencias.model;

import com.casosemergencias.controller.views.CasosReiteradosView;
import com.casosemergencias.dao.vo.CasosReiteradosVO;

//Objeto que tiene el modelo de un CasosReiterados, se utiliza en el Servicio
public class CasosReiterados extends ObjectLogic {

	private Integer id;
	private String sfid;
	private String name;
	private Double numCasos;
	private Double numDias;

	public CasosReiterados() {
		super();
	}

	public CasosReiterados(Integer id, String sfid, String name, Double numCasos, Double numDias) {
		super();
		this.id = id;
		this.sfid = sfid;
		this.name = name;
		this.numCasos = numCasos;
		this.numDias = numDias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getNumCasos() {
		return numCasos;
	}

	public void setNumCasos(Double numCasos) {
		this.numCasos = numCasos;
	}

	public Double getNumDias() {
		return numDias;
	}

	public void setNumDias(Double numDias) {
		this.numDias = numDias;
	}


	@Override
	public Object instantiateTargetVO() {
		CasosReiteradosVO casoReit = new CasosReiteradosVO();
		return casoReit;
	}

	@Override
	public Object instantiateTargetView() {
		CasosReiteradosView casoReit = new CasosReiteradosView();
		return casoReit;
	}
	
	
}
