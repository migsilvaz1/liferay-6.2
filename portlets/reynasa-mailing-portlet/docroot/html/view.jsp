<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.near.reynasa.impl.action.UsuarioTOActionImpl"%>
<%@page import="com.near.reynasa.interfaces.action.UsuarioTOAction"%>
<%@page import="com.near.reynasa.interfaces.TO.UsuarioTO"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.near.reynasa.interfaces.TO.EmpleadoTO"%>
<%@page import="com.near.reynasa.interfaces.TO.ClienteTO"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>

<%@ include file="init.jsp"%>
<portlet:actionURL var="sendMailMessageActionURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
<portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="sendMailMessage"/>
</portlet:actionURL>

<portlet:actionURL var="loadUsersActionURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
<portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="loadUsers"/>
</portlet:actionURL>
<portlet:actionURL var="backLoadUserURL" name="backLoadUsers" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
</portlet:actionURL>

<% 
if(SessionMessages.contains(renderRequest.getPortletSession(),"mail-send-success")){%>
<liferay-ui:success key="mailing.success" message="Mail has been send successfully." />
<%}
	List<ClienteTO> clientesResult = (List) request.getAttribute("clientesList");
	List<EmpleadoTO> empleadosResult = (List) request.getAttribute("empleadosList");
	
