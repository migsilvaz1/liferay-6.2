<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ include file="init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	Service serviceItem;
	ServicesUtil servicesUtil;
	
	PortletPreferences preferences = liferayPortletRequest.getPreferences();
	Integer numOfRows = Integer.parseInt(GetterUtil.getString(preferences.getValue("numPerPage", "1")));
	
	//Get artiles
	List<JournalArticle> structureArticlesInit = JournalArticleLocalServiceUtil.getStructureArticles(themeDisplay.getScopeGroupId(), SERVICES_ESTRUCTURE_NAME);
	List<JournalArticle> structureArticles = new LinkedList<JournalArticle>();
	for(JournalArticle ja : structureArticlesInit){
		if(ja.isApproved() == true && 
		 ja.isExpired() == false && 
		 ja.isDenied() == false && 
		 ja.isInactive() == false && 
		 JournalArticleLocalServiceUtil.isLatestVersion(themeDisplay.getScopeGroupId(),ja.getArticleId(),ja.getVersion()) && !structureArticles.contains(ja)){
			structureArticles.add(ja);
		}
	}
	List<AssetLink> links = AssetLinkLocalServiceUtil.getAssetLinks(0, AssetLinkLocalServiceUtil.getAssetLinksCount());
%>
<div class="container-fluid find-services">
	<div class="row-fluid span12" id="search">
		<form class="form-inline span12" style="padding: 1em;">
			<div class="input-append pull-left span4">
				<input type="text" onblur="updateElements(this.value)" onkeyup="if(event.keyCode == 13){updateElements(this.value);}" placeholder='<%=LanguageUtil.get(portletConfig, locale,"search" ) %>'/>
				<span class="add-on btn-inverse"><i class="fa fa-search fa-fw"></i></span>
			</div>
			<div class="pull-right span8 filters-ui-wrapper">
			    <div class="pull-right span8 age-slider">
			    	<div class="span1 pull-left">
			    		<i class="fa fa-child fa-fw" style="color: #dbdbdb;"></i>
			    	</div>
			    	<div class="span10 pull-left">
						<div id="age-selector"></div>
						<input type="text" id="amount" readonly style="visibility: collapse;">
					</div>
					<div class="span1 pull-left">
						<i class="fa fa-male fa-fw" style="color: #dbdbdb;"></i>
					</div>
				</div>
				<div id="sex-selector" class="btn-group span2 pull-right">
					    <span id="male" class="btn" onclick="sexSelect(this.id)"><i class="fa fa-male fa-fw"></i></span>
					    <span id="female" class="btn" onclick="sexSelect(this.id)"><i class="fa fa-female fa-fw"></i></span>
				</div>
				<div id="radiogroupUser"  class="btn-group span2 pull-right">
						<button id="servTemp-userPerson"  type="button" class="active"><i class="fa fa-user"></i></button>
                        <button id="servTemp-userCompany" type="button"><i class="fa fa-building"></i></button>          
                </div>
			</div>
			<div class="row-fluid" id="servTemp-userCompanyOptions" style="display: none;">
				<div class="span12">
					<fieldset>
						<legend class="companyOptions" style="color: #dbdbdb !important;"><liferay-ui:message key="options.advanced" />:</legend>
						<div id="radiogroupProp" class="pull-right span3 companyOptions">
							 <label style="color: #dbdbdb !important"><liferay-ui:message key="options.properties"/></label>
		                     <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.public")%>" class="companyOptions active pull-left">
		                     <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.private")%>" class="companyOptions pull-left">
		                </div>
		                <div id="radiogroupSize" class="pull-right span5">
		                	 <label style="color: #dbdbdb !important"><liferay-ui:message key="options.size" /></label>
		                     <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.micro")%>" class="companyOptions active pull-left">
		                     <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.small")%>" class="companyOptions pull-left">
		                     <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.midium")%>" class="companyOptions pull-left">
		                     <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.big")%>" class="companyOptions pull-left">
		                </div>
		                <div id="radiogroupSector" class="pull-right span4">
		                	  <label style="color: #dbdbdb !important"><liferay-ui:message key="options.sector" /></label>
		                      <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.primary")%>" class="companyOptions active pull-left">
		                      <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.industrial")%>" class="companyOptions pull-left">
		                      <input type="button" value="<%=LanguageUtil.get(portletConfig, locale,"options.services")%>" class="companyOptions pull-left">
		                 </div>
	                 </fieldset>
	             </div>
			</div>
		</form>
	</div>
	<div id="servicesList" class="row-fluid span12">
		<!-- --------------------------------------------------------------------- -->
		<div style="margin-bottom: 1em; margin-top: 1em;">
			<%=LanguageUtil.get(portletConfig, locale, "search.results")%>
		</div>
		<!-- --------------------------------------------------------------------- -->	
		<div id="ajaxServicesList">
		<portlet:resourceURL var="ajaxURL"></portlet:resourceURL>
		<%
			if (structureArticles.size()>0) { //#1
					for(JournalArticle service: structureArticles){ //#2
						String portletId;
						serviceItem = new Service();
						Document document = SAXReaderUtil.read(service.getContentByLocale(locale.toString()));
						Element rootElement = document.getRootElement();
						XPath xPathSelector_name = SAXReaderUtil.createXPath("dynamic-element[@name='name']");
						XPath xPathSelector_description = SAXReaderUtil.createXPath("dynamic-element[@name='description']");
						XPath xPathSelector_sex = SAXReaderUtil.createXPath("dynamic-element[@name='gender']");
						XPath xPathSelector_age = SAXReaderUtil.createXPath("dynamic-element[@name='age']");
						//------------------------------------------------------------------------------------
						XPath xPathSelector_serviceType = SAXReaderUtil.createXPath("dynamic-element[@name='serviceType']");
						//------------------------------------------------------------------------------------
						String sex = xPathSelector_sex.selectSingleNode(rootElement).getStringValue();
						sex = sex.trim();
						String age = xPathSelector_age.selectSingleNode(rootElement).getStringValue();
						age = age.trim();
						//------------------------------------------------------------------------------------
 						String serviceTypeString = xPathSelector_serviceType.selectSingleNode(rootElement).getStringValue();
						//------------------------------------------------------------------------------------
						serviceItem.setServiceName(xPathSelector_name.selectSingleNode(rootElement).getStringValue());
						serviceItem.setServiceDescription(xPathSelector_description.selectSingleNode(rootElement).getStringValue());
						serviceItem.setServiceSex(sex);
						serviceItem.setServiceAge(age);
						//--------------------------------------------------------------------------------------
						serviceItem.setServiceType(serviceTypeString);
						//--------------------------------------------------------------------------------------
						Layout articleLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, SERVICES_ASSERTPUBLISHER_PAGE);
						LayoutTypePortlet articleLayoutTypePortlet = (LayoutTypePortlet)articleLayout.getLayoutType();
						List<Portlet> allPortlets = articleLayoutTypePortlet.getAllPortlets("column-1");
						for (Portlet p: allPortlets){
							if (PortletKeys.ASSET_PUBLISHER.equals(p.getRootPortletId())){
								serviceItem.setId(p.getInstanceId());
								break;
							}
						}
						serviceItem.setUrl(PortalUtil.getHomeURL(request) + SERVICES_ASSERTPUBLISHER_PAGE +"/-/asset_publisher/"+ serviceItem.getId() +"/content/" + service.getUrlTitle());
						ServicesUtil.addService(serviceItem);
					} //end #2
			} //end #1
			ServicesUtil.setServicesUtilProp(numOfRows,LanguageUtil.get(portletConfig, locale,"read.more"), LanguageUtil.get(portletConfig, locale,"not.available.services"),MAXNUM_CHAR_DESCRIP);
			int numPages = (ServicesUtil.getServicesLayout().size()%(NUMCOLUMN_ROW*numOfRows) == 0) ? ServicesUtil.getServicesLayout().size()/(NUMCOLUMN_ROW*numOfRows) : ServicesUtil.getServicesLayout().size()/(NUMCOLUMN_ROW*numOfRows)+1;
			%>
			<%=ServicesUtil.getAssertList2HTML(ServicesUtil.getServicesLayout(), renderRequest.getContextPath())%>
		</div>
	</div>
	
	<div id="pagination">
		<ul class="pagination pagination-content">
			<li><a href="#">Prev</a></li>
			<%for(int i = 1; i <= numPages; i++){ %>
			<li><a href="#"><%=i %></a></li>
			<%} %>
			<li><a href="#">Next</a></li>
		</ul>
	</div>
