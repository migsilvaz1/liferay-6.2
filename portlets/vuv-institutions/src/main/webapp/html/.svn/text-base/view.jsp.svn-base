<%@page import="ec.gob.snap.vuv.model.Servicio"%>
<%@page import="ec.gob.snap.vuv.model.Institucion"%>
<%@page import="ec.gob.snap.vuv.service.InstitucionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.model.PortletConstants"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="com.liferay.portal.model.LayoutTypePortlet"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleConstants"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.journal.util.comparator.ArticleTitleComparator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="org.omg.CosNaming.IstringHelper"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetLink"%>
<%@page import="com.liferay.portal.kernel.xml.XPath"%>
<%@page import="com.liferay.portal.kernel.xml.Element"%>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@page import="com.liferay.portal.kernel.xml.Document"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
final String SERVICES_ASSERTPUBLISHER_PAGE = PropsUtil.get("service.assertPublisherDetailedPage");
	List<Institucion> instituciones = InstitucionLocalServiceUtil.getAllInstituciones();
	Map<Long, JournalArticle> institucionesMap = new HashMap<Long, JournalArticle>();
	for (Institucion institucion : instituciones) {
		JournalArticle ja = JournalArticleLocalServiceUtil.getLatestArticle(institucion.getContent());
		if (ja.isApproved() == true
				&& ja.isExpired() == false
				&& ja.isDenied() == false
				&& ja.isInactive() == false
				&& JournalArticleLocalServiceUtil.isLatestVersion(
						themeDisplay.getScopeGroupId(),
						ja.getArticleId(), ja.getVersion())
				&& !institucionesMap.keySet().contains(institucion.getId_institucion())) {
			institucionesMap.put(institucion.getId_institucion(), ja);
		}
	}
