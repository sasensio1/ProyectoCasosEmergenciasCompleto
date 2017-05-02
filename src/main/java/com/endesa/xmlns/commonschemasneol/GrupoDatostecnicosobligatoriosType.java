
package com.endesa.xmlns.commonschemasneol;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GrupoDatostecnicosobligatoriosType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrupoDatostecnicosobligatoriosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdDireccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdDireccion"/&gt;
 *         &lt;element name="CNAE" type="{http://xmlns.endesa.com/CommonSchemasNeol}CNAE"/&gt;
 *         &lt;element name="Segmento" type="{http://xmlns.endesa.com/CommonSchemasNeol}Segmento" minOccurs="0"/&gt;
 *         &lt;element name="Distribuidora" type="{http://xmlns.endesa.com/CommonSchemasNeol}Distribuidora"/&gt;
 *         &lt;element name="LineaNegocio" type="{http://xmlns.endesa.com/CommonSchemasNeol}LineaNegocio"/&gt;
 *         &lt;element name="TipoTension" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoTension" minOccurs="0"/&gt;
 *         &lt;element name="TensionV" type="{http://xmlns.endesa.com/CommonSchemasNeol}Tension" minOccurs="0"/&gt;
 *         &lt;element name="Tarifa" type="{http://xmlns.endesa.com/CommonSchemasNeol}Tarifa"/&gt;
 *         &lt;element name="PotenciaPeriodo1Kw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia"/&gt;
 *         &lt;element name="PotenciaPeriodo2Kw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaPeriodo3Kw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaPeriodo4Kw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaPeriodo5Kw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaPeriodo6Kw" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="ConsumoAnualEstKwhAnio" type="{http://xmlns.endesa.com/CommonSchemasNeol}Consumo" minOccurs="0"/&gt;
 *         &lt;element name="PropiedadEquipoMedida" type="{http://xmlns.endesa.com/CommonSchemasNeol}PropiedadEquipo" minOccurs="0"/&gt;
 *         &lt;element name="PropiedadICP" type="{http://xmlns.endesa.com/CommonSchemasNeol}PropiedadICP" minOccurs="0"/&gt;
 *         &lt;element name="ICPInstalado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaMaxAutorizadaCIE" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaAdscritaExtension" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="RefCatas" type="{http://xmlns.endesa.com/CommonSchemasNeol}ReferenciaCatastral" minOccurs="0"/&gt;
 *         &lt;element name="CIEaportado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="APMaportada" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="CodigoREIG" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoREIG" minOccurs="0"/&gt;
 *         &lt;element name="PotenciaDisenyo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="FechaCertificadoIRI" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="GrupoCIE" type="{http://xmlns.endesa.com/CommonSchemasNeol}GrupoCIEType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrupoDatostecnicosobligatoriosType", propOrder = {
    "idDireccion",
    "cnae",
    "segmento",
    "distribuidora",
    "lineaNegocio",
    "tipoTension",
    "tensionV",
    "tarifa",
    "potenciaPeriodo1Kw",
    "potenciaPeriodo2Kw",
    "potenciaPeriodo3Kw",
    "potenciaPeriodo4Kw",
    "potenciaPeriodo5Kw",
    "potenciaPeriodo6Kw",
    "consumoAnualEstKwhAnio",
    "propiedadEquipoMedida",
    "propiedadICP",
    "icpInstalado",
    "potenciaMaxAutorizadaCIE",
    "potenciaAdscritaExtension",
    "refCatas",
    "ciEaportado",
    "apMaportada",
    "codigoREIG",
    "potenciaDisenyo",
    "fechaCertificadoIRI",
    "grupoCIE"
})
public class GrupoDatostecnicosobligatoriosType {

