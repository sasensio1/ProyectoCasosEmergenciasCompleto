package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.model.CaseHistory;
import com.casosemergencias.model.Caso;
import com.casosemergencias.util.datatables.DataTableProperties;

public interface CaseService {
	
	public List<Caso> readAllCase(DataTableProperties propDatatable);
	
	public Caso readCaseBySfid(String sfid, Integer numEntradas);

	public Integer getNumCasos(DataTableProperties propDatatable);
	
	public Caso readCaseById(Integer id);

	public Caso insertCase(Caso caso) throws EmergenciasException;
	
	public Integer updateCase(Caso caso);
	
	public boolean cancelarCaso(Caso caso, String userName);
	
	public List<CaseHistory> obtenerListaHistorialDeUnCaso(String caseSfid, Integer numEntradas);
	
	public Integer getNumHistorialDeUnCaso(String sfidCase);
}