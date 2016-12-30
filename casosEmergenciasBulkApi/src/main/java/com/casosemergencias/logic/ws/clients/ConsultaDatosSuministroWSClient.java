package com.casosemergencias.logic.ws.clients;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.example.sires033.SIRES033;
import org.example.sires033_schema.ConsultaDatosSuministroMsgRequestType;
import org.example.sires033_schema.ConsultaDatosSuministroMsgResponseType;
import org.example.sires033_schema.ConsultaDatosSuministroRequestType;
import org.example.sires033_schema.ConsultaDatosSuministroResponseType;
import org.example.sires033_schema.OrdenType;
import org.example.sires033_schema.SuministroType;

import com.casosemergencias.logic.ws.responses.ConsultaDatosSuministroWSResponse;
import com.casosemergencias.util.constants.ConstantesTibcoWS;
import com.endesa.xmlns.commonschemas.SOAHeaderType;
import com.endesa.xmlns.commonschemasneol.ErrorHeaderType;
import com.endesa.xmlns.commonschemasneol.ErrorType;

public class ConsultaDatosSuministroWSClient {
	final static Logger logger = Logger.getLogger(ConsultaDatosSuministroWSClient.class);
	
	@Resource
	private SIRES033 consultaDatosSuministroWService;
	
	/**
	 * 
	 * @param numSuministro
	 * @param codEmpresa
	 * @return
	 */
	public ConsultaDatosSuministroWSResponse consultarDatosSuministroWS(String numSuministro, String codEmpresa) {
		logger.info("-- Inicio -- consultarDatosSuministroWS()");
		SOAHeaderType soaRequestHeader = null;
		ConsultaDatosSuministroMsgRequestType consultaDatosSuministroMsgRequest = null;
		ConsultaDatosSuministroRequestType consultaDatosSuministroRequest = null;
		ConsultaDatosSuministroResponseType consultaDatosSuministroResponse = null;
		ConsultaDatosSuministroWSResponse response = null;
		
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
			OrdenType ordenamiento = new OrdenType();
			ordenamiento.setCampoOrdenar("3");
			ordenamiento.setNumeroRegistros("9999");
			ordenamiento.setOrden("D");
			ordenamiento.setPosicionDesde("1");
			
			consultaDatosSuministroMsgRequest = new ConsultaDatosSuministroMsgRequestType();
			consultaDatosSuministroMsgRequest.setCodigoPais(ConstantesTibcoWS.TIBCO_WS_SIRES033_CODIGO_PAIS);
			consultaDatosSuministroMsgRequest.setCodigoEmpresa(codEmpresa);
			consultaDatosSuministroMsgRequest.setNumeroSuministro(numSuministro);
			consultaDatosSuministroMsgRequest.setOrdenamiento(ordenamiento);			
			consultaDatosSuministroMsgRequest.setPrincipal("N");
			
			// Realizar la peticion
			consultaDatosSuministroRequest = new ConsultaDatosSuministroRequestType();
			consultaDatosSuministroRequest.setSOAHeader(soaRequestHeader);
			consultaDatosSuministroRequest.setConsultaDatosSuministroMsgRequest(consultaDatosSuministroMsgRequest);
			logger.info("Realizando la petición al servicio web");
			consultaDatosSuministroResponse = consultaDatosSuministroWService.consultaDatosSuministro(consultaDatosSuministroRequest);
			// Recoger el resultado
			response = checkWSResponse(consultaDatosSuministroResponse, numSuministro);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error("Error realizando la consulta de suministros. ", exception);
		}
		logger.info("-- Fin -- consultarDatosSuministroWS()");
		return response;
	}

	/**
	 * @param consultaDatosSuministroResponse
	 */
	private ConsultaDatosSuministroWSResponse checkWSResponse(ConsultaDatosSuministroResponseType consultaDatosSuministroResponse, String idSuministro) {
		logger.info("-- Inicio -- checkWSResponse()");
		ConsultaDatosSuministroMsgResponseType consultaDatosSuministroMsgResponse;
		ConsultaDatosSuministroWSResponse response = new ConsultaDatosSuministroWSResponse();
		
		if (consultaDatosSuministroResponse != null) {
			consultaDatosSuministroMsgResponse = consultaDatosSuministroResponse.getConsultaDatosSuministroMsgResponse();
			if (consultaDatosSuministroMsgResponse.getErrorHeader() != null
					&& consultaDatosSuministroMsgResponse.getErrorHeader().getError() != null
					&& !consultaDatosSuministroMsgResponse.getErrorHeader().getError().isEmpty()) {
				checkWSErrors(response, consultaDatosSuministroMsgResponse.getErrorHeader(), idSuministro);
			}

			if (consultaDatosSuministroMsgResponse != null) {
				response.setTotalRegistros(consultaDatosSuministroMsgResponse.getTotalRegistros());
				logger.info("Total registros: " + consultaDatosSuministroMsgResponse.getTotalRegistros());
				if (consultaDatosSuministroMsgResponse.getListadoSuministros() != null
						&& consultaDatosSuministroMsgResponse.getListadoSuministros().getSuministro() != null
						&& !consultaDatosSuministroMsgResponse.getListadoSuministros().getSuministro().isEmpty()) {
					response.setListadoSuministros(consultaDatosSuministroMsgResponse.getListadoSuministros());
					for (SuministroType suministro : consultaDatosSuministroMsgResponse.getListadoSuministros().getSuministro()) {
						logger.info("Suministro " + suministro.getNumeroSuministro() + " con estado " + suministro.getEstadoSuministro());
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
	private void checkWSErrors(ConsultaDatosSuministroWSResponse response, ErrorHeaderType errors, String numSuministro) {
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