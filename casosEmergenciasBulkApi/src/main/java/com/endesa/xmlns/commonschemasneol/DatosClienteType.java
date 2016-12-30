
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DatosClienteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatosClienteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCliente" minOccurs="0"/&gt;
 *         &lt;element name="TipoPersona" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoPersona" minOccurs="0"/&gt;
 *         &lt;element name="Nombre" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCompletoType" minOccurs="0"/&gt;
 *         &lt;element name="TipoDocumentoIdent" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="DocumentoIdentificativo" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="Idioma" type="{http://xmlns.endesa.com/CommonSchemasNeol}Idioma" minOccurs="0"/&gt;
 *         &lt;element name="Nacionalidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}Nacionalidad" minOccurs="0"/&gt;
 *         &lt;element name="RazonSocial" type="{http://xmlns.endesa.com/CommonSchemasNeol}RazonSocial" minOccurs="0"/&gt;
 *         &lt;element name="Contacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}ContactoType" minOccurs="0"/&gt;
 *         &lt;element name="EstadoCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}EstadoCliente" minOccurs="0"/&gt;
 *         &lt;element name="TipoCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoCliente" minOccurs="0"/&gt;
 *         &lt;element name="ClaseCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}ClaseCliente" minOccurs="0"/&gt;
 *         &lt;element name="DatosPostales" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="DatosFacturacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DatosFacturacionType" minOccurs="0"/&gt;
 *         &lt;element name="NumeroTelefono" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTelefono" minOccurs="0"/&gt;
 *         &lt;element name="FechaNacimiento" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="Profesion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Profesion" minOccurs="0"/&gt;
 *         &lt;element name="Sexo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Sexo" minOccurs="0"/&gt;
 *         &lt;element name="FacturaDigital" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Fax" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumFax" minOccurs="0"/&gt;
 *         &lt;element name="Rol" type="{http://xmlns.endesa.com/CommonSchemasNeol}Rol" minOccurs="0"/&gt;
 *         &lt;element name="MarcaPedidoVuelo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="MarcaRobinson" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="TipoContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoContacto" minOccurs="0"/&gt;
 *         &lt;element name="NumeroContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTelefono" minOccurs="0"/&gt;
 *         &lt;element name="Email" type="{http://xmlns.endesa.com/CommonSchemasNeol}Email" minOccurs="0"/&gt;
 *         &lt;element name="Telefono" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTelefono" minOccurs="0"/&gt;
 *         &lt;element name="MetodoContactoEmail" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="AliasNEOL" type="{http://xmlns.endesa.com/CommonSchemasNeol}AliasNEOL" minOccurs="0"/&gt;
 *         &lt;element name="EntidadBancaria" type="{http://xmlns.endesa.com/CommonSchemasNeol}EntidadBancaria" minOccurs="0"/&gt;
 *         &lt;element name="IdClienteML" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdClienteML" minOccurs="0"/&gt;
 *         &lt;element name="DireccionPuntoSuministro" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="DireccionCLiente" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosClienteType", propOrder = {
    "idCliente",
    "tipoPersona",
    "nombre",
    "tipoDocumentoIdent",
    "documentoIdentificativo",
    "idioma",
    "nacionalidad",
    "razonSocial",
    "contacto",
    "estadoCliente",
    "tipoCliente",
    "claseCliente",
    "datosPostales",
    "datosFacturacion",
    "numeroTelefono",
    "fechaNacimiento",
    "profesion",
    "sexo",
    "facturaDigital",
    "fax",
    "rol",
    "marcaPedidoVuelo",
    "marcaRobinson",
    "tipoContacto",
    "numeroContacto",
    "email",
    "telefono",
    "metodoContactoEmail",
    "aliasNEOL",
    "entidadBancaria",
    "idClienteML",
    "direccionPuntoSuministro",
    "direccionCLiente"
})
public class DatosClienteType {

