
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InfoRobinsonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoRobinsonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Email" type="{http://xmlns.endesa.com/CommonSchemasNeol}Email"/&gt;
 *         &lt;element name="EstadoRobinson" type="{http://xmlns.endesa.com/CommonSchemasNeol}EstadoRobinson"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoRobinsonType", propOrder = {
    "email",
    "estadoRobinson"
})
public class InfoRobinsonType {

    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "EstadoRobinson", required = true)
    protected String estadoRobinson;

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the estadoRobinson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoRobinson() {
        return estadoRobinson;
    }

    /**
     * Sets the value of the estadoRobinson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoRobinson(String value) {
        this.estadoRobinson = value;
    }

}
