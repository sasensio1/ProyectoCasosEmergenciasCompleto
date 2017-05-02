
package org.example.sires033_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SuministroType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SuministroType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumeroSuministro" type="{http://www.example.org/SIRES033_Schema}NumeroSuministro" minOccurs="0"/&gt;
 *         &lt;element name="NombreSuministro" type="{http://www.example.org/SIRES033_Schema}NombreSuministro" minOccurs="0"/&gt;
 *         &lt;element name="Calle" type="{http://www.example.org/SIRES033_Schema}Calle" minOccurs="0"/&gt;
 *         &lt;element name="Numero" type="{http://www.example.org/SIRES033_Schema}Numero" minOccurs="0"/&gt;
 *         &lt;element name="Casa" type="{http://www.example.org/SIRES033_Schema}Casa" minOccurs="0"/&gt;
 *         &lt;element name="Departamento" type="{http://www.example.org/SIRES033_Schema}Departamento" minOccurs="0"/&gt;
 *         &lt;element name="Comuna" type="{http://www.example.org/SIRES033_Schema}Comuna" minOccurs="0"/&gt;
 *         &lt;element name="Region" type="{http://www.example.org/SIRES033_Schema}Region" minOccurs="0"/&gt;
 *         &lt;element name="EstadoSuministro" type="{http://www.example.org/SIRES033_Schema}EstadoSuministro" minOccurs="0"/&gt;
 *         &lt;element name="TipoTarifa" type="{http://www.example.org/SIRES033_Schema}TipoTarifa" minOccurs="0"/&gt;
 *         &lt;element name="AlertaFactura" type="{http://www.example.org/SIRES033_Schema}AlertaFactura" minOccurs="0"/&gt;
 *         &lt;element name="AlertaNovedades" type="{http://www.example.org/SIRES033_Schema}AlertaNovedades" minOccurs="0"/&gt;
 *         &lt;element name="FechaCorteSuministro" type="{http://www.example.org/SIRES033_Schema}FechaCorteSuministro" minOccurs="0"/&gt;
 *         &lt;element name="TipoFechaCorteSuministro" type="{http://www.example.org/SIRES033_Schema}TipoFechaCorteSuministro" minOccurs="0"/&gt;
 *         &lt;element name="FechaVencimiento" type="{http://www.example.org/SIRES033_Schema}FechaVencimiento" minOccurs="0"/&gt;
 *         &lt;element name="SuministroAfectado" type="{http://www.example.org/SIRES033_Schema}SuministroAfectado" minOccurs="0"/&gt;
 *         &lt;element name="SaldoVigente" type="{http://www.example.org/SIRES033_Schema}SaldoVigente" minOccurs="0"/&gt;
 *         &lt;element name="Principal" type="{http://www.example.org/SIRES033_Schema}Principal" minOccurs="0"/&gt;
 *         &lt;element name="TipoSuministro" type="{http://www.example.org/SIRES033_Schema}TipSuministro" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuministroType", propOrder = {
    "numeroSuministro",
    "nombreSuministro",
    "calle",
    "numero",
    "casa",
    "departamento",
    "comuna",
    "region",
    "estadoSuministro",
    "tipoTarifa",
    "alertaFactura",
    "alertaNovedades",
    "fechaCorteSuministro",
    "tipoFechaCorteSuministro",
    "fechaVencimiento",
    "suministroAfectado",
    "saldoVigente",
    "principal",
    "tipoSuministro"
})
public class SuministroType {

