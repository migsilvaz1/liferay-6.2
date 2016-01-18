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

package com.near.notificaciones.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for RNotification. This utility wraps
 * {@link com.near.notificaciones.service.impl.RNotificationServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author nearTechnologies
 * @see RNotificationService
 * @see com.near.notificaciones.service.base.RNotificationServiceBaseImpl
 * @see com.near.notificaciones.service.impl.RNotificationServiceImpl
 * @generated
 */
public class RNotificationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.near.notificaciones.service.impl.RNotificationServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.lang.String[] addNewNotification(
		java.lang.String codigoRemitente,
		java.util.List<java.lang.String> codigoDestinatarioList,
		java.util.Date fechaPrevista, java.lang.String titulo,
		java.lang.String contenido, java.lang.Integer motivo) {
		return getService()
				   .addNewNotification(codigoRemitente, codigoDestinatarioList,
			fechaPrevista, titulo, contenido, motivo);
	}

	public static void clearService() {
		_service = null;
	}

	public static RNotificationService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RNotificationService.class.getName());

			if (invokableService instanceof RNotificationService) {
				_service = (RNotificationService)invokableService;
			}
			else {
				_service = new RNotificationServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(RNotificationServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RNotificationService service) {
	}

	private static RNotificationService _service;
}