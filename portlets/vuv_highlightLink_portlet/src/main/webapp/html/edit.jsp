<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="ec.gob.snap.vuv.HighlightLinkPortletUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />
<%
	String intro = String.valueOf(renderRequest.getAttribute("intro"));
%>
<portlet:actionURL name='savePreferences' var="action" windowState="normal" />
<form action="<%= action %>" method="post" name="fm">
		<label><liferay-ui:message key="intro-text" /></label>
		<liferay-ui:input-editor />
		
		<input id="htmlCodeFromEditorPlacedHere" name="<portlet:namespace /><%=HighlightLinkPortletUtil.PREF_INTRO %>" type="hidden" value="" />
		
		<aui:input label="firts-search-results" name="<%=HighlightLinkPortletUtil.PREF_FIRST_NUM_PAG %>" value="${firstnumpag }">
			<aui:validator name="number"></aui:validator>
			<aui:validator name="min">0</aui:validator>
		</aui:input>

		<input class="btn btn-primary" type="submit" value='<liferay-ui:message key="save" />' onClick="extractCodeFromEditor()" />
</form>

<script type="text/javascript">
	function <portlet:namespace />initEditor() {
		return '<%=intro.replace("\n", "\\n") %>';
	}

	function extractCodeFromEditor() {
		document.getElementById("htmlCodeFromEditorPlacedHere").value = window.<portlet:namespace />editor.getHTML();
	}
</script>