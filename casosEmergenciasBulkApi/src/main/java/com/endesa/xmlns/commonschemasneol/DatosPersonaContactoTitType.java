
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DatosPersonaContactoTitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatosPersonaContactoTitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdPersonaContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdPersContacto" minOccurs="0"/&gt;
 *         &lt;element name="Nombre" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCompletoType" minOccurs="0"/&gt;
 *         &lt;element name="TipoDoc" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="NumDoc" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="Email" type="{http://xmlns.endesa.com/CommonSchemasNeol}Email" minOccurs="0"/&gt;
 *         &lt;element name="Nacionalidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}Nacionalidad" minOccurs="0"/&gt;
 *         &lt;element name="Idioma" type="{http://xmlns.endesa.com/CommonSchemasNeol}Idioma" minOccurs="0"/&gt;
 *         &lt;element name="MetodoContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}MetodoContacto" minOccurs="0"/&gt;
 *         &lt;element name="MetodoContactoEmail" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Rol" type="{http://xmlns.endesa.com/CommonSchemasNeol}Rol" minOccurs="0"/&gt;
 *         &lt;element name="AliasNEOL" type="{http://xmlns.endesa.com/CommonSchemasNeol}AliasNEOL" minOccurs="0"/&gt;
 *         &lt;element name="MarcaRobinson" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Estado" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://xmlns.endesa.com/CommonSchemasNeol}EstadoPersonaContacto"&gt;
 *               &lt;enumeration value="potencial"/&gt;
 *               &lt;enumeration value="activo"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Profesion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Profesion" minOccurs="0"/&gt;
 *         &lt;element name="Sexo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Sexo" minOccurs="0"/&gt;
 *         &lt;element name="FechaDeNacimiento" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="Telefono" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTelefono" minOccurs="0"/&gt;
 *         &lt;element name="DireccionContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="DatosFacturacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DatosFacturacionType" minOccurs="0"/&gt;
 *         &lt;element name="Contratos" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaNumContratoType" minOccurs="0"/&gt;
 *         &lt;element name="AutorizadoCliente" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosPersonaContactoTitType", propOrder = {
    "idPersonaContacto",
    "nombre",
    "tipoDoc",
    "numDoc",
    "email",
    "nacionalidad",
    "idioma",
    "metodoContacto",
    "metodoContactoEmail",
    "rol",
    "aliasNEOL",
    "marcaRobinson",
    "estado",
    "profesion",
    "sexo",
    "fechaDeNacimiento",
    "telefono",
    "direccionContacto",
    "datosFacturacion",
    "contratos",
    "autorizadoCliente"
})
public class DatosPersonaContactoTitType {