</div>
<script>
//Filter parameters
var rangoInf=0;
var rangoSup=100;
var maleSelected = "n";
var femaleSelected = "n";
var keywords;
//GUI
$("#servTemp-userCompany").click(function(){
    $("#servTemp-userCompanyOptions").show();
});
$("#servTemp-userPerson").click(function(){
    if ($("#servTemp-userCompanyOptions").is(":visible")){
        $("#servTemp-userCompanyOptions").hide();
    }
});
YUI().use(
  'aui-button',
  function(Y) {
    new Y.ButtonGroup(
      {
        boundingBox: '#radiogroupProp',
        type: 'radio'
      }
    ).render();
    new Y.ButtonGroup(
      {
        boundingBox: '#radiogroupSize',
        type: 'radio'
      }
    ).render();
    new Y.ButtonGroup(
      {
        boundingBox: '#radiogroupSector',
        type: 'radio'
      }
    ).render();
     new Y.ButtonGroup(
      {
        boundingBox: '#radiogroupUser',
        type: 'radio'
      }
    ).render();
  }
);
//Filter functions
//Si se modifica el rango de valores, tenemos que modificar el filtro de busqueda
$(function() {
	$("#age-selector")
    .slider({
    	min: 0,
		max: 60,
		step: 10,
		values: [ 0, 60 ],
		slide: function( event, ui ) {
			rangoInf = ui.values[ 0 ];
			rangoSup= ui.values[ 1 ];
			filterServices();
		}
    })
    .slider("pips", {
        rest: "label"
    });
});
function updateElements(key){
	keywords = key;
	filterServices();
}
function sexSelect(selected){
	if(selected == "male"){
		if(maleSelected == "n"){
			maleSelected = "y";
			$( "#"+selected ).addClass( "active" );
		}else{
			maleSelected = "n";
			$( "#"+selected ).removeClass( "active" );
		}
	}
	if(selected == "female"){
		if(femaleSelected == "n"){
			femaleSelected = "y";
			$( "#"+selected ).addClass( "active" );
		}else{
			femaleSelected = "n";
			$( "#"+selected ).removeClass( "active" );
		}
	}
	filterServices();
}
function filterServices(){
	$.ajax({
	 	   type: 'POST',
	 	   url : '${ajaxURL}',
	 	   data: { 
	 		   	'<portlet:namespace />keyword': keywords,
	 		  	'<portlet:namespace />rangoInf': rangoInf,
	 		  	'<portlet:namespace />rangoSup': rangoSup,
	 		  	'<portlet:namespace />maleSelected': maleSelected,
	 		  	'<portlet:namespace />femaleSelected': femaleSelected
	 		   },
	 	   dataType : "json",
	 	   success : function(data) {
	 		   var start = 0;
	 		   var html = '<div id="ajaxServicesList">';
	 		   html = html + data['html'];
	 		   html = html + '</div>';
	 		   $("#ajaxServicesList").replaceWith(html);
	 		  	if(data['numElems']>0){
	 		  		var paginationElem = document.getElementById("pagination");
		 		   //var pagination = '<div id="pagination"><ul class="pagination pagination-content"><li><a href="#">Prev</a></li>';
		 		   var pagination = '<ul class="pagination pagination-content"><li><a href="#">Prev</a></li>';
		 		   var numPerPag = <%=numOfRows %>*3;
		 		   var numPages = Math.ceil(data['numElems']/numPerPag);
	 		   
		 		   for(var i = 1; i <= numPages; i++){
						pagination = pagination + '<li><a href="#">' + i + '</a></li>';
					}
					//pagination = pagination + '<li><a href="#">Next</a></li></ul></div>';
					//$("#pagination").replaceWith(pagination);
					pagination = pagination + '<li><a href="#">Next</a></li></ul>';
					paginationElem.innerHTML = pagination;
					YUI().use(
							  'aui-pagination',
							  function(Y) {
							    var pages = Y.all('.servicesPageList');
							    new Y.Pagination(
							      {
							        boundingBox: '#pagination',
							        circular: false,
							        strings: {
				                        next: '<%=LanguageUtil.get(portletConfig, locale, "pagination.next") %>',
				                        prev: '<%=LanguageUtil.get(portletConfig, locale, "pagination.prev") %>'
				                      },
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
	 	   }else{
	 		  var paginationElem = document.getElementById("pagination");
	 		  //$("#pagination").replaceWith('<div id="pagination"></div>');
	 		  paginationElem.innerHTML = '<div id="pagination"></div>';
	 	   }
	 	   },
	 	   error: function () {
	 		   console.log('Error Occurred');
	 	   }
	  });
}
</script>

<script>
	YUI().use(
			  'aui-pagination',
			  function(Y) {
			    var pages = Y.all('.servicesPageList');
	
			    new Y.Pagination(
			      {
			        boundingBox: '#pagination',
			        circular: false,
			        strings: {
                        next: '<%=LanguageUtil.get(portletConfig, locale, "pagination.next") %>',
                        prev: '<%=LanguageUtil.get(portletConfig, locale, "pagination.prev") %>'
                      },
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
