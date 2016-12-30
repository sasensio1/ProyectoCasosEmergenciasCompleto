
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaNuevasCondicionesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaNuevasCondicionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdCondicion" type="{http://xmlns.endesa.com/CommonSchemasNeol}IdCondicion" maxOccurs="unbounded"/&gt;
 *         &lt;element name="DetalleCondicion" type="{http://xmlns.endesa.com/CommonSchemasNeol}DetalleCondicion" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaNuevasCondicionesType", propOrder = {
    "idCondicion",
    "detalleCondicion"
})
public class ListaNuevasCondicionesType {

    @XmlElement(name = "IdCondicion", required = true)
    protected List<String> idCondicion;
    @XmlElement(name = "DetalleCondicion", required = true)
    protected List<String> detalleCondicion;

    /**
     * Gets the value of the idCondicion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idCondicion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdCondicion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIdCondicion() {
        if (idCondicion == null) {
            idCondicion = new ArrayList<String>();
        }
        return this.idCondicion;
    }

    /**
     * Gets the value of the detalleCondicion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleCondicion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleCondicion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDetalleCondicion() {
        if (detalleCondicion == null) {
            detalleCondicion = new ArrayList<String>();
        }
        return this.detalleCondicion;
    }

}
