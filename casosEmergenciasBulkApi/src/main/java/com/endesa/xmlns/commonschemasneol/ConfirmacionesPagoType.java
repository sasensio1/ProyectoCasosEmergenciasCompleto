
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfirmacionesPagoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmacionesPagoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdObligacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdObligacion"/&gt;
 *         &lt;element name="Resultado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmacionesPagoType", propOrder = {
    "idObligacion",
    "resultado"
})
public class ConfirmacionesPagoType {

    @XmlElement(name = "IdObligacion", required = true)
    protected String idObligacion;
    @XmlElement(name = "Resultado")
    protected Boolean resultado;

    /**
     * Gets the value of the idObligacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdObligacion() {
        return idObligacion;
    }

    /**
     * Sets the value of the idObligacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdObligacion(String value) {
        this.idObligacion = value;
    }

    /**
     * Gets the value of the resultado property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isResultado() {
        return resultado;
    }

    /**
     * Sets the value of the resultado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResultado(Boolean value) {
        this.resultado = value;
    }

}
