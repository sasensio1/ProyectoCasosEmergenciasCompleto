
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SuministrosInteresType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SuministrosInteresType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Luz" type="{http://xmlns.endesa.com/CommonSchemasNeol}Luz"/&gt;
 *         &lt;element name="Gas" type="{http://xmlns.endesa.com/CommonSchemasNeol}Gas"/&gt;
 *         &lt;element name="STP" type="{http://xmlns.endesa.com/CommonSchemasNeol}STP"/&gt;
 *         &lt;element name="PSVA" type="{http://xmlns.endesa.com/CommonSchemasNeol}PSVA"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuministrosInteresType", propOrder = {
    "luz",
    "gas",
    "stp",
    "psva"
})
public class SuministrosInteresType {

    @XmlElement(name = "Luz")
    protected boolean luz;
    @XmlElement(name = "Gas")
    protected boolean gas;
    @XmlElement(name = "STP")
    protected boolean stp;
    @XmlElement(name = "PSVA")
    protected boolean psva;

    /**
     * Gets the value of the luz property.
     * 
     */
    public boolean isLuz() {
        return luz;
    }

    /**
     * Sets the value of the luz property.
     * 
     */
    public void setLuz(boolean value) {
        this.luz = value;
    }

    /**
     * Gets the value of the gas property.
     * 
     */
    public boolean isGas() {
        return gas;
    }

    /**
     * Sets the value of the gas property.
     * 
     */
    public void setGas(boolean value) {
        this.gas = value;
    }

    /**
     * Gets the value of the stp property.
     * 
     */
    public boolean isSTP() {
        return stp;
    }

    /**
     * Sets the value of the stp property.
     * 
     */
    public void setSTP(boolean value) {
        this.stp = value;
    }

    /**
     * Gets the value of the psva property.
     * 
     */
    public boolean isPSVA() {
        return psva;
    }

    /**
     * Sets the value of the psva property.
     * 
     */
    public void setPSVA(boolean value) {
        this.psva = value;
    }

}
