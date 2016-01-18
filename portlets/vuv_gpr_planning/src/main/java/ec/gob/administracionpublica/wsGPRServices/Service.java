/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.administracionpublica.wsGPRServices;

public class Service  implements java.io.Serializable {
    private ec.gob.administracionpublica.wsGPRServices.ServiceCase[] cases;

    private java.lang.String code;

    private java.lang.String commitments;

    private java.lang.String complaints;

    private java.lang.String contact;

    private java.lang.String correctiveMeasures;

    private java.lang.String customers;

    private java.lang.String customersGovernment;

    private java.lang.String customersLegal;

    private java.lang.String customersOngs;

    private java.lang.String description;

    private java.lang.String id;

    private ec.gob.administracionpublica.wsGPRServices.Indicator[] indicators;

    private ec.gob.administracionpublica.wsGPRServices.InstitutionalActivity[] institutionalActivities;

    private java.lang.String languages;

    private java.lang.String name;

    private java.lang.String office;

    private java.lang.String owner;

    private java.lang.String purpose;

    private java.lang.String responsibleUnit;

    private java.lang.String timeStamp;

    private java.lang.String type;

    private java.lang.String zip;

    public Service() {
    }

    public Service(
           ec.gob.administracionpublica.wsGPRServices.ServiceCase[] cases,
           java.lang.String code,
           java.lang.String commitments,
           java.lang.String complaints,
           java.lang.String contact,
           java.lang.String correctiveMeasures,
           java.lang.String customers,
           java.lang.String customersGovernment,
           java.lang.String customersLegal,
           java.lang.String customersOngs,
           java.lang.String description,
           java.lang.String id,
           ec.gob.administracionpublica.wsGPRServices.Indicator[] indicators,
           ec.gob.administracionpublica.wsGPRServices.InstitutionalActivity[] institutionalActivities,
           java.lang.String languages,
           java.lang.String name,
           java.lang.String office,
           java.lang.String owner,
           java.lang.String purpose,
           java.lang.String responsibleUnit,
           java.lang.String timeStamp,
           java.lang.String type,
           java.lang.String zip) {
           this.cases = cases;
           this.code = code;
           this.commitments = commitments;
           this.complaints = complaints;
           this.contact = contact;
           this.correctiveMeasures = correctiveMeasures;
           this.customers = customers;
           this.customersGovernment = customersGovernment;
           this.customersLegal = customersLegal;
           this.customersOngs = customersOngs;
           this.description = description;
           this.id = id;
           this.indicators = indicators;
           this.institutionalActivities = institutionalActivities;
           this.languages = languages;
           this.name = name;
           this.office = office;
           this.owner = owner;
           this.purpose = purpose;
           this.responsibleUnit = responsibleUnit;
           this.timeStamp = timeStamp;
           this.type = type;
           this.zip = zip;
    }


    /**
     * Gets the cases value for this Service.
     * 
     * @return cases
     */
    public ec.gob.administracionpublica.wsGPRServices.ServiceCase[] getCases() {
        return cases;
    }


    /**
     * Sets the cases value for this Service.
     * 
     * @param cases
     */
    public void setCases(ec.gob.administracionpublica.wsGPRServices.ServiceCase[] cases) {
        this.cases = cases;
    }

    public ec.gob.administracionpublica.wsGPRServices.ServiceCase getCases(int i) {
        return this.cases[i];
    }

    public void setCases(int i, ec.gob.administracionpublica.wsGPRServices.ServiceCase _value) {
        this.cases[i] = _value;
    }


    /**
     * Gets the code value for this Service.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this Service.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the commitments value for this Service.
     * 
     * @return commitments
     */
    public java.lang.String getCommitments() {
        return commitments;
    }


    /**
     * Sets the commitments value for this Service.
     * 
     * @param commitments
     */
    public void setCommitments(java.lang.String commitments) {
        this.commitments = commitments;
    }


    /**
     * Gets the complaints value for this Service.
     * 
     * @return complaints
     */
    public java.lang.String getComplaints() {
        return complaints;
    }


    /**
     * Sets the complaints value for this Service.
     * 
     * @param complaints
     */
    public void setComplaints(java.lang.String complaints) {
        this.complaints = complaints;
    }


    /**
     * Gets the contact value for this Service.
     * 
     * @return contact
     */
    public java.lang.String getContact() {
        return contact;
    }


    /**
     * Sets the contact value for this Service.
     * 
     * @param contact
     */
    public void setContact(java.lang.String contact) {
        this.contact = contact;
    }


    /**
     * Gets the correctiveMeasures value for this Service.
     * 
     * @return correctiveMeasures
     */
    public java.lang.String getCorrectiveMeasures() {
        return correctiveMeasures;
    }


    /**
     * Sets the correctiveMeasures value for this Service.
     * 
     * @param correctiveMeasures
     */
    public void setCorrectiveMeasures(java.lang.String correctiveMeasures) {
        this.correctiveMeasures = correctiveMeasures;
    }


