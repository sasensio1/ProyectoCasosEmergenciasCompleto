
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for FacturaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacturaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdFactura" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdFactura"/&gt;
 *         &lt;element name="LineaNegocio" type="{http://xmlns.endesa.com/CommonSchemasNeol}LineaNegocio"/&gt;
 *         &lt;element name="AliasContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}Alias"/&gt;
 *         &lt;element name="DireccionContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType"/&gt;
 *         &lt;element name="NumFactura" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumFactura"/&gt;
 *         &lt;element name="Periodo" type="{http://xmlns.endesa.com/CommonSchemasNeol}PeriodoType"/&gt;
 *         &lt;element name="Importe" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe"/&gt;
 *         &lt;element name="Estado" type="{http://xmlns.endesa.com/CommonSchemasNeol}EstadoFactura"/&gt;
 *         &lt;element name="Vencimiento" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha"/&gt;
 *         &lt;element name="URL" type="{http://xmlns.endesa.com/CommonSchemasNeol}URL"/&gt;
 *         &lt;element name="TipoFactura" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoFactura"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacturaType", propOrder = {
    "idFactura",
    "lineaNegocio",
    "aliasContrato",
    "direccionContrato",
    "numFactura",
    "periodo",
    "importe",
    "estado",
    "vencimiento",
    "url",
    "tipoFactura"
})
public class FacturaType {

    @XmlElement(name = "IdFactura", required = true)
    protected String idFactura;
    @XmlElement(name = "LineaNegocio", required = true)
    protected String lineaNegocio;
    @XmlElement(name = "AliasContrato", required = true)
    protected String aliasContrato;
    @XmlElement(name = "DireccionContrato", required = true)
    protected DireccionType direccionContrato;
    @XmlElement(name = "NumFactura", required = true)
    protected String numFactura;
    @XmlElement(name = "Periodo", required = true)
    protected PeriodoType periodo;
    @XmlElement(name = "Importe", required = true)
    protected String importe;
    @XmlElement(name = "Estado", required = true)
    protected String estado;
    @XmlElement(name = "Vencimiento", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar vencimiento;
    @XmlElement(name = "URL", required = true)
    protected String url;
    @XmlElement(name = "TipoFactura", required = true)
    protected String tipoFactura;

    /**
     * Gets the value of the idFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFactura() {
        return idFactura;
    }

    /**
     * Sets the value of the idFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFactura(String value) {
        this.idFactura = value;
    }

    /**
     * Gets the value of the lineaNegocio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineaNegocio() {
        return lineaNegocio;
    }

    /**
     * Sets the value of the lineaNegocio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineaNegocio(String value) {
        this.lineaNegocio = value;
    }

    /**
     * Gets the value of the aliasContrato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasContrato() {
        return aliasContrato;
    }

    /**
     * Sets the value of the aliasContrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasContrato(String value) {
        this.aliasContrato = value;
    }

    /**
     * Gets the value of the direccionContrato property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionContrato() {
        return direccionContrato;
    }

    /**
     * Sets the value of the direccionContrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionContrato(DireccionType value) {
        this.direccionContrato = value;
    }

    /**
     * Gets the value of the numFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumFactura() {
        return numFactura;
    }

    /**
     * Sets the value of the numFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumFactura(String value) {
        this.numFactura = value;
    }

    /**
     * Gets the value of the periodo property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodoType }
     *     
     */
    public PeriodoType getPeriodo() {
        return periodo;
    }

    /**
     * Sets the value of the periodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodoType }
     *     
     */
    public void setPeriodo(PeriodoType value) {
        this.periodo = value;
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
     * Gets the value of the vencimiento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVencimiento() {
        return vencimiento;
    }

    /**
     * Sets the value of the vencimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVencimiento(XMLGregorianCalendar value) {
        this.vencimiento = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the tipoFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoFactura() {
        return tipoFactura;
    }

    /**
     * Sets the value of the tipoFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoFactura(String value) {
        this.tipoFactura = value;
    }

}
