<%@ include file="/html/init.jsp" %>
<br>
<h2><%=LanguageUtil.get(locale, "misDocumentos.portlet.label.misDocumentos")%></h2>
<%
//Se crea el árbol xml de preferencias
Long folderUsuarioId = DocumentsPortletUtil.getDirectorioUsuario(themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), user.getUserId(), user.getScreenName());
String folderUsuarioIdString = folderUsuarioId == 0? "" : "" + folderUsuarioId; 
StringBundler sb = new StringBundler();

sb.append("<portlet-preferences >");

sb.append("<preference>");
sb.append("<name>");
sb.append("enableRatings");
sb.append("</name>");
sb.append("<value>");
sb.append("true");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("carpetaDelCiudadano");
sb.append("</name>");
sb.append("<value>");
sb.append("true");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("enableCommentRatings");
sb.append("</name>");
sb.append("<value>");
sb.append("true");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("showActions");
sb.append("</name>");
sb.append("<value>");
sb.append("true");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("folderColumns");
sb.append("</name>");
sb.append("<value>");
sb.append("name,num-of-folders,num-of-documents,action");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("fileEntryColumns");
sb.append("</name>");
sb.append("<value>");
sb.append("name,size,action");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("showSubfolders");
sb.append("</name>");
sb.append("<value>");
sb.append("true");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("foldersPerPage");
sb.append("</name>");
sb.append("<value>");
sb.append("20");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("showFolderMenu");
sb.append("</name>");
sb.append("<value>");
sb.append("true");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("showTabs");
sb.append("</name>");
sb.append("<value>");
sb.append("false");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("rootFolderId");
sb.append("</name>");
sb.append("<value>");
sb.append(folderUsuarioIdString);
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("fileEntriesPerPage");
sb.append("</name>");
sb.append("<value>");
sb.append("20");
sb.append("</value>");
sb.append("</preference>");

sb.append("<preference>");
sb.append("<name>");
sb.append("showFoldersSearch");
sb.append("</name>");
sb.append("<value>");
sb.append("true");
sb.append("</value>");
sb.append("</preference>");

sb.append("</portlet-preferences>");
%>

<div id="contenedorPortletEmbebido">
	<liferay-portlet:runtime  portletName='<%="110_INSTANCE_" + user.getUserId()%>' defaultPreferences="<%=sb.toString()%>"/>
</div>
<!-- 
<script>
	function cambiarIconos1(){
		//Cambiar los iconos del listado
		var contenedorPortletEmbebido = document.getElementById("contenedorPortletEmbebido");
		var contenedoresIcono = contenedorPortletEmbebido.getElementsByClassName("entry-thumbnail");
		var newdiv;
		var imagenesContenedor;
		var encontrado;
		var elementoAux;
		for (var i = 0; i < contenedoresIcono.length; i++) {
			imagenesContenedor = contenedoresIcono[i].getElementsByTagName("img");
			for(var j = 0; j < imagenesContenedor.length; j++) {
				encontrado = false;
				if(imagenesContenedor[j].src.indexOf("folder_empty.png") > -1){
					encontrado = true;
					elementoAux = 'fa fa-folder-open';
				}
				if(imagenesContenedor[j].src.indexOf("folder_full_document.png") > -1){
					encontrado = true;
					elementoAux = 'fa fa-folder';
				}
				if(encontrado == true){
					newdiv = document.createElement('i');
					newdiv.className = elementoAux;
					contenedoresIcono[i].appendChild(newdiv);
				}
			}
		}
	}
</script>
<script>
	function cambiarIconos2(){
		//Cambiar los iconos del listado
		var contenedorPortletEmbebido = document.getElementById("contenedorPortletEmbebido");
		var contenedoresIcono = contenedorPortletEmbebido.getElementsByClassName("lfr-menu-list");
		var newdiv;
		var imagenesContenedor;
		var encontrado;
		var elementoAux;
		for (var i = 0; i < contenedoresIcono.length; i++) {
			imagenesContenedor = contenedoresIcono[i].getElementsByTagName("img");
			for(var j = 0; j < imagenesContenedor.length; j++) {
				encontrado = false;
				if(imagenesContenedor[j].id.indexOf("menu_edit") > -1){
					encontrado = true;
					elementoAux = 'fa fa-pencil-square-o';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_move") > -1){
					encontrado = true;
					elementoAux = 'fa fa-arrows';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_permissions") > -1){
					encontrado = true;
					elementoAux = 'fa fa-key';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_move-to-the-recycle-bin") > -1){
					encontrado = true;
					elementoAux = 'fa fa-trash-o';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_add-subfolder") > -1 || imagenesContenedor[j].id.indexOf("menu_add-folder") > -1){
					encontrado = true;
					elementoAux = 'fa fa-folder-o';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_multiple-documents") > -1){
					encontrado = true;
					elementoAux = 'fa fa-files-o';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_add-document") > -1){
					encontrado = true;
					elementoAux = 'fa fa-file-o';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_add-shortcut") > -1){
					encontrado = true;
					elementoAux = 'fa fa-globe';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_access-from-desktop") > -1){
					encontrado = true;
					elementoAux = 'fa fa-desktop';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_descargar") > -1){
					encontrado = true;
					elementoAux = 'fa fa-download';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_checkout-document") > -1){
					encontrado = true;
					elementoAux = 'fa fa-lock';
					console.log("prueba: " + imagenesContenedor[j].parentNode.id);
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_checkin") > -1){
					encontrado = true;
					elementoAux = 'fa fa-unlock-alt';
					imagenesContenedor[j].style.display = "none";
				}
				if(imagenesContenedor[j].id.indexOf("menu_cancel-checkout-document") > -1){
					encontrado = true;
					elementoAux = 'fa fa-reply';
					imagenesContenedor[j].style.display = "none";
				}
				if(encontrado == true){
					newdiv = document.createElement('i');
					newdiv.className = elementoAux;
					imagenesContenedor[j].parentNode.insertBefore(newdiv, imagenesContenedor[j].parentNode.childNodes[0]);
				}
			}
		}
	}	
</script>
<script>
// 	cambiarIconos1();
// 	cambiarIconos2();
</script>
 -->