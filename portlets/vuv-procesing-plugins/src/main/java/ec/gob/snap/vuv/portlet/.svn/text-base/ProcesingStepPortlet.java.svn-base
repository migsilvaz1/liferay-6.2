
package ec.gob.snap.vuv.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import ec.gob.snap.request.service.RequestEndpoint;
import ec.gob.snap.request.service.RequestEndpointService;
import ec.gob.snap.request.service.RequestEndpointServiceLocator;
import ec.gob.snap.vuv.dynamic.form.EntityUpdateUtil;
import ec.gob.snap.vuv.dynamic.form.entities.Template;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.Acciones;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Variables;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Variables.Proceso;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.rpc.ServiceException;

import org.apache.axis.message.CDATAImpl;

/**
 * Portlet implementation class ProcesingStepPortlet
 */
public class ProcesingStepPortlet extends MVCPortlet {

	Log log = LogFactoryUtil.getLog(ProcesingStepPortlet.class);

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		Boolean navegacionMisDocumentos = ParamUtil.getBoolean(resourceRequest, "navegacionMisDocumentos", Boolean.FALSE);
		Boolean binarioDocumento = ParamUtil.getBoolean(resourceRequest, "binarioDocumento", Boolean.FALSE);
		if(navegacionMisDocumentos == Boolean.TRUE) {
			JSONObject result = JSONFactoryUtil.createJSONObject();
			Long directorioSeleccionadoId = ParamUtil.getLong(resourceRequest, "directorioSeleccionadoId");
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try{
				//Creación del árbol de navegación-------------------------------------------------
				DLFolder folderUsuario = DLFolderLocalServiceUtil.getDLFolder(directorioSeleccionadoId);
				List<Long> idsFolderPadre = folderUsuario.getAncestorFolderIds();
				JSONArray menuNavegacion = JSONFactoryUtil.createJSONArray();
				JSONObject directorioNavegacion;
				//Se añade al arbol de navegación el directorio actual
				directorioNavegacion = JSONFactoryUtil.createJSONObject();
				directorioNavegacion.put("id", folderUsuario.getFolderId());
				if(folderUsuario.getName().compareTo(themeDisplay.getUser().getScreenName()) == 0){
					directorioNavegacion.put("nombre", LanguageUtil.get(themeDisplay.getLocale(), "misDocumentos.portlet.label.misDocumentos"));
				}else{
					directorioNavegacion.put("nombre", folderUsuario.getName());
				}
				menuNavegacion.put(directorioNavegacion);
				result.put("menuNavegacion", menuNavegacion);
				//Se añaden al árbol todos los directorios padre
				if(idsFolderPadre != null && !idsFolderPadre.isEmpty()){
					DLFolder dlFolderAux;
					for(Long aux : idsFolderPadre){
						dlFolderAux = DLFolderLocalServiceUtil.getDLFolder(aux);
						if(dlFolderAux != null){
							directorioNavegacion = JSONFactoryUtil.createJSONObject();
							directorioNavegacion.put("id", dlFolderAux.getFolderId());
							
							if(dlFolderAux.getName().compareTo(themeDisplay.getUser().getScreenName()) == 0){
								directorioNavegacion.put("nombre", LanguageUtil.get(themeDisplay.getLocale(), "misDocumentos.portlet.label.misDocumentos"));
							}else{
								directorioNavegacion.put("nombre", dlFolderAux.getName());
							}
							menuNavegacion.put(directorioNavegacion);
						}
					}
				}
				//Listado de subdirectorios-------------------------------------------------------
				List<DLFolder> folderList = DLFolderLocalServiceUtil.getFolders(themeDisplay.getScopeGroupId(), directorioSeleccionadoId);
				if(folderList != null && !folderList.isEmpty()){
					JSONArray directorios = JSONFactoryUtil.createJSONArray();
					JSONObject directorio;
					for(DLFolder dLFolderAux : folderList){
						if(!dLFolderAux.isInactive() && !dLFolderAux.isInTrash() && !dLFolderAux.isInTrashContainer()){
							directorio = JSONFactoryUtil.createJSONObject();
							directorio.put("id", dLFolderAux.getFolderId());
							directorio.put("nombre", dLFolderAux.getName());
							directorios.put(directorio);
						}
					}
					result.put("directorios", directorios);
				}
				//Listado de ficheros del directorio actual-----------------------------------------
				List<DLFileEntry> fileEntryList = DLFileEntryServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), directorioSeleccionadoId, 0, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
				if(fileEntryList != null && !fileEntryList.isEmpty()){
					DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, themeDisplay.getLocale());
					JSONArray ficheros = JSONFactoryUtil.createJSONArray();
					JSONObject fichero;
					for(DLFileEntry fileEntryAux : fileEntryList){
						if(!fileEntryAux.isInTrash() && !fileEntryAux.isInTrashContainer()){
							fichero = JSONFactoryUtil.createJSONObject();
							fichero.put("id", fileEntryAux.getFileEntryId());
							fichero.put("nombre", fileEntryAux.getTitle());
							fichero.put("size", ((fileEntryAux.getSize()/1024)) + " KB");
							fichero.put("date", df.format(fileEntryAux.getModifiedDate()));
							ficheros.put(fichero);
						}
					}
					result.put("ficheros", ficheros);
				}
			}catch(Exception e){
				result = JSONFactoryUtil.createJSONObject();
				log.error("Error al recuperar los datos del directorio: " + e.toString());
			}finally{
				resourceResponse.setContentType("text/javascript");
				PrintWriter writer = resourceResponse.getWriter();
				writer.write(result.toString());
			}
		}else if(binarioDocumento == Boolean.TRUE){
			try{
				Long idFicheroSeleccionado = ParamUtil.getLong(resourceRequest, "idFicheroSeleccionado");
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(idFicheroSeleccionado);
				System.out.println(dlFileEntry.getTitle());
			}catch (Exception e) {
				log.error("Error al recuperar los el binario del archivo: " + e.toString());
			}
		}
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		 String idProcessBPM =
		 PortalUtil.getOriginalServletRequest(request).getParameter("id");
		if(renderRequest.getParameter("ENDPROCESS")!=null){
			SessionMessages.add(renderRequest, "vuv.procesing.step.successful");
			renderRequest.setAttribute("ENDPROCESS", true);
		} else if (idProcessBPM != null) {
			String codOperation = PropsUtil.get("ec.gob.snap.vuv.procesing.operation.prepare.form");
			prepareForm(codOperation, idProcessBPM, renderRequest, renderResponse);
			renderRequest.setAttribute("INITPROCESS", true);
		}
		else {
			//CASE NEXT
			SessionErrors.add(renderRequest, "vuv.procesing.not.process.value");
		}

		LiferayPortletConfig config = (LiferayPortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String hideDefaultMessage = config.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE;
		SessionMessages.add(renderRequest, hideDefaultMessage);

		super.doView(renderRequest, renderResponse);
	}

	public void prepareForm(String codOperation, String idProcessBPM, RenderRequest renderRequest, RenderResponse renderResponse) {

		try {
			RequestEndpointService service = new RequestEndpointServiceLocator();
			RequestEndpoint port = (RequestEndpoint) service.getPort(RequestEndpoint.class);
			Variables variables = new Variables();
			String userId = PortalUtil.getUser(renderRequest).getScreenName();
			Proceso proceso = new Proceso();
			proceso.setBpm("");
			proceso.setIdProcesoBPM(idProcessBPM);
			proceso.setDeploymentId("");
			proceso.setProcessId("");
			proceso.setVersion("");
			proceso.setUserId(userId);
			proceso.setProcessInstanceId("");
			proceso.setTaskId("");
			proceso.setCodOperation(codOperation);
			variables.setProceso(proceso);
			
			Template template = new Template();
			template.setVariables(variables);
			StringWriter process = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Template.class);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(template, process);

			CDATAImpl cdata = new CDATAImpl(process.toString());
			
			CDATAImpl cdataResponse = new CDATAImpl(port.execute(cdata.toString()));
			String response = cdataResponse.getData();

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			InputStream is = new ByteArrayInputStream(response.getBytes());

			Template transactionForm = (Template) jaxbUnmarshaller.unmarshal(is);
			File formulario = new File("Template2000.xml");
			marshaller.marshal(transactionForm, formulario);

			Formulario form = transactionForm.getFormulario();
			List<JAXBElement<?>> itemsFormulario = form.getAccionesOrOutputTextOrInputText();

			List<Acciones> actionsForm = new ArrayList<Acciones>();
			List<JAXBElement<?>> elementsForm = new ArrayList<JAXBElement<?>>();
			elementsForm.addAll(itemsFormulario);
			for (JAXBElement<?> item : itemsFormulario) {
				Object itemOb = item.getValue();
				if (itemOb instanceof Acciones) {
					actionsForm.add((Acciones) itemOb);
					elementsForm.remove(item);
					break;
				}
			}
			log.error("FORMULARIO OK");
			renderRequest.setAttribute("actionsForm", actionsForm);
			renderRequest.setAttribute("elementsForm", elementsForm);
			renderRequest.getPortletSession().setAttribute("templateForm", transactionForm);
			SessionErrors.clear(renderRequest);
		}
		catch (IOException e) {
			String errorMessage = e.getCause().getLocalizedMessage();
			log.error(errorMessage);
			SessionErrors.add(renderRequest, errorMessage);
		}
		catch (ServiceException e) {
			String errorMessage = e.getCause().getLocalizedMessage();
			log.error(errorMessage);
			SessionErrors.add(renderRequest, errorMessage);
		}
		catch (JAXBException e) {
			String errorMessage = e.getCause().getLocalizedMessage();
			log.error(errorMessage);
			SessionErrors.add(renderRequest, errorMessage);
		}
		catch (PortalException e) {
			String errorMessage = e.getCause().getLocalizedMessage();
			log.error(errorMessage);
			SessionErrors.add(renderRequest, errorMessage);
		}
		catch (SystemException e) {
			String errorMessage = e.getCause().getLocalizedMessage();
			log.error(errorMessage);
			SessionErrors.add(renderRequest, errorMessage);
		}
	}

	public void processForm(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			RequestEndpointService service = new RequestEndpointServiceLocator();
			RequestEndpoint port = (RequestEndpoint) service.getPort(RequestEndpoint.class);
			JAXBContext jaxbContext = JAXBContext.newInstance(Template.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Template templateForm = (Template) actionRequest.getPortletSession().getAttribute(
								"templateForm");
			Formulario form = templateForm.getFormulario();
			List<JAXBElement<?>> itemsFormulario = form.getAccionesOrOutputTextOrInputText();

			for (JAXBElement<?> item : itemsFormulario) {
				Object itemField = item.getValue();
				EntityUpdateUtil.JAXBElementUpdate(
					actionRequest.getParameterMap(), itemField, actionRequest.getLocale());
			}
			StringWriter templateSW = new StringWriter();
			File templateFile = new File("xmlMarshall2000.xml");
			jaxbMarshaller.marshal(templateForm, templateFile);
			jaxbMarshaller.marshal(templateForm, templateSW);
			CDATAImpl cdataSend = new CDATAImpl(templateSW.toString());
			CDATAImpl cdataResponse = new CDATAImpl(port.execute(cdataSend.toString()));
			if(cdataResponse.getData().equalsIgnoreCase("OK")){
				actionResponse.setRenderParameter("ENDPROCESS", Boolean.TRUE.toString());
			}else if(cdataResponse.getData().equalsIgnoreCase("NEXT")){
				//Next
				
			}else{
				//Error
			}
			System.out.println(cdataResponse);
		}
		catch (JSONException | ParseException | JAXBException | RemoteException | ServiceException e) {
			log.error(e.getLocalizedMessage());
			SessionErrors.add(actionRequest, e.getCause().getLocalizedMessage());
		}
	}

}
