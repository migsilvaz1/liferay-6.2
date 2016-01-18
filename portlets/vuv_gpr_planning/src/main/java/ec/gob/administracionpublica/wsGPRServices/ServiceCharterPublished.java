/**
 * ServiceCharterPublished.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.administracionpublica.wsGPRServices;

public class ServiceCharterPublished  implements java.io.Serializable {
    private java.lang.String description;

    private java.lang.String entidadId;

    private java.lang.String entidadName;

    private java.lang.String timestamp;

    public ServiceCharterPublished() {
    }

    public ServiceCharterPublished(
           java.lang.String description,
           java.lang.String entidadId,
           java.lang.String entidadName,
           java.lang.String timestamp) {
           this.description = description;
           this.entidadId = entidadId;
           this.entidadName = entidadName;
           this.timestamp = timestamp;
    }


    /**
     * Gets the description value for this ServiceCharterPublished.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ServiceCharterPublished.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the entidadId value for this ServiceCharterPublished.
     * 
     * @return entidadId
     */
    public java.lang.String getEntidadId() {
        return entidadId;
    }


    /**
     * Sets the entidadId value for this ServiceCharterPublished.
     * 
     * @param entidadId
     */
    public void setEntidadId(java.lang.String entidadId) {
        this.entidadId = entidadId;
    }


    /**
     * Gets the entidadName value for this ServiceCharterPublished.
     * 
     * @return entidadName
     */
    public java.lang.String getEntidadName() {
        return entidadName;
    }


    /**
     * Sets the entidadName value for this ServiceCharterPublished.
     * 
     * @param entidadName
     */
    public void setEntidadName(java.lang.String entidadName) {
        this.entidadName = entidadName;
    }


    /**
     * Gets the timestamp value for this ServiceCharterPublished.
     * 
     * @return timestamp
     */
    public java.lang.String getTimestamp() {
        return timestamp;
    }


    /**
     * Sets the timestamp value for this ServiceCharterPublished.
     * 
     * @param timestamp
     */
    public void setTimestamp(java.lang.String timestamp) {
        this.timestamp = timestamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceCharterPublished)) return false;
        ServiceCharterPublished other = (ServiceCharterPublished) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.entidadId==null && other.getEntidadId()==null) || 
             (this.entidadId!=null &&
              this.entidadId.equals(other.getEntidadId()))) &&
            ((this.entidadName==null && other.getEntidadName()==null) || 
             (this.entidadName!=null &&
              this.entidadName.equals(other.getEntidadName()))) &&
            ((this.timestamp==null && other.getTimestamp()==null) || 
             (this.timestamp!=null &&
              this.timestamp.equals(other.getTimestamp())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEntidadId() != null) {
            _hashCode += getEntidadId().hashCode();
        }
        if (getEntidadName() != null) {
            _hashCode += getEntidadName().hashCode();
        }
        if (getTimestamp() != null) {
            _hashCode += getTimestamp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceCharterPublished.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "serviceCharterPublished"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidadId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entidadId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidadName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entidadName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timestamp"));
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
