
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ListaGestionesRealizadaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaGestionesRealizadaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FechaGestion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha"/&gt;
 *         &lt;element name="CodigoGestion" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoGestion"/&gt;
 *         &lt;element name="DescripcionGestion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionGestion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaGestionesRealizadaType", propOrder = {
    "fechaGestion",
    "codigoGestion",
    "descripcionGestion"
})
public class ListaGestionesRealizadaType {

    @XmlElement(name = "FechaGestion", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaGestion;
    @XmlElement(name = "CodigoGestion", required = true)
    protected String codigoGestion;
    @XmlElement(name = "DescripcionGestion", required = true)
    protected String descripcionGestion;

    /**
     * Gets the value of the fechaGestion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaGestion() {
        return fechaGestion;
    }

    /**
     * Sets the value of the fechaGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaGestion(XMLGregorianCalendar value) {
        this.fechaGestion = value;
    }

    /**
     * Gets the value of the codigoGestion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoGestion() {
        return codigoGestion;
    }

    /**
     * Sets the value of the codigoGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoGestion(String value) {
        this.codigoGestion = value;
    }

    /**
     * Gets the value of the descripcionGestion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionGestion() {
        return descripcionGestion;
    }

    /**
     * Sets the value of the descripcionGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionGestion(String value) {
        this.descripcionGestion = value;
    }

}
