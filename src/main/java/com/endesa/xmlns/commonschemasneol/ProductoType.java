
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdTitularAsociado" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCliente" minOccurs="0"/&gt;
 *         &lt;element name="IdContratoAsociado" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdContrato" minOccurs="0"/&gt;
 *         &lt;element name="TipoProducto" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoProducto" minOccurs="0"/&gt;
 *         &lt;element name="Configuracion" type="{http://xmlns.endesa.com/CommonSchemasNeol}MapType" minOccurs="0"/&gt;
 *         &lt;element name="LineaNegocio" type="{http://xmlns.endesa.com/CommonSchemasNeol}LineaNegocio" minOccurs="0"/&gt;
 *         &lt;element name="ContratoAsociado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="DetalleProducto" type="{http://xmlns.endesa.com/CommonSchemasNeol}DetalleProducto" minOccurs="0"/&gt;
 *         &lt;element name="Descripcion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Comentario" minOccurs="0"/&gt;
 *         &lt;element name="IdProducto" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdProducto" minOccurs="0"/&gt;
 *         &lt;element name="IsFullOnline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductoType", propOrder = {
    "idTitularAsociado",
    "idContratoAsociado",
    "tipoProducto",
    "configuracion",
    "lineaNegocio",
    "contratoAsociado",
    "detalleProducto",
    "descripcion",
    "idProducto",
    "isFullOnline"
})
public class ProductoType {

    @XmlElement(name = "IdTitularAsociado")
    protected String idTitularAsociado;
    @XmlElement(name = "IdContratoAsociado")
    protected String idContratoAsociado;
    @XmlElement(name = "TipoProducto")
    protected String tipoProducto;
    @XmlElement(name = "Configuracion")
    protected MapType configuracion;
    @XmlElement(name = "LineaNegocio")
    protected String lineaNegocio;
    @XmlElement(name = "ContratoAsociado")
    protected Boolean contratoAsociado;
    @XmlElement(name = "DetalleProducto")
    protected String detalleProducto;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "IdProducto")
    protected String idProducto;
    @XmlElement(name = "IsFullOnline")
    protected Boolean isFullOnline;

    /**
     * Gets the value of the idTitularAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTitularAsociado() {
        return idTitularAsociado;
    }

    /**
     * Sets the value of the idTitularAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTitularAsociado(String value) {
        this.idTitularAsociado = value;
    }

    /**
     * Gets the value of the idContratoAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdContratoAsociado() {
        return idContratoAsociado;
    }

    /**
     * Sets the value of the idContratoAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdContratoAsociado(String value) {
        this.idContratoAsociado = value;
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
     * Gets the value of the configuracion property.
     * 
     * @return
     *     possible object is
     *     {@link MapType }
     *     
     */
    public MapType getConfiguracion() {
        return configuracion;
    }

    /**
     * Sets the value of the configuracion property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapType }
     *     
     */
    public void setConfiguracion(MapType value) {
        this.configuracion = value;
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
     * Gets the value of the contratoAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContratoAsociado() {
        return contratoAsociado;
    }

    /**
     * Sets the value of the contratoAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContratoAsociado(Boolean value) {
        this.contratoAsociado = value;
    }

    /**
     * Gets the value of the detalleProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetalleProducto() {
        return detalleProducto;
    }

    /**
     * Sets the value of the detalleProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetalleProducto(String value) {
        this.detalleProducto = value;
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
     * Gets the value of the isFullOnline property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsFullOnline() {
        return isFullOnline;
    }

    /**
     * Sets the value of the isFullOnline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsFullOnline(Boolean value) {
        this.isFullOnline = value;
    }

}
