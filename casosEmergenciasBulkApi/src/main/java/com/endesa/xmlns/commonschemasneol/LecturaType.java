
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for LecturaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LecturaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FechaLectura" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha"/&gt;
 *         &lt;element name="Valor" type="{http://xmlns.endesa.com/CommonSchemasNeol}ValorLectura"/&gt;
 *         &lt;element name="IntegradorAsociado" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaIntegradoresType"/&gt;
 *         &lt;element name="Estimada" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LecturaType", propOrder = {
    "fechaLectura",
    "valor",
    "integradorAsociado",
    "estimada"
})
public class LecturaType {

    @XmlElement(name = "FechaLectura", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaLectura;
    @XmlElement(name = "Valor", required = true)
    protected String valor;
    @XmlElement(name = "IntegradorAsociado", required = true)
    protected ListaIntegradoresType integradorAsociado;
    @XmlElement(name = "Estimada")
    protected boolean estimada;

    /**
     * Gets the value of the fechaLectura property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaLectura() {
        return fechaLectura;
    }

    /**
     * Sets the value of the fechaLectura property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaLectura(XMLGregorianCalendar value) {
        this.fechaLectura = value;
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

    /**
     * Gets the value of the integradorAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link ListaIntegradoresType }
     *     
     */
    public ListaIntegradoresType getIntegradorAsociado() {
        return integradorAsociado;
    }

    /**
     * Sets the value of the integradorAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaIntegradoresType }
     *     
     */
    public void setIntegradorAsociado(ListaIntegradoresType value) {
        this.integradorAsociado = value;
    }

    /**
     * Gets the value of the estimada property.
     * 
     */
    public boolean isEstimada() {
        return estimada;
    }

    /**
     * Sets the value of the estimada property.
     * 
     */
    public void setEstimada(boolean value) {
        this.estimada = value;
    }

}
