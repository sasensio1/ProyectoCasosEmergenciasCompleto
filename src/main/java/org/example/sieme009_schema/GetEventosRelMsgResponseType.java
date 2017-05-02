
package org.example.sieme009_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemasneol.ErrorHeaderType;


/**
 * <p>Java class for GetEventosRelMsgResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetEventosRelMsgResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListadoEventos" type="{http://www.example.org/SIEME009_Schema/}ListadoEventosType" minOccurs="0"/&gt;
 *         &lt;element name="ErrorHeader" type="{http://xmlns.endesa.com/CommonSchemasNeol}ErrorHeaderType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEventosRelMsgResponseType", propOrder = {
    "listadoEventos",
    "errorHeader"
})
public class GetEventosRelMsgResponseType {

    @XmlElement(name = "ListadoEventos")
    protected ListadoEventosType listadoEventos;
    @XmlElement(name = "ErrorHeader")
    protected ErrorHeaderType errorHeader;

    /**
     * Gets the value of the listadoEventos property.
     * 
     * @return
     *     possible object is
     *     {@link ListadoEventosType }
     *     
     */
    public ListadoEventosType getListadoEventos() {
        return listadoEventos;
    }

    /**
     * Sets the value of the listadoEventos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListadoEventosType }
     *     
     */
    public void setListadoEventos(ListadoEventosType value) {
        this.listadoEventos = value;
    }

    /**
     * Gets the value of the errorHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorHeaderType }
     *     
     */
    public ErrorHeaderType getErrorHeader() {
        return errorHeader;
    }

    /**
     * Sets the value of the errorHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorHeaderType }
     *     
     */
    public void setErrorHeader(ErrorHeaderType value) {
        this.errorHeader = value;
    }

}
