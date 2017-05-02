
package org.example.sieme002_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdCalle" type="{http://www.example.org/SIEME002_Schema/}IdCalle" minOccurs="0"/&gt;
 *         &lt;element name="NombreCalle" type="{http://www.example.org/SIEME002_Schema/}NombreCalle" minOccurs="0"/&gt;
 *         &lt;element name="TipoCalle" type="{http://www.example.org/SIEME002_Schema/}TipoCalle" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalleType", propOrder = {
    "idCalle",
    "nombreCalle",
    "tipoCalle"
})
public class CalleType {

    @XmlElement(name = "IdCalle")
    protected String idCalle;
    @XmlElement(name = "NombreCalle")
    protected String nombreCalle;
    @XmlElement(name = "TipoCalle")
    protected String tipoCalle;

    /**
     * Gets the value of the idCalle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCalle() {
        return idCalle;
    }

    /**
     * Sets the value of the idCalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCalle(String value) {
        this.idCalle = value;
    }

    /**
     * Gets the value of the nombreCalle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCalle() {
        return nombreCalle;
    }

    /**
     * Sets the value of the nombreCalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCalle(String value) {
        this.nombreCalle = value;
    }

    /**
     * Gets the value of the tipoCalle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCalle() {
        return tipoCalle;
    }

    /**
     * Sets the value of the tipoCalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCalle(String value) {
        this.tipoCalle = value;
    }

}
