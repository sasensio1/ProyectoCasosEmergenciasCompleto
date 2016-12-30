
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InfoCalidadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoCalidadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Email" type="{http://xmlns.endesa.com/CommonSchemasNeol}Email"/&gt;
 *         &lt;element name="Alias" type="{http://xmlns.endesa.com/CommonSchemasNeol}Alias" minOccurs="0"/&gt;
 *         &lt;element name="EstadoRobinson" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="EstadoUsuario" type="{http://xmlns.endesa.com/CommonSchemasNeol}EstadoUsuario" minOccurs="0"/&gt;
 *         &lt;element name="FechaAlta" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="FechaBaja" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="UltFechaCambio" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="LOPD" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IdUsuario" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdUsuario" minOccurs="0"/&gt;
 *         &lt;element name="DatosOpcionales" type="{http://xmlns.endesa.com/CommonSchemasNeol}DatosOpcionales" minOccurs="0"/&gt;
 *         &lt;element name="IndCalidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}IndCalidad"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoCalidadType", propOrder = {
    "email",
    "alias",
    "estadoRobinson",
    "estadoUsuario",
    "fechaAlta",
    "fechaBaja",
    "ultFechaCambio",
    "lopd",
    "idUsuario",
    "datosOpcionales",
    "indCalidad"
})
public class InfoCalidadType {

    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "Alias")
    protected String alias;
    @XmlElement(name = "EstadoRobinson")
    protected Boolean estadoRobinson;
    @XmlElement(name = "EstadoUsuario")
    protected String estadoUsuario;
    @XmlElement(name = "FechaAlta")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAlta;
    @XmlElement(name = "FechaBaja")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaBaja;
    @XmlElement(name = "UltFechaCambio")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ultFechaCambio;
    @XmlElement(name = "LOPD")
    protected Boolean lopd;
    @XmlElement(name = "IdUsuario")
    protected String idUsuario;
    @XmlElement(name = "DatosOpcionales")
    protected String datosOpcionales;
    @XmlElement(name = "IndCalidad", required = true)
    @XmlSchemaType(name = "string")
    protected IndCalidad indCalidad;

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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

    /**
     * Gets the value of the estadoRobinson property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEstadoRobinson() {
        return estadoRobinson;
    }

    /**
     * Sets the value of the estadoRobinson property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEstadoRobinson(Boolean value) {
        this.estadoRobinson = value;
    }

    /**
     * Gets the value of the estadoUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    /**
     * Sets the value of the estadoUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoUsuario(String value) {
        this.estadoUsuario = value;
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
     * Gets the value of the ultFechaCambio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUltFechaCambio() {
        return ultFechaCambio;
    }

    /**
     * Sets the value of the ultFechaCambio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUltFechaCambio(XMLGregorianCalendar value) {
        this.ultFechaCambio = value;
    }

    /**
     * Gets the value of the lopd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLOPD() {
        return lopd;
    }

    /**
     * Sets the value of the lopd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLOPD(Boolean value) {
        this.lopd = value;
    }

    /**
     * Gets the value of the idUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Sets the value of the idUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUsuario(String value) {
        this.idUsuario = value;
    }

    /**
     * Gets the value of the datosOpcionales property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatosOpcionales() {
        return datosOpcionales;
    }

    /**
     * Sets the value of the datosOpcionales property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatosOpcionales(String value) {
        this.datosOpcionales = value;
    }

    /**
     * Gets the value of the indCalidad property.
     * 
     * @return
     *     possible object is
     *     {@link IndCalidad }
     *     
     */
    public IndCalidad getIndCalidad() {
        return indCalidad;
    }

    /**
     * Sets the value of the indCalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndCalidad }
     *     
     */
    public void setIndCalidad(IndCalidad value) {
        this.indCalidad = value;
    }

}
