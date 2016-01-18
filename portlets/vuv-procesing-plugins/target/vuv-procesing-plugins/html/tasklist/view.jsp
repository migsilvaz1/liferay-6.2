<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />
<theme:defineObjects />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.bootstrap.js"></script>

<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<portlet:renderURL var="dialogURL">
	<portlet:param name="mvcPath" value="/html/tasklist/transactForm.jsp" />
	<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent()%>"/>
</portlet:renderURL>

<% 
String maxResults =  PropsUtil.get("ec.gob.snap.vuv.tasklist.max.results");
Boolean resultsTrunk = SessionMessages.contains(renderRequest,"vuv.tasklist.maximum.messages");
String reservedStatus = PropsUtil.get("ec.gob.snap.vuv.tasklist.task.status.reserved");
String readyStatus = PropsUtil.get("ec.gob.snap.vuv.tasklist.task.status.ready");
String inprogressStatus = PropsUtil.get("ec.gob.snap.vuv.tasklist.task.status.inprogress");
String roleName = "";
List<Role> roles = user.getRoles();
for(Role role: roles){
	if(role.getName().equals(PropsUtil.get("ec.gob.snap.vuv.tasklist.role.ciudadano"))){
		roleName = role.getName();
	}else if(role.getName().equals(PropsUtil.get("ec.gob.snap.vuv.tasklist.role.tramitador"))){
		roleName = role.getName();
	}
}
String userName = user.getScreenName();

if(request.getAttribute("")!= null){
}
%>

<div id="overlay" style="display: hidden;"></div>
<div id="loading" style="display: hidden;">
	<img src="<%=request.getContextPath()%>/images/processing.gif" />
</div>
<h2><liferay-ui:message key="vuv.tasklist.portlet.name"/></h2>
<p class="lead"><liferay-ui:message key="vuv.tasklist.portlet.description"/></p>

<!-- Mensajes de resultado de operación -->
<div id="succesOperationMsgContainer" class="portlet-msg-info" style="display: none;"><%=LanguageUtil.get(locale, "vuv.tasklist.msg.successful")%></div>

<span style="display: none;" class="portlet-msg-info span no-margin-left mtop1" id="maxResultDiv">
	<liferay-ui:message key="vuv.tasklist.maximum.messages" arguments="<%=maxResults%>"/>
</span>

<div class="clearfix"></div>
<!--  define table id for show list of data like search container -->
<div class="link-refresh right margin-0-0-1em"> 
	<a class="btn" onclick="refreshData()">
		<span class="glyphicon glyphicon-refresh"></span>
		<liferay-ui:message key="vuv.tasklist.refresh" />
	</a> 
</div>
<div id="select-process" class="right clear"> 
</div>
<table id="tasks" class="table table-striped stripe table-hover dt-responsive" style="width: auto !important;">

	<thead>

		<tr>

			<th><liferay-ui:message key="vuv.tasklist.estado"/></th>
			
			<th><liferay-ui:message key="vuv.tasklist.caso"/></th>

			<th><liferay-ui:message key="vuv.tasklist.tramite"/></th>

			<th><liferay-ui:message key="vuv.tasklist.step"/></th>

			<th><liferay-ui:message key="vuv.tasklist.lastmodified"/></th>

			<th><liferay-ui:message key="vuv.tasklist.priority"/></th>

			<th><liferay-ui:message key="vuv.tasklist.deadline"/></th>
			
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</thead>
		<tfoot>

		<tr>
			<th><liferay-ui:message key="vuv.tasklist.estado"/></th>

			<th><liferay-ui:message key="vuv.tasklist.caso"/></th>

			<th><liferay-ui:message key="vuv.tasklist.tramite"/></th>

			<th><liferay-ui:message key="vuv.tasklist.step"/></th>

			<th><liferay-ui:message key="vuv.tasklist.lastmodified"/></th>

			<th><liferay-ui:message key="vuv.tasklist.priority"/></th>

			<th><liferay-ui:message key="vuv.tasklist.deadline"/></th>
			
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</tfoot>
	<tbody>
	</tbody>
