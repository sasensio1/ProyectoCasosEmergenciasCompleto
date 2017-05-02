
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OpcionesConfigType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpcionesConfigType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Opcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Valor" type="{http://xmlns.endesa.com/CommonSchemasNeol}Valor"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpcionesConfigType", propOrder = {
    "opcion",
    "valor"
})
public class OpcionesConfigType {

    @XmlElement(name = "Opcion", required = true)
    protected String opcion;
    @XmlElement(name = "Valor", required = true)
    protected String valor;

    /**
     * Gets the value of the opcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcion() {
        return opcion;
    }

    /**
     * Sets the value of the opcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcion(String value) {
        this.opcion = value;
    }

    /**
     * Gets the value of the valor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor() {
        return valor;
    }

    /**
     * Sets the value of the valor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor(String value) {
        this.valor = value;
    }

}
