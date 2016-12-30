
package com.endesa.xmlns.commonschemasneol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListaCamposType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListaCamposType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Campos" type="{http://xmlns.endesa.com/CommonSchemasNeol}CamposType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="ListaPosibleValoresCampos" type="{http://xmlns.endesa.com/CommonSchemasNeol}ListaPosibleValoresCamposType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaCamposType", propOrder = {
    "campos",
    "listaPosibleValoresCampos"
})
public class ListaCamposType {

    @XmlElement(name = "Campos", required = true)
    protected List<CamposType> campos;
    @XmlElement(name = "ListaPosibleValoresCampos")
    protected List<ListaPosibleValoresCamposType> listaPosibleValoresCampos;

    /**
     * Gets the value of the campos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CamposType }
     * 
     * 
     */
    public List<CamposType> getCampos() {
        if (campos == null) {
            campos = new ArrayList<CamposType>();
        }
        return this.campos;
    }

    /**
     * Gets the value of the listaPosibleValoresCampos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaPosibleValoresCampos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaPosibleValoresCampos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaPosibleValoresCamposType }
     * 
     * 
     */
    public List<ListaPosibleValoresCamposType> getListaPosibleValoresCampos() {
        if (listaPosibleValoresCampos == null) {
            listaPosibleValoresCampos = new ArrayList<ListaPosibleValoresCamposType>();
        }
        return this.listaPosibleValoresCampos;
    }

}
