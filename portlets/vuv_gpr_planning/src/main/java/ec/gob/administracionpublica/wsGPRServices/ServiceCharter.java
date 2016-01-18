/**
 * ServiceCharter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.administracionpublica.wsGPRServices;

public class ServiceCharter  implements java.io.Serializable {
    private java.lang.String citizenRights;

    private java.lang.String contactInfo;

    private java.lang.String description;

    private java.lang.String executiveOffice;

    private java.lang.String id;

    private java.lang.String improvementActions;

    private java.lang.String lastUpdateDate;

    private java.lang.String lastUpdateUser;

    private java.lang.String name;

    private java.lang.String[] serviceIds;

    private java.lang.String status;

    private java.lang.String userCollaboration;

    public ServiceCharter() {
    }

    public ServiceCharter(
           java.lang.String citizenRights,
           java.lang.String contactInfo,
           java.lang.String description,
           java.lang.String executiveOffice,
           java.lang.String id,
           java.lang.String improvementActions,
           java.lang.String lastUpdateDate,
           java.lang.String lastUpdateUser,
           java.lang.String name,
           java.lang.String[] serviceIds,
           java.lang.String status,
           java.lang.String userCollaboration) {
           this.citizenRights = citizenRights;
           this.contactInfo = contactInfo;
           this.description = description;
           this.executiveOffice = executiveOffice;
           this.id = id;
           this.improvementActions = improvementActions;
           this.lastUpdateDate = lastUpdateDate;
           this.lastUpdateUser = lastUpdateUser;
           this.name = name;
           this.serviceIds = serviceIds;
           this.status = status;
           this.userCollaboration = userCollaboration;
    }


    /**
     * Gets the citizenRights value for this ServiceCharter.
     * 
     * @return citizenRights
     */
    public java.lang.String getCitizenRights() {
        return citizenRights;
    }


    /**
     * Sets the citizenRights value for this ServiceCharter.
     * 
     * @param citizenRights
     */
    public void setCitizenRights(java.lang.String citizenRights) {
        this.citizenRights = citizenRights;
    }


    /**
     * Gets the contactInfo value for this ServiceCharter.
     * 
     * @return contactInfo
     */
    public java.lang.String getContactInfo() {
        return contactInfo;
    }


    /**
     * Sets the contactInfo value for this ServiceCharter.
     * 
     * @param contactInfo
     */
    public void setContactInfo(java.lang.String contactInfo) {
        this.contactInfo = contactInfo;
    }


    /**
     * Gets the description value for this ServiceCharter.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ServiceCharter.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the executiveOffice value for this ServiceCharter.
     * 
     * @return executiveOffice
     */
    public java.lang.String getExecutiveOffice() {
        return executiveOffice;
    }


    /**
     * Sets the executiveOffice value for this ServiceCharter.
     * 
     * @param executiveOffice
     */
    public void setExecutiveOffice(java.lang.String executiveOffice) {
        this.executiveOffice = executiveOffice;
    }


    /**
     * Gets the id value for this ServiceCharter.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ServiceCharter.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the improvementActions value for this ServiceCharter.
     * 
     * @return improvementActions
     */
    public java.lang.String getImprovementActions() {
        return improvementActions;
    }


    /**
     * Sets the improvementActions value for this ServiceCharter.
     * 
     * @param improvementActions
     */
    public void setImprovementActions(java.lang.String improvementActions) {
        this.improvementActions = improvementActions;
    }


    /**
     * Gets the lastUpdateDate value for this ServiceCharter.
     * 
     * @return lastUpdateDate
     */
    public java.lang.String getLastUpdateDate() {
        return lastUpdateDate;
    }


    /**
     * Sets the lastUpdateDate value for this ServiceCharter.
     * 
     * @param lastUpdateDate
     */
    public void setLastUpdateDate(java.lang.String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    /**
     * Gets the lastUpdateUser value for this ServiceCharter.
     * 
     * @return lastUpdateUser
     */
    public java.lang.String getLastUpdateUser() {
        return lastUpdateUser;
    }


    /**
     * Sets the lastUpdateUser value for this ServiceCharter.
     * 
     * @param lastUpdateUser
     */
    public void setLastUpdateUser(java.lang.String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }


    /**
     * Gets the name value for this ServiceCharter.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ServiceCharter.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the serviceIds value for this ServiceCharter.
     * 
     * @return serviceIds
     */
    public java.lang.String[] getServiceIds() {
        return serviceIds;
    }


    /**
     * Sets the serviceIds value for this ServiceCharter.
     * 
     * @param serviceIds
     */
    public void setServiceIds(java.lang.String[] serviceIds) {
        this.serviceIds = serviceIds;
    }

    public java.lang.String getServiceIds(int i) {
        return this.serviceIds[i];
    }

    public void setServiceIds(int i, java.lang.String _value) {
        this.serviceIds[i] = _value;
    }


    /**
     * Gets the status value for this ServiceCharter.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ServiceCharter.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the userCollaboration value for this ServiceCharter.
     * 
     * @return userCollaboration
     */
    public java.lang.String getUserCollaboration() {
        return userCollaboration;
    }


    /**
     * Sets the userCollaboration value for this ServiceCharter.
     * 
     * @param userCollaboration
     */
    public void setUserCollaboration(java.lang.String userCollaboration) {
        this.userCollaboration = userCollaboration;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceCharter)) return false;
        ServiceCharter other = (ServiceCharter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.citizenRights==null && other.getCitizenRights()==null) || 
             (this.citizenRights!=null &&
              this.citizenRights.equals(other.getCitizenRights()))) &&
            ((this.contactInfo==null && other.getContactInfo()==null) || 
             (this.contactInfo!=null &&
              this.contactInfo.equals(other.getContactInfo()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.executiveOffice==null && other.getExecutiveOffice()==null) || 
             (this.executiveOffice!=null &&
              this.executiveOffice.equals(other.getExecutiveOffice()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.improvementActions==null && other.getImprovementActions()==null) || 
             (this.improvementActions!=null &&
              this.improvementActions.equals(other.getImprovementActions()))) &&
            ((this.lastUpdateDate==null && other.getLastUpdateDate()==null) || 
             (this.lastUpdateDate!=null &&
              this.lastUpdateDate.equals(other.getLastUpdateDate()))) &&
            ((this.lastUpdateUser==null && other.getLastUpdateUser()==null) || 
             (this.lastUpdateUser!=null &&
              this.lastUpdateUser.equals(other.getLastUpdateUser()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.serviceIds==null && other.getServiceIds()==null) || 
             (this.serviceIds!=null &&
              java.util.Arrays.equals(this.serviceIds, other.getServiceIds()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.userCollaboration==null && other.getUserCollaboration()==null) || 
             (this.userCollaboration!=null &&
              this.userCollaboration.equals(other.getUserCollaboration())));
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
        if (getCitizenRights() != null) {
            _hashCode += getCitizenRights().hashCode();
        }
        if (getContactInfo() != null) {
            _hashCode += getContactInfo().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getExecutiveOffice() != null) {
            _hashCode += getExecutiveOffice().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getImprovementActions() != null) {
            _hashCode += getImprovementActions().hashCode();
        }
        if (getLastUpdateDate() != null) {
            _hashCode += getLastUpdateDate().hashCode();
        }
        if (getLastUpdateUser() != null) {
            _hashCode += getLastUpdateUser().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getServiceIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getUserCollaboration() != null) {
            _hashCode += getUserCollaboration().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceCharter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "serviceCharter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citizenRights");
        elemField.setXmlName(new javax.xml.namespace.QName("", "citizenRights"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contactInfo"));
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
        elemField.setFieldName("executiveOffice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "executiveOffice"));
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
        elemField.setFieldName("improvementActions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "improvementActions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastUpdateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdateUser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastUpdateUser"));
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
        elemField.setFieldName("serviceIds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userCollaboration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userCollaboration"));
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
