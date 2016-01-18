package com.near.reynasa.masiveLoadUser.portlet;

/**
 * @author Filippo Maria Del Prete
 * 
 * based on the original work of Paul Butenko
 * http://java-liferay.blogspot.it/2012/09/how-to-make-users-import-into-liferay.html
 *
 */
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.interfaces.action.UsuarioTOAction;
import com.near.reynasa.masiveLoadUser.portlet.model.CsvUserBean;
import com.near.reynasa.utils.IntegrationException;
import com.near.reynasa.utils.PlexException;

import org.apache.commons.beanutils.PropertyUtils;

public class UserServiceImpl {
	private static Log _log = LogFactoryUtil.getLog(UserServiceImpl.class);

	private static UserServiceImpl INSTANCE = new UserServiceImpl();
	
	private UsuarioTOAction usuarioTOAction = new UsuarioTOActionImpl();

	private UserServiceImpl() {
	}

	public static UserServiceImpl getInstance() {
		return INSTANCE;
	}

	public User addUser(long realUserId,long userId, CsvUserBean userBean, Long roleId, Long organizationId, long creatorUserId, long companyId, Locale locale,  String portletInstanceId, String customFields, long roleAdminDistr) {
		boolean plexCreate = false;
		//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			plexCreate = usuarioTOAction.createUser(userBean.getUsuarioTO(userId));
		}
		catch (IntegrationException | PlexException e) {
			userBean.setImpStatus(e.getMessage());
		}
		if(!plexCreate){
			userBean.setImpStatus("PLEX ERROR");
			return null;
		}
		User user = addLiferayUser(userBean, roleId, organizationId, creatorUserId, companyId, locale, portletInstanceId, customFields, roleAdminDistr);
		if (user != null && plexCreate) {
			userBean.setLiferayUserId(user.getUserId());
			userBean.setImpStatus("User imported.");
			if (_log.isDebugEnabled()){
				_log.debug("User: " + userBean.getNombre() + " " + userBean.getApellidos() + " was added to liferay.");
			}
		} else {
			try {
				User realUser = UserLocalServiceUtil.getUser(realUserId);
				boolean res = usuarioTOAction.removeUser(userBean.getUsuarioTO(userId).getCodigo(), realUser.getFullName());
			}
			catch (IntegrationException | PlexException e) {
			}
			catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (_log.isDebugEnabled()){
				_log.debug("User: " + userBean.getNombre() + " " + userBean.getApellidos() + " not added to liferay." );
			}
		}
		return user;
	}

	private User addLiferayUser(CsvUserBean userBean, Long roleId, Long organizationId, long creatorUserId, long companyId, Locale locale,  String portletInstanceId, String customFields, long roleAdminDistr) {
		User user = null;
		try {
			//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			//long creatorUserId = themeDisplay.getUserId(); 
			//long companyId = themeDisplay.getCompanyId(); 
			boolean autoPassword = false;
			String password1 = userBean.getPassword();
			String password2 = userBean.getPassword();
			boolean autoScreenName = false;
			String screenName = userBean.getUsername();
			String emailAddress = userBean.getCorreoElectronico();
			long facebookId = 0;
			String openId = "";
			//Locale locale = themeDisplay.getLocale();
			String firstName = userBean.getNombre();
			String middleName = "";
			String lastName = userBean.getApellidos();

			int prefixId = 0;

			int suffixId = 0;
			boolean male = true;

			int birthdayMonth = 1;
			int birthdayDay = 1;
			int birthdayYear = 1970;

			if (userBean.getBirthday() != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(userBean.getBirthday());
				birthdayMonth = cal.get(Calendar.MONTH);
				birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
				birthdayYear = cal.get(Calendar.YEAR);
			}

			String jobTitle = "";
			

			long[] groupIds = null;

			long[] organizationIds = null;
			if (organizationId != 0 ) {
				organizationIds = new long[1];
				organizationIds[0] = organizationId;
			}
			
			long[] roleIds = null;
			if (roleId != 0 && roleAdminDistr == 0) {
				roleIds = new long[1];
				roleIds[0] = roleId;
			}else if(roleId != 0 && roleAdminDistr != 0){
				roleIds = new long[2];
				roleIds[0] = roleId;
				roleIds[1] = roleAdminDistr;
			}

			long[] userGroupIds = null;

			boolean sendEmail = false;

			ServiceContext serviceContext = new ServiceContext();
			user = null;
			boolean userbyscreeenname_exists = true;
			boolean userbyemail_exists = true;

			try {
				user = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
			} catch (NoSuchUserException nsue) {
				userbyscreeenname_exists = false;
			}
			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			} catch (NoSuchUserException nsue) {
				userbyemail_exists = false;
			}

			if((!userbyscreeenname_exists) & (!userbyemail_exists))
			{
				
				user = UserLocalServiceUtil.addUser(creatorUserId,
						companyId,
						autoPassword,
						password1,
						password2,
						autoScreenName,
						screenName,
						emailAddress,
						facebookId,
						openId,
						locale,
						firstName,
						middleName,
						lastName,
						prefixId,
						suffixId,
						male,
						birthdayMonth,
						birthdayDay,
						birthdayYear,
						jobTitle,
						groupIds,
						organizationIds,
						roleIds,
						userGroupIds,
						sendEmail,
						serviceContext);

				user.setPasswordReset(false);
				user = UserLocalServiceUtil.updateUser(user);

				UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED);
				Indexer indexer = IndexerRegistryUtil.getIndexer(User.class);

				indexer.reindex(user);
				userBean.setImpStatus("User imported.");
				// the user is created: here we save the custom fields
				saveCustomFields(user, userBean, portletInstanceId, customFields);
			} else {
				String msg_exists = "";
				if (userbyscreeenname_exists) {
					msg_exists = msg_exists + "Screen Name is not unique.";
				}
				if (userbyemail_exists) {
					msg_exists = msg_exists + " Email Address is not unique.";
				}

				userBean.setImpStatus(msg_exists);
				user = null;
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return user;
	}

	private boolean saveCustomFields(User user, CsvUserBean userBean, String portletInstanceId, String customFields){ 
		boolean retVal = false;
		/*TODO with the current user we have to check if he can use the expando fields
 	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
   long userId = themeDisplay.getUserId(); 
   long companyId = themeDisplay.getCompanyId(); 
   User userAdmin = UserLocalServiceUtil.getUser(userId);
		 */
//	String customFields = preferences.getValue("customFields", "");
		if(customFields != null && !customFields.isEmpty()) {
			String cFs[] = customFields.split(",");
			String beanFieldValue = "";
			String cfName = "";
			int k = 0;
			for (int j = 0; j < cFs.length; j++){
				k = j + 1;
				cfName = "cf" + k;
				try {
					beanFieldValue = (String) PropertyUtils.getProperty(userBean, cfName);
					user.getExpandoBridge().setAttribute(cFs[j], beanFieldValue);
					if (_log.isDebugEnabled()){
						_log.debug("User custom field: " + cFs[j] + " " + beanFieldValue);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
				retVal = true;
			}
		} else {
			retVal = false;
		}

		return retVal;
	}

}