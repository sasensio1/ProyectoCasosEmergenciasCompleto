
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PromocionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PromocionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DetallePromocion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DetallePromocion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PromocionType", propOrder = {
    "detallePromocion"
})
public class PromocionType {

    @XmlElement(name = "DetallePromocion", required = true)
    protected String detallePromocion;

    /**
     * Gets the value of the detallePromocion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetallePromocion() {
        return detallePromocion;
    }

    /**
     * Sets the value of the detallePromocion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetallePromocion(String value) {
        this.detallePromocion = value;
    }

}
