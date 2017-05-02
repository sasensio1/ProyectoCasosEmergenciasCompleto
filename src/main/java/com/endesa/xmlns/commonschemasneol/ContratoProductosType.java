
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContratoProductosType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContratoProductosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumContrato"/&gt;
 *         &lt;element name="IdContrato" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdContrato" minOccurs="0"/&gt;
 *         &lt;element name="ListaProductos" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaProductosType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContratoProductosType", propOrder = {
    "numContrato",
    "idContrato",
    "listaProductos"
})
public class ContratoProductosType {

    @XmlElement(name = "NumContrato", required = true)
    protected String numContrato;
    @XmlElement(name = "IdContrato")
    protected String idContrato;
    @XmlElement(name = "ListaProductos")
    protected ListaProductosType listaProductos;

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
     * Gets the value of the listaProductos property.
     * 
     * @return
     *     possible object is
     *     {@link ListaProductosType }
     *     
     */
    public ListaProductosType getListaProductos() {
        return listaProductos;
    }

    /**
     * Sets the value of the listaProductos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaProductosType }
     *     
     */
    public void setListaProductos(ListaProductosType value) {
        this.listaProductos = value;
    }

}
