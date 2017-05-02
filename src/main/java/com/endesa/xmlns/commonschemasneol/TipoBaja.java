
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoBaja.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoBaja"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;length value="1"/&gt;
 *     &lt;enumeration value="L"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoBaja")
@XmlEnum
public enum TipoBaja {

    L,
    N;

    public String value() {
        return name();
    }

    public static TipoBaja fromValue(String v) {
        return valueOf(v);
    }

}
