
package com.endesa.xmlns.commonschemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ErrorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ErrorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Correction" type="{http://xmlns.endesa.com/CommonSchemas}Correction"/&gt;
 *         &lt;element name="ErrorCode" type="{http://xmlns.endesa.com/CommonSchemas}ErrorCode"/&gt;
 *         &lt;element name="ErrorDate" type="{http://xmlns.endesa.com/CommonSchemas}ErrorDate"/&gt;
 *         &lt;element name="ErrorMessage" type="{http://xmlns.endesa.com/CommonSchemas}ErrorMessage"/&gt;
 *         &lt;element ref="{http://xmlns.endesa.com/CommonSchemas}ErrorType"/&gt;
 *         &lt;element name="Module" type="{http://xmlns.endesa.com/CommonSchemas}Module"/&gt;
 *         &lt;element name="Process" type="{http://xmlns.endesa.com/CommonSchemas}Process"/&gt;
 *         &lt;element name="Severity" type="{http://xmlns.endesa.com/CommonSchemas}Severity"/&gt;
 *         &lt;element name="StackTrace" type="{http://xmlns.endesa.com/CommonSchemas}StackTrace"/&gt;
 *         &lt;element name="Task" type="{http://xmlns.endesa.com/CommonSchemas}Task"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorType", propOrder = {
    "correction",
    "errorCode",
    "errorDate",
    "errorMessage",
    "errorType",
    "module",
    "process",
    "severity",
    "stackTrace",
    "task"
})
public class ErrorType {

    @XmlElement(name = "Correction", required = true)
    protected String correction;
    @XmlElement(name = "ErrorCode", required = true)
    protected String errorCode;
    @XmlElement(name = "ErrorDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar errorDate;
    @XmlElement(name = "ErrorMessage", required = true)
    protected String errorMessage;
    @XmlElement(name = "ErrorType", required = true)
    protected String errorType;
    @XmlElement(name = "Module", required = true)
    protected String module;
    @XmlElement(name = "Process", required = true)
    protected String process;
    @XmlElement(name = "Severity", required = true)
    protected String severity;
    @XmlElement(name = "StackTrace", required = true)
    protected String stackTrace;
    @XmlElement(name = "Task", required = true)
    protected String task;

    /**
     * Gets the value of the correction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrection() {
        return correction;
    }

    /**
     * Sets the value of the correction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrection(String value) {
        this.correction = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getErrorDate() {
        return errorDate;
    }

    /**
     * Sets the value of the errorDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setErrorDate(XMLGregorianCalendar value) {
        this.errorDate = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the errorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * Sets the value of the errorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorType(String value) {
        this.errorType = value;
    }

    /**
     * Gets the value of the module property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModule() {
        return module;
    }

    /**
     * Sets the value of the module property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModule(String value) {
        this.module = value;
    }

    /**
     * Gets the value of the process property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcess(String value) {
        this.process = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the stackTrace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * Sets the value of the stackTrace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStackTrace(String value) {
        this.stackTrace = value;
    }

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTask(String value) {
        this.task = value;
    }

}
