/* 
 * This file is part of the xxxxxxxxxx platform created by Near Technologies.
 * www.near.es
 * Copyright 2012-2013, xxxxxxxxxx.
 */

/** 
 * <b>File:</b><p>com.near.reynasa.masiveLoadUser.portlet.MasiveUsersTaskExecutor.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of xxxxxxxxxx.</p>
 * <b>Date:</b><p>19/6/2015.</p>
 * @author Near Technologies.
 * @version 1.0, 19/6/2015.
 */
package com.near.reynasa.masiveLoadUser.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.BackgroundTask;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.interfaces.TO.ClienteTO;
import com.near.reynasa.interfaces.TO.EmpleadoTO;
import com.near.reynasa.interfaces.TO.UsuarioTO;
import com.near.reynasa.interfaces.action.UsuarioTOAction;
import com.near.reynasa.masiveLoadUser.model.MasiveLoadUser;
import com.near.reynasa.masiveLoadUser.portlet.model.CsvUserBean;
import com.near.reynasa.masiveLoadUser.service.MasiveLoadUserLocalServiceUtil;
import com.sun.mail.handlers.message_rfc822;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;


/** 
 * <p>Class .</p>
 * <b>Project:</b><p>xxxxxxxxxx</p>
 * @version 1.0, 19/6/2015.
 */
public class MasiveUsersTaskExecutor extends BaseBackgroundTaskExecutor{
	private static Log _log = LogFactoryUtil.getLog(ImportPortlet.class);
	public MasiveUsersTaskExecutor() {

		setSerial(true);
	}
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		Map<String,Serializable> taskContextMap = backgroundTask.getTaskContextMap();

		UsuarioTOAction usersAction = new UsuarioTOActionImpl();
		UsuarioTO userReceiver = null;
		CsvUserBean csvUserBean = null;
		//		User userLiferay = null;

		@SuppressWarnings("unchecked")
		List<String> userReceivers = (List<String>) taskContextMap.get("userReceivers");
		@SuppressWarnings("unchecked")
		List<UsuarioTO> usersReceivers = (List<UsuarioTO>) taskContextMap.get("receiversComplexList");
		Number userID = (Number) taskContextMap.get("userID");
		Number count_goodAux = (Number) taskContextMap.get("count_good");
		Number masiveLoadUserAux = (Number) taskContextMap.get("masiveLoadUser");

		String path = (String) taskContextMap.get("path");

		long masiveLoadUserId = masiveLoadUserAux.longValue();

		MasiveLoadUser masiveLoadUser= MasiveLoadUserLocalServiceUtil.getMasiveLoadUser(masiveLoadUserId);

		String portletInstanceId = (String) taskContextMap.get("portletInstanceId");
		String csvSeparator = (String) taskContextMap.get("csvSeparator");
		String birthdayCsvStatus = (String) taskContextMap.get("birthdayCsvStatus");
		String birthdayCsvOptions = (String) taskContextMap.get("birthdayCsvOptions");
		Number realUserIdAux = (Number) taskContextMap.get("realUserId");
		Number organizationIdAux = (Number) taskContextMap.get("organizationId");
		Number creatorUserIdAux = (Number) taskContextMap.get("creatorUserId");
		Number companyIdAux = (Number) taskContextMap.get("companyId");
		String customFields = (String) taskContextMap.get("customFields");
		long realUserId = realUserIdAux.longValue();
		Long organizationId = organizationIdAux.longValue();
		long creatorUserId = creatorUserIdAux.longValue();
		long companyId = companyIdAux.longValue();



		int count_good = count_goodAux.intValue();
		int count = 1;
		UserCacheEngine userCacheEngine = UserCacheEngine.getInstance();
		UserServiceImpl usi = UserServiceImpl.getInstance();
		List<CsvUserBean> users = userCacheEngine.getUsers(path, portletInstanceId, csvSeparator, birthdayCsvStatus, birthdayCsvOptions);
		List<CsvUserBean> usersBad = new ArrayList<CsvUserBean>();
		for (CsvUserBean user : users) {
			if (_log.isDebugEnabled()) {
				_log.debug("Processing " + count + " user. "
								+ userReceiver.getNombre() + " " + userReceiver.getApellidos());
			}
			count = count + 1;
			long roleId = getRoleIdByRolCode(user.getRol());
			long roleAdminDistr = 0l;
			if(user.getRol().equals("3")){
				roleAdminDistr = getRoleIdAdminDistr();
			}
			usi.addUser(realUserId,userID.longValue(), user, roleId, organizationId, creatorUserId, companyId, new Locale("es_ES"), portletInstanceId, customFields, roleAdminDistr);
			if (!user.getImpStatus().equals("User imported.")) {
				if (_log.isDebugEnabled()) {
					_log.debug(" User not added to portal");
				}
				usersBad.add(user);
			} else {
				if (_log.isDebugEnabled()) {
					_log.debug(" User added to portal");
				}
				count_good = count_good + 1;
			}
		}
		if (_log.isDebugEnabled()) {
			_log.debug(users.size() + " Users were read from the CSV file");
			_log.debug(count_good + " Users were added to portal.");
			_log.debug("##### Finished importing. #####");
		}


