
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaContratoGestionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaContratoGestionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ContratoGestion" type="{http://xmlns.endesa.com/CommonSchemasNeol}ContratoGestionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaContratoGestionType", propOrder = {
    "contratoGestion"
})
public class ListaContratoGestionType {

    @XmlElement(name = "ContratoGestion")
    protected List<ContratoGestionType> contratoGestion;

    /**
     * Gets the value of the contratoGestion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contratoGestion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContratoGestion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContratoGestionType }
     * 
     * 
     */
    public List<ContratoGestionType> getContratoGestion() {
        if (contratoGestion == null) {
            contratoGestion = new ArrayList<ContratoGestionType>();
        }
        return this.contratoGestion;
    }

}
