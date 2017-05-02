
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidacionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidacionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodigoValidacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoValidacion" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionValidacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionValidacion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidacionType", propOrder = {
    "codigoValidacion",
    "descripcionValidacion"
})
public class ValidacionType {

    @XmlElement(name = "CodigoValidacion")
    protected String codigoValidacion;
    @XmlElement(name = "DescripcionValidacion")
    protected String descripcionValidacion;

    /**
     * Gets the value of the codigoValidacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    /**
     * Sets the value of the codigoValidacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoValidacion(String value) {
        this.codigoValidacion = value;
    }

    /**
     * Gets the value of the descripcionValidacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionValidacion() {
        return descripcionValidacion;
    }

    /**
     * Sets the value of the descripcionValidacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionValidacion(String value) {
        this.descripcionValidacion = value;
    }

}
