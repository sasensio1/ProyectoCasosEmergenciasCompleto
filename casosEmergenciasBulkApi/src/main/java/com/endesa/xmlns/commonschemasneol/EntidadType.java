
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntidadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntidadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TipoEntidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoEntidad"/&gt;
 *         &lt;element name="IdEntidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdEntidad"/&gt;
 *         &lt;element name="NumEntidadAsociada" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumEntidad"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntidadType", propOrder = {
    "tipoEntidad",
    "idEntidad",
    "numEntidadAsociada"
})
public class EntidadType {

    @XmlElement(name = "TipoEntidad", required = true)
    protected String tipoEntidad;
    @XmlElement(name = "IdEntidad", required = true)
    protected String idEntidad;
    @XmlElement(name = "NumEntidadAsociada", required = true)
    protected String numEntidadAsociada;

    /**
     * Gets the value of the tipoEntidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEntidad() {
        return tipoEntidad;
    }

    /**
     * Sets the value of the tipoEntidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEntidad(String value) {
        this.tipoEntidad = value;
    }

    /**
     * Gets the value of the idEntidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdEntidad() {
        return idEntidad;
    }

    /**
     * Sets the value of the idEntidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEntidad(String value) {
        this.idEntidad = value;
    }

    /**
     * Gets the value of the numEntidadAsociada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumEntidadAsociada() {
        return numEntidadAsociada;
    }

    /**
     * Sets the value of the numEntidadAsociada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumEntidadAsociada(String value) {
        this.numEntidadAsociada = value;
    }

}
