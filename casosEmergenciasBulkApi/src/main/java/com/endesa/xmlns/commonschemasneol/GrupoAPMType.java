
package com.endesa.xmlns.commonschemasneol;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GrupoAPMType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrupoAPMType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodigoAPM" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoAPM" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaInstalacionATKw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="FechaEmisionAPM" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="FechaCaducidadAPM" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="PotMaxAutorizadaAPMKw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrupoAPMType", propOrder = {
    "codigoAPM",
    "potenciaInstalacionATKw",
    "fechaEmisionAPM",
    "fechaCaducidadAPM",
    "potMaxAutorizadaAPMKw"
})
public class GrupoAPMType {

    @XmlElement(name = "CodigoAPM")
    protected String codigoAPM;
    @XmlElement(name = "PotenciaInstalacionATKw")
    protected BigDecimal potenciaInstalacionATKw;
    @XmlElement(name = "FechaEmisionAPM")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmisionAPM;
    @XmlElement(name = "FechaCaducidadAPM")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCaducidadAPM;
    @XmlElement(name = "PotMaxAutorizadaAPMKw")
    protected BigDecimal potMaxAutorizadaAPMKw;

    /**
     * Gets the value of the codigoAPM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoAPM() {
        return codigoAPM;
    }

    /**
     * Sets the value of the codigoAPM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoAPM(String value) {
        this.codigoAPM = value;
    }

    /**
     * Gets the value of the potenciaInstalacionATKw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaInstalacionATKw() {
        return potenciaInstalacionATKw;
    }

    /**
     * Sets the value of the potenciaInstalacionATKw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaInstalacionATKw(BigDecimal value) {
        this.potenciaInstalacionATKw = value;
    }

    /**
     * Gets the value of the fechaEmisionAPM property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmisionAPM() {
        return fechaEmisionAPM;
    }

    /**
     * Sets the value of the fechaEmisionAPM property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmisionAPM(XMLGregorianCalendar value) {
        this.fechaEmisionAPM = value;
    }

    /**
     * Gets the value of the fechaCaducidadAPM property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCaducidadAPM() {
        return fechaCaducidadAPM;
    }

    /**
     * Sets the value of the fechaCaducidadAPM property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCaducidadAPM(XMLGregorianCalendar value) {
        this.fechaCaducidadAPM = value;
    }

    /**
     * Gets the value of the potMaxAutorizadaAPMKw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotMaxAutorizadaAPMKw() {
        return potMaxAutorizadaAPMKw;
    }

    /**
     * Sets the value of the potMaxAutorizadaAPMKw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotMaxAutorizadaAPMKw(BigDecimal value) {
        this.potMaxAutorizadaAPMKw = value;
    }

}
