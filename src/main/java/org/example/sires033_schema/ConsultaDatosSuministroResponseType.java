
package org.example.sires033_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemas.SOAHeaderResponseType;


/**
 * <p>Java class for ConsultaDatosSuministroResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultaDatosSuministroResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAHeaderResponse" type="{http://xmlns.endesa.com/CommonSchemas}SOAHeaderResponseType"/&gt;
 *         &lt;element name="ConsultaDatosSuministroMsgResponse" type="{http://www.example.org/SIRES033_Schema}ConsultaDatosSuministroMsgResponseType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaDatosSuministroResponseType", propOrder = {
    "soaHeaderResponse",
    "consultaDatosSuministroMsgResponse"
})
public class ConsultaDatosSuministroResponseType {

    @XmlElement(name = "SOAHeaderResponse", required = true)
    protected SOAHeaderResponseType soaHeaderResponse;
    @XmlElement(name = "ConsultaDatosSuministroMsgResponse", required = true)
    protected ConsultaDatosSuministroMsgResponseType consultaDatosSuministroMsgResponse;

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
     * Gets the value of the consultaDatosSuministroMsgResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaDatosSuministroMsgResponseType }
     *     
     */
    public ConsultaDatosSuministroMsgResponseType getConsultaDatosSuministroMsgResponse() {
        return consultaDatosSuministroMsgResponse;
    }

    /**
     * Sets the value of the consultaDatosSuministroMsgResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaDatosSuministroMsgResponseType }
     *     
     */
    public void setConsultaDatosSuministroMsgResponse(ConsultaDatosSuministroMsgResponseType value) {
        this.consultaDatosSuministroMsgResponse = value;
    }

}
