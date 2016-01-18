/* 
 * This file is part of the VUV Electronic Office of Government of Ecuador.
 * Copyright 2015.
 */

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.EntityUpdateUtil.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of xxxxxxxxxx.</p>
 * <b>Date:</b><p>28/7/2015.</p>
 * @version 1.0, 28/7/2015.
 */

package ec.gob.snap.vuv.dynamic.form;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import ec.gob.snap.vuv.dynamic.form.entities.Input;
import ec.gob.snap.vuv.dynamic.form.entities.InputD;
import ec.gob.snap.vuv.dynamic.form.entities.ObjectFactory;
import ec.gob.snap.vuv.dynamic.form.entities.Properties;
import ec.gob.snap.vuv.dynamic.form.entities.PropertiesDate;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.Acciones;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SubForm;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * <p>Class EntityUpdateUtil.</p> <b>Project:</b><p>VUV Electronic Office of
 * Government of Ecuador.</p>
 * 
 * @version 1.0, 28/7/2015.
 */
public class EntityUpdateUtil {

	private final static QName _PropertiesValue_QNAME = new QName("", "value");

	public static void JAXBElementUpdate(Map<String, String[]> parametersMap, Object itemField, Locale locale)
		throws JSONException, ParseException {

		String name;
		String value;
		JSONArray jsonTable;
		ObjectFactory factory = new ObjectFactory();
		Properties currentProperties = factory.createProperties();
		PropertiesDate currentPropertiesDate = factory.createPropertiesDate();

		if (itemField instanceof Acciones) {
			name = "";
			value = "";
			List<Input> buttons = ((Acciones) itemField).getButton();
			for (Input button : buttons) {
				name = (button.getProperty() != null) ? button.getProperty() : button.getId();
				value = parametersMap.get(name)[0];
				currentProperties = updateJAXBProperties(value, button.getProperties());
				button.setProperties(currentProperties);
			}
		}
		else if (itemField instanceof SelectBox) {
			SelectBox selectValue = (SelectBox) itemField;
			name = selectValue.getProperty();
			value = parametersMap.get(name)[0];
			currentProperties = updateJAXBProperties(value, selectValue.getProperties());
			selectValue.setProperties(currentProperties);
		}
		else if (itemField instanceof SubForm.SelectBox) {
			SubForm.SelectBox selectValue = (SubForm.SelectBox) itemField;
			name = selectValue.getProperty();
			value = parametersMap.get(name)[0];
			currentProperties = updateJAXBProperties(value, selectValue.getProperties());
			selectValue.setProperties(currentProperties);
		}
		else if (itemField instanceof Input) {
			Input inputValue = (Input) itemField;
			name = inputValue.getProperty();
			value = parametersMap.get(name)[0];
			currentProperties = updateJAXBProperties(value, inputValue.getProperties());
			inputValue.setProperties(currentProperties);
		}
		else if (itemField instanceof InputD) {
			InputD dateValue = (InputD) itemField;
			name = dateValue.getProperty();
			value = parametersMap.get(name)[0];
			dateValue.getProperties();
			currentPropertiesDate = updateJAXBPropertiesDate(value, dateValue.getProperties());
			dateValue.setProperties(currentPropertiesDate);
		}
		else if (itemField instanceof SubForm) {
			SubForm subForm = (SubForm) itemField;
			List<JAXBElement<?>> subFormElements = subForm.getOutputTextOrInputTextOrInputDate();
			for (JAXBElement<?> subFormField : subFormElements) {
				JAXBElementUpdate(parametersMap, subFormField.getValue(), locale);
			}

		}
		else if (itemField instanceof MultipleSubForm) {
			MultipleSubForm multipleSubForm = (MultipleSubForm) itemField;
			List<MultipleSubForm.SubForm> subFormRows = new ArrayList<MultipleSubForm.SubForm>();
			MultipleSubForm.SubForm subFormModel = multipleSubForm.getSubForm().get(0);

			name = multipleSubForm.getProperty();
			jsonTable = JSONFactoryUtil.createJSONArray(parametersMap.get(name)[0]);
			// TODO parsear JSONArray en MultipleSubform.SubForm
			for (int i = 0; i < jsonTable.length(); i++) {
				JSONObject jsonRow = jsonTable.getJSONObject(i);
				MultipleSubForm.SubForm subFormRowi = factory.createTemplateFormularioMultipleSubFormSubForm();
				subFormRowi.getOutputTextOrInputTextOrInputDate().addAll(
					subFormModel.getOutputTextOrInputTextOrInputDate());
				List<JAXBElement<?>> fields =
					(((MultipleSubForm.SubForm) subFormRowi).getOutputTextOrInputTextOrInputDate());
				for (JAXBElement<?> field : fields) {
					JAXBTableFieldUpdate(jsonRow, field.getValue(), locale);
				}
				subFormRows.add(subFormRowi);
			}

			multipleSubForm.getSubForm().clear();
			multipleSubForm.getSubForm().addAll(subFormRows);
		}
		// TODO attachment File
	}

