
package org.example.sieme002_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemas.SOAHeaderType;


/**
 * <p>Java class for GetCalleRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCalleRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAHeader" type="{http://xmlns.endesa.com/CommonSchemas}SOAHeaderType"/&gt;
 *         &lt;element name="GetCalleMsgRequest" type="{http://www.example.org/SIEME002_Schema/}GetCalleMsgRequestType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCalleRequestType", propOrder = {
    "soaHeader",
    "getCalleMsgRequest"
})
public class GetCalleRequestType {

    @XmlElement(name = "SOAHeader", required = true)
    protected SOAHeaderType soaHeader;
    @XmlElement(name = "GetCalleMsgRequest", required = true)
    protected GetCalleMsgRequestType getCalleMsgRequest;

    /**
     * Gets the value of the soaHeader property.
     * 
     * @return
     *     possible object is
     *     {@link SOAHeaderType }
     *     
     */
    public SOAHeaderType getSOAHeader() {
        return soaHeader;
    }

    /**
     * Sets the value of the soaHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link SOAHeaderType }
     *     
     */
    public void setSOAHeader(SOAHeaderType value) {
        this.soaHeader = value;
    }

    /**
     * Gets the value of the getCalleMsgRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetCalleMsgRequestType }
     *     
     */
    public GetCalleMsgRequestType getGetCalleMsgRequest() {
        return getCalleMsgRequest;
    }

    /**
     * Sets the value of the getCalleMsgRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCalleMsgRequestType }
     *     
     */
    public void setGetCalleMsgRequest(GetCalleMsgRequestType value) {
        this.getCalleMsgRequest = value;
    }

}
