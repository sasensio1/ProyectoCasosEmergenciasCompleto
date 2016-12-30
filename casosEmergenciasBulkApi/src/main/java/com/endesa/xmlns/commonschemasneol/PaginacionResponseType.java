
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaginacionResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaginacionResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nPagina" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumPaginas"/&gt;
 *         &lt;element name="NTotalPag" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTotalPaginas"/&gt;
 *         &lt;element name="UltElemRec" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumRegistros"/&gt;
 *         &lt;element name="UltRegPag" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdRegistro"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaginacionResponseType", propOrder = {
    "nPagina",
    "nTotalPag",
    "ultElemRec",
    "ultRegPag"
})
public class PaginacionResponseType {

    @XmlElement(required = true)
    protected String nPagina;
    @XmlElement(name = "NTotalPag", required = true)
    protected String nTotalPag;
    @XmlElement(name = "UltElemRec", required = true)
    protected String ultElemRec;
    @XmlElement(name = "UltRegPag", required = true)
    protected String ultRegPag;

    /**
     * Gets the value of the nPagina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNPagina() {
        return nPagina;
    }

    /**
     * Sets the value of the nPagina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNPagina(String value) {
        this.nPagina = value;
    }

    /**
     * Gets the value of the nTotalPag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNTotalPag() {
        return nTotalPag;
    }

    /**
     * Sets the value of the nTotalPag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNTotalPag(String value) {
        this.nTotalPag = value;
    }

    /**
     * Gets the value of the ultElemRec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltElemRec() {
        return ultElemRec;
    }

    /**
     * Sets the value of the ultElemRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltElemRec(String value) {
        this.ultElemRec = value;
    }

    /**
     * Gets the value of the ultRegPag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltRegPag() {
        return ultRegPag;
    }

    /**
     * Sets the value of the ultRegPag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltRegPag(String value) {
        this.ultRegPag = value;
    }

}
