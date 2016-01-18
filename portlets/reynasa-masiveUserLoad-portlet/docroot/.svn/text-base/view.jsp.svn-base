<%@page import="java.util.LinkedList"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.near.reynasa.masiveLoadUser.model.MasiveLoadUser"%>
<%@page import="com.near.reynasa.masiveLoadUser.service.MasiveLoadUserLocalServiceUtil"%>
<%@ include file="/init.jsp"%>
<portlet:defineObjects />

<jsp:useBean id="utenti" class="java.util.ArrayList"
	type="java.util.List" scope="request" />
<%
String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
PortletPreferences preferences = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
    preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String csvSeparator = preferences.getValue("csvSeparator","EXCEL_NORTH_EUROPE_PREFERENCE");
String csvSep = null;
if (csvSeparator.equals("EXCEL_PREFERENCE")){
	csvSep = ",";
} else if (csvSeparator.equals("STANDARD_PREFERENCE")){
	csvSep = ",";
} else if (csvSeparator.equals("TAB_PREFERENCE")){
	csvSep = "<tab>";
} else {
	csvSep = ";";
}
List<Role> roles = RoleLocalServiceUtil.getRoles(company.getCompanyId());
long parentOrganizationId = OrganizationConstants.ANY_PARENT_ORGANIZATION_ID;
List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(company.getCompanyId(),parentOrganizationId);
String count_good = "";
Integer total_users = 0;
if (Validator.isNotNull(renderRequest.getAttribute("count_good"))) {
	count_good = renderRequest.getAttribute("count_good").toString();
	total_users = utenti.size() + Integer.parseInt(renderRequest.getAttribute("count_good").toString());
}




%>

<portlet:actionURL var="uploadCsvURL" name="uploadCsv">
	<portlet:param name="jspPage" value="/view.jsp" />
</portlet:actionURL>
<liferay-ui:upload-progress id="<%= uploadProgressId %>"
	message="uploading" redirect="<%= uploadCsvURL %>" />
<liferay-ui:success key="success"
	message='<%= LanguageUtil.format(pageContext, "success-read-and-added", new Object [] {count_good, total_users}) %>' />
<liferay-ui:error key="expected-header-not-found-in-the-csv-file"
	message="Expected header not found in the CSV file." />
<liferay-ui:error key="error"
	message="Sorry, an error prevented the upload. Please try again." />

<aui:form action="<%= uploadCsvURL %>" enctype="multipart/form-data"
	method="post">
	<div class="alert alert-info">
		<liferay-ui:message key='<%=LanguageUtil.get(locale, "fichero-debe-ser") %>' />

	</div>
	
	<script>
	function changeFile(){
		var upload = document.getElementById("<portlet:namespace/>fileName").value;
		if(upload != ""){
			var button = document.getElementById("<portlet:namespace/>submit");
			button.disabled = false;
			button.className = "btn btn-primary";
		}else{
			var button = document.getElementById("<portlet:namespace/>submit");
			button.disabled = true;
			button.className = "btn disabled btn-primary";
		}
	}	
	</script>
	
	<aui:fieldset cssClass='fieldset'>
		<aui:input type="file" name="fileName" size="75" label='<%=LanguageUtil.get(locale, "fichero") %>'
			helpMessage='<%=LanguageUtil.get(locale, "carga-fichero") %>' onChange="changeFile()">
			<aui:validator name="acceptFiles">'csv'</aui:validator>
		</aui:input>
		<aui:select label='<%=LanguageUtil.get(locale, "ejecucion") %>' name="executionId" helpMessage='<%=LanguageUtil.get(locale, "modo-ejecucion") %>'
			showEmptyOption="false">
			<aui:option
				label='<%=LanguageUtil.get(locale, "inmediata") %>'
				value="1" />
			<aui:option
				label='<%=LanguageUtil.get(locale, "programada") %>'
				value="2" />				
				
		</aui:select>
		<%
	     if (organizations.size() > 0) {
	     %>
		<aui:select label="organization" name="organizationId"
			helpMessage="select-organization" showEmptyOption="true">
			<%
	                    for (int i = 0; i < organizations.size(); i++) {
	                    	
	                    	Organization organization=(Organization)organizations.get(i);
	                    	String name = organization.getName();
	             %>
			<aui:option label='<%= organization.getName()%>'
				value="<%= organization.getOrganizationId() %>" />
			<%
	                    }
	             %>
		</aui:select>
		<%
	     }
		%>
	</aui:fieldset>
	<aui:button-row>
	
		<%
	 String taglibOnClick = uploadProgressId + ".startProgress(); return true;";
	 %>
		<aui:button name="submit" type="submit" value="carga" 
			onClick="<%= taglibOnClick %>" disabled="true" />
	</aui:button-row>
