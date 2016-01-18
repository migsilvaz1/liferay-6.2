<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.LinkedList"%>
<%@page	import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalService"%>
<%@ page import="com.liferay.portal.model.UserGroup"%>
<%@ page import="com.liferay.portal.service.UserGroupLocalServiceUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	PortletPreferences preferences = liferayPortletRequest.getPreferences();

	String portletResource =
		ParamUtil.getString(request, "portletResource");

	if (Validator.isNotNull(portletResource)) {
		preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				request, portletResource);
	}
	
	String htmlCodeFromEditorPlacedHere = GetterUtil.getString(preferences.getValue("htmlCodeFromEditorPlacedHere", ""));
	String pageElements = GetterUtil.getString(preferences.getValue("pageElements", ""));
	String viewContentTable = GetterUtil.getString(preferences.getValue("viewContentTable", ""));
	%>