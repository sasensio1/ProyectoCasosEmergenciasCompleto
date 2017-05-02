
package org.example.sires033_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrdenType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrdenType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumeroRegistros" type="{http://www.example.org/SIRES033_Schema}NumeroRegistros"/&gt;
 *         &lt;element name="PosicionDesde" type="{http://www.example.org/SIRES033_Schema}PosicionDesde"/&gt;
 *         &lt;element name="CampoOrdenar" type="{http://www.example.org/SIRES033_Schema}CampoOrdenar"/&gt;
 *         &lt;element name="Orden" type="{http://www.example.org/SIRES033_Schema}Orden"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrdenType", propOrder = {
    "numeroRegistros",
    "posicionDesde",
    "campoOrdenar",
    "orden"
})
public class OrdenType {

    @XmlElement(name = "NumeroRegistros", required = true)
    protected String numeroRegistros;
    @XmlElement(name = "PosicionDesde", required = true)
    protected String posicionDesde;
    @XmlElement(name = "CampoOrdenar", required = true)
    protected String campoOrdenar;
    @XmlElement(name = "Orden", required = true)
    protected String orden;

    /**
     * Gets the value of the numeroRegistros property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroRegistros() {
        return numeroRegistros;
    }

    /**
     * Sets the value of the numeroRegistros property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroRegistros(String value) {
        this.numeroRegistros = value;
    }

    /**
     * Gets the value of the posicionDesde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosicionDesde() {
        return posicionDesde;
    }

    /**
     * Sets the value of the posicionDesde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosicionDesde(String value) {
        this.posicionDesde = value;
    }

    /**
     * Gets the value of the campoOrdenar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoOrdenar() {
        return campoOrdenar;
    }

    /**
     * Sets the value of the campoOrdenar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoOrdenar(String value) {
        this.campoOrdenar = value;
    }

    /**
     * Gets the value of the orden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrden() {
        return orden;
    }

    /**
     * Sets the value of the orden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrden(String value) {
        this.orden = value;
    }

}
