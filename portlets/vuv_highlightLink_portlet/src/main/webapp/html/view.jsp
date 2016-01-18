<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="ec.gob.snap.vuv.HighlightLink"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.language.Language"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<!-- <head>
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head> -->
<body>
	<%
		PortletPreferences prefs = renderRequest.getPreferences();
		List<HighlightLink> items = (List<HighlightLink>)renderRequest.getAttribute("items");
		String intro = String.valueOf(renderRequest.getAttribute("intro"));
		Integer firstnumpag = (Integer)renderRequest.getAttribute("firstnumpag");
		
		int start = 0;
		int end = firstnumpag;
		int numPages = (items.size()%firstnumpag == 0) ? items.size()/firstnumpag : items.size()/firstnumpag+1;
		List<HighlightLink> itemOnePage = items;
	%>
<div class="row">
<div id="contenido" class="page-links">
	<div class="Title">
	</div>
	<br>
	<div class="introText">
		<p><c:out value="<%=intro%>" escapeXml="false"/></p>
	</div>
	<form class="form-search">
	<div id="search">
		<input type="text" id="autocomplete" name="<portlet:namespace />search" 
		onkeyup="updateElements(document.getElementById('autocomplete').value)" placeholder="<%=LanguageUtil.get(portletConfig, locale,"search.links")%>">
		<div id="searchicon"><i class="icon-search"></i></div>
		<div id="numresults">${items.size()} <liferay-ui:message key="results"/></div></div>
	</form>
	<div id="links">
		<div id="myToggler" class="content">
		<%
		for(int i=0; i<numPages; i++) {
			if(items.size()>end){
				itemOnePage = items.subList(start, end);
	    	}else{
	    		itemOnePage = items.subList(start, items.size());
	    		end = items.size();
	    	}
			int rest = items.subList(end, items.size()).size();
			start = end; 
			if(firstnumpag > rest){
				end = start + rest;
			}else{
				end = start + firstnumpag;
			}
			%>
			<div id="page" class="page">
			<%
			if(itemOnePage.size() != 0){
				for(HighlightLink item: itemOnePage){
					String clink = item.getLink();
					if(!clink.contains("//")){
						clink = "//" + clink;
					}
					%>
					<div class="onelink">
						<h4 class="header toggler-header-collapsed" onclick="toggleIcon(this)">
							<a class="keyword" href="<%=clink%>" target='_blank'><%=item.getLink() %></a>
							<span class="icono icon-chevron-down"></span>
							<span class="keyword categoria"><%=item.getCategory()%></span>
						</h4>
						<p class="keyword content toggler-content-collapsed"><%=item.getDetail()%></p>
					</div>
					<%
				}
			}
			%></div><%
		}		
		%>
		</div>
		
		<div id="pagination" class="pull-right">
			<ul class="pagination pagination-content">
				<li><a href="#">Prev</a></li>
				<%
				for(int i=1;i<=numPages;i++){
				%>
					<li><a href="#"><%=i %></a></li>
				<%} %>
				<li><a href="#">ddd</a></li>
			</ul>
		</div>
	</div>
