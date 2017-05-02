
package com.endesa.xmlns.commonschemasneol;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecomendadorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecomendadorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TipoUtilizacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoUtilizacion"/&gt;
 *         &lt;element name="Npersonas" type="{http://xmlns.endesa.com/CommonSchemasNeol}Numero"/&gt;
 *         &lt;element name="Potencia" type="{http://xmlns.endesa.com/CommonSchemasNeol}Potencia"/&gt;
 *         &lt;element name="Suministro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TarifaLuz" type="{http://xmlns.endesa.com/CommonSchemasNeol}Tarifa"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecomendadorType", propOrder = {
    "tipoUtilizacion",
    "npersonas",
    "potencia",
    "suministro",
    "tarifaLuz"
})
public class RecomendadorType {

    @XmlElement(name = "TipoUtilizacion", required = true)
    @XmlSchemaType(name = "string")
    protected TipoUtilizacion tipoUtilizacion;
    @XmlElement(name = "Npersonas", required = true)
    protected String npersonas;
    @XmlElement(name = "Potencia", required = true)
    protected BigDecimal potencia;
    @XmlElement(name = "Suministro", required = true)
    protected String suministro;
    @XmlElement(name = "TarifaLuz", required = true)
    protected String tarifaLuz;

    /**
     * Gets the value of the tipoUtilizacion property.
     * 
     * @return
     *     possible object is
     *     {@link TipoUtilizacion }
     *     
     */
    public TipoUtilizacion getTipoUtilizacion() {
        return tipoUtilizacion;
    }

    /**
     * Sets the value of the tipoUtilizacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoUtilizacion }
     *     
     */
    public void setTipoUtilizacion(TipoUtilizacion value) {
        this.tipoUtilizacion = value;
    }

    /**
     * Gets the value of the npersonas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpersonas() {
        return npersonas;
    }

    /**
     * Sets the value of the npersonas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpersonas(String value) {
        this.npersonas = value;
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
     * Gets the value of the suministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuministro() {
        return suministro;
    }

    /**
     * Sets the value of the suministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuministro(String value) {
        this.suministro = value;
    }

    /**
     * Gets the value of the tarifaLuz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarifaLuz() {
        return tarifaLuz;
    }

    /**
     * Sets the value of the tarifaLuz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarifaLuz(String value) {
        this.tarifaLuz = value;
    }

}