%>
<div id="filter" <%if(request.getAttribute("user-results") != null){ %> style="display: none;" <%} %>>
<%if(SessionErrors.contains(renderRequest.getPortletSession(), "mailing-no-results")){%>
<div class="portlet-msg-info"> 
<liferay-ui:message  key="mailing-no-results"></liferay-ui:message>
</div>
<%}else{ %>
<div class="portlet-msg-info"> 
<liferay-ui:message  key="mailing-filter-to-start"></liferay-ui:message>
</div>

<%}
%>
	<aui:form action="<%=loadUsersActionURL%>" method="post"
		name="loadUsersForm">
		<div class="span3 right">
			<aui:field-wrapper label="Perfil Seleccionado: ">
				<aui:select id="receiver" name="receiver" label="">
					<aui:option value="client">Clientes</aui:option>
					<aui:option value="employee">Empleados</aui:option>
				</aui:select>
			</aui:field-wrapper>
		</div>
		<div class="clearfix"></div>
		<div class="span3 no-margin-left">
			<aui:select label="mailing.chain" name="cadena" id="cadena"
				cssClass="container-select-mailing" showEmptyOption="true">
				<c:if test="${not empty cadenaList}">
					<optgroup label="<liferay-ui:message key="Select"/>">
						<c:forEach items="${cadenaList.entrySet()}" var="cadena">
							<aui:option value="${cadena.getKey()}">${cadena.getValue()}</aui:option>
						</c:forEach>
					</optgroup>
				</c:if>
			</aui:select>
			<aui:select label="mailing.zone" name="zona" id="zona"
				cssClass="container-select-mailing" showEmptyOption="true">
				<c:if test="${not empty zonaList}">
					<optgroup label="<liferay-ui:message key="Select"/>">
						<c:forEach items="${zonaList.entrySet()}" var="zona">
							<aui:option value="${zona.getKey()}">${zona.getValue()}</aui:option>
						</c:forEach>
					</optgroup>
				</c:if>
			</aui:select>
			<aui:input label="mailing.clasification" name="clasificacion"
				id="clasificacion" cssClass="container-select-mailing" />
		</div>
		<div class="span3">

			<aui:select label="mailing.business.type" name="tipoNegocio"
				id="tipoNegocio" cssClass="container-select-mailing"
				showEmptyOption="true">
				<c:if test="${not empty tipoNegocioList}">
					<optgroup label="<liferay-ui:message key="Select"/>">
						<c:forEach items="${tipoNegocioList.entrySet()}" var="tipoNegocio">
							<aui:option value="${tipoNegocio.getKey()}">${tipoNegocio.getValue()}</aui:option>
						</c:forEach>
					</optgroup>
				</c:if>
			</aui:select>
			<aui:select label="mailing.comercial" name="comercial" id="comercial"
				cssClass="container-select-mailing" showEmptyOption="true">
				<c:if test="${not empty comercialList}">
					<optgroup label="<liferay-ui:message key="Select"/>">
						<c:forEach items="${comercialList.entrySet()}" var="comercial">
							<aui:option value="${comercial.getKey()}">${comercial.getValue()}</aui:option>
						</c:forEach>
					</optgroup>
				</c:if>
			</aui:select>
		</div>
		<div class="span3">
			<aui:select label="mailing.delegation" name="delegacion"
				id="delegacion" cssClass="container-select-mailing"
				showEmptyOption="true">
				<c:if test="${not empty delegacionList}">
					<optgroup label="<liferay-ui:message key="Select"/>">
						<c:forEach items="${delegacionList.entrySet()}" var="delegacion">
							<aui:option value="${delegacion.getKey()}">${delegacion.getValue()}</aui:option>
						</c:forEach>
					</optgroup>
				</c:if>
			</aui:select>
			<aui:select label="mailing.department" name="departamento"
				id="departamento" cssClass="container-select-mailing onlyEmployee"
				showEmptyOption="true">
				<c:if test="${not empty departamentoList}">
					<optgroup label="<liferay-ui:message key="Select"/>">
						<c:forEach items="${departamentoList.entrySet()}" var="departamento">
							<aui:option value="${departamento.getKey()}">${departamento.getValue()}</aui:option>
						</c:forEach>
					</optgroup>
				</c:if>
			</aui:select>
		</div>
		<div class="span3 no-break">
			<aui:input name="mailing.clasification" type="checkbox"
				value="<%= true %>" cssClass="container-select-mailing" />
			<aui:input name="mailing.promotion.points" type="checkbox"
				value="<%= true %>" cssClass="container-select-mailing" />
			<aui:input name="mailing.registered" type="checkbox"
				value="<%= true %>" cssClass="container-select-mailing" />
			<div class="onlyClient">
				<aui:input name="mailing.travel.request" type="checkbox"
					value="<%= true %>" cssClass="container-select-mailing onlyClient" />
			</div>
		<div class="onlyClient">
			<aui:input name="mailing.cash.request" type="checkbox"
				value="<%= true %>" cssClass="container-select-mailing onlyClient" />
		</div>
		</div>
		<div class="span8">
			<br />
			<aui:layout>
				<aui:column cssClass="right">
					<aui:button type="submit" value="find" name="submit" onClick=""></aui:button>
				</aui:column>
			</aui:layout>
		</div>

		<div class="clearfix"></div>
		<br />
		<div class="hr-mailing span11"></div>
		<br />
	</aui:form>
</div>

<%
	String typeReceiver = "";
	if(request.getAttribute("typeReceiver")!= null){
		typeReceiver = (String) request.getAttribute("typeReceiver");
	}
	List<KeyValuePair> leftList = new ArrayList<KeyValuePair>();
	UsuarioTOAction usersAction2 = new UsuarioTOActionImpl();
	for (ClienteTO userSelected: clientesResult) {
		String nameMail = usersAction2.findByUserCode(userSelected.getCodUsuario()).getNombre() + " "+ usersAction2.findByUserCode(userSelected.getCodUsuario()).getApellidos()+ " (" + userSelected.getCorreo() + ")";
		leftList.add(new KeyValuePair(String.valueOf(clientesResult.indexOf(userSelected)), nameMail));
	}
	for (EmpleadoTO userSelected: empleadosResult) {
		String nameMail = usersAction2.findByUserCode(userSelected.getCodigoUsuario()).getNombre() + " "+ usersAction2.findByUserCode(userSelected.getCodigoUsuario()).getApellidos()+  " (" + userSelected.getCorreo() + ")";
		leftList.add(new KeyValuePair(String.valueOf(empleadosResult.indexOf(userSelected)), nameMail));
	}

	List<KeyValuePair> rightList = new ArrayList<KeyValuePair>();
	
	UsuarioTOAction usersAction = new UsuarioTOActionImpl();

