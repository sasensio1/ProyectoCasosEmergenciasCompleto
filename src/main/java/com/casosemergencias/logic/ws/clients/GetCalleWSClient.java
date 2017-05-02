package com.casosemergencias.logic.ws.clients;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.example.sieme002.SIEME002;
import org.example.sieme002_schema.CalleType;
import org.example.sieme002_schema.GetCalleMsgRequestType;
import org.example.sieme002_schema.GetCalleMsgResponseType;
import org.example.sieme002_schema.GetCalleRequestType;
import org.example.sieme002_schema.GetCalleResponseType;

import com.casosemergencias.logic.ws.responses.GetCalleWSResponse;
import com.endesa.xmlns.commonschemas.SOAHeaderType;
import com.endesa.xmlns.commonschemasneol.ErrorHeaderType;
import com.endesa.xmlns.commonschemasneol.ErrorType;

public class GetCalleWSClient {
final static Logger logger = Logger.getLogger(ConsultaDatosSuministroWSClient.class);
	
	@Resource
	private SIEME002 getCalleWService;
	
	public GetCalleWSResponse getCalleWS(String comuna, String nombreCalle)  {
		logger.info("-- Inicio -- getCalleWS()");
		SOAHeaderType soaRequestHeader = null;
		GetCalleMsgRequestType getCalleMsgRequest = null;
		GetCalleRequestType getCalleRequest = null;
		GetCalleResponseType getCalleResponse = null;
		GetCalleWSResponse response = null;
		
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
			getCalleMsgRequest = new GetCalleMsgRequestType();
			getCalleMsgRequest.setCodigoPais("");
			getCalleMsgRequest.setComuna(comuna);
			getCalleMsgRequest.setNombre(nombreCalle);
			
			// Realizar la peticion
			getCalleRequest = new GetCalleRequestType();
			getCalleRequest.setSOAHeader(soaRequestHeader);
			getCalleRequest.setGetCalleMsgRequest(getCalleMsgRequest);
			logger.info("Realizando la petición al servicio web");
			getCalleResponse = getCalleWService.getCalle(getCalleRequest);
			// Recoger el resultado
			response = checkWSResponse(getCalleResponse, nombreCalle, comuna);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error("Error realizando la consulta de calles. ", exception);
		}
		logger.info("-- Fin -- getCalleWS()");
		return response;
	}
	
	/**
	 * @param consultaDatosSuministroResponse
	 */
	private GetCalleWSResponse checkWSResponse(GetCalleResponseType getCalleResponse, String nombreCalle, String comuna) {
		logger.info("-- Inicio -- checkWSResponse()");
		GetCalleMsgResponseType getCalleMsgResponse;
		GetCalleWSResponse response = new GetCalleWSResponse();
		
		if (getCalleResponse != null) {
			getCalleMsgResponse = getCalleResponse.getGetCalleMsgResponse();
			if (getCalleMsgResponse.getErrorHeader() != null
					&& getCalleMsgResponse.getErrorHeader().getError() != null
					&& !getCalleMsgResponse.getErrorHeader().getError().isEmpty()) {
				checkWSErrors(response, getCalleMsgResponse.getErrorHeader(), nombreCalle, comuna);
			}
			
			if (getCalleMsgResponse != null) {
				if (getCalleMsgResponse.getListadoCalles() != null
						&& getCalleMsgResponse.getListadoCalles().getCalle() != null
						&& !getCalleMsgResponse.getListadoCalles().getCalle().isEmpty()) {
					response.setListadoCalles(getCalleMsgResponse.getListadoCalles());
					for (CalleType calle : getCalleMsgResponse.getListadoCalles().getCalle()) {
						logger.info("Calle con id '" + calle.getIdCalle() + "', tipo '" + calle.getTipoCalle() + "' y nombre '" + calle.getNombreCalle() + "'");
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
	private void checkWSErrors(GetCalleWSResponse response, ErrorHeaderType errors, String nombreCalle, String comuna) {
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
