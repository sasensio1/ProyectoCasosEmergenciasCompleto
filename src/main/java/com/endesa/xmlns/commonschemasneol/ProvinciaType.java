
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProvinciaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProvinciaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodProvincia" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodProvincia"/&gt;
 *         &lt;element name="NombreProvincia" type="{http://xmlns.endesa.com/CommonSchemasNeol}Provincia"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProvinciaType", propOrder = {
    "codProvincia",
    "nombreProvincia"
})
public class ProvinciaType {

    @XmlElement(name = "CodProvincia", required = true)
    protected String codProvincia;
    @XmlElement(name = "NombreProvincia", required = true)
    protected String nombreProvincia;

    /**
     * Gets the value of the codProvincia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodProvincia() {
        return codProvincia;
    }

    /**
     * Sets the value of the codProvincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodProvincia(String value) {
        this.codProvincia = value;
    }

    /**
     * Gets the value of the nombreProvincia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProvincia() {
        return nombreProvincia;
    }

    /**
     * Sets the value of the nombreProvincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProvincia(String value) {
        this.nombreProvincia = value;
    }

}
