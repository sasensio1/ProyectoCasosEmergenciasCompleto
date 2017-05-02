
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatosFacturacionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatosFacturacionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TipoCuenta" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoCuenta" minOccurs="0"/&gt;
 *         &lt;element name="Entidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdEntidad" minOccurs="0"/&gt;
 *         &lt;element name="Sucursal" type="{http://xmlns.endesa.com/CommonSchemasNeol}Sucursal" minOccurs="0"/&gt;
 *         &lt;element name="DC" type="{http://xmlns.endesa.com/CommonSchemasNeol}DigitoControl" minOccurs="0"/&gt;
 *         &lt;element name="NumeroCuenta" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumCuenta" minOccurs="0"/&gt;
 *         &lt;element name="DireccionFacturacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="Domiciliada" type="{http://xmlns.endesa.com/CommonSchemasNeol}MetodoPuestaCobro" minOccurs="0"/&gt;
 *         &lt;element name="IBAN" type="{http://xmlns.endesa.com/CommonSchemasNeol}IBAN" minOccurs="0"/&gt;
 *         &lt;element name="BIC" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoBIC" minOccurs="0"/&gt;
 *         &lt;element name="FormaPago" type="{http://xmlns.endesa.com/CommonSchemasNeol}FormaPago" minOccurs="0"/&gt;
 *         &lt;element name="PerteneceCuentaComercialPrincipal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosFacturacionType", propOrder = {
    "tipoCuenta",
    "entidad",
    "sucursal",
    "dc",
    "numeroCuenta",
    "direccionFacturacion",
    "domiciliada",
    "iban",
    "bic",
    "formaPago",
    "perteneceCuentaComercialPrincipal"
})
public class DatosFacturacionType {

    @XmlElement(name = "TipoCuenta")
    protected String tipoCuenta;
    @XmlElement(name = "Entidad")
    protected String entidad;
    @XmlElement(name = "Sucursal")
    protected String sucursal;
    @XmlElement(name = "DC")
    protected String dc;
    @XmlElement(name = "NumeroCuenta")
    protected String numeroCuenta;
    @XmlElement(name = "DireccionFacturacion")
    protected DireccionType direccionFacturacion;
    @XmlElement(name = "Domiciliada")
    protected String domiciliada;
    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "BIC")
    protected String bic;
    @XmlElement(name = "FormaPago")
    protected String formaPago;
    @XmlElement(name = "PerteneceCuentaComercialPrincipal")
    protected Boolean perteneceCuentaComercialPrincipal;

    /**
     * Gets the value of the tipoCuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Sets the value of the tipoCuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCuenta(String value) {
        this.tipoCuenta = value;
    }

    /**
     * Gets the value of the entidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * Sets the value of the entidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntidad(String value) {
        this.entidad = value;
    }

    /**
     * Gets the value of the sucursal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * Sets the value of the sucursal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSucursal(String value) {
        this.sucursal = value;
    }

    /**
     * Gets the value of the dc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDC() {
        return dc;
    }

    /**
     * Sets the value of the dc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDC(String value) {
        this.dc = value;
    }

    /**
     * Gets the value of the numeroCuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Sets the value of the numeroCuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCuenta(String value) {
        this.numeroCuenta = value;
    }

    /**
     * Gets the value of the direccionFacturacion property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionFacturacion() {
        return direccionFacturacion;
    }

    /**
     * Sets the value of the direccionFacturacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionFacturacion(DireccionType value) {
        this.direccionFacturacion = value;
    }

    /**
     * Gets the value of the domiciliada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomiciliada() {
        return domiciliada;
    }

    /**
     * Sets the value of the domiciliada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomiciliada(String value) {
        this.domiciliada = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIC() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIC(String value) {
        this.bic = value;
    }

    /**
     * Gets the value of the formaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the perteneceCuentaComercialPrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPerteneceCuentaComercialPrincipal() {
        return perteneceCuentaComercialPrincipal;
    }

    /**
     * Sets the value of the perteneceCuentaComercialPrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPerteneceCuentaComercialPrincipal(Boolean value) {
        this.perteneceCuentaComercialPrincipal = value;
    }

}
