
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaLecturasORQType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaLecturasORQType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Lectura" type="{http://xmlns.endesa.com/CommonSchemasNeol}LecturasORQType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaLecturasORQType", propOrder = {
    "lectura"
})
public class ListaLecturasORQType {

    @XmlElement(name = "Lectura")
    protected List<LecturasORQType> lectura;

    /**
     * Gets the value of the lectura property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lectura property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLectura().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LecturasORQType }
     * 
     * 
     */
    public List<LecturasORQType> getLectura() {
        if (lectura == null) {
            lectura = new ArrayList<LecturasORQType>();
        }
        return this.lectura;
    }

}
