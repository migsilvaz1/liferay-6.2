<%@tag import="java.math.BigDecimal"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.AttachmentFile"%>
<%@tag import="java.util.Calendar"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.dao.InputDateDAO"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.InputD"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox"%>
<%@tag import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
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
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="vuv" tagdir="/WEB-INF/tags"%>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Form Field" %>
<%@ attribute name="element" required="true" rtexprvalue="true" type="javax.xml.bind.JAXBElement" %>
<%@ attribute name="formSubmit" required="true" rtexprvalue="true"	type="String"%>

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
		showEmptyOption="false" 
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
		if(inputText.getHeight() == 0){
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
		}else{
%>
 		<aui:input 
			type="textarea"
			rows="<%=inputText.getHeight() %>"
			columns="<%=inputText.getSize() %>"
			id="<%=inputText.getInputID() %>" 
			name="<%=inputText.getInputName() %>"
			label="<%=inputText.getLabeli18n(request.getLocale()) %>"
			value="<%=inputText.getValue() %>"
			title="<%=inputText.getTitlei18n(request.getLocale()) %>"
			required="<%=inputText.isFieldRequired() %>"
			disabled="<%=inputText.isReadOnly() %>"
			max="<%=inputText.getMaxLength() %>"
			size="<%=inputText.getSize() %>"
			resizable="false"
			inlineField="<%=inputText.isGroupWithPrevious() %>"
			inlineLabel="true"
			onChange="<%=onChangeScript %>"></aui:input> 

<% 
		}
	}else if(inputText.getType().equalsIgnoreCase(Integer.class.getName())){
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
			onChange="<%=onChangeScript %>">
			<aui:validator name="digits"></aui:validator>	
			<aui:validator name="max"><%=Integer.MAX_VALUE %></aui:validator>	
			<aui:validator name="min"><%=Integer.MIN_VALUE %></aui:validator>	
		</aui:input> 
<%
	}else if(inputText.getType().equalsIgnoreCase(Long.class.getName())){
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
			onChange="<%=onChangeScript %>">
			<aui:validator name="digits"></aui:validator>	
			<aui:validator name="max"><%=Long.MAX_VALUE %></aui:validator>	
			<aui:validator name="min"><%=Long.MIN_VALUE %></aui:validator>	
		</aui:input> 
<%		}else if(inputText.getType().equalsIgnoreCase(Double.class.getName())){
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
		onChange="<%=onChangeScript %>">
			<aui:validator name="number"></aui:validator>
			<aui:validator name="max"><%=Double.MAX_VALUE %></aui:validator>	
			<aui:validator name="min"><%=Double.MIN_VALUE %></aui:validator>	
		</aui:input> 
<%		}else if(inputText.getType().equalsIgnoreCase(BigDecimal.class.getName())){
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
		onChange="<%=onChangeScript %>">
			<aui:validator name="number"></aui:validator>
		</aui:input> 
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
			onChange="<%=onChangeScript %>"
			></aui:input> 
<%						
	}
}else if (element.getValue() instanceof InputD){
	InputDateDAO inputText = new InputDateDAO((InputD) element.getValue());
	String onChangeScript = "";
	if(inputText.getOnChangeScript()!=null){
		onChangeScript = StringEscapeUtils.escapeXml(inputText.getOnChangeScript().replaceAll("<portlet:namespace/>", renderResponse.getNamespace()));
	}
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(inputText.getValue());
    String cssClass = "control-group ";
    if(inputText.isGroupWithPrevious()){
    	cssClass += "control-group-inline";
    }
%>
	<div class="<%=cssClass%>" id="<%=inputText.getInputDateID()%>" onchange="<%=onChangeScript%>">
	<label for="<%=inputText.getInputDateName() %>" title="<%=inputText.getTitlei18n(request.getLocale())%>" ><%=inputText.getLabeli18n(request.getLocale()) %></label>
    <liferay-ui:input-date
        dayParam='<%=inputText.getInputDateName() + "Day" %>'
        dayValue="<%=calendar.get(Calendar.DAY_OF_MONTH) %>"
        disabled="<%=inputText.isReadOnly() %>"
        formName="<%= inputText.getInputDateName() %>"
        monthParam='<%= inputText.getInputDateName() + "Month" %>'
        monthValue="<%= calendar.get(Calendar.MONTH) %>"
        yearParam='<%= inputText.getInputDateName()  + "Year" %>'
        yearValue="<%= calendar.get(Calendar.YEAR)  %>"
		name="<%=inputText.getInputDateName() %>"
     />
	</div>
<%
}else if(element.getValue() instanceof SubForm){
	SubForm subForm = (SubForm) element.getValue();
	List<JAXBElement<?>> subFormElements =  subForm.getOutputTextOrInputTextOrInputDate();
	%>
 	<div id="<portlet:namespace/><%=subForm.getId()%>" title="<%=subForm.getProperty()%>" class="subFormContainer">
	<%
	for(JAXBElement<?> subFormElement: subFormElements){
		%>
		<vuv:form-field element="<%=subFormElement%>" formSubmit="<%=formSubmit %>" />
		<%
	}
	%>
	</div> 
	<% 	
}else if(element.getValue() instanceof MultipleSubForm){
	MultipleSubForm multipleSubForm = (MultipleSubForm) element.getValue();
	%>
	<vuv:multiple-sub-form tableData="<%=multipleSubForm%>"  formSubmit="<%=formSubmit %>"/>
<%
}else if(element.getValue() instanceof AttachmentFile){
	//TODO attachment file
}else{
%>	
	<div class="portlet-msg-info portlet-msg-info-error">
	CUIDADO: CAMPO NO TRATADO! Tipo: <%=element.getValue().getClass() %>
	</div>	<%
}
%>