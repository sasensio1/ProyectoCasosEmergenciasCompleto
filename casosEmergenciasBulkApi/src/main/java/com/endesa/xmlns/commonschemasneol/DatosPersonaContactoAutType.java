
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatosPersonaContactoAutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatosPersonaContactoAutType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Rol" type="{http://xmlns.endesa.com/CommonSchemasNeol}Rol" minOccurs="0"/&gt;
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
@XmlType(name = "DatosPersonaContactoAutType", propOrder = {
    "rol",
    "autorizadoNivelCliente"
})
public class DatosPersonaContactoAutType {

    @XmlElement(name = "Rol")
    protected String rol;
    @XmlElement(name = "AutorizadoNivelCliente")
    protected Boolean autorizadoNivelCliente;

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
