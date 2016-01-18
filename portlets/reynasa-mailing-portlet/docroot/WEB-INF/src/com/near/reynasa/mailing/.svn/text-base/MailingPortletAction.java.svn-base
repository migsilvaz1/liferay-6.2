
package com.near.reynasa.mailing;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.BackgroundTaskLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.near.reynasa.impl.action.ClienteTOActionImpl;
import com.near.reynasa.impl.action.DistribuidorTOActionImpl;
import com.near.reynasa.impl.action.EmpleadoTOActionImpl;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.impl.action.UtilActionImpl;
import com.near.reynasa.interfaces.TO.ClienteTO;
import com.near.reynasa.interfaces.TO.DistribuidorTO;
import com.near.reynasa.interfaces.TO.EmpleadoTO;
import com.near.reynasa.interfaces.TO.UsuarioTO;
import com.near.reynasa.interfaces.action.ClienteTOAction;
import com.near.reynasa.interfaces.action.DistribuidorTOAction;
import com.near.reynasa.interfaces.action.EmpleadoTOAction;
import com.near.reynasa.interfaces.action.UsuarioTOAction;
import com.near.reynasa.interfaces.action.UtilAction;
import com.near.reynasa.utils.IntegrationException;
import com.near.reynasa.utils.PlexException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class MailSenderAction
 */
