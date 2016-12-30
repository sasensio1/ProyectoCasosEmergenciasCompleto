
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InfoContratoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoContratoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumContratoPedido" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumContrato"/&gt;
 *         &lt;element name="NombreContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}Alias"/&gt;
 *         &lt;element name="DireccionContratoPedido" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType"/&gt;
 *         &lt;element name="EstadoContPedido" type="{http://xmlns.endesa.com/CommonSchemasNeol}Estado"/&gt;
 *         &lt;element name="LineasPedido" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ImporteUltFactura" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe"/&gt;
 *         &lt;element name="FechaAlta" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha"/&gt;
 *         &lt;element name="MotivoOfrecimiento" type="{http://xmlns.endesa.com/CommonSchemasNeol}MotivoOfrecimiento"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoContratoType", propOrder = {
    "numContratoPedido",
    "nombreContrato",
    "direccionContratoPedido",
    "estadoContPedido",
    "lineasPedido",
    "importeUltFactura",
    "fechaAlta",
    "motivoOfrecimiento"
})
public class InfoContratoType {

    @XmlElement(name = "NumContratoPedido", required = true)
    protected String numContratoPedido;
    @XmlElement(name = "NombreContrato", required = true)
    protected String nombreContrato;
    @XmlElement(name = "DireccionContratoPedido", required = true)
    protected DireccionType direccionContratoPedido;
    @XmlElement(name = "EstadoContPedido", required = true)
    protected String estadoContPedido;
    @XmlElement(name = "LineasPedido", required = true)
    protected String lineasPedido;
    @XmlElement(name = "ImporteUltFactura", required = true)
    protected String importeUltFactura;
    @XmlElement(name = "FechaAlta", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAlta;
    @XmlElement(name = "MotivoOfrecimiento", required = true)
    protected String motivoOfrecimiento;

    /**
     * Gets the value of the numContratoPedido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumContratoPedido() {
        return numContratoPedido;
    }

    /**
     * Sets the value of the numContratoPedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumContratoPedido(String value) {
        this.numContratoPedido = value;
    }

    /**
     * Gets the value of the nombreContrato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreContrato() {
        return nombreContrato;
    }

    /**
     * Sets the value of the nombreContrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreContrato(String value) {
        this.nombreContrato = value;
    }

    /**
     * Gets the value of the direccionContratoPedido property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionContratoPedido() {
        return direccionContratoPedido;
    }

    /**
     * Sets the value of the direccionContratoPedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionContratoPedido(DireccionType value) {
        this.direccionContratoPedido = value;
    }

    /**
     * Gets the value of the estadoContPedido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoContPedido() {
        return estadoContPedido;
    }

    /**
     * Sets the value of the estadoContPedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoContPedido(String value) {
        this.estadoContPedido = value;
    }

    /**
     * Gets the value of the lineasPedido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineasPedido() {
        return lineasPedido;
    }

    /**
     * Sets the value of the lineasPedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineasPedido(String value) {
        this.lineasPedido = value;
    }

    /**
     * Gets the value of the importeUltFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteUltFactura() {
        return importeUltFactura;
    }

    /**
     * Sets the value of the importeUltFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteUltFactura(String value) {
        this.importeUltFactura = value;
    }

    /**
     * Gets the value of the fechaAlta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Sets the value of the fechaAlta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAlta(XMLGregorianCalendar value) {
        this.fechaAlta = value;
    }

    /**
     * Gets the value of the motivoOfrecimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoOfrecimiento() {
        return motivoOfrecimiento;
    }

    /**
     * Sets the value of the motivoOfrecimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoOfrecimiento(String value) {
        this.motivoOfrecimiento = value;
    }

}
