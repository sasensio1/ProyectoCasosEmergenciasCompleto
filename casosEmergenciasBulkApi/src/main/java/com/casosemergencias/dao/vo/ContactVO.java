package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.WhereJoinTable;

import com.casosemergencias.model.Contacto;

@Entity
@Table(name="salesforce.contact")
public class ContactVO extends ObjectVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemDate;
	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	//campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;

	@Column(name = "name")
	private String name;
	
	@Column(name = "birthdate")
	private Date fechaNacimiento;

	@Column(name = "preferredchannelcontact__c")
	private String canalPreferenteContacto;
	
	@Column(name = "associatedaccounttype__c")
	private String tipoCuentaAsociado;
	
	@Column(name = "motherslastname__c")
	private String apellidoMaterno;
	
	@Column(name = "identitytype__c")
	private String tipoIdentidad;
	
	@Column(name = "secondaryphone__c")
	private String telefonoSecundario;

	@Column(name = "secondaryemail__c")
	private String emailSecundario;
		
	@Column(name = "sf4twitter__fcbk_username__c")
	private String sf4twitterFcbkUsername;

	@Column(name = "repeatedcases__c")
	private Boolean casosReiterados;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "identitynumber__c")
	private String run;
	
	@Column(name = "concatenatecontacaddress__c")
	private String dirContacto;
	
	@Column(name = "sf4twitter__twitter_user_id__c")
	private String sf4twitterTwitterUserId;
	
	@Column(name = "sf4twitter__fcbk_user_id__c")
	private String sf4twitterFcbkUserId;
	
	@Column(name = "sf4twitter__twitter_username__c")
	private String sf4twitterTwitterUsername;
		
	@Column(name = "contacttype__c")
	private String tipoContacto;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "fatherslastname__c")
	private String apellidoPaterno;
	
	@Column(name = "sf4twitter__influencer__c")
	private String influencer;
	
	@Column(name = "sf4twitter__twitter_bio__c")
	private String twitterBio;
	
	@Column(name = "sf4twitter__influencer_type__c")
	private String influencerType;
	
	@Column(name = "sf4twitter__twitter_follower_count__c")
	private Integer seguidoresTwitter;
	
	@Column(name = "accountid")
	private String accountid;	
	
	@Column(name = "firstname")
	private String firstname;	
	
	@OneToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="accountid", referencedColumnName="sfid", insertable = false, updatable=false)
	private AccountVO cuentaJoin;
	
	@OneToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="contactaddress__c", referencedColumnName="sfid", insertable = false, updatable=false)
	private DireccionVO dirContactoJoin;
	
	
	
	/*Recuento de seguidores de Twitter*/ 
	/*Influencer*/
	/*Influencer Tipo*/
	/*Biografía de Twitter*/

	/*Joins con picklist*/
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "preferredchannelcontact__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'PreferredChannelContact__c' and objeto = 'Contact'")
	private PickListsContactCanalPreferenteContactoVO canalPreferenteContactoPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "identitytype__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'IdentityType__c' and objeto = 'Contact'")
	private PickListsContactTipoIdentidadVO tipoIdentidadPickList;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "contacttype__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@WhereJoinTable(clause = "campo = 'ContactType__c' and objeto = 'Contact'")
	private PickListsContactTipoContactoVO tipoContactoPickList;
	
	public ContactVO() {
		super();
	}

	public ContactVO(Boolean isDeleted, Date systemDate, String hcLastop, String hcError, Integer id, String sfid,
			String name, Date fechaNacimiento, String canalPreferenteContacto, String tipoCuentaAsociado,
			String apellidoMaterno, String tipoIdentidad, String telefonoSecundario, String emailSecundario,
			String sf4twitterFcbkUsername, Boolean casosReiterados, String email, String run, String dirContacto,
			String sf4twitterTwitterUserId, String sf4twitterFcbkUserId, String sf4twitterTwitterUsername,
			String tipoContacto, String phone, String apellidoPaterno, String accountid,String firstname, AccountVO cuentaJoin,
			PickListsContactCanalPreferenteContactoVO canalPreferenteContactoPickList, PickListsContactTipoIdentidadVO tipoIdentidadPickList,
			PickListsContactTipoContactoVO tipoContactoPickList) {
		super();
		this.isDeleted = isDeleted;
		this.systemDate = systemDate;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.name = name;
		this.fechaNacimiento = fechaNacimiento;
		this.canalPreferenteContacto = canalPreferenteContacto;
		this.tipoCuentaAsociado = tipoCuentaAsociado;
		this.apellidoMaterno = apellidoMaterno;
		this.tipoIdentidad = tipoIdentidad;
		this.telefonoSecundario = telefonoSecundario;
		this.emailSecundario = emailSecundario;
		this.sf4twitterFcbkUsername = sf4twitterFcbkUsername;
		this.casosReiterados = casosReiterados;
		this.email = email;
		this.run=run;
		this.dirContacto = dirContacto;
		this.sf4twitterTwitterUserId = sf4twitterTwitterUserId;
		this.sf4twitterFcbkUserId = sf4twitterFcbkUserId;
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
		this.tipoContacto = tipoContacto;
		this.phone = phone;
		this.apellidoPaterno = apellidoPaterno;
		this.accountid = accountid;
		this.firstname=firstname;
		this.cuentaJoin = cuentaJoin;
		this.canalPreferenteContactoPickList = canalPreferenteContactoPickList;
		this.tipoIdentidadPickList = tipoIdentidadPickList;
		this.tipoContactoPickList = tipoContactoPickList;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
	}

	public String getHcLastop() {
		return hcLastop;
	}

	public void setHcLastop(String hcLastop) {
		this.hcLastop = hcLastop;
	}

	public String getHcError() {
		return hcError;
	}

	public void setHcError(String hcError) {
		this.hcError = hcError;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCanalPreferenteContacto() {
		return canalPreferenteContacto;
	}

	public void setCanalPreferenteContacto(String canalPreferenteContacto) {
		this.canalPreferenteContacto = canalPreferenteContacto;
	}

	public String getTipoCuentaAsociado() {
		return tipoCuentaAsociado;
	}

	public void setTipoCuentaAsociado(String tipoCuentaAsociado) {
		this.tipoCuentaAsociado = tipoCuentaAsociado;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTipoIdentidad() {
		return tipoIdentidad;
	}

	public void setTipoIdentidad(String tipoIdentidad) {
		this.tipoIdentidad = tipoIdentidad;
	}

	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}

	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getSf4twitterFcbkUsername() {
		return sf4twitterFcbkUsername;
	}

	public void setSf4twitterFcbkUsername(String sf4twitterFcbkUsername) {
		this.sf4twitterFcbkUsername = sf4twitterFcbkUsername;
	}

	public Boolean getCasosReiterados() {
		return casosReiterados;
	}

	public void setCasosReiterados(Boolean casosReiterados) {
		this.casosReiterados = casosReiterados;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRun() {
		return run;
	}
	public void setRun(String run) {
		this.run = run;
	}
	public String getDirContacto() {
		return dirContacto;
	}

	public void setDirContacto(String dirContacto) {
		this.dirContacto = dirContacto;
	}

	public String getSf4twitterTwitterUserId() {
		return sf4twitterTwitterUserId;
	}

	public void setSf4twitterTwitterUserId(String sf4twitterTwitterUserId) {
		this.sf4twitterTwitterUserId = sf4twitterTwitterUserId;
	}

	public String getSf4twitterFcbkUserId() {
		return sf4twitterFcbkUserId;
	}

	public void setSf4twitterFcbkUserId(String sf4twitterFcbkUserId) {
		this.sf4twitterFcbkUserId = sf4twitterFcbkUserId;
	}

	public String getSf4twitterTwitterUsername() {
		return sf4twitterTwitterUsername;
	}

	public void setSf4twitterTwitterUsername(String sf4twitterTwitterUsername) {
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public Object instantiateTargetLogic() {
		Contacto contacto = new Contacto();
		return contacto;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public AccountVO getCuentaJoin() {
		return cuentaJoin;
	}

	public void setCuentaJoin(AccountVO cuentaJoin) {
		this.cuentaJoin = cuentaJoin;
	}

	public PickListsContactCanalPreferenteContactoVO getCanalPreferenteContactoPickList() {
		return canalPreferenteContactoPickList;
	}

	public void setCanalPreferenteContactoPickList(PickListsContactCanalPreferenteContactoVO canalPreferenteContactoPickList) {
		this.canalPreferenteContactoPickList = canalPreferenteContactoPickList;
	}

	public PickListsContactTipoIdentidadVO getTipoIdentidadPickList() {
		return tipoIdentidadPickList;
	}

	public void setTipoIdentidadPickList(PickListsContactTipoIdentidadVO tipoIdentidadPickList) {
		this.tipoIdentidadPickList = tipoIdentidadPickList;
	}

	public PickListsContactTipoContactoVO getTipoContactoPickList() {
		return tipoContactoPickList;
	}

	public void setTipoContactoPickList(PickListsContactTipoContactoVO tipoContactoPickList) {
		this.tipoContactoPickList = tipoContactoPickList;
	}

	public String getLabelCanalPreferenteContactoPickList() {
		String result = this.getCanalPreferenteContacto();
		if (this.getCanalPreferenteContactoPickList() != null) {
			result = this.getCanalPreferenteContactoPickList().getValor();
		}
		return result;
	}
	
	public String getLabelTipoIdentidadPickList() {
		String result = this.getTipoIdentidad();
		if (this.getTipoIdentidadPickList() != null) {
			result = this.getTipoIdentidadPickList().getValor();
		}
		return result;
	}
	
	public String getLabelTipoContactoPickList() {
		String result = this.getTipoContacto();
		if (this.getTipoContactoPickList() != null) {
			result = this.getTipoContactoPickList().getValor();
		}
		return result;
	}

	public String getInfluencer() {
		return influencer;
	}

	public void setInfluencer(String influencer) {
		this.influencer = influencer;
	}

	public String getTwitterBio() {
		return twitterBio;
	}

	public void setTwitterBio(String twitterBio) {
		this.twitterBio = twitterBio;
	}

	public String getInfluencerType() {
		return influencerType;
	}

	public void setInfluencerType(String influencerType) {
		this.influencerType = influencerType;
	}

	public Integer getSeguidoresTwitter() {
		return seguidoresTwitter;
	}

	public void setSeguidoresTwitter(Integer seguidoresTwitter) {
		this.seguidoresTwitter = seguidoresTwitter;
	}

	public DireccionVO getDirContactoJoin() {
		return dirContactoJoin;
	}

	public void setDirContactoJoin(DireccionVO dirContactoJoin) {
		this.dirContactoJoin = dirContactoJoin;
	}
}