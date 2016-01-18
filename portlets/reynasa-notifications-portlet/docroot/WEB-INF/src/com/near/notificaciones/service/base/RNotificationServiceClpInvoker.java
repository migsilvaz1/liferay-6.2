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

package com.near.notificaciones.service.base;

import com.near.notificaciones.service.RNotificationServiceUtil;

import java.util.Arrays;

/**
 * @author nearTechnologies
 * @generated
 */
public class RNotificationServiceClpInvoker {
	public RNotificationServiceClpInvoker() {
		_methodName14 = "getBeanIdentifier";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "setBeanIdentifier";

		_methodParameterTypes15 = new String[] { "java.lang.String" };

		_methodName18 = "addNewNotification";

		_methodParameterTypes18 = new String[] {
				"java.lang.String", "java.util.List", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.Integer"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return RNotificationServiceUtil.getBeanIdentifier();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			RNotificationServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return RNotificationServiceUtil.addNewNotification((java.lang.String)arguments[0],
				(java.util.List<java.lang.String>)arguments[1],
				(java.util.Date)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.Integer)arguments[5]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName18;
	private String[] _methodParameterTypes18;
}