
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DescuentoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DescuentoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DetalleDescuento" type="{http://xmlns.endesa.com/CommonSchemasNeol}DetalleDescuento"/&gt;
 *         &lt;element name="IdDescuento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescuentoType", propOrder = {
    "detalleDescuento",
    "idDescuento"
})
public class DescuentoType {

    @XmlElement(name = "DetalleDescuento", required = true)
    protected String detalleDescuento;
    @XmlElement(name = "IdDescuento", required = true)
    protected String idDescuento;

    /**
     * Gets the value of the detalleDescuento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetalleDescuento() {
        return detalleDescuento;
    }

    /**
     * Sets the value of the detalleDescuento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetalleDescuento(String value) {
        this.detalleDescuento = value;
    }

    /**
     * Gets the value of the idDescuento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDescuento() {
        return idDescuento;
    }

    /**
     * Sets the value of the idDescuento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDescuento(String value) {
        this.idDescuento = value;
    }

}
