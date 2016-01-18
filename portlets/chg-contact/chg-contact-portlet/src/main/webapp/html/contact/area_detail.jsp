<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.gfi.chg.model.Area"%>
<%@page import="com.gfi.chg.contact.ContactPortletConstantUtil"%>
<%@page import="com.gfi.chg.service.AreaLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.PortletPreferences"%>
<%@page import="com.gfi.chg.service.ContactLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.gfi.chg.model.Contact"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
long areaId = ParamUtil.getLong(request, "areaId");
Area area = null;
String userName = "";
if(areaId == 0){
	area = AreaLocalServiceUtil.createArea(0);
}else{
	area = AreaLocalServiceUtil.getArea(areaId);
	if(area.getAreaId() != 0){
		userName = "test";
	}else{
		User responsable = UserLocalServiceUtil.getUser(area.getUserId());
		userName = responsable.getScreenName();
	}
}
List<String> names = new ArrayList<String>();
for(User person: UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount())){
	names.add(person.getScreenName());
}
%>

<portlet:actionURL var="normalURL" name="backToList" />
<ul class="nav nav-tabs" style="display: block;">
	<li>
		<a href="<%=normalURL%>">Peticiones</a>
	</li>
	<li class="active">
		<a href="#">Configuración</a>
	</li>
</ul>
<div class="offset1 span10">
<portlet:actionURL var="saveAreaUrl" name="saveArea" />
<aui:form action="<%=saveAreaUrl %>" method="post" name="fm">
	<div>
	<aui:input type="hidden" name="areaId" value="<%=String.valueOf(area.getAreaId()) %>" />
	<aui:input type="text" name="name" value="<%=area.getName() %>">
		<aui:validator name="required" />
		<aui:validator name="maxLength">75</aui:validator>
	</aui:input>
	<aui:input type="text" name="email" value="<%=area.getMainEmail() %>">
		<aui:validator name="required" />
		<aui:validator name="maxLength">75</aui:validator>
	</aui:input>
	<label for="myInputNode">Responsable</label>
	<input type="text" id="myInputNode" name="<portlet:namespace/>responsable" value="<%=userName %>" />
	</div>
	<div>
		<aui:button type="submit" class="btn btn-default" name="submit" value="submit" />
	</div>
</aui:form>
</div>


<aui:script>
    AUI().use(
        'autocomplete-list','autocomplete-filters',
        function (A) {
            var options = [<% for (int i = 0; i < names.size(); i++) { %>"<%= names.get(i) %>"<%= i + 1 < names.size() ? ",":"" %><% } %>];
            
            new A.AutoCompleteList(
            {
                allowBrowserAutocomplete: 'true',
                activateFirstItem: 'true',
                inputNode: '#myInputNode',
                render: 'true',
                source: options,
                resultFilters:['phraseMatch']
            })
        }
    );
</aui:script>