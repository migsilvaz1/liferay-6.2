package ec.gob.snap.cases.services;

public class WebServiceInterfacePortTypeProxy implements ec.gob.snap.cases.services.WebServiceInterfacePortType {
  private String _endpoint = null;
  private ec.gob.snap.cases.services.WebServiceInterfacePortType webServiceInterfacePortType = null;
  
  public WebServiceInterfacePortTypeProxy() {
    _initWebServiceInterfacePortTypeProxy();
  }
  
  public WebServiceInterfacePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceInterfacePortTypeProxy();
  }
  
  private void _initWebServiceInterfacePortTypeProxy() {
    try {
      webServiceInterfacePortType = (new ec.gob.snap.cases.services.WebServiceInterfaceLocator()).getWebServiceInterfacePort();
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
  
  public ec.gob.snap.cases.services.WebServiceInterfacePortType getWebServiceInterfacePortType() {
    if (webServiceInterfacePortType == null)
      _initWebServiceInterfacePortTypeProxy();
    return webServiceInterfacePortType;
  }
  
  public ec.gob.snap.cases.process.CaseData[] execute(ec.gob.snap.cases.process.InputCaseData inputCaseData) throws java.rmi.RemoteException{
    if (webServiceInterfacePortType == null)
      _initWebServiceInterfacePortTypeProxy();
    return webServiceInterfacePortType.execute(inputCaseData);
  }
  
  
}