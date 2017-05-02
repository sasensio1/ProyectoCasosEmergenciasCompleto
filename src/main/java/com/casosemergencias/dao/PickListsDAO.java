package com.casosemergencias.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casosemergencias.dao.vo.PickListsVO;

@Repository
public class PickListsDAO {
	
	final static Logger logger = Logger.getLogger(PickListsDAO.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todos los PickLists de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PickListsVO> readAllPickLists(){
				
		logger.debug("--- Inicio -- readAllPickLists ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from PickListsVO");
			
			List<PickListsVO> pickList = query.list(); 

			logger.debug("--- Fin -- readAllPickLists ---");
			
			return pickList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readAllPickLists ", e); 
	    	logger.error("--- Fin -- readAllPickLists ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve el PickLists que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un PickLists
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PickListsVO readPickListsById(Integer id){
		
		logger.debug("--- Inicio -- readPickListsById ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from PickListsVO as pickList WHERE pickList.id = :id");
			query.setInteger("id", id);
			
			List<PickListsVO> pickList = query.list(); 

			if(pickList != null && !pickList.isEmpty()){
				return pickList.get(0);
			}			
			
			logger.debug("--- Fin -- readPickListsById ---");
			
	    }catch (HibernateException e) {
	    	logger.error("--- readPickListsById ", e); 
	    	logger.error("--- Fin -- readPickListsById ---");
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	
	/**
	 * Devuelve el PickLists que tiene como objeto y campo los pasado por parametro al metodo.
	 * @param objeto 
	 * @param campo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PickListsVO> readPickListsByObjetoAndCampo(String objeto, String campo) {
		
		logger.debug("--- Inicio -- readPickListsByObjetoAndCampo ---");
		
		Session session = sessionFactory.openSession();
		
		List<PickListsVO> pickList = null;
				
		try {
			Query query = session.createQuery("FROM PickListsVO AS pickList WHERE pickList.objeto = :objeto AND pickList.campo = :campo ORDER BY pickList.valor ASC");
			query.setString("objeto", objeto);
			query.setString("campo", campo);
			
			pickList = query.list(); 
		
			logger.debug("--- Fin -- readPickListsByObjetoAndCampo ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readPickListsByObjetoAndCampo ", e); 
	    	logger.error("--- Fin -- readPickListsByObjetoAndCampo ---");
	    } finally {
	    	session.close(); 
	    }
	    return pickList;
	}

	/**
	 * Dado un PickLists, recupera una lista de HerokuUser con los mismos datos que PickLists
	 * 
	 * @param pickList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PickListsVO> readPickListsUser(PickListsVO pickListVo) {

		logger.debug("--- Inicio -- readPickListsUser ---");

		Session session = sessionFactory.openSession();
		boolean isFirst = true;

		try {
			// preparamos la query
			StringBuilder query = new StringBuilder("from PickListsVO as pickList");
			if (pickListVo.getId() != null) {
				if (isFirst) {
					query.append(" WHERE pickList.id = :id");
					isFirst = false;
				} else {
					query.append(" AND pickList.id = :id");
				}
			}
			
			if (pickListVo.getObjeto() != null) {
				if (isFirst) {
					query.append(" WHERE pickList.objeto = :objeto");
					isFirst = false;
				} else {
					query.append(" AND pickList.objeto = :objeto");
				}
			}
			
			if (pickListVo.getCampo() != null) {
				if (isFirst) {
					query.append(" WHERE pickList.campo = :campo");
					isFirst = false;
				} else {
					query.append(" AND pickList.campo = :campo");
				}
			}
			
			if (pickListVo.getCodigo() != null) {
				if (isFirst) {
					query.append(" WHERE pickList.codigo = :codigo");
					isFirst = false;
				} else {
					query.append(" AND pickList.codigo = :codigo");
				}
			}
			
			if (pickListVo.getValor() != null) {
				if (isFirst) {
					query.append(" WHERE pickList.valor = :valor");
					isFirst = false;
				} else {
					query.append(" AND pickList.valor = :valor");
				}
			}

			// añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());

			if (pickListVo.getId() != null) {
				result.setInteger("id", pickListVo.getId());
			}
			
			if (pickListVo.getObjeto() != null) {
				result.setString("objeto", pickListVo.getObjeto());
			}
			
			if (pickListVo.getCampo() != null) {
				result.setString("campo", pickListVo.getCampo());
			}
			
			if (pickListVo.getCodigo() != null) {
				result.setString("codigo", pickListVo.getCodigo());
			}
			
			if (pickListVo.getValor() != null) {
				result.setString("valor", pickListVo.getValor());
			}
			
			query.append(" order by campo, valor");
			List<PickListsVO> pickList = result.list();

			logger.debug("--- Fin -- readPickListsUser ---");

			return pickList;
		} catch (HibernateException e) {
			logger.error("--- readPickListsUser ", e);
			logger.error("--- Fin -- readPickListsUser ---");
		} finally {
			session.close();
		}
		return null;
	}
}
