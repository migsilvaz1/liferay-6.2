/**
 * Indicator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.administracionpublica.wsGPRServices;

public class Indicator  implements java.io.Serializable {
    private java.lang.String advanceType;

    private java.lang.String description;

    private java.lang.String end_date;

    private java.lang.String frequency;

    private java.lang.String name;

    private java.lang.String pattern;

    private java.lang.String start_date;

    private java.lang.String uid_indicator;

    private java.lang.String uid_objective;

    private java.lang.String uid_project;

    private java.lang.String unidad;

    public Indicator() {
    }

    public Indicator(
           java.lang.String advanceType,
           java.lang.String description,
           java.lang.String end_date,
           java.lang.String frequency,
           java.lang.String name,
           java.lang.String pattern,
           java.lang.String start_date,
           java.lang.String uid_indicator,
           java.lang.String uid_objective,
           java.lang.String uid_project,
           java.lang.String unidad) {
           this.advanceType = advanceType;
           this.description = description;
           this.end_date = end_date;
           this.frequency = frequency;
           this.name = name;
           this.pattern = pattern;
           this.start_date = start_date;
           this.uid_indicator = uid_indicator;
           this.uid_objective = uid_objective;
           this.uid_project = uid_project;
           this.unidad = unidad;
    }


    /**
     * Gets the advanceType value for this Indicator.
     * 
     * @return advanceType
     */
    public java.lang.String getAdvanceType() {
        return advanceType;
    }


    /**
     * Sets the advanceType value for this Indicator.
     * 
     * @param advanceType
     */
    public void setAdvanceType(java.lang.String advanceType) {
        this.advanceType = advanceType;
    }


    /**
     * Gets the description value for this Indicator.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Indicator.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the end_date value for this Indicator.
     * 
     * @return end_date
     */
    public java.lang.String getEnd_date() {
        return end_date;
    }


    /**
     * Sets the end_date value for this Indicator.
     * 
     * @param end_date
     */
    public void setEnd_date(java.lang.String end_date) {
        this.end_date = end_date;
    }


    /**
     * Gets the frequency value for this Indicator.
     * 
     * @return frequency
     */
    public java.lang.String getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency value for this Indicator.
     * 
     * @param frequency
     */
    public void setFrequency(java.lang.String frequency) {
        this.frequency = frequency;
    }


    /**
     * Gets the name value for this Indicator.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Indicator.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the pattern value for this Indicator.
     * 
     * @return pattern
     */
    public java.lang.String getPattern() {
        return pattern;
    }


    /**
     * Sets the pattern value for this Indicator.
     * 
     * @param pattern
     */
    public void setPattern(java.lang.String pattern) {
        this.pattern = pattern;
    }


    /**
     * Gets the start_date value for this Indicator.
     * 
     * @return start_date
     */
    public java.lang.String getStart_date() {
        return start_date;
    }


    /**
     * Sets the start_date value for this Indicator.
     * 
     * @param start_date
     */
    public void setStart_date(java.lang.String start_date) {
        this.start_date = start_date;
    }


    /**
     * Gets the uid_indicator value for this Indicator.
     * 
     * @return uid_indicator
     */
    public java.lang.String getUid_indicator() {
        return uid_indicator;
    }


    /**
     * Sets the uid_indicator value for this Indicator.
     * 
     * @param uid_indicator
     */
    public void setUid_indicator(java.lang.String uid_indicator) {
        this.uid_indicator = uid_indicator;
    }


    /**
     * Gets the uid_objective value for this Indicator.
     * 
     * @return uid_objective
     */
    public java.lang.String getUid_objective() {
        return uid_objective;
    }


    /**
     * Sets the uid_objective value for this Indicator.
     * 
     * @param uid_objective
     */
    public void setUid_objective(java.lang.String uid_objective) {
        this.uid_objective = uid_objective;
    }


    /**
     * Gets the uid_project value for this Indicator.
     * 
     * @return uid_project
     */
    public java.lang.String getUid_project() {
        return uid_project;
    }


    /**
     * Sets the uid_project value for this Indicator.
     * 
     * @param uid_project
     */
    public void setUid_project(java.lang.String uid_project) {
        this.uid_project = uid_project;
    }


    /**
     * Gets the unidad value for this Indicator.
     * 
     * @return unidad
     */
    public java.lang.String getUnidad() {
        return unidad;
    }


    /**
     * Sets the unidad value for this Indicator.
     * 
     * @param unidad
     */
    public void setUnidad(java.lang.String unidad) {
        this.unidad = unidad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Indicator)) return false;
        Indicator other = (Indicator) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.advanceType==null && other.getAdvanceType()==null) || 
             (this.advanceType!=null &&
              this.advanceType.equals(other.getAdvanceType()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.end_date==null && other.getEnd_date()==null) || 
             (this.end_date!=null &&
              this.end_date.equals(other.getEnd_date()))) &&
            ((this.frequency==null && other.getFrequency()==null) || 
             (this.frequency!=null &&
              this.frequency.equals(other.getFrequency()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.pattern==null && other.getPattern()==null) || 
             (this.pattern!=null &&
              this.pattern.equals(other.getPattern()))) &&
            ((this.start_date==null && other.getStart_date()==null) || 
             (this.start_date!=null &&
              this.start_date.equals(other.getStart_date()))) &&
            ((this.uid_indicator==null && other.getUid_indicator()==null) || 
             (this.uid_indicator!=null &&
              this.uid_indicator.equals(other.getUid_indicator()))) &&
            ((this.uid_objective==null && other.getUid_objective()==null) || 
             (this.uid_objective!=null &&
              this.uid_objective.equals(other.getUid_objective()))) &&
            ((this.uid_project==null && other.getUid_project()==null) || 
             (this.uid_project!=null &&
              this.uid_project.equals(other.getUid_project()))) &&
            ((this.unidad==null && other.getUnidad()==null) || 
             (this.unidad!=null &&
              this.unidad.equals(other.getUnidad())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAdvanceType() != null) {
            _hashCode += getAdvanceType().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEnd_date() != null) {
            _hashCode += getEnd_date().hashCode();
        }
        if (getFrequency() != null) {
            _hashCode += getFrequency().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPattern() != null) {
            _hashCode += getPattern().hashCode();
        }
        if (getStart_date() != null) {
            _hashCode += getStart_date().hashCode();
        }
        if (getUid_indicator() != null) {
            _hashCode += getUid_indicator().hashCode();
        }
        if (getUid_objective() != null) {
            _hashCode += getUid_objective().hashCode();
        }
        if (getUid_project() != null) {
            _hashCode += getUid_project().hashCode();
        }
        if (getUnidad() != null) {
            _hashCode += getUnidad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Indicator.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "indicator"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("advanceType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "advanceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("end_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "end_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pattern");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pattern"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "start_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uid_indicator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uid_indicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uid_objective");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uid_objective"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uid_project");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uid_project"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
