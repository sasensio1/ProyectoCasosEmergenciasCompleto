
package com.endesa.xmlns.commonschemas;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AuditType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAId" type="{http://xmlns.endesa.com/CommonSchemas}SOAId"/&gt;
 *         &lt;element name="SourceApplication" type="{http://xmlns.endesa.com/CommonSchemas}SourceApplication"/&gt;
 *         &lt;element name="ServiceName" type="{http://xmlns.endesa.com/CommonSchemas}ServiceName"/&gt;
 *         &lt;element name="ExternalId" type="{http://xmlns.endesa.com/CommonSchemas}ExternalId" minOccurs="0"/&gt;
 *         &lt;element name="IP" type="{http://xmlns.endesa.com/CommonSchemas}IP" minOccurs="0"/&gt;
 *         &lt;element name="Client" type="{http://xmlns.endesa.com/CommonSchemas}Client" minOccurs="0"/&gt;
 *         &lt;element name="User" type="{http://xmlns.endesa.com/CommonSchemas}User" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{http://xmlns.endesa.com/CommonSchemas}Language" minOccurs="0"/&gt;
 *         &lt;element name="Version" type="{http://xmlns.endesa.com/CommonSchemas}Version" minOccurs="0"/&gt;
 *         &lt;element name="ArchitectureVersion" type="{http://xmlns.endesa.com/CommonSchemas}ArchitectureVersion" minOccurs="0"/&gt;
 *         &lt;element name="RequestRegisterFlag" type="{http://xmlns.endesa.com/CommonSchemas}RequestRegisterFlag" minOccurs="0"/&gt;
 *         &lt;element name="Layer" type="{http://xmlns.endesa.com/CommonSchemas}Layer"/&gt;
 *         &lt;element name="Status" type="{http://xmlns.endesa.com/CommonSchemas}Status"/&gt;
 *         &lt;element name="TimeStamp" type="{http://xmlns.endesa.com/CommonSchemas}TimeStamp"/&gt;
 *         &lt;element ref="{http://xmlns.endesa.com/CommonSchemas}Message" minOccurs="0"/&gt;
 *         &lt;element name="InFunctional" type="{http://xmlns.endesa.com/CommonSchemas}InFunctional" minOccurs="0"/&gt;
 *         &lt;element name="TimeLayer" type="{http://xmlns.endesa.com/CommonSchemas}TimeLayer" minOccurs="0"/&gt;
 *         &lt;element ref="{http://xmlns.endesa.com/CommonSchemas}Error" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditType", propOrder = {
    "soaId",
    "sourceApplication",
    "serviceName",
    "externalId",
    "ip",
    "client",
    "user",
    "language",
    "version",
    "architectureVersion",
    "requestRegisterFlag",
    "layer",
    "status",
    "timeStamp",
    "message",
    "inFunctional",
    "timeLayer",
    "error"
})
public class AuditType {

    @XmlElement(name = "SOAId", required = true)
    protected String soaId;
    @XmlElement(name = "SourceApplication", required = true)
    protected String sourceApplication;
    @XmlElement(name = "ServiceName", required = true)
    protected String serviceName;
    @XmlElement(name = "ExternalId")
    protected String externalId;
    @XmlElement(name = "IP")
    protected String ip;
    @XmlElement(name = "Client")
    protected String client;
    @XmlElement(name = "User")
    protected String user;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "Version")
    protected String version;
    @XmlElement(name = "ArchitectureVersion")
    protected String architectureVersion;
    @XmlElement(name = "RequestRegisterFlag")
    protected Boolean requestRegisterFlag;
    @XmlElement(name = "Layer", required = true)
    protected String layer;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "TimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "InFunctional")
    protected String inFunctional;
    @XmlElement(name = "TimeLayer")
    protected BigInteger timeLayer;
    @XmlElement(name = "Error")
    protected ErrorType error;

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

    /**
     * Gets the value of the requestRegisterFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequestRegisterFlag() {
        return requestRegisterFlag;
    }

    /**
     * Sets the value of the requestRegisterFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequestRegisterFlag(Boolean value) {
        this.requestRegisterFlag = value;
    }

    /**
     * Gets the value of the layer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLayer() {
        return layer;
    }

    /**
     * Sets the value of the layer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLayer(String value) {
        this.layer = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the inFunctional property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInFunctional() {
        return inFunctional;
    }

    /**
     * Sets the value of the inFunctional property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInFunctional(String value) {
        this.inFunctional = value;
    }

    /**
     * Gets the value of the timeLayer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeLayer() {
        return timeLayer;
    }

    /**
     * Sets the value of the timeLayer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeLayer(BigInteger value) {
        this.timeLayer = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setError(ErrorType value) {
        this.error = value;
    }

}
