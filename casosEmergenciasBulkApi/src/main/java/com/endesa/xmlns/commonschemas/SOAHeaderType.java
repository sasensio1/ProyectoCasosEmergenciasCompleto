
package com.endesa.xmlns.commonschemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SOAHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SOAHeaderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAId" type="{http://xmlns.endesa.com/CommonSchemas}SOAId" minOccurs="0"/&gt;
 *         &lt;element name="SourceApplication" type="{http://xmlns.endesa.com/CommonSchemas}SourceApplication"/&gt;
 *         &lt;element name="ServiceName" type="{http://xmlns.endesa.com/CommonSchemas}ServiceName"/&gt;
 *         &lt;element name="ExternalId" type="{http://xmlns.endesa.com/CommonSchemas}ExternalId"/&gt;
 *         &lt;element name="IP" type="{http://xmlns.endesa.com/CommonSchemas}IP"/&gt;
 *         &lt;element name="Client" type="{http://xmlns.endesa.com/CommonSchemas}Client"/&gt;
 *         &lt;element name="User" type="{http://xmlns.endesa.com/CommonSchemas}User" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{http://xmlns.endesa.com/CommonSchemas}Language"/&gt;
 *         &lt;element name="Version" type="{http://xmlns.endesa.com/CommonSchemas}Version"/&gt;
 *         &lt;element name="ArchitectureVersion" type="{http://xmlns.endesa.com/CommonSchemas}ArchitectureVersion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOAHeaderType", propOrder = {
    "soaId",
    "sourceApplication",
    "serviceName",
    "externalId",
    "ip",
    "client",
    "user",
    "language",
    "version",
    "architectureVersion"
})
public class SOAHeaderType {

    @XmlElement(name = "SOAId")
    protected String soaId;
    @XmlElement(name = "SourceApplication", required = true)
    protected String sourceApplication;
    @XmlElement(name = "ServiceName", required = true)
    protected String serviceName;
    @XmlElement(name = "ExternalId", required = true)
    protected String externalId;
    @XmlElement(name = "IP", required = true)
    protected String ip;
    @XmlElement(name = "Client", required = true)
    protected String client;
    @XmlElement(name = "User")
    protected String user;
    @XmlElement(name = "Language", required = true)
    protected String language;
    @XmlElement(name = "Version", required = true)
    protected String version;
    @XmlElement(name = "ArchitectureVersion")
    protected String architectureVersion;

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
     * Gets the value of the sourceApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceApplication() {
        return sourceApplication;
    }

    /**
     * Sets the value of the sourceApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceApplication(String value) {
        this.sourceApplication = value;
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
     * Gets the value of the ip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIP() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIP(String value) {
        this.ip = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClient(String value) {
        this.client = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the architectureVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchitectureVersion() {
        return architectureVersion;
    }

    /**
     * Sets the value of the architectureVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchitectureVersion(String value) {
        this.architectureVersion = value;
    }

}
