
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatosTitularPagoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatosTitularPagoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Email" type="{http://xmlns.endesa.com/CommonSchemasNeol}Email" minOccurs="0"/&gt;
 *         &lt;element name="IdCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCliente" minOccurs="0"/&gt;
 *         &lt;element name="NombreCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCompletoType" minOccurs="0"/&gt;
 *         &lt;element name="RazonSocial" type="{http://xmlns.endesa.com/CommonSchemasNeol}RazonSocial" minOccurs="0"/&gt;
 *         &lt;element name="DocumentacionCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}DocumentacionType" minOccurs="0"/&gt;
 *         &lt;element name="TelefonoContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTelefono" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosTitularPagoType", propOrder = {
    "email",
    "idCliente",
    "nombreCliente",
    "razonSocial",
    "documentacionCliente",
    "telefonoContacto"
})
public class DatosTitularPagoType {

    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "IdCliente")
    protected String idCliente;
    @XmlElement(name = "NombreCliente")
    protected NombreCompletoType nombreCliente;
    @XmlElement(name = "RazonSocial")
    protected String razonSocial;
    @XmlElement(name = "DocumentacionCliente")
    protected DocumentacionType documentacionCliente;
    @XmlElement(name = "TelefonoContacto")
    protected String telefonoContacto;

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
     * Gets the value of the nombreCliente property.
     * 
     * @return
     *     possible object is
     *     {@link NombreCompletoType }
     *     
     */
    public NombreCompletoType getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Sets the value of the nombreCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link NombreCompletoType }
     *     
     */
    public void setNombreCliente(NombreCompletoType value) {
        this.nombreCliente = value;
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
     * Gets the value of the documentacionCliente property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentacionType }
     *     
     */
    public DocumentacionType getDocumentacionCliente() {
        return documentacionCliente;
    }

    /**
     * Sets the value of the documentacionCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentacionType }
     *     
     */
    public void setDocumentacionCliente(DocumentacionType value) {
        this.documentacionCliente = value;
    }

    /**
     * Gets the value of the telefonoContacto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * Sets the value of the telefonoContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoContacto(String value) {
        this.telefonoContacto = value;
    }

}
