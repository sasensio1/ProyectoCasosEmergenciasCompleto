
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoCobro.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoCobro"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Domiciliada"/&gt;
 *     &lt;enumeration value="NoDomiciliada"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoCobro")
@XmlEnum
public enum TipoCobro {

    @XmlEnumValue("Domiciliada")
    DOMICILIADA("Domiciliada"),
    @XmlEnumValue("NoDomiciliada")
    NO_DOMICILIADA("NoDomiciliada");
    private final String value;

    TipoCobro(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoCobro fromValue(String v) {
        for (TipoCobro c: TipoCobro.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
