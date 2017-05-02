
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaIncompEncontType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaIncompEncontType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IncompEncont" type="{http://xmlns.endesa.com/CommonSchemasNeol}IncompEncontType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaIncompEncontType", propOrder = {
    "incompEncont"
})
public class ListaIncompEncontType {

    @XmlElement(name = "IncompEncont", required = true)
    protected List<IncompEncontType> incompEncont;

    /**
     * Gets the value of the incompEncont property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the incompEncont property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncompEncont().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncompEncontType }
     * 
     * 
     */
    public List<IncompEncontType> getIncompEncont() {
        if (incompEncont == null) {
            incompEncont = new ArrayList<IncompEncontType>();
        }
        return this.incompEncont;
    }

}
