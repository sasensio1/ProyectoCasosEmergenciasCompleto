
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatosTarjetaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatosTarjetaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Titular" type="{http://xmlns.endesa.com/CommonSchemasNeol}Titular"/&gt;
 *         &lt;element name="NumTarjeta" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTarjeta"/&gt;
 *         &lt;element name="Importe" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe" minOccurs="0"/&gt;
 *         &lt;element name="NumSeguridad" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumSeguridad" minOccurs="0"/&gt;
 *         &lt;element name="MesCaducidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}Mes" minOccurs="0"/&gt;
 *         &lt;element name="AnioCaducidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}Anio" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosTarjetaType", propOrder = {
    "titular",
    "numTarjeta",
    "importe",
    "numSeguridad",
    "mesCaducidad",
    "anioCaducidad"
})
public class DatosTarjetaType {

    @XmlElement(name = "Titular", required = true)
    protected String titular;
    @XmlElement(name = "NumTarjeta", required = true)
    protected String numTarjeta;
    @XmlElement(name = "Importe")
    protected String importe;
    @XmlElement(name = "NumSeguridad")
    protected String numSeguridad;
    @XmlElement(name = "MesCaducidad")
    protected String mesCaducidad;
    @XmlElement(name = "AnioCaducidad")
    protected String anioCaducidad;

    /**
     * Gets the value of the titular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Sets the value of the titular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitular(String value) {
        this.titular = value;
    }

    /**
     * Gets the value of the numTarjeta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTarjeta() {
        return numTarjeta;
    }

    /**
     * Sets the value of the numTarjeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTarjeta(String value) {
        this.numTarjeta = value;
    }

    /**
     * Gets the value of the importe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporte() {
        return importe;
    }

    /**
     * Sets the value of the importe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporte(String value) {
        this.importe = value;
    }

    /**
     * Gets the value of the numSeguridad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeguridad() {
        return numSeguridad;
    }

    /**
     * Sets the value of the numSeguridad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeguridad(String value) {
        this.numSeguridad = value;
    }

    /**
     * Gets the value of the mesCaducidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesCaducidad() {
        return mesCaducidad;
    }

    /**
     * Sets the value of the mesCaducidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesCaducidad(String value) {
        this.mesCaducidad = value;
    }

    /**
     * Gets the value of the anioCaducidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnioCaducidad() {
        return anioCaducidad;
    }

    /**
     * Sets the value of the anioCaducidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnioCaducidad(String value) {
        this.anioCaducidad = value;
    }

}
