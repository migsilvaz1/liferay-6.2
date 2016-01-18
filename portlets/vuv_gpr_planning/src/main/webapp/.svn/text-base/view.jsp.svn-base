<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<div><liferay-ui:message key="sincro.institutions" />: ${numInstitutions }</div>
<div><liferay-ui:message key="sincro.services" />: ${numServices }</div>
<portlet:actionURL name="sincronize" var="sincronizeUrl"></portlet:actionURL>
<div><liferay-ui:message key="sincro.buttom.phrase" />:</div>
<a href="${sincronizeUrl}"><button onclick="return window.confirm('El proceso se ejecutará en segundo plano. ¿Desea proceder?')">
	<liferay-ui:message key="sincro.button.label" />
</button></a>