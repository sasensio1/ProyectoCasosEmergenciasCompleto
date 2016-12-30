
package org.example.sieme009_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for EventoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Tipo" type="{http://www.example.org/SIEME009_Schema/}Tip" minOccurs="0"/&gt;
 *         &lt;element name="NEvento" type="{http://www.example.org/SIEME009_Schema/}NEvento" minOccurs="0"/&gt;
 *         &lt;element name="Vecino" type="{http://www.example.org/SIEME009_Schema/}Vecino" minOccurs="0"/&gt;
 *         &lt;element name="Nincidencia" type="{http://www.example.org/SIEME009_Schema/}Nincidencia" minOccurs="0"/&gt;
 *         &lt;element name="Ndescargo" type="{http://www.example.org/SIEME009_Schema/}Ndescargo" minOccurs="0"/&gt;
 *         &lt;element name="FechaInicio" type="{http://www.example.org/SIEME009_Schema/}FechaInicio" minOccurs="0"/&gt;
 *         &lt;element name="FechaInicioProgramada" type="{http://www.example.org/SIEME009_Schema/}FechaInicioProgramada" minOccurs="0"/&gt;
 *         &lt;element name="FechaTerminoProgramada" type="{http://www.example.org/SIEME009_Schema/}FechaTerminoProgramada" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionTipoEvento" type="{http://www.example.org/SIEME009_Schema/}DescripcionTipoEvento" minOccurs="0"/&gt;
 *         &lt;element name="Comuna" type="{http://www.example.org/SIEME009_Schema/}Comuna" minOccurs="0"/&gt;
 *         &lt;element name="TituloDescargo" type="{http://www.example.org/SIEME009_Schema/}TituloDescargo" minOccurs="0"/&gt;
 *         &lt;element name="TipoIncidencia" type="{http://www.example.org/SIEME009_Schema/}TipoIncidencia" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventoType", propOrder = {
    "tipo",
    "nevento",
    "vecino",
    "nincidencia",
    "ndescargo",
    "fechaInicio",
    "fechaInicioProgramada",
    "fechaTerminoProgramada",
    "descripcionTipoEvento",
    "comuna",
    "tituloDescargo",
    "tipoIncidencia"
})
public class EventoType {

    @XmlElement(name = "Tipo")
    protected String tipo;
    @XmlElement(name = "NEvento")
    protected String nevento;
    @XmlElement(name = "Vecino")
    protected Boolean vecino;
    @XmlElement(name = "Nincidencia")
    protected String nincidencia;
    @XmlElement(name = "Ndescargo")
    protected String ndescargo;
    @XmlElement(name = "FechaInicio")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicio;
    @XmlElement(name = "FechaInicioProgramada")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioProgramada;
    @XmlElement(name = "FechaTerminoProgramada")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaTerminoProgramada;
    @XmlElement(name = "DescripcionTipoEvento")
    protected String descripcionTipoEvento;
    @XmlElement(name = "Comuna")
    protected String comuna;
    @XmlElement(name = "TituloDescargo")
    protected String tituloDescargo;
    @XmlElement(name = "TipoIncidencia")
    protected String tipoIncidencia;

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
     * Gets the value of the nEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNevento() {
        return nevento;
    }

    /**
     * Sets the value of the nEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNevento(String value) {
        this.nevento = value;
    }

    /**
     * Gets the value of the vecino property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVecino() {
        return vecino;
    }
    
    public Boolean getVecino() {
        return vecino;
    }

    /**
     * Sets the value of the vecino property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVecino(Boolean value) {
        this.vecino = value;
    }

    /**
     * Gets the value of the nincidencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNincidencia() {
        return nincidencia;
    }

    /**
     * Sets the value of the nincidencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNincidencia(String value) {
        this.nincidencia = value;
    }

    /**
     * Gets the value of the ndescargo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNdescargo() {
        return ndescargo;
    }

    /**
     * Sets the value of the ndescargo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNdescargo(String value) {
        this.ndescargo = value;
    }

    /**
     * Gets the value of the fechaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Sets the value of the fechaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicio(XMLGregorianCalendar value) {
        this.fechaInicio = value;
    }

    /**
     * Gets the value of the fechaInicioProgramada property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicioProgramada() {
        return fechaInicioProgramada;
    }

    /**
     * Sets the value of the fechaInicioProgramada property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicioProgramada(XMLGregorianCalendar value) {
        this.fechaInicioProgramada = value;
    }

    /**
     * Gets the value of the fechaTerminoProgramada property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaTerminoProgramada() {
        return fechaTerminoProgramada;
    }

    /**
     * Sets the value of the fechaTerminoProgramada property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaTerminoProgramada(XMLGregorianCalendar value) {
        this.fechaTerminoProgramada = value;
    }

    /**
     * Gets the value of the descripcionTipoEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionTipoEvento() {
        return descripcionTipoEvento;
    }

    /**
     * Sets the value of the descripcionTipoEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionTipoEvento(String value) {
        this.descripcionTipoEvento = value;
    }

    /**
     * Gets the value of the comuna property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Sets the value of the comuna property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComuna(String value) {
        this.comuna = value;
    }

    /**
     * Gets the value of the tituloDescargo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTituloDescargo() {
        return tituloDescargo;
    }

    /**
     * Sets the value of the tituloDescargo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTituloDescargo(String value) {
        this.tituloDescargo = value;
    }

    /**
     * Gets the value of the tipoIncidencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    /**
     * Sets the value of the tipoIncidencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoIncidencia(String value) {
        this.tipoIncidencia = value;
    }

}
