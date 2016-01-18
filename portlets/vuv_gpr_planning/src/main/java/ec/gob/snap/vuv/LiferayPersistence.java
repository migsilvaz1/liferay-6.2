/* 
 * This file is part of the VUV Electronic Office of Government of Ecuador.
 * Copyright 2015.
 */

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.LiferayPersistence.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of xxxxxxxxxx.</p>
 * <b>Date:</b><p>3/7/2015.</p>
 * @version 1.0, 3/7/2015.
 */

package ec.gob.snap.vuv;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Attribute;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplate;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.util.DDMXMLUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalFolder;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalFolderLocalServiceUtil;

import ec.gob.administracionpublica.wsGPRServices.Indicator;
import ec.gob.administracionpublica.wsGPRServices.InstitutionalActivity;
import ec.gob.administracionpublica.wsGPRServices.Service;
import ec.gob.administracionpublica.wsGPRServices.ServiceCase;
import ec.gob.administracionpublica.wsGPRServices.ServiceCaseStep;
import ec.gob.administracionpublica.wsGPRServices.ServiceCenterExtended;
import ec.gob.administracionpublica.wsGPRServices.ServiceCharter;
import ec.gob.administracionpublica.wsGPRServices.ServiceOfficeInfo;
import ec.gob.administracionpublica.wsGPRServices.ServiceRequisite;
import ec.gob.snap.vuv.model.Act_Institucional;
import ec.gob.snap.vuv.model.Caso;
import ec.gob.snap.vuv.model.Centro;
import ec.gob.snap.vuv.model.Indicador;
import ec.gob.snap.vuv.model.Institucion;
import ec.gob.snap.vuv.model.Paso;
import ec.gob.snap.vuv.model.Requisito;
import ec.gob.snap.vuv.model.Servicio;
import ec.gob.snap.vuv.service.Act_InstitucionalLocalServiceUtil;
import ec.gob.snap.vuv.service.CasoLocalServiceUtil;
import ec.gob.snap.vuv.service.CentroLocalServiceUtil;
import ec.gob.snap.vuv.service.IndicadorLocalServiceUtil;
import ec.gob.snap.vuv.service.InstitucionLocalServiceUtil;
import ec.gob.snap.vuv.service.PasoLocalServiceUtil;
import ec.gob.snap.vuv.service.RequisitoLocalServiceUtil;
import ec.gob.snap.vuv.service.ServicioLocalServiceUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * <p>Class for liferay persistence of GPR elements.</p>
 * <b>Project:</b><p>VUV</p>
 * 
 * @version 1.0, 3/7/2015.
 */
public class LiferayPersistence {

	/**
	 * Attribute that represents the system log.
	 */
	private static Log log = LogFactoryUtil.getLog(LiferayPersistence.class);

	// INSTITUCIONES
	public static JournalArticle createInstitucion(
		ServiceOfficeInfo institucion, ServiceCharter serviceCharter) {

		JournalArticle ja = null;
		try {
			if (validateElement(institucion.getId())) {
				long gprId = Long.parseLong(institucion.getId());

				DDMStructure structure = getStructure("institucion.structure");
				DDMTemplate template = getTemplate("institucion.template");
				// Data for Journal Article
				long groupId = structure.getGroupId();
				long userId = structure.getUserId();
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(new Locale("es", "ES"), institucion.getShortName());
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAssetEntryVisible(true);
				Map<String, String> values = new HashMap<String, String>();
				values.put("name", institucion.getShortName());
				values.put("description", institucion.getName());
				values.put("totalServices", institucion.getTotalServices());
				values.put(
					"servicesInOperation", institucion.getServicesInOperation());
				if (Validator.isNull(serviceCharter)) {
					values.put("contact", "");
				}
				else {
					values.put("contact", serviceCharter.getContactInfo());
				}
				String content = generateXmlContent(structure, values);
				GregorianCalendar date =
					(GregorianCalendar) Calendar.getInstance(
						TimeZone.getTimeZone("Europe/Madrid"), new Locale(
							"es", "ES"));
				JournalFolder folder =
					JournalFolderLocalServiceUtil.fetchFolder(
						groupId, PropsUtil.get("institucion.folder"));
				// JournalArticle registration
				ja =
					JournalArticleLocalServiceUtil.addArticle(
						userId, groupId, folder.getFolderId(), 0L, 0L, "",
						true, 1.0, titleMap, null, content, "general",
						structure.getStructureKey(), template.getTemplateKey(),
						null, date.get(Calendar.MONTH),
						date.get(Calendar.DAY_OF_MONTH),
						date.get(Calendar.YEAR), 0, 0, 0, 0, 0, 0, 0, true, 0,
						0, 0, 0, 0, true, true, false, null, null, null, null,
						serviceContext);
				// Index Registration
				long contentId = ja.getResourcePrimKey();
				Date timestamp = new Date();
				InstitucionLocalServiceUtil.addInstitucion(
					gprId, contentId, timestamp);
			}
		}
		catch (SystemException e) {
			log.error("Error fetching institution structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error saving new institution: " + e);
		}
		return ja;
	}

	public static JournalArticle updateInstitucion(
		ServiceOfficeInfo institucion, ServiceCharter serviceCharter) {

		JournalArticle ja = null;
		boolean update = true;
		try {
			DDMStructure structure = getStructure("institucion.structure");
			if (validateElement(institucion.getId())) {
				long gprId = Long.parseLong(institucion.getId());
				Institucion dbInstitucion =
					InstitucionLocalServiceUtil.getInstitucionBygprId(gprId);

				if (Validator.isNotNull(serviceCharter)) {
					String gprStringDate = serviceCharter.getLastUpdateDate();
					if (!gprStringDate.isEmpty()) {
						SimpleDateFormat sdf =
							new SimpleDateFormat("dd/MM/yyyy");
						Date gprDate = sdf.parse(gprStringDate);
						Date localDate = dbInstitucion.getTimeStamp();
						if (gprDate.before(localDate)) {
							update = false;
						}
					}
				}
				if (update) {
					ja =
						JournalArticleLocalServiceUtil.getLatestArticle(dbInstitucion.getContent());

					Map<String, String> values = new HashMap<String, String>();
					values.put("name", institucion.getShortName());
					values.put("description", institucion.getName());
					values.put("totalServices", institucion.getTotalServices());
					values.put(
						"servicesInOperation",
						institucion.getServicesInOperation());
					if (Validator.isNull(serviceCharter)) {
						values.put("contact", "");
					}
					else {
						values.put("contact", serviceCharter.getContactInfo());
					}

					String newContent = generateXmlContent(structure, values);
					ja.setContent(newContent);
					JournalArticleLocalServiceUtil.updateJournalArticle(ja);

					dbInstitucion.setTimeStamp(new Date());
					InstitucionLocalServiceUtil.deleteInstitucion(dbInstitucion);
					InstitucionLocalServiceUtil.addInstitucion(dbInstitucion);
				}
			}
		}
		catch (SystemException e) {
			log.error("Error fetching institution structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error updating institution: " + e);
		}
		catch (ParseException e) {
			log.error("Error parsing date from gpr: " + e);
		}
		return ja;
	}

