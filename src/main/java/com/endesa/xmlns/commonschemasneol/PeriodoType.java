
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PeriodoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IniPeriodo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha"/&gt;
 *         &lt;element name="FinPeriodo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodoType", propOrder = {
    "iniPeriodo",
    "finPeriodo"
})
public class PeriodoType {

    @XmlElement(name = "IniPeriodo", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar iniPeriodo;
    @XmlElement(name = "FinPeriodo", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar finPeriodo;

    /**
     * Gets the value of the iniPeriodo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIniPeriodo() {
        return iniPeriodo;
    }

    /**
     * Sets the value of the iniPeriodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIniPeriodo(XMLGregorianCalendar value) {
        this.iniPeriodo = value;
    }

    /**
     * Gets the value of the finPeriodo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinPeriodo() {
        return finPeriodo;
    }

    /**
     * Sets the value of the finPeriodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinPeriodo(XMLGregorianCalendar value) {
        this.finPeriodo = value;
    }

}
