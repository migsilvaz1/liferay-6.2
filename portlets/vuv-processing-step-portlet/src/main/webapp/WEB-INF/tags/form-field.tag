<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox"%>
<%@tag import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@tag import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@tag import="javax.xml.bind.JAXBElement"%>
<%@tag import="java.util.List"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SubForm"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.Input"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.dao.InputDAO"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.dao.LabelDAO"%>
<%@tag import="java.util.Map.Entry"%>
<%@tag import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.dao.SelectBoxDAO"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.dao.OutputTextDAO"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.InputLabel"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib prefix="vuv" tagdir="/WEB-INF/tags"%>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Form Field" %>
<%@ attribute name="element" required="true" rtexprvalue="true" type="javax.xml.bind.JAXBElement" %>
<portlet:defineObjects />
<%
if (element.getValue() instanceof InputLabel) {
	OutputTextDAO outputText = new OutputTextDAO((InputLabel) element.getValue());
%>				
	<div id="<portlet:namespace/><%=outputText.getOutputID()%>">
		<%=outputText.getLabeli18n().getLabeli18n(request.getLocale())%>
	</div> 
<%
}else if ( element.getValue() instanceof SelectBox || element.getValue() instanceof  SubForm.SelectBox) {
	
	SelectBoxDAO selectBox = null; 
	selectBox = (element.getValue() instanceof SelectBox) ? new SelectBoxDAO((SelectBox) element.getValue()) : new SelectBoxDAO((SubForm.SelectBox) element.getValue());
	
	String onChangeScript = "";
	if(selectBox.getOnChangeScript() != null){
		onChangeScript = StringEscapeUtils.escapeXml(selectBox.getOnChangeScript().replaceAll("<portlet:namespace/>", renderResponse.getNamespace()));				
	}
%>
 	<aui:select 
		id="<%=selectBox.getSelectID() %>"
		name="<%=selectBox.getSelectName()%>"
		title="<%=selectBox.getTitlei18n().getLabeli18n(request.getLocale())%>"
		label="<%=selectBox.getLabeli18n(request.getLocale())%>"
		onChange='<%=onChangeScript%>' 
		showEmptyOption="true" 
		required="<%=selectBox.isFieldRequired()%>" 
		inlineField="<%=selectBox.isGroupWithPrevious() %>"
		disabled="<%=selectBox.isReadOnly() %>">
<%
	for (Entry<String, LabelDAO> option : selectBox.getOptions().entrySet()) {
%>
		<aui:option value="<%=option.getKey()%>"
					label="<%=option.getValue().getLabeli18n(request.getLocale())%>"></aui:option>
<%
	}
%>
	</aui:select>
<%
}else if (element.getValue() instanceof Input){
	InputDAO inputText = new InputDAO((Input) element.getValue());
	String onChangeScript = "";
	if(inputText.getOnChangeScript()!=null){
		onChangeScript = StringEscapeUtils.escapeXml(inputText.getOnChangeScript().replaceAll("<portlet:namespace/>", renderResponse.getNamespace()));
	}
	if(inputText.getType().equalsIgnoreCase(String.class.getName())){
%>
 		<aui:input 
			type="text"
			id="<%=inputText.getInputID() %>" 
			name="<%=inputText.getInputName() %>"
			label="<%=inputText.getLabeli18n(request.getLocale()) %>"
			value="<%=inputText.getValue() %>"
			title="<%=inputText.getTitlei18n(request.getLocale()) %>"
			required="<%=inputText.isFieldRequired() %>"
			disabled="<%=inputText.isReadOnly() %>"
			max="<%=inputText.getMaxLength() %>"
			size="<%=inputText.getSize() %>"
			inlineField="<%=inputText.isGroupWithPrevious() %>"
			onChange="<%=onChangeScript %>"></aui:input> 
<%
	}else if(inputText.getType().equalsIgnoreCase(Boolean.class.getName())){
%>
 		<aui:input 
			type="checkbox"
			inlineField="<%=inputText.isGroupWithPrevious() %>"
			id="<%=inputText.getInputID() %>"
			name="<%=inputText.getInputName() %>"
			label="<%=inputText.getLabeli18n(request.getLocale()) %>"
			value="<%=inputText.getValue() %>"
			required="<%=inputText.isFieldRequired() %>"
			disabled="<%=inputText.isReadOnly() %>"
			title="<%=inputText.getTitlei18n(request.getLocale()) %>"
			onChange="<%=onChangeScript %>"></aui:input> 
<%						
	}else{%>
		<div class="portlet-msg-info portlet-msg-info-error">
		CUIDADO: CAMPO NO TRATADO! Tipo: <%=inputText.getType() %>
		</div>
	<%
	}
}else if(element.getValue() instanceof SubForm){
	SubForm subForm = (SubForm) element.getValue();
	List<JAXBElement<?>> subFormElements =  subForm.getOutputTextOrInputTextOrInputDate();
	%>
 	<div id="<portlet:namespace/><%=subForm.getId()%>" title="<%=subForm.getProperty()%>" class="subFormContainer">
	<%
	for(JAXBElement<?> subFormElement: subFormElements){
		%>
		<vuv:form-field element="<%=subFormElement%>"/>
		<%
	}
	%>
	</div> 
	<% 	
}else if(element.getValue() instanceof MultipleSubForm){
	MultipleSubForm multipleSubForm = (MultipleSubForm) element.getValue();
	%>
	<vuv:multiple-sub-form tableData="<%=multipleSubForm%>"/>
<%
}
%>