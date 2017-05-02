
package com.endesa.xmlns.commonschemasneol;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InfoLuzType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoLuzType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Potencia" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia"/&gt;
 *         &lt;element name="DiscHoraria" type="{http://xmlns.endesa.com/CommonSchemasNeol}DiscHoraria"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoLuzType", propOrder = {
    "potencia",
    "discHoraria"
})
public class InfoLuzType {

    @XmlElement(name = "Potencia", required = true)
    protected BigDecimal potencia;
    @XmlElement(name = "DiscHoraria", required = true)
    protected String discHoraria;

    /**
     * Gets the value of the potencia property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotencia() {
        return potencia;
    }

    /**
     * Sets the value of the potencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotencia(BigDecimal value) {
        this.potencia = value;
    }

    /**
     * Gets the value of the discHoraria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscHoraria() {
        return discHoraria;
    }

    /**
     * Sets the value of the discHoraria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscHoraria(String value) {
        this.discHoraria = value;
    }

}
