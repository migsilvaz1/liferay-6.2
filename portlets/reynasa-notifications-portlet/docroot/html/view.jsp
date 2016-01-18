<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.notifications.NotificationEvent"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.near.notificaciones.util.RolesRetriever"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="init.jsp" %>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.service.UserNotificationEventLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserNotificationEvent"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%String currentURLObj = (String) request.getAttribute("javax.servlet.forward.request_uri");%>
<%String currentURL = themeDisplay.getURLCurrent(); %>
<script>
	function confirmarEliminar(){
		return confirm("<%=LanguageUtil.get(locale, "notificaciones.msg.confirm.eliminarNotificacion")%>");
	}
	function cargarFecha(){
		if(document.getElementById("fechaFiltroInput").value.trim() == ""){
			var fechaHoy = new Date();
			var dia = fechaHoy.getDate();
			var mes = fechaHoy.getMonth()+1;
			var anyo = fechaHoy.getFullYear();
			if(dia < 10) {
			    dia = '0' + dia;
			} 
			if(mes < 10) {
			    mes = '0' + mes;
			} 
			fechaHoy = dia + '/' + mes + '/' + anyo;
			document.getElementById("fechaFiltroInput").value = fechaHoy;
		}
	}
</script>

<%
	SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
	SimpleDateFormat diaFormat = new SimpleDateFormat("dd/MM/yyyy");
	List<UserNotificationEvent> userNotificationEventList = UserNotificationEventLocalServiceUtil.getUserNotificationEvents(user.getUserId());
	int contadorNotificSinLeer = 0;
	for(UserNotificationEvent userNotificationEvent : userNotificationEventList){
		if(userNotificationEvent.getArchived() == false){
			contadorNotificSinLeer++;
		}	
	}	
	String notificacionesMenuHeader = LanguageUtil.get(locale, "notificaciones.menu.notificaciones")+ " (" + userNotificationEventList.size() + ")";
	String notificacionesLeidas = LanguageUtil.get(locale, "notificaciones.menu.leidas")+ " (" + contadorNotificSinLeer + ")";
%>
<portlet:renderURL var="nuevaNotificacionURL">
	<portlet:param name="mvcPath" value="/html/edit.jsp" />
	<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent().toString()%>" />
</portlet:renderURL>

<portlet:renderURL var="leidasURL">
	<portlet:param name="leidas" value="true" />
</portlet:renderURL>

<portlet:renderURL var="notificaciones">
</portlet:renderURL>
<%
	String busqueda = (String)request.getAttribute("idBusqueda");
	String busquedaFecha = (String)request.getAttribute("fechaFiltroInput");
	if(busqueda == null){
		busqueda = "";
	}
	if(busquedaFecha == null){
		busquedaFecha = "";
	}
%>

<form action='<portlet:actionURL name="busqueda"/>' method="POST">
	<table style="width: 100%;">
		<tr>
			<td style="width: 25%;">
			    <div class="input-prepend" style="width: 90%;">
			    	<span class="add-on"><i class="icon-search"></i></span>
					<input type="text" name="<portlet:namespace/>idBusqueda" class="span2" value="<%=busqueda %>" placeholder="<%=LanguageUtil.get(locale, "notificaciones.menu.busquedaCoincidencias")%>" style="width: 100%;"/>
			    </div>
			</td>
			<td style="width: 5%;">
			</td>
			<td style="width: 25%;">
				<script type="text/javascript">
					YUI({ lang: 'es' }).use('aui-datepicker',function(Y) {
					    var datepicker = new Y.DatePicker(
					      {
					        trigger: '#fechaFiltroInput',
					        mask: '%d/%m/%Y',
					        popover: {
					          zIndex: 1
					        }
					      }
					    );
					  }
					);
				</script>
				<div class="input-prepend" style="width: 90%;">
					<span class="add-on"><i class="icon-calendar"></i></span>
					<input type="text" id="fechaFiltroInput" name="<portlet:namespace/>fechaFiltroInput" class="span2" placeholder="<%=LanguageUtil.get(locale, "notificaciones.menu.busquedaFecha")%>" value="<%=busquedaFecha %>" style="width: 100%;" onfocus="cargarFecha()">
			    </div>
			</td>
			<td style="width: 5%;">
			</td>
			<td style="width: 40%;" valign="top" align="right">
				<button type="submit" class="btn btn-large btn-primary green botonSearchNotificacion"><%=LanguageUtil.get(locale, "notificaciones.listado.buscar")%></button>
			</td>
		</tr>
	</table>
