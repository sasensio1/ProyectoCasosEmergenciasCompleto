package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.AccountView;
import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.controller.views.SuministroView;
import com.casosemergencias.logic.AccountService;
import com.casosemergencias.logic.SuministroService;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

@Controller
public class AccountController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private SuministroService suministroService;
	
	@RequestMapping(value = "/private/homeCuentas", method = RequestMethod.GET)
	public ModelAndView listadoCuentas() {
		
		logger.info("--- Inicio -- listadoCuentas ---");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeCuentasPage");
			
		logger.info("--- Fin -- listadoCuentas ---");
		return model;
	}
	
	/**
	 * Método que obtiene los datos de una cuenta a partir de su id. y los
	 * devuelve a la página.
	 * 
	 * @param sfid
	 *            Identificador de la cuenta.
	 * @return ModelAndView Datos de la cuenta a mostrar en la página.
	 */
	@RequestMapping(value = "/private/entidadCuenta", method = RequestMethod.GET)
	public ModelAndView getAccountData(@RequestParam String sfid,HttpServletRequest request) {
		logger.trace("Detalle de cuenta");
		HttpSession session = request.getSession(true);
		
		//def. variables para controlar tablas de la pantalla
		Integer limiteSuministros = 10; //por defecto recuperaremos 10 suministros asociados a la cuenta.
		Integer numSuministros = 0;
		List<SuministroView> suministrosView = new ArrayList<SuministroView>();
		
		session.setAttribute(Constantes.SFID_CUENTA, sfid);	
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, Constantes.FINAL_DETAIL_PAGE_CUENTA);
		
		AccountView cuentaView = new AccountView();
		ModelAndView model = new ModelAndView();
		Cuenta cuentaBBDD = accountService.getAccountBySfid(sfid, limiteSuministros, null, null);
		
		if (cuentaBBDD != null) {
			ParserModelVO.parseDataModelVO(cuentaBBDD, cuentaView);
		}
				
		List<Suministro> listaSuministros = suministroService.getNumSuministrosDeUnaCuenta(sfid);
		
		if (listaSuministros != null && !listaSuministros.isEmpty()) {
			numSuministros = listaSuministros.size();
			for (Suministro suministro : listaSuministros) {
				SuministroView suministroView = new SuministroView();
				ParserModelVO.parseDataModelVO(suministro, suministroView);
				suministrosView.add(suministroView);
			}
			cuentaView.setSuministros(suministrosView);
		}
		
		if (numSuministros > limiteSuministros) {
			cuentaView.setControlNumSuministros(true);
		} else {
			cuentaView.setControlNumSuministros(false);
		}
		
		//transformamos las fechas con el gmt de sesion
		long offset = (long)session.getAttribute("difGMTUser");	
		if(cuentaView.getSuministros() != null && !cuentaView.getSuministros().isEmpty()){
			for(SuministroView miSuministro : cuentaView.getSuministros()){
				if(miSuministro.getFechaCorte() != null){
					Date fechaCorte = miSuministro.getFechaCorte();
					fechaCorte = new Date(fechaCorte.getTime() + offset);
					miSuministro.setFechaCorte(fechaCorte);
				}
			}	
		}
		if(cuentaView.getCasos() != null && !cuentaView.getCasos().isEmpty()){
			for(CaseView miCase : cuentaView.getCasos()){
				if(miCase.getFechaApertura() != null){
					Date fechaApertura = miCase.getFechaApertura();
					fechaApertura = new Date(fechaApertura.getTime() + offset);
					miCase.setFechaApertura(fechaApertura);
				}
				if(miCase.getFechaEstimadaCierre() != null){
					Date fechaEstimacion = miCase.getFechaEstimadaCierre();
					fechaEstimacion = new Date(fechaEstimacion.getTime() + offset);
					miCase.setFechaEstimadaCierre(fechaEstimacion);
				}
			}	
		}
		
		logger.info("SFID_CUENTA" + session.getAttribute(Constantes.SFID_CUENTA));
		logger.info("SFID_CONTACTO" + session.getAttribute(Constantes.SFID_CONTACTO));
		logger.info("SFID_SUMINISTRO" + session.getAttribute(Constantes.SFID_SUMINISTRO));
		logger.info("FINAL_DETAIL_PAGE" + session.getAttribute(Constantes.FINAL_DETAIL_PAGE));

		model.setViewName("private/entidadCuentaPage");
		model.addObject("cuenta", cuentaView);
		return model;
	}

	/**
	 * M&eacute;todo para recuperar los datos del lsitado de de cuentas.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarCuentas", method = RequestMethod.POST)
	public @ResponseBody String listadoCuentas(@RequestBody String body,HttpServletRequest request){
		
		logger.info("--- Inicio -- listadoCuentas ---");
		
		//Limpieza de sfid que arrastramos
		
		HttpSession session = request.getSession(true);	
		
		session.setAttribute(Constantes.SFID_SUMINISTRO, null);	
		session.setAttribute(Constantes.SFID_CONTACTO, null);	
		session.setAttribute(Constantes.SFID_CUENTA, null);	
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, null);	
		session.setAttribute(Constantes.SFID_DIRECCION, null);

		
		//Limpieza de sfid que arrastramos
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		listaCuentas = accountService.readAllCuentas(propDataTable);

		for (Cuenta cuenta : listaCuentas) {
			jsonResult = new JSONObject();
			jsonResult.put("name", cuenta.getName());
			jsonResult.put("identitynumber__c", cuenta.getAccountRun());
			jsonResult.put("mainphone__c", cuenta.getTelefonoPrincipal());
			jsonResult.put("primaryemail__c", cuenta.getEmailPrincipal());
			jsonResult.put("sfid", cuenta.getSfid());
			jsonArray.put(jsonResult);
		}
		
		Integer numCuentas = accountService.getNumCuentas(propDataTable);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("iTotalRecords", numCuentas); 
		jsonObject.put("iTotalDisplayRecords", numCuentas); 
		jsonObject.put("data", jsonArray);
		jsonObject.put("draw", propDataTable.getDraw());
		
		logger.info("SFID_CUENTA" + session.getAttribute(Constantes.SFID_CUENTA));
		logger.info("SFID_CONTACTO" + session.getAttribute(Constantes.SFID_CONTACTO));
		logger.info("SFID_SUMINISTRO" + session.getAttribute(Constantes.SFID_SUMINISTRO));
		
		logger.info("--- Fin -- listadoCuentas ---");
		
		return jsonObject.toString();
	}
}