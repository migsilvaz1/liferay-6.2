<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.language.Language"%>
<%@page import="com.liferay.portlet.journal.model.JournalStructureAdapter"%>
<%@page import="com.liferay.portlet.journal.model.JournalStructureConstants"%>
<%@page import="com.liferay.portal.kernel.xml.Node"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil"%>
<%@page import="com.liferay.portal.kernel.xml.Document"%>
<%@page import="com.liferay.portal.kernel.xml.DocumentException"%>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalStructure"%>
<%@page import="com.liferay.portlet.journal.model.JournalTemplate"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@include file="/html/init.jsp" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<div id="portlet-content">
<%List<DDMStructure> structures = DDMStructureLocalServiceUtil.getStructures();
DDMStructure structure = null;
Map<String, Map<String, String>> attributes = null;
for(DDMStructure st : structures){
	if(st.getStructureKey().equals(PropsUtil.get("faq.structure")) && st.getGroupId() == themeDisplay.getScopeGroupId()){
		structure = st;
	}
}
List<String> opciones = new LinkedList<String>();
// Categories vocabulary
AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getScopeGroupId(), PropsUtil.get("faq.vocabulary"));
if(vocabulary != null && vocabulary.getCategories() != null){
	List<AssetCategory> categories = vocabulary.getCategories();
	for(AssetCategory ac : categories){
		if(ac.getName() != "" && ac.getName() != "[]"){
		opciones.add(ac.getName());
		}
	}
}
//AssetCategoryLocalServiceUtil

/*if(structure != null){
	
	attributes = structure.getFieldsMap(locale.toString());
	Map<String, String> category = attributes.get("category");
	List<String> options = structure.getChildrenFieldNames("category");
	for(String op : options){
		opciones.add(structure.getFieldLabel(op, locale.toString()));
	}
} */

%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
	<%= htmlCodeFromEditorPlacedHere != ""? htmlCodeFromEditorPlacedHere : LanguageUtil.get(locale,"init.htmlCodeFromEditorPlacedHere" ) %>
	<div class="faq-form-wrapper span12">
	<form class="navbar-search right" onkeypress="return anular(event)">
		<select onchange="updateElements(this.value)">
			<option value="" selected="selected"><%=LanguageUtil.get(locale, "tag.categoria") %></option>
			<%
			for(String op: opciones){
				%>
				<option value="<%= op %>"><%= op %></option>
				<%
			}
				
			%>
		</select>
  		<input type="text" class="search-query" placeholder="<%=LanguageUtil.get(locale, "tag.search") %>" onkeyup="updateElements(this.value)"/>
	</form>
	</div>
	
	<div id="tablaContenidos" class="toc span12" style="display: <%=(viewContentTable!="" && viewContentTable.equals("true")) || viewContentTable==""? "inherit" : "none"%>">
		<div id="myToggler" class="collapsebox">
			<div id="myTogglerHeader" class="contentTable header toggler-header toggler-header-collapsed">
			<h4> <%=LanguageUtil.get(locale, "tabla.contenidos") %>  </h4> <h4 id="myTogglerExpand">[-]</h4>
			</div>
			<div class="toc-index content toggler-content-collapsed">
				<ol>
<%
List<JournalArticle> structureArticlesInit = JournalArticleLocalServiceUtil.getStructureArticles(themeDisplay.getScopeGroupId(), PropsUtil.get("faq.structure"));
List<JournalArticle> structureArticles = new LinkedList<JournalArticle>();
for(JournalArticle ja : structureArticlesInit){
	if(ja.isApproved() == true && ja.isExpired() == false && ja.isDenied() == false && ja.isInactive() == false && JournalArticleLocalServiceUtil.isLatestVersion(themeDisplay.getScopeGroupId(),ja.getArticleId(),ja.getVersion())){
		structureArticles.add(ja);
	}
}
List<JournalArticle> structureArticlesAux = structureArticles;


Date now = new Date();
for (JournalArticle element : structureArticles) {
	if (element.getExpirationDate() == null || element.getExpirationDate().after(now)) {
		Document document = null;
			document = SAXReaderUtil.read(element.getContentByLocale(locale.toString()));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='"  + "faq" + "']/dynamic-content");
			List<AssetCategory> categoriesList = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), element.getResourcePrimKey());

	%>		

					<li class="toc-level-1" class="span11"><a href="#<%=element.getArticleId()%>-link" class="wikipage" onclick="linkShow(<%=element.getArticleId()%>);"><%=node.getText()%></a><i><%= categoriesList.size() > 0 ?categoriesList.get(0).getName() : "" %></i></li>
				

