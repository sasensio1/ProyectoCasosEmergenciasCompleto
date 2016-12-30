
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GrupoGasObligatorioType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrupoGasObligatorioType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Presionbar" type="{http://xmlns.endesa.com/CommonSchemasNeol}Presion" minOccurs="0"/&gt;
 *         &lt;element name="CaudalMaximo" type="{http://xmlns.endesa.com/CommonSchemasNeol}Caudal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrupoGasObligatorioType", propOrder = {
    "presionbar",
    "caudalMaximo"
})
public class GrupoGasObligatorioType {

    @XmlElement(name = "Presionbar")
    protected String presionbar;
    @XmlElement(name = "CaudalMaximo")
    protected String caudalMaximo;

    /**
     * Gets the value of the presionbar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresionbar() {
        return presionbar;
    }

    /**
     * Sets the value of the presionbar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresionbar(String value) {
        this.presionbar = value;
    }

    /**
     * Gets the value of the caudalMaximo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaudalMaximo() {
        return caudalMaximo;
    }

    /**
     * Sets the value of the caudalMaximo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaudalMaximo(String value) {
        this.caudalMaximo = value;
    }

}
