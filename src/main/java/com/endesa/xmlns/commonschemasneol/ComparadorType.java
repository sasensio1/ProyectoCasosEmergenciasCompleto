
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComparadorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComparadorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UsoSuministro" type="{http://xmlns.endesa.com/CommonSchemasNeol}Segmento"/&gt;
 *         &lt;element name="ComercializadoraLuz" type="{http://xmlns.endesa.com/CommonSchemasNeol}Comercializadora"/&gt;
 *         &lt;element name="TarifaLuz" type="{http://xmlns.endesa.com/CommonSchemasNeol}Tarifa"/&gt;
 *         &lt;element name="ComercializadoraGas" type="{http://xmlns.endesa.com/CommonSchemasNeol}Comercializadora"/&gt;
 *         &lt;element name="TarifaGas" type="{http://xmlns.endesa.com/CommonSchemasNeol}Tarifa"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComparadorType", propOrder = {
    "usoSuministro",
    "comercializadoraLuz",
    "tarifaLuz",
    "comercializadoraGas",
    "tarifaGas"
})
public class ComparadorType {

    @XmlElement(name = "UsoSuministro", required = true)
    protected String usoSuministro;
    @XmlElement(name = "ComercializadoraLuz", required = true)
    protected String comercializadoraLuz;
    @XmlElement(name = "TarifaLuz", required = true)
    protected String tarifaLuz;
    @XmlElement(name = "ComercializadoraGas", required = true)
    protected String comercializadoraGas;
    @XmlElement(name = "TarifaGas", required = true)
    protected String tarifaGas;

    /**
     * Gets the value of the usoSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsoSuministro() {
        return usoSuministro;
    }

    /**
     * Sets the value of the usoSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsoSuministro(String value) {
        this.usoSuministro = value;
    }

    /**
     * Gets the value of the comercializadoraLuz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComercializadoraLuz() {
        return comercializadoraLuz;
    }

    /**
     * Sets the value of the comercializadoraLuz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComercializadoraLuz(String value) {
        this.comercializadoraLuz = value;
    }

    /**
     * Gets the value of the tarifaLuz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarifaLuz() {
        return tarifaLuz;
    }

    /**
     * Sets the value of the tarifaLuz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarifaLuz(String value) {
        this.tarifaLuz = value;
    }

    /**
     * Gets the value of the comercializadoraGas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComercializadoraGas() {
        return comercializadoraGas;
    }

    /**
     * Sets the value of the comercializadoraGas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComercializadoraGas(String value) {
        this.comercializadoraGas = value;
    }

    /**
     * Gets the value of the tarifaGas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarifaGas() {
        return tarifaGas;
    }

    /**
     * Sets the value of the tarifaGas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarifaGas(String value) {
        this.tarifaGas = value;
    }

}
