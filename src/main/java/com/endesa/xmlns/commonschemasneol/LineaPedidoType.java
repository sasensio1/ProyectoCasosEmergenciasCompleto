
package com.endesa.xmlns.commonschemasneol;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineaPedidoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineaPedidoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumLinea" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumLinea" minOccurs="0"/&gt;
 *         &lt;element name="ContratoAsociado" type="{http://xmlns.endesa.com/CommonSchemasNeol}ContratoType" minOccurs="0"/&gt;
 *         &lt;element name="IsAnulable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Estado" type="{http://xmlns.endesa.com/CommonSchemasNeol}Estado" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineaPedidoType", propOrder = {
    "numLinea",
    "contratoAsociado",
    "isAnulable",
    "estado"
})
public class LineaPedidoType {

    @XmlElement(name = "NumLinea")
    protected BigInteger numLinea;
    @XmlElement(name = "ContratoAsociado")
    protected ContratoType contratoAsociado;
    @XmlElement(name = "IsAnulable")
    protected Boolean isAnulable;
    @XmlElement(name = "Estado")
    protected String estado;

    /**
     * Gets the value of the numLinea property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumLinea() {
        return numLinea;
    }

    /**
     * Sets the value of the numLinea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumLinea(BigInteger value) {
        this.numLinea = value;
    }

    /**
     * Gets the value of the contratoAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link ContratoType }
     *     
     */
    public ContratoType getContratoAsociado() {
        return contratoAsociado;
    }

    /**
     * Sets the value of the contratoAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContratoType }
     *     
     */
    public void setContratoAsociado(ContratoType value) {
        this.contratoAsociado = value;
    }

    /**
     * Gets the value of the isAnulable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAnulable() {
        return isAnulable;
    }

    /**
     * Sets the value of the isAnulable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAnulable(Boolean value) {
        this.isAnulable = value;
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

}
