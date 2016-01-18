
package ec.gob.snap.vuv;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import ec.gob.administracionpublica.wsGPRServices.Service;
import ec.gob.administracionpublica.wsGPRServices.ServiceCharter;
import ec.gob.administracionpublica.wsGPRServices.ServiceCharterPublished;
import ec.gob.administracionpublica.wsGPRServices.ServiceInOperation;
import ec.gob.administracionpublica.wsGPRServices.ServiceOfficeInfo;
import ec.gob.administracionpublica.wsGPRServices.WsGPRServices_PortType;
import ec.gob.administracionpublica.wsGPRServices.WsGPRServices_ServiceLocator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

/**
 * <p>Class this class contains all methods needed to interact with the GPR.</p>
 * <b>Project:</b><p>vuv</p>
 *
 * @version 1.0, 28/5/2015.
 */
public class GPRInterface {

	/**
	 * Attribute that represents system log.
	 */
	private static Log log = LogFactoryUtil.getLog(GPRInterface.class);
	/**
	 * Attribute that represents the configuration for the connection.
	 */
	private WsGPRServices_PortType port;
	/**
	 * Attribute that represents the user to connect.
	 */
	private String user;
	/**
	 * Attribute that represents .
	 */
	private String pass;

	// Constructors for the default address and for a new address
	/**
	 * Constructor method for the class {@link GPRInterface} for the default
	 * address and for a new address.
	 *
	 * @param userParam
	 *            to connect to GPR.
	 * @param passParam
	 *            to connect to GPR.
	 */
	public GPRInterface(String userParam, String passParam) {

		WsGPRServices_ServiceLocator serviceLocator =
						new WsGPRServices_ServiceLocator();
		try {
			user = userParam;
			pass = passParam;
			port = serviceLocator.getwsGPRServicesPort();
		}
		catch (ServiceException e) {
			log.error("Error creating the service port: " + e);
		}
	}

	/**
	 * Constructor method for the class {@link GPRInterface}.
	 *
	 * @param userParam
	 *            to connect to GPR.
	 * @param passParam
	 *            to connect to GPR.
	 * @param addressParam
	 *            to connect to GPR.
	 */
	public GPRInterface(String userParam, String passParam, String addressParam) {

		WsGPRServices_ServiceLocator serviceLocator =
						new WsGPRServices_ServiceLocator();
		serviceLocator.setwsGPRServicesPortEndpointAddress(addressParam);
		try {
			this.user = userParam;
			this.pass = passParam;
			port = serviceLocator.getwsGPRServicesPort();
		}
		catch (ServiceException e) {
			log.error("Error creating the service port: " + e);
		}
	}

	/**
	 * Service verification.
	 *
	 * @return if service is active.
	 */
	public boolean isUp() {

		boolean is = false;
		try {
			Integer isUp = Integer.valueOf(port.wsUp());
			if (isUp == 1) {
				is = true;
			}
		}
		catch (NumberFormatException e) {
			log.error("isUp_FORMAT_ERROR: Error formatting GPR response: " + e);
		}
		catch (RemoteException e) {
			log.error("isUp_CONTACT_ERROR: Error contacting GPR: " + e);
		}
		return is;
	}

	/**
	 * Gets the institutions that are in operation.
	 *
	 * @return a list of operative institutions.
	 */
	public List<ServiceInOperation> getServicesInOperationList() {

		List<ServiceInOperation> services = null;
		try {
			ServiceInOperation[] servicesInOperation =
							port.getServicesInOperation(user, pass);
			if (servicesInOperation.length == 1) {
				ServiceInOperation serviceInOperation = servicesInOperation[0];
				if (serviceInOperation.getServiceId().isEmpty()) {
					log.warn("servicesInOperationList_ERROR: " +
									serviceInOperation.getServiceName() + "_" +
									serviceInOperation.getDescription());
				}
				else {
					services = new ArrayList<ServiceInOperation>();
					services.add(serviceInOperation);
				}
			}
			else {
				services = new ArrayList<ServiceInOperation>();
				for (ServiceInOperation sio : servicesInOperation) {
					services.add(sio);
				}
			}
		}
		catch (RemoteException e) {
			log.error("servicesInOperationList_CONTACT_ERROR: Error contacting GPR: " +
							e);
		}
		return services;
	}

