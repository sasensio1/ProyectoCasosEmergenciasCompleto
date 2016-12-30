
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentacionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentacionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocIdentificativo" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumDocIdent"/&gt;
 *         &lt;element name="TipoIdentificativo" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoDocIdent"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentacionType", propOrder = {
    "docIdentificativo",
    "tipoIdentificativo"
})
public class DocumentacionType {

    @XmlElement(name = "DocIdentificativo", required = true)
    protected String docIdentificativo;
    @XmlElement(name = "TipoIdentificativo", required = true)
    protected String tipoIdentificativo;

    /**
     * Gets the value of the docIdentificativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIdentificativo() {
        return docIdentificativo;
    }

    /**
     * Sets the value of the docIdentificativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIdentificativo(String value) {
        this.docIdentificativo = value;
    }

    /**
     * Gets the value of the tipoIdentificativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoIdentificativo() {
        return tipoIdentificativo;
    }

    /**
     * Sets the value of the tipoIdentificativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoIdentificativo(String value) {
        this.tipoIdentificativo = value;
    }

}
