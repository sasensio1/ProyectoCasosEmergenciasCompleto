
package org.example.sires033_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.endesa.xmlns.commonschemasneol.ErrorHeaderType;


/**
 * <p>Java class for ConsultaDatosSuministroMsgResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultaDatosSuministroMsgResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListadoSuministros" type="{http://www.example.org/SIRES033_Schema}ListadoSuministrosType" minOccurs="0"/&gt;
 *         &lt;element name="TotalRegistros" type="{http://www.example.org/SIRES033_Schema}TotalRegistros" minOccurs="0"/&gt;
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
@XmlType(name = "ConsultaDatosSuministroMsgResponseType", propOrder = {
    "listadoSuministros",
    "totalRegistros",
    "errorHeader"
})
public class ConsultaDatosSuministroMsgResponseType {

    @XmlElement(name = "ListadoSuministros")
    protected ListadoSuministrosType listadoSuministros;
    @XmlElement(name = "TotalRegistros")
    protected String totalRegistros;
    @XmlElement(name = "ErrorHeader")
    protected ErrorHeaderType errorHeader;

    /**
     * Gets the value of the listadoSuministros property.
     * 
     * @return
     *     possible object is
     *     {@link ListadoSuministrosType }
     *     
     */
    public ListadoSuministrosType getListadoSuministros() {
        return listadoSuministros;
    }

    /**
     * Sets the value of the listadoSuministros property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListadoSuministrosType }
     *     
     */
    public void setListadoSuministros(ListadoSuministrosType value) {
        this.listadoSuministros = value;
    }

    /**
     * Gets the value of the totalRegistros property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalRegistros() {
        return totalRegistros;
    }

    /**
     * Sets the value of the totalRegistros property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalRegistros(String value) {
        this.totalRegistros = value;
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
