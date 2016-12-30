
package org.example.sieme002_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemas.SOAHeaderResponseType;


/**
 * <p>Java class for GetCalleResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCalleResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAHeaderResponse" type="{http://xmlns.endesa.com/CommonSchemas}SOAHeaderResponseType"/&gt;
 *         &lt;element name="GetCalleMsgResponse" type="{http://www.example.org/SIEME002_Schema/}GetCalleMsgResponseType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCalleResponseType", propOrder = {
    "soaHeaderResponse",
    "getCalleMsgResponse"
})
public class GetCalleResponseType {

    @XmlElement(name = "SOAHeaderResponse", required = true)
    protected SOAHeaderResponseType soaHeaderResponse;
    @XmlElement(name = "GetCalleMsgResponse", required = true)
    protected GetCalleMsgResponseType getCalleMsgResponse;

    /**
     * Gets the value of the soaHeaderResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SOAHeaderResponseType }
     *     
     */
    public SOAHeaderResponseType getSOAHeaderResponse() {
        return soaHeaderResponse;
    }

    /**
     * Sets the value of the soaHeaderResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SOAHeaderResponseType }
     *     
     */
    public void setSOAHeaderResponse(SOAHeaderResponseType value) {
        this.soaHeaderResponse = value;
    }

    /**
     * Gets the value of the getCalleMsgResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetCalleMsgResponseType }
     *     
     */
    public GetCalleMsgResponseType getGetCalleMsgResponse() {
        return getCalleMsgResponse;
    }

    /**
     * Sets the value of the getCalleMsgResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCalleMsgResponseType }
     *     
     */
    public void setGetCalleMsgResponse(GetCalleMsgResponseType value) {
        this.getCalleMsgResponse = value;
    }

}
