
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaLineasPedidoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaLineasPedidoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LineaPedido" type="{http://xmlns.endesa.com/CommonSchemasNeol}LineaPedidoType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaLineasPedidoType", propOrder = {
    "lineaPedido"
})
public class ListaLineasPedidoType {

    @XmlElement(name = "LineaPedido", required = true)
    protected List<LineaPedidoType> lineaPedido;

    /**
     * Gets the value of the lineaPedido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineaPedido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineaPedido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineaPedidoType }
     * 
     * 
     */
    public List<LineaPedidoType> getLineaPedido() {
        if (lineaPedido == null) {
            lineaPedido = new ArrayList<LineaPedidoType>();
        }
        return this.lineaPedido;
    }

}
