
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GrupoDocumentosAdjuntosType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrupoDocumentosAdjuntosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Aportada" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Comentario" type="{http://xmlns.endesa.com/CommonSchemasNeol}Comentario" minOccurs="0"/&gt;
 *         &lt;element name="Emisor" type="{http://xmlns.endesa.com/CommonSchemasNeol}Emisor" minOccurs="0"/&gt;
 *         &lt;element name="FechaAportacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="FechaEmision" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="FechaVigencia" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="NumeroDocumento" type="{http://xmlns.endesa.com/CommonSchemasNeol}Numerodocumento" minOccurs="0"/&gt;
 *         &lt;element name="TipoDocumento" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoDocumento" minOccurs="0"/&gt;
 *         &lt;element name="Url" type="{http://xmlns.endesa.com/CommonSchemasNeol}URL" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrupoDocumentosAdjuntosType", propOrder = {
    "aportada",
    "comentario",
    "emisor",
    "fechaAportacion",
    "fechaEmision",
    "fechaVigencia",
    "numeroDocumento",
    "tipoDocumento",
    "url"
})
public class GrupoDocumentosAdjuntosType {

    @XmlElement(name = "Aportada")
    protected Boolean aportada;
    @XmlElement(name = "Comentario")
    protected String comentario;
    @XmlElement(name = "Emisor")
    protected String emisor;
    @XmlElement(name = "FechaAportacion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAportacion;
    @XmlElement(name = "FechaEmision")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmision;
    @XmlElement(name = "FechaVigencia")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaVigencia;
    @XmlElement(name = "NumeroDocumento")
    protected String numeroDocumento;
    @XmlElement(name = "TipoDocumento")
    protected String tipoDocumento;
    @XmlElement(name = "Url")
    protected String url;

    /**
     * Gets the value of the aportada property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAportada() {
        return aportada;
    }

    /**
     * Sets the value of the aportada property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAportada(Boolean value) {
        this.aportada = value;
    }

    /**
     * Gets the value of the comentario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Sets the value of the comentario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentario(String value) {
        this.comentario = value;
    }

    /**
     * Gets the value of the emisor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * Sets the value of the emisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmisor(String value) {
        this.emisor = value;
    }

    /**
     * Gets the value of the fechaAportacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAportacion() {
        return fechaAportacion;
    }

    /**
     * Sets the value of the fechaAportacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAportacion(XMLGregorianCalendar value) {
        this.fechaAportacion = value;
    }

    /**
     * Gets the value of the fechaEmision property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Sets the value of the fechaEmision property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmision(XMLGregorianCalendar value) {
        this.fechaEmision = value;
    }

    /**
     * Gets the value of the fechaVigencia property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the value of the fechaVigencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaVigencia(XMLGregorianCalendar value) {
        this.fechaVigencia = value;
    }

    /**
     * Gets the value of the numeroDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Sets the value of the numeroDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Gets the value of the tipoDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Sets the value of the tipoDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumento(String value) {
        this.tipoDocumento = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
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
    public void setUrl(String value) {
        this.url = value;
    }

}
