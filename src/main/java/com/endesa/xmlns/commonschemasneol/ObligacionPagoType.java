
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ObligacionPagoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObligacionPagoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdObligacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdObligacion" minOccurs="0"/&gt;
 *         &lt;element name="NumObligacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumObligacion" minOccurs="0"/&gt;
 *         &lt;element name="Importe" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe" minOccurs="0"/&gt;
 *         &lt;element name="Fecha" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="Estado" type="{http://xmlns.endesa.com/CommonSchemasNeol}Estado" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObligacionPagoType", propOrder = {
    "idObligacion",
    "numObligacion",
    "importe",
    "fecha",
    "estado"
})
public class ObligacionPagoType {

    @XmlElement(name = "IdObligacion")
    protected String idObligacion;
    @XmlElement(name = "NumObligacion")
    protected String numObligacion;
    @XmlElement(name = "Importe")
    protected String importe;
    @XmlElement(name = "Fecha")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "Estado")
    protected String estado;

    /**
     * Gets the value of the idObligacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdObligacion() {
        return idObligacion;
    }

    /**
     * Sets the value of the idObligacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdObligacion(String value) {
        this.idObligacion = value;
    }

    /**
     * Gets the value of the numObligacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumObligacion() {
        return numObligacion;
    }

    /**
     * Sets the value of the numObligacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumObligacion(String value) {
        this.numObligacion = value;
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
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

}
