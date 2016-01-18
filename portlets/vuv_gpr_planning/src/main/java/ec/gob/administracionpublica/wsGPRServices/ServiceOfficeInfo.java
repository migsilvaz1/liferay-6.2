/**
 * ServiceOfficeInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.administracionpublica.wsGPRServices;

public class ServiceOfficeInfo  implements java.io.Serializable {
    private java.lang.String financeCode;

    private java.lang.String id;

    private java.lang.String name;

    private java.lang.String servicesInOperation;

    private java.lang.String shortName;

    private java.lang.String totalServices;

    public ServiceOfficeInfo() {
    }

    public ServiceOfficeInfo(
           java.lang.String financeCode,
           java.lang.String id,
           java.lang.String name,
           java.lang.String servicesInOperation,
           java.lang.String shortName,
           java.lang.String totalServices) {
           this.financeCode = financeCode;
           this.id = id;
           this.name = name;
           this.servicesInOperation = servicesInOperation;
           this.shortName = shortName;
           this.totalServices = totalServices;
    }


    /**
     * Gets the financeCode value for this ServiceOfficeInfo.
     * 
     * @return financeCode
     */
    public java.lang.String getFinanceCode() {
        return financeCode;
    }


    /**
     * Sets the financeCode value for this ServiceOfficeInfo.
     * 
     * @param financeCode
     */
    public void setFinanceCode(java.lang.String financeCode) {
        this.financeCode = financeCode;
    }


    /**
     * Gets the id value for this ServiceOfficeInfo.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ServiceOfficeInfo.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the name value for this ServiceOfficeInfo.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ServiceOfficeInfo.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the servicesInOperation value for this ServiceOfficeInfo.
     * 
     * @return servicesInOperation
     */
    public java.lang.String getServicesInOperation() {
        return servicesInOperation;
    }


    /**
     * Sets the servicesInOperation value for this ServiceOfficeInfo.
     * 
     * @param servicesInOperation
     */
    public void setServicesInOperation(java.lang.String servicesInOperation) {
        this.servicesInOperation = servicesInOperation;
    }


    /**
     * Gets the shortName value for this ServiceOfficeInfo.
     * 
     * @return shortName
     */
    public java.lang.String getShortName() {
        return shortName;
    }


    /**
     * Sets the shortName value for this ServiceOfficeInfo.
     * 
     * @param shortName
     */
    public void setShortName(java.lang.String shortName) {
        this.shortName = shortName;
    }


    /**
     * Gets the totalServices value for this ServiceOfficeInfo.
     * 
     * @return totalServices
     */
    public java.lang.String getTotalServices() {
        return totalServices;
    }


    /**
     * Sets the totalServices value for this ServiceOfficeInfo.
     * 
     * @param totalServices
     */
    public void setTotalServices(java.lang.String totalServices) {
        this.totalServices = totalServices;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceOfficeInfo)) return false;
        ServiceOfficeInfo other = (ServiceOfficeInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.financeCode==null && other.getFinanceCode()==null) || 
             (this.financeCode!=null &&
              this.financeCode.equals(other.getFinanceCode()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.servicesInOperation==null && other.getServicesInOperation()==null) || 
             (this.servicesInOperation!=null &&
              this.servicesInOperation.equals(other.getServicesInOperation()))) &&
            ((this.shortName==null && other.getShortName()==null) || 
             (this.shortName!=null &&
              this.shortName.equals(other.getShortName()))) &&
            ((this.totalServices==null && other.getTotalServices()==null) || 
             (this.totalServices!=null &&
              this.totalServices.equals(other.getTotalServices())));
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
        if (getFinanceCode() != null) {
            _hashCode += getFinanceCode().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getServicesInOperation() != null) {
            _hashCode += getServicesInOperation().hashCode();
        }
        if (getShortName() != null) {
            _hashCode += getShortName().hashCode();
        }
        if (getTotalServices() != null) {
            _hashCode += getTotalServices().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceOfficeInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "serviceOfficeInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("financeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "financeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("servicesInOperation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "servicesInOperation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shortName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalServices");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalServices"));
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
