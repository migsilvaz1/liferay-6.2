<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	String numPerPage = GetterUtil.getString(renderRequest.getAttribute("numPerPage"), "1");
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<label for="number"><liferay-ui:message key="services.set.pages" /></label>
	<aui:input name="numPerPage" class="form-control" value="<%=numPerPage %>" >
		<aui:validator name="number"></aui:validator>
		<aui:validator name="min">1</aui:validator>
		<aui:validator name="digits"></aui:validator>
	</aui:input>
	<input type="submit" class="btn btn-primary" value='<liferay-ui:message key="save" />' onClick="return checkVal();" />
</aui:form>