<%@page import="com.gfi.chg.model.Area"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.gfi.chg.contact.ContactPortletConstantUtil"%>
<%@page import="com.gfi.chg.service.AreaLocalServiceUtil"%>
<%@page import="com.gfi.chg.service.TracingLocalServiceUtil"%>
<%@page import="com.gfi.chg.model.Tracing"%>
<%@page import="java.util.List"%>
<%@page import="com.gfi.chg.model.Contact"%>
<%@page import="com.gfi.chg.service.ContactLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="configURL">
	<portlet:param name="jspPage" value="/html/contact/area_list.jsp" />
</portlet:renderURL>
<%
	Contact peticion = null;
	long contactId = ParamUtil.getLong(request, "contactId");
	if(contactId > 0){
		peticion = ContactLocalServiceUtil.getContact(contactId);
	}
	if(peticion != null){
		List<Tracing> historico = TracingLocalServiceUtil.findByContactId(contactId);
%>

<%
if (renderRequest.isUserInRole("administrator")) {
%>
<ul class="nav nav-tabs" style="display: block;">
	<li class="active">
		<a href="#">Peticiones</a>
	</li>
	<li>
		<a href="<%=configURL%>">Configuración</a>
	</li>
</ul>
<%} %>


<portlet:actionURL var="backToListUrl" name="backToList" />
<portlet:actionURL var="answerContactUrl" name="answerContact" />
<portlet:actionURL var="resendContactUrl" name="resendContact" />
<portlet:actionURL var="endContactUrl" name="endContact" >
	<portlet:param name="contactId" value="<%= String.valueOf(peticion.getContactId()) %>"/>
</portlet:actionURL>
<portlet:actionURL var="deleteContactUrl" name="deleteContact" >
	<portlet:param name="contactId" value="<%= String.valueOf(peticion.getContactId()) %>"/>
</portlet:actionURL>

	<div class="row">
		<div class="offset1 span10">
			<h1>Solicitud número <%=peticion.getContactId() %></h1>
			<div id="info-contacto">
				<h2>Información del Solicitante</h2>
				<table class="table table-condensed">
					<tr>
						<td><strong>Nombre</strong></td>
						<td><%=peticion.getName() %></td>
						<td><strong>Apellidos</strong></td>
						<td><%=peticion.getSurname() %></td>
						<td><strong>Actividad</strong></td>
						<td><%=peticion.getActivity() %></td>
					</tr>
					<tr>
						<td><strong>Dirección</strong></td>
						<td colspan="5"><%=peticion.getAddress() %></td>
					</tr>
					<tr>
						<td><strong>Población</strong></td>
						<td colspan="3"><%=peticion.getCity() %></td>
						<td><strong>Código Postal</strong></td>
						<td><%=peticion.getPostalCode() %></td>
					</tr>
					<tr>
						<td><strong>Email</strong></td>
						<td colspan="3"><%=peticion.getEmail() %></td>
						<td><strong>Teléfono</strong></td>
						<td><%=peticion.getTelephone() %></td>
					</tr>
				</table>
			</div>
			<div id="info-peticion">
				<h2>Solicitud</h2>
				<table class="table table-condensed">
					<tr>
						<td><strong><%=new SimpleDateFormat("dd/MM/yyyy").format(peticion.getCreateDate()) %></strong></td>
						<td><strong><%=ContactPortletConstantUtil.statusTranslate(peticion.getStatus()) %></strong></td>
					</tr>
					<tr>
						<td><strong>Asunto</strong></td>
						<td><%=peticion.getSubject() %></td>
					</tr>
					<tr>
						<td><strong>Descripción</strong></td>
						<td><%=peticion.getDescription() %></td>
					</tr>
				</table>
			</div>
			<%if(peticion.getStatus() == ContactPortletConstantUtil.FINISHED){ %>
			<div id="response">
				<h2>Respuesta</h2>
				<div class="alert alert-info"><p><%=(peticion.getResponse().isEmpty()) ? "Sin respuesta" : peticion.getResponse() %></p></div>
			</div>
			<%} %>
			<div id="history">
				<h2>Historial</h2>
				<table class="table">
					<tr>
						<th>Fecha</th>
						<th>Servicio</th>
						<th>Comentario</th>
						<th>Estado</th>
					</tr>
					<%for(Tracing entrada: historico){ %>
					<tr>
						<td><%=new SimpleDateFormat("dd/MM/yyyy").format(entrada.getModifiedDate()) %></td>
						<td><%=AreaLocalServiceUtil.getArea(entrada.getAreaId()).getName() %></td>
						<td><%=entrada.getComment() %></td>
						<td><%=ContactPortletConstantUtil.statusTranslate(entrada.getStatus()) %></td>
					</tr>
					<%} %>
				</table>
			</div>
			<div id="actions">
				<a href="<%=backToListUrl %>"><button class="btn">Volver</button></a>
				<%if(peticion.getStatus() != ContactPortletConstantUtil.FINISHED){ %>
				<button class="btn btn-primary" data-toggle="modal" data-target="#responder">Responder</button>
				<button class="btn btn-primary" data-toggle="modal" data-target="#reenviar">Reenviar</button>
				<a href="<%=endContactUrl %>"><button class="btn btn-success">Finalizar</button></a>
				<a href="<%=deleteContactUrl %>"><button class="btn btn-danger" onclick="return window.confirm('¿Seguro que desea eliminar?');">Eliminar</button></a>
				<%}%>
			</div>
		</div>
	</div>

	<!-- Responder -->
	<div class="modal fade" id="responder" tabindex="-1" role="dialog" aria-labelledby="responderLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="responderLabel">Responder</h4>
				</div>
				<div class="modal-body">
					<aui:form action="<%=answerContactUrl %>" method="post" name="fm">
						<aui:input type="hidden" name="contactId" value="<%=String.valueOf(peticion.getContactId()) %>" />
						<span class="help-block">Escriba su respuesta para enviar al usuario.</span>
						<aui:input type="textarea" name="response" label="Respuesta" style="width: 500px; height: 200px;">
							<aui:validator name="required" />
							<aui:validator name="maxLength">500</aui:validator>
						</aui:input>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<aui:button type="submit" class="btn btn-default" name="submit" value="submit" />
				</aui:form>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Reenviar -->
	<div class="modal fade" id="reenviar" tabindex="-1" role="dialog" aria-labelledby="reenviarlLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="reenviarlLabel">Reenviar</h4>
				</div>
				<div class="modal-body">
					<aui:form action="<%=resendContactUrl %>" method="post" name="fm">
						<aui:input type="hidden" name="contactId" value="<%=String.valueOf(peticion.getContactId()) %>" />
						<span class="help-block">Seleccione un servicio de destino.</span>
						<aui:select label="Servicios" name="areaId">
						<%
						for(Area area: AreaLocalServiceUtil.getAreas(0, AreaLocalServiceUtil.getAreasCount())){
							if(!area.getName().equals(ContactPortletConstantUtil.DEFAULT_AREA_NAME)){
						%>
							<aui:option selected="<%=area.equals(AreaLocalServiceUtil.getArea(peticion.getAreaId())) %>" value="<%=area.getAreaId() %>"><%=area.getName() %></aui:option>
						<%
							} 
						}
						%>
						</aui:select>
						<span class="help-block">Escriba su comentario (opcional).</span>
						<aui:input type="textarea" name="comment" label="Comentario" style="width: 500px; height: 100px;">
							<aui:validator name="maxLength">250</aui:validator>
						</aui:input>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<aui:button type="submit" class="btn btn-default" name="submit" value="submit" />
				</aui:form>
				</div>
			</div>
		</div>
	</div>
<%
	}else{
		
	}
%>