%>
<div id="mail-edition-box" <%if(request.getAttribute("user-results") == null){ %> style="display: none;" <%} %>>
<div class="w100 center chartBack" >
	<liferay-ui:header
	    backURL = "<%=backLoadUserURL %>"
	    title='mailing.back.to.filter'
	/>
</div>
<aui:form action="<%=sendMailMessageActionURL%>" method="post" name="sendMailForm">
<div id="user-move-boxes">
<br/>
	<div class="center w90">
	<liferay-ui:input-move-boxes leftBoxName="availableValues"
		leftList="<%=leftList%>" leftReorder="false" cssClass="mailing-move-boxes"
		leftTitle="Usuarios filtrados" 
		rightBoxName="selectedValues" rightList="<%=rightList%>"
		rightTitle="Enviar a..."/>
	<aui:input type="hidden" name="senderEmailAddess" value="${user.displayEmailAddress}"></aui:input>
	<aui:input name="receiversEmailAddress" type="hidden" />
	<aui:input name="typeReceiver" type="hidden" value="<%=typeReceiver%>"/>

				<div class="moveAll">
					<div class="span5"></div>
					<div class="inner span1">
						<div class="toolbar-content yui3-widget component toolbar">
							<div class="btn-group btn-group-horizontal">
								<button id="allToLeft" class="btn" type="button"
									onclick="toLeft()">
									<i class="icon-backward"></i>
								</button>
								<button id="allToRight" class="btn" type="button"
									onclick="toRight()">
									<i class="icon-forward"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
	<div class="clearfix"></div>
