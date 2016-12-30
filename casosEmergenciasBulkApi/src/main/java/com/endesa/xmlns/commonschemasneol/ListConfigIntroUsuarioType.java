
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListConfigIntroUsuarioType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListConfigIntroUsuarioType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdConfigUsuario" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdConfigUsuario"/&gt;
 *         &lt;element name="ConfiguracionUsuario" type="{http://xmlns.endesa.com/CommonSchemasNeol}ConfiguracionUsuario"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListConfigIntroUsuarioType", propOrder = {
    "idConfigUsuario",
    "configuracionUsuario"
})
public class ListConfigIntroUsuarioType {

    @XmlElement(name = "IdConfigUsuario", required = true)
    protected String idConfigUsuario;
    @XmlElement(name = "ConfiguracionUsuario", required = true)
    protected String configuracionUsuario;

    /**
     * Gets the value of the idConfigUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdConfigUsuario() {
        return idConfigUsuario;
    }

    /**
     * Sets the value of the idConfigUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdConfigUsuario(String value) {
        this.idConfigUsuario = value;
    }

    /**
     * Gets the value of the configuracionUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfiguracionUsuario() {
        return configuracionUsuario;
    }

    /**
     * Sets the value of the configuracionUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfiguracionUsuario(String value) {
        this.configuracionUsuario = value;
    }

}
