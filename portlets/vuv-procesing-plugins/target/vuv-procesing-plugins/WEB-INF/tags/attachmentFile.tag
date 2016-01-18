<%@tag import="ec.gob.snap.vuv.util.MyDocumentsViewUtil"%>
<%@tag import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@tag import="com.liferay.portal.kernel.json.JSONObject"%>
<%@tag import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@tag import="com.liferay.portal.kernel.json.JSONArray"%>
<%@tag import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%@ attribute name="attachmentFileDao" required="true" rtexprvalue="true" type="ec.gob.snap.vuv.dynamic.form.dao.AttachmentFileDAO"%>


<%String attachmentFileId = attachmentFileDao.getAttachmentFileId();%>
<div id=<%=attachmentFileId + "attachmentFullContainer"%> style="width: 100%;">
	<portlet:resourceURL var="listarContenidosResourceURL">
		<portlet:param name="navegacionMisDocumentos" value="true"/>
	</portlet:resourceURL>
	<portlet:resourceURL var="obtenerBinarioResourceURL">
		<portlet:param name="binarioDocumento" value="true"/>
	</portlet:resourceURL>
	<select onchange='cambiadoTipoOrigen(this.value, "<%=attachmentFileId%>")' style="width: auto;">
		<option value="0">
			<%=LanguageUtil.get(locale, "vuv.procesing.fileSelector.selectFrom")%>
		</option>
		<option value="1">
			<%=LanguageUtil.get(locale, "vuv.procesing.fileSelector.selectLocal")%>
		</option>
		<option value="2">
			<%=LanguageUtil.get(locale, "vuv.procesing.fileSelector.selectRemote")%>
		</option>
	</select>
	<br><br>
	<div id="<%=attachmentFileId%>ficheroLocal" style="display: none;">
		<input id="<%=attachmentFileId%>inputFicheroSubir" type="file"/>
	</div>
	<div id="<%=attachmentFileId%>ficheroRemoto" style="display: none; margin: 5px;">
		<%
		Long raizDirectorioUsuario = MyDocumentsViewUtil.getDirectorioUsuarioId(themeDisplay.getScopeGroupId(), user.getScreenName());
		if(raizDirectorioUsuario != 0){
		%>
			<input id="<%=attachmentFileId%>directorioSeleccionadoHidden" type="hidden"/>
			<table style="width: 100%;">
				<tr>
					<td id="<%=attachmentFileId%>menuNavegacionMisDocs" class="menuNavegacionMisDocs">
					</td>
				</tr>
				<tr>
					<td id="<%=attachmentFileId%>ficherosEnDirectorioActual" valign="top" align="center">
						<table id="<%=attachmentFileId%>subdirectoriosEnDirectorioActualTable" style="width: 100%;"></table>
						<table id="<%=attachmentFileId%>ficherosEnDirectorioActualTable" style="width: 100%;"></table>
						<span id="<%=attachmentFileId%>msgNohayFicheros" style="padding-top: 5px; padding-bottom: 5px;"><%=LanguageUtil.get(locale, "vuv.procesing.fileSelector.filesNotFound")%></span>
					</td>
				</tr>
			</table>
			<table style="width: 100%">
				<tr style="height: 20px;"></tr>
				<tr>
					<td align="right" valign="middle">
						<input id="<%=attachmentFileId%>idFicheroSeleccionadoHidden" type="hidden"/>
						<table>
							<tr>
								<td>
									<b><%=LanguageUtil.get(locale, "vuv.procesing.fileSelector.selectedFile")%>:</b> <span id="<%=attachmentFileId%>nombreFicheroSeleccionado" style="margin-bottom: 0px !important; font-style: italic;"></span>
								</td>
								<td>
									<button id="<%=attachmentFileId%>botonLimpiarSeleccion" class="botonSinFondo" title='<%=LanguageUtil.get(locale, "vuv.procesing.fileSelector.deleteSelectedFile")%>' style="display:none;" onclick="limpiarSeleccion('<%=attachmentFileId%>')"><i class="fa fa-times"></i></button>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<script>
				function seleccionarDirectorio(valor, attachmentFileId){
					document.getElementById(attachmentFileId + "directorioSeleccionadoHidden").value = valor;
					<%= renderResponse.getNamespace() + "listarDirectorios(attachmentFileId);"%>
				}
				function seleccionarFichero(id, nombre, attachmentFileId){
					document.getElementById(attachmentFileId + "idFicheroSeleccionadoHidden").value = id;
					document.getElementById(attachmentFileId + "nombreFicheroSeleccionado").innerHTML = nombre;
					document.getElementById(attachmentFileId + "botonLimpiarSeleccion").style.display = "block";
					<%= renderResponse.getNamespace() + "obtenerBinario();"%>
				}
				function cambiadoTipoOrigen(opcion, attachmentFileId){
					switch(opcion) {
					    case "0":
					    	document.getElementById(attachmentFileId + "ficheroLocal").style.display = "none";
				    		document.getElementById(attachmentFileId + "ficheroRemoto").style.display = "none";
					        break;
					    case "1":
					    	document.getElementById(attachmentFileId + "ficheroLocal").style.display = "block";
					    	document.getElementById(attachmentFileId + "ficheroRemoto").style.display = "none";
					        break;  
					    case "2":
					    	document.getElementById(attachmentFileId + "ficheroLocal").style.display = "none";
					    	document.getElementById(attachmentFileId + "ficheroRemoto").style.display = "block";
					    	document.getElementById(attachmentFileId + "directorioSeleccionadoHidden").value = "";
					    	document.getElementById(attachmentFileId + "idFicheroSeleccionadoHidden").value = "";
					    	document.getElementById(attachmentFileId + "nombreFicheroSeleccionado").innerHTML = msgFicheroNoSeleccionado;
					    	document.getElementById(attachmentFileId + "botonLimpiarSeleccion").style.display = "none";
					    	seleccionarDirectorio('<%=raizDirectorioUsuario%>', attachmentFileId);
					        break;   
					    default:
					    	document.getElementById(attachmentFileId + "ficheroLocal").style.display = "none";
				    		document.getElementById(attachmentFileId + "ficheroRemoto").style.display = "none";
					}
				}
				function limpiarSeleccion(attachmentFileId){
			    	document.getElementById(attachmentFileId + "idFicheroSeleccionadoHidden").value = "";
			    	document.getElementById(attachmentFileId + "nombreFicheroSeleccionado").innerHTML = msgFicheroNoSeleccionado;
			    	document.getElementById(attachmentFileId + "botonLimpiarSeleccion").style.display = "none";
				}
				
				//LLamada ajax para navegación de directorios/ficheros
			    Liferay.provide(
			        window,
			        '<portlet:namespace/>listarDirectorios',
			        function(attachmentFileId) {
			            var listarContenidosURL = '<%=listarContenidosResourceURL.toString()%>';
			            var idDirectorioSeleccionado = document.getElementById(attachmentFileId + "directorioSeleccionadoHidden").value;
			            AUI().io.request (
			            	listarContenidosURL,{
				                data: {<portlet:namespace/>directorioSeleccionadoId: idDirectorioSeleccionado},
				                dataType: 'json',
				                on: {
									failure: function() {
									    alert("Ha habido un fallo de ajax");
									},
									success: function(event, id, obj) {
										var encontrado = false;
									    var result = this.get('responseData');
									    //Pintar árbol de navegación superior
									  	var directoriosNavegacionContainer = document.getElementById(attachmentFileId + "menuNavegacionMisDocs");
									  	directoriosNavegacionContainer.innerHTML = "";
									    var directoriosNavegacion = result.menuNavegacion;
									    if(directoriosNavegacion != null){
										    for (var i = directoriosNavegacion.length - 1; i >= 0; i--) {
										    	directoriosNavegacionContainer.innerHTML += '<span style="cursor: pointer;" onclick="seleccionarDirectorio(' + directoriosNavegacion[i].id + ',&#39;' + attachmentFileId + '&#39;)"><i class="fa fa-folder-open-o"></i> <b> ' + directoriosNavegacion[i].nombre + ' </b></span>'
										    	if(i > 0){
										    		directoriosNavegacionContainer.innerHTML += '<b> / </b>';
										    	}
										    }
									    }
									    //Pintar botones para subdirectorios
									    var subdirectoriosEnDirectorioActualContainer = document.getElementById(attachmentFileId + "subdirectoriosEnDirectorioActualTable");
									    subdirectoriosEnDirectorioActualContainer.innerHTML = "";
									    var directorios = result.directorios;
									    if(directorios != null && directorios.length > 0){
									    	encontrado = true;
										    for (var i = 0; i < directorios.length; i++) {
											    subdirectoriosEnDirectorioActualContainer.innerHTML += '<tr class="filaFichero" onclick="seleccionarDirectorio(' + directorios[i].id + ',&#39;' + attachmentFileId + '&#39;)"><td style="padding-left:5px; padding-right:5px;"><i class="fa fa-folder"></i> ' + directorios[i].nombre + '</td></tr>'
										    }
									    }
									    //Pintar ficheros
									    var ficherosEnDirectorioActualContainer = document.getElementById(attachmentFileId + "ficherosEnDirectorioActualTable");
									    ficherosEnDirectorioActualContainer.innerHTML = "";
									    var ficheros = result.ficheros;
									    if(ficheros != null && ficheros.length > 0){
										    encontrado = true;
									    	for (var i = 0; i < ficheros.length; i++) {
										    	ficherosEnDirectorioActualContainer.innerHTML += '<tr class="filaFichero" onclick="seleccionarFichero(' + ficheros[i].id + ', &#39;' + ficheros[i].nombre + '&#39;, &#39;' + attachmentFileId + '&#39;)"><td width="34%" style="padding-left:5px;"><i class="fa fa-file-o"></i> ' + ficheros[i].nombre + '</td><td width="33%" align="center">' + ficheros[i].date + '</td><td align="right" width="33%" style="padding-right:5px;">' + ficheros[i].size + '</td></tr>'
										    }
									    }
									    //Mostrar msg no hay ficheros
									    if(encontrado){
									    	document.getElementById(attachmentFileId + "msgNohayFicheros").style.display="none";
									    }else{
									    	document.getElementById(attachmentFileId + "msgNohayFicheros").style.display="block";
									    }
									}
				                }
			                }
			            ); 
			        },
			        ['aui-io']
			    );
				//Se carga por defecto el mensaje que indica al usuario que no ha seleccionado ningún fichero 
				var msgFicheroNoSeleccionado = '<%=LanguageUtil.get(locale, "vuv.procesing.fileSelector.fileNoSelected")%>';
				document.getElementById('<%=attachmentFileId%>' + "nombreFicheroSeleccionado").innerHTML = msgFicheroNoSeleccionado;
			</script>
		<%
		}else{
		%>
			<%=LanguageUtil.get(locale, "vuv.procesing.fileSelector.folderNotFound") %>
		<%
		}
		%>
	</div>
</div>