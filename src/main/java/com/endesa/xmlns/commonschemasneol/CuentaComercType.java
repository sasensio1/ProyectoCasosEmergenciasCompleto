
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CuentaComercType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CuentaComercType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TipoCuenta" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoCuenta" minOccurs="0"/&gt;
 *         &lt;element name="IdCuenta" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCuenta" minOccurs="0"/&gt;
 *         &lt;element name="Descripcion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionCuenta" minOccurs="0"/&gt;
 *         &lt;element name="TitularPago" type="{http://xmlns.endesa.com/CommonSchemasNeol}DatosTitularPagoType" minOccurs="0"/&gt;
 *         &lt;element name="Alias" type="{http://xmlns.endesa.com/CommonSchemasNeol}Alias" minOccurs="0"/&gt;
 *         &lt;element name="TipoPuestaCobro" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoPuestaCobro" minOccurs="0"/&gt;
 *         &lt;element name="CodigoPais" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoPais" minOccurs="0"/&gt;
 *         &lt;element name="CodigoControl" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoControl" minOccurs="0"/&gt;
 *         &lt;element name="Entidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}Entidad" minOccurs="0"/&gt;
 *         &lt;element name="Oficina" type="{http://xmlns.endesa.com/CommonSchemasNeol}Oficina" minOccurs="0"/&gt;
 *         &lt;element name="DC" type="{http://xmlns.endesa.com/CommonSchemasNeol}DigitoControl" minOccurs="0"/&gt;
 *         &lt;element name="NumCuenta" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumCuenta" minOccurs="0"/&gt;
 *         &lt;element name="ListContratos" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaContratosType" minOccurs="0"/&gt;
 *         &lt;element name="DireccionFacturacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="BIC" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoBIC" minOccurs="0"/&gt;
 *         &lt;element name="IBAN" type="{http://xmlns.endesa.com/CommonSchemasNeol}IBAN" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CuentaComercType", propOrder = {
    "tipoCuenta",
    "idCuenta",
    "descripcion",
    "titularPago",
    "alias",
    "tipoPuestaCobro",
    "codigoPais",
    "codigoControl",
    "entidad",
    "oficina",
    "dc",
    "numCuenta",
    "listContratos",
    "direccionFacturacion",
    "bic",
    "iban"
})
public class CuentaComercType {

    @XmlElement(name = "TipoCuenta")
    protected String tipoCuenta;
    @XmlElement(name = "IdCuenta")
    protected String idCuenta;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "TitularPago")
    protected DatosTitularPagoType titularPago;
    @XmlElement(name = "Alias")
    protected String alias;
    @XmlElement(name = "TipoPuestaCobro")
    protected String tipoPuestaCobro;
    @XmlElement(name = "CodigoPais")
    protected String codigoPais;
    @XmlElement(name = "CodigoControl")
    protected String codigoControl;
    @XmlElement(name = "Entidad")
    protected String entidad;
    @XmlElement(name = "Oficina")
    protected String oficina;
    @XmlElement(name = "DC")
    protected String dc;
    @XmlElement(name = "NumCuenta")
    protected String numCuenta;
    @XmlElement(name = "ListContratos")
    protected ListaContratosType listContratos;
    @XmlElement(name = "DireccionFacturacion")
    protected DireccionType direccionFacturacion;
    @XmlElement(name = "BIC")
    protected String bic;
    @XmlElement(name = "IBAN")
    protected String iban;

    /**
     * Gets the value of the tipoCuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Sets the value of the tipoCuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCuenta(String value) {
        this.tipoCuenta = value;
    }

    /**
     * Gets the value of the idCuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * Sets the value of the idCuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCuenta(String value) {
        this.idCuenta = value;
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
     * Gets the value of the titularPago property.
     * 
     * @return
     *     possible object is
     *     {@link DatosTitularPagoType }
     *     
     */
    public DatosTitularPagoType getTitularPago() {
        return titularPago;
    }

    /**
     * Sets the value of the titularPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosTitularPagoType }
     *     
     */
    public void setTitularPago(DatosTitularPagoType value) {
        this.titularPago = value;
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
     * Gets the value of the tipoPuestaCobro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPuestaCobro() {
        return tipoPuestaCobro;
    }

    /**
     * Sets the value of the tipoPuestaCobro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPuestaCobro(String value) {
        this.tipoPuestaCobro = value;
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
     * Gets the value of the codigoControl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoControl() {
        return codigoControl;
    }

    /**
     * Sets the value of the codigoControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoControl(String value) {
        this.codigoControl = value;
    }

    /**
     * Gets the value of the entidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * Sets the value of the entidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntidad(String value) {
        this.entidad = value;
    }

    /**
     * Gets the value of the oficina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOficina() {
        return oficina;
    }

    /**
     * Sets the value of the oficina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOficina(String value) {
        this.oficina = value;
    }

    /**
     * Gets the value of the dc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDC() {
        return dc;
    }

    /**
     * Sets the value of the dc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDC(String value) {
        this.dc = value;
    }

    /**
     * Gets the value of the numCuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Sets the value of the numCuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCuenta(String value) {
        this.numCuenta = value;
    }

    /**
     * Gets the value of the listContratos property.
     * 
     * @return
     *     possible object is
     *     {@link ListaContratosType }
     *     
     */
    public ListaContratosType getListContratos() {
        return listContratos;
    }

    /**
     * Sets the value of the listContratos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaContratosType }
     *     
     */
    public void setListContratos(ListaContratosType value) {
        this.listContratos = value;
    }

    /**
     * Gets the value of the direccionFacturacion property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionFacturacion() {
        return direccionFacturacion;
    }

    /**
     * Sets the value of the direccionFacturacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionFacturacion(DireccionType value) {
        this.direccionFacturacion = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIC() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIC(String value) {
        this.bic = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

}
