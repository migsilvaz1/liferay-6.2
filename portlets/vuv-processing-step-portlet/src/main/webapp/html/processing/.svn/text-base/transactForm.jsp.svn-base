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
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
<portlet:defineObjects />
<portlet:actionURL var="transactionFormURL" name="transactionForm">

</portlet:actionURL>
<aui:form action="<%=transactionFormURL%>" method="post"
	name="transactionForm">
	<aui:button type="submit" value="vuv.tasklist.refresh"
		cssClass="glyphicon glyphicon-refresh">
	</aui:button>
</aui:form>

<aui:form cssClass="formAction">
 	<c:set var="actions" value="${requestScope.actionsForm}" />
	<c:set var="elements" value="${requestScope.elementsForm}" /> 
	<div class="formBody span12"> 		
 		<c:forEach var="element" items="${elements}">
			<vuv:form-field element="${element}" />
		</c:forEach>  

	</div>
	<div class="clearfix"></div>
	<c:if test="${not empty actions}">
		<vuv:form-actions-section actions="${actions}" />
	</c:if>
</aui:form>
