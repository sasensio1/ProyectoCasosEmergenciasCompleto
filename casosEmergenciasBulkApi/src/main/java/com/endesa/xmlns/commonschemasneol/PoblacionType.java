
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PoblacionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PoblacionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodPoblacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodPoblacion" minOccurs="0"/&gt;
 *         &lt;element name="NombrePoblacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Poblacion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PoblacionType", propOrder = {
    "codPoblacion",
    "nombrePoblacion"
})
public class PoblacionType {

    @XmlElement(name = "CodPoblacion")
    protected String codPoblacion;
    @XmlElement(name = "NombrePoblacion")
    protected String nombrePoblacion;

    /**
     * Gets the value of the codPoblacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPoblacion() {
        return codPoblacion;
    }

    /**
     * Sets the value of the codPoblacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPoblacion(String value) {
        this.codPoblacion = value;
    }

    /**
     * Gets the value of the nombrePoblacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePoblacion() {
        return nombrePoblacion;
    }

    /**
     * Sets the value of the nombrePoblacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePoblacion(String value) {
        this.nombrePoblacion = value;
    }

}