    @XmlElement(name = "IdDireccion", required = true)
    protected String idDireccion;
    @XmlElement(name = "CNAE", required = true)
    protected String cnae;
    @XmlElement(name = "Segmento")
    protected String segmento;
    @XmlElement(name = "Distribuidora", required = true)
    protected String distribuidora;
    @XmlElement(name = "LineaNegocio", required = true)
    protected String lineaNegocio;
    @XmlElement(name = "TipoTension")
    protected String tipoTension;
    @XmlElement(name = "TensionV")
    protected String tensionV;
    @XmlElement(name = "Tarifa", required = true)
    protected String tarifa;
    @XmlElement(name = "PotenciaPeriodo1Kw", required = true)
    protected BigDecimal potenciaPeriodo1Kw;
    @XmlElement(name = "PotenciaPeriodo2Kw")
    protected BigDecimal potenciaPeriodo2Kw;
    @XmlElement(name = "PotenciaPeriodo3Kw")
    protected BigDecimal potenciaPeriodo3Kw;
    @XmlElement(name = "PotenciaPeriodo4Kw")
    protected BigDecimal potenciaPeriodo4Kw;
    @XmlElement(name = "PotenciaPeriodo5Kw")
    protected BigDecimal potenciaPeriodo5Kw;
    @XmlElement(name = "PotenciaPeriodo6Kw")
    protected BigDecimal potenciaPeriodo6Kw;
    @XmlElement(name = "ConsumoAnualEstKwhAnio")
    protected String consumoAnualEstKwhAnio;
    @XmlElement(name = "PropiedadEquipoMedida")
    protected String propiedadEquipoMedida;
    @XmlElement(name = "PropiedadICP")
    protected String propiedadICP;
    @XmlElement(name = "ICPInstalado")
    protected Boolean icpInstalado;
    @XmlElement(name = "PotenciaMaxAutorizadaCIE")
    protected BigDecimal potenciaMaxAutorizadaCIE;
    @XmlElement(name = "PotenciaAdscritaExtension")
    protected BigDecimal potenciaAdscritaExtension;
    @XmlElement(name = "RefCatas")
    protected String refCatas;
    @XmlElement(name = "CIEaportado")
    protected Boolean ciEaportado;
    @XmlElement(name = "APMaportada")
    protected Boolean apMaportada;
    @XmlElement(name = "CodigoREIG")
    protected String codigoREIG;
    @XmlElement(name = "PotenciaDisenyo")
    protected BigDecimal potenciaDisenyo;
    @XmlElement(name = "FechaCertificadoIRI")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCertificadoIRI;
    @XmlElement(name = "GrupoCIE")
    protected GrupoCIEType grupoCIE;

