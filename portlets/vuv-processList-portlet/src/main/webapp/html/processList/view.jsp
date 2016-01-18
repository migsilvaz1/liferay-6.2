<%@ include file="/html/processList/init.jsp" %>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dataTables.bootstrap.js"></script>

<portlet:resourceURL var="getProcessResourceURL"></portlet:resourceURL>

<% 
// String maxResults =  PropsUtil.get("ec.gob.snap.vuv.tasklist.max.results");
String maxResults = "100";
%>
<h2><liferay-ui:message key="vuv.processlist.portlet.name"/></h2>
<%-- <p class="lead"><liferay-ui:message key="vuv.tasklist.portlet.description"/></p> --%>
<span style="display: none;" class="portlet-msg-info span no-margin-left mtop1" id="maxResultDiv">
	<liferay-ui:message key="vuv.processlist.maximum.messages" arguments="<%=maxResults%>"/>
</span>
<div class="clearfix"></div>
<!--  define table id for show list of data like search container -->
<div class="link-refresh right margin-0-0-1em"> 
	<a class="btn" onclick="refreshData()">
		<span class="glyphicon glyphicon-refresh"></span>
		<liferay-ui:message key="vuv.processlist.portlet.label.refresh" />
	</a> 
</div>
<div id="select-process" class="right clear"> 
</div>
<table id="processes" class="table table-striped stripe table-hover dt-responsive" style="width: auto !important;">
	<thead>
		<tr>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.id"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.descripcionProceso"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.fechaInicio"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.fechaFin"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.documentosAportados"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.documentosGenerados"/></th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.id"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.descripcionProceso"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.fechaInicio"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.fechaFin"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.documentosAportados"/></th>
			<th><liferay-ui:message key="vuv.processlist.portlet.label.documentosGenerados"/></th>
		</tr>
	</tfoot>
	<tbody>
	</tbody>
</table>
<!-- Función para recargar datos de la tabla -->
<script type="text/javascript">
	function refreshData(){
		var table = $('#processes').DataTable();
		table.ajax.reload();
	   	table.draw();
	};
</script>
<!-- Función para rellenar tabla y combo de filtro -->
<script type="text/javascript">
$(document).ready(function() {
    $('#processes').dataTable( {
        "processing": true,
        "searching": true,
        "search": {
            "regex": true
          },
        "responsive": true,
        "ajax": "<%=getProcessResourceURL%>",
        "columns":[
			{"data": "processCode", "defaultContent": ""},
			{"data": "processName", "defaultContent": ""},
			{"data": "processDate", "defaultContent": ""},
			{"data": "processDateFinalizacion", "defaultContent": ""},
			{"data": "processDocumentosAportados", "defaultContent": ""},
			{"data": "processDocumentosGenerados", "defaultContent": ""}
		],
    	"drawCallback": function( settings ) {
 			var maxLen = <%=maxResults%>;
			var resultsTrunk = <%=SessionMessages.contains(renderRequest,"vuv.processlist.maximum.messages")%>;
            var maxResultDiv = $('#maxResultDiv');
			if(resultsTrunk){
                maxResultDiv.css("display","block");
			}else{
				maxResultDiv.css("display","none");
			}
		},
    	"language": {
    	    "lengthMenu": Liferay.Language.get("vuv.processlist.lengthMenu"),
    	    "loadingRecords": Liferay.Language.get("vuv.processlist.loading"),
    	    "zeroRecords": Liferay.Language.get("vuv.processlist.zeroRecords"),
    	    "emptyTable": Liferay.Language.get("vuv.processlist.zeroRecords"),
    	    "paginate": {
    	        "previous": Liferay.Language.get("vuv.processlist.previous"),
    	    	"next":Liferay.Language.get("vuv.processlist.next")
    	    },
    	    "processing": "",
    	    "info":Liferay.Language.get("vuv.processlist.info"),
    	    "infoFiltered": Liferay.Language.get("vuv.processlist.infoFiltered"),
    	    "infoEmpty": Liferay.Language.get("vuv.processlist.infoEmpty")
    	},
        "initComplete": function () {
            this.api().column(1).every( function () {
                var column = this;
                var select = $('<select><option value="">'+Liferay.Language.get("vuv.processlist.all.process")+'</option></select>')
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
<!-- Función para filtro de texto por columna -->
<script type="text/javascript">	
	$(document).ready(function() {
	    $('#processes tfoot th').each( function () {
	        var title = $('#processes thead th').eq( $(this).index() ).text();
	        var placeHolder = Liferay.Language.get("vuv.processlist.search")+' '+title;
	        $(this).html( '<input type="text" placeholder="'+placeHolder+'" />' );
	    } );
	    var table = $('#processes').DataTable();
	    table.columns().every( function () {
	        var that = this;
	        $( 'input', this.footer() ).on( 'keyup change', function () {
	            that
	                .search( this.value,true,true )
	                .draw();
	        } );
	    } );
	} );
</script>