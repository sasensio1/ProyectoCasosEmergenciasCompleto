
package com.endesa.xmlns.commonschemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TraceDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TraceDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAId" type="{http://xmlns.endesa.com/CommonSchemas}SOAId"/&gt;
 *         &lt;element name="ExternalId" type="{http://xmlns.endesa.com/CommonSchemas}ExternalId"/&gt;
 *         &lt;element name="ServiceName" type="{http://xmlns.endesa.com/CommonSchemas}ServiceName"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TraceDataType", propOrder = {
    "soaId",
    "externalId",
    "serviceName"
})
public class TraceDataType {

    @XmlElement(name = "SOAId", required = true)
    protected String soaId;
    @XmlElement(name = "ExternalId", required = true)
    protected String externalId;
    @XmlElement(name = "ServiceName", required = true)
    protected String serviceName;

    /**
     * Gets the value of the soaId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOAId() {
        return soaId;
    }

    /**
     * Sets the value of the soaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOAId(String value) {
        this.soaId = value;
    }

    /**
     * Gets the value of the externalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the value of the externalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalId(String value) {
        this.externalId = value;
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

}
