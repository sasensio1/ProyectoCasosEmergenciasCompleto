
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValorNormalizadoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValorNormalizadoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdLineaPedido" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdLineaPedido" minOccurs="0"/&gt;
 *         &lt;element name="IdCampo" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCampo" minOccurs="0"/&gt;
 *         &lt;element name="NombreCampo" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCampo" minOccurs="0"/&gt;
 *         &lt;element name="ListaPosibleValoresCampos" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaPosibleValoresCamposType" minOccurs="0"/&gt;
 *         &lt;element name="ValorDefecto" type="{http://xmlns.endesa.com/CommonSchemasNeol}ValorDefecto" minOccurs="0"/&gt;
 *         &lt;element name="IdLineaNegocio" type="{http://xmlns.endesa.com/CommonSchemasNeol}LineaNegocio" minOccurs="0"/&gt;
 *         &lt;element name="RequiereEnergetico" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValorNormalizadoType", propOrder = {
    "idLineaPedido",
    "idCampo",
    "nombreCampo",
    "listaPosibleValoresCampos",
    "valorDefecto",
    "idLineaNegocio",
    "requiereEnergetico"
})
public class ValorNormalizadoType {

    @XmlElement(name = "IdLineaPedido")
    protected String idLineaPedido;
    @XmlElement(name = "IdCampo")
    protected String idCampo;
    @XmlElement(name = "NombreCampo")
    protected String nombreCampo;
    @XmlElement(name = "ListaPosibleValoresCampos")
    protected ListaPosibleValoresCamposType listaPosibleValoresCampos;
    @XmlElement(name = "ValorDefecto")
    protected String valorDefecto;
    @XmlElement(name = "IdLineaNegocio")
    protected String idLineaNegocio;
    @XmlElement(name = "RequiereEnergetico")
    protected Boolean requiereEnergetico;

    /**
     * Gets the value of the idLineaPedido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdLineaPedido() {
        return idLineaPedido;
    }

    /**
     * Sets the value of the idLineaPedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdLineaPedido(String value) {
        this.idLineaPedido = value;
    }

    /**
     * Gets the value of the idCampo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCampo() {
        return idCampo;
    }

    /**
     * Sets the value of the idCampo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCampo(String value) {
        this.idCampo = value;
    }

    /**
     * Gets the value of the nombreCampo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCampo() {
        return nombreCampo;
    }

    /**
     * Sets the value of the nombreCampo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCampo(String value) {
        this.nombreCampo = value;
    }

    /**
     * Gets the value of the listaPosibleValoresCampos property.
     * 
     * @return
     *     possible object is
     *     {@link ListaPosibleValoresCamposType }
     *     
     */
    public ListaPosibleValoresCamposType getListaPosibleValoresCampos() {
        return listaPosibleValoresCampos;
    }

    /**
     * Sets the value of the listaPosibleValoresCampos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaPosibleValoresCamposType }
     *     
     */
    public void setListaPosibleValoresCampos(ListaPosibleValoresCamposType value) {
        this.listaPosibleValoresCampos = value;
    }

    /**
     * Gets the value of the valorDefecto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorDefecto() {
        return valorDefecto;
    }

    /**
     * Sets the value of the valorDefecto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorDefecto(String value) {
        this.valorDefecto = value;
    }

    /**
     * Gets the value of the idLineaNegocio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdLineaNegocio() {
        return idLineaNegocio;
    }

    /**
     * Sets the value of the idLineaNegocio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdLineaNegocio(String value) {
        this.idLineaNegocio = value;
    }

    /**
     * Gets the value of the requiereEnergetico property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequiereEnergetico() {
        return requiereEnergetico;
    }

    /**
     * Sets the value of the requiereEnergetico property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequiereEnergetico(Boolean value) {
        this.requiereEnergetico = value;
    }

}
