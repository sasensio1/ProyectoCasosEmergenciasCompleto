
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DireccionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DireccionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Alias" type="{http://xmlns.endesa.com/CommonSchemasNeol}Alias" minOccurs="0"/&gt;
 *         &lt;element name="TipoVia" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoVia" minOccurs="0"/&gt;
 *         &lt;element name="CodCalle" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodCalle" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionCalle" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionCalle" minOccurs="0"/&gt;
 *         &lt;element name="Numero" type="{http://xmlns.endesa.com/CommonSchemasNeol}Numero" minOccurs="0"/&gt;
 *         &lt;element name="Piso" type="{http://xmlns.endesa.com/CommonSchemasNeol}Piso" minOccurs="0"/&gt;
 *         &lt;element name="Puerta" type="{http://xmlns.endesa.com/CommonSchemasNeol}Puerta" minOccurs="0"/&gt;
 *         &lt;element name="Escalera" type="{http://xmlns.endesa.com/CommonSchemasNeol}Escalera" minOccurs="0"/&gt;
 *         &lt;element name="CodigoPostal" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoPostal" minOccurs="0"/&gt;
 *         &lt;element name="CodPoblacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodPoblacion" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionPoblacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionPoblacion" minOccurs="0"/&gt;
 *         &lt;element name="CodMunicipio" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodMunicipio" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionMunicipio" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionMunicipio" minOccurs="0"/&gt;
 *         &lt;element name="CodProvincia" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodProvincia" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionProvincia" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionProvincia" minOccurs="0"/&gt;
 *         &lt;element name="CodigoPais" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoPais" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionPais" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionPais" minOccurs="0"/&gt;
 *         &lt;element name="CodTipAcFin" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodTipAcFin" minOccurs="0"/&gt;
 *         &lt;element name="DireccionContactoPrincipal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="DireccionNormalizada" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="DireccionMismaQueContacto" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="TipoDireccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoDireccion" minOccurs="0"/&gt;
 *         &lt;element name="IdDireccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdDireccion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DireccionType", propOrder = {
    "alias",
    "tipoVia",
    "codCalle",
    "descripcionCalle",
    "numero",
    "piso",
    "puerta",
    "escalera",
    "codigoPostal",
    "codPoblacion",
    "descripcionPoblacion",
    "codMunicipio",
    "descripcionMunicipio",
    "codProvincia",
    "descripcionProvincia",
    "codigoPais",
    "descripcionPais",
    "codTipAcFin",
    "direccionContactoPrincipal",
    "direccionNormalizada",
    "direccionMismaQueContacto",
    "tipoDireccion",
    "idDireccion"
})
public class DireccionType {

    @XmlElement(name = "Alias")
    protected String alias;
    @XmlElement(name = "TipoVia")
    protected String tipoVia;
    @XmlElement(name = "CodCalle")
    protected String codCalle;
    @XmlElement(name = "DescripcionCalle")
    protected String descripcionCalle;
    @XmlElement(name = "Numero")
    protected String numero;
    @XmlElement(name = "Piso")
    protected String piso;
    @XmlElement(name = "Puerta")
    protected String puerta;
    @XmlElement(name = "Escalera")
    protected String escalera;
    @XmlElement(name = "CodigoPostal")
    protected String codigoPostal;
    @XmlElement(name = "CodPoblacion")
    protected String codPoblacion;
    @XmlElement(name = "DescripcionPoblacion")
    protected String descripcionPoblacion;
    @XmlElement(name = "CodMunicipio")
    protected String codMunicipio;
    @XmlElement(name = "DescripcionMunicipio")
    protected String descripcionMunicipio;
    @XmlElement(name = "CodProvincia")
    protected String codProvincia;
    @XmlElement(name = "DescripcionProvincia")
    protected String descripcionProvincia;
    @XmlElement(name = "CodigoPais")
    protected String codigoPais;
    @XmlElement(name = "DescripcionPais")
    protected String descripcionPais;
    @XmlElement(name = "CodTipAcFin")
    protected String codTipAcFin;
    @XmlElement(name = "DireccionContactoPrincipal")
    protected Boolean direccionContactoPrincipal;
    @XmlElement(name = "DireccionNormalizada")
    protected Boolean direccionNormalizada;
    @XmlElement(name = "DireccionMismaQueContacto")
    protected Boolean direccionMismaQueContacto;
    @XmlElement(name = "TipoDireccion")
    protected String tipoDireccion;
    @XmlElement(name = "IdDireccion")
    protected String idDireccion;

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
     * Gets the value of the tipoVia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoVia() {
        return tipoVia;
    }

