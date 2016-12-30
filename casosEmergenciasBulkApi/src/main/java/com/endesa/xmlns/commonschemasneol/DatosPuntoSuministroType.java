
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatosPuntoSuministroType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatosPuntoSuministroType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodigoPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoPS" minOccurs="0"/&gt;
 *         &lt;element name="TipoPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoPS" minOccurs="0"/&gt;
 *         &lt;element name="CUPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}CUPS" minOccurs="0"/&gt;
 *         &lt;element name="IdCUPS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionPS" minOccurs="0"/&gt;
 *         &lt;element name="DireccionPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="TipoSuministro" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoSuministro" minOccurs="0"/&gt;
 *         &lt;element name="ClientProPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}ClientProPS" minOccurs="0"/&gt;
 *         &lt;element name="PSinCRM" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosPuntoSuministroType", propOrder = {
    "codigoPS",
    "tipoPS",
    "cups",
    "idCUPS",
    "descripcionPS",
    "direccionPS",
    "tipoSuministro",
    "clientProPS",
    "pSinCRM"
})
public class DatosPuntoSuministroType {

    @XmlElement(name = "CodigoPS")
    protected String codigoPS;
    @XmlElement(name = "TipoPS")
    protected String tipoPS;
    @XmlElement(name = "CUPS")
    protected String cups;
    @XmlElement(name = "IdCUPS")
    protected String idCUPS;
    @XmlElement(name = "DescripcionPS")
    protected String descripcionPS;
    @XmlElement(name = "DireccionPS")
    protected DireccionType direccionPS;
    @XmlElement(name = "TipoSuministro")
    protected String tipoSuministro;
    @XmlElement(name = "ClientProPS")
    protected String clientProPS;
    @XmlElement(name = "PSinCRM")
    protected Boolean pSinCRM;

    /**
     * Gets the value of the codigoPS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPS() {
        return codigoPS;
    }

    /**
     * Sets the value of the codigoPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPS(String value) {
        this.codigoPS = value;
    }

    /**
     * Gets the value of the tipoPS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPS() {
        return tipoPS;
    }

    /**
     * Sets the value of the tipoPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPS(String value) {
        this.tipoPS = value;
    }

    /**
     * Gets the value of the cups property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUPS() {
        return cups;
    }

    /**
     * Sets the value of the cups property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUPS(String value) {
        this.cups = value;
    }

    /**
     * Gets the value of the idCUPS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCUPS() {
        return idCUPS;
    }

    /**
     * Sets the value of the idCUPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCUPS(String value) {
        this.idCUPS = value;
    }

    /**
     * Gets the value of the descripcionPS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionPS() {
        return descripcionPS;
    }

    /**
     * Sets the value of the descripcionPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionPS(String value) {
        this.descripcionPS = value;
    }

    /**
     * Gets the value of the direccionPS property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionPS() {
        return direccionPS;
    }

    /**
     * Sets the value of the direccionPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionPS(DireccionType value) {
        this.direccionPS = value;
    }

    /**
     * Gets the value of the tipoSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSuministro() {
        return tipoSuministro;
    }

    /**
     * Sets the value of the tipoSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSuministro(String value) {
        this.tipoSuministro = value;
    }

    /**
     * Gets the value of the clientProPS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientProPS() {
        return clientProPS;
    }

    /**
     * Sets the value of the clientProPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientProPS(String value) {
        this.clientProPS = value;
    }

    /**
     * Gets the value of the pSinCRM property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPSinCRM() {
        return pSinCRM;
    }

    /**
     * Sets the value of the pSinCRM property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPSinCRM(Boolean value) {
        this.pSinCRM = value;
    }

}
