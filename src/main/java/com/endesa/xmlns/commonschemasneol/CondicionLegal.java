
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CondicionLegal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CondicionLegal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="IdProducto" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdProducto"/&gt;
 *           &lt;element name="IdPromocion" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdPromocion"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="TextoCondiciones" type="{http://xmlns.endesa.com/CommonSchemasNeol}TextoCondiciones"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CondicionLegal", propOrder = {
    "idProducto",
    "idPromocion",
    "textoCondiciones"
})
public class CondicionLegal {

    @XmlElement(name = "IdProducto")
    protected String idProducto;
    @XmlElement(name = "IdPromocion")
    protected String idPromocion;
    @XmlElement(name = "TextoCondiciones", required = true)
    protected String textoCondiciones;

    /**
     * Gets the value of the idProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the value of the idProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProducto(String value) {
        this.idProducto = value;
    }

    /**
     * Gets the value of the idPromocion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPromocion() {
        return idPromocion;
    }

    /**
     * Sets the value of the idPromocion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPromocion(String value) {
        this.idPromocion = value;
    }

    /**
     * Gets the value of the textoCondiciones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoCondiciones() {
        return textoCondiciones;
    }

    /**
     * Sets the value of the textoCondiciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoCondiciones(String value) {
        this.textoCondiciones = value;
    }

}
