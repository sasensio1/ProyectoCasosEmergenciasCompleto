package com.casosemergencias.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseCommentDAO;
import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.vo.CaseCommentVO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.Caso;
import com.casosemergencias.util.ParserModelVO;

public class CaseCommentServiceImpl implements CaseCommentService{

	final static Logger logger = Logger.getLogger(CaseCommentService.class);
	
	@Autowired
	public CaseCommentDAO caseCommentDAO;
	
	@Autowired CaseDAO caseDAO;
	
	@Override
	public List<CaseComment> obtenerListaComentariosDeUnCaso(String caseSfid) {
		
		List<CaseCommentVO> listaComentariosVO = caseCommentDAO.readCaseCommentByCaseId(caseSfid);
		List<CaseComment> listaComentarios = parseaYPreparaListaComentariosCasos(listaComentariosVO);
		
		return listaComentarios;
	}

	@Override
	public Caso obtenerDatosCasoParaComentario(String caseSfid) {
		CaseVO caseVO = caseDAO.readCaseForCommentByCaseid(caseSfid);
		Caso casoRetorno = new Caso();
		ParserModelVO.parseDataModelVO(caseVO, casoRetorno);
		
		return casoRetorno;
	}
	
	@Override
	public Boolean insertCaseComment(CaseComment caseComment) {
		CaseCommentVO caseCommentVO = new CaseCommentVO();
		
		caseCommentVO.setComment(caseComment.getComment());
		caseCommentVO.setIspublished(false);
		caseCommentVO.setCaseid(caseComment.getCaseid());
		Boolean insert = caseCommentDAO.insertCaseComment(caseCommentVO);
		return insert;
	}
	
	
	/*
	 * Método que parsea una lista de CaseHistoryVO en CaseComment.
	 * Ademas si 'createdate' coincide con 'lastmodifieddate', elimina el valor de 'lastmodifieddate' y 'lastmodifiedbyid', ya que el comentario no ha sido modificado
	 * */
	private List<CaseComment> parseaYPreparaListaComentariosCasos(List<CaseCommentVO> listaCaseCommentVO) {
		if(listaCaseCommentVO!=null && !listaCaseCommentVO.isEmpty()){
			
			List<CaseComment> retorno = new ArrayList<CaseComment>();
			
			SimpleDateFormat  dateFormat  = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//Definimos el formato para comparar 'createdate' con 'lastmodifieddate'
			
			for(CaseCommentVO comentarioCasoVO: listaCaseCommentVO){
				CaseComment casoRelacionado = new CaseComment();
				ParserModelVO.parseDataModelVO(comentarioCasoVO, casoRelacionado);
				
				try {
					
					Date fechaCreate = null;
					Date fechaModif = null;					
					if(casoRelacionado.getCreateddate() != null){
						fechaModif = dateFormat.parse(casoRelacionado.getCreateddate().toString());
					}
					if(casoRelacionado.getLastmodifieddate() != null){
						fechaCreate = dateFormat.parse(casoRelacionado.getLastmodifieddate().toString());
					}
				
					if(fechaCreate != null && fechaModif != null && fechaCreate.equals(fechaModif)){
						//El comentario ha sido insertado, no ha sido modificado
						casoRelacionado.setLastmodifieddate(null);
						casoRelacionado.setLastmodifiedbyid(null);
					}
				} catch (ParseException e) {
					logger.error("--- parseaYPreparaListaComentariosCasos -- error al parsear una fecha ---");
					logger.error(e.getMessage());					
				}
				
				retorno.add(casoRelacionado);
			}
			return retorno;
		}
		return null;
	}

}