    /**
     * Sets the value of the tipoVia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoVia(String value) {
        this.tipoVia = value;
    }

    /**
     * Gets the value of the codCalle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCalle() {
        return codCalle;
    }

    /**
     * Sets the value of the codCalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCalle(String value) {
        this.codCalle = value;
    }

    /**
     * Gets the value of the descripcionCalle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionCalle() {
        return descripcionCalle;
    }

    /**
     * Sets the value of the descripcionCalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionCalle(String value) {
        this.descripcionCalle = value;
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
     * Gets the value of the piso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPiso() {
        return piso;
    }

    /**
     * Sets the value of the piso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPiso(String value) {
        this.piso = value;
    }

    /**
     * Gets the value of the puerta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuerta() {
        return puerta;
    }

    /**
     * Sets the value of the puerta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuerta(String value) {
        this.puerta = value;
    }

    /**
     * Gets the value of the escalera property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEscalera() {
        return escalera;
    }

    /**
     * Sets the value of the escalera property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEscalera(String value) {
        this.escalera = value;
    }

    /**
     * Gets the value of the codigoPostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Sets the value of the codigoPostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPostal(String value) {
        this.codigoPostal = value;
    }

    /**
     * Gets the value of the codPoblacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPoblacion() {
        return codPoblacion;
    }

    /**
     * Sets the value of the codPoblacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPoblacion(String value) {
        this.codPoblacion = value;
    }

    /**
     * Gets the value of the descripcionPoblacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionPoblacion() {
        return descripcionPoblacion;
    }

    /**
     * Sets the value of the descripcionPoblacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionPoblacion(String value) {
        this.descripcionPoblacion = value;
    }

    /**
     * Gets the value of the codMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * Sets the value of the codMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMunicipio(String value) {
        this.codMunicipio = value;
    }

    /**
     * Gets the value of the descripcionMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionMunicipio() {
        return descripcionMunicipio;
    }

    /**
     * Sets the value of the descripcionMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionMunicipio(String value) {
        this.descripcionMunicipio = value;
    }

    /**
     * Gets the value of the codProvincia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodProvincia() {
        return codProvincia;
    }

    /**
     * Sets the value of the codProvincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodProvincia(String value) {
        this.codProvincia = value;
    }

    /**
     * Gets the value of the descripcionProvincia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionProvincia() {
        return descripcionProvincia;
    }

    /**
     * Sets the value of the descripcionProvincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionProvincia(String value) {
        this.descripcionProvincia = value;
    }

    /**
     * Gets the value of the codigoPais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * Sets the value of the codigoPais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPais(String value) {
        this.codigoPais = value;
    }

    /**
     * Gets the value of the descripcionPais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionPais() {
        return descripcionPais;
    }

    /**
     * Sets the value of the descripcionPais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionPais(String value) {
        this.descripcionPais = value;
    }

    /**
     * Gets the value of the codTipAcFin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipAcFin() {
        return codTipAcFin;
    }

    /**
     * Sets the value of the codTipAcFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipAcFin(String value) {
        this.codTipAcFin = value;
    }

    /**
     * Gets the value of the direccionContactoPrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDireccionContactoPrincipal() {
        return direccionContactoPrincipal;
    }

    /**
     * Sets the value of the direccionContactoPrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDireccionContactoPrincipal(Boolean value) {
        this.direccionContactoPrincipal = value;
    }

    /**
     * Gets the value of the direccionNormalizada property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDireccionNormalizada() {
        return direccionNormalizada;
    }

    /**
     * Sets the value of the direccionNormalizada property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDireccionNormalizada(Boolean value) {
        this.direccionNormalizada = value;
    }

    /**
     * Gets the value of the direccionMismaQueContacto property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDireccionMismaQueContacto() {
        return direccionMismaQueContacto;
    }

    /**
     * Sets the value of the direccionMismaQueContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDireccionMismaQueContacto(Boolean value) {
        this.direccionMismaQueContacto = value;
    }

    /**
     * Gets the value of the tipoDireccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDireccion() {
        return tipoDireccion;
    }

    /**
     * Sets the value of the tipoDireccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDireccion(String value) {
        this.tipoDireccion = value;
    }

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

}
