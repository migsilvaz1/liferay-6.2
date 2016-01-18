<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.near.notificaciones.util.RolesRetriever"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<head>
	<!--Se anula el submit del formulario con la tecla enter-->
	<script type=text/javascript>
		function stopRKey(evt) {
		   var evt = (evt) ? evt : ((event) ? event : null);
		   var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
		   if ((evt.keyCode == 13) && (node.type=="text")) {return false;}
		}
		document.onkeypress = stopRKey;
	</script>
	<aui:script>
		var autocompleteList;
		function cargarAutocompletar(){
			document.getElementById('idDestinatarioInput').value = "";
			if(autocompleteList != null){
				autocompleteList.destroy();
			}
			AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',function (A) {
				A.io.request(renderURL.toString(),{
			  		dataType: 'json',
			  		method: 'GET',
			  		on: {
			   			success: function() {
			     		autocompleteList = new A.AutoCompleteList({
								activateFirstItem: 'true',
								inputNode: '#nombreDestinatarioInput',
								resultTextLocator: 'nombreAutocompletar',
								resultHighlighter:['phraseMatch'], 
								resultFilters:['phraseMatch'],
								render: 'true',
								source:this.get('responseData'),
								on:{
									select: function(itemNode) {
										document.getElementById('idDestinatarioInput').value = itemNode.result.raw.userId;
										habilitarFecha();
									}
								}
							});
			    		}
			    	}
				});
			});	
		}
	</aui:script>
	<portlet:resourceURL var="getUsuariosResourceURL" />
	<script>
	    Liferay.provide(window, '<portlet:namespace/>getUsuarios',
	        function() {
	            var A = AUI();
	            var getUsuariosURL = '<%= getUsuariosResourceURL.toString() %>';
	            var rolSelect = document.getElementById("rolDestinatarioSelect");
	            var multiSelectUsuarios = document.getElementById("destinatariosMultiselect");
	            var rolSelectValue = rolSelect.options[rolSelect.selectedIndex].value;
	            A.io.request (
	                getUsuariosURL, {
	                	data: {
	                    	<portlet:namespace />idRol: rolSelectValue
		                },
		                dataType: 'json',
		                on:{
							success: function(event, id, obj) {
							    var usuarios = this.get('responseData');
							    //Vaciar el select
							    if (multiSelectUsuarios.length > 0) {
							    	multiSelectUsuarios.options.length = 0;
							    } 
							    for (var i = 0; i < usuarios.length; i++) {
							    	var opt = document.createElement('option');
							    	opt.value = usuarios[i].userId;
							    	opt.innerHTML = usuarios[i].nombreAutocompletar;
							        multiSelectUsuarios.appendChild(opt);
							    }
							}
		                }
	                }
	            ); 
	        },
	        ['aui-io']
	    );
	</script>
	<aui:script>
		//Si se ha accedido al formulario desde el botón de responder de una notificación, cargamos todos los datos de respuesta
		if(<%=request.getParameter("tipoNotificacionRespuesta")%> != null){
			document.getElementById('tipoNotificacionSelect').selectedIndex = 2;
			document.getElementById('rolDestinatarioSelect').disabled = false;
			cargarSelectRoles();
 		    var rolesSelector = document.getElementById("rolDestinatarioSelect");
 		    var idRolRespuesta = "<%=request.getParameter("idRolRespuesta")%>";
 		    var contador = 0;
 		    var encontrado = false;
	    	while(contador < rolesSelector.length && !encontrado) {
 		    	if(rolesSelector.options[contador].value == idRolRespuesta){
 		    		rolesSelector.selectedIndex = contador;
 		    		cambiadoRolDestino(rolesSelector.options[contador]);
 		    		encontrado = true;
 		    	}
 		    	contador++;
		    }
			document.getElementById('nombreDestinatarioInput').disabled = false;
			document.getElementById('nombreDestinatarioInput').value = "<%=request.getParameter("nombreUserRespuesta")%>"
			document.getElementById('idDestinatarioInput').value = "<%=request.getParameter("idUserRespuesta")%>"
			document.getElementById('fechaPrevistaInput').disabled = false;
			document.getElementById('fechaPrevistaInput').value = "<%=request.getParameter("fechaPrevistaRespuesta")%>";
			document.getElementById('horaPrevistaInput').disabled = false;
			document.getElementById('horaPrevistaInput').value = "<%=request.getParameter("horaPrevistaRespuesta") != null && !request.getParameter("horaPrevistaRespuesta").isEmpty()? request.getParameter("horaPrevistaRespuesta") : ""%>";
			<%
				String titulo = request.getParameter("tituloRespuesta");
				if(titulo != null && titulo.length() > 3){
					if(titulo.substring(0, 3).compareTo("Re:") !=0){
						titulo = "Re: " + titulo;
					}
				}else{
					titulo = "Re: " + titulo;
				}
			%>
			document.getElementById('titulo').disabled = false;
			document.getElementById('titulo').value = "<%=titulo%>";
			
			document.getElementById('contenido').disabled = false;
		}
	</aui:script>
	<aui:script>
		var renderURL;
		function createRenderURL(value) {
		    AUI().use('liferay-portlet-url', function(A) {
		    	renderURL = Liferay.PortletURL.createResourceURL();
		        renderURL.setParameter('idRol',value);
		        renderURL.setPortletId('reynasanotifications_WAR_reynasanotificationsportlet');
		    });
		}
		function cambiadoTipoNotificacion() {
			ocultarMultiselect();
			if (document.getElementById('tipoNotificacionSelect').selectedIndex != 0) {
				document.getElementById('rolDestinatarioSelect').disabled = false;
				document.getElementById('rolDestinatarioSelect').selectedIndex = 0;
				cargarSelectRoles();
				document.getElementById('nombreDestinatarioInput').value = "";
				document.getElementById('nombreDestinatarioInput').disabled = true;
				document.getElementById('selectTipoSeleccionDest').selectedIndex = 0;
				document.getElementById('selectTipoSeleccionDest').disabled = true;
				deshabilitarFecha();
				if(document.getElementById('tipoNotificacionSelect').selectedIndex == 1){
					document.getElementById('selectTipoSeleccionDest').style.display = "block";
					document.getElementById('nombreDestinatarioInput').style.display = "none";
				}
				if(document.getElementById('tipoNotificacionSelect').selectedIndex == 2){
					document.getElementById('selectTipoSeleccionDest').style.display = "none";
					document.getElementById('nombreDestinatarioInput').style.display = "block";
				}
			}
		}
		function cambiadoRolDestino(res) {
			var value = res.value;
			document.getElementById('nombreDestinatarioInput').value = "";
			document.getElementById('nombreDestinatarioInput').disabled = true;
			document.getElementById('selectTipoSeleccionDest').selectedIndex = 0;
			ocultarMultiselect();
			deshabilitarFecha();
			//Envío personal
			if (value != 0) {
				var rolDestinatarioSelectedValue = value;
				createRenderURL(rolDestinatarioSelectedValue);
				if(document.getElementById('tipoNotificacionSelect').selectedIndex == 2){
					cargarAutocompletar();
				}
				document.getElementById('nombreDestinatarioInput').disabled = false;
				document.getElementById('selectTipoSeleccionDest').disabled = false;
			} else {
				document.getElementById('nombreDestinatarioInput').disabled = true;
				document.getElementById('selectTipoSeleccionDest').disabled = true;
			}	
		}
		
		function cambiadoSelectTipoSeleccionDest(){
			if (document.getElementById('selectTipoSeleccionDest').selectedIndex != 0) {
				deshabilitarFecha();
				if(document.getElementById('selectTipoSeleccionDest').selectedIndex == 1){
					ocultarMultiselect();
					habilitarFecha();
				}
				if(document.getElementById('selectTipoSeleccionDest').selectedIndex == 2){
					mostrarMultiselect();
				}
			}else{
				ocultarMultiselect();
			}
		}
		
		function cambiadoDestinatariosMultiselect(){
			if(document.getElementById('destinatariosMultiselect').selectedIndex != -1){
				habilitarFecha();
			}else{
				deshabilitarFecha();
			}
		}
		
		function mostrarMultiselect(){
			document.getElementById('destinatariosMultiselect').selectedIndex = -1;
			document.getElementById('divDestinatarios').style.display = "block";
		}
		
		function ocultarMultiselect(){
			document.getElementById('destinatariosMultiselect').selectedIndex = -1;
			document.getElementById('divDestinatarios').style.display = "none";
		}
		
		function vaciarIdDestinatarioHidden(){
			var destinatariosMultiselectvalue = document.getElementById('destinatariosMultiselect');
			var inputNombre = document.getElementById('nombreDestinatarioInput');
			var id;
			var encontrado = false;
			var contador = 0;
			while(contador < destinatariosMultiselectvalue.children.length && encontrado == false){
			    var child = destinatariosMultiselectvalue.children[contador];
			    if (child.tagName == 'OPTION'){
			    	if(inputNombre.value.trim().localeCompare(child.innerHTML) == 0){
			    		console.log("nombre: "+child.innerHTML);
			    		document.getElementById('idDestinatarioInput').value = child.value;
			    		encontrado = true;
			    	}else{
			    		document.getElementById('idDestinatarioInput').value = "";
			    	}
			    }
			    contador++;
			}
			if(document.getElementById('nombreDestinatarioInput').value.trim() == ""){
				document.getElementById('idDestinatarioInput').value = "";
				deshabilitarFecha();
			}
		}
		
		function habilitarFecha(){
			document.getElementById('fechaPrevistaInput').disabled = false;
			document.getElementById('horaPrevistaInput').disabled = false;
			//Cambiamos la fecha por defecto por la actual.
			cargarFecha();
		}
		
		function deshabilitarFecha(){
			document.getElementById('fechaPrevistaInput').disabled = true;
			document.getElementById('fechaPrevistaInput').value = "";
			document.getElementById('horaPrevistaInput').disabled = true;
			document.getElementById('horaPrevistaInput').value = "";
		}
		function cargarFecha() {
			if(document.getElementById('fechaPrevistaInput').value.trim() == ""){
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
				document.getElementById("fechaPrevistaInput").value = fechaHoy;
			}
		}
		function cargarHora() {
			//El método sólo carga la hora predefinida si no se ha seleccionado ninguna.
			if(document.getElementById('horaPrevistaInput').value.trim() == ""){
				var horaCompletaNow = new Date();
				var horaNow = horaCompletaNow.getHours();
				var minutosNow = horaCompletaNow.getMinutes();
				if(minutosNow >= 0 && minutosNow < 30 ) {
					minutosNow = 30;
				} else {
					minutosNow = '00';
					horaNow = horaNow + 1;
				}
				if(horaNow < 10 && horaNow > 0) {
				    horaNow = '0' + horaNow;
				} 
				horaCompletaNow = horaNow + ':' + minutosNow;
				document.getElementById("horaPrevistaInput").value = horaCompletaNow;
			}
		}
		function cargarSelectRoles() {
			var selectRol = document.getElementById("rolDestinatarioSelect");
			selectRol.options.length = 1;
			//Notificación General
			if (document.getElementById('tipoNotificacionSelect').selectedIndex == 1) {
				<%
					List<Role> rolesPermitidosTrueList = RolesRetriever.getRolesPermitidos(true, company.getCompanyId(), user);
					for(Role rol : rolesPermitidosTrueList){
				%>
						var option = document.createElement("option");
						option.text = "<%=rol.getName()%>";
						option.value = "<%=rol.getRoleId()%>"; 
						selectRol.add(option);
				<%
					}
				%>
			}
			//Notificación Personal
			if (document.getElementById('tipoNotificacionSelect').selectedIndex == 2) {
				<%
					List<Role> rolesPermitidosFalseList = RolesRetriever.getRolesPermitidos(false, company.getCompanyId(), user);
					for(Role rol : rolesPermitidosFalseList){
				%>
						var option = document.createElement("option");
						option.text = "<%=rol.getName()%>";
						option.value = "<%=rol.getRoleId()%>";
						selectRol.add(option);
				<%					
					}
				%>
			}
		}
		function validarFormulario() {
			//Se comprueba que el tipo de notificación no esté vacío, en caso contrario se muestra el mensaje.
			var selectTipo = document.getElementById('tipoNotificacionSelect');
			var msgErrorSelectTipo = document.getElementById("notificacionTipoMissed");
			var correcto = true;
			
			if(selectTipo.selectedIndex == 0){
				msgErrorSelectTipo.style.display = "block";
				correcto = false;
			}else{
				if(msgErrorSelectTipo.style.display != "none"){
					msgErrorSelectTipo.style.display = "none";
				}	
			}
			//Se comprueba que el nombre del destinatario sea correcto, en caso contrario se muestra el mensaje.
			var inputNombreDest = document.getElementById('nombreDestinatarioInput');
			var idDestinatarioHidden = document.getElementById('idDestinatarioInput');
			var msgErrorInputNombreDest = document.getElementById("notificacionNombreDestMissed");
			if(selectTipo.selectedIndex == 2){
				if(inputNombreDest.disabled != true){
					if(idDestinatarioHidden.value.trim() == ""){
						msgErrorInputNombreDest.style.display = "block";
						correcto = false;
					}else{
						if(msgErrorInputNombreDest.style.display != "none"){
							msgErrorInputNombreDest.style.display = "none";	
						}
					}			
				}else{
					msgErrorInputNombreDest.style.display = "none";	
				}
			}else{
				msgErrorInputNombreDest.style.display = "none";	
			}
			//Se comprueba que se haya seleccionado un rol para el destinatario, en caso contrario se muestra el mensaje.
			var rolDestSelect = document.getElementById('rolDestinatarioSelect');
			var msgErrorRolDestSelect = document.getElementById("notificacionRolDestMissed");
			
			if(rolDestSelect.disabled != true){
				if(rolDestSelect.selectedIndex == 0){
					msgErrorRolDestSelect.style.display = "block";
					correcto = false;
				}else{
					if(msgErrorRolDestSelect.style.display != "none"){
						msgErrorRolDestSelect.style.display = "none";	
					}
				}
			}else{
				msgErrorRolDestSelect.style.display = "none";	
			}
			//Se comprueba que se haya seleccionado un tipo de selección para los destinatarios de envío general
 			var selectTipoDest = document.getElementById('selectTipoSeleccionDest');
 			var msgErrorSelectTipoDest = document.getElementById("selectTipoDestMissed");
 			var msgErrorNoDestinatariosMultiselect = document.getElementById("noDestinatariosMultiselect");
 			if(selectTipo.selectedIndex == 1){
	 			if(selectTipoDest.disabled != true){
	 				if(selectTipoDest.selectedIndex == 0){
	 					msgErrorSelectTipoDest.style.display = "block";
	 					correcto = false;
	 				}else{
	 					if(msgErrorSelectTipoDest.style.display != "none"){
	 						msgErrorSelectTipoDest.style.display = "none";	
	 					}
	 				}
	 			}else{
	 				msgErrorSelectTipoDest.style.display = "none";
				}
	 			
				if(selectTipoDest.selectedIndex == 2){
					if(document.getElementById('destinatariosMultiselect').selectedIndex == -1){
						msgErrorNoDestinatariosMultiselect.style.display = "block";
						correcto = false;
					}else{
						msgErrorNoDestinatariosMultiselect.style.display = "none";
					}
				}else{
					msgErrorNoDestinatariosMultiselect.style.display = "none";
				}
 			}else{
				msgErrorNoDestinatariosMultiselect.style.display = "none";
			}
			//Se comprueba que se haya seleccionado una fecha prevista correcta, en caso contrario se muestra el mensaje.
			var inputFecha = document.getElementById('fechaPrevistaInput');
			var msgFechaMissed = document.getElementById("notificacionFechaPrevistaMissed");
			
			if(inputFecha.disabled != true){
				var inputFecha = document.getElementById('fechaPrevistaInput');
				var formatoFecha=/^[0-9][0-9]\/[0-9][0-9]\/[0-9][0-9][0-9][0-9]$/;
				var fechaPlantilla = new Date()
				fechaPlantilla.setFullYear(inputFecha.value.substring(6,10), inputFecha.value.substring(3,5)-1, inputFecha.value.substring(0,2))
				if((inputFecha.value.length==0 || !formatoFecha.exec(inputFecha.value)) || (fechaPlantilla.getMonth() != inputFecha.value.substring(3,5)-1 || fechaPlantilla.getDate() != inputFecha.value.substring(0,2))){
					msgFechaMissed.style.display = "block";
					correcto = false;
				}else{
					if(msgFechaMissed.style.display != "none"){
						msgFechaMissed.style.display = "none";	
					}
				}
			}else{
				msgFechaMissed.style.display = "none";	
			}
			//Se comprueba que se haya seleccionado una hora prevista correcta, en caso contrario se muestra el mensaje.		
			var inputHora = document.getElementById('horaPrevistaInput');
			var msgHoraMissed = document.getElementById("notificacionHoraPrevistaMissed");
			
			if(inputHora.disabled != true){
				if(inputHora.value.trim() != ""){
					var formatoHora=/^(0[0-9]|1\d|2[0-3]):([0-5]\d)?$/;
					if(!formatoHora.test(document.getElementById("horaPrevistaInput").value)){
						msgHoraMissed.style.display = "block";
						correcto = false;
					}else{
						msgHoraMissed.style.display = "none";
					}
				}
			}else{
				msgHoraMissed.style.display = "none";
			}
			//Se comprueba que se haya escrito un título, en caso contrario se muestra el mensaje.		
			var inputTitulo = document.getElementById('titulo');
			var tituloMissed = document.getElementById("notificacionTituloMissed");
			
			if(inputTitulo.value.trim() == ""){
				tituloMissed.style.display = "block";
				correcto = false;
			}else{
				if(tituloMissed.style.display != "none"){
					tituloMissed.style.display = "none";	
				}
			}
			//Se comprueba que se haya escrito un contenido, en caso contrario se muestra el mensaje.		
			var inputContenido = document.getElementById('contenido');
			var contenidoMissed = document.getElementById("notificacionContenidoMissed");
			
			if(inputContenido.value.trim() == ""){
				contenidoMissed.style.display = "block";
				correcto = false;
			}else{
				if(contenidoMissed.style.display != "none"){
					contenidoMissed.style.display = "none";	
				}
			}
			return correcto;
		}
		</aui:script>