</aui:form>
<br />


	<table class="table table-bordered table-hover table-striped">
		<thead class="table-columns">
			<tr>
				<th class="table-first-header"><%=LanguageUtil.get(locale, "user") %></th>
				<th><%=LanguageUtil.get(locale, "estado-ejecucion") %></th>
				<th class="table-last-header"><%=LanguageUtil.get(locale, "fecha-peticion") %></th>
				<th><%=LanguageUtil.get(locale, "archivo-procesado") %></th>
				<th><%=LanguageUtil.get(locale, "archivo-errores") %></th>
				
			</tr>
		</thead>
		<tbody class="table-data">
			<%
			
			
			
			List<MasiveLoadUser> listMasiveLoadUserAux=MasiveLoadUserLocalServiceUtil.getMasiveLoadUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<MasiveLoadUser> listMasiveLoadUser= new LinkedList<MasiveLoadUser> ();

			for(int i = listMasiveLoadUserAux.size()-1; i>=0; i--){
				listMasiveLoadUser.add(listMasiveLoadUserAux.get(i));
			}
			for (MasiveLoadUser masiveLoadUser:listMasiveLoadUser) {
				DLFileEntry dlSuccessEntry=null,dlErrorEntry=null;
				if(masiveLoadUser.getSuccessFile()>0){
					dlSuccessEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(masiveLoadUser.getSuccessFile());
				}
				if(masiveLoadUser.getErrorFile()>0){
					dlErrorEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(masiveLoadUser.getErrorFile());
				}
				if(masiveLoadUser.getUserId() == user.getUserId()){

					
					String estadoEjecucion = "";
					if(masiveLoadUser.getStatusExecution()==1){
						estadoEjecucion = LanguageUtil.get(locale, "process");
					}else if(masiveLoadUser.getStatusExecution()==2){
						estadoEjecucion = LanguageUtil.get(locale, "fin-process");
					}else if(masiveLoadUser.getStatusExecution()==3){
						estadoEjecucion = LanguageUtil.get(locale, "programada");
					}
    %>
			<tr>
				<td class="table-cell first"><%= masiveLoadUser.getUserName()%></td>
				<td class="table-cell"><%= estadoEjecucion%></td>
				<td class="table-cell last"><%= masiveLoadUser.getCreateDate()%></td>
				<%if(dlSuccessEntry!=null){ %>
					<td class="table-cell"><a href='<%=themeDisplay.getPortalURL()+"/c/document_library/get_file?uuid="+dlSuccessEntry.getUuid()+"&groupId="+dlSuccessEntry.getGroupId() %>' ><%= dlSuccessEntry.getTitle()%></a></td>
				<%}else{ %>
					<td class="table-cell"></td>
				<%} %>
				
				<td class="table-cell">
				<input class="btn btn-large btn-primary green" type="button" value=<%=LanguageUtil.get(locale, "export.csv")%>
    onClick="location.href = '<portlet:resourceURL><portlet:param name="format" value="csv" /><portlet:param name="id" value="<%=String.valueOf(masiveLoadUser.getSuccessFile()) %>" /></portlet:resourceURL>'" />
				</td>
				
				
						
				
			</tr>
			<%
				}
	}
	%>
		</tbody>
	</table>




