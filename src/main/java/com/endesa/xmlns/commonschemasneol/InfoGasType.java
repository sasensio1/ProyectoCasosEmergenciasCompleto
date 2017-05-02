
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InfoGasType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoGasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GrupoPeaje" type="{http://xmlns.endesa.com/CommonSchemasNeol}GrupoPeaje"/&gt;
 *         &lt;element name="DispCaldera" type="{http://xmlns.endesa.com/CommonSchemasNeol}DispCaldera"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoGasType", propOrder = {
    "grupoPeaje",
    "dispCaldera"
})
public class InfoGasType {

    @XmlElement(name = "GrupoPeaje", required = true)
    protected String grupoPeaje;
    @XmlElement(name = "DispCaldera")
    protected boolean dispCaldera;

    /**
     * Gets the value of the grupoPeaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrupoPeaje() {
        return grupoPeaje;
    }

    /**
     * Sets the value of the grupoPeaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrupoPeaje(String value) {
        this.grupoPeaje = value;
    }

    /**
     * Gets the value of the dispCaldera property.
     * 
     */
    public boolean isDispCaldera() {
        return dispCaldera;
    }

    /**
     * Sets the value of the dispCaldera property.
     * 
     */
    public void setDispCaldera(boolean value) {
        this.dispCaldera = value;
    }

}
