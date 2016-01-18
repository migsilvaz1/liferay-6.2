/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.near.notificaciones.service.impl;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.near.notificaciones.service.base.RNotificationServiceBaseImpl;
import com.near.notificaciones.util.RedireccionesRetriever;
import com.near.notificaciones.util.ReynasaNotificationHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * The implementation of the r notification remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.near.notificaciones.service.RNotificationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nearTechnologies
 * @see com.near.notificaciones.service.base.RNotificationServiceBaseImpl
 * @see com.near.notificaciones.service.RNotificationServiceUtil
 */
public class RNotificationServiceImpl extends RNotificationServiceBaseImpl {

	private Log logger = LogFactoryUtil.getLog(RNotificationServiceImpl.class);

	public String[] addNewNotification(String codigoRemitente, List<String> codigoDestinatarioList, Date fechaPrevista, String titulo, String contenido, Integer motivo){
		Long companyId = Long.parseLong(PropsUtil.get("reynasa.fidelizacion.companyId"));
		String[] resultArray = null;
		User remitente = null;
		try {
			remitente = UserLocalServiceUtil.getUserByScreenName(companyId, codigoRemitente);
			if(titulo != null && !titulo.trim().isEmpty()){
				if(contenido != null && !contenido.trim().isEmpty()){
					if(motivo != null && motivo != 0){
						String[] arrayRedireccionMotivo = RedireccionesRetriever.getRedireccionURL(motivo);
						if(RedireccionesRetriever.getRedireccionURL(motivo) != null){
							User destinatario;
							if(codigoDestinatarioList != null && !codigoDestinatarioList.isEmpty()){
								String horaPrevista, diaPrevisto;
								SimpleDateFormat diaFormat = new SimpleDateFormat("dd/MM/yyyy");
								SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
								resultArray = new String[codigoDestinatarioList.size()];
								String codigoDestinatario;
								if(fechaPrevista != null){
									horaPrevista = horaFormat.format(fechaPrevista);
									diaPrevisto = diaFormat.format(fechaPrevista);
								}else{
									Date fechaActual = new Date();
									horaPrevista = horaFormat.format(fechaActual);
									diaPrevisto = diaFormat.format(fechaActual);
								}
								JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
								String redireccionMotivo = "<br><br><a href='" + arrayRedireccionMotivo[0] + "'><i class='icon-globe'></i> Ir a " + arrayRedireccionMotivo[1] + "</a>";
								payloadJSON.put("userId", remitente.getUserId());
								payloadJSON.put("remitenteNombre", remitente.getFullName());
								payloadJSON.put("titulo", titulo);
								payloadJSON.put("contenido", contenido + redireccionMotivo);
								payloadJSON.put("fechaPrevista", diaPrevisto);
								payloadJSON.put("horaPrevista", horaPrevista);
								NotificationEvent notificationEvent;
								for(int i = 0; i < codigoDestinatarioList.size(); i++){
									codigoDestinatario = codigoDestinatarioList.get(i);
									if(codigoDestinatario != null && !codigoDestinatario.trim().isEmpty()){
										try{
											destinatario = UserLocalServiceUtil.getUserByScreenName(companyId, codigoDestinatario);
											notificationEvent = new NotificationEvent(new Date().getTime(), ReynasaNotificationHandler.PORTLET_ID, payloadJSON);
											UserNotificationEventLocalServiceUtil.addUserNotificationEvent(destinatario.getUserId(), notificationEvent);
											resultArray[i] = "'" + codigoDestinatario + "': Notificación enviada correctamente";
											logger.info(resultArray[i]);
										}catch (NoSuchUserException e){
											resultArray[i] = "'" + codigoDestinatario + "': No se ha encontrado el destinatario";
											logger.error(resultArray[i]);
										}catch (Exception e) {
											resultArray[i] = "'" + codigoDestinatario + "': Ha habido un error durante el envío de la notificación";
											logger.error(resultArray[i]);
										}
									}
								}
							}else{
								resultArray = new String[1];
								resultArray[0] = "Error: Debe seleccionar un destinatario como mínimo";
								logger.error(resultArray[0]);
							}
						}else{
							resultArray = new String[1];
							resultArray[0] = "Error: El motivo introducido para la notificación no es válido";
							logger.error(resultArray[0]);
						}
					}else{
						resultArray = new String[1];
						resultArray[0] = "Error: Debe introducir un motivo para la notificación";
						logger.error(resultArray[0]);
					}
				}else{
					resultArray = new String[1];
					resultArray[0] = "Error: Debe introducir un contenido para la notificación";
					logger.error(resultArray[0]);
				}
			}else{
				resultArray = new String[1];
				resultArray[0] = "Error: Debe introducir un título para la notificación";
				logger.error(resultArray[0]);
			}
		}catch (NoSuchUserException e){
			resultArray = new String[1];
			resultArray[0] = "Error: No se ha encontrado el usuario remitente";
			logger.error(resultArray[0]);
		}
		catch (Exception e) {
			resultArray = new String[1];
			resultArray[0] = "Error: Ha habido un error durante la operación";
			logger.error(resultArray[0]);
		}
		return resultArray;
	}
}