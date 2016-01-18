package ec.gob.snap.vuv;

public class Service {

    /*******************************************************************
     * ATTRIBUTES
     ******************************************************************/
    /**
     * Attribute that represents the id of the service. 
     */
    private String idServ;
    /**
     * Attribute that represents the Url to link to the service.
     */
    private String url;
    /**
     * Attribute that represents the Name of the service.
     */
    private String serviceName;
    /**
     * Attribute that represents the Description of the service.
     */
    private String servDescrip;
    /**
     * Attribute that represents the Target sex of the service .
     */
    private String sex;
    /**
     * Attribute that represents the Target age of the service. 
     */
    private String age;
    /**
     * Attribute that represents the type of the service. 
     */
    private String serviceType;
    
    /*******************************************************************
     * METHODS
     ************************************************id******************/
    /**id
     * Method to get the url of the service.
     * 
     * @return url Parameter that represents the url to get the Selected Service item on the web portal.
     */
    public String getUrl() {
	return url;
    }

    /**
     * Method to set the url of the service.
     * 
     * @param paramUrl Parameter that represents the url to get the Selected Service item on the web portal.
     */
    public void setUrl(String paramUrl) {
	this.url = paramUrl;
    }

    /**
     * Method to get the name of the service.
     * 
     * @return serviceName Parameter that represents the name of the Service item.
     */
    public String getServiceName() {
	return serviceName;
    }

    /**
     * Method to set the name of the service.
     * 
     * @param paramServiceName Parameter that represents the name of the Service item.
     */
    public void setServiceName(String paramServiceName) {
	this.serviceName = paramServiceName;
    }

    /**
     * Method to get the description of the service.
     * 
     * @return serviceDescription Parameter that represents the description of the Service item.
     */
    public String getServiceDescription() {
	return servDescrip;
    }

    /**
     * Method to set the description of the service.
     * 
     * @param paramServDescrip Parameter that represents the description of the Service item.
     */
    public void setServiceDescription(String paramServDescrip) {
	this.servDescrip = paramServDescrip;
    }

    /**
     * Method to get the id of the service.
     * 
     * @return id Parameter that represents the id of the Service.
     */
    public String getId() {
	return idServ;
    }

    /**
     * Method to set the id of the service.
     * 
     * @param paramId Parameter that represents the id of the Service.
     */
    public void setId(String paramId) {
	this.idServ = paramId;
    }

    /**
     * Method to get the target sex of the service.
     * 
     * @return sex Parameter that represents the target sex associated to the service. 
     */
    public String getServiceSex() {
	return sex;
    }

    /**
     * Method to set the target sex of the service.
     * 
     * @param paramSex Parameter that represents the target sex associated to the service. 
     */
    public void setServiceSex(String paramSex) {
	this.sex = paramSex;
    }

    /**
     * Method to get the target age of the service.
     * 
     * @return age Parameter that represents the target age associated to the service. 
     */
    public String getServiceAge() {
	return age;
    }

    /**
     * Method to set the target age of the service.
     * 
     * @param paramAge Parameter that represents the target age associated to the service. 
     */
    public void setServiceAge(String paramAge) {
	this.age = paramAge;
    }

    /**
     * Method to get the type of the service.
     * 
     * @return Parameter that represents the type associated to the service. 
     */
	public String getServiceType() {
		return serviceType;
	}

    /**
     * Method to set the target age of the service.
     * 
     * @param paramAge Parameter that represents the target age associated to the service. 
     */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

}
