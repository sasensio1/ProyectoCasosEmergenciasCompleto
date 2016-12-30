
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaCondicionesLegalesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaCondicionesLegalesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CondicionLegal" type="{http://xmlns.endesa.com/CommonSchemasNeol}CondicionesLegales"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaCondicionesLegalesType", propOrder = {
    "condicionLegal"
})
public class ListaCondicionesLegalesType {

    @XmlElement(name = "CondicionLegal", required = true)
    protected String condicionLegal;

    /**
     * Gets the value of the condicionLegal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondicionLegal() {
        return condicionLegal;
    }

    /**
     * Sets the value of the condicionLegal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondicionLegal(String value) {
        this.condicionLegal = value;
    }

}
