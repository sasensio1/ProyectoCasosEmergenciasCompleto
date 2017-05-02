
package com.endesa.xmlns.commonschemasneol;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoOpCambio.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoOpCambio"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CuentaComercial"/&gt;
 *     &lt;enumeration value="DireccionFacturacion"/&gt;
 *     &lt;enumeration value="FacturaDigital"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoOpCambio")
@XmlEnum
public enum TipoOpCambio {

    @XmlEnumValue("CuentaComercial")
    CUENTA_COMERCIAL("CuentaComercial"),
    @XmlEnumValue("DireccionFacturacion")
    DIRECCION_FACTURACION("DireccionFacturacion"),
    @XmlEnumValue("FacturaDigital")
    FACTURA_DIGITAL("FacturaDigital");
    private final String value;

    TipoOpCambio(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoOpCambio fromValue(String v) {
        for (TipoOpCambio c: TipoOpCambio.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
