package ec.gob.administracionpublica.wsGPRServices;

public class WsGPRServicesProxy implements ec.gob.administracionpublica.wsGPRServices.WsGPRServices_PortType {
  private String _endpoint = null;
  private ec.gob.administracionpublica.wsGPRServices.WsGPRServices_PortType wsGPRServices_PortType = null;
  
  public WsGPRServicesProxy() {
    _initWsGPRServicesProxy();
  }
  
  public WsGPRServicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsGPRServicesProxy();
  }
  
  private void _initWsGPRServicesProxy() {
    try {
      wsGPRServices_PortType = (new ec.gob.administracionpublica.wsGPRServices.WsGPRServices_ServiceLocator()).getwsGPRServicesPort();
      if (wsGPRServices_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsGPRServices_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsGPRServices_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsGPRServices_PortType != null)
      ((javax.xml.rpc.Stub)wsGPRServices_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ec.gob.administracionpublica.wsGPRServices.WsGPRServices_PortType getWsGPRServices_PortType() {
    if (wsGPRServices_PortType == null)
      _initWsGPRServicesProxy();
    return wsGPRServices_PortType;
  }
  
  public ec.gob.administracionpublica.wsGPRServices.Service getService(java.lang.String usuario, java.lang.String password, java.lang.String serviceId) throws java.rmi.RemoteException{
    if (wsGPRServices_PortType == null)
      _initWsGPRServicesProxy();
    return wsGPRServices_PortType.getService(usuario, password, serviceId);
  }
  
  public java.lang.String wsUp() throws java.rmi.RemoteException{
    if (wsGPRServices_PortType == null)
      _initWsGPRServicesProxy();
    return wsGPRServices_PortType.wsUp();
  }
  
  public byte[] downloadServiceAttachment(java.lang.String usuario, java.lang.String password, java.lang.String serviceLetterFile) throws java.rmi.RemoteException{
    if (wsGPRServices_PortType == null)
      _initWsGPRServicesProxy();
    return wsGPRServices_PortType.downloadServiceAttachment(usuario, password, serviceLetterFile);
  }
  
  public ec.gob.administracionpublica.wsGPRServices.ServiceInOperation[] getServicesInOperation(java.lang.String usuario, java.lang.String password) throws java.rmi.RemoteException{
    if (wsGPRServices_PortType == null)
      _initWsGPRServicesProxy();
    return wsGPRServices_PortType.getServicesInOperation(usuario, password);
  }
  
  public ec.gob.administracionpublica.wsGPRServices.ServiceCharter getServiceCharter(java.lang.String usuario, java.lang.String password, java.lang.String entidadID) throws java.rmi.RemoteException{
    if (wsGPRServices_PortType == null)
      _initWsGPRServicesProxy();
    return wsGPRServices_PortType.getServiceCharter(usuario, password, entidadID);
  }
  
  public ec.gob.administracionpublica.wsGPRServices.ServiceCharterPublished[] getOfficeWithServiceChartersPublished(java.lang.String usuario, java.lang.String password) throws java.rmi.RemoteException{
    if (wsGPRServices_PortType == null)
      _initWsGPRServicesProxy();
    return wsGPRServices_PortType.getOfficeWithServiceChartersPublished(usuario, password);
  }
  
  public ec.gob.administracionpublica.wsGPRServices.ServiceOfficeInfo[] getGprEntities(java.lang.String usuario, java.lang.String password) throws java.rmi.RemoteException{
    if (wsGPRServices_PortType == null)
      _initWsGPRServicesProxy();
    return wsGPRServices_PortType.getGprEntities(usuario, password);
  }
  
  
}