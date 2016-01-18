/**
 * ServiceCaseStep.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.administracionpublica.wsGPRServices;

public class ServiceCaseStep  implements java.io.Serializable {
    private java.lang.String automationLevel;

    private java.lang.String automationLevelWanted;

    private java.lang.String code;

    private java.lang.String codeSequence;

    private java.lang.String cost;

    private java.lang.String cycleTime;

    private java.lang.String description;

    private java.lang.String executiveOffice;

    private java.lang.String fee;

    private java.lang.String feeLegal;

    private java.lang.String id;

    private java.lang.String interactions;

    private java.lang.String interactionsRemote;

    private java.lang.String name;

    private java.lang.String paymentForm;

    private java.lang.String procedure;

    private ec.gob.administracionpublica.wsGPRServices.ServiceRequisite[] requisites;

    private java.lang.String sequence;

    private java.lang.String signatures;

    private java.lang.String timeRangeActual;

    private java.lang.String timeRangeWanted;

    private java.lang.String timeStamp;

    private java.lang.String zip;

    public ServiceCaseStep() {
    }

    public ServiceCaseStep(
           java.lang.String automationLevel,
           java.lang.String automationLevelWanted,
           java.lang.String code,
           java.lang.String codeSequence,
           java.lang.String cost,
           java.lang.String cycleTime,
           java.lang.String description,
           java.lang.String executiveOffice,
           java.lang.String fee,
           java.lang.String feeLegal,
           java.lang.String id,
           java.lang.String interactions,
           java.lang.String interactionsRemote,
           java.lang.String name,
           java.lang.String paymentForm,
           java.lang.String procedure,
           ec.gob.administracionpublica.wsGPRServices.ServiceRequisite[] requisites,
           java.lang.String sequence,
           java.lang.String signatures,
           java.lang.String timeRangeActual,
           java.lang.String timeRangeWanted,
           java.lang.String timeStamp,
           java.lang.String zip) {
           this.automationLevel = automationLevel;
           this.automationLevelWanted = automationLevelWanted;
           this.code = code;
           this.codeSequence = codeSequence;
           this.cost = cost;
           this.cycleTime = cycleTime;
           this.description = description;
           this.executiveOffice = executiveOffice;
           this.fee = fee;
           this.feeLegal = feeLegal;
           this.id = id;
           this.interactions = interactions;
           this.interactionsRemote = interactionsRemote;
           this.name = name;
           this.paymentForm = paymentForm;
           this.procedure = procedure;
           this.requisites = requisites;
           this.sequence = sequence;
           this.signatures = signatures;
           this.timeRangeActual = timeRangeActual;
           this.timeRangeWanted = timeRangeWanted;
           this.timeStamp = timeStamp;
           this.zip = zip;
    }


    /**
     * Gets the automationLevel value for this ServiceCaseStep.
     * 
     * @return automationLevel
     */
    public java.lang.String getAutomationLevel() {
        return automationLevel;
    }


    /**
     * Sets the automationLevel value for this ServiceCaseStep.
     * 
     * @param automationLevel
     */
    public void setAutomationLevel(java.lang.String automationLevel) {
        this.automationLevel = automationLevel;
    }


    /**
     * Gets the automationLevelWanted value for this ServiceCaseStep.
     * 
     * @return automationLevelWanted
     */
    public java.lang.String getAutomationLevelWanted() {
        return automationLevelWanted;
    }


    /**
     * Sets the automationLevelWanted value for this ServiceCaseStep.
     * 
     * @param automationLevelWanted
     */
    public void setAutomationLevelWanted(java.lang.String automationLevelWanted) {
        this.automationLevelWanted = automationLevelWanted;
    }


    /**
     * Gets the code value for this ServiceCaseStep.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this ServiceCaseStep.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the codeSequence value for this ServiceCaseStep.
     * 
     * @return codeSequence
     */
    public java.lang.String getCodeSequence() {
        return codeSequence;
    }


    /**
     * Sets the codeSequence value for this ServiceCaseStep.
     * 
     * @param codeSequence
     */
    public void setCodeSequence(java.lang.String codeSequence) {
        this.codeSequence = codeSequence;
    }


    /**
     * Gets the cost value for this ServiceCaseStep.
     * 
     * @return cost
     */
    public java.lang.String getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this ServiceCaseStep.
     * 
     * @param cost
     */
    public void setCost(java.lang.String cost) {
        this.cost = cost;
    }


    /**
     * Gets the cycleTime value for this ServiceCaseStep.
     * 
     * @return cycleTime
     */
    public java.lang.String getCycleTime() {
        return cycleTime;
    }


    /**
     * Sets the cycleTime value for this ServiceCaseStep.
     * 
     * @param cycleTime
     */
    public void setCycleTime(java.lang.String cycleTime) {
        this.cycleTime = cycleTime;
    }


    /**
     * Gets the description value for this ServiceCaseStep.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ServiceCaseStep.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the executiveOffice value for this ServiceCaseStep.
     * 
     * @return executiveOffice
     */
    public java.lang.String getExecutiveOffice() {
        return executiveOffice;
    }


    /**
     * Sets the executiveOffice value for this ServiceCaseStep.
     * 
     * @param executiveOffice
     */
    public void setExecutiveOffice(java.lang.String executiveOffice) {
        this.executiveOffice = executiveOffice;
    }


    /**
     * Gets the fee value for this ServiceCaseStep.
     * 
     * @return fee
     */
    public java.lang.String getFee() {
        return fee;
    }


    /**
     * Sets the fee value for this ServiceCaseStep.
     * 
     * @param fee
     */
    public void setFee(java.lang.String fee) {
        this.fee = fee;
    }


    /**
     * Gets the feeLegal value for this ServiceCaseStep.
     * 
     * @return feeLegal
     */
    public java.lang.String getFeeLegal() {
        return feeLegal;
    }


    /**
     * Sets the feeLegal value for this ServiceCaseStep.
     * 
     * @param feeLegal
     */
    public void setFeeLegal(java.lang.String feeLegal) {
        this.feeLegal = feeLegal;
    }


    /**
     * Gets the id value for this ServiceCaseStep.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ServiceCaseStep.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the interactions value for this ServiceCaseStep.
     * 
     * @return interactions
     */
    public java.lang.String getInteractions() {
        return interactions;
    }


    /**
     * Sets the interactions value for this ServiceCaseStep.
     * 
     * @param interactions
     */
    public void setInteractions(java.lang.String interactions) {
        this.interactions = interactions;
    }


    /**
     * Gets the interactionsRemote value for this ServiceCaseStep.
     * 
     * @return interactionsRemote
     */
    public java.lang.String getInteractionsRemote() {
        return interactionsRemote;
    }


    /**
     * Sets the interactionsRemote value for this ServiceCaseStep.
     * 
     * @param interactionsRemote
     */
    public void setInteractionsRemote(java.lang.String interactionsRemote) {
        this.interactionsRemote = interactionsRemote;
    }


    /**
     * Gets the name value for this ServiceCaseStep.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ServiceCaseStep.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the paymentForm value for this ServiceCaseStep.
     * 
     * @return paymentForm
     */
    public java.lang.String getPaymentForm() {
        return paymentForm;
    }


    /**
     * Sets the paymentForm value for this ServiceCaseStep.
     * 
     * @param paymentForm
     */
    public void setPaymentForm(java.lang.String paymentForm) {
        this.paymentForm = paymentForm;
    }


    /**
     * Gets the procedure value for this ServiceCaseStep.
     * 
     * @return procedure
     */
    public java.lang.String getProcedure() {
        return procedure;
    }


    /**
     * Sets the procedure value for this ServiceCaseStep.
     * 
     * @param procedure
     */
    public void setProcedure(java.lang.String procedure) {
        this.procedure = procedure;
    }


    /**
     * Gets the requisites value for this ServiceCaseStep.
     * 
     * @return requisites
     */
    public ec.gob.administracionpublica.wsGPRServices.ServiceRequisite[] getRequisites() {
        return requisites;
    }


    /**
     * Sets the requisites value for this ServiceCaseStep.
     * 
     * @param requisites
     */
    public void setRequisites(ec.gob.administracionpublica.wsGPRServices.ServiceRequisite[] requisites) {
        this.requisites = requisites;
    }

    public ec.gob.administracionpublica.wsGPRServices.ServiceRequisite getRequisites(int i) {
        return this.requisites[i];
    }

    public void setRequisites(int i, ec.gob.administracionpublica.wsGPRServices.ServiceRequisite _value) {
        this.requisites[i] = _value;
    }


    /**
     * Gets the sequence value for this ServiceCaseStep.
     * 
     * @return sequence
     */
    public java.lang.String getSequence() {
        return sequence;
    }


    /**
     * Sets the sequence value for this ServiceCaseStep.
     * 
     * @param sequence
     */
    public void setSequence(java.lang.String sequence) {
        this.sequence = sequence;
    }


    /**
     * Gets the signatures value for this ServiceCaseStep.
     * 
     * @return signatures
     */
    public java.lang.String getSignatures() {
        return signatures;
    }


    /**
     * Sets the signatures value for this ServiceCaseStep.
     * 
     * @param signatures
     */
    public void setSignatures(java.lang.String signatures) {
        this.signatures = signatures;
    }


    /**
     * Gets the timeRangeActual value for this ServiceCaseStep.
     * 
     * @return timeRangeActual
     */
    public java.lang.String getTimeRangeActual() {
        return timeRangeActual;
    }


    /**
     * Sets the timeRangeActual value for this ServiceCaseStep.
     * 
     * @param timeRangeActual
     */
    public void setTimeRangeActual(java.lang.String timeRangeActual) {
        this.timeRangeActual = timeRangeActual;
    }


    /**
     * Gets the timeRangeWanted value for this ServiceCaseStep.
     * 
     * @return timeRangeWanted
     */
    public java.lang.String getTimeRangeWanted() {
        return timeRangeWanted;
    }


    /**
     * Sets the timeRangeWanted value for this ServiceCaseStep.
     * 
     * @param timeRangeWanted
     */
    public void setTimeRangeWanted(java.lang.String timeRangeWanted) {
        this.timeRangeWanted = timeRangeWanted;
    }


    /**
     * Gets the timeStamp value for this ServiceCaseStep.
     * 
     * @return timeStamp
     */
    public java.lang.String getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this ServiceCaseStep.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(java.lang.String timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the zip value for this ServiceCaseStep.
     * 
     * @return zip
     */
    public java.lang.String getZip() {
        return zip;
    }


    /**
     * Sets the zip value for this ServiceCaseStep.
     * 
     * @param zip
     */
    public void setZip(java.lang.String zip) {
        this.zip = zip;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceCaseStep)) return false;
        ServiceCaseStep other = (ServiceCaseStep) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.automationLevel==null && other.getAutomationLevel()==null) || 
             (this.automationLevel!=null &&
              this.automationLevel.equals(other.getAutomationLevel()))) &&
            ((this.automationLevelWanted==null && other.getAutomationLevelWanted()==null) || 
             (this.automationLevelWanted!=null &&
              this.automationLevelWanted.equals(other.getAutomationLevelWanted()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.codeSequence==null && other.getCodeSequence()==null) || 
             (this.codeSequence!=null &&
              this.codeSequence.equals(other.getCodeSequence()))) &&
            ((this.cost==null && other.getCost()==null) || 
             (this.cost!=null &&
              this.cost.equals(other.getCost()))) &&
            ((this.cycleTime==null && other.getCycleTime()==null) || 
             (this.cycleTime!=null &&
              this.cycleTime.equals(other.getCycleTime()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.executiveOffice==null && other.getExecutiveOffice()==null) || 
             (this.executiveOffice!=null &&
              this.executiveOffice.equals(other.getExecutiveOffice()))) &&
            ((this.fee==null && other.getFee()==null) || 
             (this.fee!=null &&
              this.fee.equals(other.getFee()))) &&
            ((this.feeLegal==null && other.getFeeLegal()==null) || 
             (this.feeLegal!=null &&
              this.feeLegal.equals(other.getFeeLegal()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.interactions==null && other.getInteractions()==null) || 
             (this.interactions!=null &&
              this.interactions.equals(other.getInteractions()))) &&
            ((this.interactionsRemote==null && other.getInteractionsRemote()==null) || 
             (this.interactionsRemote!=null &&
              this.interactionsRemote.equals(other.getInteractionsRemote()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.paymentForm==null && other.getPaymentForm()==null) || 
             (this.paymentForm!=null &&
              this.paymentForm.equals(other.getPaymentForm()))) &&
            ((this.procedure==null && other.getProcedure()==null) || 
             (this.procedure!=null &&
              this.procedure.equals(other.getProcedure()))) &&
            ((this.requisites==null && other.getRequisites()==null) || 
             (this.requisites!=null &&
              java.util.Arrays.equals(this.requisites, other.getRequisites()))) &&
            ((this.sequence==null && other.getSequence()==null) || 
             (this.sequence!=null &&
              this.sequence.equals(other.getSequence()))) &&
            ((this.signatures==null && other.getSignatures()==null) || 
             (this.signatures!=null &&
              this.signatures.equals(other.getSignatures()))) &&
            ((this.timeRangeActual==null && other.getTimeRangeActual()==null) || 
             (this.timeRangeActual!=null &&
              this.timeRangeActual.equals(other.getTimeRangeActual()))) &&
            ((this.timeRangeWanted==null && other.getTimeRangeWanted()==null) || 
             (this.timeRangeWanted!=null &&
              this.timeRangeWanted.equals(other.getTimeRangeWanted()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
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
        if (getAutomationLevel() != null) {
            _hashCode += getAutomationLevel().hashCode();
        }
        if (getAutomationLevelWanted() != null) {
            _hashCode += getAutomationLevelWanted().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getCodeSequence() != null) {
            _hashCode += getCodeSequence().hashCode();
        }
        if (getCost() != null) {
            _hashCode += getCost().hashCode();
        }
        if (getCycleTime() != null) {
            _hashCode += getCycleTime().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getExecutiveOffice() != null) {
            _hashCode += getExecutiveOffice().hashCode();
        }
        if (getFee() != null) {
            _hashCode += getFee().hashCode();
        }
        if (getFeeLegal() != null) {
            _hashCode += getFeeLegal().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getInteractions() != null) {
            _hashCode += getInteractions().hashCode();
        }
        if (getInteractionsRemote() != null) {
            _hashCode += getInteractionsRemote().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPaymentForm() != null) {
            _hashCode += getPaymentForm().hashCode();
        }
        if (getProcedure() != null) {
            _hashCode += getProcedure().hashCode();
        }
        if (getRequisites() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRequisites());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRequisites(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSequence() != null) {
            _hashCode += getSequence().hashCode();
        }
        if (getSignatures() != null) {
            _hashCode += getSignatures().hashCode();
        }
        if (getTimeRangeActual() != null) {
            _hashCode += getTimeRangeActual().hashCode();
        }
        if (getTimeRangeWanted() != null) {
            _hashCode += getTimeRangeWanted().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        if (getZip() != null) {
            _hashCode += getZip().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceCaseStep.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "serviceCaseStep"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("automationLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "automationLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("automationLevelWanted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "automationLevelWanted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeSequence");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeSequence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cycleTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cycleTime"));
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
        elemField.setFieldName("fee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feeLegal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feeLegal"));
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
        elemField.setFieldName("interactions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interactionsRemote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactionsRemote"));
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
        elemField.setFieldName("paymentForm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentForm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procedure");
        elemField.setXmlName(new javax.xml.namespace.QName("", "procedure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requisites");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requisites"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://administracionpublica.gob.ec/wsGPRServices", "serviceRequisite"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequence");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sequence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signatures");
        elemField.setXmlName(new javax.xml.namespace.QName("", "signatures"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeRangeActual");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeRangeActual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeRangeWanted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeRangeWanted"));
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