<%

	}
}
%>
</ol>
			</div>
		</div>
	</div>

<%
int pageSize = 10;
if(pageElements != ""){
pageSize = Integer.parseInt(pageElements);
}
int start = 0;
int end = pageSize;
int numPages = (structureArticles.size()%pageSize == 0) ? structureArticles.size()/pageSize : structureArticles.size()/pageSize+1;
%>
<div id="items" class="content-pagination faq-results-wrapper">
<%
			    for(int i = 0; i < numPages; i++){
			    	if(structureArticles.size()>end){
			    		structureArticlesAux = structureArticles.subList(start, end);
			    	}else{
			    		structureArticlesAux = structureArticles.subList(start, structureArticles.size());
			    		end = structureArticles.size();
			    	}
					int rest = structureArticles.subList(end, structureArticles.size()).size();
					start = end; 
					if(pageSize > rest){
						end = start + rest;
					}else{
						end = start + pageSize;
					}
%>
<div id="page" class="page" style="display: none;">
<div id="results">
<%
if(structureArticlesAux.size() != 0){
	for(JournalArticle a : structureArticlesAux){
		if (a.getExpirationDate() == null || a.getExpirationDate().after(now)) {
		String content = JournalContentUtil.getContent(themeDisplay.getScopeGroupId(), a.getArticleId(), PropsUtil.get("faq.template"), themeDisplay.getLocale().toString(), themeDisplay);
		%>  
		<%=content%>
		<%
		}
	}
}



%>
</div>
</div>

<%} %>
<div id="pagination" class="button-row">

				<ul class="pagination pagination-content">
					<li><a href="#"><%=LanguageUtil.get(locale, "pagination.prev") %></a></li>
					<%
					    for(int j = 1; j <= numPages; j++){
					%>
					<li><a href="#"><%=j%></a></li>
					<%
					    }
					%>
					<li><a href="#"><%=LanguageUtil.get(locale, "pagination.next") %></a></li>
				</ul>

			</div>
</div>


<portlet:resourceURL var="ajaxURL"></portlet:resourceURL>
<script>
function load(){
	
	YUI().use(
			  'aui-toggler',
			  function(Y) {
			    new Y.TogglerDelegate(
			      {
			        animated: true,
			        closeAllOnExpand: true,
			        container: '#myToggler',
			        content: '.content',
			        expanded: false,
			        header: '.header',
			        transition: {
			          duration: 0.2,
			          easing: 'cubic-bezier(0, 0.1, 0, 1)'
			        }
			      }
			    );
			  }
			);
	
	$("#myTogglerHeader").click(function() {
	    var txt = document.getElementById("myTogglerExpand");
	    var header = document.getElementById("myTogglerHeader");
		 if(header.getAttribute('class') == "contentTable header toggler-header toggler-header-expanded"){
			txt.innerHTML = "[+]";
		}else if( header.getAttribute('class') == "contentTable header toggler-header toggler-header-collapsed" ){
			txt.innerHTML = "[-]";
		} 
	});
	
	var pag = YUI()
	.use(
			'aui-pagination',
			function(Y) {
				var pages = Y.all('.content-pagination div.page');
				var size = pages.size();
				if (pages.size() > 0) {
					new Y.Pagination(
							{
								boundingBox : '#pagination',
								circular : false,
								contentBox : '#pagination .pagination-content',
								on : {
									changeRequest : function(event) {
										var instance = this, state = event.state, lastState = event.lastState;
								
										if (lastState) {
											pages.item(
													lastState.page - 1)
													.setStyle(
															'display',
															'none');
										}

										pages.item(state.page - 1)
												.setStyle('display',
														'block');
									}
								},
								page : 1
							}).render();
				}
			});
	
}