	public static void activateInstitution(String institucionGprId) {

		try {
			if (validateElement(institucionGprId)) {
				long gprId = Long.parseLong(institucionGprId);
				Institucion persistedInstitution =
					InstitucionLocalServiceUtil.getInstitucionBygprId(gprId);
				long resourcePrimkey = persistedInstitution.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_APPROVED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error activating institution");
		}
		catch (SystemException e) {
			log.error(e + "Error activating institution");
		}
	}

	public static void expireInstitucion(String institucionGprId) {

		try {
			if (validateElement(institucionGprId)) {
				long gprId = Long.parseLong(institucionGprId);
				Institucion persistedInstitution =
					InstitucionLocalServiceUtil.getInstitucionBygprId(gprId);
				long resourcePrimkey = persistedInstitution.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error expiring institution");
		}
		catch (SystemException e) {
			log.error(e + "Error expiring institution");
		}
	}

	public static boolean isNewInstitucion(ServiceOfficeInfo institucion) {

		boolean isNew = true;
		if (validateElement(institucion.getId())) {
			long gprId = Long.parseLong(institucion.getId());
			Institucion intento =
				InstitucionLocalServiceUtil.getInstitucionBygprId(gprId);
			if (Validator.isNull(intento)) {
				isNew = true;
			}
			else {
				isNew = false;
			}
		}
		return isNew;
	}

	public static int expireInactiveInstitutions(
		List<String> activeInstituciones) {

		int count = 0;
		List<Institucion> dbInstituciones =
			InstitucionLocalServiceUtil.getAllInstituciones();
		for (Institucion local : dbInstituciones) {
			String gprId = String.valueOf(local.getId_GPR_institucion());
			if (!activeInstituciones.contains(gprId)) {
				expireInstitucion(gprId);
				count++;
			}
		}
		return count;
	}

	// SERVICIOS
	public static JournalArticle createServicio(
		Service servicio, String id_institucion) {

		JournalArticle ja = null;
		try {
			if (validateElement(id_institucion) &&
				validateElement(servicio.getId())) {

				DDMStructure structure = getStructure("servicio.structure");
				DDMTemplate template = getTemplate("servicio.template");
				// Data for Journal Article
				long groupId = structure.getGroupId();
				long userId = structure.getUserId();
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(new Locale("es", "ES"), servicio.getCode());
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAssetEntryVisible(true);
				Map<String, String> values = new HashMap<String, String>();
				values.put("name", servicio.getName());
				values.put("description", servicio.getDescription());
				values.put(
					"receiver",
					servicio.getCustomers() + "#" +
						servicio.getCustomersLegal() + "#" +
						servicio.getCustomersGovernment() + "#" +
						servicio.getCustomersOngs());
				values.put("gender", "[\"both\"]");
				values.put("age", "25");
				values.put("type", servicio.getType());
				values.put("language", servicio.getLanguages());
				values.put("status", "operation");
				values.put("contact", servicio.getComplaints());
				values.put("serviceType", "[\"0\"]");
				String content = generateXmlContent(structure, values);
				GregorianCalendar date =
					(GregorianCalendar) Calendar.getInstance(
						TimeZone.getTimeZone("Europe/Madrid"), new Locale(
							"es", "ES"));
				JournalFolder folder =
					JournalFolderLocalServiceUtil.fetchFolder(
						groupId, PropsUtil.get("servicio.folder"));
				// JournalArticle registration
				ja =
					JournalArticleLocalServiceUtil.addArticle(
						userId, groupId, folder.getFolderId(), 0L, 0L, "",
						true, 1.0, titleMap, null, content, "general",
						structure.getStructureKey(), template.getTemplateKey(),
						null, date.get(Calendar.MONTH),
						date.get(Calendar.DAY_OF_MONTH),
						date.get(Calendar.YEAR), 0, 0, 0, 0, 0, 0, 0, true, 0,
						0, 0, 0, 0, true, true, false, null, null, null, null,
						serviceContext);
				// Index Registration
				long gprId = Long.parseLong(servicio.getId());
				long contentId = ja.getResourcePrimKey();
				Date timestamp = new Date();
				long institucionGprId = Long.parseLong(id_institucion);
				Institucion institucion =
					InstitucionLocalServiceUtil.getInstitucionBygprId(institucionGprId);
				ServicioLocalServiceUtil.addServicio(
					gprId, contentId, timestamp,
					institucion.getId_institucion());
			}
		}
		catch (SystemException e) {
			log.error("Error fetching service structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error saving new service: " + e);
		}
		return ja;
	}

	public static boolean updateServicio(Service servicio) {

		JournalArticle ja = null;
		boolean update = true;
		try {
			if (validateElement(servicio.getId())) {
				DDMStructure structure = getStructure("servicio.structure");
				long gprId = Long.parseLong(servicio.getId());
				Servicio dbServicio =
					ServicioLocalServiceUtil.getServicioBygprId(gprId);

				long serverts = Long.parseLong(servicio.getTimeStamp());
				Date gprDate = new Date(serverts);
				Date localDate = dbServicio.getTimeStamp();
				if (gprDate.before(localDate)) {
					update = false;
				}

				if (update) {
					ja =
						JournalArticleLocalServiceUtil.getLatestArticle(dbServicio.getContent());

					String gender = getNodeValue(ja.getContent(), "gender");
					String age = getNodeValue(ja.getContent(), "age");
					String status = getNodeValue(ja.getContent(), "status");

					Map<String, String> values = new HashMap<String, String>();
					values.put("name", servicio.getName());
					values.put("description", servicio.getDescription());
					values.put(
						"receiver",
						servicio.getCustomers() + "#" +
							servicio.getCustomersLegal() + "#" +
							servicio.getCustomersGovernment() + "#" +
							servicio.getCustomersOngs());
					values.put("gender", gender);
					values.put("age", age);
					values.put("type", servicio.getType());
					values.put("language", servicio.getLanguages());
					values.put("status", status);
					values.put("contact", servicio.getComplaints());

					String newContent = generateXmlContent(structure, values);
					ja.setContent(newContent);
					JournalArticleLocalServiceUtil.updateJournalArticle(ja);

					dbServicio.setTimeStamp(new Date());
					ServicioLocalServiceUtil.updateServicio(dbServicio);
				}
			}
		}
		catch (SystemException e) {
			log.error("Error fetching service structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error updating service: " + e);
		}
		return update;
	}

	public static void activateServicio(String servicioGprId) {

		try {
			if (validateElement(servicioGprId)) {
				long gprId = Long.parseLong(servicioGprId);
				Servicio persistedServicio =
					ServicioLocalServiceUtil.getServicioBygprId(gprId);
				long resourcePrimkey = persistedServicio.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_APPROVED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error activating service");
		}
		catch (SystemException e) {
			log.error(e + "Error activating service");
		}
	}

	public static void expireServicio(String servicioGprId) {

		try {
			if (validateElement(servicioGprId)) {
				long gprId = Long.parseLong(servicioGprId);
				Servicio persistedServicio =
					ServicioLocalServiceUtil.getServicioBygprId(gprId);
				long resourcePrimkey = persistedServicio.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error expiring service");
		}
		catch (SystemException e) {
			log.error(e + "Error expiring service");
		}
	}

	public static boolean isNewServicio(Service servicio) {

		boolean isNew = true;
		if (validateElement(servicio.getId())) {
			long gprId = Long.parseLong(servicio.getId());
			Servicio intento =
				ServicioLocalServiceUtil.getServicioBygprId(gprId);
			if (Validator.isNull(intento)) {
				isNew = true;
			}
			else {
				isNew = false;
			}
		}
		return isNew;
	}

	public static int expireInactiveServicios(List<String> activeServiciosParam) {

		int count = 0;
		for (Servicio servicio : ServicioLocalServiceUtil.getAllServicios()) {
			if (!activeServiciosParam.contains(String.valueOf(servicio.getId_GPR_servicio()))) {
				long servicioId = servicio.getId_servicio();
				for (Act_Institucional actividad : ServicioLocalServiceUtil.getAllActInstByIdServicio(servicioId)) {
					expireActividadInstitucional(String.valueOf(actividad.getId_GPR_act_institucional()));
				}
				for (Indicador indicador : ServicioLocalServiceUtil.getAllIndicadoresByIdServicio(servicioId)) {
					expireIndicador(String.valueOf(indicador.getId_GPR_indicador()));
				}
				for (Caso caso : ServicioLocalServiceUtil.getAllCasosByIdServicio(servicioId)) {
					long casoId = caso.getId_caso();
					for (Centro centro : CasoLocalServiceUtil.getAllCentrosByIdCaso(casoId)) {
						expireCentro(String.valueOf(centro.getId_centro()));
					}
					for (Paso paso : CasoLocalServiceUtil.getAllPasosByIdCaso(casoId)) {
						for (Requisito requisito : PasoLocalServiceUtil.getAllRequisitosByIdPaso(paso.getId_paso())) {
							expireRequisito(String.valueOf(requisito.getId_GPR_requisito()));
						}
						expirePaso(String.valueOf(paso.getId_GPR_paso()));
					}
					expireCaso(String.valueOf(caso.getId_GPR_caso()));
				}
				expireServicio(String.valueOf(servicio.getId_GPR_servicio()));
				count++;
			}
		}
		return count;
	}

	// CASOS
	public static JournalArticle createCaso(ServiceCase caso, String id_servicio) {

		JournalArticle ja = null;
		try {
			if (validateElement(id_servicio) && validateElement(caso.getId())) {

				DDMStructure structure = getStructure("caso.structure");
				DDMTemplate template = getTemplate("caso.template");
				// Data for Journal Article
				long groupId = structure.getGroupId();
				long userId = structure.getUserId();
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(new Locale("es", "ES"), caso.getName());
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAssetEntryVisible(true);
				Map<String, String> values = new HashMap<String, String>();
				values.put("name", caso.getName());
				values.put("description", caso.getDescription());
				values.put("totalCost", caso.getTotalCost());
				values.put("procedure", caso.getProcedure());
				String content = generateXmlContent(structure, values);
				GregorianCalendar date =
					(GregorianCalendar) Calendar.getInstance(
						TimeZone.getTimeZone("Europe/Madrid"), new Locale(
							"es", "ES"));
				JournalFolder folder =
					JournalFolderLocalServiceUtil.fetchFolder(
						groupId, PropsUtil.get("caso.folder"));
				// JournalArticle registration
				List<Layout> layouts;
				String layoutUuid = "";
				layouts =
					LayoutLocalServiceUtil.getLayouts(
						0, LayoutLocalServiceUtil.getLayoutsCount());
				for (Layout layout : layouts) {
					if (layout.getName().contains(PropsUtil.get("caso.layout"))) {
						layoutUuid = layout.getUuid();
					}
				}

				ja =
					JournalArticleLocalServiceUtil.addArticle(
						userId, groupId, folder.getFolderId(), 0L, 0L, "",
						true, 1.0, titleMap, null, content, "general",
						structure.getStructureKey(), template.getTemplateKey(),
						layoutUuid, date.get(Calendar.MONTH),
						date.get(Calendar.DAY_OF_MONTH),
						date.get(Calendar.YEAR), 0, 0, 0, 0, 0, 0, 0, true, 0,
						0, 0, 0, 0, true, true, false, null, null, null, null,
						serviceContext);
				// Index Registration
				long gprId = Long.parseLong(caso.getId());
				long contentId = ja.getResourcePrimKey();
				Date timestamp = new Date();
				long servicioGprId = Long.parseLong(id_servicio);
				Servicio servicio =
					ServicioLocalServiceUtil.getServicioBygprId(servicioGprId);
				CasoLocalServiceUtil.addCaso(
					gprId, contentId, timestamp, servicio.getId_servicio());
			}
		}
		catch (SystemException e) {
			log.error("Error fetching case structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error saving new case: " + e);
		}
		return ja;
	}

	public static JournalArticle updateCaso(ServiceCase caso) {

		JournalArticle ja = null;
		boolean update = false;
		try {
			if (validateElement(caso.getId())) {
				DDMStructure structure = getStructure("caso.structure");
				long gprId = Long.parseLong(caso.getId());
				Caso dbCaso = CasoLocalServiceUtil.getCasoBygprId(gprId);

				long serverts = Long.parseLong(caso.getTimeStamp());
				Date gprDate = new Date(serverts);
				Date localDate = dbCaso.getTimeStamp();
				if (gprDate.after(localDate)) {
					update = true;
				}

				if (update) {
					ja =
						JournalArticleLocalServiceUtil.getLatestArticle(dbCaso.getContent());

					Map<String, String> values = new HashMap<String, String>();
					values.put("name", caso.getName());
					values.put("description", caso.getDescription());
					values.put("totalCost", caso.getTotalCost());
					values.put("procedure", caso.getProcedure());

					String newContent = generateXmlContent(structure, values);
					ja.setContent(newContent);
					JournalArticleLocalServiceUtil.updateJournalArticle(ja);

					dbCaso.setTimeStamp(new Date());
					CasoLocalServiceUtil.updateCaso(dbCaso);
				}
			}
		}
		catch (SystemException e) {
			log.error("Error fetching case structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error updating case: " + e);
		}
		return ja;
	}

	public static void activateCaso(String casoGprId) {

		try {
			if (validateElement(casoGprId)) {
				long gprId = Long.parseLong(casoGprId);
				Caso persistedCaso = CasoLocalServiceUtil.getCasoBygprId(gprId);
				long resourcePrimkey = persistedCaso.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_APPROVED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error activating case");
		}
		catch (SystemException e) {
			log.error(e + "Error activating case");
		}
	}

	public static void expireCaso(String casoGprId) {

		try {
			if (validateElement(casoGprId)) {
				long gprId = Long.parseLong(casoGprId);
				Caso persistedCaso = CasoLocalServiceUtil.getCasoBygprId(gprId);
				long resourcePrimkey = persistedCaso.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error expiring case");
		}
		catch (SystemException e) {
			log.error(e + "Error expiring case");
		}
	}

	public static boolean isNewCaso(ServiceCase caso) {

		boolean isNew = true;
		if (validateElement(caso.getId())) {
			long gprId = Long.parseLong(caso.getId());
			Caso intento = CasoLocalServiceUtil.getCasoBygprId(gprId);
			if (Validator.isNull(intento)) {
				isNew = true;
			}
			else {
				isNew = false;
			}
		}
		return isNew;
	}

	// INDICADORES
	public static JournalArticle createIndicador(
		Indicator indicador, String id_servicio) {

		JournalArticle ja = null;
		try {
			if (validateElement(indicador.getUid_indicator()) &&
				validateElement(id_servicio)) {

				DDMStructure structure = getStructure("indicador.structure");
				DDMTemplate template = getTemplate("indicador.template");
				// Data for Journal Article
				long groupId = structure.getGroupId();
				long userId = structure.getUserId();
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(new Locale("es", "ES"), indicador.getName());
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAssetEntryVisible(true);
				Map<String, String> values = new HashMap<String, String>();
				values.put("name", indicador.getName());
				values.put("description", indicador.getDescription());
				String content = generateXmlContent(structure, values);
				GregorianCalendar date =
					(GregorianCalendar) Calendar.getInstance(
						TimeZone.getTimeZone("Europe/Madrid"), new Locale(
							"es", "ES"));
				JournalFolder folder =
					JournalFolderLocalServiceUtil.fetchFolder(
						groupId, PropsUtil.get("indicador.folder"));
				// JournalArticle registration
				ja =
					JournalArticleLocalServiceUtil.addArticle(
						userId, groupId, folder.getFolderId(), 0L, 0L, "",
						true, 1.0, titleMap, null, content, "general",
						structure.getStructureKey(), template.getTemplateKey(),
						null, date.get(Calendar.MONTH),
						date.get(Calendar.DAY_OF_MONTH),
						date.get(Calendar.YEAR), 0, 0, 0, 0, 0, 0, 0, true, 0,
						0, 0, 0, 0, true, true, false, null, null, null, null,
						serviceContext);
				// Index Registration
				long gprId = Long.parseLong(indicador.getUid_indicator());
				long contentId = ja.getResourcePrimKey();
				Date timestamp = new Date();
				long servicioGprId = Long.parseLong(id_servicio);
				Servicio servicio =
					ServicioLocalServiceUtil.getServicioBygprId(servicioGprId);
				IndicadorLocalServiceUtil.addIndicador(
					gprId, contentId, timestamp, servicio.getId_servicio());
			}
		}
		catch (SystemException e) {
			log.error("Error fetching indicator structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error saving new indicator: " + e);
		}
		return ja;
	}

	public static JournalArticle updateIndicador(Indicator indicador) {

		JournalArticle ja = null;
		try {
			if (validateElement(indicador.getUid_indicator())) {

				DDMStructure structure = getStructure("indicador.structure");
				long gprId = Long.parseLong(indicador.getUid_indicator());
				Indicador dbIndicador =
					IndicadorLocalServiceUtil.getIndicadorBygprId(gprId);
				ja =
					JournalArticleLocalServiceUtil.getLatestArticle(dbIndicador.getContent());

				Map<String, String> values = new HashMap<String, String>();
				values.put("name", indicador.getName());
				values.put("description", indicador.getDescription());

				String newContent = generateXmlContent(structure, values);
				ja.setContent(newContent);
				JournalArticleLocalServiceUtil.updateJournalArticle(ja);

				dbIndicador.setTimeStamp(new Date());
				IndicadorLocalServiceUtil.updateIndicador(dbIndicador);
			}
		}
		catch (SystemException e) {
			log.error("Error fetching indicator structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error updating indicator: " + e);
		}
		return ja;
	}

	public static void activateIndicador(String indicadorUid) {

		try {
			if (validateElement(indicadorUid)) {
				long gprId = Long.parseLong(indicadorUid);
				Indicador persistedIndicador =
					IndicadorLocalServiceUtil.getIndicadorBygprId(gprId);
				long resourcePrimkey = persistedIndicador.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_APPROVED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error activating indicator");
		}
		catch (SystemException e) {
			log.error(e + "Error activating indicator");
		}
	}

	public static void expireIndicador(String indicadorUid) {

		try {
			if (validateElement(indicadorUid)) {
				long gprId = Long.parseLong(indicadorUid);
				Indicador persistedIndicador =
					IndicadorLocalServiceUtil.getIndicadorBygprId(gprId);
				long resourcePrimkey = persistedIndicador.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error expiring indicator");
		}
		catch (SystemException e) {
			log.error(e + "Error expiring indicator");
		}
	}

	public static boolean isNewIndicador(Indicator indicador) {

		boolean isNew = true;
		if (validateElement(indicador.getUid_indicator())) {
			long gprId = Long.parseLong(indicador.getUid_indicator());
			Indicador intento =
				IndicadorLocalServiceUtil.getIndicadorBygprId(gprId);
			if (Validator.isNull(intento)) {
				isNew = true;
			}
			else {
				isNew = false;
			}
		}
		return isNew;
	}

	// ACTIVIADADES INSTITUCIONALES
	public static JournalArticle createActividadInstitucional(
		InstitutionalActivity actividadInstitucional, String id_servicio) {

		JournalArticle ja = null;
		try {
			if (validateElement(id_servicio) &&
				validateElement(actividadInstitucional.getId())) {
				DDMStructure structure =
					getStructure("actividadinstitucional.structure");
				DDMTemplate template =
					getTemplate("actividadinstitucional.template");
				// Data for Journal Article
				long groupId = structure.getGroupId();
				long userId = structure.getUserId();
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(
					new Locale("es", "ES"), actividadInstitucional.getId());
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAssetEntryVisible(true);
				Map<String, String> values = new HashMap<String, String>();
				values.put(
					"description", actividadInstitucional.getDescription());
				String content = generateXmlContent(structure, values);
				GregorianCalendar date =
					(GregorianCalendar) Calendar.getInstance(
						TimeZone.getTimeZone("Europe/Madrid"), new Locale(
							"es", "ES"));
				JournalFolder folder =
					JournalFolderLocalServiceUtil.fetchFolder(
						groupId, PropsUtil.get("actividadinstitucional.folder"));
				// JournalArticle registration
				ja =
					JournalArticleLocalServiceUtil.addArticle(
						userId, groupId, folder.getFolderId(), 0L, 0L, "",
						true, 1.0, titleMap, null, content, "general",
						structure.getStructureKey(), template.getTemplateKey(),
						null, date.get(Calendar.MONTH),
						date.get(Calendar.DAY_OF_MONTH),
						date.get(Calendar.YEAR), 0, 0, 0, 0, 0, 0, 0, true, 0,
						0, 0, 0, 0, true, true, false, null, null, null, null,
						serviceContext);
				// Index Registration
				long gprId = Long.parseLong(actividadInstitucional.getId());
				long contentId = ja.getResourcePrimKey();
				Date timestamp = new Date();
				long servicioGprId = Long.parseLong(id_servicio);
				Servicio servicio =
					ServicioLocalServiceUtil.getServicioBygprId(servicioGprId);
				Act_InstitucionalLocalServiceUtil.addAct_Institucional(
					gprId, contentId, timestamp, servicio.getId_servicio());
			}
		}
		catch (SystemException e) {
			log.error("Error fetching institutional activity structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error saving new institutional activity: " + e);
		}
		return ja;
	}

	public static JournalArticle updateActividadInstitucional(
		InstitutionalActivity actividadInstitucional) {

		JournalArticle ja = null;
		try {
			if (validateElement(actividadInstitucional.getId())) {
				DDMStructure structure =
					getStructure("actividadinstitucional.structure");
				long gprId = Long.parseLong(actividadInstitucional.getId());
				Act_Institucional dbActividad =
					Act_InstitucionalLocalServiceUtil.getAct_InstitucionalBygprId(gprId);
				ja =
					JournalArticleLocalServiceUtil.getLatestArticle(dbActividad.getContent());

				Map<String, String> values = new HashMap<String, String>();
				values.put(
					"description", actividadInstitucional.getDescription());

				String newContent = generateXmlContent(structure, values);
				ja.setContent(newContent);
				JournalArticleLocalServiceUtil.updateJournalArticle(ja);

				dbActividad.setTimeStamp(new Date());
				Act_InstitucionalLocalServiceUtil.updateAct_Institucional(dbActividad);
			}
		}
		catch (SystemException e) {
			log.error("Error fetching institutional activity structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error updating institutional activity: " + e);
		}
		return ja;
	}

	public static void activateActividadInstitucional(
		String actividadInstitucionalGprId) {

		try {
			if (validateElement(actividadInstitucionalGprId)) {
				long gprId = Long.parseLong(actividadInstitucionalGprId);
				Act_Institucional persistedActInstitucional =
					Act_InstitucionalLocalServiceUtil.getAct_InstitucionalBygprId(gprId);
				long resourcePrimkey = persistedActInstitucional.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_APPROVED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error activating institutional activity");
		}
		catch (SystemException e) {
			log.error(e + "Error activating institutional activity");
		}
	}

	public static void expireActividadInstitucional(
		String actividadInstitucionalGprId) {

		try {
			if (validateElement(actividadInstitucionalGprId)) {
				long gprId = Long.parseLong(actividadInstitucionalGprId);
				Act_Institucional persistedActInstitucional =
					Act_InstitucionalLocalServiceUtil.getAct_InstitucionalBygprId(gprId);
				long resourcePrimkey = persistedActInstitucional.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error expiring institutional activity");
		}
		catch (SystemException e) {
			log.error(e + "Error expiring institutional activity");
		}
	}

	public static boolean isNewActividadInstitucional(
		InstitutionalActivity actividadInstitucional) {

		boolean isNew = true;
		if (validateElement(actividadInstitucional.getId())) {
			long gprId = Long.parseLong(actividadInstitucional.getId());
			Act_Institucional intento =
				Act_InstitucionalLocalServiceUtil.getAct_InstitucionalBygprId(gprId);
			if (Validator.isNull(intento)) {
				isNew = true;
			}
			else {
				isNew = false;
			}
		}
		return isNew;
	}

	// CENTROS
	public static JournalArticle createCentro(
		ServiceCenterExtended centro, String id_caso) {

		JournalArticle ja = null;
		try {
			if (validateElement(id_caso) && validateElement(centro.getId())) {
				DDMStructure structure = getStructure("centro.structure");
				DDMTemplate template = getTemplate("centro.template");
				// Data for Journal Article
				long groupId = structure.getGroupId();
				long userId = structure.getUserId();
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(new Locale("es", "ES"), centro.getName());
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAssetEntryVisible(true);
				Map<String, String> values = new HashMap<String, String>();
				values.put("office", centro.getOffice());
				values.put("name", centro.getName());
				values.put("address", centro.getAddress());
				values.put("zip", centro.getZip());
				values.put("circuit", centro.getLocationCicuito());
				values.put("canton", centro.getLocationCanton());
				values.put("distrit", centro.getLocationDistrito());
				values.put("zone", centro.getLocationZona());
				values.put("latitude", centro.getLatitude());
				values.put("longitude", centro.getLongitude());
				values.put("score", centro.getScore());

				String content = generateXmlContent(structure, values);
				GregorianCalendar date =
					(GregorianCalendar) Calendar.getInstance(
						TimeZone.getTimeZone("Europe/Madrid"), new Locale(
							"es", "ES"));
				JournalFolder folder =
					JournalFolderLocalServiceUtil.fetchFolder(
						groupId, PropsUtil.get("centro.folder"));
				// JournalArticle registration
				ja =
					JournalArticleLocalServiceUtil.addArticle(
						userId, groupId, folder.getFolderId(), 0L, 0L, "",
						true, 1.0, titleMap, null, content, "general",
						structure.getStructureKey(), template.getTemplateKey(),
						null, date.get(Calendar.MONTH),
						date.get(Calendar.DAY_OF_MONTH),
						date.get(Calendar.YEAR), 0, 0, 0, 0, 0, 0, 0, true, 0,
						0, 0, 0, 0, true, true, false, null, null, null, null,
						serviceContext);
				// Index Registration
				long gprId = Long.parseLong(centro.getId());
				long contentId = ja.getResourcePrimKey();
				Date timestamp = new Date();
				long casoGprId = Long.parseLong(id_caso);
				Caso caso = CasoLocalServiceUtil.getCasoBygprId(casoGprId);
				CentroLocalServiceUtil.addCentro(
					gprId, contentId, timestamp, caso.getId_caso());
			}
		}
		catch (SystemException e) {
			log.error("Error fetching center structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error saving new center: " + e);
		}
		return ja;
	}

	public static JournalArticle updateCentro(ServiceCenterExtended centro) {

		JournalArticle ja = null;
		try {
			if (validateElement(centro.getId())) {
				DDMStructure structure = getStructure("centro.structure");
				long gprId = Long.parseLong(centro.getId());
				Centro dbCentro =
					CentroLocalServiceUtil.getCentroBygprId(gprId);
				ja =
					JournalArticleLocalServiceUtil.getLatestArticle(dbCentro.getContent());

				Map<String, String> values = new HashMap<String, String>();
				values.put("office", centro.getOffice());
				values.put("name", centro.getName());
				values.put("address", centro.getAddress());
				values.put("zip", centro.getZip());
				values.put("circuit", centro.getLocationCicuito());
				values.put("canton", centro.getLocationCanton());
				values.put("distrit", centro.getLocationDistrito());
				values.put("zone", centro.getLocationZona());
				values.put("latitude", centro.getLatitude());
				values.put("longitude", centro.getLongitude());
				values.put("score", centro.getScore());

				String newContent = generateXmlContent(structure, values);
				ja.setContent(newContent);
				JournalArticleLocalServiceUtil.updateJournalArticle(ja);

				dbCentro.setTimeStamp(new Date());
				CentroLocalServiceUtil.updateCentro(dbCentro);
			}
		}
		catch (SystemException e) {
			log.error("Error fetching center structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error updating center: " + e);
		}
		return ja;
	}

	public static void activateCentro(String centroGprId) {

		try {
			if (validateElement(centroGprId)) {
				long gprId = Long.parseLong(centroGprId);
				Centro persistedCentro =
					CentroLocalServiceUtil.getCentroBygprId(gprId);
				long resourcePrimkey = persistedCentro.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_APPROVED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error activating center");
		}
		catch (SystemException e) {
			log.error(e + "Error activating center");
		}
	}

	public static void expireCentro(String centroGprId) {

		try {
			if (validateElement(centroGprId)) {
				long gprId = Long.parseLong(centroGprId);
				Centro persistedCentro =
					CentroLocalServiceUtil.getCentroBygprId(gprId);
				long resourcePrimkey = persistedCentro.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error expiring center");
		}
		catch (SystemException e) {
			log.error(e + "Error expiring center");
		}
	}

	public static boolean isNewCentro(ServiceCenterExtended centroParam) {

		boolean isNew = true;
		if (validateElement(centroParam.getId())) {
			long gprId = Long.parseLong(centroParam.getId());
			Centro intento = CentroLocalServiceUtil.getCentroBygprId(gprId);
			if (Validator.isNull(intento)) {
				isNew = true;
			}
			else {
				isNew = false;
			}
		}
		return isNew;
	}

	// PASOS
	public static JournalArticle createPaso(ServiceCaseStep paso, String id_caso) {

		JournalArticle ja = null;
		try {
			if (validateElement(id_caso) && validateElement(paso.getId())) {
				DDMStructure structure = getStructure("paso.structure");
				DDMTemplate template = getTemplate("paso.template");
				// Data for Journal Article
				long groupId = structure.getGroupId();
				long userId = structure.getUserId();
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(new Locale("es", "ES"), paso.getName());
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAssetEntryVisible(true);
				Map<String, String> values = new HashMap<String, String>();
				values.put("name", paso.getName());
				values.put("description", paso.getDescription());
				values.put("code", paso.getCode());
				values.put("signatures", paso.getSignatures());
				values.put("cost", paso.getCost());
				values.put("fees", paso.getFee());
				values.put("legalBase", paso.getFeeLegal());
				values.put("payment", paso.getPaymentForm());
				values.put("interactions", paso.getInteractions());
				values.put("interactionsRemote", paso.getInteractionsRemote());
				values.put("time", paso.getTimeRangeActual());
				values.put("procedure", paso.getProcedure());
				values.put("entity", paso.getExecutiveOffice());
				values.put("bpms", "");

				String content = generateXmlContent(structure, values);
				GregorianCalendar date =
					(GregorianCalendar) Calendar.getInstance(
						TimeZone.getTimeZone("Europe/Madrid"), new Locale(
							"es", "ES"));
				JournalFolder folder =
					JournalFolderLocalServiceUtil.fetchFolder(
						groupId, PropsUtil.get("paso.folder"));
				// JournalArticle registration
				ja =
					JournalArticleLocalServiceUtil.addArticle(
						userId, groupId, folder.getFolderId(), 0L, 0L, "",
						true, 1.0, titleMap, null, content, "general",
						structure.getStructureKey(), template.getTemplateKey(),
						null, date.get(Calendar.MONTH),
						date.get(Calendar.DAY_OF_MONTH),
						date.get(Calendar.YEAR), 0, 0, 0, 0, 0, 0, 0, true, 0,
						0, 0, 0, 0, true, true, false, null, null, null, null,
						serviceContext);
				// Index Registration
				long gprId = Long.parseLong(paso.getId());
				long contentId = ja.getResourcePrimKey();
				Date timestamp = new Date();
				long casoGprId = Long.parseLong(id_caso);
				Caso caso = CasoLocalServiceUtil.getCasoBygprId(casoGprId);
				PasoLocalServiceUtil.addPaso(
					gprId, contentId, timestamp, caso.getId_caso());
			}
		}
		catch (SystemException e) {
			log.error("Error fetching step structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error saving new step: " + e);
		}
		return ja;
	}

	public static JournalArticle updatePaso(ServiceCaseStep paso) {

		JournalArticle ja = null;
		boolean update = false;
		try {
			if (validateElement(paso.getId())) {
				DDMStructure structure = getStructure("paso.structure");
				long gprId = Long.parseLong(paso.getId());
				Paso dbPaso = PasoLocalServiceUtil.getPasoBygprId(gprId);

				long serverts = Long.parseLong(paso.getTimeStamp());
				Date gprDate = new Date(serverts);
				Date localDate = dbPaso.getTimeStamp();
				if (gprDate.after(localDate)) {
					update = false;
				}
				if (update) {
					ja =
						JournalArticleLocalServiceUtil.getLatestArticle(dbPaso.getContent());

					String bpms = getNodeValue(ja.getContent(), "bpms");
					Map<String, String> values = new HashMap<String, String>();
					values.put("name", paso.getName());
					values.put("description", paso.getDescription());
					values.put("code", paso.getCode());
					values.put("signatures", paso.getSignatures());
					values.put("cost", paso.getCost());
					values.put("fees", paso.getFee());
					values.put("legalBase", paso.getFeeLegal());
					values.put("payment", paso.getPaymentForm());
					values.put("interactions", paso.getInteractions());
					values.put(
						"interactionsRemote", paso.getInteractionsRemote());
					values.put("time", paso.getTimeRangeActual());
					values.put("procedure", paso.getProcedure());
					values.put("entity", paso.getExecutiveOffice());
					values.put("bpms", bpms);

					String newContent = generateXmlContent(structure, values);
					ja.setContent(newContent);
					JournalArticleLocalServiceUtil.updateJournalArticle(ja);

					dbPaso.setTimeStamp(new Date());
					PasoLocalServiceUtil.updatePaso(dbPaso);
				}
			}
		}
		catch (SystemException e) {
			log.error("Error fetching step structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error updating step: " + e);
		}
		return ja;
	}

	public static void activatePaso(String pasoGprId) {

		try {
			if (validateElement(pasoGprId)) {
				long gprId = Long.parseLong(pasoGprId);
				Paso persistedPaso = PasoLocalServiceUtil.getPasoBygprId(gprId);
				long resourcePrimkey = persistedPaso.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_APPROVED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error activating step");
		}
		catch (SystemException e) {
			log.error(e + "Error activating step");
		}
	}

	public static void expirePaso(String pasoGprId) {

		try {
			if (validateElement(pasoGprId)) {
				long gprId = Long.parseLong(pasoGprId);
				Paso persistedPaso = PasoLocalServiceUtil.getPasoBygprId(gprId);
				long resourcePrimkey = persistedPaso.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error expiring step");
		}
		catch (SystemException e) {
			log.error(e + "Error expiring step");
		}
	}

	public static boolean isNewPaso(ServiceCaseStep paso) {

		boolean isNew = true;
		if (validateElement(paso.getId())) {
			long gprId = Long.parseLong(paso.getId());
			Paso intento = PasoLocalServiceUtil.getPasoBygprId(gprId);
			if (Validator.isNull(intento)) {
				isNew = true;
			}
			else {
				isNew = false;
			}
		}
		return isNew;
	}

	// REQUISITOS
	public static JournalArticle createRequisito(
		ServiceRequisite requisito, String id_paso) {

		JournalArticle ja = null;
		try {
			if (validateElement(id_paso) && validateElement(requisito.getId())) {
				DDMStructure structure = getStructure("requisito.structure");
				DDMTemplate template = getTemplate("requisito.template");
				// Data for Journal Article
				long groupId = structure.getGroupId();
				long userId = structure.getUserId();
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(new Locale("es", "ES"), requisito.getCode());
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAssetEntryVisible(true);
				Map<String, String> values = new HashMap<String, String>();
				values.put("name", requisito.getName());
				values.put("code", requisito.getCode());
				values.put("entity", requisito.getExecutiveOffice());
				values.put("instructions", requisito.getInstructions());
				values.put("acceptedForms", requisito.getAcceptedForms());
				values.put("order", requisito.getCodeSequence());
				values.put("obligatoriness", requisito.getObligatoriness());
				values.put("issuing", requisito.getIssuingExecutiveOffice());

				String content = generateXmlContent(structure, values);
				GregorianCalendar date =
					(GregorianCalendar) Calendar.getInstance(
						TimeZone.getTimeZone("Europe/Madrid"), new Locale(
							"es", "ES"));
				JournalFolder folder =
					JournalFolderLocalServiceUtil.fetchFolder(
						groupId, PropsUtil.get("requisito.folder"));
				// JournalArticle registration
				ja =
					JournalArticleLocalServiceUtil.addArticle(
						userId, groupId, folder.getFolderId(), 0L, 0L, "",
						true, 1.0, titleMap, null, content, "general",
						structure.getStructureKey(), template.getTemplateKey(),
						null, date.get(Calendar.MONTH),
						date.get(Calendar.DAY_OF_MONTH),
						date.get(Calendar.YEAR), 0, 0, 0, 0, 0, 0, 0, true, 0,
						0, 0, 0, 0, true, true, false, null, null, null, null,
						serviceContext);
				// Index Registration
				long gprId = Long.parseLong(requisito.getId());
				long contentId = ja.getResourcePrimKey();
				Date timestamp = new Date();
				long pasoGprId = Long.parseLong(id_paso);
				Paso paso = PasoLocalServiceUtil.getPasoBygprId(pasoGprId);
				RequisitoLocalServiceUtil.addRequisito(
					gprId, contentId, timestamp, paso.getId_paso());
			}
		}
		catch (SystemException e) {
			log.error("Error fetching requirement structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error saving requirement step: " + e);
		}
		return ja;
	}

	public static JournalArticle updateRequisito(ServiceRequisite requisito) {

		JournalArticle ja = null;
		boolean update = false;
		try {
			if (validateElement(requisito.getId())) {
				DDMStructure structure = getStructure("requisito.structure");
				long gprId = Long.parseLong(requisito.getId());
				Requisito dbRequisito =
					RequisitoLocalServiceUtil.getRequisitoBygprId(gprId);

				long serverts = Long.parseLong(requisito.getTimeStamp());
				Date gprDate = new Date(serverts);
				Date localDate = dbRequisito.getTimeStamp();
				if (gprDate.after(localDate)) {
					update = false;
				}
				if (update) {
					ja =
						JournalArticleLocalServiceUtil.getLatestArticle(dbRequisito.getContent());

					Map<String, String> values = new HashMap<String, String>();
					values.put("name", requisito.getName());
					values.put("code", requisito.getCode());
					values.put("entity", requisito.getExecutiveOffice());
					values.put("instructions", requisito.getInstructions());
					values.put("acceptedForms", requisito.getAcceptedForms());
					values.put("order", requisito.getCodeSequence());
					values.put("obligatoriness", requisito.getObligatoriness());
					values.put("issuing", requisito.getIssuingExecutiveOffice());

					String newContent = generateXmlContent(structure, values);
					ja.setContent(newContent);
					JournalArticleLocalServiceUtil.updateJournalArticle(ja);

					dbRequisito.setTimeStamp(new Date());
					RequisitoLocalServiceUtil.updateRequisito(dbRequisito);
				}
			}
		}
		catch (SystemException e) {
			log.error("Error fetching step structure: " + e);
		}
		catch (PortalException e) {
			log.error("Error updating step: " + e);
		}
		return ja;
	}

	public static void activateRequisito(String requisitoGprId) {

		try {
			if (validateElement(requisitoGprId)) {
				long gprId = Long.parseLong(requisitoGprId);
				Requisito persistedRequisito =
					RequisitoLocalServiceUtil.getRequisitoBygprId(gprId);
				long resourcePrimkey = persistedRequisito.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_APPROVED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error activating requirement");
		}
		catch (SystemException e) {
			log.error(e + "Error activating requirement");
		}
	}

	public static void expireRequisito(String requisitoGprId) {

		try {
			if (validateElement(requisitoGprId)) {
				long gprId = Long.parseLong(requisitoGprId);
				Requisito persistedRequisito =
					RequisitoLocalServiceUtil.getRequisitoBygprId(gprId);
				long resourcePrimkey = persistedRequisito.getContent();
				JournalArticle journalArticle =
					JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey);
				journalArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
				journalArticle.persist();
			}
		}
		catch (PortalException e) {
			log.error(e + "Error expiring requirement");
		}
		catch (SystemException e) {
			log.error(e + "Error expiring requirement");
		}
	}

	public static boolean isNewRequisito(ServiceRequisite requisito) {

		boolean isNew = true;
		if (validateElement(requisito.getId())) {
			long gprId = Long.parseLong(requisito.getId());
			Requisito intento =
				RequisitoLocalServiceUtil.getRequisitoBygprId(gprId);
			if (Validator.isNull(intento)) {
				isNew = true;
			}
			else {
				isNew = false;
			}
		}
		return isNew;
	}

	// Utility methods
	public static DDMStructure getStructure(String key) {

		DDMStructure structure = null;
		if (key.equals("")) {
			key = "institucion.structure";
		}
		List<DDMStructure> structures;
		try {
			structures = DDMStructureLocalServiceUtil.getStructures();
			for (DDMStructure st : structures) {
				if (st.getStructureKey().equals(PropsUtil.get(key))) {
					structure = st;
				}
			}
		}
		catch (SystemException e) {
			log.error(e + "Error fetching the structure " + key);
		}
		return structure;
	}

	public static DDMTemplate getTemplate(String key) {

		DDMTemplate template = null;
		if (key.equals("")) {
			key = "institucion.template";
		}
		List<DDMTemplate> templates;
		try {
			templates =
				DDMTemplateLocalServiceUtil.getDDMTemplates(
					0, DDMTemplateLocalServiceUtil.getDDMTemplatesCount());
			for (DDMTemplate tp : templates) {
				if (tp.getTemplateKey().equals(PropsUtil.get(key))) {
					template = tp;
				}
			}
		}
		catch (SystemException e) {
			log.error(e + "Error fetching the structure " + key);
		}
		return template;
	}

	public static void folderCheck() {

		try {
			boolean createFolderInstituciones = true;
			boolean createFolderServicios = true;
			boolean createFolderRequisitos = true;
			boolean createFolderPasos = true;
			boolean createFolderCasos = true;
			boolean createFolderIndicadores = true;
			boolean createFolderCentros = true;
			boolean createFolderActividadInstitucional = true;
			DDMStructure structure = getStructure("");
			long groupId = structure.getGroupId();
			long userId = structure.getUserId();
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setAddGuestPermissions(true);
			serviceContext.setAssetEntryVisible(true);
			List<JournalFolder> folders =
				JournalFolderLocalServiceUtil.getFolders(groupId, 0);
			for (JournalFolder folder : folders) {
				if (folder.getName().equals(PropsUtil.get("institucion.folder"))) {
					createFolderInstituciones = false;
				}
				if (folder.getName().equals(PropsUtil.get("servicio.folder"))) {
					createFolderServicios = false;
				}
				if (folder.getName().equals(PropsUtil.get("requisito.folder"))) {
					createFolderRequisitos = false;
				}
				if (folder.getName().equals(PropsUtil.get("paso.folder"))) {
					createFolderPasos = false;
				}
				if (folder.getName().equals(PropsUtil.get("caso.folder"))) {
					createFolderCasos = false;
				}
				if (folder.getName().equals(PropsUtil.get("indicador.folder"))) {
					createFolderIndicadores = false;
				}
				if (folder.getName().equals(PropsUtil.get("centro.folder"))) {
					createFolderCentros = false;
				}
				if (folder.getName().equals(
					PropsUtil.get("actividadinstitucional.folder"))) {
					createFolderActividadInstitucional = false;
				}
			}
			if (createFolderInstituciones) {
				JournalFolderLocalServiceUtil.addFolder(
					userId, groupId, 0, PropsUtil.get("institucion.folder"),
					"", serviceContext);
			}
			if (createFolderServicios) {
				JournalFolderLocalServiceUtil.addFolder(
					userId, groupId, 0, PropsUtil.get("servicio.folder"), "",
					serviceContext);
			}
			if (createFolderRequisitos) {
				JournalFolderLocalServiceUtil.addFolder(
					userId, groupId, 0, PropsUtil.get("requisito.folder"), "",
					serviceContext);
			}
			if (createFolderPasos) {
				JournalFolderLocalServiceUtil.addFolder(
					userId, groupId, 0, PropsUtil.get("paso.folder"), "",
					serviceContext);
			}
			if (createFolderCasos) {
				JournalFolderLocalServiceUtil.addFolder(
					userId, groupId, 0, PropsUtil.get("caso.folder"), "",
					serviceContext);
			}
			if (createFolderIndicadores) {
				JournalFolderLocalServiceUtil.addFolder(
					userId, groupId, 0, PropsUtil.get("indicador.folder"), "",
					serviceContext);
			}
			if (createFolderCentros) {
				JournalFolderLocalServiceUtil.addFolder(
					userId, groupId, 0, PropsUtil.get("centro.folder"), "",
					serviceContext);
			}
			if (createFolderActividadInstitucional) {
				JournalFolderLocalServiceUtil.addFolder(
					userId, groupId, 0,
					PropsUtil.get("actividadinstitucional.folder"), "",
					serviceContext);
			}
		}
		catch (SystemException e) {
			log.error(e + "Error checking folders");
		}
		catch (PortalException e) {
			log.error(e + "Error checking folders");
		}
	}

	public static boolean isNewer(String gprTimestamp, String localTimestamp) {

		long gprts = Long.parseLong(gprTimestamp);
		Date gprDate = new Date(gprts);
		long localts = Long.parseLong(localTimestamp);
		Date localDate = new Date(localts);
		return localDate.before(gprDate);
	}

	public static String generateXmlContent(
		DDMStructure ddmStructure, Map<String, String> values) {

		String xml = null;
		try {
			// Documents to work with
			Document structureDocument = ddmStructure.getDocument();
			Document journalDocument = SAXReaderUtil.createDocument();
			// We get the document's roots
			Element sRoot = structureDocument.getRootElement();
			Element jRoot = SAXReaderUtil.createElement("root");
			// We get the attributes from the structure and asign them to the
			// content
			List<Attribute> srAttributes = sRoot.attributes();
			for (Attribute a : srAttributes) {
				jRoot.addAttribute(a.getName(), a.getValue());
			}
			// Get the root childs node
			for (Element element : sRoot.elements()) {
				// Set the attributes for the new element
				Element newElement = jRoot.addElement("dynamic-element");
				String name = element.attributeValue("name");
				String type = element.attributeValue("type");
				String index_type = element.attributeValue("indexType");
				String index = "0";
				if (type.equals("textarea")) {
					type = "text_box";
				}
				else if (type.equals("select")) {
					type = "list";
				}
				else if (type.equals("ddm-text-html")) {
					type = "text_area";
				}
				newElement.addAttribute("name", name);
				newElement.addAttribute("type", type);
				newElement.addAttribute("index-type", index_type);
				newElement.addAttribute("index", index);
				// Inserting the values
				Element jvalue = newElement.addElement("dynamic-content");
				for (Element sValue : element.elements()) {
					if (sValue.attribute("locale") != null) {
						String locale = sValue.attribute("locale").getValue();
						jvalue.addAttribute("language-id", locale);
					}
				}
				jvalue.addCDATA(values.get(name));
			}
			journalDocument.setRootElement(jRoot);
			xml = DDMXMLUtil.formatXML(journalDocument);
		}
		catch (Exception e) {
			log.error("Error generating xml from structure " +
				ddmStructure.getStructureKey().toString() + ": " + e);
			e.printStackTrace();
		}
		return xml;
	}

	public static String getNodeValue(String xml, String name) {

		String value = null;
		try {
			Document doc = SAXReaderUtil.read(xml);
			Node node =
				doc.selectSingleNode("/root/dynamic-element[@name='" + name +
					"']/dynamic-content");
			if (Validator.isNotNull(node) && node.getText().length() > 0) {
				value = node.getText();
			}
		}
		catch (DocumentException e) {
			log.error("Error fetching node value: " + e);
		}
		return value;
	}

	private static boolean validateElement(String element) {

		boolean res = false;
		if (element != null && !Validator.isBlank(element) &&
			Validator.isNumber(element)) {
			res = true;
		}
		return res;
	}
}
