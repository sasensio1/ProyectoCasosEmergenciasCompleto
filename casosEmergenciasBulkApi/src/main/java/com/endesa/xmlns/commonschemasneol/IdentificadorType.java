
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentificadorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentificadorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="CodigoClienteEndesa" type="{http://xmlns.endesa.com/CommonSchemasNeol}CodigoCliente"/&gt;
 *         &lt;element name="Documentacion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DocumentacionType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificadorType", propOrder = {
    "codigoClienteEndesa",
    "documentacion"
})
public class IdentificadorType {

    @XmlElement(name = "CodigoClienteEndesa")
    protected String codigoClienteEndesa;
    @XmlElement(name = "Documentacion")
    protected DocumentacionType documentacion;

    /**
     * Gets the value of the codigoClienteEndesa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoClienteEndesa() {
        return codigoClienteEndesa;
    }

    /**
     * Sets the value of the codigoClienteEndesa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoClienteEndesa(String value) {
        this.codigoClienteEndesa = value;
    }

    /**
     * Gets the value of the documentacion property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentacionType }
     *     
     */
    public DocumentacionType getDocumentacion() {
        return documentacion;
    }

    /**
     * Sets the value of the documentacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentacionType }
     *     
     */
    public void setDocumentacion(DocumentacionType value) {
        this.documentacion = value;
    }

}
