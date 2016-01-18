package ec.gob.snap.tasks.services;

public class WebServiceInterfacePortTypeProxy implements ec.gob.snap.tasks.services.WebServiceInterfacePortType {
  private String _endpoint = null;
  private ec.gob.snap.tasks.services.WebServiceInterfacePortType webServiceInterfacePortType = null;
  
  public WebServiceInterfacePortTypeProxy() {
    _initWebServiceInterfacePortTypeProxy();
  }
  
  public WebServiceInterfacePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceInterfacePortTypeProxy();
  }
  
  private void _initWebServiceInterfacePortTypeProxy() {
    try {
      webServiceInterfacePortType = (new ec.gob.snap.tasks.services.WebServiceInterfaceLocator()).getWebServiceInterfacePort();
      if (webServiceInterfacePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webServiceInterfacePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webServiceInterfacePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webServiceInterfacePortType != null)
      ((javax.xml.rpc.Stub)webServiceInterfacePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ec.gob.snap.tasks.services.WebServiceInterfacePortType getWebServiceInterfacePortType() {
    if (webServiceInterfacePortType == null)
      _initWebServiceInterfacePortTypeProxy();
    return webServiceInterfacePortType;
  }
  
  public ec.gob.snap.tasks.process.TaskData[] execute(ec.gob.snap.tasks.process.InputTaskData inputTaskData) throws java.rmi.RemoteException{
    if (webServiceInterfacePortType == null)
      _initWebServiceInterfacePortTypeProxy();
    return webServiceInterfacePortType.execute(inputTaskData);
  }
  
  
}