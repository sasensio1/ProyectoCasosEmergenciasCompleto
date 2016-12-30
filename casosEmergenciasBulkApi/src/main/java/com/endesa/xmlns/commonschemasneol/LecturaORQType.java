
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LecturaORQType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LecturaORQType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdIntegrador" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ValorLectura" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LecturaORQType", propOrder = {
    "idIntegrador",
    "valorLectura"
})
public class LecturaORQType {

    @XmlElement(name = "IdIntegrador", required = true)
    protected String idIntegrador;
    @XmlElement(name = "ValorLectura")
    protected boolean valorLectura;

    /**
     * Gets the value of the idIntegrador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdIntegrador() {
        return idIntegrador;
    }

    /**
     * Sets the value of the idIntegrador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdIntegrador(String value) {
        this.idIntegrador = value;
    }

    /**
     * Gets the value of the valorLectura property.
     * 
     */
    public boolean isValorLectura() {
        return valorLectura;
    }

    /**
     * Sets the value of the valorLectura property.
     * 
     */
    public void setValorLectura(boolean value) {
        this.valorLectura = value;
    }

}
