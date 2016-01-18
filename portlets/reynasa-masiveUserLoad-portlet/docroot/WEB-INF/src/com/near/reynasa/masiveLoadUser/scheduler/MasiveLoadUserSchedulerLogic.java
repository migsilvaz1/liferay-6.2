package com.near.reynasa.masiveLoadUser.scheduler;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.BackgroundTask;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalStructure;
import com.near.reynasa.masiveLoadUser.model.MasiveLoadUser;
import com.near.reynasa.masiveLoadUser.portlet.ImportPortlet;
import com.near.reynasa.masiveLoadUser.portlet.UserCacheEngine;
import com.near.reynasa.masiveLoadUser.portlet.UserServiceImpl;
import com.near.reynasa.masiveLoadUser.portlet.model.CsvUserBean;
import com.near.reynasa.masiveLoadUser.service.MasiveLoadUserLocalServiceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;


public final class MasiveLoadUserSchedulerLogic {
	private static final Log LOG = LogFactoryUtil.getLog(MasiveLoadUserSchedulerLogic.class);
	private static final String EXCEPTION_GET_GROUP_OR_STRUCTURE = "Error al obtener el grupo o la estructura, ";
	private static final String ITS_FOUND_MESSAGE = "Se han encontrado ";
	private static Log _log = LogFactoryUtil.getLog(ImportPortlet.class);


	/**
	 * 
	 * @param period
	 * @param structureName
	 * @param locale
	 * @param groupName
	 * @return
	 */
	public static void executePendingCSV() {
		try {
			List<MasiveLoadUser> MasiveLoadUsersAux = MasiveLoadUserLocalServiceUtil.getMasiveLoadUsers(0, MasiveLoadUserLocalServiceUtil.getMasiveLoadUsersCount()-1);
			List<MasiveLoadUser> MasiveLoadUsers = new LinkedList<MasiveLoadUser>();
			for(MasiveLoadUser m : MasiveLoadUsersAux){
				if(m.getStatusExecution()==3){
					MasiveLoadUsers.add(m);
				}
			}
			for(MasiveLoadUser masiveLoadUser : MasiveLoadUsers){
				int count_good = 0;
				int count = 1;
				UserCacheEngine userCacheEngine = UserCacheEngine.getInstance();
				UserServiceImpl usi = UserServiceImpl.getInstance();

				long fileId = masiveLoadUser.getSuccessFile();
				DLFileEntry dlSuccessEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileId);
				long companyId = dlSuccessEntry.getCompanyId();
				Company c = CompanyLocalServiceUtil.getCompany(companyId);
				Properties properties=PortalUtil.getPortalProperties();

				String serverHome = properties.getProperty("liferay.home");
				//		String path =portalURL+"/c/document_library/get_file?uuid="+dlSuccessEntry.getUuid()+"&groupId="+dlSuccessEntry.getGroupId();
				String path = serverHome+"/data/document_library/"+dlSuccessEntry.getCompanyId()+"/"+dlSuccessEntry.getFolderId()+"/"+dlSuccessEntry.getName()+"/1.0";
				List<CsvUserBean> users = userCacheEngine.getUsers(path, "reynasamasiveUserLoad_WAR_reynasamasiveUserLoadportlet", "EXCEL_PREFERENCE", "notnull", "dd-MM-yyyy");
				List<CsvUserBean> usersBad = new ArrayList<CsvUserBean>();
				for (CsvUserBean user : users) {

					if (_log.isDebugEnabled()) {
						_log.debug("Processing " + count + " user. "
										+ user.getNombre() + " " + user.getApellidos());
					}
					count = count + 1;
					long roleId = getRoleIdByRolCode(user.getRol());
					long roleAdminDistr = 0l;
					if(user.getRol().equals("3")){
						roleAdminDistr = getRoleIdAdminDistr();
					}
					usi.addUser(masiveLoadUser.getUserId(),masiveLoadUser.getUserId(), user, roleId, 0l, masiveLoadUser.getUserId(), masiveLoadUser.getCompanyId(), new Locale("es_ES"), "reynasamasiveUserLoad_WAR_reynasamasiveUserLoadportlet", "", roleAdminDistr);
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
					FileWriter escribirArchivoErrores=new FileWriter(archivoError,true);

					//Escribimos en el archivo con el metodo write
					for(CsvUserBean csvUser:usersBad){
						escribirArchivoErrores.write(csvUser.toString());
					}
					//Cerramos la conexion
					escribirArchivoErrores.flush();
					escribirArchivoErrores.close();
					FileEntry fileEntryError = newFileData(masiveLoadUser.getUserId(), archivoError);


					masiveLoadUser.setErrorFile(fileEntryError.getPrimaryKey());
					masiveLoadUser.setStatusExecution(2);
					MasiveLoadUserLocalServiceUtil.updateMasiveLoadUser(masiveLoadUser);
					User user = UserLocalServiceUtil.getUser(masiveLoadUser.getUserId());

					JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
					payloadJSON.put("userId", user.getUserId());
					payloadJSON.put("remitenteNombre", user.getFullName());
					Locale locale = new Locale("es_ES");
					payloadJSON.put("titulo", LanguageUtil.get(locale , "asunto-carga"));
					payloadJSON.put("contenido", LanguageUtil.get(locale, "contenido-carga"));
					payloadJSON.put("fechaPrevista", new Date().getDay());
					payloadJSON.put("horaPrevista", new Date().getHours());

					NotificationEvent notificationEvent = new NotificationEvent(new Date().getTime(), "reynasamasiveUserLoad_WAR_reynasamasiveUserLoadportlet", payloadJSON);

					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(user.getUserId(), notificationEvent);
				}else {
					//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
					File archivoError=new File(masiveLoadUser.getSuccessFile()+".txt");


					//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
					FileWriter escribirArchivoErrores=new FileWriter(archivoError,true);

					//Cerramos la conexion
					escribirArchivoErrores.flush();
					escribirArchivoErrores.close();
					FileEntry fileEntryError = newFileData(masiveLoadUser.getUserId(), archivoError);


					masiveLoadUser.setErrorFile(fileEntryError.getPrimaryKey());
					masiveLoadUser.setStatusExecution(2);
					MasiveLoadUserLocalServiceUtil.updateMasiveLoadUser(masiveLoadUser);
					User user = UserLocalServiceUtil.getUser(masiveLoadUser.getUserId());

					JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
					payloadJSON.put("userId", user.getUserId());
					payloadJSON.put("remitenteNombre", user.getFullName());
					Locale locale = new Locale("es_ES");
					payloadJSON.put("titulo", LanguageUtil.get(locale , "asunto-carga"));
					payloadJSON.put("contenido", LanguageUtil.get(locale, "contenido-carga"));
					payloadJSON.put("fechaPrevista", new Date().getDay());
					payloadJSON.put("horaPrevista", new Date().getHours());

					NotificationEvent notificationEvent = new NotificationEvent(new Date().getTime(), "reynasamasiveUserLoad_WAR_reynasamasiveUserLoadportlet", payloadJSON);

					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(user.getUserId(), notificationEvent);
				}

			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private MasiveLoadUserSchedulerLogic() {
		// Prevent instantiation
		throw new AssertionError("Instantiating utility class...");
	}
	private static long getRoleIdAdminDistr(){
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
	private static long getRoleIdByRolCode(String rol) {
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





	private static FileEntry newFileData(long userId, File file){
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
