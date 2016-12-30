
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContratoGestionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContratoGestionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Contrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}ContratoType"/&gt;
 *         &lt;element name="TipoGestion" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoGestion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContratoGestionType", propOrder = {
    "contrato",
    "tipoGestion"
})
public class ContratoGestionType {

    @XmlElement(name = "Contrato", required = true)
    protected ContratoType contrato;
    @XmlElement(name = "TipoGestion", required = true)
    protected String tipoGestion;

    /**
     * Gets the value of the contrato property.
     * 
     * @return
     *     possible object is
     *     {@link ContratoType }
     *     
     */
    public ContratoType getContrato() {
        return contrato;
    }

    /**
     * Sets the value of the contrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContratoType }
     *     
     */
    public void setContrato(ContratoType value) {
        this.contrato = value;
    }

    /**
     * Gets the value of the tipoGestion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoGestion() {
        return tipoGestion;
    }

    /**
     * Sets the value of the tipoGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoGestion(String value) {
        this.tipoGestion = value;
    }

}
