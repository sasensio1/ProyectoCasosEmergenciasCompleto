
package com.endesa.xmlns.commonschemasneol;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ContratoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContratoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumContrato" minOccurs="0"/&gt;
 *         &lt;element name="NombreContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreContrato" minOccurs="0"/&gt;
 *         &lt;element name="Direccion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *         &lt;element name="EmpresaTitular" type="{http://xmlns.endesa.com/CommonSchemasNeol}Empresa" minOccurs="0"/&gt;
 *         &lt;element name="Estado" type="{http://xmlns.endesa.com/CommonSchemasNeol}Estado" minOccurs="0"/&gt;
 *         &lt;element name="ListaLineasPedido" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaLineasPedidoType" minOccurs="0"/&gt;
 *         &lt;element name="FacturaDigital" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="LineaNegocio" type="{http://xmlns.endesa.com/CommonSchemasNeol}LineaNegocio" minOccurs="0"/&gt;
 *         &lt;element name="FechaAlta" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="ValidacionNoSuperada" type="{http://xmlns.endesa.com/CommonSchemasNeol}ValidacionType" minOccurs="0"/&gt;
 *         &lt;element name="IdContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdContrato" minOccurs="0"/&gt;
 *         &lt;element name="IdCuentaComercial" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCuenta" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionCuentaComercial" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionCuenta" minOccurs="0"/&gt;
 *         &lt;element name="ListaContratosAsociados" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaDatosContratoType" minOccurs="0"/&gt;
 *         &lt;element name="Tarifa" type="{http://xmlns.endesa.com/CommonSchemasNeol}Tarifa" minOccurs="0"/&gt;
 *         &lt;element name="CUPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}CUPS" minOccurs="0"/&gt;
 *         &lt;element name="ListaDocumentacionAdjunta" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaDocumentosAdjuntosType" minOccurs="0"/&gt;
 *         &lt;element name="ListaDocumentacionNoAdjunta" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaDocumentosPendientesType" minOccurs="0"/&gt;
 *         &lt;element name="FechaRescision" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="DeudaPendiente" type="{http://xmlns.endesa.com/CommonSchemasNeol}Deuda" minOccurs="0"/&gt;
 *         &lt;element name="ProductoAsociado" type="{http://xmlns.endesa.com/CommonSchemasNeol}ProductoType" minOccurs="0"/&gt;
 *         &lt;element name="CodigoUltimaFactura" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoFactura" minOccurs="0"/&gt;
 *         &lt;element name="ImporteUltimaFactura" type="{http://xmlns.endesa.com/CommonSchemasNeol}Importe" minOccurs="0"/&gt;
 *         &lt;element name="BonoSocial" type="{http://xmlns.endesa.com/CommonSchemasNeol}BonoSocial" minOccurs="0"/&gt;
 *         &lt;element name="CuentaComercial" type="{http://xmlns.endesa.com/CommonSchemasNeol}CuentaComercType" minOccurs="0"/&gt;
 *         &lt;element name="Potencia" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="PropiedadEquipo" type="{http://xmlns.endesa.com/CommonSchemasNeol}PropiedadEquipo" minOccurs="0"/&gt;
 *         &lt;element name="ConsumoMedio" type="{http://xmlns.endesa.com/CommonSchemasNeol}ConsumoMedio" minOccurs="0"/&gt;
 *         &lt;element name="Caudal" type="{http://xmlns.endesa.com/CommonSchemasNeol}Caudal" minOccurs="0"/&gt;
 *         &lt;element name="Tension" type="{http://xmlns.endesa.com/CommonSchemasNeol}Tension" minOccurs="0"/&gt;
 *         &lt;element name="EquipoMedida" type="{http://xmlns.endesa.com/CommonSchemasNeol}EquipoMedida" minOccurs="0"/&gt;
 *         &lt;element name="DiscriminacionHoraria" type="{http://xmlns.endesa.com/CommonSchemasNeol}DiscHoraria" minOccurs="0"/&gt;
 *         &lt;element name="TarifaATR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Potencia1" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="Potencia2" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="Potencia3" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia" minOccurs="0"/&gt;
 *         &lt;element name="TipoTension" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoTension" minOccurs="0"/&gt;
 *         &lt;element name="Presion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Presion" minOccurs="0"/&gt;
 *         &lt;element name="ControlPotencia" type="{http://xmlns.endesa.com/CommonSchemasNeol}ControlPotencia" minOccurs="0"/&gt;
 *         &lt;element name="CNAE" type="{http://xmlns.endesa.com/CommonSchemasNeol}CNAE" minOccurs="0"/&gt;
 *         &lt;element name="TipoContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoContrato" minOccurs="0"/&gt;
 *         &lt;element name="DatosTecnicos" type="{http://xmlns.endesa.com/CommonSchemasNeol}DatosTecnicos" minOccurs="0"/&gt;
 *         &lt;element name="FechaUltimaModificacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="IsSVE" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ListaPersonasContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaPersonAutorizaType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContratoType", propOrder = {
    "numContrato",
    "nombreContrato",
    "direccion",
    "empresaTitular",
    "estado",
    "listaLineasPedido",
    "facturaDigital",
    "lineaNegocio",
    "fechaAlta",
    "validacionNoSuperada",
    "idContrato",
    "idCuentaComercial",
    "descripcionCuentaComercial",
    "listaContratosAsociados",
    "tarifa",
    "cups",
    "listaDocumentacionAdjunta",
    "listaDocumentacionNoAdjunta",
    "fechaRescision",
    "deudaPendiente",
    "productoAsociado",
    "codigoUltimaFactura",
    "importeUltimaFactura",
    "bonoSocial",
    "cuentaComercial",
    "potencia",
    "propiedadEquipo",
    "consumoMedio",
    "caudal",
    "tension",
    "equipoMedida",
    "discriminacionHoraria",
    "tarifaATR",
    "potencia1",
    "potencia2",
    "potencia3",
    "tipoTension",
    "presion",
    "controlPotencia",
    "cnae",
    "tipoContrato",
    "datosTecnicos",
    "fechaUltimaModificacion",
    "isSVE",
    "listaPersonasContacto"
})
public class ContratoType {

