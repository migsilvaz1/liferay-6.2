package com.gfi.chg.contact;

import com.gfi.chg.model.Area;
import com.gfi.chg.model.Contact;
import com.gfi.chg.model.Tracing;
import com.gfi.chg.service.AreaLocalServiceUtil;
import com.gfi.chg.service.ContactLocalServiceUtil;
import com.gfi.chg.service.TracingLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.InternetAddressUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class ContactPortlet
 */
public class ContactPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(ContactPortlet.class);

	@Override
	public void init() throws PortletException {
		try {
			if (AreaLocalServiceUtil.getAreasCount() == 0) {
				log.info("No previous configuration detected. Initializing configuration.");
				long companyId = PortalUtil.getDefaultCompanyId();
				Map<String, String> areas = InitialConfigurationLoaderUtil.loadAreas();
				boolean completedWithErrors = false;
				for (String areaName : areas.keySet()) {
					User responsable = null;
               try {
	               responsable = UserLocalServiceUtil.getUserByEmailAddress(companyId, areas.get(areaName));
               } catch (PortalException e) {
                  Role rol = null;
                  try {
	                  rol = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
                  } catch (PortalException e1) {
	                  log.error(e1,e1);
	                  completedWithErrors = true;
                  }
               	responsable = UserLocalServiceUtil.getRoleUsers(rol.getRoleId()).get(0);
               }
					Area area = AreaLocalServiceUtil.createArea(CounterLocalServiceUtil.increment(Area.class.getName()));
					area.setName(areaName);
					area.setMainEmail(areas.get(areaName));
					if(responsable == null){
						area.setUserId(0);
					}else{
						area.setUserId(responsable.getUserId());
					}
					area.persist();
				}
				if(completedWithErrors){
					log.info("Initial configuration completed with errors");
				}
			} else {
				log.info("Previous configuration detected. Skipping initial configuration.");
			}
		} catch (SystemException e) {
			log.error(e, e);
		}
		super.init();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	      throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
		      .getAttribute(WebKeys.THEME_DISPLAY);
		boolean signedIn = themeDisplay.isSignedIn();
		List<Contact> contacts = null;
		if (signedIn) {
			try {
				User user = themeDisplay.getUser();
				List<Area> areas = AreaLocalServiceUtil.findByUserId(user
				      .getUserId());
				contacts = new ArrayList<Contact>();
				for (Area area : areas) {
					contacts.addAll(ContactLocalServiceUtil.findByAreaId(area
					      .getAreaId()));
				}
			} catch (SystemException e) {
				log.error(e,e);
				SessionErrors.add(renderRequest, "no-contact-loaded");
			}
		}
		renderRequest.setAttribute("contacts", contacts);
		super.doView(renderRequest, renderResponse);
	}

	public void createContact(ActionRequest actionRequest,
	      ActionResponse actionResponse) throws IOException, PortletException {

		String name = ParamUtil.getString(actionRequest, "name");
		String surname = ParamUtil.getString(actionRequest, "surname");
		String activity = ParamUtil.getString(actionRequest, "activity");
		String address = ParamUtil.getString(actionRequest, "address");
		String city = ParamUtil.getString(actionRequest, "city");
		String postalCode = ParamUtil.getString(actionRequest, "postalCode");
		String email = ParamUtil.getString(actionRequest, "email");
		String telephone = ParamUtil.getString(actionRequest, "telephone");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String description = ParamUtil.getString(actionRequest, "description");

		try {
			Area defaultArea = AreaLocalServiceUtil
			      .findByName(com.gfi.chg.contact.ContactPortletConstantUtil.DEFAULT_AREA_NAME);
			Contact contact = ContactLocalServiceUtil
			      .createContact(CounterLocalServiceUtil.increment(Contact.class
			            .getName()));
			contact.setName(name);
			contact.setSurname(surname);
			contact.setActivity(activity);
			contact.setAddress(address);
			contact.setCity(city);
			contact.setPostalCode(postalCode);
			contact.setEmail(email);
			contact.setTelephone(telephone);
			contact.setSubject(subject);
			contact.setDescription(description);
			contact.setAreaId(defaultArea.getAreaId());
			contact.setStatus(com.gfi.chg.contact.ContactPortletConstantUtil.NEW);
			contact.setCreateDate(new Date());
			contact.persist();
			Tracing newTracing = TracingLocalServiceUtil
			      .createTracing(CounterLocalServiceUtil.increment(Tracing.class
			            .getName()));
			newTracing.setAreaId(defaultArea.getAreaId());
			newTracing.setContactId(contact.getContactId());
			newTracing
			      .setComment(com.gfi.chg.contact.ContactPortletConstantUtil.NEW_CONTACT_TRAZING_MESSAGE);
			newTracing
			      .setStatus(com.gfi.chg.contact.ContactPortletConstantUtil.NEW);
			newTracing.setModifiedDate(new Date());
			newTracing.persist();
			sendMailMessage(defaultArea.getMainEmail(),
			      ContactPortletConstantUtil.CONTACT_SUBJECT,
			      ContactPortletConstantUtil.NEW_CONTACT_MAIL);
			actionResponse.setRenderParameter("jspPage",
			      "/html/contact/guest-end.jsp");
		} catch (SystemException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "contact-creation-error");
		}
	}

	public void backToList(ActionRequest actionRequest,
	      ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
		      .getAttribute(WebKeys.THEME_DISPLAY);
		boolean signedIn = themeDisplay.isSignedIn();
		List<Contact> contacts = null;
		addProcessActionSuccessMessage = false;
		if (signedIn) {
			try {
				User user = themeDisplay.getUser();
				List<Area> areas = AreaLocalServiceUtil.findByUserId(user
				      .getUserId());
				contacts = new ArrayList<Contact>();
				for (Area area : areas) {
					contacts.addAll(ContactLocalServiceUtil.findByAreaId(area
					      .getAreaId()));
				}
			} catch (SystemException e) {
				log.error(e, e);
				SessionErrors.add(actionRequest, "no-contact-loaded");
			}
		}
		actionRequest.setAttribute("contacts", contacts);
		actionResponse.setRenderParameter("jspPage", "/html/contact/view.jsp");
	}

	public void answerContact(ActionRequest actionRequest,
	      ActionResponse actionResponse) throws IOException, PortletException {

		try {
			String contactIdString = ParamUtil.getString(actionRequest,
			      "contactId");
			String response = ParamUtil.getString(actionRequest, "response");
			long contactId = Long.parseLong(contactIdString);
			Contact petition = ContactLocalServiceUtil.getContact(contactId);
			Tracing finished = TracingLocalServiceUtil
			      .createTracing(CounterLocalServiceUtil.increment(Tracing.class
			            .getName()));
			finished.setContactId(contactId);
			finished.setAreaId(petition.getAreaId());
			finished
			      .setComment(ContactPortletConstantUtil.FINAL_CONTACT_TRAZING_MESSAGE_RESPONSE);
			finished.setStatus(ContactPortletConstantUtil.FINISHED);
			finished.setModifiedDate(new Date());
			finished.persist();
			petition.setResponse(response);
			petition.setStatus(ContactPortletConstantUtil.FINISHED);
			petition.persist();
			sendMailMessage(petition.getEmail(),
			      ContactPortletConstantUtil.CONTACT_RESPONSE,
			      "Mensaje original:\n" + petition.getDescription()
			            + "Respuesta:\n" + response);
		} catch (PortalException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "no-contact-fetched");
		} catch (SystemException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "general-error");
		}
	}

	public void resendContact(ActionRequest actionRequest,
	      ActionResponse actionResponse) throws IOException, PortletException {
		try {
			String contactIdString = ParamUtil.getString(actionRequest,
			      "contactId");
			String areaIdString = ParamUtil.getString(actionRequest, "areaId");
			String comment = ParamUtil.getString(actionRequest, "comment");
			long contactId = Long.parseLong(contactIdString);
			long areaId = Long.parseLong(areaIdString);
			Contact petition = ContactLocalServiceUtil.getContact(contactId);
			Area area = AreaLocalServiceUtil.getArea(areaId);
			Tracing finished = TracingLocalServiceUtil
			      .createTracing(CounterLocalServiceUtil.increment(Tracing.class
			            .getName()));
			finished.setContactId(contactId);
			finished.setAreaId(area.getAreaId());
			finished.setComment(comment);
			finished.setStatus(ContactPortletConstantUtil.RECIVED);
			finished.setModifiedDate(new Date());
			finished.persist();
			petition.setAreaId(areaId);
			petition.setStatus(ContactPortletConstantUtil.RECIVED);
			petition.persist();
			// TODO:Enviar mail con notificacion a nueva area
			sendMailMessage(area.getMainEmail(),
			      ContactPortletConstantUtil.CONTACT_SUBJECT_RESEND,
			      ContactPortletConstantUtil.RESEND_CONTACT_MAIL);
		} catch (PortalException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "persistence-error");
		} catch (SystemException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "general-error");
		}
	}

	public void endContact(ActionRequest actionRequest,
	      ActionResponse actionResponse) throws IOException, PortletException {
		try {
			String contactIdString = ParamUtil.getString(actionRequest,
			      "contactId");
			long contactId = Long.parseLong(contactIdString);
			Contact petition = ContactLocalServiceUtil.getContact(contactId);
			// Crear nuevo tracing y asignarlo
			Tracing finished = TracingLocalServiceUtil
			      .createTracing(CounterLocalServiceUtil.increment(Tracing.class
			            .getName()));
			finished.setContactId(contactId);
			finished.setAreaId(petition.getAreaId());
			finished
			      .setComment(ContactPortletConstantUtil.FINAL_CONTACT_TRAZING_MESSAGE_FINISHED);
			finished.setStatus(ContactPortletConstantUtil.FINISHED);
			finished.setModifiedDate(new Date());
			finished.persist();
			// actualizar estado y respuesta a la peticion
			petition.setStatus(ContactPortletConstantUtil.FINISHED);
			petition.persist();
		} catch (PortalException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "no-contact-fetched");
		} catch (SystemException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "general-error");
		}
	}

	public void deleteContact(ActionRequest actionRequest,
	      ActionResponse actionResponse) throws IOException, PortletException {
		try {
			String contactIdString = ParamUtil.getString(actionRequest,
			      "contactId");
			long contactId = Long.parseLong(contactIdString);
			ContactLocalServiceUtil.deleteContact(contactId);
		} catch (PortalException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "no-contact-deleted");
		} catch (SystemException e) {
			log.error(e, e);
			SessionErrors.add(actionRequest, "general-error");
		}
	}

	public void sendMailMessage(String receiverMailAddress, String mailSubject,
	      String mailBody) throws IOException, PortletException, SystemException {
		String senderMailAddress = PrefsPropsUtil
		      .getString(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		try {
			InternetAddress from = InternetAddress.parse(senderMailAddress)[0];
			InternetAddress to = InternetAddress.parse(receiverMailAddress)[0];
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(mailBody);
			mailMessage.setSubject(mailSubject);
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveArea(ActionRequest actionRequest,
	      ActionResponse actionResponse) throws IOException, PortletException {
		try {
			String areaIdString = ParamUtil.getString(actionRequest, "areaId");
			long areaId = Long.parseLong(areaIdString);
			String name = ParamUtil.getString(actionRequest, "name");
			String email = ParamUtil.getString(actionRequest, "email");
			String responsableName = ParamUtil.getString(actionRequest, "responsable");
			Area area = null;
			if(areaId == 0){
		      area = AreaLocalServiceUtil.createArea(CounterLocalServiceUtil.increment(Area.class.getName()));
			}else{
				area = AreaLocalServiceUtil.getArea(areaId);
			}
			area.setName(name);
			area.setMainEmail(email);
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User responsable = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), responsableName);
			if(responsable != null){
				area.setUserId(responsable.getUserId());
				area.persist();
			}else{
				SessionErrors.add(actionRequest, "no-such-user");
			}
      } catch (SystemException e) {
	      log.error(e,e);
	      SessionErrors.add(actionRequest, "general-error");
      } catch (PortalException e) {
	      log.error(e,e);
	      SessionErrors.add(actionRequest, "general-error");
      }
	}
}