	public static void JAXBTableFieldUpdate(JSONObject jsonField, Object itemField, Locale locale)
		throws JSONException, ParseException {

		ObjectFactory factory = new ObjectFactory();
		Properties currentProperties = factory.createProperties();
		PropertiesDate currentPropertiesDate = factory.createPropertiesDate();

		if (itemField instanceof MultipleSubForm.SubForm.SelectBox) {
			MultipleSubForm.SubForm.SelectBox selectValue = (MultipleSubForm.SubForm.SelectBox) itemField;
			String jsonKey = selectValue.getProperty();
			String value = jsonField.getString(jsonKey);
			currentProperties = updateJAXBProperties(value, selectValue.getProperties());
			selectValue.setProperties(currentProperties);
		}
		else if (itemField instanceof Input) {
			Input inputValue = (Input) itemField;
			String jsonKey = inputValue.getProperty();
			String value = jsonField.getString(jsonKey);
			currentProperties = updateJAXBProperties(value, inputValue.getProperties());
			inputValue.setProperties(currentProperties);
		}
		else if (itemField instanceof InputD) {
			InputD dateValue = (InputD) itemField;
			String jsonKey = dateValue.getProperty();
			String value = jsonField.getString(jsonKey);
			currentPropertiesDate = updateJAXBPropertiesDate(value, dateValue.getProperties());
			dateValue.setProperties(currentPropertiesDate);
		}
	}

	private static PropertiesDate updateJAXBPropertiesDate(String value, PropertiesDate properties) {

		ObjectFactory factory = new ObjectFactory();
		PropertiesDate newProperties = factory.createPropertiesDate();
		JAXBElement<?> valueJAXB = factory.createPropertiesValue(value);
		List<JAXBElement<?>> details = properties.getLabelOrValueOrType();
		for (JAXBElement<?> prop : details) {
			if (prop.getName().equals(_PropertiesValue_QNAME)) {
				newProperties.getLabelOrValueOrType().add(valueJAXB);
			}
			else {
				newProperties.getLabelOrValueOrType().add(prop);
			}
		}

		return newProperties;
	}

	private static Properties updateJAXBProperties(String value, Properties properties) {

		ObjectFactory factory = new ObjectFactory();
		Properties newProperties = factory.createProperties();
		JAXBElement<?> valueJAXB = factory.createPropertiesValue(value);
		List<JAXBElement<?>> details = properties.getLabelOrAccionOrValue();
		for (JAXBElement<?> prop : details) {
			if (prop.getName().equals(_PropertiesValue_QNAME)) {
				newProperties.getLabelOrAccionOrValue().add(valueJAXB);
			}
			else {
				newProperties.getLabelOrAccionOrValue().add(prop);
			}
		}

		return newProperties;
	}

}
