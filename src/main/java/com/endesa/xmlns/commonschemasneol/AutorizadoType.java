
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutorizadoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutorizadoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdPersContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdPersContacto" minOccurs="0"/&gt;
 *         &lt;element name="Rol" type="{http://xmlns.endesa.com/CommonSchemasNeol}Rol" minOccurs="0"/&gt;
 *         &lt;element name="Email" type="{http://xmlns.endesa.com/CommonSchemasNeol}Email" minOccurs="0"/&gt;
 *         &lt;element name="Nombre" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCompletoType" minOccurs="0"/&gt;
 *         &lt;element name="TipoDocIdentificativo" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="DocumentoIdentificativo" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="Idioma" type="{http://xmlns.endesa.com/CommonSchemasNeol}Idioma" minOccurs="0"/&gt;
 *         &lt;element name="Nacionalidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}Nacionalidad" minOccurs="0"/&gt;
 *         &lt;element name="DireccionPostalPrincipal" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="DatosBancariosCuentaPrincipal" type="{http://xmlns.endesa.com/CommonSchemasNeol}CuentaComercType" minOccurs="0"/&gt;
 *         &lt;element name="ListaContratosAutoriz" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaContratosType" minOccurs="0"/&gt;
 *         &lt;element name="AutorizadoNivelCliente" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutorizadoType", propOrder = {
    "idPersContacto",
    "rol",
    "email",
    "nombre",
    "tipoDocIdentificativo",
    "documentoIdentificativo",
    "idioma",
    "nacionalidad",
    "direccionPostalPrincipal",
    "datosBancariosCuentaPrincipal",
    "listaContratosAutoriz",
    "autorizadoNivelCliente"
})
public class AutorizadoType {

    @XmlElement(name = "IdPersContacto")
    protected String idPersContacto;
    @XmlElement(name = "Rol")
    protected String rol;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Nombre")
    protected NombreCompletoType nombre;
    @XmlElement(name = "TipoDocIdentificativo")
    protected String tipoDocIdentificativo;
    @XmlElement(name = "DocumentoIdentificativo")
    protected String documentoIdentificativo;
    @XmlElement(name = "Idioma")
    protected String idioma;
    @XmlElement(name = "Nacionalidad")
    protected String nacionalidad;
    @XmlElement(name = "DireccionPostalPrincipal")
    protected DireccionType direccionPostalPrincipal;
    @XmlElement(name = "DatosBancariosCuentaPrincipal")
    protected CuentaComercType datosBancariosCuentaPrincipal;
    @XmlElement(name = "ListaContratosAutoriz")
    protected ListaContratosType listaContratosAutoriz;
    @XmlElement(name = "AutorizadoNivelCliente")
    protected Boolean autorizadoNivelCliente;

    /**
     * Gets the value of the idPersContacto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPersContacto() {
        return idPersContacto;
    }

    /**
     * Sets the value of the idPersContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPersContacto(String value) {
        this.idPersContacto = value;
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
     * Gets the value of the tipoDocIdentificativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocIdentificativo() {
        return tipoDocIdentificativo;
    }

    /**
     * Sets the value of the tipoDocIdentificativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocIdentificativo(String value) {
        this.tipoDocIdentificativo = value;
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
     * Gets the value of the direccionPostalPrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionPostalPrincipal() {
        return direccionPostalPrincipal;
    }

    /**
     * Sets the value of the direccionPostalPrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionPostalPrincipal(DireccionType value) {
        this.direccionPostalPrincipal = value;
    }

    /**
     * Gets the value of the datosBancariosCuentaPrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link CuentaComercType }
     *     
     */
    public CuentaComercType getDatosBancariosCuentaPrincipal() {
        return datosBancariosCuentaPrincipal;
    }

    /**
     * Sets the value of the datosBancariosCuentaPrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link CuentaComercType }
     *     
     */
    public void setDatosBancariosCuentaPrincipal(CuentaComercType value) {
        this.datosBancariosCuentaPrincipal = value;
    }

    /**
     * Gets the value of the listaContratosAutoriz property.
     * 
     * @return
     *     possible object is
     *     {@link ListaContratosType }
     *     
     */
    public ListaContratosType getListaContratosAutoriz() {
        return listaContratosAutoriz;
    }

    /**
     * Sets the value of the listaContratosAutoriz property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaContratosType }
     *     
     */
    public void setListaContratosAutoriz(ListaContratosType value) {
        this.listaContratosAutoriz = value;
    }

    /**
     * Gets the value of the autorizadoNivelCliente property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutorizadoNivelCliente() {
        return autorizadoNivelCliente;
    }

    /**
     * Sets the value of the autorizadoNivelCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutorizadoNivelCliente(Boolean value) {
        this.autorizadoNivelCliente = value;
    }

}
