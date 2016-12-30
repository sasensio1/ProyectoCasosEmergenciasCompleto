package com.casosemergencias.logic;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.AccountDAO;
import com.casosemergencias.dao.AssetDAO;
import com.casosemergencias.dao.CalleDAO;
import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.ContactDAO;
import com.casosemergencias.dao.DireccionDAO;
import com.casosemergencias.dao.RelacionActivoContactoDAO;
import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.dao.vo.AssetVO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.dao.vo.ContactVO;
import com.casosemergencias.dao.vo.DireccionVO;
import com.casosemergencias.dao.vo.RelacionActivoContactoVO;
import com.casosemergencias.dao.vo.StreetVO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.logic.sf.response.SearchDirectionResponse;
import com.casosemergencias.logic.sf.rest.SearchDirection;
import com.casosemergencias.logic.sf.util.SalesforceLoginChecker;
import com.casosemergencias.model.Calle;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.constants.ConstantesError;
import com.casosemergencias.util.datatables.DataTableProperties;


//las transacciones se abren y cierran aqui
public class ContactServiceImpl implements ContactService{
	
	final static Logger logger = Logger.getLogger(ContactService.class);
	
	@Autowired
	private ContactDAO contactDao;
	
	@Autowired
	private RelacionActivoContactoDAO relacionDAO;
	
	@Autowired
	private CaseDAO casoDAO;
	
	@Autowired
	private AssetDAO assetDAO;
	
	@Autowired
	private CalleDAO calleDAO;
	
	@Autowired
	private DireccionDAO direccionDAO;
	
	@Autowired
	private AccountDAO cuentaDAO;
	
	@Autowired
	private SalesforceLoginChecker salesforceLoginChecker;
		
	/**
	 * Metodo que devuelve una lista de todos los contactos a mostrar en la tabla de nuestra app.
	 * @return listofallcontacts
	 */
	@Override
	public List<Contacto> listOfContactsTable() {
		
		List<Contacto> listOfContactsTable= new ArrayList<Contacto>();
		List<ContactVO> listOfAllContacts =new ArrayList<ContactVO>();
		listOfAllContacts=contactDao.readAllContact();
		Contacto contacto= null;
		
		
		for(ContactVO con:listOfAllContacts){
			
			contacto = new Contacto();
			
			ParserModelVO.parseDataModelVO(con, contacto);
		
			listOfContactsTable.add(contacto);
					
		}		
		return listOfContactsTable;		
	}
	
	@Override
	public Contacto readContactoBySfid(String sfid){
		Contacto returnContacto = new Contacto();
		ContactVO contactoVO = contactDao.readContactBySfid(sfid);
		
		if (contactoVO != null){
			ParserModelVO.parseDataModelVO(contactoVO, returnContacto);
		}
		
		List<RelacionActivoContactoVO> listaRelacionVO = relacionDAO.getSuministrosRelacionesPorContacto(sfid);
		List<Suministro> listaSuministro = parseaListaSuministrosRel(listaRelacionVO);
		returnContacto.setSuministros(listaSuministro);
		
		List<CaseVO> listacasosVO = casoDAO.readCaseOfContact(sfid);
		List<Caso> casoRelacionado = parseaListaCasos(listacasosVO);
		returnContacto.setCasos(casoRelacionado);
		
		return returnContacto;
	}

	@Override
	public List<Contacto> readAllContactos(DataTableProperties propDatatable) {
		logger.debug("--- Inicio -- readAllContactos ---");
		List<Contacto> listContactos = new ArrayList<Contacto>();

		List<ContactVO> listContactosVO = contactDao.readContactosDataTable(propDatatable);
		logger.debug("--- Inicio -- readAllContactos cantidad: " + listContactosVO.size() + " ---");

		for (ContactVO contactoVO : listContactosVO) {
			Contacto contacto = new Contacto();
			ParserModelVO.parseDataModelVO(contactoVO, contacto);
			listContactos.add(contacto);
		}

		logger.debug("--- Fin -- readAllContactos ---:" + listContactos.size());
		return listContactos;
	}

	@Override
	public Integer getNumContactos(DataTableProperties propDatatable) {
		return contactDao.countContactos(propDatatable);
	}
	
