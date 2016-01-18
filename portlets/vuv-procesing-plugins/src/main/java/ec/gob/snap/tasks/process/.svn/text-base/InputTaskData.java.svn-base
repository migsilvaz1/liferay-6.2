/**
 * InputTaskData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.snap.tasks.process;

public class InputTaskData  implements java.io.Serializable {
    private java.lang.String idProcesoBPM;

    private java.lang.String userId;

    private java.lang.String profiles;

    public InputTaskData() {
    }

    public InputTaskData(
           java.lang.String idProcesoBPM,
           java.lang.String userId,
           java.lang.String profiles) {
           this.idProcesoBPM = idProcesoBPM;
           this.userId = userId;
           this.profiles = profiles;
    }


    /**
     * Gets the idProcesoBPM value for this InputTaskData.
     * 
     * @return idProcesoBPM
     */
    public java.lang.String getIdProcesoBPM() {
        return idProcesoBPM;
    }


    /**
     * Sets the idProcesoBPM value for this InputTaskData.
     * 
     * @param idProcesoBPM
     */
    public void setIdProcesoBPM(java.lang.String idProcesoBPM) {
        this.idProcesoBPM = idProcesoBPM;
    }


    /**
     * Gets the userId value for this InputTaskData.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this InputTaskData.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }


    /**
     * Gets the profiles value for this InputTaskData.
     * 
     * @return profiles
     */
    public java.lang.String getProfiles() {
        return profiles;
    }


    /**
     * Sets the profiles value for this InputTaskData.
     * 
     * @param profiles
     */
    public void setProfiles(java.lang.String profiles) {
        this.profiles = profiles;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputTaskData)) return false;
        InputTaskData other = (InputTaskData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idProcesoBPM==null && other.getIdProcesoBPM()==null) || 
             (this.idProcesoBPM!=null &&
              this.idProcesoBPM.equals(other.getIdProcesoBPM()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.profiles==null && other.getProfiles()==null) || 
             (this.profiles!=null &&
              this.profiles.equals(other.getProfiles())));
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
        if (getIdProcesoBPM() != null) {
            _hashCode += getIdProcesoBPM().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getProfiles() != null) {
            _hashCode += getProfiles().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputTaskData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://process.tasks.snap.gob.ec", ">inputTaskData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProcesoBPM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProcesoBPM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profiles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
