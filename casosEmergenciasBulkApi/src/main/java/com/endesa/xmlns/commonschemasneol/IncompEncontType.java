
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IncompEncontType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IncompEncontType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DetalleListaIncompa" type="{http://xmlns.endesa.com/CommonSchemasNeol}DetalleListaIncompa" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IncompEncontType", propOrder = {
    "detalleListaIncompa"
})
public class IncompEncontType {

    @XmlElement(name = "DetalleListaIncompa")
    protected String detalleListaIncompa;

    /**
     * Gets the value of the detalleListaIncompa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetalleListaIncompa() {
        return detalleListaIncompa;
    }

    /**
     * Sets the value of the detalleListaIncompa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetalleListaIncompa(String value) {
        this.detalleListaIncompa = value;
    }

}
