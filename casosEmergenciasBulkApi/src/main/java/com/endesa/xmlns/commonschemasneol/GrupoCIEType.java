
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GrupoCIEType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrupoCIEType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CIEElectronico" type="{http://xmlns.endesa.com/CommonSchemasNeol}CIEElectrico" minOccurs="0"/&gt;
 *         &lt;element name="CodigoCIE" type="{http://xmlns.endesa.com/CommonSchemasNeol}CIE" minOccurs="0"/&gt;
 *         &lt;element name="HuellaSelloElectronico" type="{http://xmlns.endesa.com/CommonSchemasNeol}HuellaSelloElectronico" minOccurs="0"/&gt;
 *         &lt;element name="FechaEmisionCIE" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="FechaCaducidadCIE" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="NIFInstalador" type="{http://xmlns.endesa.com/CommonSchemasNeol}NIF" minOccurs="0"/&gt;
 *         &lt;element name="NombreRazSocialInstalador" type="{http://xmlns.endesa.com/CommonSchemasNeol}RazonSocial" minOccurs="0"/&gt;
 *         &lt;element name="IntensidadDiferencialA" type="{http://xmlns.endesa.com/CommonSchemasNeol}Intensidad" minOccurs="0"/&gt;
 *         &lt;element name="SensibilidadDiferencialmA" type="{http://xmlns.endesa.com/CommonSchemasNeol}Sensibilidad" minOccurs="0"/&gt;
 *         &lt;element name="SeccionCable" type="{http://xmlns.endesa.com/CommonSchemasNeol}SeccionCable" minOccurs="0"/&gt;
 *         &lt;element name="TipoSuministroCIE" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoSuministro" minOccurs="0"/&gt;
 *         &lt;element name="GrupoAPM" type="{http://xmlns.endesa.com/CommonSchemasNeol}GrupoAPMType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrupoCIEType", propOrder = {
    "cieElectronico",
    "codigoCIE",
    "huellaSelloElectronico",
    "fechaEmisionCIE",
    "fechaCaducidadCIE",
    "nifInstalador",
    "nombreRazSocialInstalador",
    "intensidadDiferencialA",
    "sensibilidadDiferencialmA",
    "seccionCable",
    "tipoSuministroCIE",
    "grupoAPM"
})
public class GrupoCIEType {

    @XmlElement(name = "CIEElectronico")
    protected String cieElectronico;
    @XmlElement(name = "CodigoCIE")
    protected String codigoCIE;
    @XmlElement(name = "HuellaSelloElectronico")
    protected String huellaSelloElectronico;
    @XmlElement(name = "FechaEmisionCIE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmisionCIE;
    @XmlElement(name = "FechaCaducidadCIE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCaducidadCIE;
    @XmlElement(name = "NIFInstalador")
    protected String nifInstalador;
    @XmlElement(name = "NombreRazSocialInstalador")
    protected String nombreRazSocialInstalador;
    @XmlElement(name = "IntensidadDiferencialA")
    protected Double intensidadDiferencialA;
    @XmlElement(name = "SensibilidadDiferencialmA")
    protected Double sensibilidadDiferencialmA;
    @XmlElement(name = "SeccionCable")
    protected String seccionCable;
    @XmlElement(name = "TipoSuministroCIE")
    protected String tipoSuministroCIE;
    @XmlElement(name = "GrupoAPM")
    protected GrupoAPMType grupoAPM;

    /**
     * Gets the value of the cieElectronico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIEElectronico() {
        return cieElectronico;
    }

    /**
     * Sets the value of the cieElectronico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIEElectronico(String value) {
        this.cieElectronico = value;
    }

    /**
     * Gets the value of the codigoCIE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCIE() {
        return codigoCIE;
    }

    /**
     * Sets the value of the codigoCIE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCIE(String value) {
        this.codigoCIE = value;
    }

    /**
     * Gets the value of the huellaSelloElectronico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHuellaSelloElectronico() {
        return huellaSelloElectronico;
    }

    /**
     * Sets the value of the huellaSelloElectronico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHuellaSelloElectronico(String value) {
        this.huellaSelloElectronico = value;
    }

    /**
     * Gets the value of the fechaEmisionCIE property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmisionCIE() {
        return fechaEmisionCIE;
    }

    /**
     * Sets the value of the fechaEmisionCIE property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmisionCIE(XMLGregorianCalendar value) {
        this.fechaEmisionCIE = value;
    }

    /**
     * Gets the value of the fechaCaducidadCIE property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCaducidadCIE() {
        return fechaCaducidadCIE;
    }

    /**
     * Sets the value of the fechaCaducidadCIE property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCaducidadCIE(XMLGregorianCalendar value) {
        this.fechaCaducidadCIE = value;
    }

    /**
     * Gets the value of the nifInstalador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNIFInstalador() {
        return nifInstalador;
    }

    /**
     * Sets the value of the nifInstalador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNIFInstalador(String value) {
        this.nifInstalador = value;
    }

    /**
     * Gets the value of the nombreRazSocialInstalador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreRazSocialInstalador() {
        return nombreRazSocialInstalador;
    }

    /**
     * Sets the value of the nombreRazSocialInstalador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreRazSocialInstalador(String value) {
        this.nombreRazSocialInstalador = value;
    }

    /**
     * Gets the value of the intensidadDiferencialA property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIntensidadDiferencialA() {
        return intensidadDiferencialA;
    }

    /**
     * Sets the value of the intensidadDiferencialA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIntensidadDiferencialA(Double value) {
        this.intensidadDiferencialA = value;
    }

    /**
     * Gets the value of the sensibilidadDiferencialmA property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSensibilidadDiferencialmA() {
        return sensibilidadDiferencialmA;
    }

    /**
     * Sets the value of the sensibilidadDiferencialmA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSensibilidadDiferencialmA(Double value) {
        this.sensibilidadDiferencialmA = value;
    }

    /**
     * Gets the value of the seccionCable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeccionCable() {
        return seccionCable;
    }

    /**
     * Sets the value of the seccionCable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeccionCable(String value) {
        this.seccionCable = value;
    }

    /**
     * Gets the value of the tipoSuministroCIE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSuministroCIE() {
        return tipoSuministroCIE;
    }

    /**
     * Sets the value of the tipoSuministroCIE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSuministroCIE(String value) {
        this.tipoSuministroCIE = value;
    }

    /**
     * Gets the value of the grupoAPM property.
     * 
     * @return
     *     possible object is
     *     {@link GrupoAPMType }
     *     
     */
    public GrupoAPMType getGrupoAPM() {
        return grupoAPM;
    }

    /**
     * Sets the value of the grupoAPM property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrupoAPMType }
     *     
     */
    public void setGrupoAPM(GrupoAPMType value) {
        this.grupoAPM = value;
    }

}
