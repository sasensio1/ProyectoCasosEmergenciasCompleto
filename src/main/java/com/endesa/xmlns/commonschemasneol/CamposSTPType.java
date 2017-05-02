
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CamposSTPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CamposSTPType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CUPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}CUPS" minOccurs="0"/&gt;
 *         &lt;element name="Cantidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}Cantidad" minOccurs="0"/&gt;
 *         &lt;element name="Tipo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Tipo" minOccurs="0"/&gt;
 *         &lt;element name="Marca" type="{http://xmlns.endesa.com/CommonSchemasNeol}Marca" minOccurs="0"/&gt;
 *         &lt;element name="DireccionPs" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="Estado" type="{http://xmlns.endesa.com/CommonSchemasNeol}Estado" minOccurs="0"/&gt;
 *         &lt;element name="FechaInstalacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CamposSTPType", propOrder = {
    "cups",
    "cantidad",
    "tipo",
    "marca",
    "direccionPs",
    "estado",
    "fechaInstalacion"
})
public class CamposSTPType {

    @XmlElement(name = "CUPS")
    protected String cups;
    @XmlElement(name = "Cantidad")
    protected String cantidad;
    @XmlElement(name = "Tipo")
    protected String tipo;
    @XmlElement(name = "Marca")
    protected String marca;
    @XmlElement(name = "DireccionPs")
    protected DireccionType direccionPs;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "FechaInstalacion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInstalacion;

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
     * Gets the value of the cantidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantidad(String value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the marca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Sets the value of the marca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarca(String value) {
        this.marca = value;
    }

    /**
     * Gets the value of the direccionPs property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionPs() {
        return direccionPs;
    }

    /**
     * Sets the value of the direccionPs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionPs(DireccionType value) {
        this.direccionPs = value;
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

    /**
     * Gets the value of the fechaInstalacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInstalacion() {
        return fechaInstalacion;
    }

    /**
     * Sets the value of the fechaInstalacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInstalacion(XMLGregorianCalendar value) {
        this.fechaInstalacion = value;
    }

}
