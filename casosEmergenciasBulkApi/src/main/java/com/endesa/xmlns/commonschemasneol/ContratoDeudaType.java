
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContratoDeudaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContratoDeudaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumContrato"/&gt;
 *         &lt;element name="ImporteDeudaAcumulada" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContratoDeudaType", propOrder = {
    "numContrato",
    "importeDeudaAcumulada"
})
public class ContratoDeudaType {

    @XmlElement(name = "NumContrato", required = true)
    protected String numContrato;
    @XmlElement(name = "ImporteDeudaAcumulada", required = true)
    protected String importeDeudaAcumulada;

    /**
     * Gets the value of the numContrato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumContrato() {
        return numContrato;
    }

    /**
     * Sets the value of the numContrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumContrato(String value) {
        this.numContrato = value;
    }

    /**
     * Gets the value of the importeDeudaAcumulada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteDeudaAcumulada() {
        return importeDeudaAcumulada;
    }

    /**
     * Sets the value of the importeDeudaAcumulada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteDeudaAcumulada(String value) {
        this.importeDeudaAcumulada = value;
    }

}
