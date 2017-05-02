
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Campo" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCampo" minOccurs="0"/&gt;
 *         &lt;element name="ValorCampo" type="{http://xmlns.endesa.com/CommonSchemasNeol}ValorCampo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampoType", propOrder = {
    "campo",
    "valorCampo"
})
public class CampoType {

    @XmlElement(name = "Campo")
    protected String campo;
    @XmlElement(name = "ValorCampo")
    protected String valorCampo;

    /**
     * Gets the value of the campo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo() {
        return campo;
    }

    /**
     * Sets the value of the campo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo(String value) {
        this.campo = value;
    }

    /**
     * Gets the value of the valorCampo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorCampo() {
        return valorCampo;
    }

    /**
     * Sets the value of the valorCampo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorCampo(String value) {
        this.valorCampo = value;
    }

}
