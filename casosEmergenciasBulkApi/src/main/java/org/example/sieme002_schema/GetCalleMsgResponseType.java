
package org.example.sieme002_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemasneol.ErrorHeaderType;


/**
 * <p>Java class for GetCalleMsgResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCalleMsgResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListadoCalles" type="{http://www.example.org/SIEME002_Schema/}ListadoCallesType" minOccurs="0"/&gt;
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
@XmlType(name = "GetCalleMsgResponseType", propOrder = {
    "listadoCalles",
    "errorHeader"
})
public class GetCalleMsgResponseType {

    @XmlElement(name = "ListadoCalles")
    protected ListadoCallesType listadoCalles;
    @XmlElement(name = "ErrorHeader")
    protected ErrorHeaderType errorHeader;

    /**
     * Gets the value of the listadoCalles property.
     * 
     * @return
     *     possible object is
     *     {@link ListadoCallesType }
     *     
     */
    public ListadoCallesType getListadoCalles() {
        return listadoCalles;
    }

    /**
     * Sets the value of the listadoCalles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListadoCallesType }
     *     
     */
    public void setListadoCalles(ListadoCallesType value) {
        this.listadoCalles = value;
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
