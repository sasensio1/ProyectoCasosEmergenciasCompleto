
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GastoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GastoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ImporteGasto" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe"/&gt;
 *         &lt;element name="DetalleGasto" type="{http://xmlns.endesa.com/CommonSchemasNeol}Comentario" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GastoType", propOrder = {
    "importeGasto",
    "detalleGasto"
})
public class GastoType {

    @XmlElement(name = "ImporteGasto", required = true)
    protected String importeGasto;
    @XmlElement(name = "DetalleGasto")
    protected String detalleGasto;

    /**
     * Gets the value of the importeGasto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteGasto() {
        return importeGasto;
    }

    /**
     * Sets the value of the importeGasto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteGasto(String value) {
        this.importeGasto = value;
    }

    /**
     * Gets the value of the detalleGasto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetalleGasto() {
        return detalleGasto;
    }

    /**
     * Sets the value of the detalleGasto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetalleGasto(String value) {
        this.detalleGasto = value;
    }

}
