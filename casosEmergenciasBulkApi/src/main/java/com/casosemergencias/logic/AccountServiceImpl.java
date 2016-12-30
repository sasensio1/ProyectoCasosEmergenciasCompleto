package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.AccountDAO;
import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableProperties;

//las transacciones se abren y cierran aqui
public class AccountServiceImpl implements AccountService {

	final static Logger logger = Logger.getLogger(AccountService.class);

	@Autowired
	private AccountDAO accountDao;

	/**
	 * Metodo que devuelve una lista de todas las cuentas a mostrar en la tabla
	 * de nuestra app.
	 * 
	 * @return listofallaccounts
	 */
	@Override
	public List<Cuenta> listOfAccountsTable() {

		List<Cuenta> listOfAccountsTable = new ArrayList<Cuenta>();
		List<AccountVO> listOfAllAccounts = new ArrayList<AccountVO>();
		listOfAllAccounts = accountDao.readAllAccount();
		Cuenta cuenta = null;

		for (AccountVO cuen : listOfAllAccounts) {

			cuenta = new Cuenta();

			ParserModelVO.parseDataModelVO(cuen, cuenta);

			listOfAccountsTable.add(cuenta);

		}
		return listOfAccountsTable;
	}

	/**
	 * Método que los datos de una cuenta, a partir de su id.
	 * @param sfid Identificador de la cuenta.
	 * @param limiteSuministros numero que limita los suministros asociados a la cuenta. Si es null se recuperan todos los suministros
	 * @param limiteContacto numero que limita los contactos asociados a la cuenta. Si es null se recuperan todos los contactos
	 * @param limiteCasos numero que limita los casos asociados a la cuenta. Si es null se recuperan todos los casos
	 * 
	 * @return ModelAndView Datos de la cuenta a mostrar en la página.
	 */
	@Override
	public Cuenta getAccountBySfid(String sfid, Integer limiteSuministros, Integer limiteContacto, Integer limiteCasos) {
		Cuenta cuenta = new Cuenta();
		AccountVO cuentaVO = accountDao.readAccountBySfid(sfid, limiteSuministros, limiteContacto, limiteCasos);

		if (cuentaVO != null) {
			ParserModelVO.parseDataModelVO(cuentaVO, cuenta);
		}
	
		return cuenta;
	}

	@Override
	public List<Cuenta> readAllCuentas(DataTableProperties propDatatable) {
		logger.debug("--- Inicio -- readAllSuministros ---");
		List<Cuenta> listCuentas = new ArrayList<Cuenta>();
		
		List<AccountVO> listCuentasVO = accountDao.readCuentaDataTable(propDatatable);
		logger.debug("--- Inicio -- readAllSuministros cantidad: " + listCuentasVO.size() + " ---");
		
		for (AccountVO cuentaVO : listCuentasVO) {
			Cuenta cuenta = new Cuenta();
			ParserModelVO.parseDataModelVO(cuentaVO, cuenta);
			listCuentas.add(cuenta);
		}
		
		logger.debug("--- Fin -- readAllSuministros ---:"+listCuentas.size());
		return listCuentas;
	}

	@Override
	public Integer getNumCuentas(DataTableProperties propDatatable) {
		return accountDao.countCuentas(propDatatable);
	}
}