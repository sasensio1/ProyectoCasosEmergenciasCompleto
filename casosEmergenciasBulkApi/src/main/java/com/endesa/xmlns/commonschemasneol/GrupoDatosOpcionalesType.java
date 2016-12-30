
package com.endesa.xmlns.commonschemasneol;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GrupoDatosOpcionalesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrupoDatosOpcionalesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PotAdscritaAccesoKw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="FecLimiteDerAdscritos" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaBaja" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Perdidas" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaTransformadorKw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="TipoPuntoMedida" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoPuntoMedida" minOccurs="0"/&gt;
 *         &lt;element name="NCedulaHabitabilidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumeroCedulaHabitabilidad" minOccurs="0"/&gt;
 *         &lt;element name="FecExpedicionCedula" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="FecultimoCambioComerc" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="FechaultimaLectura" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="AmbitoValidezCIE" type="{http://xmlns.endesa.com/CommonSchemasNeol}AmbitoValidezCIE" minOccurs="0"/&gt;
 *         &lt;element name="ViviendaHabitual" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="FechaultimaRevision" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="ResultadoUltimaRevision" type="{http://xmlns.endesa.com/CommonSchemasNeol}Resultado" minOccurs="0"/&gt;
 *         &lt;element name="FechaUltimaInspeccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="ResultadoUltimaInspeccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Resultado" minOccurs="0"/&gt;
 *         &lt;element name="FianzaDistribuidora" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ImporteFianza" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe" minOccurs="0"/&gt;
 *         &lt;element name="Comentario" type="{http://xmlns.endesa.com/CommonSchemasNeol}Comentario" minOccurs="0"/&gt;
 *         &lt;element name="RedDistribucionGas" type="{http://xmlns.endesa.com/CommonSchemasNeol}RedDistribucionGas" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrupoDatosOpcionalesType", propOrder = {
    "potAdscritaAccesoKw",
    "fecLimiteDerAdscritos",
    "potenciaBaja",
    "perdidas",
    "potenciaTransformadorKw",
    "tipoPuntoMedida",
    "nCedulaHabitabilidad",
    "fecExpedicionCedula",
    "fecultimoCambioComerc",
    "fechaultimaLectura",
    "ambitoValidezCIE",
    "viviendaHabitual",
    "fechaultimaRevision",
    "resultadoUltimaRevision",
    "fechaUltimaInspeccion",
    "resultadoUltimaInspeccion",
    "fianzaDistribuidora",
    "importeFianza",
    "comentario",
    "redDistribucionGas"
})
public class GrupoDatosOpcionalesType {

