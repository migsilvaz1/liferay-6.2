<%@tag import="ec.gob.snap.vuv.dynamic.form.dao.InputDAO"%>
<%@tag
	import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.Acciones"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.Input"%>
<%@tag import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Form Action Section"%>
<%@ attribute name="actions" required="true" rtexprvalue="true"
	type="java.util.List"%>
<portlet:defineObjects />
<div class="alert alert-buttons">
	<%
		for (Object action : actions) {
			Acciones action_ = (Acciones) action;
			List<Input> buttons = action_.getButton();

			for (Input button : buttons) {
				InputDAO buttonDAO = new InputDAO(button);
	%>
	<aui:button id="<%=buttonDAO.getInputID()%>"
		class="formSubmit"
		name="<%=buttonDAO.getInputName()%>"
		disabled="<%=buttonDAO.isReadOnly()%>" type="submit"
		value="<%=buttonDAO.getLabeli18n(request.getLocale())%>">

		<aui:input 
			name="<%=buttonDAO.getInputName()%>"
			type="hidden"
			value="<%=buttonDAO.getAction()%>">
		</aui:input>
	</aui:button>
	<%
		}
		}
	%>
	<div class="clearfix"></div>
</div>