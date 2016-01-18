<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.entities.InputLabel"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SubForm"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page import="javax.lang.model.util.Elements"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.dao.LabelDAO"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.dao.SelectBoxDAO"%>
<%@page	import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox.Options.Option"%>
<%@page	import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox.Options"%>
<%@page	import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.dao.OutputTextDAO"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.dao.InputDAO"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.entities.Properties.Label"%>
<%@page import="javax.xml.bind.JAXBElement"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.entities.Properties"%>
<%@page import="ec.gob.snap.vuv.dynamic.form.entities.Input"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page	import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.Acciones"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib prefix="vuv" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<theme:defineObjects />
<portlet:defineObjects />

<style>
	.formAction label{
		text-transform: none;
	}
	.formAction input:not([type]), input[type="text"]{
	    width: auto;
    	min-width: 0;
	}
</style>

<!-- Mensaje de error por submit fallido -->
<%
	String taskListErrorProcess = PortalUtil.getOriginalServletRequest(request).getParameter("taskListErrorProcess");
	if(taskListErrorProcess != null && !taskListErrorProcess.isEmpty()){
%>
		<div class="alert alert-error">
			<%=LanguageUtil.get(locale, "vuv.tasklist.msg.error")%>
		</div>
<%
	}
%>

<%String redirect = ParamUtil.getString(request, "redirect"); %>
<h3><a href="<%=redirect%>"><i class="fa fa-chevron-circle-left"></i></a> Volver</h3>
<br>
<portlet:actionURL var="processFormURL" name="processForm">
	<portlet:param name="urlError" value="<%=themeDisplay.getURLCurrent()%>"/>
	<portlet:param name="urlExito" value="<%=redirect%>"/>
</portlet:actionURL>

<liferay-ui:error key="tasklist-endprocess-error" message="Ha habido un error prueba" />
<liferay-ui:error key="bpmn-error" message="vuv.tasklist.portlet.error.bpmn" />

<aui:form cssClass="formAction" action="<%=processFormURL%>" name="formService">
 	<c:set var="actions" value="${requestScope.actionsForm}" />
	<c:set var="elements" value="${requestScope.elementsForm}" /> 
	<div class="formBody span12" style="margin-left: 0px !important;"> 		
 		<c:forEach var="element" items="${elements}">
			<vuv:form-field element="${element}" formSubmit="formService" />
		</c:forEach>
	</div>
	<div class="clearfix"></div>
	<c:if test="${not empty actions}">
			<vuv:form-actions-section actions="${actions}"/>
	</c:if>
</aui:form>