	private List<Caso> parseaListaCasos(List<CaseVO> listacasosVO) {
		if(listacasosVO!=null && !listacasosVO.isEmpty()){
			List<Caso> retorno = new ArrayList<Caso>();
			for(CaseVO casoVO: listacasosVO){
				Caso casoRelacionado = new Caso();
				ParserModelVO.parseDataModelVO(casoVO, casoRelacionado);
				retorno.add(casoRelacionado);
			}
			return retorno;
		}
		return null;
	}

	private List<Suministro> parseaListaSuministrosRel(List<RelacionActivoContactoVO> listaRelacionVO) {
		if(listaRelacionVO!=null && !listaRelacionVO.isEmpty()){
			List<Suministro> retorno = new ArrayList<Suministro>();
			for(RelacionActivoContactoVO relacion: listaRelacionVO){
				if(relacion.getActivo()!=null && relacion.getActivo().getSuministroJoin()!=null){
					SuministroVO sumConRelacion = relacion.getActivo().getSuministroJoin();
					Suministro sumRelacionado = new Suministro();
					ParserModelVO.parseDataModelVO(sumConRelacion, sumRelacionado);
					if(relacion.getTipoRelacionActivo()!=null)
						sumRelacionado.setRelacionActivo(relacion.getTipoRelacionActivo().getValor());
					retorno.add(sumRelacionado);
				}
			}
			
			return retorno;
		}
		return null;
	}

	@Override
	public Boolean asociarSuministro(String sfid, String contactSfid) {
		List<AssetVO> listAssetVO= assetDAO.readAssetBySuministroid(sfid);
		if(listAssetVO!=null && !listAssetVO.isEmpty()){
			AssetVO assetVO=listAssetVO.get(0);
			String activoId=assetVO.getSfid();
			List<RelacionActivoContactoVO> listRelActiContactoVO= relacionDAO.readRelacionActivoContactoByActivoIdAndContact(activoId,contactSfid);
				if(listRelActiContactoVO!=null && !listRelActiContactoVO.isEmpty()){
					return false;				
				}
				else{
					RelacionActivoContactoVO relActiContactoVO= new RelacionActivoContactoVO();
					relActiContactoVO.setTipoRelacionActivoClave(Constantes.PICKLIST_RELACIONACTIVO_REPORTADOR);
					relActiContactoVO.setActivoId(activoId);
					relActiContactoVO.setContactoId(contactSfid);
					relacionDAO.insertRelacionActivoContacto(relActiContactoVO);
					return true;
				}
		}
		return null;
	}
	
