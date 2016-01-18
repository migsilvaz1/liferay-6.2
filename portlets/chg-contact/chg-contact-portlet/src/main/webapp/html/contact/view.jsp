<%@page import="java.text.SimpleDateFormat"%>
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
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> 
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="configURL">
	<portlet:param name="jspPage" value="/html/contact/area_list.jsp" />
</portlet:renderURL>

<liferay-ui:error key="general-error" message="Ha sucedido un error" />
<liferay-ui:error key="no-contact-loaded" message="No se han cargado las peticiones" />
<liferay-ui:error key="no-contact-fetched" message="No se ha encontrado la petici�n" />
<liferay-ui:error key="no-contact-deleted" message="No se ha borrado la petici�n" />
<liferay-ui:error key="no-such-user" message="No existe el usuario seleccionado" />
<liferay-ui:error key="contact-creation-error" message="Error al crear petici�n" />
<liferay-ui:error key="persistence-error" message="Error de persistencia" />

<%
	List<Contact> peticiones = (List<Contact>) renderRequest.getAttribute("contacts");
	if(Validator.isNotNull(peticiones)){
%>
<%
if (renderRequest.isUserInRole("administrator")) {
%>
<ul class="nav nav-tabs" style="display: block;">
	<li class="active">
		<a href="#">Peticiones</a>
	</li>
	<li>
		<a href="<%=configURL%>">Configuraci�n</a>
	</li>
</ul>
<%} %>
	<div class="offset1 span10">
	<h1>Solicitudes de Informaci�n</h1>
	<%if(peticiones.size()>0){ %>
	<table class="table">
	  <tr>
	    <th>Fecha de alta</th>
	    <th>Asunto</th>
	    <th>Email</th>
	    <th>Servicio</th>
	    <th>Estado</th>
	  </tr>
	  <%for(Contact peticion: peticiones){ %>
		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/contact/contact_detail.jsp" />
			<portlet:param name="contactId" value="<%= String.valueOf(peticion.getContactId()) %>"/>
		</portlet:renderURL>
	  <tr>
	    <td><%=new SimpleDateFormat("dd/MM/yyyy").format(peticion.getCreateDate()) %></td>
	    <td><a href="<%=editURL %>" ><%=peticion.getSubject() %></a></td>
	    <td><%=peticion.getEmail() %></td>
	    <td><%=AreaLocalServiceUtil.getArea(peticion.getAreaId()).getName() %></td>
	    <td><%=ContactPortletConstantUtil.statusTranslate(peticion.getStatus()) %></td>
	  </tr>
	  <%
	  	} 
	  }else{
		%>
			<div class="alert alert-info"><p>No se han encontrado resultados</p></div>
		<%
	  }
	  %>
	</table>
	</div>

<%
	} else {
%>
	<portlet:actionURL var="createContactUrl" name="createContact" />
	<div class="offset1 span10">
	<h1>Solicitar Informaci�n</h1>
	<aui:form action="<%=createContactUrl %>" method="post" name="fm">
		<aui:input type="text" name="name" label="Nombre">
			<aui:validator name="required" />
		</aui:input>
		<aui:input type="text" name="surname" label="Apellidos">
			<aui:validator name="required" />
		</aui:input>
		<aui:input type="text" name="activity" label="Actividad" />
		<aui:input type="textarea" name="address" label="Direcci�n" />
		<aui:input type="text" name="city" label="Poblaci�n" />
		<aui:input type="text" name="postalCode" label="C�digo Postal">
			<aui:validator name="digits" errorMessage="Deben ser d�gitos" />
			<aui:validator name="maxLength">5</aui:validator>
			<aui:validator name="minLength">5</aui:validator>
		</aui:input>
		<aui:input type="text" name="email" label="Email">
			<aui:validator name="required" />
			<aui:validator name="email" />
		</aui:input>
		<aui:input type="text" name="telephone" label="Tel�fono">
			<aui:validator name="digits" errorMessage="Deben ser d�gitos" />
		</aui:input>
		<aui:input type="text" name="subject" label="Asunto">
			<aui:validator name="required" />
		</aui:input>
		<aui:input type="textarea" name="description" label="Descripci�n">
			<aui:validator name="required" />
		</aui:input>
		<aui:button type="submit" name="submit" value="submit" />
	</aui:form>
	<p>De conformidad con lo establecido en la Ley Org�nica 15/1999, de 13 de diciembre, de 
	Protecci�n de Datos de Car�cter Personal, se le informa de que sus datos de car�cter personal 
	van a ser incorporados a un fichero automatizado del que es responsable la Confederaci�n Hidrogr�fica 
	del Guadalquivir con la finalidad de recopilar las preguntas m�s frecuentes realizadas a la Confederaci�n 
	Hidrogr�fica del Guadalquivir. Podr� ejercitar los derechos de acceso, rectificaci�n, cancelaci�n y 
	oposici�n dirigi�ndose por escrito a la Secretar�a General de la Confederaci�n Hidrogr�fica del 
	Guadalquivir, sita en Plaza de Espa�a, Sector II - 41071. SEVILLA</p>
	</div>
<%	}%>