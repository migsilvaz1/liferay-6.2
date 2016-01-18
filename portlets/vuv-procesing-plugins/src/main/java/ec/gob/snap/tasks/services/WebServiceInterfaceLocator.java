/**
 * WebServiceInterfaceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.snap.tasks.services;

public class WebServiceInterfaceLocator extends org.apache.axis.client.Service implements ec.gob.snap.tasks.services.WebServiceInterface {

    public WebServiceInterfaceLocator() {
    }


    public WebServiceInterfaceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebServiceInterfaceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceInterfacePort
    private java.lang.String WebServiceInterfacePort_address = "http://192.168.8.75:8181/cxf/tasks-bpm";

    public java.lang.String getWebServiceInterfacePortAddress() {
        return WebServiceInterfacePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceInterfacePortWSDDServiceName = "WebServiceInterfacePort";

    public java.lang.String getWebServiceInterfacePortWSDDServiceName() {
        return WebServiceInterfacePortWSDDServiceName;
    }

    public void setWebServiceInterfacePortWSDDServiceName(java.lang.String name) {
        WebServiceInterfacePortWSDDServiceName = name;
    }

    public ec.gob.snap.tasks.services.WebServiceInterfacePortType getWebServiceInterfacePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceInterfacePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceInterfacePort(endpoint);
    }

    public ec.gob.snap.tasks.services.WebServiceInterfacePortType getWebServiceInterfacePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ec.gob.snap.tasks.services.WebServiceInterfaceSoapBindingStub _stub = new ec.gob.snap.tasks.services.WebServiceInterfaceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWebServiceInterfacePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceInterfacePortEndpointAddress(java.lang.String address) {
        WebServiceInterfacePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ec.gob.snap.tasks.services.WebServiceInterfacePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ec.gob.snap.tasks.services.WebServiceInterfaceSoapBindingStub _stub = new ec.gob.snap.tasks.services.WebServiceInterfaceSoapBindingStub(new java.net.URL(WebServiceInterfacePort_address), this);
                _stub.setPortName(getWebServiceInterfacePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebServiceInterfacePort".equals(inputPortName)) {
            return getWebServiceInterfacePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.tasks.snap.gob.ec/", "WebServiceInterface");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.tasks.snap.gob.ec/", "WebServiceInterfacePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceInterfacePort".equals(portName)) {
            setWebServiceInterfacePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