public class MailingPortletAction extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(MailingPortletAction.class);

	@ProcessAction(name = "loadUsers")
	public void loadUsers(ActionRequest actionRequest, ActionResponse actionResponse) {

		ClienteTOAction cliente = new ClienteTOActionImpl();
		EmpleadoTOAction empleado = new EmpleadoTOActionImpl();
		UsuarioTOAction usersAction = new UsuarioTOActionImpl();
		UsuarioTO currentUser = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			User user = themeDisplay.getUser();
			currentUser = usersAction.findByUserCode(user.getScreenName());

			String receiver = ParamUtil.getString(actionRequest, "receiver");
			String cadena = actionRequest.getParameter("cadena");
			String zona = actionRequest.getParameter("zona");
			String tipoNegocio = actionRequest.getParameter("tipoNegocio");
			String comercial = actionRequest.getParameter("comercial");
			String delegacion = actionRequest.getParameter("delegacion");
			String clasificacion = actionRequest.getParameter("clasificacion");
			String departamento = actionRequest.getParameter("departamento");
			Boolean points = ParamUtil.getBoolean(actionRequest, "points");
			Boolean registered = ParamUtil.getBoolean(actionRequest, "registered");
			Boolean travel = ParamUtil.getBoolean(actionRequest, "travel");
			Boolean cash = ParamUtil.getBoolean(actionRequest, "cash");

			DistribuidorTOAction dist = new DistribuidorTOActionImpl();
			DistribuidorTO distribuidor = dist.findDistribuidorById(Long.parseLong(currentUser.getDistrCod()), true);
			Integer anioActivo = distribuidor.getAnioActivo();

			List filteredUserd = null;
			switch (receiver) {
			case "client":
				filteredUserd = new ArrayList<ClienteTO>();
				filteredUserd = 
					cliente.findClienteByFilter(
						Long.parseLong(currentUser.getDistrCod()), cadena, zona, tipoNegocio, comercial, delegacion,
						clasificacion, points, registered, travel, cash, anioActivo.toString());
				actionRequest.setAttribute("clientesList", filteredUserd);
				break;
			case "employee":
				filteredUserd = new ArrayList<EmpleadoTO>();
				filteredUserd =
					empleado.findEmpleadoByFilter(
						Long.parseLong(currentUser.getDistrCod()), cadena, zona, tipoNegocio, comercial, delegacion,
						clasificacion, departamento, points, registered, anioActivo.toString());
				actionRequest.setAttribute("empleadosList", filteredUserd);
				break;

			}
			actionRequest.setAttribute("typeReceiver", receiver);
			if (filteredUserd.isEmpty()) {
				SessionErrors.add(actionRequest.getPortletSession(), "mailing-no-results");
			}
			else {
				actionRequest.getPortletSession().setAttribute("receiversList", filteredUserd);
				actionRequest.setAttribute("user-results", Boolean.TRUE);
				
				SessionMessages.add(actionRequest, themeDisplay.getPortletDisplay().getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			}

		}
		catch (IntegrationException e) {
			LOG.error(e.getLocalizedMessage());
			SessionErrors.add(actionRequest.getPortletSession(), e.getLocalizedMessage());
		}
		catch (NumberFormatException e) {
			LOG.error(e.getLocalizedMessage());
			SessionErrors.add(actionRequest.getPortletSession(), e.getLocalizedMessage());
		}
		catch (PlexException e) {
			LOG.error(e.getLocalizedMessage());
			SessionErrors.add(actionRequest.getPortletSession(), e.getLocalizedMessage());

		}
	}

	public void sendMailMessage(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, AddressException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			User user = themeDisplay.getUser();

			String mailSubject = ParamUtil.getString(actionRequest, "mailSubject");
			String mailCampaign = ParamUtil.getString(actionRequest, "mailCampaign");
			String mailBody = ParamUtil.getString(actionRequest, "mailBody");
			String senderMailAddress = ParamUtil.getString(actionRequest, "senderEmailAddess");
			String[] userReceivers = ParamUtil.getParameterValues(actionRequest, "receiversEmailAddress", new String[0]);
			String typeReceiver = ParamUtil.getString(actionRequest, "typeReceiver");
			
			List<String> userReceiverList = new ArrayList<>(Arrays.asList(userReceivers));
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			Map<String, Serializable> taskContextMap = new HashMap<String, Serializable>();
			
			taskContextMap.put("mailSubject", mailSubject);
			taskContextMap.put("mailCampaign", mailCampaign);
			taskContextMap.put("mailBody", mailBody);
			taskContextMap.put("senderMailAddress", senderMailAddress);
			taskContextMap.put("userReceivers", (Serializable) userReceiverList);
			taskContextMap.put("typeReceiver", typeReceiver);
			taskContextMap.put("userID", user.getUserId());

			switch (typeReceiver) {
			case "client":
				List<ClienteTO> clientesReceiver =
					(List<ClienteTO>) actionRequest.getPortletSession().getAttribute("receiversList");
				taskContextMap.put("receiversComplexList", (Serializable) clientesReceiver);
				break;
			case "employee":
				List<EmpleadoTO> empleadosReceiver = (List<EmpleadoTO>) actionRequest.getPortletSession().getAttribute("receiversList");
				taskContextMap.put("receiversComplexList", (Serializable) empleadosReceiver);
				break;

			}
			String[] servletContext = {actionRequest.getPortletSession().getPortletContext().getPortletContextName()};
			
			
			BackgroundTaskLocalServiceUtil.addBackgroundTask(user.getUserId(), themeDisplay.getScopeGroupId(),
				StringPool.BLANK, servletContext, MailTaskExecutor.class, taskContextMap, serviceContext);

			SessionMessages.add(actionRequest.getPortletSession(), "mail-send-success");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest.getPortletSession(), "mailing-error-liferay-server");
		}
		catch (SystemException e) {
			SessionErrors.add(actionRequest.getPortletSession(), "mailing-error-liferay-server");
		}
	}

	@ProcessAction(name = "backLoadUsers")
	public void backLoadUsers(ActionRequest actionRequest, ActionResponse actionResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		actionRequest.getPortletSession().removeAttribute("receiversList");
		actionRequest.removeAttribute("user-results");
		SessionMessages.add(actionRequest, themeDisplay.getPortletDisplay().getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UsuarioTOAction currentUserAction = new UsuarioTOActionImpl();
		UtilAction util = new UtilActionImpl();
		User user = themeDisplay.getUser();
		UsuarioTO currentUser = null;

		Map<String, String> cadenaList = null;
		Map<String, String> zonaList = null;
		Map<String, String> tipoNegocioList = null;
		Map<String, String> comercialList = null;
		Map<String, String> delegacionList = null;
		Map<String, String> departamentoList = null;
		try {
			currentUser = currentUserAction.findByUserCode(user.getScreenName());
			if (currentUser != null) {
				cadenaList = util.findAllCadenas(Long.parseLong(currentUser.getDistrCod()));
				zonaList = util.findAllZonas(Long.parseLong(currentUser.getDistrCod()));
				tipoNegocioList = util.findAllTipoNegocio(Long.parseLong(currentUser.getDistrCod()));
				comercialList = util.findAllComerciales(Long.parseLong(currentUser.getDistrCod()));
				delegacionList = util.findAllDelegaciones(Long.parseLong(currentUser.getDistrCod()));
				departamentoList = util.findAllDepartamento(Long.parseLong(currentUser.getDistrCod()));
				List<ClienteTO> clientesList = null;
				List<EmpleadoTO> empleadosList = null;

				if (renderRequest.getAttribute("clientesList") != null) {
					clientesList = (List) renderRequest.getAttribute("clientesList");
				}
				else {
					clientesList = new ArrayList<ClienteTO>();
				}
				if (renderRequest.getAttribute("empleadosList") != null) {
					empleadosList = (List) renderRequest.getAttribute("empleadosList");
				}
				else {
					empleadosList = new ArrayList<EmpleadoTO>();
				}

				String typeReceiver = (String) renderRequest.getAttribute("typeReceiver");
				renderRequest.setAttribute("typeReceiver", typeReceiver);
				renderRequest.setAttribute("clientesList", clientesList);
				renderRequest.setAttribute("empleadosList", empleadosList);
				renderRequest.setAttribute("cadenaList", cadenaList);
				renderRequest.setAttribute("zonaList", zonaList);
				renderRequest.setAttribute("tipoNegocioList", tipoNegocioList);
				renderRequest.setAttribute("comercialList", comercialList);
				renderRequest.setAttribute("delegacionList", delegacionList);
				renderRequest.setAttribute("departamentoList", departamentoList);
				super.doView(renderRequest, renderResponse);
				
			}
		}
		catch (IntegrationException | PlexException e1) {
			LOG.error(e1.getLocalizedMessage());
			SessionErrors.add(renderRequest.getPortletSession(), e1.getLocalizedMessage());
		}
	}

}
