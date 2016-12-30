
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RangoImporteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RangoImporteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ImporteMinimo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe"/&gt;
 *         &lt;element name="ImporteMaximo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangoImporteType", propOrder = {
    "importeMinimo",
    "importeMaximo"
})
public class RangoImporteType {

    @XmlElement(name = "ImporteMinimo", required = true)
    protected String importeMinimo;
    @XmlElement(name = "ImporteMaximo", required = true)
    protected String importeMaximo;

    /**
     * Gets the value of the importeMinimo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteMinimo() {
        return importeMinimo;
    }

    /**
     * Sets the value of the importeMinimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteMinimo(String value) {
        this.importeMinimo = value;
    }

    /**
     * Gets the value of the importeMaximo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteMaximo() {
        return importeMaximo;
    }

    /**
     * Sets the value of the importeMaximo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteMaximo(String value) {
        this.importeMaximo = value;
    }

}
