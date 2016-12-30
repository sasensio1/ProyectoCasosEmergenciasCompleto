package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.PickListsDAO;
import com.casosemergencias.dao.vo.PickListsVO;
import com.casosemergencias.model.PickList;
import com.casosemergencias.util.ParserModelVO;

public class PickListsServiceImpl implements PickListsService{

final static Logger logger = Logger.getLogger(CaseService.class);
	
	@Autowired
	private PickListsDAO pickListDao;
	
	@Override
	public Map<String, Map<String, String>> getPickListPorObjeto(String objeto){
		
		Map<String, Map<String, String>> datosRetorno = null;
		PickListsVO objPick = new PickListsVO();
		objPick.setObjeto(objeto);
		List<PickListsVO> listaPickList = pickListDao.readPickListsUser(objPick);
		
		if (listaPickList != null && !listaPickList.isEmpty()){			
			PickListsVO ob = null;			
			Map<String, String> mapAux = null;
			for(int i=0; i<listaPickList.size();i++){
				ob = listaPickList.get(i);
				if (datosRetorno == null){
					 datosRetorno = new LinkedHashMap<String, Map<String, String>>();
				}
				
				if (!datosRetorno.containsKey(ob.getCampo())){
					mapAux = new LinkedHashMap<String, String>();
				}else{
					mapAux = datosRetorno.get(ob.getCampo());
				}
				
				mapAux.put(ob.getCodigo(), ob.getValor());
				datosRetorno.put(ob.getCampo(), mapAux);
			}
		}
		return datosRetorno;
	}
	
//	@Override
//	public Map<String, String> getPickListPorCampo(String objeto, String campo){
//		Map<String, String> datosRetorno = null;
//		PickListsVO objPick = new PickListsVO();
//		objPick.setObjeto(objeto);
//		objPick.setCampo(campo);
//		List<PickListsVO> listaPickList = pickListDao.readPickListsUser(objPick);
//		if (listaPickList != null && !listaPickList.isEmpty()){
//			PickListsVO ob = null;					
//			for(int i=0; i<listaPickList.size();i++){
//				ob = listaPickList.get(i);
//				if (datosRetorno == null){
//					 datosRetorno = new LinkedHashMap<String, String>();
//				}
//				datosRetorno.put(ob.getCodigo(), ob.getValor());
//			}
//		}
//		return datosRetorno;
//	}

	@Override
	public List<PickList> getPickListPorObjetoYCampo(String objeto, String campo) {
		List<PickList> picklistsLogic = new ArrayList<PickList>();
		List<PickListsVO> picklistsVO = pickListDao.readPickListsByObjetoAndCampo(objeto, campo);
		if (picklistsVO != null && !picklistsVO.isEmpty()) {
			for (PickListsVO picklistVO : picklistsVO) {
				PickList picklistLogic = new PickList();
				ParserModelVO.parseDataModelVO(picklistVO, picklistLogic);
				picklistsLogic.add(picklistLogic);
			}
		}
		return picklistsLogic;
	}
}
