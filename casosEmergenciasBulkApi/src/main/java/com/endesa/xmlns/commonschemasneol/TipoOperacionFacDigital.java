
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoOperacionFacDigital.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoOperacionFacDigital"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Activacion"/&gt;
 *     &lt;enumeration value="Desactivacion"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoOperacionFacDigital")
@XmlEnum
public enum TipoOperacionFacDigital {

    @XmlEnumValue("Activacion")
    ACTIVACION("Activacion"),
    @XmlEnumValue("Desactivacion")
    DESACTIVACION("Desactivacion");
    private final String value;

    TipoOperacionFacDigital(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoOperacionFacDigital fromValue(String v) {
        for (TipoOperacionFacDigital c: TipoOperacionFacDigital.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
