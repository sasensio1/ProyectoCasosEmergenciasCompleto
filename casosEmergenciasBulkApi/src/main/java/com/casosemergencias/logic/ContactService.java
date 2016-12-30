package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.model.Calle;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.util.datatables.DataTableProperties;

public interface ContactService {
	public List<Contacto> listOfContactsTable();
	public Contacto readContactoBySfid(String sfid);
	public List<Contacto> readAllContactos(DataTableProperties propDatatable);
	public Integer getNumContactos(DataTableProperties propDatatable);
	public Boolean asociarSuministro(String sfid,String contactSfid);
	public Direccion getSalesforceAddress(Calle street, Direccion direccion) throws EmergenciasException;
	//public Caso populateCaseInfoToInsert(String direccionSf,String contactSfid,String herokuCaseOwner);


}