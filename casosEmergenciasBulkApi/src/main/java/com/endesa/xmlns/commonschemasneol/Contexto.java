
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Contexto.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Contexto"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Recomendador"/&gt;
 *     &lt;enumeration value="Comparador"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Contexto")
@XmlEnum
public enum Contexto {

    @XmlEnumValue("Recomendador")
    RECOMENDADOR("Recomendador"),
    @XmlEnumValue("Comparador")
    COMPARADOR("Comparador");
    private final String value;

    Contexto(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Contexto fromValue(String v) {
        for (Contexto c: Contexto.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