</head>
<body>
	<div style="width: 100%; margin: 0 auto;">
		<table style="width: 100%;">
			<tr>
				<td>
					<%String redirect = ParamUtil.getString(request, "redirect"); %>
					<liferay-ui:header backURL="<%=redirect%>" title='<%=LanguageUtil.get(locale, "notificaciones.menu.iniciarHilo")%>'/>
					<br>
				</td>
			</tr>
		</table>
				
		<portlet:actionURL var="sendNotificacionActionURL" windowState="maximized" name="sendNotificacion"><portlet:param name="redirect" value="<%=redirect %>"/></portlet:actionURL>
		
		<form autocomplete="off" action="<%=sendNotificacionActionURL%>" id="formularioNuevaNotificacion" name="formularioNuevaNotificacion" method="POST" onsubmit="return validarFormulario()">
			<input type="hidden" id="remitenteId" name="<portlet:namespace/>remitenteId" value="<%=user.getUserId()%>">
			<div>
				<table>	
					<tr>
						<td width="40%">
							<table class="tablaFormularioNuevaNotificacion">
								<tr>
									<td>
										<div id="notificacionTipoMissed" class="alert alert-warning mensajeErrorNotificacion">
											<%=LanguageUtil.get(locale, "notificaciones.msg.error.noTipoSelected")%>
										</div>	
									</td>
									<td>
									</td>
								</tr>
								<tr>
									<td>
										<label class="control-label" for="tipoNotificacionSelect"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.label.tipo")%></label>
										<select id="tipoNotificacionSelect" name="<portlet:namespace/>tipoNotificacionSelect" onchange="cambiadoTipoNotificacion()">
											<option disabled selected class="noMostrar"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.placeholder.tipo")%></option>
											<option><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.tipo.general")%></option>
											<option><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.tipo.personal")%></option>
										</select>
									</td>
									<td></td>
								</tr>
								<tr>
									<td>
										<div id="notificacionRolDestMissed" class="alert alert-warning mensajeErrorNotificacion">
											<%=LanguageUtil.get(locale, "notificaciones.msg.error.noRolSelected")%>
										</div>	
									</td>
									<td>
										<div id="notificacionNombreDestMissed" class="alert alert-warning mensajeErrorNotificacion">
											<%=LanguageUtil.get(locale, "notificaciones.msg.error.noDestinatarioSelected")%>
										</div>
										<div id="selectTipoDestMissed" class="alert alert-warning mensajeErrorNotificacion">
											<%=LanguageUtil.get(locale, "notificaciones.msg.error.noGrupoDestinatariosSelected")%>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<label class="control-label" for="rolDestinatarioSelect"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.label.rol")%></label>
										<select id="rolDestinatarioSelect" name="<portlet:namespace/>rolDestinatarioSelect" <%--onchange="cambiadoRolDestino(this);"--%> onchange="<%= renderResponse.getNamespace() + "getUsuarios();"%>;cambiadoRolDestino(this)" disabled>
											<option disabled selected class="noMostrar"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.placeholder.rol")%></option>
										</select>
									</td>
									<td>
										<label class="control-label" for="nombreDestinatarioInput"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.label.destinatario")%></label>
										<input type="text" id="nombreDestinatarioInput" name="<portlet:namespace/>nombreDestinatarioInput" placeholder="<%=LanguageUtil.get(locale, "notificaciones.formularioNueva.placeholder.destinatario")%>" onchange="vaciarIdDestinatarioHidden()" disabled>
										<select id="selectTipoSeleccionDest" name="<portlet:namespace/>selectTipoSeleccionDest" style="display: none;" disabled onchange="cambiadoSelectTipoSeleccionDest()">
											<option disabled selected class="noMostrar"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.placeholder.grupo")%></option>
											<option><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.destinatario.todos")%></option>
											<option><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.destinatario.personalizado")%></option>
										</select>
										<input type="hidden" id="idDestinatarioInput" name="<portlet:namespace/>idDestinatarioInput"/>
									</td>
								</tr>
								<tr>
									<td>
										<div id="notificacionFechaPrevistaMissed" class="alert alert-warning mensajeErrorNotificacion">
											<%=LanguageUtil.get(locale, "notificaciones.msg.error.fechaIncorrecta")%>
										</div>
									</td>
									<td>
										<div id="notificacionHoraPrevistaMissed" class="alert alert-warning mensajeErrorNotificacion">
											<%=LanguageUtil.get(locale, "notificaciones.msg.error.horaIncorrecta")%>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<script type="text/javascript">
											YUI({ lang: 'es' }).use('aui-datepicker',function(Y) {
											    var datepicker = new Y.DatePicker(
											      {
											        trigger: '#fechaPrevistaInput',
											        mask: '%d/%m/%Y',
											        popover: {
											          zIndex: 1
											        }
											      }
											    );
											  }
											);
										</script>
										<label class="control-label" for="fechaPrevistaInput"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.label.fecha")%></label>
										<input id="fechaPrevistaInput" name="<portlet:namespace/>fechaPrevistaInput" type="text" placeholder="<%=LanguageUtil.get(locale, "notificaciones.formularioNueva.placeholder.fecha")%>" onfocus="cargarFecha()" disabled>
									</td>
									<td>
										<script type="text/javascript">
											YUI().use('aui-timepicker', function(Y) {
											    new Y.TimePicker(
											      {
											        trigger: '#horaPrevistaInput',
											        mask: '%H:%M',
											        popover: {
											          zIndex: 1
											        }
											      }
											    );
											  }
											);
										</script>
										<label class="control-label" for="horaPrevistaInput"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.label.hora")%></label>
										<input type="text" id="horaPrevistaInput" name="<portlet:namespace/>horaPrevistaInput" placeholder="<%=LanguageUtil.get(locale, "notificaciones.formularioNueva.placeholder.hora")%>" onfocus="cargarHora()" disabled>
									</td>
								</tr>
							</table>
						</td>
						<td width="10%">
						</td>
						<td width="50%">
							<div id="divDestinatarios" class="noMostrar">
								<table style="width: 100%;">
									<tr>
										<td align="center">
											<div id=noDestinatariosMultiselect class="alert alert-warning mensajeErrorNotificacion">
												<%=LanguageUtil.get(locale, "notificaciones.msg.error.noDestinatariosSelected")%>
											</div>	
										</td>
									</tr>
									<tr>
										<td>
											<label class="control-label" for="destinatariosMultiselect"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.label.destinatarios")%> <%=LanguageUtil.get(locale, "notificaciones.formularioNueva.label.destinatarios.aclaracion")%></label>
											<select id='destinatariosMultiselect' name="<portlet:namespace/>destinatariosMultiselect" multiple style="width: 100%; height:170px;" onchange="cambiadoDestinatariosMultiselect()">
											</select>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>	
			</div>
			<br>
			<div>
				<table style="width: 100%;">
				<tr>
					<td align="right" style="margin-bottom: 20px;">
						<button type="submit" class="btn btn-large btn-primary green letrasMayusculas"><%=LanguageUtil.get(locale, "notificaciones.formularioNueva.submit")%></button>
					</td>
				</tr>
				<tr>
					<td style="padding-top: 15px; padding-right: 15px;">
						<div id="notificacionTituloMissed" class="alert alert-warning mensajeErrorNotificacion" style="width: 60%;">
							<%=LanguageUtil.get(locale, "notificaciones.msg.error.noTitulo")%>
						</div>
						<input id="titulo" name="<portlet:namespace/>titulo" style="width:100%;" type="text" placeholder="<%=LanguageUtil.get(locale, "notificaciones.formularioNueva.placeholder.titulo")%>">
					</td>
				</tr>
				<tr>
					<td style="padding-right: 15px;">
						<div id="notificacionContenidoMissed" class="alert alert-warning mensajeErrorNotificacion" style="width: 60%;">
							<%=LanguageUtil.get(locale, "notificaciones.msg.error.noContenido")%>
						</div>
						<textarea id="contenido" name="<portlet:namespace/>contenido"  style="width: 100%; height: 100px;" placeholder="<%=LanguageUtil.get(locale, "notificaciones.formularioNueva.placeholder.contenido")%>"></textarea>
					</td>
				</tr>
				</table>
			</div>
		</form>
	</div>
</body>