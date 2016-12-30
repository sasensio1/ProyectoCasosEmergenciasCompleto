package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.dao.HerokuUserDAO;
import com.casosemergencias.dao.vo.HerokuUserVO;
import com.casosemergencias.model.HerokuUser;
import com.casosemergencias.util.ParserModelVO;


//las transacciones se abren y cierran aqui
public class HerokuUserServiceImpl implements HerokuUserService{
	
	final static Logger logger = Logger.getLogger(HerokuUserService.class);
	
	@Autowired
	private HerokuUserDAO herokuUserDao;
	
	
	/**
	 * Metodo que dado un usuario y una contraseña, recupera de BBDD un HerokuUser. Si no existe devuelve null
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	@Override
	public HerokuUser readUserPass(String user, String pass) {

		logger.info("--- Inicio -- readUserPass ---");
		HerokuUser herokuUserView = new HerokuUser();
				
		HerokuUserVO herokuUser = new HerokuUserVO();
		herokuUser.setUsername(user);
		herokuUser.setPassword(pass);
		
		
		List<HerokuUserVO> listHerokuUser = new ArrayList<HerokuUserVO>();
		listHerokuUser = herokuUserDao.readHerokuUser(herokuUser);
		
		if(listHerokuUser != null && !listHerokuUser.isEmpty()){
			//El UserName es unico, por lo tanto  listHerokuUser solo tendra un dato
			herokuUser = listHerokuUser.get(0);
			ParserModelVO.parseDataModelVO(herokuUser, herokuUserView);
			
			logger.info("--- Fin -- readUserPass -- Existe usuario y password ---");
			
			return herokuUserView;
			
		}else{
			//si no existen datos devuelvo el usuario vacio
			logger.info("--- Fin -- readUserPass -- No existe usuario y password ---");
			return null;
		}

	}
	

	/**
	 * Metodo que dado un usuario y una contraseña, recupera de BBDD un HerokuUser. Si no existe devuelve null
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	@Override
	public HerokuUser readUser(String userName) {

		logger.info("--- Inicio -- readUser ---");
		HerokuUser herokuUserView = new HerokuUser();
				
		HerokuUserVO herokuUser = new HerokuUserVO();
		herokuUser.setUsername(userName);		
		
		List<HerokuUserVO> listHerokuUser = new ArrayList<HerokuUserVO>();
		listHerokuUser = herokuUserDao.readHerokuUser(herokuUser);
		
		if(listHerokuUser != null && !listHerokuUser.isEmpty()){
			//El UserName es unico, por lo tanto  listHerokuUser solo tendra un dato
			herokuUser = listHerokuUser.get(0);
			
			//guardamos el HerokuUser en UserView
			herokuUserView.setId(herokuUser.getId());
			herokuUserView.setName(herokuUser.getName());
			herokuUserView.setUser(herokuUser.getUsername());
			herokuUserView.setPass(herokuUser.getPassword());
			herokuUserView.setEmail(herokuUser.getEmail());
			herokuUserView.setEnvioEmail(herokuUser.getEnvioMail());
			
			logger.info("--- Fin -- readUser -- Existe usuario y password ---");
			
			return herokuUserView;
			
		}else{
			//si no existen datos devuelvo el usuario vacio
			logger.info("--- Fin -- readUser -- No existe usuario y password ---");
			return null;
		}
	}
		
	@Transactional
	@Override
	public void insertUser() {
	//	Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		
		try{
			HerokuUserVO herokuUser1 = new HerokuUserVO();
			herokuUser1.setName("User5");
			herokuUser1.setPassword("User5");
			herokuUser1.setEnvioMail(false);
			herokuUser1.setUsername("User5");
			herokuUser1.setActivo(false);
			herokuUser1.setEmail("user1@email.com");
			herokuUser1.setCreatedDate(new Date());
			
			HerokuUserVO herokuUser2 = new HerokuUserVO();
			herokuUser2.setName("User6");
			herokuUser2.setPassword("User6");
			herokuUser2.setEnvioMail(false);
			herokuUser2.setUsername("User6");
			herokuUser2.setActivo(true);
			herokuUser2.setEmail("user2@email.com");
			herokuUserDao.insertHerokuUser(herokuUser1, null);
			herokuUserDao.insertHerokuUser(herokuUser2, null);
//			herokuUserDao.insertHerokuUser2(null, null);
			
			//tx.commit();

	 	}catch (Exception e) {
	    	logger.error("readHerokuUser "+ e.getMessage());
	    	logger.error(e.getStackTrace()); 
//	    	tx.rollback();
	    }finally {
	    	//session.close(); 
	    }
	
	}

}
