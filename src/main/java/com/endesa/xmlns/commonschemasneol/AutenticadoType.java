
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutenticadoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutenticadoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DatosAutenticado" type="{http://xmlns.endesa.com/CommonSchemasNeol}AutorizadoType"/&gt;
 *         &lt;element name="DatosFacturacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DatosFacturacionType"/&gt;
 *         &lt;element name="DireccionPersContAntenticado" type="{http://xmlns.endesa.com/CommonSchemasNeol}DireccionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutenticadoType", propOrder = {
    "datosAutenticado",
    "datosFacturacion",
    "direccionPersContAntenticado"
})
public class AutenticadoType {

    @XmlElement(name = "DatosAutenticado", required = true)
    protected AutorizadoType datosAutenticado;
    @XmlElement(name = "DatosFacturacion", required = true)
    protected DatosFacturacionType datosFacturacion;
    @XmlElement(name = "DireccionPersContAntenticado")
    protected DireccionType direccionPersContAntenticado;

    /**
     * Gets the value of the datosAutenticado property.
     * 
     * @return
     *     possible object is
     *     {@link AutorizadoType }
     *     
     */
    public AutorizadoType getDatosAutenticado() {
        return datosAutenticado;
    }

    /**
     * Sets the value of the datosAutenticado property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutorizadoType }
     *     
     */
    public void setDatosAutenticado(AutorizadoType value) {
        this.datosAutenticado = value;
    }

    /**
     * Gets the value of the datosFacturacion property.
     * 
     * @return
     *     possible object is
     *     {@link DatosFacturacionType }
     *     
     */
    public DatosFacturacionType getDatosFacturacion() {
        return datosFacturacion;
    }

    /**
     * Sets the value of the datosFacturacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosFacturacionType }
     *     
     */
    public void setDatosFacturacion(DatosFacturacionType value) {
        this.datosFacturacion = value;
    }

    /**
     * Gets the value of the direccionPersContAntenticado property.
     * 
     * @return
     *     possible object is
     *     {@link DireccionType }
     *     
     */
    public DireccionType getDireccionPersContAntenticado() {
        return direccionPersContAntenticado;
    }

    /**
     * Sets the value of the direccionPersContAntenticado property.
     * 
     * @param value
     *     allowed object is
     *     {@link DireccionType }
     *     
     */
    public void setDireccionPersContAntenticado(DireccionType value) {
        this.direccionPersContAntenticado = value;
    }

}
