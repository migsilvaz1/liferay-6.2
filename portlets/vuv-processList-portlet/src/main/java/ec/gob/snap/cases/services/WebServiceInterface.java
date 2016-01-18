/**
 * WebServiceInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.snap.cases.services;

public interface WebServiceInterface extends javax.xml.rpc.Service {
    public java.lang.String getWebServiceInterfacePortAddress();

    public ec.gob.snap.cases.services.WebServiceInterfacePortType getWebServiceInterfacePort() throws javax.xml.rpc.ServiceException;

    public ec.gob.snap.cases.services.WebServiceInterfacePortType getWebServiceInterfacePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
