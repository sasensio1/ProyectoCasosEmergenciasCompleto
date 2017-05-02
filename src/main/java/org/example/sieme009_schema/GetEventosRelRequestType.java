
package org.example.sieme009_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemas.SOAHeaderType;


/**
 * <p>Java class for GetEventosRelRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetEventosRelRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAHeader" type="{http://xmlns.endesa.com/CommonSchemas}SOAHeaderType"/&gt;
 *         &lt;element name="GetEventosRelMsgRequest" type="{http://www.example.org/SIEME009_Schema/}GetEventosRelMsgRequestType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEventosRelRequestType", propOrder = {
    "soaHeader",
    "getEventosRelMsgRequest"
})
public class GetEventosRelRequestType {

    @XmlElement(name = "SOAHeader", required = true)
    protected SOAHeaderType soaHeader;
    @XmlElement(name = "GetEventosRelMsgRequest", required = true)
    protected GetEventosRelMsgRequestType getEventosRelMsgRequest;

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
     * Gets the value of the getEventosRelMsgRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetEventosRelMsgRequestType }
     *     
     */
    public GetEventosRelMsgRequestType getGetEventosRelMsgRequest() {
        return getEventosRelMsgRequest;
    }

    /**
     * Sets the value of the getEventosRelMsgRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetEventosRelMsgRequestType }
     *     
     */
    public void setGetEventosRelMsgRequest(GetEventosRelMsgRequestType value) {
        this.getEventosRelMsgRequest = value;
    }

}
