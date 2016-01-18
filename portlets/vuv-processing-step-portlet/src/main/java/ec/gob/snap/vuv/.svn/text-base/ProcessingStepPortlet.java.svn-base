package ec.gob.snap.vuv;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.xml.internal.ws.util.xml.CDATA;

import ec.gob.snap.request.service.RequestEndpoint;
import ec.gob.snap.request.service.RequestEndpointService;
import ec.gob.snap.request.service.RequestEndpointServiceLocator;
import ec.gob.snap.vuv.dynamic.form.entities.Template;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.Acciones;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Variables;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Variables.Proceso;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.rpc.ServiceException;

/**
 * Portlet implementation class ProcessingStepPortlet
 */
public class ProcessingStepPortlet extends MVCPortlet {

    Log log = LogFactoryUtil.getLog(ProcessingStepPortlet.class);

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse){
	HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
	String param = PortalUtil.getOriginalServletRequest(request).getParameter("id"); 
	try {
	    RequestEndpointService service = new RequestEndpointServiceLocator();
	    RequestEndpoint port = (RequestEndpoint) service.getPort(RequestEndpoint.class);
	    Variables variables = new Variables();
	    String userId = PortalUtil.getUser(renderRequest).getScreenName();
	    Proceso proceso = new Proceso();
	    proceso.setBpm("");
	    if(param != null){
		proceso.setIdProcesoBPM(param);
	    }
	    proceso.setDeploymentId("");
	    proceso.setProcessId("");
	    proceso.setVersion("");
	    proceso.setUserId(userId);
	    proceso.setProcessInstanceId("");
	    proceso.setTaskId("");
	    proceso.setCodOperation(PropsUtil.get("cod.operation"));



	    variables.setProceso(proceso);
	    Template template = new Template();
	    template.setVariables(variables);
	    StringWriter process = new StringWriter();

	    JAXBContext jaxbContext = JAXBContext.newInstance(Template.class);
	    Marshaller marshaller = jaxbContext.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    marshaller.marshal(template, process);

	    CDATA cdata = new CDATA(process.toString());
	    CDATA cdataResponse = new CDATA(port.execute(cdata.getText()));
	    String response = cdataResponse.getText();

	    //Transaction
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    InputStream is = new ByteArrayInputStream(response.getBytes());

	    Template transactionForm = (Template) jaxbUnmarshaller.unmarshal(is);

	    Formulario form = transactionForm.getFormulario();
	    List<JAXBElement<?>> itemsFormulario = form.getAccionesOrOutputTextOrInputText();

	    List<Acciones> actionsForm = new ArrayList<Acciones>();
	    List<JAXBElement<?>> elementsForm = itemsFormulario;
	    for (JAXBElement<?> item : itemsFormulario) {
		Object itemOb = item.getValue();
		if(itemOb instanceof Acciones){
		    actionsForm.add((Acciones)itemOb);
		    elementsForm.remove(item);
		    break;
		}
	    }

	    renderRequest.setAttribute("actionsForm", actionsForm);
	    renderRequest.setAttribute("elementsForm", elementsForm);

	    super.doView(renderRequest, renderResponse);
	} catch (IOException e) {
	    log.error(e.getLocalizedMessage());
	    SessionErrors.add(renderRequest, e.getLocalizedMessage());
	} catch (PortletException e) {
	    log.error(e.getLocalizedMessage());
	    SessionErrors.add(renderRequest, e.getLocalizedMessage());
	} catch (ServiceException e) {
	    log.error(e.getLocalizedMessage());
	    SessionErrors.add(renderRequest, e.getLocalizedMessage());
	} catch (JAXBException e) {
	    log.error(e.getLocalizedMessage());
	    SessionErrors.add(renderRequest, e.getLocalizedMessage());
	} catch (PortalException e) {
	    log.error(e.getLocalizedMessage());
	    SessionErrors.add(renderRequest, e.getLocalizedMessage());
	} catch (SystemException e) {
	    log.error(e.getLocalizedMessage());
	    SessionErrors.add(renderRequest, e.getLocalizedMessage());
	} 
    }

    public void transactionForm(ActionRequest actionRequest, ActionResponse actionResponse) {
	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(Template.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

	    //TODO Solicitar xml al servicio de tramitación
	    ClassLoader currentcl = Thread.currentThread().getContextClassLoader();
	    InputStream xmlStructure = currentcl.getResourceAsStream("xmlGenerado2.xml");

	    Template transactionForm = (Template) jaxbUnmarshaller.unmarshal(xmlStructure);

	    Formulario form = transactionForm.getFormulario();
	    List<JAXBElement<?>> itemsFormulario = form.getAccionesOrOutputTextOrInputText();

	    List<Acciones> actionsForm = new ArrayList<Acciones>();
	    List<JAXBElement<?>> elementsForm = itemsFormulario;
	    for (JAXBElement<?> item : itemsFormulario) {
		Object itemOb = item.getValue();
		if(itemOb instanceof Acciones){
		    actionsForm.add((Acciones)itemOb);
		    elementsForm.remove(item);
		    break;
		}
	    }

	    actionRequest.setAttribute("actionsForm", actionsForm);
	    actionRequest.setAttribute("elementsForm", elementsForm);
	}
	catch (JAXBException e) {
	    log.error(e.getLocalizedMessage());
	    SessionErrors.add(actionRequest, e.getLocalizedMessage());
	}

    }

}