</div>
</div>
 <aui:script>
 	var elements = document.getElementsByClassName("keyword");
 	var kwords = [];
 	for(var i=0; i<elements.length; i++) {
 		var split_string = elements[i].textContent.split(" ");
 		for(var j=0; j<split_string.length; j++) {
 			if(split_string[j]!="" && split_string[j].length>2){
 				split_string[j] = split_string[j].replace("[\"", "");
 				split_string[j] = split_string[j].replace("\"]", "");
 				if(!(kwords.indexOf(split_string[j]) > -1)){
 					kwords[kwords.length] = split_string[j];
 				}
 			}
 		}
 	}
 	load();
 	function load(){
 	AUI().use(
         'autocomplete-list', 'aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',
         function (A) {
        	
             new A.AutoCompleteList(
             {
                allowBrowserAutocomplete: 'false',
                activateFirstItem: 'true',
                inputNode: '#autocomplete',
                resultHighlighter:['phraseMatch'], 
				resultFilters:['phraseMatch'],
                render: 'true',
                maxResults: 5,
                source: kwords
            })
        }
    );
     AUI().use('aui-toggler', function(Y) {
			new Y.TogglerDelegate({
				animated : true,
				closeAllOnExpand : true,
				container : '#myToggler',
				content : '.content',
				expanded : false,
				header : '.header',
				transition : {
					duration : 0.2,
					easing : 'cubic-bezier(0, 0.1, 0, 1)'
				}
			});
		});
     AUI().use('aui-pagination', function(Y) {
			var pages = Y.all('.content div.page');
			new Y.Pagination({
				boundingBox : '#pagination',
				strings: {
					next: '&raquo;',
                    prev: '&laquo;'
                  },
				circular : false,
				contentBox : '#pagination .pagination-content',
				on : {
						changeRequest : function(event) {
							var instance = this, state = event.state, lastState = event.lastState;
							if (lastState) {
									pages.item(lastState.page - 1).setStyle('display','none');
							}
							pages.item(state.page - 1).setStyle('display','block');
						}
				},
				page : 1
				}).render();
		});
 	}
</aui:script>
<portlet:resourceURL var="ajaxURL"></portlet:resourceURL>
<script>
function updateElements(key){
       $.ajax({
    	   type: 'POST',
    	   url : '${ajaxURL}',
    	   data: { '<portlet:namespace />keyword': key },
    	   dataType : "json",
    	   success : function(data) {
    		   var start = 0;
    		   var end = <%=firstnumpag%>;
    		   var perpage = <%=firstnumpag%>;
    		   var numPages = (data.length%end == 0) ? data.length/end : data.length/end+1;
    		   var itemOnePage = data;
    		   var html = '<div id="myToggler" class="content">';
    		   for(var i=0; i<numPages; i++) {
    				if(data.length>end){
    					itemOnePage = data.slice(start, end);
    		    	}else{
    		    		itemOnePage = data.slice(start, data.length);
    		    		end = data.length;
    		    	}
    				var rest = data.slice(end, data.length).length;
    				start = end; 
    				if(perpage > rest){
    					end = start + rest;
    				}else{
    					end = start + perpage;
    				}
    				if(i==0){
    					html = html + '<div id="page" class="page">';
    				}else{
    					html = html + '<div id="page" class="page">';
    				}
    				if(itemOnePage.length != 0){
    					for(var j=0;j<itemOnePage.length;j++){
    						html = html + '<div class="onelink"><h4 class="header toggler-header-collapsed"><a class="keyword" href="'
    						+ itemOnePage[j].link + '">' + itemOnePage[j].link + '</a><span class="icono icon-chevron-down"></span><span class="keyword categoria">'
    						+ itemOnePage[j].category + '</span></h4>' + '<p class="keyword content toggler-content-collapsed">' + itemOnePage[j].details + '</p></div>';
    					}
    				}
    				html = html + '</div>';
    			}
    		   html = html + '</div>';
    		   pagi = '<div id="pagination" class="pull-right"><ul class="pagination pagination-content"><li><a href="#">Prev</a></li>';
   				for(var i=1;i<=numPages;i++){
   					pagi = pagi + '<li><a href="#">' + i + '</a></li>';
   				}
   				pagi = pagi + '<li><a href="#">ddd</a></li></ul></div>';
   				$("#numresults").replaceWith("<div id=\"numresults\">" + data.length + "<%=LanguageUtil.get(portletConfig, locale, "n.results")%></div>");
    		   $("#myToggler").replaceWith(html);
    		   $("#pagination").replaceWith(pagi);
    		   load();
    	   },
    	   error: function () {
    		   console.log('Error Occurred');
    	   }
       });
}
function toggleIcon(element){
	var children = element.childNodes;
	for(var i = 0; i<=children.length;i++){
		if(children[i].className == "icono icon-chevron-up"){
			children[i].setAttribute('class', "icono icon-chevron-down");
		}else{
			if(children[i].className == "icono icon-chevron-down"){
				children[i].setAttribute('class', "icono icon-chevron-up");
			}
		}
	}
}
</script>
</body>