    /**
     * Gets the customers value for this Service.
     * 
     * @return customers
     */
    public java.lang.String getCustomers() {
        return customers;
    }


    /**
     * Sets the customers value for this Service.
     * 
     * @param customers
     */
    public void setCustomers(java.lang.String customers) {
        this.customers = customers;
    }


    /**
     * Gets the customersGovernment value for this Service.
     * 
     * @return customersGovernment
     */
    public java.lang.String getCustomersGovernment() {
        return customersGovernment;
    }


    /**
     * Sets the customersGovernment value for this Service.
     * 
     * @param customersGovernment
     */
    public void setCustomersGovernment(java.lang.String customersGovernment) {
        this.customersGovernment = customersGovernment;
    }


    /**
     * Gets the customersLegal value for this Service.
     * 
     * @return customersLegal
     */
    public java.lang.String getCustomersLegal() {
        return customersLegal;
    }


    /**
     * Sets the customersLegal value for this Service.
     * 
     * @param customersLegal
     */
    public void setCustomersLegal(java.lang.String customersLegal) {
        this.customersLegal = customersLegal;
    }


    /**
     * Gets the customersOngs value for this Service.
     * 
     * @return customersOngs
     */
    public java.lang.String getCustomersOngs() {
        return customersOngs;
    }


    /**
     * Sets the customersOngs value for this Service.
     * 
     * @param customersOngs
     */
    public void setCustomersOngs(java.lang.String customersOngs) {
        this.customersOngs = customersOngs;
    }


    /**
     * Gets the description value for this Service.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Service.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the id value for this Service.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Service.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the indicators value for this Service.
     * 
     * @return indicators
     */
    public ec.gob.administracionpublica.wsGPRServices.Indicator[] getIndicators() {
        return indicators;
    }


    /**
     * Sets the indicators value for this Service.
     * 
     * @param indicators
     */
    public void setIndicators(ec.gob.administracionpublica.wsGPRServices.Indicator[] indicators) {
        this.indicators = indicators;
    }

    public ec.gob.administracionpublica.wsGPRServices.Indicator getIndicators(int i) {
        return this.indicators[i];
    }

    public void setIndicators(int i, ec.gob.administracionpublica.wsGPRServices.Indicator _value) {
        this.indicators[i] = _value;
    }


    /**
     * Gets the institutionalActivities value for this Service.
     * 
     * @return institutionalActivities
     */
    public ec.gob.administracionpublica.wsGPRServices.InstitutionalActivity[] getInstitutionalActivities() {
        return institutionalActivities;
    }


    /**
     * Sets the institutionalActivities value for this Service.
     * 
     * @param institutionalActivities
     */
    public void setInstitutionalActivities(ec.gob.administracionpublica.wsGPRServices.InstitutionalActivity[] institutionalActivities) {
        this.institutionalActivities = institutionalActivities;
    }

    public ec.gob.administracionpublica.wsGPRServices.InstitutionalActivity getInstitutionalActivities(int i) {
        return this.institutionalActivities[i];
    }

    public void setInstitutionalActivities(int i, ec.gob.administracionpublica.wsGPRServices.InstitutionalActivity _value) {
        this.institutionalActivities[i] = _value;
    }


    /**
     * Gets the languages value for this Service.
     * 
     * @return languages
     */
    public java.lang.String getLanguages() {
        return languages;
    }


    /**
     * Sets the languages value for this Service.
     * 
     * @param languages
     */
    public void setLanguages(java.lang.String languages) {
        this.languages = languages;
    }


    /**
     * Gets the name value for this Service.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Service.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the office value for this Service.
     * 
     * @return office
     */
    public java.lang.String getOffice() {
        return office;
    }


    /**
     * Sets the office value for this Service.
     * 
     * @param office
     */
    public void setOffice(java.lang.String office) {
        this.office = office;
    }


    /**
     * Gets the owner value for this Service.
     * 
     * @return owner
     */
    public java.lang.String getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this Service.
     * 
     * @param owner
     */
    public void setOwner(java.lang.String owner) {
        this.owner = owner;
    }


    /**
     * Gets the purpose value for this Service.
     * 
     * @return purpose
     */
    public java.lang.String getPurpose() {
        return purpose;
    }


    /**
     * Sets the purpose value for this Service.
     * 
     * @param purpose
     */
    public void setPurpose(java.lang.String purpose) {
        this.purpose = purpose;
    }


    /**
     * Gets the responsibleUnit value for this Service.
     * 
     * @return responsibleUnit
     */
    public java.lang.String getResponsibleUnit() {
        return responsibleUnit;
    }


    /**
     * Sets the responsibleUnit value for this Service.
     * 
     * @param responsibleUnit
     */
    public void setResponsibleUnit(java.lang.String responsibleUnit) {
        this.responsibleUnit = responsibleUnit;
    }