    @XmlElement(name = "NumeroSuministro")
    protected String numeroSuministro;
    @XmlElement(name = "NombreSuministro")
    protected String nombreSuministro;
    @XmlElement(name = "Calle")
    protected String calle;
    @XmlElement(name = "Numero")
    protected String numero;
    @XmlElement(name = "Casa")
    protected String casa;
    @XmlElement(name = "Departamento")
    protected String departamento;
    @XmlElement(name = "Comuna")
    protected String comuna;
    @XmlElement(name = "Region")
    protected String region;
    @XmlElement(name = "EstadoSuministro")
    protected String estadoSuministro;
    @XmlElement(name = "TipoTarifa")
    protected String tipoTarifa;
    @XmlElement(name = "AlertaFactura")
    protected String alertaFactura;
    @XmlElement(name = "AlertaNovedades")
    protected String alertaNovedades;
    @XmlElement(name = "FechaCorteSuministro")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCorteSuministro;
    @XmlElement(name = "TipoFechaCorteSuministro")
    protected String tipoFechaCorteSuministro;
    @XmlElement(name = "FechaVencimiento")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaVencimiento;
    @XmlElement(name = "SuministroAfectado")
    protected String suministroAfectado;
    @XmlElement(name = "SaldoVigente")
    protected String saldoVigente;
    @XmlElement(name = "Principal")
    protected String principal;
    @XmlElement(name = "TipoSuministro")
    protected String tipoSuministro;

    /**
     * Gets the value of the numeroSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSuministro() {
        return numeroSuministro;
    }

    /**
     * Sets the value of the numeroSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSuministro(String value) {
        this.numeroSuministro = value;
    }

    /**
     * Gets the value of the nombreSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSuministro() {
        return nombreSuministro;
    }

    /**
     * Sets the value of the nombreSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSuministro(String value) {
        this.nombreSuministro = value;
    }

    /**
     * Gets the value of the calle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Sets the value of the calle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalle(String value) {
        this.calle = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Gets the value of the casa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCasa() {
        return casa;
    }

    /**
     * Sets the value of the casa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCasa(String value) {
        this.casa = value;
    }

    /**
     * Gets the value of the departamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Sets the value of the departamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
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
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the estadoSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSuministro() {
        return estadoSuministro;
    }

    /**
     * Sets the value of the estadoSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSuministro(String value) {
        this.estadoSuministro = value;
    }

    /**
     * Gets the value of the tipoTarifa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTarifa() {
        return tipoTarifa;
    }

    /**
     * Sets the value of the tipoTarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTarifa(String value) {
        this.tipoTarifa = value;
    }

    /**
     * Gets the value of the alertaFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlertaFactura() {
        return alertaFactura;
    }

    /**
     * Sets the value of the alertaFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlertaFactura(String value) {
        this.alertaFactura = value;
    }

    /**
     * Gets the value of the alertaNovedades property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlertaNovedades() {
        return alertaNovedades;
    }

    /**
     * Sets the value of the alertaNovedades property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlertaNovedades(String value) {
        this.alertaNovedades = value;
    }

    /**
     * Gets the value of the fechaCorteSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCorteSuministro() {
        return fechaCorteSuministro;
    }

    /**
     * Sets the value of the fechaCorteSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCorteSuministro(XMLGregorianCalendar value) {
        this.fechaCorteSuministro = value;
    }

    /**
     * Gets the value of the tipoFechaCorteSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoFechaCorteSuministro() {
        return tipoFechaCorteSuministro;
    }

    /**
     * Sets the value of the tipoFechaCorteSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoFechaCorteSuministro(String value) {
        this.tipoFechaCorteSuministro = value;
    }

    /**
     * Gets the value of the fechaVencimiento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Sets the value of the fechaVencimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaVencimiento(XMLGregorianCalendar value) {
        this.fechaVencimiento = value;
    }

    /**
     * Gets the value of the suministroAfectado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuministroAfectado() {
        return suministroAfectado;
    }

    /**
     * Sets the value of the suministroAfectado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuministroAfectado(String value) {
        this.suministroAfectado = value;
    }

    /**
     * Gets the value of the saldoVigente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoVigente() {
        return saldoVigente;
    }

    /**
     * Sets the value of the saldoVigente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoVigente(String value) {
        this.saldoVigente = value;
    }

    /**
     * Gets the value of the principal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * Sets the value of the principal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipal(String value) {
        this.principal = value;
    }

    /**
     * Gets the value of the tipoSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSuministro() {
        return tipoSuministro;
    }

    /**
     * Sets the value of the tipoSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSuministro(String value) {
        this.tipoSuministro = value;
    }

}
