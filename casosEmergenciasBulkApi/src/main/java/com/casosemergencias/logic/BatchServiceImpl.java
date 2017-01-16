package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.batch.FieldLabelTableCreatorBatch;
import com.casosemergencias.batch.PicklistTableCreatorBatch;
import com.casosemergencias.batch.SalesforceSoapBulkApiInvokerBatch;
import com.casosemergencias.batch.bean.BulkApiInfoContainerBatch;
import com.casosemergencias.dao.HistoricBatchDAO;
import com.casosemergencias.dao.vo.HistoricBatchVO;
import com.casosemergencias.model.HistoricBatch;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableProperties;

public class BatchServiceImpl implements BatchService {
	
	final static Logger logger = Logger.getLogger(CaseService.class);


	@Autowired
	FieldLabelTableCreatorBatch fieldLabelTableCreatorBatch;
	
	@Autowired
	PicklistTableCreatorBatch picklistTableCreatorBatch;
	
	@Autowired
	SalesforceSoapBulkApiInvokerBatch soapBulkApiInvokerBatch;
	
	@Autowired
	private HistoricBatchDAO historicBatchDao;

	@Override
	public void updateHerokuPickListTable() {
		picklistTableCreatorBatch.fillHerokuPicklistTable();
	}
	
	@Override
	public void updateHerokuFieldLabelTable() {
		fieldLabelTableCreatorBatch.fillHerokuFieldLabelTable();
	}
	
	@Override
	public void getInfoToUpdateFromBulkApi(Date processStartDate, Date processEndDate) {
		soapBulkApiInvokerBatch.getAllBulkApiInfo(processStartDate, processEndDate);
	}

	@Override
	public void updateHerokuObjectsFromBulkApi(String objectName, BulkApiInfoContainerBatch bulkApiInfoContainer) {
		//TODO: COMPLETAR CON LLAMADAS A LOS DAOS SEGUN EL OBJETO. HABRÁ QUE INYECTAR LOS DAOS QUE SEAN NECESARIOS
		//TODO: DEVOLVER BOOLEAN CON ESTADO DE PROCESO.
	}
	
	/**
	 * Metodo que devuelve una lista con todos los HistoricBatchs que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<HistoricBatch> readAllHistoricBatch(DataTableProperties propDatatable) {
		
		logger.debug("--- Inicio -- readAllHistoricBatch ---");
		
		List<HistoricBatch> listHistoricBatch = new ArrayList<>();
		List<HistoricBatchVO> listHistoricBatchsVO = historicBatchDao.readHistoricBatchDataTable(propDatatable);

		logger.debug("--- Inicio -- readAllHistoricBatch historicBatchs en la lista: " + listHistoricBatchsVO.size() + " ---");
		
		for (HistoricBatchVO historicBatchVO : listHistoricBatchsVO) {
			HistoricBatch historicBatch = new HistoricBatch();
			ParserModelVO.parseDataModelVO(historicBatchVO, historicBatch);
			listHistoricBatch.add(historicBatch);
		}
		
		logger.debug("--- Fin -- readAllHistoricBatch ---");
		return listHistoricBatch;
	}
	
	public Integer getNumHistoricBatchs(DataTableProperties propDatatable){
		logger.debug("--- getNumCasos ---");
		return historicBatchDao.getNumHistoricBatchs(propDatatable);
	}
	
	
}