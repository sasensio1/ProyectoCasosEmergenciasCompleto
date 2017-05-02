
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CoordenadasType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoordenadasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Latitud" type="{http://xmlns.endesa.com/CommonSchemasNeol}Latitud" minOccurs="0"/&gt;
 *         &lt;element name="Longitud" type="{http://xmlns.endesa.com/CommonSchemasNeol}Longitud" minOccurs="0"/&gt;
 *         &lt;element name="RangoMaxAccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}RangoAccion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoordenadasType", propOrder = {
    "latitud",
    "longitud",
    "rangoMaxAccion"
})
public class CoordenadasType {

    @XmlElement(name = "Latitud")
    protected String latitud;
    @XmlElement(name = "Longitud")
    protected String longitud;
    @XmlElement(name = "RangoMaxAccion")
    protected String rangoMaxAccion;

    /**
     * Gets the value of the latitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * Sets the value of the latitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitud(String value) {
        this.latitud = value;
    }

    /**
     * Gets the value of the longitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * Sets the value of the longitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitud(String value) {
        this.longitud = value;
    }

    /**
     * Gets the value of the rangoMaxAccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRangoMaxAccion() {
        return rangoMaxAccion;
    }

    /**
     * Sets the value of the rangoMaxAccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRangoMaxAccion(String value) {
        this.rangoMaxAccion = value;
    }

}
