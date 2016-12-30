
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaginacionOutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaginacionOutType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdUltReg" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdEntidad"/&gt;
 *         &lt;element name="NumGestiones" type="{http://xmlns.endesa.com/CommonSchemasNeol}Numero"/&gt;
 *         &lt;element name="HayMasResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaginacionOutType", propOrder = {
    "idUltReg",
    "numGestiones",
    "hayMasResult"
})
public class PaginacionOutType {

    @XmlElement(name = "IdUltReg", required = true)
    protected String idUltReg;
    @XmlElement(name = "NumGestiones", required = true)
    protected String numGestiones;
    @XmlElement(name = "HayMasResult")
    protected boolean hayMasResult;

    /**
     * Gets the value of the idUltReg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUltReg() {
        return idUltReg;
    }

    /**
     * Sets the value of the idUltReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUltReg(String value) {
        this.idUltReg = value;
    }

    /**
     * Gets the value of the numGestiones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumGestiones() {
        return numGestiones;
    }

    /**
     * Sets the value of the numGestiones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumGestiones(String value) {
        this.numGestiones = value;
    }

    /**
     * Gets the value of the hayMasResult property.
     * 
     */
    public boolean isHayMasResult() {
        return hayMasResult;
    }

    /**
     * Sets the value of the hayMasResult property.
     * 
     */
    public void setHayMasResult(boolean value) {
        this.hayMasResult = value;
    }

}