%>
<head>
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
	<div>
		
		
		<div class="span12">
			<div class="institutions-wrapper">
			<div class="span3">
				<div id="search">
					<div class="input-append">
						<input type="text" onchange="updateElements(this.value)"/>
						<span class="add-on"><i class="icon-search icon-white"></i></span>
					</div>
					<div class="mobile-select-wrapper">
					<select onchange="animar(this.value)">
						<option value="" selected="selected"><liferay-ui:message key="selector.default" /></option>
						<%
						for(Long institucionId: institucionesMap.keySet()){
							JournalArticle institucion = institucionesMap.get(institucionId);
							Document document = SAXReaderUtil.read(institucion.getContentByLocale(locale.toString()));
							Element rootElement = document.getRootElement();
							XPath xPathSelector_name = SAXReaderUtil.createXPath("dynamic-element[@name='name']");
							String name = xPathSelector_name.selectSingleNode(rootElement).getStringValue();
							%>
							<option value="<%= institucionId %>"><%= name %></option>
							<%
						}
								
						%>
					</select>
				</div>
			</div><!-- #search -->
				<ul id="list" class="institutions-list">
			<%
				for(Long institucionId: institucionesMap.keySet()){
					JournalArticle institucion = institucionesMap.get(institucionId);
					Document document = SAXReaderUtil.read(institucion.getContentByLocale(locale.toString()));
					Element rootElement = document.getRootElement();
					XPath xPathSelector_name = SAXReaderUtil.createXPath("dynamic-element[@name='name']");
					String name = xPathSelector_name.selectSingleNode(rootElement).getStringValue();
					%>
						<li id="<%=institucionId %>" class="institution" onClick="animar(this.id)"><%=name %></li>
					<%
				}
			%>
				</ul>
			</div><!-- span3 -->
			<div id="institutions" class="span9">
				<div class="inst-content-wrapper">
				<%
					boolean first = true;
					String firstId = "";
					for(Long institucionId: institucionesMap.keySet()){
						JournalArticle institucion = institucionesMap.get(institucionId);
						Document document = SAXReaderUtil.read(institucion.getContentByLocale(locale.toString()));
						Element rootElement = document.getRootElement();
						XPath xPathSelector_name = SAXReaderUtil.createXPath("dynamic-element[@name='name']");
						String name = xPathSelector_name.selectSingleNode(rootElement).getStringValue();
						XPath xPathSelector_description = SAXReaderUtil.createXPath("dynamic-element[@name='description']");
						String description = xPathSelector_description.selectSingleNode(rootElement).getStringValue();
						XPath xPathSelector_totalServices = SAXReaderUtil.createXPath("dynamic-element[@name='totalServices']");
						String totalServices = xPathSelector_totalServices.selectSingleNode(rootElement).getStringValue();
						XPath xPathSelector_servicesInOperation = SAXReaderUtil.createXPath("dynamic-element[@name='servicesInOperation']");
						String servicesInOperation = xPathSelector_servicesInOperation.selectSingleNode(rootElement).getStringValue();
						XPath xPathSelector_contact = SAXReaderUtil.createXPath("dynamic-element[@name='contact']");
						String contacto = xPathSelector_contact.selectSingleNode(rootElement).getStringValue();
						List<Servicio> servicios = InstitucionLocalServiceUtil.getAllServiciosByIdInstitucion(institucionId);
						Map<String, String> serviciosMap = new HashMap<String, String>();
						if(servicios.size()>0){
							for(Servicio servicio: servicios){
								JournalArticle servicioJa = JournalArticleLocalServiceUtil.getLatestArticle(servicio.getContent());
								Document serviceDocument = SAXReaderUtil.read(servicioJa.getContentByLocale(locale.toString()));
								Element serviceRootElement = serviceDocument.getRootElement();
								XPath selector_sname = SAXReaderUtil.createXPath("dynamic-element[@name='name']");
								String sname = selector_sname.selectSingleNode(serviceRootElement).getStringValue();
								
								String portletId="";
								Layout articleLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, SERVICES_ASSERTPUBLISHER_PAGE);
								LayoutTypePortlet articleLayoutTypePortlet = (LayoutTypePortlet)articleLayout.getLayoutType();
								List<Portlet> allPortlets = articleLayoutTypePortlet.getAllPortlets("column-1");
								for (Portlet p: allPortlets){
									if (PortletKeys.ASSET_PUBLISHER.equals(p.getRootPortletId())){
										portletId = p.getInstanceId();
										break;
									}
								}
								String url = PortalUtil.getHomeURL(request) + SERVICES_ASSERTPUBLISHER_PAGE +"/-/asset_publisher/"+ portletId +"/content/" + servicioJa.getUrlTitle();
								serviciosMap.put(sname, url);
							}
						}						
						if(first){
							firstId = "#id-" + institucionId;
							%>
								<div id="id-<%=institucionId%>">
									<div>
										<div class="page-header">
											<h3><%=name %></h3>
											<p><%=description %></p>
										</div>
										<h4><liferay-ui:message key="data.contact" /></h4>
										<h5><%=contacto %></h5>
										<h4><liferay-ui:message key="data.services" /></h4>
										<%if(!servicios.isEmpty()){%>
										<table class="table table-hover">
										 <tr>
										   <th><liferay-ui:message key="data.services.name" /></th>
										   <th><liferay-ui:message key="data.services.status" /></th>
										 </tr>
										 	<%for(String serviceName: serviciosMap.keySet()){
										 		String url = serviciosMap.get(serviceName);
										 	%>
										 <tr>
										   <td><a href="<%=url %>"><%=serviceName %></a></td>
										   <td><span class="online"><liferay-ui:message key="data.services.operative" /></span></td>
										 </tr>
										 <%} %>
										</table>
										<%}else{ %>
										<div class="alert"><liferay-ui:message key="data.services.none" /></div>
										<%} %>
									</div>
								</div>
							<%
						}else{
							%>
								<div id="id-<%=institucionId%>" style="display: none;">
									<div>
										<div class="page-header">
											<h3><%=name %></h3>
											<p><%=description %></p>
										</div>
										<h4><liferay-ui:message key="data.contact" /></h4>
										<h5><%=contacto %></h5>
										<h4><liferay-ui:message key="data.services" /></h4>
										<%if(!servicios.isEmpty()){%>
										<table class="table table-hover">
										 <tr>
										   <th><liferay-ui:message key="data.services.name" /></th>
										   <th><liferay-ui:message key="data.services.status" /></th>
										 </tr>
										 	<%for(String serviceName: serviciosMap.keySet()){
										 		String url = serviciosMap.get(serviceName);
										 	%>
										 <tr>
										   <td><a href="<%=url%>"><%=serviceName %></a></td>
										   <td><span class="online"><liferay-ui:message key="data.services.operative" /></span></td>
										 </tr>
										 <%} %>
										</table>
										<%}else{ %>
										<div class="alert"><liferay-ui:message key="data.services.none" /></div>
										<%} %>
									</div>
								</div>
							<%
						}
						first=false;
					}
				%>
			</div> <!-- .inst-content-wrapper"> -->
			</div><!-- span9 -->
		</div><!-- row -->
	</div><!-- span12 -->
		<script>
		var actual = "<%=firstId%>";
		function animar(elemid){
			var id = "#id-"+elemid;
			if(actual != ""){
				$(actual).toggle(400);
			}
			setTimeout(function(){ $(id).toggle(400); }, 500);
			actual = id;
			if(screen.width >= 768){
				$('html,body').animate({ scrollTop: 0 }, 'slow');
			}
		}
		</script>
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
		    		   var html = '<ul id="list" class="institutions-list">';
		    		   for(var i=0; i<data.length; i++) {
		    			   html = html + '<li id="' + data[i].institucionId + '" " class="institution" onClick="animar(this.id)">' + data[i].name + '</li>';
		    		   }
		    		   html = html + '</ul></div>';
		    		   $("#list").replaceWith(html);
		    		   if(data.length == 0){
		    			   animar("");
		    		   }else{
		    			   animar(data[0].institucionId);
		    		   }
		    	   },
		    	   error: function () {
		    		   console.log('Error Occurred');
		    	   }
		       });
		}
		$(".institution").click(function ( e ) {
	    	e.preventDefault();
	     	$(".institution.active").removeClass('active');
	    	$(this).addClass('active');
    	});
	</script>
	</div>
</body>