package com.casosemergencias.logic.sf.bean;

import com.casosemergencias.model.Direccion;
import com.casosemergencias.model.Calle;

public class DireccionSalesForce {
	//Campos Street
	private String region ;
	private String comuna ;
	private String calle ;
	private String tipoCalle ;
	//Campos Address
	private String numero ;
	private String departamento ;
	
	//Getters y Setters
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getTipoCalle() {
		return tipoCalle;
	}

	public void setTipoCalle(String tipoCalle) {
		this.tipoCalle = tipoCalle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public static DireccionSalesForce copyFieldsFromHerokuToSalesForceDirectionBean(Calle streetHeroku, Direccion direccionHeroku) {
		DireccionSalesForce directionSF = new DireccionSalesForce();
		if (streetHeroku != null && direccionHeroku != null) {
			directionSF.setRegion((streetHeroku.getRegion()!= null && !"".equals(streetHeroku.getRegion()) ? streetHeroku.getRegion(): ""));
			directionSF.setComuna((streetHeroku.getMunicipality()!= null && !"".equals(streetHeroku.getMunicipality()) ? streetHeroku.getMunicipality() : ""));
			directionSF.setCalle((streetHeroku.getStreet() != null && !"".equals(streetHeroku.getStreet() ) ? streetHeroku.getStreet()  : ""));
			directionSF.setTipoCalle((streetHeroku.getStreetType()  != null && !"".equals(streetHeroku.getStreetType() ) ? streetHeroku.getStreetType()  : ""));
			directionSF.setNumero((direccionHeroku.getNumero() != null && !"".equals(direccionHeroku.getNumero() ) ? direccionHeroku.getNumero()  : ""));
			directionSF.setDepartamento((direccionHeroku.getDepartamento() != null && !"".equals(direccionHeroku.getDepartamento()) ? direccionHeroku.getDepartamento() : ""));			
		}
		return directionSF;
	}
}