
package com.endesa.xmlns.commonschemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MCDERROR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MCDERROR"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodigoError" type="{http://xmlns.endesa.com/CommonSchemas}CodigoError"/&gt;
 *         &lt;element name="MensajeError" type="{http://xmlns.endesa.com/CommonSchemas}MensajeError"/&gt;
 *         &lt;element name="TipoError" type="{http://xmlns.endesa.com/CommonSchemas}TipoError"/&gt;
 *         &lt;element name="FechaHora" type="{http://xmlns.endesa.com/CommonSchemas}FechaHora"/&gt;
 *         &lt;element name="Programa" type="{http://xmlns.endesa.com/CommonSchemas}Programa"/&gt;
 *         &lt;element name="Funcion" type="{http://xmlns.endesa.com/CommonSchemas}Funcion"/&gt;
 *         &lt;element name="Traza" type="{http://xmlns.endesa.com/CommonSchemas}Traza" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MCDERROR", propOrder = {
    "codigoError",
    "mensajeError",
    "tipoError",
    "fechaHora",
    "programa",
    "funcion",
    "traza"
})
public class MCDERROR {

    @XmlElement(name = "CodigoError", required = true)
    protected String codigoError;
    @XmlElement(name = "MensajeError", required = true)
    protected String mensajeError;
    @XmlElement(name = "TipoError", required = true)
    protected String tipoError;
    @XmlElement(name = "FechaHora", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHora;
    @XmlElement(name = "Programa", required = true)
    protected String programa;
    @XmlElement(name = "Funcion", required = true)
    protected String funcion;
    @XmlElement(name = "Traza")
    protected String traza;

    /**
     * Gets the value of the codigoError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Sets the value of the codigoError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoError(String value) {
        this.codigoError = value;
    }

    /**
     * Gets the value of the mensajeError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * Sets the value of the mensajeError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeError(String value) {
        this.mensajeError = value;
    }

    /**
     * Gets the value of the tipoError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoError() {
        return tipoError;
    }

    /**
     * Sets the value of the tipoError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoError(String value) {
        this.tipoError = value;
    }

    /**
     * Gets the value of the fechaHora property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Sets the value of the fechaHora property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHora(XMLGregorianCalendar value) {
        this.fechaHora = value;
    }

    /**
     * Gets the value of the programa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * Sets the value of the programa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrograma(String value) {
        this.programa = value;
    }

    /**
     * Gets the value of the funcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncion() {
        return funcion;
    }

    /**
     * Sets the value of the funcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncion(String value) {
        this.funcion = value;
    }

    /**
     * Gets the value of the traza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraza() {
        return traza;
    }

    /**
     * Sets the value of the traza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraza(String value) {
        this.traza = value;
    }

}
