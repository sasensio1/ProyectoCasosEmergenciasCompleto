
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoViaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoViaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodTipoVia" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodTipoVia" minOccurs="0"/&gt;
 *         &lt;element name="NomTipoVia" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreVia" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoViaType", propOrder = {
    "codTipoVia",
    "nomTipoVia"
})
public class TipoViaType {

    @XmlElement(name = "CodTipoVia")
    protected String codTipoVia;
    @XmlElement(name = "NomTipoVia")
    protected String nomTipoVia;

    /**
     * Gets the value of the codTipoVia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoVia() {
        return codTipoVia;
    }

    /**
     * Sets the value of the codTipoVia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoVia(String value) {
        this.codTipoVia = value;
    }

    /**
     * Gets the value of the nomTipoVia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomTipoVia() {
        return nomTipoVia;
    }

    /**
     * Sets the value of the nomTipoVia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomTipoVia(String value) {
        this.nomTipoVia = value;
    }

}
