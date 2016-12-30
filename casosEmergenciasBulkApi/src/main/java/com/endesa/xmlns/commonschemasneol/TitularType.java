
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TitularType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TitularType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocIdentificativo" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="TipoIdentificativo" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="Nombre" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCompletoType" minOccurs="0"/&gt;
 *         &lt;element name="IdPersContacto" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdPersContacto" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TitularType", propOrder = {
    "docIdentificativo",
    "tipoIdentificativo",
    "nombre",
    "idPersContacto"
})
public class TitularType {

    @XmlElement(name = "DocIdentificativo")
    protected String docIdentificativo;
    @XmlElement(name = "TipoIdentificativo")
    protected String tipoIdentificativo;
    @XmlElement(name = "Nombre")
    protected NombreCompletoType nombre;
    @XmlElement(name = "IdPersContacto")
    protected String idPersContacto;

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

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link NombreCompletoType }
     *     
     */
    public NombreCompletoType getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link NombreCompletoType }
     *     
     */
    public void setNombre(NombreCompletoType value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the idPersContacto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPersContacto() {
        return idPersContacto;
    }

    /**
     * Sets the value of the idPersContacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPersContacto(String value) {
        this.idPersContacto = value;
    }

}
