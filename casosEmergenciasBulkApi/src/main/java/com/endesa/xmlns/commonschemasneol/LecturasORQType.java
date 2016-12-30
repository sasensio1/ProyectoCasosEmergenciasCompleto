
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for LecturasORQType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LecturasORQType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FechaLectura" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha"/&gt;
 *         &lt;element name="IntegradorAsociado" type="{http://xmlns.endesa.com/CommonSchemasNeol}LecturaORQType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "LecturasORQType", propOrder = {
    "fechaLectura",
    "integradorAsociado",
    "estimada"
})
public class LecturasORQType {

    @XmlElement(name = "FechaLectura", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaLectura;
    @XmlElement(name = "IntegradorAsociado")
    protected List<LecturaORQType> integradorAsociado;
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
     * Gets the value of the integradorAsociado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the integradorAsociado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntegradorAsociado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LecturaORQType }
     * 
     * 
     */
    public List<LecturaORQType> getIntegradorAsociado() {
        if (integradorAsociado == null) {
            integradorAsociado = new ArrayList<LecturaORQType>();
        }
        return this.integradorAsociado;
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
