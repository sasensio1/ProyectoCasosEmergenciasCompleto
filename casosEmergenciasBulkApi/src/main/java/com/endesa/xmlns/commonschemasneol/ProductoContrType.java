
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductoContrType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductoContrType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdProducto" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdProducto"/&gt;
 *         &lt;element name="EquSTP" type="{http://xmlns.endesa.com/CommonSchemasNeol}EquSTPType" minOccurs="0"/&gt;
 *         &lt;element name="IdPromocion" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdPromocion" minOccurs="0"/&gt;
 *         &lt;element name="EmprComercializadora" type="{http://xmlns.endesa.com/CommonSchemasNeol}Empresa" minOccurs="0"/&gt;
 *         &lt;element name="CUPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}CUPS" minOccurs="0"/&gt;
 *         &lt;element name="TipoSolicitud" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoSolicitud" minOccurs="0"/&gt;
 *         &lt;element name="SubtipoSolicitud" type="{http://xmlns.endesa.com/CommonSchemasNeol}SubtipoSolicitud" minOccurs="0"/&gt;
 *         &lt;element name="TipoCambioTitular" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoCambioTitular" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductoContrType", propOrder = {
    "idProducto",
    "equSTP",
    "idPromocion",
    "emprComercializadora",
    "cups",
    "tipoSolicitud",
    "subtipoSolicitud",
    "tipoCambioTitular"
})
public class ProductoContrType {

    @XmlElement(name = "IdProducto", required = true)
    protected String idProducto;
    @XmlElement(name = "EquSTP")
    protected EquSTPType equSTP;
    @XmlElement(name = "IdPromocion")
    protected String idPromocion;
    @XmlElement(name = "EmprComercializadora")
    protected String emprComercializadora;
    @XmlElement(name = "CUPS")
    protected String cups;
    @XmlElement(name = "TipoSolicitud")
    protected String tipoSolicitud;
    @XmlElement(name = "SubtipoSolicitud")
    protected String subtipoSolicitud;
    @XmlElement(name = "TipoCambioTitular")
    protected String tipoCambioTitular;

    /**
     * Gets the value of the idProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the value of the idProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProducto(String value) {
        this.idProducto = value;
    }

    /**
     * Gets the value of the equSTP property.
     * 
     * @return
     *     possible object is
     *     {@link EquSTPType }
     *     
     */
    public EquSTPType getEquSTP() {
        return equSTP;
    }

    /**
     * Sets the value of the equSTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquSTPType }
     *     
     */
    public void setEquSTP(EquSTPType value) {
        this.equSTP = value;
    }

    /**
     * Gets the value of the idPromocion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPromocion() {
        return idPromocion;
    }

    /**
     * Sets the value of the idPromocion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPromocion(String value) {
        this.idPromocion = value;
    }

    /**
     * Gets the value of the emprComercializadora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmprComercializadora() {
        return emprComercializadora;
    }

    /**
     * Sets the value of the emprComercializadora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmprComercializadora(String value) {
        this.emprComercializadora = value;
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
     * Gets the value of the tipoSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    /**
     * Sets the value of the tipoSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSolicitud(String value) {
        this.tipoSolicitud = value;
    }

    /**
     * Gets the value of the subtipoSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtipoSolicitud() {
        return subtipoSolicitud;
    }

    /**
     * Sets the value of the subtipoSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtipoSolicitud(String value) {
        this.subtipoSolicitud = value;
    }

    /**
     * Gets the value of the tipoCambioTitular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCambioTitular() {
        return tipoCambioTitular;
    }

    /**
     * Sets the value of the tipoCambioTitular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCambioTitular(String value) {
        this.tipoCambioTitular = value;
    }

}