    /**
     * Gets the timeStamp value for this Service.
     * 
     * @return timeStamp
     */
    public java.lang.String getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this Service.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(java.lang.String timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the type value for this Service.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Service.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the zip value for this Service.
     * 
     * @return zip
     */
    public java.lang.String getZip() {
        return zip;
    }


    /**
     * Sets the zip value for this Service.
     * 
     * @param zip
     */
    public void setZip(java.lang.String zip) {
        this.zip = zip;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Service)) return false;
        Service other = (Service) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cases==null && other.getCases()==null) || 
             (this.cases!=null &&
              java.util.Arrays.equals(this.cases, other.getCases()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.commitments==null && other.getCommitments()==null) || 
             (this.commitments!=null &&
              this.commitments.equals(other.getCommitments()))) &&
            ((this.complaints==null && other.getComplaints()==null) || 
             (this.complaints!=null &&
              this.complaints.equals(other.getComplaints()))) &&
            ((this.contact==null && other.getContact()==null) || 
             (this.contact!=null &&
              this.contact.equals(other.getContact()))) &&
            ((this.correctiveMeasures==null && other.getCorrectiveMeasures()==null) || 
             (this.correctiveMeasures!=null &&
              this.correctiveMeasures.equals(other.getCorrectiveMeasures()))) &&
            ((this.customers==null && other.getCustomers()==null) || 
             (this.customers!=null &&
              this.customers.equals(other.getCustomers()))) &&
            ((this.customersGovernment==null && other.getCustomersGovernment()==null) || 
             (this.customersGovernment!=null &&
              this.customersGovernment.equals(other.getCustomersGovernment()))) &&
            ((this.customersLegal==null && other.getCustomersLegal()==null) || 
             (this.customersLegal!=null &&
              this.customersLegal.equals(other.getCustomersLegal()))) &&
            ((this.customersOngs==null && other.getCustomersOngs()==null) || 
             (this.customersOngs!=null &&
              this.customersOngs.equals(other.getCustomersOngs()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.indicators==null && other.getIndicators()==null) || 
             (this.indicators!=null &&
              java.util.Arrays.equals(this.indicators, other.getIndicators()))) &&
            ((this.institutionalActivities==null && other.getInstitutionalActivities()==null) || 
             (this.institutionalActivities!=null &&
              java.util.Arrays.equals(this.institutionalActivities, other.getInstitutionalActivities()))) &&
            ((this.languages==null && other.getLanguages()==null) || 
             (this.languages!=null &&
              this.languages.equals(other.getLanguages()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.office==null && other.getOffice()==null) || 
             (this.office!=null &&
              this.office.equals(other.getOffice()))) &&
            ((this.owner==null && other.getOwner()==null) || 
             (this.owner!=null &&
              this.owner.equals(other.getOwner()))) &&
            ((this.purpose==null && other.getPurpose()==null) || 
             (this.purpose!=null &&
              this.purpose.equals(other.getPurpose()))) &&
            ((this.responsibleUnit==null && other.getResponsibleUnit()==null) || 
             (this.responsibleUnit!=null &&
              this.responsibleUnit.equals(other.getResponsibleUnit()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.zip==null && other.getZip()==null) || 
             (this.zip!=null &&
              this.zip.equals(other.getZip())));
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
        if (getCases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getCommitments() != null) {
            _hashCode += getCommitments().hashCode();
        }
        if (getComplaints() != null) {
            _hashCode += getComplaints().hashCode();
        }
        if (getContact() != null) {
            _hashCode += getContact().hashCode();
        }
        if (getCorrectiveMeasures() != null) {
            _hashCode += getCorrectiveMeasures().hashCode();
        }
        if (getCustomers() != null) {
            _hashCode += getCustomers().hashCode();
        }
        if (getCustomersGovernment() != null) {
            _hashCode += getCustomersGovernment().hashCode();
        }
        if (getCustomersLegal() != null) {
            _hashCode += getCustomersLegal().hashCode();
        }
        if (getCustomersOngs() != null) {
            _hashCode += getCustomersOngs().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIndicators() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIndicators());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIndicators(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInstitutionalActivities() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInstitutionalActivities());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInstitutionalActivities(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLanguages() != null) {
            _hashCode += getLanguages().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOffice() != null) {
            _hashCode += getOffice().hashCode();
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getPurpose() != null) {
            _hashCode += getPurpose().hashCode();
        }
        if (getResponsibleUnit() != null) {
            _hashCode += getResponsibleUnit().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getZip() != null) {
            _hashCode += getZip().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Service.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "service"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "serviceCase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commitments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commitments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complaints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "complaints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correctiveMeasures");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correctiveMeasures"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customersGovernment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customersGovernment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customersLegal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customersLegal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customersOngs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customersOngs"));
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
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicators");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicators"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "indicator"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institutionalActivities");
        elemField.setXmlName(new javax.xml.namespace.QName("", "institutionalActivities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "institutionalActivity"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "languages"));
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
        elemField.setFieldName("office");
        elemField.setXmlName(new javax.xml.namespace.QName("", "office"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owner");
        elemField.setXmlName(new javax.xml.namespace.QName("", "owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purpose");
        elemField.setXmlName(new javax.xml.namespace.QName("", "purpose"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responsibleUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responsibleUnit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeStamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zip"));
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
