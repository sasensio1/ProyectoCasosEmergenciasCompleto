
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaginacionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaginacionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CampoOrdenacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}CampoOrdenacion"/&gt;
 *         &lt;element name="OrdenOrdenacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}OrdenOrdenacion"/&gt;
 *         &lt;element name="NumRegPag" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumRegistros"/&gt;
 *         &lt;element name="UltRegPag" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdRegistro"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaginacionType", propOrder = {
    "campoOrdenacion",
    "ordenOrdenacion",
    "numRegPag",
    "ultRegPag"
})
public class PaginacionType {

    @XmlElement(name = "CampoOrdenacion", required = true)
    protected String campoOrdenacion;
    @XmlElement(name = "OrdenOrdenacion", required = true)
    protected String ordenOrdenacion;
    @XmlElement(name = "NumRegPag", required = true)
    protected String numRegPag;
    @XmlElement(name = "UltRegPag", required = true)
    protected String ultRegPag;

    /**
     * Gets the value of the campoOrdenacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoOrdenacion() {
        return campoOrdenacion;
    }

    /**
     * Sets the value of the campoOrdenacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoOrdenacion(String value) {
        this.campoOrdenacion = value;
    }

    /**
     * Gets the value of the ordenOrdenacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdenOrdenacion() {
        return ordenOrdenacion;
    }

    /**
     * Sets the value of the ordenOrdenacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdenOrdenacion(String value) {
        this.ordenOrdenacion = value;
    }

    /**
     * Gets the value of the numRegPag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRegPag() {
        return numRegPag;
    }

    /**
     * Sets the value of the numRegPag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRegPag(String value) {
        this.numRegPag = value;
    }

    /**
     * Gets the value of the ultRegPag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltRegPag() {
        return ultRegPag;
    }

    /**
     * Sets the value of the ultRegPag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltRegPag(String value) {
        this.ultRegPag = value;
    }

}
