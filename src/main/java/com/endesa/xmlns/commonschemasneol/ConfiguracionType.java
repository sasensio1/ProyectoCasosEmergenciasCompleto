
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfiguracionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfiguracionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdConf" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdConf" minOccurs="0"/&gt;
 *         &lt;element name="ValorConf" type="{http://xmlns.endesa.com/CommonSchemasNeol}ValorConf" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfiguracionType", propOrder = {
    "idConf",
    "valorConf"
})
public class ConfiguracionType {

    @XmlElement(name = "IdConf")
    protected String idConf;
    @XmlElement(name = "ValorConf")
    protected String valorConf;

    /**
     * Gets the value of the idConf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdConf() {
        return idConf;
    }

    /**
     * Sets the value of the idConf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdConf(String value) {
        this.idConf = value;
    }

    /**
     * Gets the value of the valorConf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorConf() {
        return valorConf;
    }

    /**
     * Sets the value of the valorConf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorConf(String value) {
        this.valorConf = value;
    }

}
