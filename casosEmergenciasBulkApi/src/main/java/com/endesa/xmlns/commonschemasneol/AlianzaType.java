
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AlianzaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlianzaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdAlianza" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdAlianza" minOccurs="0"/&gt;
 *         &lt;element name="IdProducto" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdProducto" minOccurs="0"/&gt;
 *         &lt;element name="LineaNegocio" type="{http://xmlns.endesa.com/CommonSchemasNeol}LineaNegocio" minOccurs="0"/&gt;
 *         &lt;element name="Descripcion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Comentario" minOccurs="0"/&gt;
 *         &lt;element name="FechaAlta" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="FechaBaja" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="Proveedor" type="{http://xmlns.endesa.com/CommonSchemasNeol}Proveedor" minOccurs="0"/&gt;
 *         &lt;element name="TelefProveedor" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTelefono" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlianzaType", propOrder = {
    "idAlianza",
    "idProducto",
    "lineaNegocio",
    "descripcion",
    "fechaAlta",
    "fechaBaja",
    "proveedor",
    "telefProveedor"
})
public class AlianzaType {

    @XmlElement(name = "IdAlianza")
    protected String idAlianza;
    @XmlElement(name = "IdProducto")
    protected String idProducto;
    @XmlElement(name = "LineaNegocio")
    protected String lineaNegocio;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "FechaAlta")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAlta;
    @XmlElement(name = "FechaBaja")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaBaja;
    @XmlElement(name = "Proveedor")
    protected String proveedor;
    @XmlElement(name = "TelefProveedor")
    protected String telefProveedor;

    /**
     * Gets the value of the idAlianza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAlianza() {
        return idAlianza;
    }

    /**
     * Sets the value of the idAlianza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAlianza(String value) {
        this.idAlianza = value;
    }

    /**
     * Gets the value of the idProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the value of the idProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProducto(String value) {
        this.idProducto = value;
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
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
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
     * Gets the value of the fechaBaja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaBaja() {
        return fechaBaja;
    }

    /**
     * Sets the value of the fechaBaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaBaja(XMLGregorianCalendar value) {
        this.fechaBaja = value;
    }

    /**
     * Gets the value of the proveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Sets the value of the proveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProveedor(String value) {
        this.proveedor = value;
    }

    /**
     * Gets the value of the telefProveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefProveedor() {
        return telefProveedor;
    }

    /**
     * Sets the value of the telefProveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefProveedor(String value) {
        this.telefProveedor = value;
    }

}