		if(usersBad!=null&&usersBad.size()>0){
			//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
			File archivoError=new File(masiveLoadUser.getSuccessFile()+".txt");


			//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
			FileWriter escribirArchivoError=new FileWriter(archivoError,true);

			//Escribimos en el archivo con el metodo write
			for(CsvUserBean csvUser:usersBad){
				escribirArchivoError.write(csvUser.toString());
			}
			//Cerramos la conexion
			escribirArchivoError.flush();
			escribirArchivoError.close();

			FileEntry fileEntryError = newFileData(userID.longValue(), archivoError);


			masiveLoadUser.setErrorFile(fileEntryError.getPrimaryKey());
			masiveLoadUser.setStatusExecution(2);
			MasiveLoadUserLocalServiceUtil.updateMasiveLoadUser(masiveLoadUser);
			
		}else{
			//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
			File archivoError=new File(masiveLoadUser.getSuccessFile()+".txt");


			//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
			FileWriter escribirArchivoError=new FileWriter(archivoError,true);

			
			//Cerramos la conexion
			escribirArchivoError.flush();
			escribirArchivoError.close();

			FileEntry fileEntryError = newFileData(userID.longValue(), archivoError);


			masiveLoadUser.setErrorFile(fileEntryError.getPrimaryKey());
			masiveLoadUser.setStatusExecution(2);
			MasiveLoadUserLocalServiceUtil.updateMasiveLoadUser(masiveLoadUser);
			
		}

		Message message = new Message();

		// Background task id needs to be passed



		message.put("backgroundTaskId", BackgroundTaskThreadLocal.getBackgroundTaskId());
		

		// Pass all the necessary attributes here

		// Send it over the built-in Message Bus to the background task status
		// destination

		MessageBusUtil.sendMessage(DestinationNames.BACKGROUND_TASK_STATUS, message);
		BackgroundTaskResult result = new BackgroundTaskResult(0, "masiveUsers-finish");
		return result;
	}

	private long getRoleIdAdminDistr(){
		long res = 0l;
		String rolString = "";
		long companyId = PortalUtil.getDefaultCompanyId();
		rolString=PropsUtil.get("rol.administradorDistribuidor");
		Role role;
		try {
			role = RoleLocalServiceUtil.getRole(companyId, rolString);
			res=role.getRoleId();
		}
		catch (PortalException | SystemException e) {
			
			e.printStackTrace();
		}				
		
		return res;
	}
	/**
	 * 
	 * @param rol
	 * @return
	 */
	private long getRoleIdByRolCode(String rol) {
		String rolString = "";
		long companyId = PortalUtil.getDefaultCompanyId();
		long res = 0;
		try {
			if("1".equals(rol)){
				rolString=PropsUtil.get("rol.administrator");
				Role role = RoleLocalServiceUtil.getRole(companyId, rolString);				
				res=role.getRoleId();
			}else if("2".equals(rol)){
				rolString=PropsUtil.get("rol.administradorFuncional");
				Role role = RoleLocalServiceUtil.getRole(companyId, rolString);				
				res=role.getRoleId();
			}else if("3".equals(rol)){
				rolString=PropsUtil.get("rol.administradorDistribuidorPersonal");
				Role role = RoleLocalServiceUtil.getRole(companyId, rolString);				
				res=role.getRoleId();
			}else if("4".equals(rol)){
				rolString=PropsUtil.get("rol.cliente");
				Role role = RoleLocalServiceUtil.getRole(companyId, rolString);				
				res=role.getRoleId();
			}else if("5".equals(rol)){
				rolString=PropsUtil.get("rol.centro");
				Role role = RoleLocalServiceUtil.getRole(companyId, rolString);				
				res=role.getRoleId();
			}else if("6".equals(rol)){
				rolString=PropsUtil.get("rol.empleado");
				Role role = RoleLocalServiceUtil.getRole(companyId, rolString);				
				res=role.getRoleId();
			}else if("7".equals(rol)){
				rolString=PropsUtil.get("rol.proveedor");
				Role role = RoleLocalServiceUtil.getRole(companyId, rolString);				
				res=role.getRoleId();
			}
		}
		catch (PortalException | SystemException e) {
			e.printStackTrace();
		}

		return res;
	}





	private FileEntry newFileData(long userId, File file){
		try {
			ServiceContext serviceContext = new ServiceContext();
			//		UploadPortletRequest uploadRequest = PortalUtil
			//				.getUploadPortletRequest(actionRequest);
			Calendar c1 = Calendar.getInstance();

			//File file = uploadRequest.getFile("fileName");
			String contentType = MimeTypesUtil.getContentType(file);

			InputStream inputStream  = new FileInputStream(file);

			Folder folderName;

			folderName = DLAppLocalServiceUtil.getFolder(10181L, 0, "Promociones");

			long folderId = folderName.getFolderId();
			long repositoryId = folderName.getRepositoryId();


			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, 
				repositoryId, 
				folderId, 
				file.getName(), 
				contentType, 
				"CSV"+c1.getTimeInMillis(), 
				"description", 
				"changeLog", 
				inputStream, 
				file.length(), 
				serviceContext);

			return fileEntry;

		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

}