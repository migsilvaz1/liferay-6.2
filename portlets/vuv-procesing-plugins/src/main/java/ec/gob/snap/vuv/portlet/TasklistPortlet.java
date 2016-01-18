
package ec.gob.snap.vuv.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
import com.liferay.util.bridges.mvc.MVCPortlet;

import ec.gob.snap.request.service.RequestEndpoint;
import ec.gob.snap.request.service.RequestEndpointService;
import ec.gob.snap.request.service.RequestEndpointServiceLocator;
import ec.gob.snap.tasks.process.InputTaskData;
import ec.gob.snap.tasks.process.TaskData;
import ec.gob.snap.tasks.services.WebServiceInterfaceLocator;
import ec.gob.snap.tasks.services.WebServiceInterfacePortType;
import ec.gob.snap.vuv.dynamic.form.EntityUpdateUtil;
import ec.gob.snap.vuv.dynamic.form.entities.Template;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.Acciones;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Variables;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Variables.Local;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Variables.Output;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Variables.Proceso;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
 * Portlet implementation class TasklistPortlet
 */
public class TasklistPortlet extends MVCPortlet {

    Log log = LogFactoryUtil.getLog(TasklistPortlet.class);
    private Template processingTemplate = null;
    
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
    	super.doView(renderRequest, renderResponse);
    }
    
    @Override
    public void serveResource(
        ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws IOException {

        ThemeDisplay themeDisplay =
            (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String userId = themeDisplay.getUser().getScreenName();

        if (resourceRequest.getResourceID().equals("loadDataTable")) {
            log.info("Load DataTable");
            try {
                WebServiceInterfaceLocator webServiceInterfaceLocator =
                    new WebServiceInterfaceLocator();
                WebServiceInterfacePortType port;
                String taskColumns[] =
                    {
                        "status", "processInstanceID", "processName",
                        "taskName", "taskDate", "priority", "deadline",
                        "userID", "taskId", "idProcesoBPM"
                    };
                Integer maxDisplay =
                    Integer.parseInt(PropsUtil.get("ec.gob.snap.vuv.tasklist.max.results"));
                port = webServiceInterfaceLocator.getWebServiceInterfacePort();
                String idProcesoBPM = "";
                String profiles = "";
                InputTaskData inputTaskData =
                    new InputTaskData(idProcesoBPM, userId, profiles);
                TaskData[] taskList = port.execute(inputTaskData);

                if (taskList != null) {
                    if (taskList.length > maxDisplay) {
                        taskList = Arrays.copyOf(taskList, maxDisplay);
                        SessionMessages.add(
                            resourceRequest.getPortletSession(),
                            "vuv.tasklist.maximum.messages");
                    }
                    else {
                        SessionMessages.clear(resourceRequest.getPortletSession());
                    }
                    JSONArray dataList = JSONFactoryUtil.createJSONArray();
                    JSONObject outputData;
                    String taskStatus = "";
                    String taskProcessInstanceID = "";
                    String taskProcessName = "";
                    String taskName = "";
                    String taskDate = "";
                    String taskDeadline = "";
                    String taskPriority = "";
                    for (TaskData taskData : taskList) {
                        taskStatus = taskData.getStatus().toUpperCase();
                        taskProcessInstanceID = taskData.getProcessInstanceId();
                        taskProcessName = taskData.getProcessName();
                        taskName = taskData.getTaskName();
                        taskDate = taskData.getTaskDate();
                        taskDeadline = taskData.getDeadline();
                        taskPriority = taskData.getPriority();
                        outputData = JSONFactoryUtil.createJSONObject();
                        outputData.put(taskColumns[0], taskStatus);
                        outputData.put(taskColumns[1], taskProcessInstanceID);
                        outputData.put(taskColumns[2], taskProcessName);
                        outputData.put(taskColumns[3], taskName);
                        outputData.put(taskColumns[4], taskDate);
                        outputData.put(taskColumns[5], taskPriority);
                        outputData.put(taskColumns[6], taskDeadline);
                        outputData.put(taskColumns[7], taskData.getUserId());
                        outputData.put(taskColumns[8], taskData.getTaskId());
                        outputData.put(
                            taskColumns[9], taskData.getProcessIdGpr());
                        dataList.put(outputData);
                    }
                    JSONObject outputJSON = JSONFactoryUtil.createJSONObject();
                    outputJSON.put("data", dataList);
                    resourceResponse.getWriter().write(outputJSON.toString());
                }
                else {
                    JSONObject outputJSON = JSONFactoryUtil.createJSONObject();
                    resourceResponse.getWriter().write(outputJSON.toString());
                }
            }
            catch (ServiceException | ConnectException | BindException
                            | PortUnreachableException | NoRouteToHostException e) {
                log.error(e.getLocalizedMessage());
                SessionErrors.add(
                    resourceRequest, e.getCause().getLocalizedMessage());
            }catch(Exception e){
//                log.error(e.getLocalizedMessage());
            	e.printStackTrace();
            }

        }
        else if (resourceRequest.getResourceID().equals("reclamar")) {
            String idProcesoBPM = resourceRequest.getParameter("idProcesoBPM");
            String processInstanceId =
                resourceRequest.getParameter("processInstanceId");
            String taskId = resourceRequest.getParameter("taskId");
            log.info("CLAME: idProcesoBPM: " + idProcesoBPM +
                " processInstanceId: " + processInstanceId + " taskId: " +
                taskId);

            try {
                RequestEndpointService service =
                    new RequestEndpointServiceLocator();

                RequestEndpoint port =
                    (RequestEndpoint) service.getPort(RequestEndpoint.class);
                // Instanciamos el proceso
                Proceso proceso = new Proceso();
                proceso.setBpm("");
                proceso.setCodOperation(PropsUtil.get("ec.gob.snap.vuv.procesing.operation.claim.task"));
                proceso.setDeploymentId("");
                proceso.setIdProcesoBPM(idProcesoBPM);
                proceso.setProcessId("");
                proceso.setProcessInstanceId(processInstanceId);
                proceso.setTaskId(taskId);
                proceso.setUserId(userId);
                proceso.setVersion("");
                // Instanciamos el local
                Local local = new Local();
                // Instanciamos el output
                Output output = new Output();
                // Instanciamos las variables
                Variables variables = new Variables();
                // Instanciamos el formulario
                Formulario formulario = new Formulario();
                // Asignamos los valores de variables
                variables.setProceso(proceso);
                variables.setLocal(local);
                variables.setOutput(output);
                // Instanciamos la template
                Template template = new Template();
                // Asignamos los valores a la template
                template.setVariables(variables);
                template.setFormulario(formulario);

                StringWriter process = new StringWriter();
                JAXBContext jaxbContext =
                    JAXBContext.newInstance(Template.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(template, process);

                CDATAImpl cdata = new CDATAImpl(process.toString());

                String response = port.execute(cdata.getData());

                JSONObject outputJSON = JSONFactoryUtil.createJSONObject();
                resourceResponse.getWriter().write(outputJSON.toString());
            }
            catch (ServiceException | ConnectException | BindException
                            | PortUnreachableException | NoRouteToHostException
                            | JAXBException e) {
                log.error(e.getLocalizedMessage());
                SessionErrors.add(
                    resourceRequest, e.getCause().getLocalizedMessage());
            }
        }
        else if (resourceRequest.getResourceID().equals("liberar")) {
            String idProcesoBPM = resourceRequest.getParameter("idProcesoBPM");
            String processInstanceId =
                resourceRequest.getParameter("processInstanceId");
            String taskId = resourceRequest.getParameter("taskId");
            log.info("RELEASE: idProcesoBPM: " + idProcesoBPM +
                " processInstanceId: " + processInstanceId + " taskId: " +
                taskId);

            try {
                RequestEndpointService service =
                    new RequestEndpointServiceLocator();

                RequestEndpoint port =
                    (RequestEndpoint) service.getPort(RequestEndpoint.class);
                // Instanciamos el proceso
                Proceso proceso = new Proceso();
                proceso.setBpm("");
                proceso.setCodOperation(PropsUtil.get("ec.gob.snap.vuv.procesing.operation.release.task"));
                proceso.setDeploymentId("");
                proceso.setIdProcesoBPM(idProcesoBPM);
                proceso.setProcessId("");
                proceso.setProcessInstanceId(processInstanceId);
                proceso.setTaskId(taskId);
                proceso.setUserId(userId);
                proceso.setVersion("");
                // Instanciamos el local
                Local local = new Local();
                // Instanciamos el output
                Output output = new Output();
                // Instanciamos las variables
                Variables variables = new Variables();
                // Instanciamos el formulario
                Formulario formulario = new Formulario();
                // Asignamos los valores de variables
                variables.setProceso(proceso);
                variables.setLocal(local);
                variables.setOutput(output);
                // Instanciamos la template
                Template template = new Template();
                // Asignamos los valores a la template
                template.setVariables(variables);
                template.setFormulario(formulario);

                StringWriter process = new StringWriter();
                JAXBContext jaxbContext =
                    JAXBContext.newInstance(Template.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(template, process);

                CDATAImpl cdata = new CDATAImpl(process.toString());

                String response = port.execute(cdata.getData());

                JSONObject outputJSON = JSONFactoryUtil.createJSONObject();
                resourceResponse.getWriter().write(outputJSON.toString());
            }
            catch (ServiceException | ConnectException | BindException
                            | PortUnreachableException | NoRouteToHostException
                            | JAXBException e) {
                log.error(e.getLocalizedMessage());
                SessionErrors.add(
                    resourceRequest, e.getCause().getLocalizedMessage());
            }
        }
        else {
            log.warn("Bad Ajax Request");
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.liferay.util.bridges.mvc.MVCPortlet#doDispatch(javax.portlet.RenderRequest,
     *      javax.portlet.RenderResponse)
     */
    @Override
    protected void doDispatch(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        HttpServletRequest httpReq =
            PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        String idProcesoBPM = httpReq.getParameter("idProcesoBPM");
        String processInstanceID = httpReq.getParameter("processInstanceID");
        String taskId = httpReq.getParameter("taskId");
        log.info("DoDispatch");
        if (idProcesoBPM != null && processInstanceID != null && taskId != null) {
            try {
                RequestEndpointService service =
                    new RequestEndpointServiceLocator();
                RequestEndpoint port =
                    (RequestEndpoint) service.getPort(RequestEndpoint.class);
                Variables variables = new Variables();
                String userId =
                    PortalUtil.getUser(renderRequest).getScreenName();
                if(userId.equals("bpmsadmin")){userId = "bpmsAdmin";}
                Proceso proceso = new Proceso();
                proceso.setBpm("");
                proceso.setIdProcesoBPM(idProcesoBPM);
                proceso.setDeploymentId("");
                proceso.setProcessId("");
                proceso.setVersion("");
                proceso.setUserId(userId);
                proceso.setProcessInstanceId(processInstanceID);
                proceso.setTaskId(taskId);
                proceso.setCodOperation(PropsUtil.get("ec.gob.snap.vuv.procesing.operation.start.task"));

                variables.setProceso(proceso);
                Template template = new Template();
                template.setVariables(variables);
                StringWriter process = new StringWriter();

                JAXBContext jaxbContext =
                    JAXBContext.newInstance(Template.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(template, process);
                
                CDATAImpl cdata = new CDATAImpl(process.toString());
                String message = cdata.toString();
                log.info(message);
                CDATAImpl cdataResponse =
                    new CDATAImpl(port.execute(message));
                String response = cdataResponse.getData();
                
                if(response.equals("ERROR")){
                	SessionErrors.add(renderRequest, "bpmn-error");
                }else{
                	log.info(response);
                    // Transaction
                    log.info("Transaction");
                    Unmarshaller jaxbUnmarshaller =
                        jaxbContext.createUnmarshaller();
                    InputStream is = new ByteArrayInputStream(response.getBytes());

                    Template transactionForm =
                        (Template) jaxbUnmarshaller.unmarshal(is);
                    
                    if (processingTemplate != null) {
                    	processingTemplate = null;
                    }
                    processingTemplate = transactionForm;
                    
                    Formulario form = transactionForm.getFormulario();
                    List<JAXBElement<?>> itemsFormulario =
                        form.getAccionesOrOutputTextOrInputText();

                    List<Acciones> actionsForm = new ArrayList<Acciones>();
                    List<JAXBElement<?>> elementsForm =
                        new ArrayList<JAXBElement<?>>();
                    elementsForm.addAll(itemsFormulario);
                    for (JAXBElement<?> item : itemsFormulario) {
                        Object itemOb = item.getValue();
                        if (itemOb instanceof Acciones) {
                            actionsForm.add((Acciones) itemOb);
                            elementsForm.remove(item);
                            break;
                        }
                    }
                    log.info("FORMULARIO OK");
                    renderRequest.setAttribute("actionsForm", actionsForm);
                    renderRequest.setAttribute("elementsForm", elementsForm);
                    SessionErrors.clear(renderRequest);
                }
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
        super.doDispatch(renderRequest, renderResponse);
    }

    public void processForm(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			RequestEndpointService service = new RequestEndpointServiceLocator();
			RequestEndpoint port = (RequestEndpoint) service.getPort(RequestEndpoint.class);
			JAXBContext jaxbContext = JAXBContext.newInstance(Template.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Template templateForm = processingTemplate;
			Formulario form = templateForm.getFormulario();
			List<JAXBElement<?>> itemsFormulario = form.getAccionesOrOutputTextOrInputText();

			for (JAXBElement<?> item : itemsFormulario) {
				Object itemField = item.getValue();
				EntityUpdateUtil.JAXBElementUpdate(
					actionRequest.getParameterMap(), itemField, actionRequest.getLocale());
			}
			StringWriter templateSW = new StringWriter();
			jaxbMarshaller.marshal(templateForm, templateSW);
			CDATAImpl cdataSend = new CDATAImpl(templateSW.toString());
			CDATAImpl cdataResponse = new CDATAImpl(port.execute(cdataSend.toString()));
			if(cdataResponse.getData().equalsIgnoreCase("OK")){
//				actionResponse.setRenderParameter("ENDPROCESS", Boolean.TRUE.toString());
				String urlExito = ParamUtil.getString(actionRequest, "urlExito");
				actionResponse.sendRedirect(urlExito);
			}else if(cdataResponse.getData().equalsIgnoreCase("NEXT")){
				//Next
			}else{
				String urlError = ParamUtil.getString(actionRequest, "urlError");
				if(urlError != null && !urlError.isEmpty()){
					if(!urlError.contains("&taskListErrorProcess=true")){
						urlError = new String(urlError + "&taskListErrorProcess=true");
					}
				}
				LiferayPortletConfig config = (LiferayPortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
				SessionMessages.add(actionRequest, config.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.sendRedirect(urlError);
			}
			System.out.println(cdataResponse);
		}
		catch (JSONException | ParseException | JAXBException | IOException | ServiceException e) {
			log.error(e.getLocalizedMessage());
			SessionErrors.add(actionRequest, e.getCause().getLocalizedMessage());
		}
	}
}
