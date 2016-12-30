package com.casosemergencias.logic.ws.clients;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.example.sieme009.SIEME009;
import org.example.sieme009_schema.EventoType;
import org.example.sieme009_schema.GetEventosRelMsgRequestType;
import org.example.sieme009_schema.GetEventosRelMsgResponseType;
import org.example.sieme009_schema.GetEventosRelRequestType;
import org.example.sieme009_schema.GetEventosRelResponseType;

import com.casosemergencias.logic.ws.responses.GetEventosRelacionadosWSResponse;
import com.endesa.xmlns.commonschemas.SOAHeaderType;
import com.endesa.xmlns.commonschemasneol.ErrorHeaderType;
import com.endesa.xmlns.commonschemasneol.ErrorType;

public class GetEventosRelacionadosWSClient {
	final static Logger logger = Logger.getLogger(GetEventosRelacionadosWSClient.class);
	
	@Resource
	private SIEME009 getEventosRelacionadosWService;
	
	/**
	 * 
	 * @param numSuministro
	 * @param codEmpresa
	 * @return
	 */
	public GetEventosRelacionadosWSResponse getEventosRelacionadosWS(String numSuministro, String codEmpresa) {
		logger.info("-- Inicio -- getEventosRelacionadosWS()");
		SOAHeaderType soaRequestHeader = null;
		GetEventosRelMsgRequestType getEventosRelMsgRequest = null;
		GetEventosRelRequestType getEventosRelRequest = null;
		GetEventosRelResponseType getEventosRelResponse = null;
		GetEventosRelacionadosWSResponse response = null;
		
		try {
			
			// Rellenar la cabecera
			soaRequestHeader = new SOAHeaderType();
			soaRequestHeader.setArchitectureVersion("");
			soaRequestHeader.setClient("");
			soaRequestHeader.setExternalId("");
			soaRequestHeader.setIP("");
			soaRequestHeader.setLanguage("");
			soaRequestHeader.setServiceName("");
			soaRequestHeader.setSOAId("");
			soaRequestHeader.setSourceApplication("SFC");
			soaRequestHeader.setUser("");
			soaRequestHeader.setVersion("");
			
			// Rellenar los datos de la peticion
			getEventosRelMsgRequest = new GetEventosRelMsgRequestType();
			getEventosRelMsgRequest.setCodigoPais("");
			getEventosRelMsgRequest.setCliente(numSuministro);
			getEventosRelMsgRequest.setEmpresa(codEmpresa);
			
			// Realizar la peticion
			getEventosRelRequest = new GetEventosRelRequestType();
			getEventosRelRequest.setSOAHeader(soaRequestHeader);
			getEventosRelRequest.setGetEventosRelMsgRequest(getEventosRelMsgRequest);
			logger.info("Realizando la petición al servicio web");
			getEventosRelResponse = getEventosRelacionadosWService.getEventosRel(getEventosRelRequest);
			// Recoger el resultado
			response = checkWSResponse(getEventosRelResponse, numSuministro);
		} catch (Exception exception) {
			logger.error("Error realizando la consulta de eventos relacionados. ", exception);
		}
		logger.info("-- Fin -- getEventosRelacionadosWS()");
		return response;
	}

	/**
	 * @param getEventosRelacionadosResponse
	 */
	private static GetEventosRelacionadosWSResponse checkWSResponse(GetEventosRelResponseType getEventosRelacionadosResponse, String idSuministro) {
		logger.info("-- Inicio -- checkWSResponse()");
		GetEventosRelMsgResponseType getEventosRelMsgResponse;
		GetEventosRelacionadosWSResponse response = new GetEventosRelacionadosWSResponse();
		
		if (getEventosRelacionadosResponse != null) {
			getEventosRelMsgResponse = getEventosRelacionadosResponse.getGetEventosRelMsgResponse();
			if (getEventosRelMsgResponse.getErrorHeader() != null
					&& getEventosRelMsgResponse.getErrorHeader().getError() != null
					&& !getEventosRelMsgResponse.getErrorHeader().getError().isEmpty()) {
				checkWSErrors(response, getEventosRelMsgResponse.getErrorHeader(), idSuministro);
			} 
			
			if (getEventosRelMsgResponse != null) {
				if (getEventosRelMsgResponse.getListadoEventos() != null
						&& getEventosRelMsgResponse.getListadoEventos() != null
						&& !getEventosRelMsgResponse.getListadoEventos().getEvento().isEmpty()) {
					response.setListadoEventos(getEventosRelMsgResponse.getListadoEventos());
					for (EventoType evento : getEventosRelMsgResponse.getListadoEventos().getEvento()) {
						logger.info("Evento " + evento.getNevento() + " con descipción: " + evento.getDescripcionTipoEvento());
					}
				}
			}
		}
		logger.info("-- Fin -- checkWSResponse()");
		return response;
	}
	
	/**
	 * 
	 * @param response
	 * @param errorsArray
	 * @param numSuministro
	 */
	private static void checkWSErrors(GetEventosRelacionadosWSResponse response, ErrorHeaderType errors, String numSuministro) {
		logger.info("-- Inicio -- checkWSErrors()");
		Map<String, String> errorsMap = new HashMap<String, String>();
		StringBuilder strErrores = new StringBuilder("");
		
		if (errors != null && !errors.getError().isEmpty()) {
            for (ErrorType datosError: errors.getError()) {
            	strErrores.append(" Código de error - ").append(datosError.getCodigoError()).append(". Descripción Error: ").append(datosError.getMensajeError()).append(".");
                errorsMap.put(datosError.getCodigoError(), datosError.getMensajeError());
            }
            response.setMapaErrores(errorsMap);
            response.setResultadoErroneo(true);
            logger.error(strErrores.toString());
            logger.info("-- Fin -- checkWSErrors()");
        }
    }
}