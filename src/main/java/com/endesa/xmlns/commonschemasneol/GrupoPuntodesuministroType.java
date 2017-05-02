
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GrupoPuntodesuministroType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrupoPuntodesuministroType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdCliente" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCliente"/&gt;
 *         &lt;element name="CUPS" type="{http://xmlns.endesa.com/CommonSchemasNeol}CUPS"/&gt;
 *         &lt;element name="Telemedida" type="{http://xmlns.endesa.com/CommonSchemasNeol}Telemedida" minOccurs="0"/&gt;
 *         &lt;element name="TipoPuntoMedida" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoPuntoMedida" minOccurs="0"/&gt;
 *         &lt;element name="GrupoDatostecnicosobligatorios" type="{http://xmlns.endesa.com/CommonSchemasNeol}GrupoDatostecnicosobligatoriosType" minOccurs="0"/&gt;
 *         &lt;element name="GrupoGasObligatorio" type="{http://xmlns.endesa.com/CommonSchemasNeol}GrupoGasObligatorioType" minOccurs="0"/&gt;
 *         &lt;element name="GrupoDocumentosAdjuntos" type="{http://xmlns.endesa.com/CommonSchemasNeol}GrupoDocumentosAdjuntosType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrupoPuntodesuministroType", propOrder = {
    "idCliente",
    "cups",
    "telemedida",
    "tipoPuntoMedida",
    "grupoDatostecnicosobligatorios",
    "grupoGasObligatorio",
    "grupoDocumentosAdjuntos"
})
public class GrupoPuntodesuministroType {

    @XmlElement(name = "IdCliente", required = true)
    protected String idCliente;
    @XmlElement(name = "CUPS", required = true)
    protected String cups;
    @XmlElement(name = "Telemedida")
    protected String telemedida;
    @XmlElement(name = "TipoPuntoMedida")
    protected String tipoPuntoMedida;
    @XmlElement(name = "GrupoDatostecnicosobligatorios")
    protected GrupoDatostecnicosobligatoriosType grupoDatostecnicosobligatorios;
    @XmlElement(name = "GrupoGasObligatorio")
    protected GrupoGasObligatorioType grupoGasObligatorio;
    @XmlElement(name = "GrupoDocumentosAdjuntos")
    protected GrupoDocumentosAdjuntosType grupoDocumentosAdjuntos;

    /**
     * Gets the value of the idCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCliente(String value) {
        this.idCliente = value;
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
     * Gets the value of the telemedida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelemedida() {
        return telemedida;
    }

    /**
     * Sets the value of the telemedida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelemedida(String value) {
        this.telemedida = value;
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
     * Gets the value of the grupoDatostecnicosobligatorios property.
     * 
     * @return
     *     possible object is
     *     {@link GrupoDatostecnicosobligatoriosType }
     *     
     */
    public GrupoDatostecnicosobligatoriosType getGrupoDatostecnicosobligatorios() {
        return grupoDatostecnicosobligatorios;
    }

    /**
     * Sets the value of the grupoDatostecnicosobligatorios property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrupoDatostecnicosobligatoriosType }
     *     
     */
    public void setGrupoDatostecnicosobligatorios(GrupoDatostecnicosobligatoriosType value) {
        this.grupoDatostecnicosobligatorios = value;
    }

    /**
     * Gets the value of the grupoGasObligatorio property.
     * 
     * @return
     *     possible object is
     *     {@link GrupoGasObligatorioType }
     *     
     */
    public GrupoGasObligatorioType getGrupoGasObligatorio() {
        return grupoGasObligatorio;
    }

    /**
     * Sets the value of the grupoGasObligatorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrupoGasObligatorioType }
     *     
     */
    public void setGrupoGasObligatorio(GrupoGasObligatorioType value) {
        this.grupoGasObligatorio = value;
    }

    /**
     * Gets the value of the grupoDocumentosAdjuntos property.
     * 
     * @return
     *     possible object is
     *     {@link GrupoDocumentosAdjuntosType }
     *     
     */
    public GrupoDocumentosAdjuntosType getGrupoDocumentosAdjuntos() {
        return grupoDocumentosAdjuntos;
    }

    /**
     * Sets the value of the grupoDocumentosAdjuntos property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrupoDocumentosAdjuntosType }
     *     
     */
    public void setGrupoDocumentosAdjuntos(GrupoDocumentosAdjuntosType value) {
        this.grupoDocumentosAdjuntos = value;
    }

}