</div>
		<aui:input label="mailing.mail.subject" name="mailSubject"
			id="mailSubject" type="text" wrapperCssClass="w50" cssClass="wr100" required="true" />
		<aui:input label="mailing.mail.campaign" name="mailCampaign"
			id="mailCampaign" type="text" wrapperCssClass="w50" cssClass="wr100" required="true" />
		<liferay-ui:input-editor name="mailBody"></liferay-ui:input-editor>

		<div class="control-group btn-submit btn-group-horizontal right">
			<aui:button value="submit" name="submit" type="submit"
				onClick="return checkValues();"></aui:button>
			<button type="button" id="showModal" class="btn btn-primary"
				onclick="actualizar()"><%=LanguageUtil.get(locale, "mail.previsualizacion")%></button>
		</div>
		<div class="clearfix"></div>
		<div class="definition-of-terms">
			<h4>
				<liferay-ui:message key="definition-of-terms" />
			</h4>
			<dl>
				<dt class="span3 no-margin-left">[$NOMBRE_DEL_CLIENTE$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.client.name" />
				</dd>
				<dt class="span3 no-margin-left">[$NUMERO_DEL_CLIENTE$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.client.number" />
				</dd>
				<dt class="span3 no-margin-left">[$NOMBRE_DEL_EMPLEADO$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.employee.name" />
				</dd>
				<dt class="span3 no-margin-left">[$NUMERO_DEL_EMPLEADO$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.employee.number" />
				</dd>
				<dt class="span3 no-margin-left">[$NOMBRE_DEL_CENTRO$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.center.name" />
				</dd>
				<dt class="span3 no-margin-left">[$NUMERO_DEL_CENTRO$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.center.number" />
				</dd>
				<dt class="span3 no-margin-left">[$NOMBRE_DEL_USUARIO$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.user.name" />
				</dd>
				<dt class="span3 no-margin-left">[$IMPORTE_DE_FACTURACION$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.billing.amount" />
				</dd>
				<dt class="span3 no-margin-left">[$PUNTOS_DE_FACTURACION$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.billing.points" />
				</dd>
				<dt class="span3 no-margin-left">[$PUNTOS_DE_PROMOCION$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.promotion.points" />
				</dd>
				<dt class="span3 no-margin-left">[$PUNTOS_CONS_FACTURACION$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.billing.consumed.points" />
				</dd>
				<dt class="span3 no-margin-left">[$PUNTOS_CONS_PROMOCION$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.consumed.promotion.points" />
				</dd>
				<dt class="span3 no-margin-left">[$PUNTOS_DISP_FACTURACION$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.billing.available.points" />
				</dd>
				<dt class="span3 no-margin-left">[$PUNTOS_DISP_PROMOCION$]</dt>
				
				<dd class="span3">
					<liferay-ui:message key="mailing.promotion.available.points" />
				</dd>
			</dl>

		</div>

	</aui:form>
</div>


<div class="yui3-skin-sam">
    <div id="modal"></div>
</div>

<script type="text/javascript">
	var bodyContent="";
	var modal;
	var subject ="";
	window.onload = function(){
		YUI().use(
				  'aui-modal',
				  function(Y) {
				    modal = new Y.Modal(
				      {
				        bodyContent: bodyContent,
				        centered: true,
				        destroyOnHide: false,
				        headerContent: '<h3>'+subject+'</h3>',
				        modal: true,
				        render: '#modal',
				        resizable: {
				          handles: 'b, r'
				        },
				        visible: false,
				        width: 1000
				      }
				    ).render();

				    modal.addToolbar(
				      [
				        {
				          label: 'Cancel',
				          on: {
				            click: function() {
				              modal.hide();
				            }
				          }
				        }
				      ]
				    );

				    Y.one('#showModal').on(
				      'click',
				      function() {
				        modal.show();
				      }
				    );
				  }
				);
	}
	
	function actualizar() {
		//Popup values
		var nombreDelCliente = "";
		var numeroDelCliente = "";
		var nombreDelEmpleado = "";
		var numeroDelEmpleado = "";
		var nombreDelCentro = "";
		var numeroDelCentro = "";
		var nombreDelUsuario = "";
		var importeDeFacturacion = "";
		var puntosDeFacturacion = "";
		var puntosDePromocion = "";
		var puntosConsumidosDeFacturacion = "";
		var puntosConsumidosDePromocion = "";
		var puntosDisponiblesDeFacturacion = "";
		var puntosDisponiblesDePromocion = " ";
		var email = "";
		
		var selectedValues = Liferay.Util.listSelect('#<portlet:namespace/>selectedValues');
		var indice = selectedValues[0];
		<%for(int i = 0; i<clientesResult.size();i++){%>
			if('<%=i%>' == indice){
				
					nombreDelCliente = '<%=clientesResult.get(i).getNombre()%>';
					numeroDelCliente = '<%=clientesResult.get(i).getNumero()%>';
					nombreDelCentro = '<%=clientesResult.get(i).getNombreCentro()%>';
					numeroDelCentro = '<%=clientesResult.get(i).getNumeroCentro()%>';
					nombreDelUsuario = '<%=usersAction.findByUserCode(clientesResult.get(i).getCodUsuario()).getNombre()%>';
					importeDeFacturacion = '<%=clientesResult.get(i).getImporteFacturacion()%>';
					puntosDeFacturacion = '<%=clientesResult.get(i).getPuntosFacturacion()%>';
					puntosDePromocion = '<%=clientesResult.get(i).getPuntosPromocion()%>';
					puntosConsumidosDeFacturacion = '<%=clientesResult.get(i).getPuntosConsumidosFacturacion()%>';
					puntosConsumidosDePromocion = '<%=clientesResult.get(i).getPuntosConsumidosPromocion()%>';
					puntosDisponiblesDeFacturacion = '<%=clientesResult.get(i).getPuntosDisponiblesFacturacion()%>';
					puntosDisponiblesDePromocion = '<%=clientesResult.get(i).getPuntosDisponiblesPromocion()%>';
					
					email = '<%=clientesResult.get(i).getCorreo()%>';
			}
			
		<%}%>
		<%for(int i = 0; i<empleadosResult.size();i++){%>
		if('<%=i%>' == indice){
			
			nombreDelEmpleado = '<%=empleadosResult.get(i).getNombre()%>';
			numeroDelEmpleado = '<%=empleadosResult.get(i).getNumero()%>';
			nombreDelUsuario = '<%=usersAction.findByUserCode(empleadosResult.get(i).getCodigoUsuario()).getNombre()%>';
			puntosDePromocion = '<%=empleadosResult.get(i).getPuntosPromocion()%>';
			puntosConsumidosDePromocion = '<%=empleadosResult.get(i).getPuntosConsumidosPromocion()%>';
			puntosDisponiblesDePromocion = '<%=empleadosResult.get(i).getPuntosDisponiblesPromocion()%>';
			
			
			email = '<%=empleadosResult.get(i).getCorreo()%>';
		
		}
		
	<%}%>
	
		var send = document
				.getElementById("<portlet:namespace/>senderEmailAddess").value;
		var to = email;
	subject = document.getElementById("<portlet:namespace/>mailSubject").value;
	var mailCampaign = document.getElementById("<portlet:namespace/>mailCampaign").value;
	var mailBody = window.<portlet:namespace />mailBody.getHTML();
	
	mailBody = mailBody.replace("[$NOMBRE_DEL_CLIENTE$]", nombreDelCliente); 
	mailBody = mailBody.replace("[$NUMERO_DEL_CLIENTE$]", numeroDelCliente); 
	mailBody = mailBody.replace("[$NOMBRE_DEL_EMPLEADO$]", nombreDelEmpleado); 
	mailBody = mailBody.replace("[$NUMERO_DEL_EMPLEADO$]", numeroDelEmpleado); 
	mailBody = mailBody.replace("[$NOMBRE_DEL_CENTRO$]", nombreDelCentro); 
	mailBody = mailBody.replace("[$NUMERO_DEL_CENTRO$]", numeroDelCentro); 
	mailBody = mailBody.replace("[$NOMBRE_DEL_USUARIO$]", nombreDelUsuario); 
	mailBody = mailBody.replace("[$IMPORTE_DE_FACTURACION$]", importeDeFacturacion); 
	mailBody = mailBody.replace("[$PUNTOS_DE_FACTURACION$]", puntosDeFacturacion); 
	mailBody = mailBody.replace("[$PUNTOS_DE_PROMOCION$]", puntosDePromocion); 
	mailBody = mailBody.replace("[$PUNTOS_CONS_FACTURACION$]", puntosConsumidosDeFacturacion);
	mailBody = mailBody.replace("[$PUNTOS_CONS_PROMOCION$]", puntosConsumidosDePromocion);
	mailBody = mailBody.replace("[$PUNTOS_DISP_FACTURACION$]", puntosDisponiblesDeFacturacion);
	mailBody = mailBody.replace("[$PUNTOS_DISP_PROMOCION$]", puntosDisponiblesDePromocion);

		
	bodyContent = "to: "+to+"</br>"+"<h4>"+mailCampaign+"</h4>"+"</br>"+mailBody;
	
	YUI().use(
			  'aui-modal',
			  function(Y) {
			    modal = new Y.Modal(
			      {
			        bodyContent: bodyContent,
			        centered: true,
			        destroyOnHide: false,
			        headerContent: '<h3>'+subject+'</h3>',
			        modal: true,
			        render: '#modal',
			        resizable: {
			          handles: 'b, r'
			        },
			        visible: false,
			        width: 1000
			      }
			    ).render();

			    modal.addToolbar(
			      [
			        {
			          label: 'Cancel',
			          on: {
			            click: function() {
			              modal.hide();
			            }
			          }
			        }
			      ]
			    );

			    Y.one('#showModal').on(
			      'click',
			      function() {
			        modal.show();
			      }
			    );
			  }
			);
	
}

</script>




<aui:script use="aui-base">
       var receiverOption = A.one('#<portlet:namespace />receiver');
       var leftSelector = A.one('.left-selector-column');
       var rightSelector = A.one('.right-selector-column');
       
       leftSelector.replaceClass ('span4','span5');
       rightSelector.replaceClass ('span4','span5');
       
       
       receiverOption.on('click', function(event) {
	    	   	  var radioValue = receiverOption.get('value');
	    	   	  if(radioValue == 'client'){
	    	   		  var inputs = A.all('.onlyClient');
	    	   		  inputs.each(function(){
	    	   			  var currentInput = this;
	    	   			  currentInput.removeAttribute('disabled');
	    	   		  });
	    	   		  var inputs = A.all('.onlyEmployee');
	    	   		  inputs.each(function(){
	    	   			  var currentInput = this;
	    	   			  currentInput.set('disabled','true');
	    	   		  });
	    	   	  }else if(radioValue == 'employee'){
	    	   		  var inputs = A.all('.onlyClient');
	    	   		  inputs.each(function(){
	    	   			  var currentInput = this;
	    	   			  currentInput.set('disabled','true');
	    	   		  });
	    	   		  var inputs = A.all('.onlyEmployee');
	    	   		  inputs.each(function(){
	    	   			  var currentInput = this;
	    	   			  currentInput.removeAttribute('disabled');
	    	   		  });
	    	   	  }
	       });
    	   
</aui:script>

<aui:script use="liferay-util-list-fields">
A.one('#<portlet:namespace/>sendMailForm').on(
		'submit',
		function(event) {
			var selectedValues = Liferay.Util
					.listSelect('#<portlet:namespace/>selectedValues');
			A.one('#<portlet:namespace/>receiversEmailAddress').val(selectedValues);
			submitForm('#<portlet:namespace/>sendMailForm');
			
		});
</aui:script>

<script type="text/javascript">
 
 YUI().use(
		  'aui-toggler',
		  function(Y) {
		    new Y.TogglerDelegate(
		      {
		        animated: true,
		        closeAllOnExpand: false,
		        container: '#user-move-boxes',
		        content: '.content',
		        expanded: true,
		        header: '.header',
		        transition: {
		          duration: 0.2,
		          easing: 'cubic-bezier(0, 0.1, 0, 1)'
		        }
		      }
		    );
		  }
		);

 </script>
<script type="text/javascript">
 function toLeft(){
	 var from = document.getElementById("<portlet:namespace/>selectedValues");
	 var to = document.getElementById("<portlet:namespace/>availableValues");
	 var elems = document.getElementById("<portlet:namespace/>selectedValues").options;
	 var num = elems.length;
	 for (i = 0; i < num; i++) {
		 to.appendChild(elems[0]);
	 }
 }
 function toRight(){
	 var from = document.getElementById("<portlet:namespace/>availableValues");
	 var to = document.getElementById("<portlet:namespace/>selectedValues");
	 var elems = document.getElementById("<portlet:namespace/>availableValues").options;
	 var num = elems.length;
	 for (i = 0; i < num; i++) {
		 to.appendChild(elems[0]);
	 }
 }
 function checkValues(){
	 var dest = document.getElementById("<portlet:namespace/>selectedValues").options;
	 var body = window.<portlet:namespace />editor.getHTML();
	 if(dest.length == 0){
		 alert("Debe seleccionar al menos un destinatario");
		 return false;
	 }
	 if("" == ""){
		 return confirm("El correo está en blanco. ¿Desea continuar de todos modos?");
	 }
 }
 </script>