
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
 * <p>Java class for IntegradorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegradorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Territorio" type="{http://xmlns.endesa.com/CommonSchemasNeol}Territorio" minOccurs="0"/&gt;
 *         &lt;element name="NumeroLectura" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumLectura" minOccurs="0"/&gt;
 *         &lt;element name="Descripcion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DescripcionIntegrador" minOccurs="0"/&gt;
 *         &lt;element name="Valor" type="{http://xmlns.endesa.com/CommonSchemasNeol}ValorIntegrador" minOccurs="0"/&gt;
 *         &lt;element name="FechaUltFactura" type="{http://xmlns.endesa.com/CommonSchemasNeol}Fecha" minOccurs="0"/&gt;
 *         &lt;element name="SolicitudesInteg" type="{http://xmlns.endesa.com/CommonSchemasNeol}SolicitudesIntegradorType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="NumRuedas" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumRuedas" minOccurs="0"/&gt;
 *         &lt;element name="Estimada" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="LecturaAutomatica" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegradorType", propOrder = {
    "territorio",
    "numeroLectura",
    "descripcion",
    "valor",
    "fechaUltFactura",
    "solicitudesInteg",
    "numRuedas",
    "estimada",
    "lecturaAutomatica"
})
public class IntegradorType {

    @XmlElement(name = "Territorio")
    protected String territorio;
    @XmlElement(name = "NumeroLectura")
    protected String numeroLectura;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "Valor")
    protected String valor;
    @XmlElement(name = "FechaUltFactura")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaUltFactura;
    @XmlElement(name = "SolicitudesInteg")
    protected List<SolicitudesIntegradorType> solicitudesInteg;
    @XmlElement(name = "NumRuedas")
    protected String numRuedas;
    @XmlElement(name = "Estimada")
    protected Boolean estimada;
    @XmlElement(name = "LecturaAutomatica")
    protected Boolean lecturaAutomatica;

    /**
     * Gets the value of the territorio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerritorio() {
        return territorio;
    }

    /**
     * Sets the value of the territorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerritorio(String value) {
        this.territorio = value;
    }

    /**
     * Gets the value of the numeroLectura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroLectura() {
        return numeroLectura;
    }

    /**
     * Sets the value of the numeroLectura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroLectura(String value) {
        this.numeroLectura = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
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
     * Gets the value of the fechaUltFactura property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaUltFactura() {
        return fechaUltFactura;
    }

    /**
     * Sets the value of the fechaUltFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaUltFactura(XMLGregorianCalendar value) {
        this.fechaUltFactura = value;
    }

    /**
     * Gets the value of the solicitudesInteg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the solicitudesInteg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSolicitudesInteg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SolicitudesIntegradorType }
     * 
     * 
     */
    public List<SolicitudesIntegradorType> getSolicitudesInteg() {
        if (solicitudesInteg == null) {
            solicitudesInteg = new ArrayList<SolicitudesIntegradorType>();
        }
        return this.solicitudesInteg;
    }

    /**
     * Gets the value of the numRuedas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRuedas() {
        return numRuedas;
    }

    /**
     * Sets the value of the numRuedas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRuedas(String value) {
        this.numRuedas = value;
    }

    /**
     * Gets the value of the estimada property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEstimada() {
        return estimada;
    }

    /**
     * Sets the value of the estimada property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEstimada(Boolean value) {
        this.estimada = value;
    }

    /**
     * Gets the value of the lecturaAutomatica property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLecturaAutomatica() {
        return lecturaAutomatica;
    }

    /**
     * Sets the value of the lecturaAutomatica property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLecturaAutomatica(Boolean value) {
        this.lecturaAutomatica = value;
    }

}