function updateElements(key){
       $.ajax({
    	   type: 'POST',
    	   url : '${ajaxURL}',
    	   data: { '<portlet:namespace />keyword': key },
    	   dataType : "json",
    	   success : function(data) {
    		   var start = 0;
    		   var end = <%=pageSize%>;
    		   var perpage = <%=pageSize%>;
    		   if(data.length%end == 0){
    			   var numPages = data.length/end;
    		   }else {
    			   var numPages = Math.floor(data.length/end)+1;
    		   }
    		   var itemOnePage = data;
    		   var html = '<div id="items" class="content-pagination">';
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
    					html = html + '<div id="page" class="page"> <div id="results">';
    				}else{
    					html = html + '<div id="page" class="page" style="display: none;"> <div id="results">';
    				}
    				if(itemOnePage.length != 0){
    					for(var j=0;j<itemOnePage.length;j++){
    						html = html + itemOnePage[j].object;
    					}
    				}
    				html = html + '</div></div>';
    			}
    		   if(data.length != 0){
    		   pagi = '<div id="pagination" class="clearfix button-row right"><ul class="pagination pagination-content right"><li><a href="#"><%=LanguageUtil.get(locale, "pagination.prev") %></a></li>';
  				for(var i=1;i<=numPages;i++){
  					pagi = pagi + '<li><a href="#">' + i + '</a></li>';
  				}
  				pagi = pagi + '<li><a href="#"><%=LanguageUtil.get(locale, "pagination.next") %></a></li></ul></div>';
  				html = html+pagi;
    		   }else{
    			   html = html + '<div id="info" class="alert alert-info clearfix"><%=LanguageUtil.get(locale, "info.datos") %></div>';
    		   }
    		   html = html + '</div>';
    		   
    		  
    		   $("#items").replaceWith(html);
    		   
    		   
    		   var tablaContenidos = '<div id="tablaContenidos" class="toc span12" style="display: <%=(viewContentTable!="" && viewContentTable.equals("true")) || viewContentTable==""? "inherit" : "none"%>">	<div id="myToggler" class="collapsebox"> <div id="myTogglerHeader" class="contentTable header toggler-header toggler-header-expanded"> <h4> <%=LanguageUtil.get(locale, "tabla.contenidos") %>  </h4> <h4 id="myTogglerExpand">[-]</h4> </div> <div class="toc-index content toggler-content-expanded"> <ol>';
    		   for(var x=0;x<data.length;x++){
					
    			   tablaContenidos = tablaContenidos + '<li class="toc-level-1"><a href="#';
    			   tablaContenidos = tablaContenidos + data[x].articleId;
    			   tablaContenidos = tablaContenidos + '-link" class="wikipage" onclick="linkShow(';
    			   tablaContenidos = tablaContenidos + data[x].articleId;
    			   tablaContenidos = tablaContenidos + ');">';
    			   tablaContenidos = tablaContenidos + data[x].node;
    			   tablaContenidos = tablaContenidos + '</a><i>';
    			   tablaContenidos = tablaContenidos + data[x].category;
    			   tablaContenidos = tablaContenidos + '</i></li>';
					
				}
    		   
    		   tablaContenidos = tablaContenidos + '</ol> </div> </div> </div>';
    		   $("#tablaContenidos").replaceWith(tablaContenidos);
    		   load();
    		   
    	   },
    	   error: function () {
    		   console.log('Error Occurred');
    	   }
       });
}

$("#myTogglerHeader").click(function() {
    var txt = document.getElementById("myTogglerExpand");
    var header = document.getElementById("myTogglerHeader");
	 if(header.getAttribute('class') == "contentTable header toggler-header toggler-header-expanded"){
		txt.innerHTML = "[+]";
	}else if( header.getAttribute('class') == "contentTable header toggler-header toggler-header-collapsed" ){
		txt.innerHTML = "[-]";
	} 
});
</script>
<script type="text/javascript">
$(document).ready(function() { 	
	toggler();
});

YUI().use(
		  'aui-toggler',
		  function(Y) {
		    new Y.TogglerDelegate(
		      {
		        animated: true,
		        closeAllOnExpand: true,
		        container: '#myToggler',
		        content: '.content',
		        expanded: false,
		        header: '.header',
		        transition: {
		          duration: 0.2,
		          easing: 'cubic-bezier(0, 0.1, 0, 1)'
		        }
		      }
		    );
		  }
		);

function togglerAction(value){
	var id = value.getAttribute('id');
	var content = document.getElementById(id.concat("-content"));
	var header = document.getElementById(id.concat("-header"));
	var classesContent = content.getAttribute('class');
	var classesHeader = header.getAttribute('class');
	if(classesContent == "content toggler-content toggler-content-expanded"){
		content.setAttribute('class', "content toggler-content toggler-content-collapsed");
		document.getElementById(id.concat("-icon")).setAttribute('class', "icon-chevron-down");
	}else if(classesContent == "content toggler-content toggler-content-collapsed"){
		content.setAttribute('class',"content toggler-content toggler-content-expanded" );	
		document.getElementById(id.concat("-icon")).setAttribute('class', "icon-chevron-up");

	}
	if(classesHeader == "header toggler-header toggler-header-expanded"){
		header.setAttribute('class', "header toggler-header toggler-header-collapsed");
	}else if(classesHeader == "header toggler-header toggler-header-collapsed"){
		header.setAttribute('class',"header toggler-header toggler-header-expanded" );		
	}
	
}

