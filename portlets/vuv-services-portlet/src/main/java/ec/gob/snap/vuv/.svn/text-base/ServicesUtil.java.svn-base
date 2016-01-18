
package ec.gob.snap.vuv;

import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class ServicesUtil {

	/*******************************************************************
	 * ATTRIBUTES
	 ******************************************************************/
	/**
	 * Attribute that represents the number of services items per row to show on
	 * the services page.
	 */
	private static Integer numRows;
	/**
	 * Attribute that represents the type of message 'Read More' according to
	 * the locale and associated to service item description.
	 */
	private static String readMore;
	/**
	 * Attribute that represents the type of message 'Not Avaible Services'
	 * according to the locale and associated to service item description.
	 */
	private static String notServices;
	/**
	 * Attribute that represents the maximun number of characters to be shown on
	 * shhort description on Services Searcher Portlet.
	 */
	private static Integer maxNumCharDescrip;
	/**
	 * Attribute that represents the list of available Services to represent on
	 * the Service Page.
	 */
	private static List<Service> servicesLayout = new ArrayList<Service>();

	/*******************************************************************
	 * METHODS
	 ******************************************************************/
	/**
	 * Method to get the list of available Services.
	 * 
	 * @return ArrayList<Service> Services Layout.
	 */
	public static List<Service> getServicesLayout() {

		return servicesLayout;
	}

	/**
	 * Method to inicialize the Service Utils accoding to the locale and number
	 * of service item to show on the Service page.
	 * 
	 * @param paramNumRows
	 *            Number of rows for the layout.
	 * @param paramReadMore
	 *            "Read More" layout label.
	 * @param paramNotServices
	 *            "Not Available Service" layout label.
	 */
	public static void setServicesUtilProp(
		Integer paramNumRows, String paramReadMore, String paramNotServices,
		Integer paramMaxNumCharDescrip) {

		ServicesUtil.numRows = paramNumRows;
		ServicesUtil.readMore = paramReadMore;
		ServicesUtil.notServices = paramNotServices;
		ServicesUtil.maxNumCharDescrip = paramMaxNumCharDescrip;
	}

	/**
	 * Method to add a service item to the Service List.
	 * 
	 * @param service
	 *            Service to add.
	 */
	public static void addService(Service service) {

		Boolean existingService = false;
		for (Service serviceItem : ServicesUtil.servicesLayout) {
			if (serviceItem.getServiceName().equalsIgnoreCase(
				service.getServiceName())) {
				existingService = true;
			}
		}
		if (!existingService) {
			ServicesUtil.servicesLayout.add(service);
		}
	}

	/**
	 * This method es responsible of building a HTML list of services ready to
	 * be show on the portal.
	 * 
	 * @param paramServLayout
	 *            Service List to be formatted.
	 * @return HTML code with the services properly formatted.
	 */
	public static String getAssertList2HTML(
		List<Service> paramServLayout, String contextPath) {

		StringBuffer html = new StringBuffer();
		Integer counterPerline = 0;
		Integer linePerPage = 0;

		if (!paramServLayout.isEmpty()) { // #3
			String tipoServicio;
			html.append("<div class=\"servicesPageList\">");
			for (int i = 0; i < paramServLayout.size(); i++) { // #4
				StringBuffer shortDescription = new StringBuffer();
				if (i == 0) {
					html.append("<div class=\"row-fluid span12 servicesRowList\" style=\"margin: 0px !important; display: block;\">");
				}
				if (paramServLayout.get(i).getServiceDescription().length() > ServicesUtil.maxNumCharDescrip) {
					shortDescription.append(paramServLayout.get(i).getServiceDescription().substring(
						0, ServicesUtil.maxNumCharDescrip) +
						"...");
				}
				else {
					shortDescription.append(paramServLayout.get(i).getServiceDescription());
				}
				html.append("<div id=\"ficha\" class=\"span4 well well-small\">");
				html.append("<div><h4>" +
					paramServLayout.get(i).getServiceName() + "</h4></div>");
				html.append("<p class=\"serviceDescrip\">" +
					shortDescription.toString() + "</p>");
				// Iconos de tipo de servicio y botón de "Leer más"
				// reestructurados
				// ------------------------------------------------------------------------------------------
				html.append("<div><table style=\"width:100%;\">");
				html.append("</tr>");
				html.append("<td width=\"50%\" align=\"left\" style=\"cursor:default !important;\">");
				// ["0"] = No automatizado(informativo)
				// ["1"] = Automatizado en la VUV
				// ["2"] = Automatizado fuera de la VUV
				tipoServicio = paramServLayout.get(i).getServiceType();
				if (tipoServicio == null) {
					tipoServicio = "";
				}
				if (tipoServicio.contains("0")) {
					html.append("<img src=\"" + contextPath +
						"/images/servicioInformativoOn.png\"> ");
				}
				else {
					html.append("<img src=\"" + contextPath +
						"/images/servicioInformativoOff.png\"> ");
				}
				if (tipoServicio.contains("1")) {
					html.append("<img src=\"" + contextPath +
						"/images/servicioAutomatizadoOn.png\"> ");;
				}
				else {
					html.append("<img src=\"" + contextPath +
						"/images/servicioAutomatizadoOff.png\"> ");;
				}
				if (tipoServicio.contains("2")) {
					html.append("<img src=\"" + contextPath +
						"/images/servicioAutomatizadoExternoOn.png\">");
				}
				else {
					html.append("<img src=\"" + contextPath +
						"/images/servicioAutomatizadoExternoOff.png\">");
				}
				html.append("</td>");
				html.append("<td width=\"50%\" align=\"right\">");
				html.append("<p>");
				html.append("<a class=\"btn btn-inverse pull-right\" href=\"" +
					paramServLayout.get(i).getUrl() +
					"\">" +
					ServicesUtil.readMore +
					"<span style=\"margin-left:1em\"><i class=\"icon-chevron-right\"></i></span></a>");
				html.append("</p>");
				html.append("</td>");
				html.append("</tr>");
				html.append("</table></div>");
				// ------------------------------------------------------------------------------------------
				// html.append("<p>");
				// html.append("<a class=\"btn btn-inverse pull-right\" href=\""
				// + paramServLayout.get(i).getUrl() + "\">" +
				// ServicesUtil.readMore +
				// "<span style=\"margin-left:1em\"><i class=\"icon-chevron-right\"></i></span></a>");
				// html.append("</p>");
				html.append("</div>");
				counterPerline++;

				if (counterPerline.equals(3)) {
					if (i < ServicesUtil.servicesLayout.size()) {
						if (linePerPage == numRows -1) {
							html.append("</div></div><div class=\"servicesPageList\" style=\"display: none;\"><div class=\"row-fluid span12 servicesRowList\" style=\"margin: 0px !important;\">");
							linePerPage = 0;
						}
						else {
							html.append("</div><div class=\"row-fluid span12 servicesRowList\" style=\"margin: 0px !important;\">");
							linePerPage++;
						}
					}
					else {
						html.append("</div></div>");
					}
					// reset
					counterPerline = 0;
				}
			} // end of #4
			if (counterPerline > 0) {
				html.append("</div>");
				linePerPage++;
			}
			if (linePerPage > 0) {
				html.append("</div>");
			}
		} // end of #3
		else {
			html.append("<div class=\"alert alert-block span4 offset3\">");
			html.append("<i class=\"icon-warning-sign pull-left\"></i>");
			html.append("<p class=\"pull-left\">" + ServicesUtil.notServices +
				"</p>");
			html.append("</div>");
		}
		return html.toString();
	}

	/**
	 * Method to filter the number of service to be shown on the Service Page
	 * according tho parameteres.
	 * 
	 * @param serviceItem
	 *            Parameter that represents the service object to be checked.
	 * @param keyword
	 *            Parameter that represents the keywords that the service name
	 *            must containt.
	 * @param rangoInf
	 *            Parameter that represents the minimum age to constrain the
	 *            list of services.
	 * @param rangoSup
	 *            Parameter that represents the maximum age to constrain the
	 *            list of services.
	 * @param maleSelected
	 *            Parameter that represents if the male option has been selected
	 *            by the user.
	 * @param femaleSelected
	 *            Parameter that represents if the female option has been
	 *            selected by the user.
	 * @return True if the service item has accomplished with the specified
	 *         parameters.
	 */
	public static boolean filterService(

		Service serviceItem, String keyword, String rangoInf, String rangoSup,
		String maleSelected, String femaleSelected) {

		boolean maincheck = false;
		boolean ageCheck = false;
		boolean sexCheck = false;
		boolean keyCheck = true;
		try {
			// Logical constants
			String EMPTY = "";
			String BOTHSex = "both";
			String MANSex = "man";
			String WOMANSex = "woman";
			String YESAnswer = "y";
			String NOAnswer = "n";

			if (keyword != null && !keyword.equalsIgnoreCase(EMPTY)) {
				for (String elem : keyword.split("\\*")) {
					keyCheck =
						keyCheck &&
							serviceItem.getServiceName().toUpperCase().contains(
								elem.toUpperCase());
				}
			}
			Integer age = Integer.parseInt(serviceItem.getServiceAge());
			Integer iRangoSup = Integer.parseInt(rangoSup);
			Integer iRangoInf = Integer.parseInt(rangoInf);
			if (Validator.isNotNull(age)) {
				if (iRangoInf.compareTo(age) <= 0 &&
					age.compareTo(iRangoSup) <= 0) {
					ageCheck = true;
				}
			}
			else {
				ageCheck = true;
			}

			String sex = BOTHSex;
			if (YESAnswer.equalsIgnoreCase(maleSelected) &&
				YESAnswer.equalsIgnoreCase(femaleSelected) ||
				NOAnswer.equalsIgnoreCase(maleSelected) &&
				NOAnswer.equalsIgnoreCase(femaleSelected)) {
				sexCheck = true;
			}
			else {
				if (YESAnswer.equalsIgnoreCase(maleSelected) &&
					NOAnswer.equalsIgnoreCase(femaleSelected)) {
					sex = MANSex;
				}
				if (NOAnswer.equalsIgnoreCase(maleSelected) &&
					YESAnswer.equalsIgnoreCase(femaleSelected)) {
					sex = WOMANSex;
				}
				if (Validator.isNotNull(serviceItem.getServiceSex())) {
					if (serviceItem.getServiceSex().contains(sex) ||
						serviceItem.getServiceSex().contains(BOTHSex)) {
						sexCheck = true;
					}
				}
				else {
					sexCheck = true;
				}
			}
			if (ageCheck && sexCheck && keyCheck) {
				maincheck = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return maincheck;
	}
}
