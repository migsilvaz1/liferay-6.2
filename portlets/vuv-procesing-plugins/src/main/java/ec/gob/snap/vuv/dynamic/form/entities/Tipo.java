//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.03 at 08:24:32 AM CEST 
//


package ec.gob.snap.vuv.dynamic.form.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipo.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tipo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="java.lang.String"/>
 *     &lt;enumeration value="java.lang.Integer"/>
 *     &lt;enumeration value="java.lang.Double"/>
 *     &lt;enumeration value="java.math.BigDecimal"/>
 *     &lt;enumeration value="java.lang.Long"/>
 *     &lt;enumeration value="java.lang.Boolean"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipo")
@XmlEnum
public enum Tipo {

    @XmlEnumValue("java.lang.String")
    JAVA_LANG_STRING("java.lang.String"),
    @XmlEnumValue("java.lang.Integer")
    JAVA_LANG_INTEGER("java.lang.Integer"),
    @XmlEnumValue("java.lang.Double")
    JAVA_LANG_DOUBLE("java.lang.Double"),
    @XmlEnumValue("java.math.BigDecimal")
    JAVA_MATH_BIG_DECIMAL("java.math.BigDecimal"),
    @XmlEnumValue("java.lang.Long")
    JAVA_LANG_LONG("java.lang.Long"),
    @XmlEnumValue("java.lang.Boolean")
    JAVA_LANG_BOOLEAN("java.lang.Boolean");
    private final String value;

    Tipo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Tipo fromValue(String v) {
        for (Tipo c: Tipo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