function linkShow(value){
	var pages = document.getElementsByClassName("page");
	var pageIndice = -1;
	for(i=0; i<pages.length; i++){
		pages[i].style.display="none";
	}
	for(i=0; i<pages.length; i++){
	var pageTogglers = pages[i].getElementsByClassName("toggler");
		for(j=0; j<pageTogglers.length; j++){
			if(pageTogglers[j].getAttribute('id') == value){
				pageIndice = i;
			}
		}
	}
	pageIndice = pageIndice + 1;
YUI()
	.use(
			'aui-pagination',
			function(Y) {
				var pages = Y.all('.content-pagination div.page');
				var size = pages.size();
				if (pages.size() > 0) {
					new Y.Pagination(
							{
								boundingBox : '#pagination',
								circular : false,
								contentBox : '#pagination .pagination-content',
								on : {
									changeRequest : function(event) {
										var instance = this, state = event.state, lastState = event.lastState;
								
										if (lastState) {
											pages.item(
													lastState.page - 1)
													.setStyle(
															'display',
															'none');
										}

										pages.item(state.page - 1)
												.setStyle('display',
														'block');
									}
								},
								page : pageIndice
							}).render();
				}
			});
}
var activePage = 0;
function getSearch(value){
	var contador = 0;
	
	var togglers = document.getElementsByClassName("toggler");
	var pages = document.getElementsByClassName("page");
	for(var i = 0; i < pages.length; i++){
		if(pages[i].style.display == "block"){
			activePage = i;
		}
		pages[i].style.display = "inherit";
	}
	var pagination = document.getElementById("pagination");
	pagination.style.display = "none";
	
	if(value == ""){
		pagination.style.display = "inherit";
		for(var i = 0; i < pages.length; i++){
			pages[i].style.display = "none";
		}
		pages[activePage].style.display = "block";
	}
	for(var i = 0; i < togglers.length; i++){
		togglers[i].style.display = "none";
	}
	for(var i = 0; i < togglers.length; i++){
		var content = togglers[i].getElementsByClassName("content")[0];
		if(content.textContent.toUpperCase().indexOf(value.toUpperCase()) > -1){
			togglers[i].style.display = "inherit";
			contador++;
		}
	}
	if(contador == 0 && document.getElementById("info") == null){
		var cont = document.getElementById("items");
		var div = document.createElement("div"); 
		div.setAttribute('class', "alert alert-info clearfix");
		div.setAttribute('id', "info");
		var textnode = document.createTextNode("<%=LanguageUtil.get(locale, "info.datos") %>"); 
		div.appendChild(textnode); 
		cont.appendChild(div); 
	}else if(contador != 0 && document.getElementById("info") != null){
		var info = document.getElementById("info");
		info.parentNode.removeChild(info);
	}
}


function toggler(){
var elements = document.getElementsByClassName("toggler");
for(var i = 0; i < elements.length; i++) { 
	var pad = "#";
	var id = elements[i].getAttribute('id');
	var ident = pad.concat(id);
	
}
}

var pag = YUI()
.use(
		'aui-pagination',
		function(Y) {
			var pages = Y.all('.content-pagination div.page');
			var size = pages.size();
			if (pages.size() > 0) {
				new Y.Pagination(
						{
							boundingBox : '#pagination',
							circular : false,
							strings: {
                                next: '<%=LanguageUtil.get(locale, "pagination.next") %>',
                                prev: '<%=LanguageUtil.get(locale, "pagination.prev") %>'
                              },
							contentBox : '#pagination .pagination-content',
							on : {
								changeRequest : function(event) {
									var instance = this, state = event.state, lastState = event.lastState;
							
									if (lastState) {
										pages.item(
												lastState.page - 1)
												.setStyle(
														'display',
														'none');
									}

									pages.item(state.page - 1)
											.setStyle('display',
													'block');
								}
							},
							page : 1
						}).render();
			}
		});
		
function anular(e) {
     tecla = (document.all) ? e.keyCode : e.which;
     return (tecla != 13);
}
</script>
</div>