    @XmlElement(name = "IdCliente")
    protected String idCliente;
    @XmlElement(name = "TipoPersona")
    protected String tipoPersona;
    @XmlElement(name = "Nombre")
    protected NombreCompletoType nombre;
    @XmlElement(name = "TipoDocumentoIdent")
    protected String tipoDocumentoIdent;
    @XmlElement(name = "DocumentoIdentificativo")
    protected String documentoIdentificativo;
    @XmlElement(name = "Idioma")
    protected String idioma;
    @XmlElement(name = "Nacionalidad")
    protected String nacionalidad;
    @XmlElement(name = "RazonSocial")
    protected String razonSocial;
    @XmlElement(name = "Contacto")
    protected ContactoType contacto;
    @XmlElement(name = "EstadoCliente")
    protected String estadoCliente;
    @XmlElement(name = "TipoCliente")
    protected String tipoCliente;
    @XmlElement(name = "ClaseCliente")
    protected String claseCliente;
    @XmlElement(name = "DatosPostales")
    protected DireccionType datosPostales;
    @XmlElement(name = "DatosFacturacion")
    protected DatosFacturacionType datosFacturacion;
    @XmlElement(name = "NumeroTelefono")
    protected String numeroTelefono;
    @XmlElement(name = "FechaNacimiento")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaNacimiento;
    @XmlElement(name = "Profesion")
    protected String profesion;
    @XmlElement(name = "Sexo")
    protected String sexo;
    @XmlElement(name = "FacturaDigital")
    protected Boolean facturaDigital;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "Rol")
    protected String rol;
    @XmlElement(name = "MarcaPedidoVuelo")
    protected Boolean marcaPedidoVuelo;
    @XmlElement(name = "MarcaRobinson")
    protected Boolean marcaRobinson;
    @XmlElement(name = "TipoContacto")
    protected String tipoContacto;
    @XmlElement(name = "NumeroContacto")
    protected String numeroContacto;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Telefono")
    protected String telefono;
    @XmlElement(name = "MetodoContactoEmail")
    protected Boolean metodoContactoEmail;
    @XmlElement(name = "AliasNEOL")
    protected String aliasNEOL;
    @XmlElement(name = "EntidadBancaria")
    protected String entidadBancaria;
    @XmlElement(name = "IdClienteML")
    protected String idClienteML;
    @XmlElement(name = "DireccionPuntoSuministro")
    protected DireccionType direccionPuntoSuministro;
    @XmlElement(name = "DireccionCLiente")
    protected DireccionType direccionCLiente;

    /**
     * Gets the value of the idCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCliente(String value) {
        this.idCliente = value;
    }

    /**
     * Gets the value of the tipoPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPersona() {
        return tipoPersona;
    }

    /**
     * Sets the value of the tipoPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPersona(String value) {
        this.tipoPersona = value;
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
     * Gets the value of the tipoDocumentoIdent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumentoIdent() {
        return tipoDocumentoIdent;
    }

    /**
     * Sets the value of the tipoDocumentoIdent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumentoIdent(String value) {
        this.tipoDocumentoIdent = value;
    }

    /**
     * Gets the value of the documentoIdentificativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoIdentificativo() {
        return documentoIdentificativo;
    }

    /**
     * Sets the value of the documentoIdentificativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoIdentificativo(String value) {
        this.documentoIdentificativo = value;
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
     * Gets the value of the razonSocial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Sets the value of the razonSocial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocial(String value) {
        this.razonSocial = value;
    }

    /**
     * Gets the value of the contacto property.
     * 
     * @return
     *     possible object is
     *     {@link ContactoType }
     *     
     */
    public ContactoType getContacto() {
        return contacto;
    }

    /**
     * Sets the value of the contacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactoType }
     *     
     */
    public void setContacto(ContactoType value) {
        this.contacto = value;
    }

    /**
     * Gets the value of the estadoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCliente() {
        return estadoCliente;
    }

    /**
     * Sets the value of the estadoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCliente(String value) {
        this.estadoCliente = value;
    }

    /**
     * Gets the value of the tipoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * Sets the value of the tipoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCliente(String value) {
        this.tipoCliente = value;
    }

    /**
     * Gets the value of the claseCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaseCliente() {
        return claseCliente;
    }

    /**
     * Sets the value of the claseCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaseCliente(String value) {
        this.claseCliente = value;
    }

    /**
     * Gets the value of the datosPostales property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDatosPostales() {
        return datosPostales;
    }

    /**
     * Sets the value of the datosPostales property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDatosPostales(DireccionType value) {
        this.datosPostales = value;
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
     * Gets the value of the numeroTelefono property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Sets the value of the numeroTelefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTelefono(String value) {
        this.numeroTelefono = value;
    }

    /**
     * Gets the value of the fechaNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Sets the value of the fechaNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNacimiento(XMLGregorianCalendar value) {
        this.fechaNacimiento = value;
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
     * Gets the value of the facturaDigital property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFacturaDigital() {
        return facturaDigital;
    }

    /**
     * Sets the value of the facturaDigital property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFacturaDigital(Boolean value) {
        this.facturaDigital = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
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
     * Gets the value of the marcaPedidoVuelo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMarcaPedidoVuelo() {
        return marcaPedidoVuelo;
    }

    /**
     * Sets the value of the marcaPedidoVuelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMarcaPedidoVuelo(Boolean value) {
        this.marcaPedidoVuelo = value;
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
     * Gets the value of the tipoContacto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoContacto() {
        return tipoContacto;
    }

    /**
     * Sets the value of the tipoContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoContacto(String value) {
        this.tipoContacto = value;
    }

    /**
     * Gets the value of the numeroContacto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroContacto() {
        return numeroContacto;
    }

    /**
     * Sets the value of the numeroContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroContacto(String value) {
        this.numeroContacto = value;
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
     * Gets the value of the entidadBancaria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntidadBancaria() {
        return entidadBancaria;
    }

    /**
     * Sets the value of the entidadBancaria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntidadBancaria(String value) {
        this.entidadBancaria = value;
    }

    /**
     * Gets the value of the idClienteML property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdClienteML() {
        return idClienteML;
    }

    /**
     * Sets the value of the idClienteML property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdClienteML(String value) {
        this.idClienteML = value;
    }

    /**
     * Gets the value of the direccionPuntoSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionPuntoSuministro() {
        return direccionPuntoSuministro;
    }

    /**
     * Sets the value of the direccionPuntoSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionPuntoSuministro(DireccionType value) {
        this.direccionPuntoSuministro = value;
    }

    /**
     * Gets the value of the direccionCLiente property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionCLiente() {
        return direccionCLiente;
    }

    /**
     * Sets the value of the direccionCLiente property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionCLiente(DireccionType value) {
        this.direccionCLiente = value;
    }

}