    /**
     * Gets the value of the idDireccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDireccion() {
        return idDireccion;
    }

    /**
     * Sets the value of the idDireccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDireccion(String value) {
        this.idDireccion = value;
    }

    /**
     * Gets the value of the cnae property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNAE() {
        return cnae;
    }

    /**
     * Sets the value of the cnae property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNAE(String value) {
        this.cnae = value;
    }

    /**
     * Gets the value of the segmento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegmento() {
        return segmento;
    }

    /**
     * Sets the value of the segmento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegmento(String value) {
        this.segmento = value;
    }

    /**
     * Gets the value of the distribuidora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistribuidora() {
        return distribuidora;
    }

    /**
     * Sets the value of the distribuidora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistribuidora(String value) {
        this.distribuidora = value;
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
     * Gets the value of the tipoTension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTension() {
        return tipoTension;
    }

    /**
     * Sets the value of the tipoTension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTension(String value) {
        this.tipoTension = value;
    }

    /**
     * Gets the value of the tensionV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTensionV() {
        return tensionV;
    }

    /**
     * Sets the value of the tensionV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTensionV(String value) {
        this.tensionV = value;
    }

    /**
     * Gets the value of the tarifa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     * Sets the value of the tarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarifa(String value) {
        this.tarifa = value;
    }

    /**
     * Gets the value of the potenciaPeriodo1Kw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaPeriodo1Kw() {
        return potenciaPeriodo1Kw;
    }

    /**
     * Sets the value of the potenciaPeriodo1Kw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaPeriodo1Kw(BigDecimal value) {
        this.potenciaPeriodo1Kw = value;
    }

    /**
     * Gets the value of the potenciaPeriodo2Kw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaPeriodo2Kw() {
        return potenciaPeriodo2Kw;
    }

    /**
     * Sets the value of the potenciaPeriodo2Kw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaPeriodo2Kw(BigDecimal value) {
        this.potenciaPeriodo2Kw = value;
    }

    /**
     * Gets the value of the potenciaPeriodo3Kw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaPeriodo3Kw() {
        return potenciaPeriodo3Kw;
    }

    /**
     * Sets the value of the potenciaPeriodo3Kw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaPeriodo3Kw(BigDecimal value) {
        this.potenciaPeriodo3Kw = value;
    }

    /**
     * Gets the value of the potenciaPeriodo4Kw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaPeriodo4Kw() {
        return potenciaPeriodo4Kw;
    }

    /**
     * Sets the value of the potenciaPeriodo4Kw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaPeriodo4Kw(BigDecimal value) {
        this.potenciaPeriodo4Kw = value;
    }

    /**
     * Gets the value of the potenciaPeriodo5Kw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaPeriodo5Kw() {
        return potenciaPeriodo5Kw;
    }

    /**
     * Sets the value of the potenciaPeriodo5Kw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaPeriodo5Kw(BigDecimal value) {
        this.potenciaPeriodo5Kw = value;
    }

    /**
     * Gets the value of the potenciaPeriodo6Kw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaPeriodo6Kw() {
        return potenciaPeriodo6Kw;
    }

    /**
     * Sets the value of the potenciaPeriodo6Kw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaPeriodo6Kw(BigDecimal value) {
        this.potenciaPeriodo6Kw = value;
    }

    /**
     * Gets the value of the consumoAnualEstKwhAnio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsumoAnualEstKwhAnio() {
        return consumoAnualEstKwhAnio;
    }

    /**
     * Sets the value of the consumoAnualEstKwhAnio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsumoAnualEstKwhAnio(String value) {
        this.consumoAnualEstKwhAnio = value;
    }

    /**
     * Gets the value of the propiedadEquipoMedida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropiedadEquipoMedida() {
        return propiedadEquipoMedida;
    }

    /**
     * Sets the value of the propiedadEquipoMedida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropiedadEquipoMedida(String value) {
        this.propiedadEquipoMedida = value;
    }

    /**
     * Gets the value of the propiedadICP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropiedadICP() {
        return propiedadICP;
    }

    /**
     * Sets the value of the propiedadICP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropiedadICP(String value) {
        this.propiedadICP = value;
    }

    /**
     * Gets the value of the icpInstalado property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isICPInstalado() {
        return icpInstalado;
    }

    /**
     * Sets the value of the icpInstalado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setICPInstalado(Boolean value) {
        this.icpInstalado = value;
    }

    /**
     * Gets the value of the potenciaMaxAutorizadaCIE property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaMaxAutorizadaCIE() {
        return potenciaMaxAutorizadaCIE;
    }

    /**
     * Sets the value of the potenciaMaxAutorizadaCIE property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaMaxAutorizadaCIE(BigDecimal value) {
        this.potenciaMaxAutorizadaCIE = value;
    }

    /**
     * Gets the value of the potenciaAdscritaExtension property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaAdscritaExtension() {
        return potenciaAdscritaExtension;
    }

    /**
     * Sets the value of the potenciaAdscritaExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaAdscritaExtension(BigDecimal value) {
        this.potenciaAdscritaExtension = value;
    }

    /**
     * Gets the value of the refCatas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefCatas() {
        return refCatas;
    }

    /**
     * Sets the value of the refCatas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefCatas(String value) {
        this.refCatas = value;
    }

    /**
     * Gets the value of the ciEaportado property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCIEaportado() {
        return ciEaportado;
    }

    /**
     * Sets the value of the ciEaportado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCIEaportado(Boolean value) {
        this.ciEaportado = value;
    }

    /**
     * Gets the value of the apMaportada property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAPMaportada() {
        return apMaportada;
    }

    /**
     * Sets the value of the apMaportada property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAPMaportada(Boolean value) {
        this.apMaportada = value;
    }

    /**
     * Gets the value of the codigoREIG property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoREIG() {
        return codigoREIG;
    }

    /**
     * Sets the value of the codigoREIG property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoREIG(String value) {
        this.codigoREIG = value;
    }

    /**
     * Gets the value of the potenciaDisenyo property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotenciaDisenyo() {
        return potenciaDisenyo;
    }

    /**
     * Sets the value of the potenciaDisenyo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotenciaDisenyo(BigDecimal value) {
        this.potenciaDisenyo = value;
    }

    /**
     * Gets the value of the fechaCertificadoIRI property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCertificadoIRI() {
        return fechaCertificadoIRI;
    }

    /**
     * Sets the value of the fechaCertificadoIRI property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCertificadoIRI(XMLGregorianCalendar value) {
        this.fechaCertificadoIRI = value;
    }

    /**
     * Gets the value of the grupoCIE property.
     * 
     * @return
     *     possible object is
     *     {@link GrupoCIEType }
     *     
     */
    public GrupoCIEType getGrupoCIE() {
        return grupoCIE;
    }

    /**
     * Sets the value of the grupoCIE property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrupoCIEType }
     *     
     */
    public void setGrupoCIE(GrupoCIEType value) {
        this.grupoCIE = value;
    }

}
