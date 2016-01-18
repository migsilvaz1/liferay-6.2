<%--
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
--%>

<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@ include file="/html/taglib/ddm/html/init.jsp" %>

<div class="lfr-ddm-container" id="<%= randomNamespace %>">
	<c:if test="<%= Validator.isNotNull(xsd) %>">

		<%
		pageContext.setAttribute("checkRequired", checkRequired);
		
		if(requestedLocale.equals(LocaleUtil.SPAIN)){
		List<String> fieldsName = new LinkedList<String>();
		fieldsName.addAll(structure.getFieldNames());
		
		for(int i = 0; i<fieldsName.size()-1; i++){
		    String res = structure.getFieldProperty(fieldsName.get(i), "readOnly");
		    boolean read = Boolean.parseBoolean(res);
		    
		
		%>
		<%= DDMXSDUtil.getFieldHTMLByName(pageContext, classNameId, classPK, fieldsName.get(i), fields, portletResponse.getNamespace(), fieldsNamespace, mode, read, requestedLocale)  %>
		<%}}else{ %>
		<%= DDMXSDUtil.getHTML(pageContext, xsd, fields, portletResponse.getNamespace(), fieldsNamespace, mode, readOnly, requestedLocale) %>
		<%} %>
		<aui:input name="<%= fieldsDisplayInputName %>" type="hidden" />

		<aui:script use="liferay-ddm-repeatable-fields">
			new Liferay.DDM.RepeatableFields(
				{
					classNameId: <%= classNameId %>,
					classPK: <%= classPK %>,
					container: '#<%= randomNamespace %>',
					doAsGroupId: <%= scopeGroupId %>,
					fieldsDisplayInput: '#<portlet:namespace /><%= fieldsDisplayInputName %>',
					namespace: '<%= fieldsNamespace %>',
					p_l_id: <%= themeDisplay.getPlid() %>,
					portletNamespace: '<portlet:namespace />',
					repeatable: <%= repeatable %>
				}
			);
		</aui:script>
	</c:if>