
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CUPSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CUPSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdCUPS" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TipoSuministro" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoSuministro"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUPSType", propOrder = {
    "idCUPS",
    "tipoSuministro"
})
public class CUPSType {

    @XmlElement(name = "IdCUPS", required = true)
    protected String idCUPS;
    @XmlElement(name = "TipoSuministro", required = true)
    protected String tipoSuministro;

    /**
     * Gets the value of the idCUPS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCUPS() {
        return idCUPS;
    }

    /**
     * Sets the value of the idCUPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCUPS(String value) {
        this.idCUPS = value;
    }

    /**
     * Gets the value of the tipoSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSuministro() {
        return tipoSuministro;
    }

    /**
     * Sets the value of the tipoSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSuministro(String value) {
        this.tipoSuministro = value;
    }

}
