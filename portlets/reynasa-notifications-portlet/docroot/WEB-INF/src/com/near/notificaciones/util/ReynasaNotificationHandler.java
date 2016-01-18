package com.near.notificaciones.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;

public class ReynasaNotificationHandler extends BaseUserNotificationHandler {
	public static final String PORTLET_ID = "reynasanotifications_WAR_reynasanotificationsportlet";

	public ReynasaNotificationHandler() {
		setPortletId(ReynasaNotificationHandler.PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String remitenteNombre = "de: " + payloadJSON.getString("remitenteNombre");
		String titulo =payloadJSON.getString("titulo");
		String contenido = payloadJSON.getString("contenido").length() > 100? payloadJSON.getString("contenido").substring(0, 100)+"..." : payloadJSON.getString("contenido");
		String fechaPrevista = "Fecha prevista: " + payloadJSON.getString("fechaPrevista");
		String horaPrevista = payloadJSON.getString("horaPrevista");
		if(horaPrevista != null && !horaPrevista.trim().isEmpty()){
			fechaPrevista = fechaPrevista.concat(" a las " + horaPrevista);
		}
		String body = StringUtil.replace(getBodyTemplate(), new String[] {"[$REMITENTE$]", "[$TITULO$]", "[$FECHAPREVISTA$]", "[$CONTENIDO$]" }, new String[] {remitenteNombre, titulo, fechaPrevista, contenido });
		return body;
	}
	
	protected String getBodyTemplate() throws Exception {
		StringBundler sb = new StringBundler();
		sb.append("<div style=\"margin-top: 10px; margin-bottom: 5px;\">[$REMITENTE$]</div><b>[$TITULO$]</b><br><span style=\"color: #7f7f7f;\">[$FECHAPREVISTA$]</span><br>[$CONTENIDO$]");
		return sb.toString();
		
	}
}