</table>
<script type="text/javascript">
var jsonData = null;
function refreshData(){
	var table = $('#tasks').DataTable();
	table.ajax.reload();
   	table.draw();
};
</script>
<script type="text/javascript">
$(document).ready(function() {
	var lockSource = '<%=request.getContextPath()%>' + '/images/lock.png';
	var unlockSource = '<%=request.getContextPath()%>' + '/images/unlock.png';
	var ready = '<%=readyStatus%>';
	var reserved =  '<%=reservedStatus%>';
	var inprogress =  '<%=inprogressStatus%>';
	var ciudadano = "<%=PropsUtil.get("ec.gob.snap.vuv.tasklist.role.ciudadano")%>";
	var tramitador = "<%=PropsUtil.get("ec.gob.snap.vuv.tasklist.role.tramitador")%>";
	var role = "<%=roleName%>";
	var userName = "<%=userName%>";
    $('#tasks').dataTable( {
        "processing": true,
        "searching": true,
        "search": {
            "regex": true
          },
        "responsive": true,
        "ajax": "<portlet:resourceURL id='loadDataTable'/>",
        columnDefs: [
                     { className: 'never', targets: [7, 8, 9] }
                   ],
        "columns": [
                    {
                	"className":      "status",
                	"orderable":      false,
                	"data":           "status",
                	"userID":		  "userID",
                	"mRender": function(data, type, row) {
                		var html = '';
                		var asignedUserId = row['userID'];
                		if (data == ready) {
    						html = '<button class="btn btn-info btn-sm reclamar" title="Reclamar">' + '<img src="' + unlockSource + '" /></button>';
    					}else if(data == reserved || data == inprogress){
    						if(userName.toUpperCase() == asignedUserId.toUpperCase()){
    							if(role == ciudadano){
    								html = '<button class="btn btn-info btn-sm tramitable" disabled="true" title="Tramitar"><img src="' + lockSource + '" /></button>';
        						}
        						if(role == tramitador){
        							if(data == reserved){
        								html = '<button class="btn btn-info btn-sm liberar tramitable" title="Liberar"><img src="' + lockSource + '" /></button>';
        							}else{
        								html = '<button class="btn btn-info btn-sm tramitable" disabled="true" title="Tramitar"><img src="' + lockSource + '" /></button>';
        							}
        						}
    						}else{
    							html = '<button class="btn btn-info btn-sm" disabled="true" title="Sin operación"><img src="' + lockSource + '" /></button>';
    						}
    					}
                	    return html;
                	  }
            		},
                    { "data": "processInstanceID", 
                      "defaultContent": "" },
                    { "data": "processName", 
                      "defaultContent": "" },
                    { "data": "taskName", 
                      "defaultContent": "" },
                    { "data": "taskDate", 
                      "defaultContent": "" },
                    { "data": "priority", 
                      "defaultContent": "0", 
                      "className": "glyphicon glyphicon-record priorityCell dt-body-center"},
                    { "data": "deadline", 
                      "defaultContent": "" },
                    { "data": "userID", 
                      "defaultContent": "",
                      "visible": false		},
                    { "data": "taskId", 
                      "defaultContent": "",
                      "visible": false		},
                    { "data": "idProcesoBPM", 
                      "defaultContent": "",
                      "visible": false		}
                ],
    	"drawCallback": function( settings ) {
    			jsonData = settings['aoData'];
     			var maxLen = <%=maxResults%>;
    			var resultsTrunk = <%=SessionMessages.contains(renderRequest,"vuv.tasklist.maximum.messages")%>;
                var maxResultDiv = $('#maxResultDiv');
    			if(resultsTrunk){
                    maxResultDiv.css("display","block");
    			}else{
    				maxResultDiv.css("display","none");
    			}
    		
		  	    $('th.priorityCell').each( function(){
		   	    	var th = $(this);
		   	    	th.removeClass("glyphicon glyphicon-record priorityCell dt-body-center");
		   	    });
		  	    $('th.status').each( function(){
		   	    	var th = $(this);
		   	    	th.removeClass("status");
		   	    });
		  	    
    	  	    $('.priorityCell.dt-body-center').each( function(){
    	   	    	var column = $(this);
    	   	    	var data = column.html();
    	   	    	if (data == "3") {
						column.addClass("red");
					}else if(data == "2"){
						column.addClass("yellow");
					}else if(data == "1" || data == "0"){
						column.addClass("green");
					}
    	   	    });
    	  	  $('.status').each( function(index){
  	   	    	var column = $(this);
  	   	    	var button = column.find("button");
  	   	    	var clases = button.attr('class');
  	   	   		if(clases != undefined){
	  	   	   		if(clases.indexOf("reclamar") != -1){
		   	    		button[0].addEventListener("click", function(event){
		   	    			event.stopPropagation();
		   	    			var idProcesoBPM = $("#tasks").dataTable().fnGetData(index).idProcesoBPM;
		   	    			var processInstanceID = $("#tasks").dataTable().fnGetData(index).processInstanceID;
		   	    			var taskId = $("#tasks").dataTable().fnGetData(index).taskId;
		   	    			$.ajax({
		   	     				type     : "POST",
		   	     				url      : "<portlet:resourceURL id='reclamar'/>",
		   	     				data : ({
			   	     				'<portlet:namespace />idProcesoBPM': idProcesoBPM,
			   	     				'<portlet:namespace />processInstanceId': processInstanceID,
			   	     				'<portlet:namespace />taskId': taskId
		   	     				}),
		   	     				success:function(data)
		   	     				{
		   	     					refreshData();
		   	     				},
		   	     				async : false,
		   	     			});
		   	    		}, false);
		   	    	}else if(clases.indexOf("liberar") != -1){
		   	    		button[0].addEventListener("click", function(event){
		   	    			event.stopPropagation();
		   	    			var idProcesoBPM = $("#tasks").dataTable().fnGetData(index).idProcesoBPM;
		   	    			var processInstanceID = $("#tasks").dataTable().fnGetData(index).processInstanceID;
		   	    			var taskId = $("#tasks").dataTable().fnGetData(index).taskId;
		   	    			$.ajax({
		   	     				type     : "POST",
		   	     				url      : "<portlet:resourceURL id='liberar'/>",
			   	     			data : ({
			   	     				'<portlet:namespace />idProcesoBPM': idProcesoBPM,
			   	     				'<portlet:namespace />processInstanceId': processInstanceID,
			   	     				'<portlet:namespace />taskId': taskId
		   	     				}),
		   	     				success:function(data)
		   	     				{
		   	     					refreshData();
		   	     				},
		   	     				async : false,
		   	     			});
		   	    		}, false);
		   	    	}
  	   	   		}
  	   	    });
    	},
    	"language": {
    	    "lengthMenu": Liferay.Language.get("vuv.tasklist.lengthMenu"),
    	    "loadingRecords": Liferay.Language.get("vuv.tasklist.loading"),
    	    "zeroRecords": Liferay.Language.get("vuv.tasklist.zeroRecords"),
    	    "emptyTable": Liferay.Language.get("vuv.tasklist.zeroRecords"),
    	    "paginate": {
    	        "previous": Liferay.Language.get("vuv.tasklist.previous"),
    	        "next":Liferay.Language.get("vuv.tasklist.next")},
    	    "processing": "",
    	    "info":Liferay.Language.get("vuv.tasklist.info"),
    	    "infoFiltered": Liferay.Language.get("vuv.tasklist.infoFiltered"),
    	    "infoEmpty": Liferay.Language.get("vuv.tasklist.infoEmpty")
    	},
        "initComplete": function () {
            this.api().column(1).every( function () {
                var column = this;
                var select = $('<select><option value="">'+Liferay.Language.get("vuv.tasklist.all.process")+'</option></select>')
                    .appendTo( $('#select-process').empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        }
    } );
});
</script>
<script type="text/javascript">	
	$(document).ready(function() {
	    $('#tasks tfoot th').each( function () {
	        var title = $('#tasks thead th').eq( $(this).index() ).text();
	        var placeHolder = Liferay.Language.get("vuv.tasklist.search")+' '+title;
	        $(this).html( '<input type="text" placeholder="'+placeHolder+'" />' );
	    } );
	 
	    var table = $('#tasks').DataTable();
	    table.columns().every( function () {
	        var that = this;
	 
	        $( 'input', this.footer() ).on( 'keyup change', function () {
	            that
	                .search( this.value,true,true )
	                .draw();
	        } );
	    } );
	    $.fn.dataTable.ext.errMode = 'none';
	    $('#tasks')
	        .on( 'error.dt', function ( e, settings, techNote, message ) {
	            alert( 'Ha ocurrido un error');
	        } )
	        .DataTable();
	} );
</script>
<script type="text/javascript">
$(document).ready(function() {
    $('#tasks tbody').on( 'click', 'td', function () {
   		var fila = this.closest('tr');
   		if(!(this.innerHTML == fila.getElementsByTagName("td")[0].innerHTML)){
	    	var button = fila.getElementsByTagName("td")[0].childNodes[0];
	    	var processInstanceID = fila.getElementsByTagName("td")[1].innerHTML;
	    	var texto = button.className;
	    	var idProcesoBPM;
	    	var taskId;
	    	if(texto.indexOf("tramitable") != 0){
	    		for(var i=0; i<jsonData.length; i++){
	    			var instance = jsonData[i]['_aData'];
	    			if(processInstanceID == instance['processInstanceID']){
	    				idProcesoBPM = instance['idProcesoBPM'];
	   	    			taskId = instance['taskId'];
	    				break;
	    			}
	    		}
	    		var url = '<%=dialogURL%>'+'&idProcesoBPM='+idProcesoBPM+'&processInstanceID='+processInstanceID+'&taskId='+taskId
	    		window.location = url;
	    	}
    	}
    });
} );
</script>
<script type="text/javascript">
	$(document).ajaxStart(function() {
		$("#overlay").show();
		$("#loading").show();
	});
	$(document).ajaxStop(function() {
		$("#overlay").hide();
		$("#loading").hide();
	});
</script>