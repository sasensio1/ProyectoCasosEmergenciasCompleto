
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PeticionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeticionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCliente"/&gt;
 *         &lt;element name="IdGestion" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdGestion" minOccurs="0"/&gt;
 *         &lt;element name="NumGestion" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumContrato" minOccurs="0"/&gt;
 *         &lt;element name="TipoGestion" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoGestion" minOccurs="0"/&gt;
 *         &lt;element name="Tipologia" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoPeticion" minOccurs="0"/&gt;
 *         &lt;element name="Subtipologia" type="{http://xmlns.endesa.com/CommonSchemasNeol}SubtipoPeticion" minOccurs="0"/&gt;
 *         &lt;element name="Estado" type="{http://xmlns.endesa.com/CommonSchemasNeol}Estado" minOccurs="0"/&gt;
 *         &lt;element name="Fecha" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="Direccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="TipoProducto" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoProducto" minOccurs="0"/&gt;
 *         &lt;element name="Alias" type="{http://xmlns.endesa.com/CommonSchemasNeol}Alias" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeticionType", propOrder = {
    "idCliente",
    "idGestion",
    "numGestion",
    "tipoGestion",
    "tipologia",
    "subtipologia",
    "estado",
    "fecha",
    "direccion",
    "tipoProducto",
    "alias"
})
public class PeticionType {

    @XmlElement(name = "IdCliente", required = true)
    protected String idCliente;
    @XmlElement(name = "IdGestion")
    protected String idGestion;
    @XmlElement(name = "NumGestion")
    protected String numGestion;
    @XmlElement(name = "TipoGestion")
    protected String tipoGestion;
    @XmlElement(name = "Tipologia")
    protected String tipologia;
    @XmlElement(name = "Subtipologia")
    protected String subtipologia;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "Fecha")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "Direccion")
    protected DireccionType direccion;
    @XmlElement(name = "TipoProducto")
    protected String tipoProducto;
    @XmlElement(name = "Alias")
    protected String alias;

    /**
     * Gets the value of the idCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCliente(String value) {
        this.idCliente = value;
    }

    /**
     * Gets the value of the idGestion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdGestion() {
        return idGestion;
    }

    /**
     * Sets the value of the idGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdGestion(String value) {
        this.idGestion = value;
    }

    /**
     * Gets the value of the numGestion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumGestion() {
        return numGestion;
    }

    /**
     * Sets the value of the numGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumGestion(String value) {
        this.numGestion = value;
    }

    /**
     * Gets the value of the tipoGestion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoGestion() {
        return tipoGestion;
    }

    /**
     * Sets the value of the tipoGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoGestion(String value) {
        this.tipoGestion = value;
    }

    /**
     * Gets the value of the tipologia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologia() {
        return tipologia;
    }

    /**
     * Sets the value of the tipologia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologia(String value) {
        this.tipologia = value;
    }

    /**
     * Gets the value of the subtipologia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtipologia() {
        return subtipologia;
    }

    /**
     * Sets the value of the subtipologia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtipologia(String value) {
        this.subtipologia = value;
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
     * Gets the value of the direccion property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccion() {
        return direccion;
    }

    /**
     * Sets the value of the direccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccion(DireccionType value) {
        this.direccion = value;
    }

    /**
     * Gets the value of the tipoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Sets the value of the tipoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProducto(String value) {
        this.tipoProducto = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

}
