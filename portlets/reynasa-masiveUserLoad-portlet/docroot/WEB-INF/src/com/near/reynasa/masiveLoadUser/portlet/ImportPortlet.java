package com.near.reynasa.masiveLoadUser.portlet;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.util.IOUtils;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.OutputStreamWriter;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.BackgroundTaskLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.FileNameException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.near.reynasa.masiveLoadUser.model.MasiveLoadUser;
import com.near.reynasa.masiveLoadUser.portlet.model.CsvUserBean;
import com.near.reynasa.masiveLoadUser.scheduler.MasiveLoadUserScheduler;
import com.near.reynasa.masiveLoadUser.service.MasiveLoadUserLocalServiceUtil;

/**
 * @author 
 * 
 */
public class ImportPortlet extends MVCPortlet {
	/**
	 * 
	 */
	private static Log _log = LogFactoryUtil.getLog(ImportPortlet.class);

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortletException
	 * @throws IOException
	 */
	
	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res){
		String id = req.getParameter("id");
		File file = new File(id+".txt");  
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(d);
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
	    int minutes = cal.get(Calendar.MINUTE);
		if (file.exists()) {
		    try {
		    	res.setContentType("application/vnd.ms-excel");
				res.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+"logimport_"+id+"_"+year+month+day+hour+minutes+".csv");

				res.addProperty(
					HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		    	OutputStream out = res.getPortletOutputStream();
		    	String header = "username,correoElectronico,nombre,apellidos,password,birthday,activo,rol,codigoCentro,denCentro,codigoCliente,denCliente,codigoEmpleado,codigoDelegacion,denDelegacion,cif,direccion,municipio,codigoPostal,provincia,telefonoMovil,telefonoFijo,usuarioPuedeCanjear,usuarioPuedeAdministrar,usuarioPuedeSuplantar\n";
				out.write(header.getBytes());
				FileInputStream fileInputStream = new FileInputStream(file);
				
				IOUtils.copy(fileInputStream, out);
				
				out.flush();
				out.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void uploadCsv(javax.portlet.ActionRequest actionRequest,
			javax.portlet.ActionResponse actionResponse)
			throws PortletException, IOException {

		try {
			if (_log.isDebugEnabled()) {
				_log.debug("We are in try");
			}
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User userLiferay = themeDisplay.getUser();
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			if (uploadRequest.getSize("fileName") == 0) {
				throw new IOException("File size is 0");
			}
			Long executionId = ParamUtil.getLong(uploadRequest, "executionId");
			Long organizationId = ParamUtil.getLong(uploadRequest, "organizationId");
			
			String sourceFileName = uploadRequest.getFileName("fileName");
			File file = uploadRequest.getFile("fileName");

			if (_log.isDebugEnabled()) {
				_log.debug("File name:" + sourceFileName);
			}
			
			
			int count_good = 0;

			if (_log.isDebugEnabled()) {
				_log.debug("executionId " + executionId);
				_log.debug("organizationId " + organizationId);
				_log.debug("##### Started importing #####");
			}

			

			if (_log.isDebugEnabled()) {
				_log.debug("Now we're going to add users to portal");
			}
			FileEntry fileEntry = newFileData(userLiferay.getUserId(), file);
			MasiveLoadUser masiveLoadUser= MasiveLoadUserLocalServiceUtil.createMasiveLoadUser(CounterLocalServiceUtil.increment());
			masiveLoadUser.setSuccessFile(fileEntry.getFileEntryId());
			masiveLoadUser.setCompanyId(fileEntry.getCompanyId());
			masiveLoadUser.setGroupId(fileEntry.getGroupId());
			masiveLoadUser.setUserId(fileEntry.getUserId());
			masiveLoadUser.setUserName(userLiferay.getFullName());
			masiveLoadUser.setStatusExecution(executionId.intValue());
			masiveLoadUser.setCreateDate(new Date());
			MasiveLoadUserLocalServiceUtil.updateMasiveLoadUser(masiveLoadUser);
			
						
			if(executionId==1){
				Map<String, Serializable> taskContextMap = new HashMap<String, Serializable>();
				ServiceContext serviceContext = null;
				try {
					serviceContext = ServiceContextFactory.getInstance(actionRequest);
				}
				catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	//			taskContextMap.put("request", (Serializable) actionRequest);
				taskContextMap.put("path", file.getPath());
				taskContextMap.put("userID", userLiferay.getUserId());
				
				String portletInstanceId = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
				taskContextMap.put("portletInstanceId", portletInstanceId);
				PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletInstanceId);
				String csvSeparator = preferences.getValue("csvSeparator", "EXCEL_PREFERENCE");
				taskContextMap.put("csvSeparator", csvSeparator);
		    	String birthdayCsvStatus = preferences.getValue("birthdayCsvStatus","notnull");
				taskContextMap.put("birthdayCsvStatus", birthdayCsvStatus);
		    	String birthdayCsvOptions = preferences.getValue("birthdayCsvOptions","dd-MM-yyyy");
				taskContextMap.put("birthdayCsvOptions", birthdayCsvOptions);
				taskContextMap.put("count_good", count_good);
				
				taskContextMap.put("realUserId", userLiferay.getUserId());
				taskContextMap.put("organizationId", organizationId);
				taskContextMap.put("creatorUserId", userLiferay.getUserId());
				taskContextMap.put("companyId", themeDisplay.getCompanyId());
				taskContextMap.put("masiveLoadUser", masiveLoadUser.getId());
				String customFields = ParamUtil.getString(actionRequest, "customFields", "");
				taskContextMap.put("customFields", customFields);	
				
				//taskContextMap.put("receiversComplexList", (Serializable) users);
				
				
				String[] servletContext = {actionRequest.getPortletSession().getPortletContext().getPortletContextName()};

				try {
					BackgroundTaskLocalServiceUtil.addBackgroundTask(userLiferay.getUserId(), themeDisplay.getScopeGroupId(),
						StringPool.BLANK, servletContext, MasiveUsersTaskExecutor.class, taskContextMap, serviceContext);
				}
				catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
	
				SessionMessages.add(actionRequest, "success");
				/* we're using a session variable to hold all the beans of the CSV users
				 * for very large import this is not very good
				 * TODO: split the file or don't use memory but a file to write the status of
				 * the imported user
				 */
			//	actionRequest.setAttribute("utenti", usersBad);
				/* the total row number is utenti.size()
				 * 
				 */
				actionRequest.setAttribute("count_good", count_good);

				
				
			}else if(executionId==2){
				// cron
				masiveLoadUser.setStatusExecution(3);
				MasiveLoadUserLocalServiceUtil.updateMasiveLoadUser(masiveLoadUser);
							
				
			}

		} catch (NullPointerException e) {
			if (_log.isErrorEnabled()) {
				_log.error("Error: " + e);
			}
			SessionMessages.add(actionRequest, "error");
		}

		catch (IOException e1) {
			if (_log.isErrorEnabled()) {
				_log.error("Error Reading The File. Error: " + e1);
			}
			SessionMessages.add(actionRequest, "error");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	 
	 




	private FileEntry newFileData(long userId, File file){
		 try {
         ServiceContext serviceContext = new ServiceContext();
//			UploadPortletRequest uploadRequest = PortalUtil
//					.getUploadPortletRequest(actionRequest);
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