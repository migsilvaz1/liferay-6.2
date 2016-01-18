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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RNotificationService}.
 *
 * @author nearTechnologies
 * @see RNotificationService
 * @generated
 */
public class RNotificationServiceWrapper implements RNotificationService,
	ServiceWrapper<RNotificationService> {
	public RNotificationServiceWrapper(
		RNotificationService rNotificationService) {
		_rNotificationService = rNotificationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rNotificationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rNotificationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rNotificationService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String[] addNewNotification(
		java.lang.String codigoRemitente,
		java.util.List<java.lang.String> codigoDestinatarioList,
		java.util.Date fechaPrevista, java.lang.String titulo,
		java.lang.String contenido, java.lang.Integer motivo) {
		return _rNotificationService.addNewNotification(codigoRemitente,
			codigoDestinatarioList, fechaPrevista, titulo, contenido, motivo);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RNotificationService getWrappedRNotificationService() {
		return _rNotificationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRNotificationService(
		RNotificationService rNotificationService) {
		_rNotificationService = rNotificationService;
	}

	@Override
	public RNotificationService getWrappedService() {
		return _rNotificationService;
	}

	@Override
	public void setWrappedService(RNotificationService rNotificationService) {
		_rNotificationService = rNotificationService;
	}

	private RNotificationService _rNotificationService;
}