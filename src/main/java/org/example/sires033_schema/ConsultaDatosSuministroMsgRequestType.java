
package org.example.sires033_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultaDatosSuministroMsgRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultaDatosSuministroMsgRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodigoPais" type="{http://www.example.org/SIRES033_Schema}CodigoPais" minOccurs="0"/&gt;
 *         &lt;element name="CodigoEmpresa" type="{http://www.example.org/SIRES033_Schema}CodigoEmpresa"/&gt;
 *         &lt;element name="NumeroIdentificacion" type="{http://www.example.org/SIRES033_Schema}NumeroIdentificacion" minOccurs="0"/&gt;
 *         &lt;element name="NumeroIdentificacionEmpresa" type="{http://www.example.org/SIRES033_Schema}NumeroIdentificacionEmpresa" minOccurs="0"/&gt;
 *         &lt;element name="NumeroSuministro" type="{http://www.example.org/SIRES033_Schema}NumeroSuministro" minOccurs="0"/&gt;
 *         &lt;element name="Principal" type="{http://www.example.org/SIRES033_Schema}Principal"/&gt;
 *         &lt;element name="Ordenamiento" type="{http://www.example.org/SIRES033_Schema}OrdenType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaDatosSuministroMsgRequestType", propOrder = {
    "codigoPais",
    "codigoEmpresa",
    "numeroIdentificacion",
    "numeroIdentificacionEmpresa",
    "numeroSuministro",
    "principal",
    "ordenamiento"
})
public class ConsultaDatosSuministroMsgRequestType {

    @XmlElement(name = "CodigoPais")
    protected String codigoPais;
    @XmlElement(name = "CodigoEmpresa", required = true)
    protected String codigoEmpresa;
    @XmlElement(name = "NumeroIdentificacion")
    protected String numeroIdentificacion;
    @XmlElement(name = "NumeroIdentificacionEmpresa")
    protected String numeroIdentificacionEmpresa;
    @XmlElement(name = "NumeroSuministro")
    protected String numeroSuministro;
    @XmlElement(name = "Principal", required = true)
    protected String principal;
    @XmlElement(name = "Ordenamiento", required = true)
    protected OrdenType ordenamiento;

    /**
     * Gets the value of the codigoPais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * Sets the value of the codigoPais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPais(String value) {
        this.codigoPais = value;
    }

    /**
     * Gets the value of the codigoEmpresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    /**
     * Sets the value of the codigoEmpresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEmpresa(String value) {
        this.codigoEmpresa = value;
    }

    /**
     * Gets the value of the numeroIdentificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Sets the value of the numeroIdentificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIdentificacion(String value) {
        this.numeroIdentificacion = value;
    }

    /**
     * Gets the value of the numeroIdentificacionEmpresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIdentificacionEmpresa() {
        return numeroIdentificacionEmpresa;
    }

    /**
     * Sets the value of the numeroIdentificacionEmpresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIdentificacionEmpresa(String value) {
        this.numeroIdentificacionEmpresa = value;
    }

    /**
     * Gets the value of the numeroSuministro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSuministro() {
        return numeroSuministro;
    }

    /**
     * Sets the value of the numeroSuministro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSuministro(String value) {
        this.numeroSuministro = value;
    }

    /**
     * Gets the value of the principal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * Sets the value of the principal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipal(String value) {
        this.principal = value;
    }

    /**
     * Gets the value of the ordenamiento property.
     * 
     * @return
     *     possible object is
     *     {@link OrdenType }
     *     
     */
    public OrdenType getOrdenamiento() {
        return ordenamiento;
    }

    /**
     * Sets the value of the ordenamiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrdenType }
     *     
     */
    public void setOrdenamiento(OrdenType value) {
        this.ordenamiento = value;
    }

}
