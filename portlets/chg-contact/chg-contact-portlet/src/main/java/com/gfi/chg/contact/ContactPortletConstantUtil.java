package com.gfi.chg.contact;

public class ContactPortletConstantUtil {
	public static final int NEW = 0;
	public static final int RECIVED = 1;
	public static final int FINISHED = 2;
	public static final String DEFAULT_AREA_NAME = "Registro General";
	public static final String NEW_CONTACT_TRAZING_MESSAGE = "Entrada en el sistema";
	public static final String FINAL_CONTACT_TRAZING_MESSAGE_RESPONSE = "Respuesta emitida";
	public static final String FINAL_CONTACT_TRAZING_MESSAGE_FINISHED = "Finalizado";
	public static final String CONTACT_SUBJECT = "Nueva Solicitud de Información.";
	public static final String CONTACT_SUBJECT_RESEND = "Reenvio solicitud información.";
	public static final String CONTACT_RESPONSE = "Respuesta a solicitud de información.";
	public static final String NEW_CONTACT_MAIL = "Ha recivido una nueva petición de información. Acceda al área de peticiones del portal de CHG para completarla.";
	public static final String RESEND_CONTACT_MAIL = "Se le ha delegado una nueva petición de información. Acceda al área de peticiones del portal de CHG para completarla.";

	
	public static String statusTranslate(int status){
		String res;
		if(status == 0){
			res = "Nuevo";
		}else if(status == 1){
			res = "Recivido";
		}else if(status == 2){
			res = "Finalizado";
		}else{
			res = null;
		}
		return res;
	}
}
