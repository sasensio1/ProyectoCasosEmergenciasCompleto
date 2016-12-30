
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaDocumentosAdjuntosType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaDocumentosAdjuntosType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListDocumentosAdjuntados" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListDocumentosAdjuntadosType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaDocumentosAdjuntosType", propOrder = {
    "listDocumentosAdjuntados"
})
public class ListaDocumentosAdjuntosType {

    @XmlElement(name = "ListDocumentosAdjuntados", required = true)
    protected List<ListDocumentosAdjuntadosType> listDocumentosAdjuntados;

    /**
     * Gets the value of the listDocumentosAdjuntados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listDocumentosAdjuntados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListDocumentosAdjuntados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListDocumentosAdjuntadosType }
     * 
     * 
     */
    public List<ListDocumentosAdjuntadosType> getListDocumentosAdjuntados() {
        if (listDocumentosAdjuntados == null) {
            listDocumentosAdjuntados = new ArrayList<ListDocumentosAdjuntadosType>();
        }
        return this.listDocumentosAdjuntados;
    }

}
