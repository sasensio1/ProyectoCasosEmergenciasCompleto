package com.casosemergencias.batch;

import java.util.Calendar;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.logic.BatchService;

import com.casosemergencias.util.constants.ConstantesBatch;

@Resource
public class BorradoHistoricoCargasBatch {
	final static Logger logger = Logger.getLogger(BorradoHistoricoCargasBatch.class);
	
	@Autowired
	private BatchService batchService;
	
	public void borraHistoricoAntiguo() {
		logger.trace("Borrado del historico de cargas");
		try {
			Calendar fechaParaBorrar= Calendar.getInstance();
			fechaParaBorrar.add(Calendar.DAY_OF_YEAR, (-1)*ConstantesBatch.NUM_DIAS_ANTES_DE_BORRADO);
			batchService.borraHistoricoAntiguo(fechaParaBorrar.getTime());
		} catch (Exception ex) {
			logger.error("Error borrando del historico de cargas: ", ex);
		}
		logger.trace("Borrado del historico de cargas de Heroku completado");
	}

}