    @XmlElement(name = "PotAdscritaAccesoKw")
    protected BigDecimal potAdscritaAccesoKw;
    @XmlElement(name = "FecLimiteDerAdscritos")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecLimiteDerAdscritos;
    @XmlElement(name = "PotenciaBaja")
    protected Boolean potenciaBaja;
    @XmlElement(name = "Perdidas")
    protected Boolean perdidas;
    @XmlElement(name = "PotenciaTransformadorKw")
    protected BigDecimal potenciaTransformadorKw;
    @XmlElement(name = "TipoPuntoMedida")
    protected String tipoPuntoMedida;
    @XmlElement(name = "NCedulaHabitabilidad")
    protected String nCedulaHabitabilidad;
    @XmlElement(name = "FecExpedicionCedula")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecExpedicionCedula;
    @XmlElement(name = "FecultimoCambioComerc")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecultimoCambioComerc;
    @XmlElement(name = "FechaultimaLectura")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaultimaLectura;
    @XmlElement(name = "AmbitoValidezCIE")
    protected String ambitoValidezCIE;
    @XmlElement(name = "ViviendaHabitual")
    protected Boolean viviendaHabitual;
    @XmlElement(name = "FechaultimaRevision")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaultimaRevision;
    @XmlElement(name = "ResultadoUltimaRevision")
    protected String resultadoUltimaRevision;
    @XmlElement(name = "FechaUltimaInspeccion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaUltimaInspeccion;
    @XmlElement(name = "ResultadoUltimaInspeccion")
    protected String resultadoUltimaInspeccion;
    @XmlElement(name = "FianzaDistribuidora")
    protected Boolean fianzaDistribuidora;
    @XmlElement(name = "ImporteFianza")
    protected String importeFianza;
    @XmlElement(name = "Comentario")
    protected String comentario;
    @XmlElement(name = "RedDistribucionGas")
    protected String redDistribucionGas;

    /**
     * Gets the value of the potAdscritaAccesoKw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotAdscritaAccesoKw() {
        return potAdscritaAccesoKw;
    }

    /**
     * Sets the value of the potAdscritaAccesoKw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotAdscritaAccesoKw(BigDecimal value) {
        this.potAdscritaAccesoKw = value;
    }

    /**
     * Gets the value of the fecLimiteDerAdscritos property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecLimiteDerAdscritos() {
        return fecLimiteDerAdscritos;
    }

    /**
     * Sets the value of the fecLimiteDerAdscritos property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecLimiteDerAdscritos(XMLGregorianCalendar value) {
        this.fecLimiteDerAdscritos = value;
    }

    /**
     * Gets the value of the potenciaBaja property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPotenciaBaja() {
        return potenciaBaja;
    }

    /**
     * Sets the value of the potenciaBaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPotenciaBaja(Boolean value) {
        this.potenciaBaja = value;
    }

    /**
     * Gets the value of the perdidas property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPerdidas() {
        return perdidas;
    }

    /**
     * Sets the value of the perdidas property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPerdidas(Boolean value) {
        this.perdidas = value;
    }

    /**
     * Gets the value of the potenciaTransformadorKw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaTransformadorKw() {
        return potenciaTransformadorKw;
    }

    /**
     * Sets the value of the potenciaTransformadorKw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaTransformadorKw(BigDecimal value) {
        this.potenciaTransformadorKw = value;
    }

    /**
     * Gets the value of the tipoPuntoMedida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPuntoMedida() {
        return tipoPuntoMedida;
    }

    /**
     * Sets the value of the tipoPuntoMedida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPuntoMedida(String value) {
        this.tipoPuntoMedida = value;
    }

    /**
     * Gets the value of the nCedulaHabitabilidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNCedulaHabitabilidad() {
        return nCedulaHabitabilidad;
    }

    /**
     * Sets the value of the nCedulaHabitabilidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNCedulaHabitabilidad(String value) {
        this.nCedulaHabitabilidad = value;
    }

    /**
     * Gets the value of the fecExpedicionCedula property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecExpedicionCedula() {
        return fecExpedicionCedula;
    }

    /**
     * Sets the value of the fecExpedicionCedula property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecExpedicionCedula(XMLGregorianCalendar value) {
        this.fecExpedicionCedula = value;
    }

    /**
     * Gets the value of the fecultimoCambioComerc property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecultimoCambioComerc() {
        return fecultimoCambioComerc;
    }

    /**
     * Sets the value of the fecultimoCambioComerc property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecultimoCambioComerc(XMLGregorianCalendar value) {
        this.fecultimoCambioComerc = value;
    }

    /**
     * Gets the value of the fechaultimaLectura property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaultimaLectura() {
        return fechaultimaLectura;
    }

    /**
     * Sets the value of the fechaultimaLectura property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaultimaLectura(XMLGregorianCalendar value) {
        this.fechaultimaLectura = value;
    }

    /**
     * Gets the value of the ambitoValidezCIE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmbitoValidezCIE() {
        return ambitoValidezCIE;
    }

    /**
     * Sets the value of the ambitoValidezCIE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmbitoValidezCIE(String value) {
        this.ambitoValidezCIE = value;
    }

    /**
     * Gets the value of the viviendaHabitual property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isViviendaHabitual() {
        return viviendaHabitual;
    }

    /**
     * Sets the value of the viviendaHabitual property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setViviendaHabitual(Boolean value) {
        this.viviendaHabitual = value;
    }

    /**
     * Gets the value of the fechaultimaRevision property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaultimaRevision() {
        return fechaultimaRevision;
    }

    /**
     * Sets the value of the fechaultimaRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaultimaRevision(XMLGregorianCalendar value) {
        this.fechaultimaRevision = value;
    }

    /**
     * Gets the value of the resultadoUltimaRevision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultadoUltimaRevision() {
        return resultadoUltimaRevision;
    }

    /**
     * Sets the value of the resultadoUltimaRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultadoUltimaRevision(String value) {
        this.resultadoUltimaRevision = value;
    }

    /**
     * Gets the value of the fechaUltimaInspeccion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaUltimaInspeccion() {
        return fechaUltimaInspeccion;
    }

    /**
     * Sets the value of the fechaUltimaInspeccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaUltimaInspeccion(XMLGregorianCalendar value) {
        this.fechaUltimaInspeccion = value;
    }

    /**
     * Gets the value of the resultadoUltimaInspeccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultadoUltimaInspeccion() {
        return resultadoUltimaInspeccion;
    }

    /**
     * Sets the value of the resultadoUltimaInspeccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultadoUltimaInspeccion(String value) {
        this.resultadoUltimaInspeccion = value;
    }

    /**
     * Gets the value of the fianzaDistribuidora property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFianzaDistribuidora() {
        return fianzaDistribuidora;
    }

    /**
     * Sets the value of the fianzaDistribuidora property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFianzaDistribuidora(Boolean value) {
        this.fianzaDistribuidora = value;
    }

    /**
     * Gets the value of the importeFianza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteFianza() {
        return importeFianza;
    }

    /**
     * Sets the value of the importeFianza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteFianza(String value) {
        this.importeFianza = value;
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
     * Gets the value of the redDistribucionGas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedDistribucionGas() {
        return redDistribucionGas;
    }

    /**
     * Sets the value of the redDistribucionGas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedDistribucionGas(String value) {
        this.redDistribucionGas = value;
    }

}
