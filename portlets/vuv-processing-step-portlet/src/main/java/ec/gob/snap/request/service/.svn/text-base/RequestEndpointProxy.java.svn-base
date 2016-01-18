package ec.gob.snap.request.service;

public class RequestEndpointProxy implements ec.gob.snap.request.service.RequestEndpoint {
  private String _endpoint = null;
  private ec.gob.snap.request.service.RequestEndpoint requestEndpoint = null;
  
  public RequestEndpointProxy() {
    _initRequestEndpointProxy();
  }
  
  public RequestEndpointProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestEndpointProxy();
  }
  
  private void _initRequestEndpointProxy() {
    try {
      requestEndpoint = (new ec.gob.snap.request.service.RequestEndpointServiceLocator()).getRequestService();
      if (requestEndpoint != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestEndpoint)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestEndpoint)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestEndpoint != null)
      ((javax.xml.rpc.Stub)requestEndpoint)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ec.gob.snap.request.service.RequestEndpoint getRequestEndpoint() {
    if (requestEndpoint == null)
      _initRequestEndpointProxy();
    return requestEndpoint;
  }
  
  public java.lang.String execute(java.lang.String process) throws java.rmi.RemoteException{
    if (requestEndpoint == null)
      _initRequestEndpointProxy();
    return requestEndpoint.execute(process);
  }
  
  
}