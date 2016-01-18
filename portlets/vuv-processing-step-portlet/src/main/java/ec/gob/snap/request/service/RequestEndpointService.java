/**
 * RequestEndpointService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.snap.request.service;

public interface RequestEndpointService extends javax.xml.rpc.Service {
    public java.lang.String getRequestServiceAddress();

    public ec.gob.snap.request.service.RequestEndpoint getRequestService() throws javax.xml.rpc.ServiceException;

    public ec.gob.snap.request.service.RequestEndpoint getRequestService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
