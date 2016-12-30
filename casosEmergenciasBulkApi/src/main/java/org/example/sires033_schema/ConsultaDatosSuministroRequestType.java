
package org.example.sires033_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemas.SOAHeaderType;


/**
 * <p>Java class for ConsultaDatosSuministroRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultaDatosSuministroRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SOAHeader" type="{http://xmlns.endesa.com/CommonSchemas}SOAHeaderType"/&gt;
 *         &lt;element name="ConsultaDatosSuministroMsgRequest" type="{http://www.example.org/SIRES033_Schema}ConsultaDatosSuministroMsgRequestType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaDatosSuministroRequestType", propOrder = {
    "soaHeader",
    "consultaDatosSuministroMsgRequest"
})
public class ConsultaDatosSuministroRequestType {

    @XmlElement(name = "SOAHeader", required = true)
    protected SOAHeaderType soaHeader;
    @XmlElement(name = "ConsultaDatosSuministroMsgRequest", required = true)
    protected ConsultaDatosSuministroMsgRequestType consultaDatosSuministroMsgRequest;

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
     * Gets the value of the consultaDatosSuministroMsgRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaDatosSuministroMsgRequestType }
     *     
     */
    public ConsultaDatosSuministroMsgRequestType getConsultaDatosSuministroMsgRequest() {
        return consultaDatosSuministroMsgRequest;
    }

    /**
     * Sets the value of the consultaDatosSuministroMsgRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaDatosSuministroMsgRequestType }
     *     
     */
    public void setConsultaDatosSuministroMsgRequest(ConsultaDatosSuministroMsgRequestType value) {
        this.consultaDatosSuministroMsgRequest = value;
    }

}
