package ec.gob.snap.vuv;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.util.bridges.mvc.MVCPortlet;

import ec.gob.snap.cases.process.CaseData;
import ec.gob.snap.cases.process.InputCaseData;
import ec.gob.snap.cases.services.WebServiceInterfaceLocator;
import ec.gob.snap.cases.services.WebServiceInterfacePortType;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Arrays;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.rpc.ServiceException;

public class ProcessListPortlet extends MVCPortlet{

	private final Log logger = LogFactoryUtil.getLog(ProcessListPortlet.class);

	//Clases para iconos
	private static final String iconFileGeneric = "fa fa-file-o";
	private static final String iconFileExcel = "fa fa-file-excel-o";
	private static final String iconFilePdf = "fa fa-file-pdf-o";
	private static final String iconFileAudio = "fa fa-file-audio-o";
	private static final String iconFileWord = "fa fa-file-word-o";
	private static final String iconFileImage = "fa fa-file-image-o";
	private static final String iconFileVideo = "fa fa-file-video-o";
	private static final String iconFilePowerPoint = "fa fa-file-powerpoint-o";

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		WebServiceInterfaceLocator webServiceInterfaceLocator = new WebServiceInterfaceLocator();
		WebServiceInterfacePortType webServicePort;
		String processColumns[] = {"processCode", "processName", "processDate", "processDateFinalizacion", "processDocumentosAportados", "processDocumentosGenerados"};
		Integer maxDisplay = 100;
		try {
			webServicePort = webServiceInterfaceLocator.getWebServiceInterfacePort();
			// TODO Cambiar el user id por el del usuario logado
			String userId = "bpmsAdmin";
			InputCaseData inputCaseData = new InputCaseData(userId);
			CaseData[] caseDataArray = webServicePort.execute(inputCaseData);
			JSONArray dataList = JSONFactoryUtil.createJSONArray();
			JSONObject outputData;
			String processCode = "";
			String processName = "";
			String processDate = "";
			String processDateFinalizacion = "";
			//Inicio - Provisional fase 2 (recoger datos de llamada al servicio real)-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			String[] documentosAportados;
			String[] documentosGenerados;
			StringBuilder documentosAportadosStringBuilder;
			StringBuilder documentosGeneradosStringBuilder;
			//Fin - Provisional fase 2 (recoger datos de llamada al servicio real)-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(caseDataArray != null){
				if(caseDataArray.length > maxDisplay){
					caseDataArray = Arrays.copyOf(caseDataArray, maxDisplay);
					SessionMessages.add(resourceRequest.getPortletSession(), "vuv.processlist.maximum.messages");
				}else{
					SessionMessages.clear(resourceRequest.getPortletSession());
				}
				for(CaseData caseData : caseDataArray){
					processCode = caseData.getProcessCode();
					processName = caseData.getProcessName();
					processDate = caseData.getProcessDate();
					processDateFinalizacion = caseData.getProcessDateFinalizacion();
					//Inicio - Provisional fase 2 (recoger datos de llamada al servicio real)-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
					documentosAportadosStringBuilder = new StringBuilder("");
					documentosAportados = new String[3];
					documentosAportados[0] = ".pdf";
					documentosAportados[1] = ".pdf";
					documentosAportados[2] = ".doc";
					if(documentosAportados != null && documentosAportados.length >0){
						for(int i = 0; i < documentosAportados.length; i++){
							//documentosAportadosStringBuilder.append("<a style='cursor:pointer;' href='" + documentosAportados[i] + "'><i class='" + getCssClassFileIcon(documentosAportados[i]) + "'></i></a> ");
							documentosAportadosStringBuilder.append("<a style='cursor:pointer;'><i class='" + getCssClassFileIcon(documentosAportados[i]) + "'></i></a> ");
							if(i < documentosAportados.length - 1){
								documentosAportadosStringBuilder.append(" ");
							}
						}
					}
					documentosGeneradosStringBuilder = new StringBuilder("");
					documentosGenerados = new String[2];
					documentosGenerados[0] = ".doc";
					documentosGenerados[1] = ".png";
					if(documentosGenerados != null && documentosGenerados.length > 0){
						for(int i = 0; i < documentosGenerados.length; i++){
							//documentosGeneradosStringBuilder.append("<a style='cursor:pointer;' href='" + documentosGenerados[i] + "'><i class='" + getCssClassFileIcon(documentosGenerados[i]) + "'></i></a>");
							documentosGeneradosStringBuilder.append("<a style='cursor:pointer;'><i class='" + getCssClassFileIcon(documentosGenerados[i]) + "'></i></a>");
							if(i < documentosGenerados.length - 1){
								documentosGeneradosStringBuilder.append(" ");
							}
						}
					}
					//Fin - Provisional fase 2 (recoger datos de llamada al servicio real)-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
					outputData = JSONFactoryUtil.createJSONObject();
					outputData.put(processColumns[0], processCode);
					outputData.put(processColumns[1], processName);
					outputData.put(processColumns[2], processDate);
					outputData.put(processColumns[3], processDateFinalizacion);
					outputData.put(processColumns[4], documentosAportadosStringBuilder.toString());
					outputData.put(processColumns[5], documentosGeneradosStringBuilder.toString());
					dataList.put(outputData);
				}
			}
			JSONObject outputJSON = JSONFactoryUtil.createJSONObject();
			outputJSON.put("data", dataList);
			resourceResponse.getWriter().write(outputJSON.toString());
		}
		catch (ServiceException e) {
			logger.error(e.getLocalizedMessage());
			SessionErrors.add(resourceRequest, e.getLocalizedMessage());
		}catch (ConnectException e) {
			logger.error(e.getLocalizedMessage());
			SessionErrors.add(resourceRequest, e.getLocalizedMessage());
		}
	}

	/**
	 * Devuelve la clase para el icono de acceso al documento en función del tipo de archivo al que apunta la ruta especificada
	 * @param enlace URL de localización del archivo en cuestión.
	 * @return
	 */
	public String getCssClassFileIcon(String enlace){
		String clase;
		if(enlace != null && !enlace.isEmpty()){
			String enlaceLowerCase = enlace.toLowerCase();
			if(enlaceLowerCase.contains(".xls")){
				clase = iconFileExcel;
			}else{
				if(enlaceLowerCase.contains(".png") || enlaceLowerCase.contains(".jpg") || enlaceLowerCase.contains(".gif")){
					clase = iconFileImage;
				}else{
					if(enlaceLowerCase.contains(".doc") || enlaceLowerCase.contains(".docx")){
						clase = iconFileWord;
					}else{
						if(enlaceLowerCase.contains(".pdf")){
							clase = iconFilePdf;
						}else{
							if(enlaceLowerCase.contains(".mp4") || enlaceLowerCase.contains(".avi") || enlaceLowerCase.contains(".mpeg") || enlaceLowerCase.contains(".flv") || enlaceLowerCase.contains(".mkv")){
								clase = iconFileVideo;
							}else{
								if(enlaceLowerCase.contains(".pptx") || enlaceLowerCase.contains(".ppt")){
									clase = iconFilePowerPoint;
								}else{
									if(enlaceLowerCase.contains(".mp3")){
										clase = iconFileAudio;
									}else{
										clase = iconFileGeneric;
									}
								}
							}
						}
					}
				}
			}
		}else{
			clase = iconFileGeneric;
		}
		return clase;
	}
}
