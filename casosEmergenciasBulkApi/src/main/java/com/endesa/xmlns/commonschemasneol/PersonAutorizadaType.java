
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonAutorizadaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonAutorizadaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Rol" type="{http://xmlns.endesa.com/CommonSchemasNeol}Rol" minOccurs="0"/&gt;
 *         &lt;element name="Email" type="{http://xmlns.endesa.com/CommonSchemasNeol}Email" minOccurs="0"/&gt;
 *         &lt;element name="NombreCompleto" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCompletoType" minOccurs="0"/&gt;
 *         &lt;element name="Documentacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DocumentacionType" minOccurs="0"/&gt;
 *         &lt;element name="RazonSocial" type="{http://xmlns.endesa.com/CommonSchemasNeol}RazonSocial" minOccurs="0"/&gt;
 *         &lt;element name="Direccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="Telefono" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTelefono" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonAutorizadaType", propOrder = {
    "rol",
    "email",
    "nombreCompleto",
    "documentacion",
    "razonSocial",
    "direccion",
    "telefono"
})
public class PersonAutorizadaType {

    @XmlElement(name = "Rol")
    protected String rol;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "NombreCompleto")
    protected NombreCompletoType nombreCompleto;
    @XmlElement(name = "Documentacion")
    protected DocumentacionType documentacion;
    @XmlElement(name = "RazonSocial")
    protected String razonSocial;
    @XmlElement(name = "Direccion")
    protected DireccionType direccion;
    @XmlElement(name = "Telefono")
    protected String telefono;

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
     * Gets the value of the nombreCompleto property.
     * 
     * @return
     *     possible object is
     *     {@link NombreCompletoType }
     *     
     */
    public NombreCompletoType getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Sets the value of the nombreCompleto property.
     * 
     * @param value
     *     allowed object is
     *     {@link NombreCompletoType }
     *     
     */
    public void setNombreCompleto(NombreCompletoType value) {
        this.nombreCompleto = value;
    }

    /**
     * Gets the value of the documentacion property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentacionType }
     *     
     */
    public DocumentacionType getDocumentacion() {
        return documentacion;
    }

    /**
     * Sets the value of the documentacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentacionType }
     *     
     */
    public void setDocumentacion(DocumentacionType value) {
        this.documentacion = value;
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
     * Gets the value of the direccion property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccion() {
        return direccion;
    }

    /**
     * Sets the value of the direccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccion(DireccionType value) {
        this.direccion = value;
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

}
