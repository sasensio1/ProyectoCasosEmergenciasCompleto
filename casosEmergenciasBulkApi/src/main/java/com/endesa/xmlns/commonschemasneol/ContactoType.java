
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContactoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TipoDoc" type="{http://xmlns.endesa.com/CommonSchemasNeol}TipoDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="NumDoc" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumDocIdent" minOccurs="0"/&gt;
 *         &lt;element name="NombreEmpresa" type="{http://xmlns.endesa.com/CommonSchemasNeol}Empresa" minOccurs="0"/&gt;
 *         &lt;element name="Nombre" type="{http://xmlns.endesa.com/CommonSchemasNeol}NombreCompletoType" minOccurs="0"/&gt;
 *         &lt;element name="Nacionalidad" type="{http://xmlns.endesa.com/CommonSchemasNeol}Nacionalidad" minOccurs="0"/&gt;
 *         &lt;element name="Idioma" type="{http://xmlns.endesa.com/CommonSchemasNeol}Idioma" minOccurs="0"/&gt;
 *         &lt;element name="Telefono" type="{http://xmlns.endesa.com/CommonSchemasNeol}NumTelefono" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactoType", propOrder = {
    "tipoDoc",
    "numDoc",
    "nombreEmpresa",
    "nombre",
    "nacionalidad",
    "idioma",
    "telefono"
})
public class ContactoType {

    @XmlElement(name = "TipoDoc")
    protected String tipoDoc;
    @XmlElement(name = "NumDoc")
    protected String numDoc;
    @XmlElement(name = "NombreEmpresa")
    protected String nombreEmpresa;
    @XmlElement(name = "Nombre")
    protected NombreCompletoType nombre;
    @XmlElement(name = "Nacionalidad")
    protected String nacionalidad;
    @XmlElement(name = "Idioma")
    protected String idioma;
    @XmlElement(name = "Telefono")
    protected String telefono;

    /**
     * Gets the value of the tipoDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * Sets the value of the tipoDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDoc(String value) {
        this.tipoDoc = value;
    }

    /**
     * Gets the value of the numDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumDoc() {
        return numDoc;
    }

    /**
     * Sets the value of the numDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumDoc(String value) {
        this.numDoc = value;
    }

    /**
     * Gets the value of the nombreEmpresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Sets the value of the nombreEmpresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEmpresa(String value) {
        this.nombreEmpresa = value;
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
     * Gets the value of the nacionalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Sets the value of the nacionalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidad(String value) {
        this.nacionalidad = value;
    }

    /**
     * Gets the value of the idioma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Sets the value of the idioma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdioma(String value) {
        this.idioma = value;
    }

    /**
     * Gets the value of the telefono property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets the value of the telefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

}
