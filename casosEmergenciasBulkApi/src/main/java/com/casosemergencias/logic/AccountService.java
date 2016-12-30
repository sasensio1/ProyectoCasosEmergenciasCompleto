package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Cuenta;
import com.casosemergencias.util.datatables.DataTableProperties;

public interface AccountService {

	public List<Cuenta> listOfAccountsTable();

	public Cuenta getAccountBySfid(String sfid, Integer limiteSuministros, Integer limiteContacto, Integer limiteCasos);
	
	public List<Cuenta> readAllCuentas(DataTableProperties propDatatable);
	
	public Integer getNumCuentas(DataTableProperties propDatatable);
}