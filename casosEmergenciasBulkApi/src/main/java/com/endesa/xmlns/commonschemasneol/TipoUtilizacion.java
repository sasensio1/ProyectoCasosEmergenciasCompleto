
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoUtilizacion.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoUtilizacion"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Habitual"/&gt;
 *     &lt;enumeration value="NoHabitual"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoUtilizacion")
@XmlEnum
public enum TipoUtilizacion {

    @XmlEnumValue("Habitual")
    HABITUAL("Habitual"),
    @XmlEnumValue("NoHabitual")
    NO_HABITUAL("NoHabitual");
    private final String value;

    TipoUtilizacion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoUtilizacion fromValue(String v) {
        for (TipoUtilizacion c: TipoUtilizacion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
