
package com.near.reynasa.mailing;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.xmlrpc.Response;
import com.liferay.portal.model.BackgroundTask;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.interfaces.TO.ClienteTO;
import com.near.reynasa.interfaces.TO.EmpleadoTO;
import com.near.reynasa.interfaces.TO.UsuarioTO;
import com.near.reynasa.interfaces.action.UsuarioTOAction;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MailTaskExecutor extends BaseBackgroundTaskExecutor {

	public MailTaskExecutor() {

		setSerial(true);
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {

		Map<String,Serializable> taskContextMap = backgroundTask.getTaskContextMap();
		
		UsuarioTOAction usersAction = new UsuarioTOActionImpl();
		

		User senderUser = null;
		
		String mailSubject = (String) taskContextMap.get("mailSubject");
		String mailCampaign = (String) taskContextMap.get("mailCampaign");
		@SuppressWarnings("unchecked")
		List<String> userReceivers = (List<String>) taskContextMap.get("userReceivers");
		String typeReceiver = (String) taskContextMap.get("typeReceiver");
		Number userID = (Number) taskContextMap.get("userID");
		senderUser = UserLocalServiceUtil.getUser(userID.longValue());

		if (typeReceiver.equals("client")) {
			@SuppressWarnings("unchecked")
			List<ClienteTO> clientesReceiver = (List<ClienteTO>) taskContextMap.get("receiversComplexList");
			ClienteTO clienteReceiver = null;
			for (String clientIndex : userReceivers) {
				String mailBody = (String) taskContextMap.get("mailBody");
				UsuarioTO userReceiver = null;
				String nombreDelCliente = "";
				String numeroDelCliente = "";
				String nombreDelEmpleado = "";
				String numeroDelEmpleado = "";
				String nombreDelCentro = "";
				String numeroDelCentro = "";
				String nombreDelUsuario = "";
				String importeDeFacturacion = "";
				String puntosDeFacturacion = "";
				String puntosDePromocion = "";
				String puntosConsumidosDeFacturacion = "";
				String puntosConsumidosDePromocion = "";
				String puntosDisponiblesDeFacturacion = "";
				String puntosDisponiblesDePromocion = "";
				
				clienteReceiver = clientesReceiver.get(Integer.parseInt(clientIndex));
				userReceiver = usersAction.findByUserCode(clienteReceiver.getCodUsuario());
//				userLiferay = UserLocalServiceUtil.getUserByScreenName(senderUser.getCompanyId(), userReceiver.getCodigo());
				nombreDelCliente = clienteReceiver.getNombre();
				numeroDelCliente = clienteReceiver.getNumero();
				nombreDelCentro = clienteReceiver.getNombreCentro();
				numeroDelCentro = clienteReceiver.getNumeroCentro();
				nombreDelUsuario = userReceiver.getNombre();
				importeDeFacturacion = clienteReceiver.getImporteFacturacion();
				puntosDeFacturacion = clienteReceiver.getPuntosFacturacion();
				puntosDePromocion = clienteReceiver.getPuntosPromocion();
				puntosConsumidosDeFacturacion = clienteReceiver.getPuntosConsumidosFacturacion();
				puntosConsumidosDePromocion = clienteReceiver.getPuntosConsumidosPromocion();
				puntosDisponiblesDeFacturacion = clienteReceiver.getPuntosDisponiblesFacturacion();
				puntosDisponiblesDePromocion = clienteReceiver.getPuntosDisponiblesPromocion();

				mailBody =
					StringUtil.replace(mailBody, new String[] {
						"[$NOMBRE_DEL_CLIENTE$]", "[$NUMERO_DEL_CLIENTE$]", "[$NOMBRE_DEL_EMPLEADO$]",
						"[$NUMERO_DEL_EMPLEADO$]", "[$NOMBRE_DEL_CENTRO$]", "[$NUMERO_DEL_CENTRO$]",
						"[$NOMBRE_DEL_USUARIO$]", "[$IMPORTE_DE_FACTURACION$]", "[$PUNTOS_DE_FACTURACION$]",
						"[$PUNTOS_DE_PROMOCION$]", "[$PUNTOS_CONS_FACTURACION$]",
						"[$PUNTOS_CONS_PROMOCION$]", "[$PUNTOS_DISP_FACTURACION$]",
						"[$PUNTOS_DISP_PROMOCION$]"
					}, new String[] {
						nombreDelCliente, numeroDelCliente, nombreDelEmpleado, numeroDelEmpleado, nombreDelCentro,
						numeroDelCentro, nombreDelUsuario, importeDeFacturacion, puntosDeFacturacion,
						puntosDePromocion, puntosConsumidosDeFacturacion, puntosConsumidosDePromocion,
						puntosDisponiblesDeFacturacion, puntosDisponiblesDePromocion
					});
				
		  		SubscriptionSender subscriptionSender = new SubscriptionSender();
		  		 
				subscriptionSender.setSubject(mailSubject + " - " + mailCampaign);
				subscriptionSender.setBody(mailBody.toString());
				subscriptionSender.setUserId(userID.longValue());
				subscriptionSender.setCompanyId(senderUser.getCompanyId());
				subscriptionSender.setFrom(senderUser.getEmailAddress(), senderUser.getFullName());
				subscriptionSender.setHtmlFormat(true);
				subscriptionSender.setMailId("user", clienteReceiver.getCodUsuario());
				subscriptionSender.addRuntimeSubscribers(clienteReceiver.getCorreo(), clienteReceiver.getNombre());
				subscriptionSender.flushNotificationsAsync();

			}
		}
		else {
			@SuppressWarnings("unchecked")
			List<EmpleadoTO> empleadosReceiver = (List<EmpleadoTO>) taskContextMap.get("receiversComplexList");
			EmpleadoTO empleadoReceiver = null;
			for (String employeeIndex : userReceivers) {
				String mailBody = (String) taskContextMap.get("mailBody");
				UsuarioTO userReceiver = null;
				String nombreDelCliente = "";
				String numeroDelCliente = "";
				String nombreDelEmpleado = "";
				String numeroDelEmpleado = "";
				String nombreDelCentro = "";
				String numeroDelCentro = "";
				String nombreDelUsuario = "";
				String importeDeFacturacion = "";
				String puntosDeFacturacion = "";
				String puntosDePromocion = "";
				String puntosConsumidosDeFacturacion = "";
				String puntosConsumidosDePromocion = "";
				String puntosDisponiblesDeFacturacion = "";
				String puntosDisponiblesDePromocion = "";
				
				empleadoReceiver = empleadosReceiver.get(Integer.parseInt(employeeIndex));
				userReceiver = usersAction.findByUserCode(empleadoReceiver.getCodigoUsuario());
//				userLiferay = UserLocalServiceUtil.getUserByScreenName(senderUser.getCompanyId(), userReceiver.getCodigo());
				nombreDelEmpleado = empleadoReceiver.getNombre();
				numeroDelEmpleado = empleadoReceiver.getNumero();
				nombreDelUsuario = userReceiver.getNombre();
				puntosDePromocion = empleadoReceiver.getPuntosPromocion();
				puntosConsumidosDePromocion = empleadoReceiver.getPuntosConsumidosPromocion();
				puntosDisponiblesDePromocion = empleadoReceiver.getPuntosDisponiblesPromocion();
				mailBody =
					StringUtil.replace(mailBody, new String[] {
						"[$NOMBRE_DEL_CLIENTE$]", "[$NUMERO_DEL_CLIENTE$]", "[$NOMBRE_DEL_EMPLEADO$]",
						"[$NUMERO_DEL_EMPLEADO$]", "[$NOMBRE_DEL_CENTRO$]", "[$NUMERO_DEL_CENTRO$]",
						"[$NOMBRE_DEL_USUARIO$]", "[$IMPORTE_DE_FACTURACION$]", "[$PUNTOS_DE_FACTURACION$]",
						"[$PUNTOS_DE_PROMOCION$]", "[$PUNTOS_CONS_FACTURACION$]",
						"[$PUNTOS_CONS_PROMOCION$]", "[$PUNTOS_DISP_FACTURACION$]",
						"[$PUNTOS_DISP_PROMOCION$]"
					}, new String[] {
						nombreDelCliente, numeroDelCliente, nombreDelEmpleado, numeroDelEmpleado, nombreDelCentro,
						numeroDelCentro, nombreDelUsuario, importeDeFacturacion, puntosDeFacturacion,
						puntosDePromocion, puntosConsumidosDeFacturacion, puntosConsumidosDePromocion,
						puntosDisponiblesDeFacturacion, puntosDisponiblesDePromocion
					});
				
		  		SubscriptionSender subscriptionSender = new SubscriptionSender();
				subscriptionSender.setSubject(mailSubject + " - " + mailCampaign);
				subscriptionSender.setBody(mailBody.toString());
				subscriptionSender.setUserId(userID.longValue());
				subscriptionSender.setCompanyId(senderUser.getCompanyId());
				subscriptionSender.setFrom(senderUser.getEmailAddress(), senderUser.getFullName());
				subscriptionSender.setHtmlFormat(true);
				subscriptionSender.setMailId("user", empleadoReceiver.getCodigoUsuario());
				subscriptionSender.addRuntimeSubscribers(empleadoReceiver.getCorreo(), empleadoReceiver.getNombre());
				subscriptionSender.flushNotificationsAsync();

			}

		}
		
		Message message = new Message();

		// Background task id needs to be passed

		message.put("backgroundTaskId", BackgroundTaskThreadLocal.getBackgroundTaskId());

		// Pass all the necessary attributes here

		// Send it over the built-in Message Bus to the background task status
		// destination

		MessageBusUtil.sendMessage(DestinationNames.BACKGROUND_TASK_STATUS, message);
		BackgroundTaskResult result = new BackgroundTaskResult(0, "mailing-finish");
		return result;
	}
	
	
}
