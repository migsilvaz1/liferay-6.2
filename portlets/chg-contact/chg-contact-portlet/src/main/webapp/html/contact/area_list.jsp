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

<portlet:actionURL var="normalURL" name="backToList" />
<portlet:renderURL var="createAreaUrl">
	<portlet:param name="jspPage" value="/html/contact/area_detail.jsp" />
	<portlet:param name="areaId" value="0" />
</portlet:renderURL>

<ul class="nav nav-tabs" style="display: block;">
	<li>
		<a href="<%=normalURL%>">Peticiones</a>
	</li>
	<li class="active">
		<a href="#">Configuración</a>
	</li>
</ul>

<%
List<Area> areas = AreaLocalServiceUtil.getAreas(0, AreaLocalServiceUtil.getAreasCount());
%>

<div class="offset1 span10">
	
	<h3>Departamentos</h3>
	<table class="table">
	  <tr>
	    <th>Nombre</th>
	    <th>Email Principal</th>
	    <th>Responsable</th>
	    <th>Editar</th>
	  </tr>
<%
		for(Area area: areas){
			User responsable = UserLocalServiceUtil.getUser(10199);
			if(area.getUserId() != 0){
				responsable = UserLocalServiceUtil.getUser(area.getUserId());
			}
%>
	<portlet:renderURL var="updateAreaUrl">
		<portlet:param name="jspPage" value="/html/contact/area_detail.jsp" />
		<portlet:param name="areaId" value="<%=String.valueOf(area.getAreaId()) %>" />
	</portlet:renderURL>
	
	<tr>
		<td><%=area.getName() %></td>
		<td><%=area.getMainEmail() %></td>
		<td><%=responsable.getScreenName() %></td>
		<td><a href="<%=updateAreaUrl %>"><button type="button" class="btn btn-primary">Editar</button></a></td>
	</tr>
<%
		}
%>
	</table>
	<div class="pull-right">
		<a href="<%=createAreaUrl%>"><button type="button" class="btn btn-primary">Nuevo</button></a>
	</div>
</div>