    @XmlElement(name = "IdPersonaContacto")
    protected String idPersonaContacto;
    @XmlElement(name = "Nombre")
    protected NombreCompletoType nombre;
    @XmlElement(name = "TipoDoc")
    protected String tipoDoc;
    @XmlElement(name = "NumDoc")
    protected String numDoc;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Nacionalidad")
    protected String nacionalidad;
    @XmlElement(name = "Idioma")
    protected String idioma;
    @XmlElement(name = "MetodoContacto")
    protected String metodoContacto;
    @XmlElement(name = "MetodoContactoEmail")
    protected Boolean metodoContactoEmail;
    @XmlElement(name = "Rol")
    protected String rol;
    @XmlElement(name = "AliasNEOL")
    protected String aliasNEOL;
    @XmlElement(name = "MarcaRobinson")
    protected Boolean marcaRobinson;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "Profesion")
    protected String profesion;
    @XmlElement(name = "Sexo")
    protected String sexo;
    @XmlElement(name = "FechaDeNacimiento")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDeNacimiento;
    @XmlElement(name = "Telefono")
    protected String telefono;
    @XmlElement(name = "DireccionContacto")
    protected DireccionType direccionContacto;
    @XmlElement(name = "DatosFacturacion")
    protected DatosFacturacionType datosFacturacion;
    @XmlElement(name = "Contratos")
    protected ListaNumContratoType contratos;
    @XmlElement(name = "AutorizadoCliente")
    protected Boolean autorizadoCliente;

    /**
     * Gets the value of the idPersonaContacto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPersonaContacto() {
        return idPersonaContacto;
    }

    /**
     * Sets the value of the idPersonaContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPersonaContacto(String value) {
        this.idPersonaContacto = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link NombreCompletoType }
     *     
     */
    public NombreCompletoType getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link NombreCompletoType }
     *     
     */
    public void setNombre(NombreCompletoType value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the tipoDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * Sets the value of the tipoDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDoc(String value) {
        this.tipoDoc = value;
    }

    /**
     * Gets the value of the numDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumDoc() {
        return numDoc;
    }

    /**
     * Sets the value of the numDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumDoc(String value) {
        this.numDoc = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the nacionalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Sets the value of the nacionalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidad(String value) {
        this.nacionalidad = value;
    }

    /**
     * Gets the value of the idioma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Sets the value of the idioma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdioma(String value) {
        this.idioma = value;
    }

    /**
     * Gets the value of the metodoContacto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetodoContacto() {
        return metodoContacto;
    }

    /**
     * Sets the value of the metodoContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetodoContacto(String value) {
        this.metodoContacto = value;
    }

    /**
     * Gets the value of the metodoContactoEmail property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMetodoContactoEmail() {
        return metodoContactoEmail;
    }

    /**
     * Sets the value of the metodoContactoEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMetodoContactoEmail(Boolean value) {
        this.metodoContactoEmail = value;
    }

    /**
     * Gets the value of the rol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRol() {
        return rol;
    }

    /**
     * Sets the value of the rol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRol(String value) {
        this.rol = value;
    }

    /**
     * Gets the value of the aliasNEOL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasNEOL() {
        return aliasNEOL;
    }

    /**
     * Sets the value of the aliasNEOL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasNEOL(String value) {
        this.aliasNEOL = value;
    }

    /**
     * Gets the value of the marcaRobinson property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMarcaRobinson() {
        return marcaRobinson;
    }

    /**
     * Sets the value of the marcaRobinson property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMarcaRobinson(Boolean value) {
        this.marcaRobinson = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the profesion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * Sets the value of the profesion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfesion(String value) {
        this.profesion = value;
    }

    /**
     * Gets the value of the sexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Sets the value of the sexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexo(String value) {
        this.sexo = value;
    }

    /**
     * Gets the value of the fechaDeNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * Sets the value of the fechaDeNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDeNacimiento(XMLGregorianCalendar value) {
        this.fechaDeNacimiento = value;
    }

    /**
     * Gets the value of the telefono property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets the value of the telefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Gets the value of the direccionContacto property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionContacto() {
        return direccionContacto;
    }

    /**
     * Sets the value of the direccionContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionContacto(DireccionType value) {
        this.direccionContacto = value;
    }

    /**
     * Gets the value of the datosFacturacion property.
     * 
     * @return
     *     possible object is
     *     {@link DatosFacturacionType }
     *     
     */
    public DatosFacturacionType getDatosFacturacion() {
        return datosFacturacion;
    }

    /**
     * Sets the value of the datosFacturacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosFacturacionType }
     *     
     */
    public void setDatosFacturacion(DatosFacturacionType value) {
        this.datosFacturacion = value;
    }

    /**
     * Gets the value of the contratos property.
     * 
     * @return
     *     possible object is
     *     {@link ListaNumContratoType }
     *     
     */
    public ListaNumContratoType getContratos() {
        return contratos;
    }

    /**
     * Sets the value of the contratos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaNumContratoType }
     *     
     */
    public void setContratos(ListaNumContratoType value) {
        this.contratos = value;
    }

    /**
     * Gets the value of the autorizadoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutorizadoCliente() {
        return autorizadoCliente;
    }

    /**
     * Sets the value of the autorizadoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutorizadoCliente(Boolean value) {
        this.autorizadoCliente = value;
    }

}
