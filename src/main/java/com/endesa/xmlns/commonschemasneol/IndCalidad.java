
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IndCalidad.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IndCalidad"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Alta"/&gt;
 *     &lt;enumeration value="Baja"/&gt;
 *     &lt;enumeration value="ModificacionRol"/&gt;
 *     &lt;enumeration value="ModificacionContratos"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IndCalidad")
@XmlEnum
public enum IndCalidad {

    @XmlEnumValue("Alta")
    ALTA("Alta"),
    @XmlEnumValue("Baja")
    BAJA("Baja"),
    @XmlEnumValue("ModificacionRol")
    MODIFICACION_ROL("ModificacionRol"),
    @XmlEnumValue("ModificacionContratos")
    MODIFICACION_CONTRATOS("ModificacionContratos");
    private final String value;

    IndCalidad(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IndCalidad fromValue(String v) {
        for (IndCalidad c: IndCalidad.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