    @XmlElement(name = "NumContrato")
    protected String numContrato;
    @XmlElement(name = "NombreContrato")
    protected String nombreContrato;
    @XmlElement(name = "Direccion")
    protected DireccionType direccion;
    @XmlElement(name = "EmpresaTitular")
    protected String empresaTitular;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "ListaLineasPedido")
    protected ListaLineasPedidoType listaLineasPedido;
    @XmlElement(name = "FacturaDigital")
    protected Boolean facturaDigital;
    @XmlElement(name = "LineaNegocio")
    protected String lineaNegocio;
    @XmlElement(name = "FechaAlta")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAlta;
    @XmlElement(name = "ValidacionNoSuperada")
    protected ValidacionType validacionNoSuperada;
    @XmlElement(name = "IdContrato")
    protected String idContrato;
    @XmlElement(name = "IdCuentaComercial")
    protected String idCuentaComercial;
    @XmlElement(name = "DescripcionCuentaComercial")
    protected String descripcionCuentaComercial;
    @XmlElement(name = "ListaContratosAsociados")
    protected ListaDatosContratoType listaContratosAsociados;
    @XmlElement(name = "Tarifa")
    protected String tarifa;
    @XmlElement(name = "CUPS")
    protected String cups;
    @XmlElement(name = "ListaDocumentacionAdjunta")
    protected ListaDocumentosAdjuntosType listaDocumentacionAdjunta;
    @XmlElement(name = "ListaDocumentacionNoAdjunta")
    protected ListaDocumentosPendientesType listaDocumentacionNoAdjunta;
    @XmlElement(name = "FechaRescision")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRescision;
    @XmlElement(name = "DeudaPendiente")
    protected String deudaPendiente;
    @XmlElement(name = "ProductoAsociado")
    protected ProductoType productoAsociado;
    @XmlElement(name = "CodigoUltimaFactura")
    protected String codigoUltimaFactura;
    @XmlElement(name = "ImporteUltimaFactura")
    protected String importeUltimaFactura;
    @XmlElement(name = "BonoSocial")
    protected String bonoSocial;
    @XmlElement(name = "CuentaComercial")
    protected CuentaComercType cuentaComercial;
    @XmlElement(name = "Potencia")
    protected BigDecimal potencia;
    @XmlElement(name = "PropiedadEquipo")
    protected String propiedadEquipo;
    @XmlElement(name = "ConsumoMedio")
    protected String consumoMedio;
    @XmlElement(name = "Caudal")
    protected String caudal;
    @XmlElement(name = "Tension")
    protected String tension;
    @XmlElement(name = "EquipoMedida")
    protected String equipoMedida;
    @XmlElement(name = "DiscriminacionHoraria")
    protected String discriminacionHoraria;
    @XmlElement(name = "TarifaATR")
    protected String tarifaATR;
    @XmlElement(name = "Potencia1")
    protected BigDecimal potencia1;
    @XmlElement(name = "Potencia2")
    protected BigDecimal potencia2;
    @XmlElement(name = "Potencia3")
    protected BigDecimal potencia3;
    @XmlElement(name = "TipoTension")
    protected String tipoTension;
    @XmlElement(name = "Presion")
    protected String presion;
    @XmlElement(name = "ControlPotencia")
    protected String controlPotencia;
    @XmlElement(name = "CNAE")
    protected String cnae;
    @XmlElement(name = "TipoContrato")
    protected String tipoContrato;
    @XmlElement(name = "DatosTecnicos")
    protected String datosTecnicos;
    @XmlElement(name = "FechaUltimaModificacion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaUltimaModificacion;
    @XmlElement(name = "IsSVE")
    protected Boolean isSVE;
    @XmlElement(name = "ListaPersonasContacto")
    protected ListaPersonAutorizaType listaPersonasContacto;

    /**
     * Gets the value of the numContrato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumContrato() {
        return numContrato;
    }

    /**
     * Sets the value of the numContrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumContrato(String value) {
        this.numContrato = value;
    }

    /**
     * Gets the value of the nombreContrato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreContrato() {
        return nombreContrato;
    }

    /**
     * Sets the value of the nombreContrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreContrato(String value) {
        this.nombreContrato = value;
    }

    /**
     * Gets the value of the direccion property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccion() {
        return direccion;
    }

    /**
     * Sets the value of the direccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccion(DireccionType value) {
        this.direccion = value;
    }

    /**
     * Gets the value of the empresaTitular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresaTitular() {
        return empresaTitular;
    }

    /**
     * Sets the value of the empresaTitular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresaTitular(String value) {
        this.empresaTitular = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the listaLineasPedido property.
     * 
     * @return
     *     possible object is
     *     {@link ListaLineasPedidoType }
     *     
     */
    public ListaLineasPedidoType getListaLineasPedido() {
        return listaLineasPedido;
    }

    /**
     * Sets the value of the listaLineasPedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaLineasPedidoType }
     *     
     */
    public void setListaLineasPedido(ListaLineasPedidoType value) {
        this.listaLineasPedido = value;
    }

    /**
     * Gets the value of the facturaDigital property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFacturaDigital() {
        return facturaDigital;
    }

    /**
     * Sets the value of the facturaDigital property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFacturaDigital(Boolean value) {
        this.facturaDigital = value;
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
     * Gets the value of the validacionNoSuperada property.
     * 
     * @return
     *     possible object is
     *     {@link ValidacionType }
     *     
     */
    public ValidacionType getValidacionNoSuperada() {
        return validacionNoSuperada;
    }

    /**
     * Sets the value of the validacionNoSuperada property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidacionType }
     *     
     */
    public void setValidacionNoSuperada(ValidacionType value) {
        this.validacionNoSuperada = value;
    }

    /**
     * Gets the value of the idContrato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdContrato() {
        return idContrato;
    }

    /**
     * Sets the value of the idContrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdContrato(String value) {
        this.idContrato = value;
    }

    /**
     * Gets the value of the idCuentaComercial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCuentaComercial() {
        return idCuentaComercial;
    }

    /**
     * Sets the value of the idCuentaComercial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCuentaComercial(String value) {
        this.idCuentaComercial = value;
    }

    /**
     * Gets the value of the descripcionCuentaComercial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionCuentaComercial() {
        return descripcionCuentaComercial;
    }

    /**
     * Sets the value of the descripcionCuentaComercial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionCuentaComercial(String value) {
        this.descripcionCuentaComercial = value;
    }

    /**
     * Gets the value of the listaContratosAsociados property.
     * 
     * @return
     *     possible object is
     *     {@link ListaDatosContratoType }
     *     
     */
    public ListaDatosContratoType getListaContratosAsociados() {
        return listaContratosAsociados;
    }

    /**
     * Sets the value of the listaContratosAsociados property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaDatosContratoType }
     *     
     */
    public void setListaContratosAsociados(ListaDatosContratoType value) {
        this.listaContratosAsociados = value;
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
     * Gets the value of the cups property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUPS() {
        return cups;
    }

    /**
     * Sets the value of the cups property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUPS(String value) {
        this.cups = value;
    }

    /**
     * Gets the value of the listaDocumentacionAdjunta property.
     * 
     * @return
     *     possible object is
     *     {@link ListaDocumentosAdjuntosType }
     *     
     */
    public ListaDocumentosAdjuntosType getListaDocumentacionAdjunta() {
        return listaDocumentacionAdjunta;
    }

    /**
     * Sets the value of the listaDocumentacionAdjunta property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaDocumentosAdjuntosType }
     *     
     */
    public void setListaDocumentacionAdjunta(ListaDocumentosAdjuntosType value) {
        this.listaDocumentacionAdjunta = value;
    }

    /**
     * Gets the value of the listaDocumentacionNoAdjunta property.
     * 
     * @return
     *     possible object is
     *     {@link ListaDocumentosPendientesType }
     *     
     */
    public ListaDocumentosPendientesType getListaDocumentacionNoAdjunta() {
        return listaDocumentacionNoAdjunta;
    }

    /**
     * Sets the value of the listaDocumentacionNoAdjunta property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaDocumentosPendientesType }
     *     
     */
    public void setListaDocumentacionNoAdjunta(ListaDocumentosPendientesType value) {
        this.listaDocumentacionNoAdjunta = value;
    }

    /**
     * Gets the value of the fechaRescision property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRescision() {
        return fechaRescision;
    }

    /**
     * Sets the value of the fechaRescision property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRescision(XMLGregorianCalendar value) {
        this.fechaRescision = value;
    }

    /**
     * Gets the value of the deudaPendiente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeudaPendiente() {
        return deudaPendiente;
    }

    /**
     * Sets the value of the deudaPendiente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeudaPendiente(String value) {
        this.deudaPendiente = value;
    }

    /**
     * Gets the value of the productoAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link ProductoType }
     *     
     */
    public ProductoType getProductoAsociado() {
        return productoAsociado;
    }

    /**
     * Sets the value of the productoAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductoType }
     *     
     */
    public void setProductoAsociado(ProductoType value) {
        this.productoAsociado = value;
    }

    /**
     * Gets the value of the codigoUltimaFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoUltimaFactura() {
        return codigoUltimaFactura;
    }

    /**
     * Sets the value of the codigoUltimaFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoUltimaFactura(String value) {
        this.codigoUltimaFactura = value;
    }

    /**
     * Gets the value of the importeUltimaFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteUltimaFactura() {
        return importeUltimaFactura;
    }

    /**
     * Sets the value of the importeUltimaFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteUltimaFactura(String value) {
        this.importeUltimaFactura = value;
    }

    /**
     * Gets the value of the bonoSocial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBonoSocial() {
        return bonoSocial;
    }

    /**
     * Sets the value of the bonoSocial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBonoSocial(String value) {
        this.bonoSocial = value;
    }

    /**
     * Gets the value of the cuentaComercial property.
     * 
     * @return
     *     possible object is
     *     {@link CuentaComercType }
     *     
     */
    public CuentaComercType getCuentaComercial() {
        return cuentaComercial;
    }

    /**
     * Sets the value of the cuentaComercial property.
     * 
     * @param value
     *     allowed object is
     *     {@link CuentaComercType }
     *     
     */
    public void setCuentaComercial(CuentaComercType value) {
        this.cuentaComercial = value;
    }

    /**
     * Gets the value of the potencia property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotencia() {
        return potencia;
    }

    /**
     * Sets the value of the potencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotencia(BigDecimal value) {
        this.potencia = value;
    }

    /**
     * Gets the value of the propiedadEquipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropiedadEquipo() {
        return propiedadEquipo;
    }

    /**
     * Sets the value of the propiedadEquipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropiedadEquipo(String value) {
        this.propiedadEquipo = value;
    }

    /**
     * Gets the value of the consumoMedio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsumoMedio() {
        return consumoMedio;
    }

    /**
     * Sets the value of the consumoMedio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsumoMedio(String value) {
        this.consumoMedio = value;
    }

    /**
     * Gets the value of the caudal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaudal() {
        return caudal;
    }

    /**
     * Sets the value of the caudal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaudal(String value) {
        this.caudal = value;
    }

    /**
     * Gets the value of the tension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTension() {
        return tension;
    }

    /**
     * Sets the value of the tension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTension(String value) {
        this.tension = value;
    }

    /**
     * Gets the value of the equipoMedida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipoMedida() {
        return equipoMedida;
    }

    /**
     * Sets the value of the equipoMedida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipoMedida(String value) {
        this.equipoMedida = value;
    }

    /**
     * Gets the value of the discriminacionHoraria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscriminacionHoraria() {
        return discriminacionHoraria;
    }

    /**
     * Sets the value of the discriminacionHoraria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscriminacionHoraria(String value) {
        this.discriminacionHoraria = value;
    }

    /**
     * Gets the value of the tarifaATR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarifaATR() {
        return tarifaATR;
    }

    /**
     * Sets the value of the tarifaATR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarifaATR(String value) {
        this.tarifaATR = value;
    }

    /**
     * Gets the value of the potencia1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotencia1() {
        return potencia1;
    }

    /**
     * Sets the value of the potencia1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotencia1(BigDecimal value) {
        this.potencia1 = value;
    }

    /**
     * Gets the value of the potencia2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotencia2() {
        return potencia2;
    }

    /**
     * Sets the value of the potencia2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotencia2(BigDecimal value) {
        this.potencia2 = value;
    }

    /**
     * Gets the value of the potencia3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotencia3() {
        return potencia3;
    }

    /**
     * Sets the value of the potencia3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotencia3(BigDecimal value) {
        this.potencia3 = value;
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
     * Gets the value of the presion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresion() {
        return presion;
    }

    /**
     * Sets the value of the presion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresion(String value) {
        this.presion = value;
    }

    /**
     * Gets the value of the controlPotencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlPotencia() {
        return controlPotencia;
    }

    /**
     * Sets the value of the controlPotencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlPotencia(String value) {
        this.controlPotencia = value;
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
     * Gets the value of the tipoContrato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoContrato() {
        return tipoContrato;
    }

    /**
     * Sets the value of the tipoContrato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoContrato(String value) {
        this.tipoContrato = value;
    }

    /**
     * Gets the value of the datosTecnicos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatosTecnicos() {
        return datosTecnicos;
    }

    /**
     * Sets the value of the datosTecnicos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatosTecnicos(String value) {
        this.datosTecnicos = value;
    }

    /**
     * Gets the value of the fechaUltimaModificacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    /**
     * Sets the value of the fechaUltimaModificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaUltimaModificacion(XMLGregorianCalendar value) {
        this.fechaUltimaModificacion = value;
    }

    /**
     * Gets the value of the isSVE property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSVE() {
        return isSVE;
    }

    /**
     * Sets the value of the isSVE property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSVE(Boolean value) {
        this.isSVE = value;
    }

    /**
     * Gets the value of the listaPersonasContacto property.
     * 
     * @return
     *     possible object is
     *     {@link ListaPersonAutorizaType }
     *     
     */
    public ListaPersonAutorizaType getListaPersonasContacto() {
        return listaPersonasContacto;
    }

    /**
     * Sets the value of the listaPersonasContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaPersonAutorizaType }
     *     
     */
    public void setListaPersonasContacto(ListaPersonAutorizaType value) {
        this.listaPersonasContacto = value;
    }

}