	@Override
	public Direccion getSalesforceAddress(Calle street,Direccion direccion) throws EmergenciasException {
		
		logger.trace("--- Servicio getSFDirection iniciado ---");
		// 1. Leer usuario de fichero de propiedades
		Properties properties = new Properties();
		String username = null;
		String password = null;
		String token = null;
		UserSessionInfo userSessionInfoFromDB = null;
		SearchDirectionResponse respuestaDireccion = null;
		Direccion direccionSf = new Direccion();
		Calle streetSf= new Calle();
		

		try (InputStream propsInputStream = getClass().getClassLoader().getResourceAsStream("/environment/dev/config.properties")) {
			properties.load(propsInputStream);
			username = properties.getProperty("heroku.user");
			password = properties.getProperty("heroku.pass");
			token = properties.getProperty("heroku.token");
			
			if (username != null && !"".equals(username) && password != null && !"".equals(password) && token != null && !"".equals(token)) {
				UserSessionInfo sessionInfoToLogin = new UserSessionInfo();
				sessionInfoToLogin.setUsername(properties.getProperty("heroku.user"));
				sessionInfoToLogin.setPassword(properties.getProperty("heroku.pass"));
				sessionInfoToLogin.setAccessToken(properties.getProperty("heroku.token"));
				userSessionInfoFromDB = salesforceLoginChecker.getUserSessionInfo(sessionInfoToLogin);
				if (userSessionInfoFromDB != null) {
					StreetVO streetHerokuNew= new StreetVO();
					DireccionVO direccionHerokuNew =new DireccionVO();
					respuestaDireccion=SearchDirection.searchDirectionInSalesforce(userSessionInfoFromDB, street, direccion);
					if (respuestaDireccion.getIdDireccion() != null && !"".equals(respuestaDireccion.getIdDireccion())  ) {
						logger.info("Direccion recuperada correctamente" + respuestaDireccion.getIdDireccion());						
						if(respuestaDireccion.getIdCalle()!= null && !"".equals(respuestaDireccion.getIdCalle())){
							logger.info("Calle recuperada correctamente" + respuestaDireccion.getIdCalle());						
							StreetVO streetHerokuBBDD =calleDAO.readCalleBySfid(respuestaDireccion.getIdCalle());
								if(streetHerokuBBDD==null){
									streetHerokuNew.setSfid(respuestaDireccion.getIdCalle());
									streetHerokuNew.setRegion(street.getRegion());
									streetHerokuNew.setMunicipality(street.getMunicipality());
									streetHerokuNew.setStreet(street.getStreet());
									streetHerokuNew.setStreetType(street.getStreetType());
									calleDAO.insertCalle(streetHerokuNew);		
								}
						}																				
							DireccionVO direccionHerokuBBDD = direccionDAO.readDireccionBySfid(respuestaDireccion.getIdDireccion());
							if(direccionHerokuBBDD==null){
								direccionHerokuNew.setNumero(direccion.getNumero());
								direccionHerokuNew.setDepartamento(direccion.getDepartamento());
								direccionHerokuNew.setSfid(respuestaDireccion.getIdDireccion());
								if(respuestaDireccion.getNameDireccion() != null && !"".equals(respuestaDireccion.getNameDireccion())){
									direccionHerokuNew.setName(respuestaDireccion.getNameDireccion());
								}
								direccionHerokuNew.setCalle(respuestaDireccion.getIdCalle());
								direccionHerokuNew.setCalleJoin(streetHerokuNew);
								direccionDAO.insertDireccion(direccionHerokuNew);
								ParserModelVO.parseDataModelVO(direccionHerokuNew, direccionSf);
							}
							else{
								ParserModelVO.parseDataModelVO(direccionHerokuBBDD, direccionSf);
							}						
					}
					else{
						direccionSf = null;
						logger.warn("Se ha producido un error al recuperar la direccion en SalesForce");
						throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_006, ConstantesError.SALESFORCE__SEARCH_ADDRESS_ERROR);
					}
				}
			}
		} catch (IOException exception) {
			logger.error("Error obteniendo los datos del usuario: ", exception);
			throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_006, ConstantesError.SALESFORCE__SEARCH_ADDRESS_ERROR);
		}
		logger.trace("--- Servicio getSFDirection completado ---");
		return direccionSf;
	}

	/*@Override
	public Caso populateCaseInfoToInsert(String direccionSf, String contactSfid,String herokuCaseOwner) {
		logger.debug("Rellenamos los datos del caso para insertarlo por direccion");
		Caso casoToInsert = new Caso();
		ContactVO contacto = contactDao.readContactBySfid(contactSfid);
		DireccionVO direccion = direccionDAO.readDireccionBySfid(direccionSf);
		String canalNotificacion = null;
		if (contacto != null) {
			logger.debug("El contacto no es nulo, se rellenan sus datos");
			if (contacto.getCanalPreferenteContacto() != null && !"".equals(contacto.getCanalPreferenteContacto())) {
				canalNotificacion = contacto.getCanalPreferenteContacto();
			}
			if(contacto.getAccountid()!=null){
				casoToInsert.setNombreCuenta(contacto.getAccountid());
			
			}
			casoToInsert.setNombreContacto(contacto.getSfid());
			casoToInsert.setEmailNotificacion(contacto.getEmail());
			casoToInsert.setTelefonoContacto(contacto.getPhone());
		}
		if(direccion!=null){
			if(direccion.getName()!=null){
				casoToInsert.setDireccionSuministro(direccion.getName());
			}
		}
		casoToInsert.setHerokuUsername(herokuCaseOwner);
		casoToInsert.setDireccion(direccionSf);
		casoToInsert.setPeticion(Constantes.COD_CASO_MOTIVO_EMERGENCIA);
		casoToInsert.setCanalOrigen(Constantes.COD_CASO_ORIGEN_CALL_CENTER);
		casoToInsert.setType(Constantes.COD_CASO_TYPE_RECLAMO);
		casoToInsert.setEstado(Constantes.COD_CASO_STATUS_PREINGRESADO);
		casoToInsert.setCanalNotificacion((canalNotificacion != null && !"".equals(canalNotificacion) ? canalNotificacion : Constantes.COD_CONTACTO_CANAL_PREF_CONTACT_003));
		return casoToInsert;
	}*/
}