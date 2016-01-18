<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@include file="/html/init.jsp" %>
<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
<label><%=LanguageUtil.get(locale, "config.descripcion") %></label>
<liferay-ui:input-editor/>
<input name="<portlet:namespace />htmlCodeFromEditorPlacedHere" type="hidden" value="" />
<br>
<label><%=LanguageUtil.get(locale, "config.pageElements") %></label>
<input name="<portlet:namespace />pageElements" value="<%=pageElements != ""?pageElements:"10"%>"/>
<br>
<br>
<label><%=LanguageUtil.get(locale, "config.viewContentTable") %></label>
<select name="<portlet:namespace />viewContentTable">
<%if(viewContentTable.equals("false")){ %>
<option value="true"><%=LanguageUtil.get(locale, "config.yes") %></option>
<option value="false" selected="selected"><%=LanguageUtil.get(locale, "config.no") %></option>
<%}else{ %>
<option value="true" selected="selected"><%=LanguageUtil.get(locale, "config.yes") %></option>
<option value="false"><%=LanguageUtil.get(locale, "config.no") %></option>
<%} %>
</select>
<br>
<br>
<input class="btn btn-primary" type="submit" value='<liferay-ui:message key="save" />' onClick="extractCodeFromEditor()" />
</form>

<script type="text/javascript">
            function <portlet:namespace />initEditor() {
            	var res = '<%= htmlCodeFromEditorPlacedHere != ""?htmlCodeFromEditorPlacedHere.replace("\n", "\\n"):LanguageUtil.get(locale, "init.htmlCodeFromEditorPlacedHere") %>';
                        return res; }
          
            function extractCodeFromEditor() {
                        var x = document.<portlet:namespace />fm.<portlet:namespace />htmlCodeFromEditorPlacedHere.value = window.<portlet:namespace />editor.getHTML();
       
            }
</script>