
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CuentaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CuentaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SelectorAlias" type="{http://xmlns.endesa.com/CommonSchemasNeol}SelectorAlias"/&gt;
 *         &lt;element name="Alias" type="{http://xmlns.endesa.com/CommonSchemasNeol}Alias"/&gt;
 *         &lt;element name="Banco" type="{http://xmlns.endesa.com/CommonSchemasNeol}Banco"/&gt;
 *         &lt;element name="Oficina" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdOficina"/&gt;
 *         &lt;element name="DigitoControl" type="{http://xmlns.endesa.com/CommonSchemasNeol}DigitoControl"/&gt;
 *         &lt;element name="Cuenta" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumCuenta"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CuentaType", propOrder = {
    "selectorAlias",
    "alias",
    "banco",
    "oficina",
    "digitoControl",
    "cuenta"
})
public class CuentaType {

    @XmlElement(name = "SelectorAlias", required = true)
    protected String selectorAlias;
    @XmlElement(name = "Alias", required = true)
    protected String alias;
    @XmlElement(name = "Banco", required = true)
    protected String banco;
    @XmlElement(name = "Oficina", required = true)
    protected String oficina;
    @XmlElement(name = "DigitoControl", required = true)
    protected String digitoControl;
    @XmlElement(name = "Cuenta", required = true)
    protected String cuenta;

    /**
     * Gets the value of the selectorAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectorAlias() {
        return selectorAlias;
    }

    /**
     * Sets the value of the selectorAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectorAlias(String value) {
        this.selectorAlias = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Gets the value of the banco property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Sets the value of the banco property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanco(String value) {
        this.banco = value;
    }

    /**
     * Gets the value of the oficina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOficina() {
        return oficina;
    }

    /**
     * Sets the value of the oficina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOficina(String value) {
        this.oficina = value;
    }

    /**
     * Gets the value of the digitoControl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigitoControl() {
        return digitoControl;
    }

    /**
     * Sets the value of the digitoControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigitoControl(String value) {
        this.digitoControl = value;
    }

    /**
     * Gets the value of the cuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Sets the value of the cuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuenta(String value) {
        this.cuenta = value;
    }

}