	/**
	 * Gets institutions information and its components.
	 *
	 * @param id
	 *            service id.
	 * @return the service.
	 */
	public Service getService(String id) {

		Service service = null;
		try {
			service = port.getService(user, pass, id);
			if (service.getId().isEmpty()) {
				log.warn("getService_ERROR: " + service.getName() + "_" +
								service.getDescription());
			}
		}
		catch (RemoteException e) {
			log.error("getService_CONTACT_ERROR: Error contacting GPR: " + e);
		}
		return service;
	}

	/**
	 * Gets the service charter from an institution.
	 *
	 * @param id
	 *            institution id.
	 * @return the institution service charter.
	 */
	public ServiceCharter getServiceCharter(String id) {

		ServiceCharter serviceCharter = null;
		try {
			serviceCharter = port.getServiceCharter(user, pass, id);
			if (serviceCharter.getId().isEmpty()) {
				if(!serviceCharter.getName().equals("101")){
					log.warn("getServiceCharter_ERROR: " +
									serviceCharter.getName() + "_" +
									serviceCharter.getDescription());
				}
			}
		}
		catch (RemoteException e) {
			log.error("getServiceCharter_CONTACT_ERROR: Error contacting GPR: " +
							e);
		}
		return serviceCharter;
	}

	/**
	 * Gets a list with the institutions that have service charter.
	 *
	 * @return the institution list.
	 */
	public List<ServiceCharterPublished> getOfficeWithServiceChartersPublished() {

		List<ServiceCharterPublished> res =
						new ArrayList<ServiceCharterPublished>();
		try {
			ServiceCharterPublished[] servicesChartersPublished =
							port.getOfficeWithServiceChartersPublished(user, pass);
			if (servicesChartersPublished.length == 1) {
				ServiceCharterPublished serviceCharterPublished =
								servicesChartersPublished[0];
				if (serviceCharterPublished.getEntidadId().isEmpty()) {
					log.warn("getOfficeWithServiceChartersPublished_ERROR: " +
									serviceCharterPublished.getEntidadName() + "_" +
									serviceCharterPublished.getDescription());
				}
				else {
					res.add(serviceCharterPublished);
				}
			}
			else {
				for (ServiceCharterPublished serviceCharterPublished : servicesChartersPublished) {
					res.add(serviceCharterPublished);
				}
			}
		}
		catch (RemoteException e) {
			log.error("getOfficeWithServiceChartersPublished_CONTACT_ERROR: Error contacting GPR: " +
							e);
		}
		return res;
	}

	/**
	 * Get the zip file of attachments of service or procedure.
	 *
	 * @param serviceLetterFile
	 *            the service file.
	 */
	public void downloadServiceAttachment(String serviceLetterFile) {

		try {
			byte[] attachment =
							port.downloadServiceAttachment(user, pass, serviceLetterFile);
			if (attachment == null) {
				log.warn("downloadServiceAttachment_ERROR: Attachment not downloaded");
			}
			else {
				// TODO: Process attachment
				log.warn("downloadServiceAttachment: Unimplemented method");
			}
		}
		catch (RemoteException e) {
			log.error("CONTACT_ERROR: Error contacting GPR: " + e);
		}
	}

	/**
	 * Gets the full institutions list.
	 *
	 * @return institutions list.
	 */
	public List<ServiceOfficeInfo> getGprEntitesList() {

		List<ServiceOfficeInfo> entities = null;
		try {
			ServiceOfficeInfo[] servicesOfficeInfo =
							port.getGprEntities(user, pass);
			if (servicesOfficeInfo.length == 1) {
				ServiceOfficeInfo serviceOfficeInfo = servicesOfficeInfo[0];
				if (serviceOfficeInfo.getId().isEmpty()) {
					log.warn("getGprEntites_ERROR: " +
									serviceOfficeInfo.getName() + "_" +
									serviceOfficeInfo.getShortName());
				}
				else {
					entities = new ArrayList<ServiceOfficeInfo>();
					entities.add(serviceOfficeInfo);
				}
			}
			else {
				entities = new ArrayList<ServiceOfficeInfo>();
				for (ServiceOfficeInfo serviceOfficeInfo : servicesOfficeInfo) {
					entities.add(serviceOfficeInfo);
				}
			}
		}
		catch (RemoteException e) {
			log.error("getGprEntites_CONTACT_ERROR: Error contacting GPR: " + e);
		}
		return entities;
	}
}
