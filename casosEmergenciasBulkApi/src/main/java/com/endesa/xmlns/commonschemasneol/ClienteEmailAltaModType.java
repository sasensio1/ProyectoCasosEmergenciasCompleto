
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClienteEmailAltaModType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClienteEmailAltaModType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Email" type="{http://xmlns.endesa.com/CommonSchemasNeol}Email" minOccurs="0"/&gt;
 *         &lt;element name="Cliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}DatosClienteType" minOccurs="0"/&gt;
 *         &lt;element name="TipoAccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoAccion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClienteEmailAltaModType", propOrder = {
    "email",
    "cliente",
    "tipoAccion"
})
public class ClienteEmailAltaModType {

    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Cliente")
    protected DatosClienteType cliente;
    @XmlElement(name = "TipoAccion")
    protected String tipoAccion;

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
     * Gets the value of the cliente property.
     * 
     * @return
     *     possible object is
     *     {@link DatosClienteType }
     *     
     */
    public DatosClienteType getCliente() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosClienteType }
     *     
     */
    public void setCliente(DatosClienteType value) {
        this.cliente = value;
    }

    /**
     * Gets the value of the tipoAccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAccion() {
        return tipoAccion;
    }

    /**
     * Sets the value of the tipoAccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAccion(String value) {
        this.tipoAccion = value;
    }

}