</form>
<%
	Map data = new HashMap();
	data.put("leidas", true);
%>
<table style="width: 100%;">	
	<tr>
		<td valign="top" style="width: 25%;">
			<div class="controls-list menuLateralListNotificaciones">
				<aui:nav cssClass="nav-list">
					<%
					//Se comprueban los roles para mostrar o no la opción de Iniciar hilo
					long roleClienteId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente")).getRoleId();
					long roleCentroId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro")).getRoleId();
					long roleAdminFuncionalId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorFuncional")).getRoleId();
					long roleAdminDistrId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidor")).getRoleId();
					//Sólo se muestra la opción de iniciar hilo si el usuario puede enviar notificaciones
					if(UserLocalServiceUtil.hasRoleUser(roleClienteId, user.getUserId()) || UserLocalServiceUtil.hasRoleUser(roleCentroId, user.getUserId()) || UserLocalServiceUtil.hasRoleUser(roleAdminFuncionalId, user.getUserId())|| UserLocalServiceUtil.hasRoleUser(roleAdminDistrId, user.getUserId())){
					%>
						<aui:nav-item label="notificaciones.menu.iniciarHilo" href="<%= nuevaNotificacionURL%>"/>
						<aui:nav-item cssClass="divider"/>
					<%
					}
					%>
					<aui:nav-item label="<%=notificacionesMenuHeader%>" href="<%=notificaciones%>"/>
					<aui:nav-item label="<%=notificacionesLeidas %>" href="<%= leidasURL %>"/>
				</aui:nav>
			</div>
		</td>
		<td style="width: 5%;"></td>
		<td valign="top" style="width: 70%;">
		<%
		if(request.getParameter("leidas") != null && request.getParameter("leidas").equals("true")) {
			List<UserNotificationEvent> aux = new ArrayList<UserNotificationEvent>();
			for(UserNotificationEvent notificacion : userNotificationEventList){
				if(notificacion.getArchived() == false){
					aux.add(notificacion);
				}
			}
			userNotificationEventList = aux;
		}		
		if((busqueda != null && busqueda != "") && (busquedaFecha != null && busquedaFecha != "")){
			busqueda = busqueda.toLowerCase();
			List<UserNotificationEvent> aux = new ArrayList<UserNotificationEvent>();
			for(UserNotificationEvent e : userNotificationEventList){
				JSONObject jsObject = JSONFactoryUtil.createJSONObject(e.getPayload());
				String titulo = jsObject.getString("titulo").toLowerCase();
				String contenido = jsObject.getString("contenido").toLowerCase();
				String remitenteNombre = jsObject.getString("remitenteNombre").toLowerCase();
				long time = e.getTimestamp();
				Date date = new Date(time);
				String fechaPrevista = diaFormat.format(date);
				if((titulo.contains(busqueda) || contenido.contains(busqueda) || remitenteNombre.contains(busqueda)) && fechaPrevista.equals(busquedaFecha)){
					aux.add(e);
				}
			}
			userNotificationEventList = aux;
		}else if(busqueda != null && busqueda != ""){
			busqueda = busqueda.toLowerCase();
			List<UserNotificationEvent> aux = new ArrayList<UserNotificationEvent>();
			for(UserNotificationEvent e : userNotificationEventList){
				JSONObject jsObject = JSONFactoryUtil.createJSONObject(e.getPayload());
				String titulo = jsObject.getString("titulo").toLowerCase();
				String contenido = jsObject.getString("contenido").toLowerCase();
				String remitenteNombre = jsObject.getString("remitenteNombre").toLowerCase();
				if(titulo.contains(busqueda) || contenido.contains(busqueda) || remitenteNombre.contains(busqueda)){
					aux.add(e);
				}
			}
			userNotificationEventList = aux;
		}else if(busquedaFecha != null && busquedaFecha != ""){
			List<UserNotificationEvent> aux = new ArrayList<UserNotificationEvent>();
			for(UserNotificationEvent e : userNotificationEventList){
				long time = e.getTimestamp();
				Date date = new Date(time);
				String fechaPrevista = diaFormat.format(date);
				if(fechaPrevista.equals(busquedaFecha)){
					aux.add(e);
				}
			}
			userNotificationEventList = aux;
		}
		if(userNotificationEventList != null && !userNotificationEventList.isEmpty()) {
		%>
			<script type="text/javascript">
				YUI().use(
				  'aui-pagination',
				  function(Y) {
				    var pages = Y.all('.listadoNotificaciones .paginaNotificaciones');
			
				    new Y.Pagination(
				      {
				        boundingBox: '#pagination',
				        circular: false,
				        contentBox: '#pagination .pagination-content',
				        on: {
				          changeRequest: function(event) {
				            var instance = this,
				                state = event.state,
				                lastState = event.lastState;
			
				            if (lastState) {
				                pages.item(lastState.page - 1).setStyle('display', 'none');
				            }
				            pages.item(state.page - 1).setStyle('display', 'block');
				          }
				        },
				        page: 1
				      }
				    ).render();
				  }
				);
			</script>
			<script type="text/javascript">
				YUI().use(
				  'aui-toggler',
				  function(Y) {
				    new Y.TogglerDelegate(
				      {
				    	animated: true,
				        closeAllOnExpand: true,
				        container: '.listadoNotificaciones',
				        header: '.cabeceraNotificacion',
				        content: '.contenidoNotificacion',
				        expanded: false,
				        transition: {
				            duration: 0.1,
				            easing: 'cubic-bezier(0, 0.1, 0, 1)'
				          }
				      }
				    );
				  }
				);
			</script>
			<div class="listadoNotificaciones">
			<%
				char intro = 10;
				String introString = "" + intro;
				UserNotificationEvent notificacion;
				JSONObject notificacionJSON;
				Integer notificacionesPorPagina = 5;
				Integer tamanyo = userNotificationEventList.size();
				Integer paginas;
				Float paginasDecimal = tamanyo / (float)notificacionesPorPagina;
				//Si el result. de la división del total de elementos entre la cantidad de 
				//objetos que queremos paginar(5) tiene decimales añadiremos una página más.
				if(paginasDecimal % 1 !=0){
					paginas = (tamanyo / notificacionesPorPagina) + 1;
				}else{
					paginas = tamanyo / notificacionesPorPagina;
				}
				Integer contadorPaginas = 1;
				Integer contadorNotificaciones = 0;
				Integer maxNotificacionPagina;
				Boolean seguir = Boolean.TRUE;
				String noDisplay;
				while(contadorPaginas <= paginas && seguir == true){
					if(contadorPaginas ==1){
						noDisplay = "";
					}else{
						noDisplay = "style=\"display: none;\"";
					}
					%>
						<div class="paginaNotificaciones" <%=noDisplay%>>
					<%
					maxNotificacionPagina = (contadorPaginas * notificacionesPorPagina);
					while (contadorNotificaciones < maxNotificacionPagina && seguir == true){
						notificacion = userNotificationEventList.get(contadorNotificaciones);
						notificacionJSON = JSONFactoryUtil.createJSONObject(notificacion.getPayload());
						User remitente = UserLocalServiceUtil.getUser(Long.parseLong(notificacionJSON.getString("userId")));
				        Date date=new Date(notificacion.getTimestamp());
				        String horaText = horaFormat.format(date);
				        String diaText = diaFormat.format(date);
				        String fechaCompleta;
				    	String fechaCabecera;
				        if(diaText.compareTo(diaFormat.format(new Date())) == 0){
				        	fechaCompleta = horaText;
				        	fechaCabecera = horaText;
				        }else{
				        	fechaCompleta = diaText + " " + LanguageUtil.get(locale, "notificaciones.listado.aLas") + " " + horaText;
				        	fechaCabecera = diaText;
				        }
						
					%>
					<div class="notificacionDiv">
						<div class="cabeceraNotificacion">
							<table style="width: 100%;">
								<tr>
									<td width="35%">
										<%if(notificacion.getArchived() == false){%>
										<strong>
										<%}%>
										<%=remitente.getFullName().length() > 25? remitente.getFullName().substring(0, 25) + "..." : remitente.getFullName()%>
										<%if(notificacion.getArchived() == false){%>
										</strong>
										<%}%>
									</td>
									<td width="50%">
									<%if(notificacion.getArchived() == false){%>
										<b><span style="color: #ff9237">
									<%}%>
									<%=notificacionJSON.getString("titulo").length() > 35? notificacionJSON.getString("titulo").substring(0, 35) + "..." : notificacionJSON.getString("titulo")%>
									<%if(notificacion.getArchived() == false){%>
										</span></b>
									<%}%>
									</td>
									<td width="15%" align="right">
										<%=fechaCabecera%>
									</td>
								</tr>
							</table>
						</div>
						<div class="contenidoNotificacion">
							<div>
								<table style="width: 100%;">
									<tr>
										<td style="width: 10%">
											<img style="width: 50px; height: 50px;" alt="<%=HtmlUtil.escape(remitente.getFullName()) %>" class="user-logo" src="<%= remitente.getPortraitURL(themeDisplay) %>" />
										</td>
										<td style="width: 84%">
											<%=LanguageUtil.get(locale, "notificaciones.listado.de") + ": " + remitente.getFullName()%><br>
											<%=LanguageUtil.get(locale, "notificaciones.listado.recibido") + ": " + fechaCompleta%>
										</td>
										<td style="width: 3%" align="right">
											<% 
												List<Role> rolesPermitidosRespuesta = RolesRetriever.getRolesPermitidos(false, company.getCompanyId(), user);
												long[] rolesRemitente = remitente.getRoleIds();
												Boolean respuestaEncontrada = Boolean.FALSE;
												int contadorRolesRemitente = 0;
												int contadorRolesPermitidos;
												//Recorremos todos los roles del remitente y los comparamos con los roles permitidos por el usuario logado
												//Si se encuentran coincidencia, se carga el formulario de respuesta de notificación con los valores hidden
												//necesarios para cargar el formulario de respuesta.
												while(contadorRolesRemitente < rolesRemitente.length && !respuestaEncontrada){
													contadorRolesPermitidos = 0;
													while(contadorRolesPermitidos < rolesPermitidosRespuesta.size() && !respuestaEncontrada){
														if(rolesPermitidosRespuesta.get(contadorRolesPermitidos).getRoleId() == rolesRemitente[contadorRolesRemitente]){
															//Pintar formulario en pantalla (botón responder)
	 														//Tipo de notificación: Personal
															//Identificador de rol respuesta: rolesRemitente[contadorRolesRemitente]
											%>
															<portlet:renderURL var="replyNotificacionActionURL" windowState="maximized">
																<portlet:param name="redirect" value="<%=currentURL%>" />
																<portlet:param name="jspPage" value="/html/edit.jsp" />
																<portlet:param name="tipoNotificacionRespuesta" value='2'/>
																<portlet:param name="idRolRespuesta" value='<%=""+rolesRemitente[contadorRolesRemitente]%>' />
																<portlet:param name="idUserRespuesta" value='<%=""+remitente.getUserId()%>' />
																<portlet:param name="nombreUserRespuesta" value='<%=remitente.getFullName()%>' />
																<portlet:param name="fechaPrevistaRespuesta" value='<%=notificacionJSON.getString("fechaPrevista")%>' />
																<portlet:param name="horaPrevistaRespuesta" value='<%=notificacionJSON.getString("horaPrevista")%>' />
																<portlet:param name="tituloRespuesta" value='<%=notificacionJSON.getString("titulo")%>'/>
															</portlet:renderURL>
															<form action="<%=replyNotificacionActionURL%>" id="formularioReplyNotificacion" name="formularioReplyNotificacion" method="post">																															
																<button class="botonSinFondo" title="<%=LanguageUtil.get(locale, "notificaciones.boton.title.responder")%>" type="submit" name="replyNotificacionImage"><span class="icon-share-alt" aria-hidden="true"></span></button>
															</form>
											<%
															respuestaEncontrada = Boolean.TRUE;
														}
														contadorRolesPermitidos++;
													}
													contadorRolesRemitente++;
												}
											%>
										</td>
										<td style="width: 3%" align="right">
											<portlet:actionURL var="deleteNotificacionActionURL" windowState="maximized" name="deleteNotificacion"><portlet:param name="redirect" value="<%=currentURL %>" /></portlet:actionURL>
											<form action="<%=deleteNotificacionActionURL%>" id="formularioDeleteNotificacion" name="formularioDeleteNotificacion" method="post" onsubmit="return confirmarEliminar()">
												<input type="hidden" id="idNotificacionEliminar" name="<portlet:namespace/>idNotificacionEliminar" value="<%=notificacion.getUserNotificationEventId()%>"/>
												<button class="botonSinFondo" title="<%=LanguageUtil.get(locale, "notificaciones.boton.title.eliminar")%>" type="submit" name="deleteNotificacionImage"><span class="icon-trash" aria-hidden="true"></span></button>
											</form>
										</td>
									</tr>
								</table>
							</div>
							<br>
							<div>
								<b><%=notificacionJSON.getString("titulo")%></b>
								<br>
								<% 		
									String fechaPrevista = LanguageUtil.get(locale, "notificaciones.formularioNueva.label.fecha") + ": " + notificacionJSON.getString("fechaPrevista");
									String horaPrevista = notificacionJSON.getString("horaPrevista");
									if(horaPrevista != null && !horaPrevista.trim().isEmpty()){
										fechaPrevista = fechaPrevista.concat(" " + LanguageUtil.get(locale, "notificaciones.listado.aLas") + " " + horaPrevista);
									}			
								%>
								<span class="notificacionfechaPrevista"><%=fechaPrevista%></span>
								<br>
								<%
									String contenidoIntros = notificacionJSON.getString("contenido").replaceAll(introString, "<br>");
								%>
								<%=contenidoIntros%>
								<portlet:actionURL var="viewNotificacionActionURL" windowState="maximized" name="viewNotificacion"><portlet:param name="redirect" value="<%=currentURL%>" /></portlet:actionURL>
								<!-- Notificación no leída -->
								<%if(notificacion.getArchived() == false){ %>
									<div align="right">
										<form action="<%=viewNotificacionActionURL %>" id="formularioViewNotificacion" name="formularioViewNotificacion" method="post">
											<input type="hidden" id="idNotificacionLeida" name="<portlet:namespace/>idNotificacionLeida" value="<%=notificacion.getUserNotificationEventId()%>"/>												
											<button title="<%=LanguageUtil.get(locale, "notificaciones.boton.title.marcarLeido")%>" class="botonSinFondo" type="submit" name="viewNotificacionImage"><span class="icon-eye-open" aria-hidden="true"></span></button>
										</form>
									</div>
								<!-- Notificación leída -->
								<%}else{%>
									<div align="right">
										<form action="<%=viewNotificacionActionURL %>" id="formularioViewNotificacion" name="formularioViewNotificacion" method="post">
											<input type="hidden" id="idNotificacionLeida" name="<portlet:namespace/>idNotificacionLeida" value="<%=notificacion.getUserNotificationEventId()%>"/>												
											<button title="<%=LanguageUtil.get(locale, "notificaciones.boton.title.marcarNoLeido")%>" class="botonSinFondo" type="submit" name="viewNotificacionImage"><span class="icon-eye-close" aria-hidden="true"></span></button>
										</form>
									</div>
								<%}%>
							</div>
						</div>
					</div>
					<%	
						contadorNotificaciones++;
						if(contadorNotificaciones == tamanyo){
							seguir = Boolean.FALSE;
						}
						//br
					}
					%>
					</div>
					<%
					contadorPaginas++;
				}
			  %>
			</div>
			<div id="pagination">
			  <ul class="pagination pagination-content">
			    <li><a href="#">Prev</a></li>
			    <%for(int pag = 1; pag <= paginas; pag++){%>
				    <li><a href="#"><%=pag%></a></li>
			    <%}%>
			    <li><a href="#">Next</a></li>
			  </ul>
			</div>
			<%
			}
			//Si no hay notificaciones asociadas al usuario se muestra el mensaje evitando la ejecución d todo el código anterior
			else{
			%>
				<div align="center" style="padding-top: 40px;">
					<%=LanguageUtil.get(locale, "notificaciones.msg.info.noNotificaciones")%>
				</div>
			<%
			}
			%>
		</td>
	</tr>
</table>
<br>