
package org.example.sieme009_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemas.SOAHeaderResponseType;


/**
 * <p>Java class for GetEventosRelResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetEventosRelResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAHeaderResponse" type="{http://xmlns.endesa.com/CommonSchemas}SOAHeaderResponseType"/&gt;
 *         &lt;element name="GetEventosRelMsgResponse" type="{http://www.example.org/SIEME009_Schema/}GetEventosRelMsgResponseType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEventosRelResponseType", propOrder = {
    "soaHeaderResponse",
    "getEventosRelMsgResponse"
})
public class GetEventosRelResponseType {

    @XmlElement(name = "SOAHeaderResponse", required = true)
    protected SOAHeaderResponseType soaHeaderResponse;
    @XmlElement(name = "GetEventosRelMsgResponse", required = true)
    protected GetEventosRelMsgResponseType getEventosRelMsgResponse;

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
     * Gets the value of the getEventosRelMsgResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetEventosRelMsgResponseType }
     *     
     */
    public GetEventosRelMsgResponseType getGetEventosRelMsgResponse() {
        return getEventosRelMsgResponse;
    }

    /**
     * Sets the value of the getEventosRelMsgResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetEventosRelMsgResponseType }
     *     
     */
    public void setGetEventosRelMsgResponse(GetEventosRelMsgResponseType value) {
        this.getEventosRelMsgResponse = value;
    }

}
