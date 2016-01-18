package com.near.notificaciones.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.near.notificaciones.util.ReynasaNotificationHandler;
import com.near.notificaciones.util.UserRetriever;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

public class NotificacionesPortlet extends MVCPortlet{

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		try {
			Long idRol = Long.parseLong(ParamUtil.getString(resourceRequest, "idRol"));
			UserRetriever.putUsersJSON(resourceRequest, resourceResponse, UserLocalServiceUtil.getRoleUsers(idRol));
		} catch (SystemException e) {
			System.out.println("Excepción en NotificacionesPortlet línea 39 - " + e.toString() + ": " + e.getMessage());
		}
	}
	
	@ProcessAction(name="busqueda")
	public void busqueda(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException{		
		String busqueda = ParamUtil.getString(actionRequest, "idBusqueda");
		actionRequest.setAttribute("idBusqueda", busqueda);
		String busquedaFecha = ParamUtil.getString(actionRequest, "fechaFiltroInput");
		actionRequest.setAttribute("fechaFiltroInput", busquedaFecha);
	}

	public void sendNotificacion(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{		
		Long idDestino;
		String remitenteId = ParamUtil.getString(actionRequest, "remitenteId");
		User remitente = UserLocalServiceUtil.getUser(Long.parseLong(remitenteId));
		String titulo = ParamUtil.getString(actionRequest, "titulo");
		String contenido = ParamUtil.getString(actionRequest, "contenido");
		String fechaPrevista = ParamUtil.getString(actionRequest,"fechaPrevistaInput").trim();
		String horaPrevista = ParamUtil.getString(actionRequest,"horaPrevistaInput").trim();
		try {
			String tipoNotificacion = ParamUtil.getString(actionRequest, "tipoNotificacionSelect");
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			// Este atributo se utiliza para mostrar la foto de perfil de quien ha enviado la notificación.
			// Se está recibiendo como un parámetro hidden desde el formulario de nueva notificación.
			payloadJSON.put("userId", remitenteId);
			payloadJSON.put("remitenteNombre", remitente.getFullName());
			payloadJSON.put("titulo", titulo);
			payloadJSON.put("contenido", contenido);
			payloadJSON.put("fechaPrevista", fechaPrevista);
			payloadJSON.put("horaPrevista", horaPrevista);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			//Si es una notificación general se comprueba si se envía a todos los miembros de un rol o una subselección
			if(tipoNotificacion.compareTo(LanguageUtil.get(actionRequest.getLocale(), "notificaciones.formularioNueva.tipo.general")) == 0){
				String selectTipoSeleccionDest = ParamUtil.getString(actionRequest,"selectTipoSeleccionDest");
				if(selectTipoSeleccionDest.compareTo(LanguageUtil.get(actionRequest.getLocale(), "notificaciones.formularioNueva.destinatario.todos")) == 0){
					List<User> usuariosNotificar = UserLocalServiceUtil.getRoleUsers(ParamUtil.getLong(actionRequest, "rolDestinatarioSelect"));
					for(User user : usuariosNotificar){
						idDestino = user.getUserId();
						UserNotificationEventLocalServiceUtil.addUserNotificationEvent(idDestino, ReynasaNotificationHandler.PORTLET_ID, new Date().getTime(), idDestino, payloadJSON.toString(), false, serviceContext);
						//System.out.println("Id: " + idDestino +" Nombre: " + UserLocalServiceUtil.getUser(idDestino).getFullName());
					}
				}else{
					long[] idDestinatarios = ParamUtil.getLongValues(actionRequest, "destinatariosMultiselect");
					for(long idDestinatario : idDestinatarios){
						UserNotificationEventLocalServiceUtil.addUserNotificationEvent(idDestinatario, ReynasaNotificationHandler.PORTLET_ID, new Date().getTime(), idDestinatario, payloadJSON.toString(), false, serviceContext);
						//System.out.println("Id: " + idDestinatario +" Nombre: " + UserLocalServiceUtil.getUser(idDestinatario).getFullName());
					}
				}
			}
			else{
				if(tipoNotificacion.compareTo(LanguageUtil.get(actionRequest.getLocale(), "notificaciones.formularioNueva.tipo.personal")) == 0){
					idDestino = ParamUtil.getLong(actionRequest,"idDestinatarioInput");
					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(idDestino, ReynasaNotificationHandler.PORTLET_ID, new Date().getTime(), idDestino, payloadJSON.toString(), false, serviceContext);
					//System.out.println("Id: " + idDestino +" Nombre: " + UserLocalServiceUtil.getUser(idDestino).getFullName());
				}else{
					System.out.println("Excepción en NotificacionesPortlet línea 86 - " + "Error, no se ha escogido un tipo de notificación correcto.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteNotificacion(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		Long idNotificacionEliminar = Long.parseLong(ParamUtil.getString(actionRequest, "idNotificacionEliminar"));
		UserNotificationEventLocalServiceUtil.deleteUserNotificationEvent(idNotificacionEliminar);
	}
	
	public void viewNotificacion(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		Long idNotificacionLeida = Long.parseLong(ParamUtil.getString(actionRequest, "idNotificacionLeida"));
		UserNotificationEvent notificacionAux = UserNotificationEventLocalServiceUtil.getUserNotificationEvent(idNotificacionLeida);
		if(notificacionAux.getArchived() == true){
			notificacionAux.setArchived(false);
		}else{
			notificacionAux.setArchived(true);
		}
		UserNotificationEventLocalServiceUtil.updateUserNotificationEvent(notificacionAux);
		//Ocultar el msg por defecto
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		try {
			actionResponse.sendRedirect(redirect);
		} catch (IOException e) {
			System.out.println("error al redirigir en viewNotificacion - Notificaciones Portlet: " + e.toString());
		}
	}
}
