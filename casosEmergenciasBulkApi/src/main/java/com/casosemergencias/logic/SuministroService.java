package com.casosemergencias.logic;

import java.util.List;
import java.util.Map;

import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.datatables.DataTableProperties;

public interface SuministroService {
	
	public List<Suministro> readAllSuministros();	
	public List<Suministro> readAllSuministros(DataTableProperties propDatatable);
	public Suministro readSuministroBySfid(String id);	
	public Integer getNumSuministros(DataTableProperties propDatatable);
	public List<Suministro> getNumSuministrosDeUnaCuenta(String sfidCuenta);
	public Map<String, Object> getDatosSuministroWS(String numSuministro);
	public List<Suministro> readSuministrosCuenta(String sfidCuenta, Integer numeroSuministros);
	
}