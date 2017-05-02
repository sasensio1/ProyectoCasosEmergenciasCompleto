
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaRobinsonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaRobinsonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InfoRobinson" type="{http://xmlns.endesa.com/CommonSchemasNeol}InfoRobinsonType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaRobinsonType", propOrder = {
    "infoRobinson"
})
public class ListaRobinsonType {

    @XmlElement(name = "InfoRobinson", required = true)
    protected List<InfoRobinsonType> infoRobinson;

    /**
     * Gets the value of the infoRobinson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infoRobinson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoRobinson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfoRobinsonType }
     * 
     * 
     */
    public List<InfoRobinsonType> getInfoRobinson() {
        if (infoRobinson == null) {
            infoRobinson = new ArrayList<InfoRobinsonType>();
        }
        return this.infoRobinson;
    }

}
