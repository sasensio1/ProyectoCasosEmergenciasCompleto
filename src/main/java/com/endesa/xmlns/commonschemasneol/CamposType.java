
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CamposType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CamposType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdCampo" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCampo"/&gt;
 *         &lt;element name="NombreCampo" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCampo"/&gt;
 *         &lt;element name="ValorDefecto" type="{http://xmlns.endesa.com/CommonSchemasNeol}ValorDefecto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CamposType", propOrder = {
    "idCampo",
    "nombreCampo",
    "valorDefecto"
})
public class CamposType {

    @XmlElement(name = "IdCampo", required = true)
    protected String idCampo;
    @XmlElement(name = "NombreCampo", required = true)
    protected String nombreCampo;
    @XmlElement(name = "ValorDefecto", required = true)
    protected String valorDefecto;

    /**
     * Gets the value of the idCampo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCampo() {
        return idCampo;
    }

    /**
     * Sets the value of the idCampo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCampo(String value) {
        this.idCampo = value;
    }

    /**
     * Gets the value of the nombreCampo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCampo() {
        return nombreCampo;
    }

    /**
     * Sets the value of the nombreCampo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCampo(String value) {
        this.nombreCampo = value;
    }

    /**
     * Gets the value of the valorDefecto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorDefecto() {
        return valorDefecto;
    }

    /**
     * Sets the value of the valorDefecto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorDefecto(String value) {
        this.valorDefecto = value;
    }

}
