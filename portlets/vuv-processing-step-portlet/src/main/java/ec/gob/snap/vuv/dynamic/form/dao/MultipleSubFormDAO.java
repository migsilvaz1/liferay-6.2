/* 
 * This file is part of the VUV Electronic Office of Government of Ecuador.
 * Copyright 2015.
 */

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.dao.MultipleSubFormDAO.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of VUV Electronic Office of Government of Ecuador.</p>
 * <b>Date:</b><p>16/7/2015.</p>
 * @version 1.0, 16/7/2015.
 */

package ec.gob.snap.vuv.dynamic.form.dao;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import ec.gob.snap.vuv.dynamic.form.entities.Input;
import ec.gob.snap.vuv.dynamic.form.entities.InputLabel;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm.AddItemText;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm.CancelItemText;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm.NewItemText;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm.SubForm;

import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.TransformerConfigurationException;

/**
 * <p>Class MultipleSubFormDAO.</p> <b>Project:</b><p>VUV Electronic Office of
 * Government of Ecuador</p>
 * 
 * @version 1.0, 16/7/2015.
 */
public class MultipleSubFormDAO {

	private Boolean erasable;
	private Boolean excelMode;
	private Boolean editable;
	private Boolean creatable;

	private String tableID;
	private String tableParent;
	private String tableProperty;
	private Integer tableOrder;

	private LabelDAO addItem;
	private LabelDAO cancelItem;
	private LabelDAO saveItem;
	private JSONArray tableRows_;

	/**
	 * Constructor method for the class {@link MultipleSubFormDAO}.
	 */
	public MultipleSubFormDAO(MultipleSubForm tableData, Locale locale) {

		erasable = tableData.isIsErasable();
		excelMode = tableData.isIsEnableTableEnterData();
		editable = tableData.isIsEditable();
		creatable = tableData.isIsCreatable();

		tableID = tableData.getId();
		tableParent = tableData.getParent();
		tableProperty = tableData.getProperty();
		tableOrder = tableData.getOrder();
		tableRows_ = JSONFactoryUtil.createJSONArray();

		List<Object> itemsTable = tableData.getAddItemTextAndCancelItemTextAndNewItemText();

		try {
			for (Object item : itemsTable) {
				if (item instanceof AddItemText) {
					addItem = new LabelDAO((AddItemText) item);
				}
				else if (item instanceof CancelItemText) {
					cancelItem = new LabelDAO((CancelItemText) item);
				}
				else if (item instanceof NewItemText) {
					saveItem = new LabelDAO((NewItemText) item);
				}
				else if (item instanceof SubForm) {
					List<JAXBElement<?>> fields = (((SubForm) item).getOutputTextOrInputTextOrInputDate());
					tableRows_.put(tableFieldsJSON(fields, locale));
				}
			}
		}
		catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JSONArray tableFieldsJSON(List<JAXBElement<?>> columns, Locale locale)
		throws TransformerConfigurationException {

		JSONObject jsonField = null;
		JSONArray jsonRow = JSONFactoryUtil.createJSONArray();

		for (JAXBElement<?> element : columns) {
			jsonField = JSONFactoryUtil.createJSONObject();
			if (element.getValue() instanceof InputLabel) {
				OutputTextDAO outputText = new OutputTextDAO((InputLabel) element.getValue());
				jsonField.put("id", outputText.getOutputID());
				jsonField.put("key", "");
				jsonField.put("name", "");
				jsonField.put("value", outputText.getLabeli18n().getLabeli18n(locale));
				jsonField.put("required", outputText.isFieldRequired());
				jsonField.put("type", "outputText");
			}
			else if (element.getValue() instanceof SubForm.SelectBox) {
				SelectBoxDAO selectBox = new SelectBoxDAO((SubForm.SelectBox) element.getValue());
				jsonField.put("id", selectBox.getSelectID());
				jsonField.put("key", selectBox.getSelectName());
				jsonField.put("name", selectBox.getLabeli18n().getLabeli18n(locale));
				jsonField.put("value", selectBox.getValue());
				jsonField.put("options", selectBox.getJSONOptions(locale));
				jsonField.put("required", selectBox.isFieldRequired());
				jsonField.put("type", "selectBox");
			}
			else if (element.getValue() instanceof Input) {
				InputDAO inputText = new InputDAO((Input) element.getValue());

				if (inputText.getType().equalsIgnoreCase(String.class.getName())) {
					jsonField.put("type", "inputText");
				}
				else if (inputText.getType().equalsIgnoreCase(Boolean.class.getName())) {
					jsonField.put("type", "checkedBox");
				}
				else if (inputText.getType().equalsIgnoreCase(Integer.class.getName())) {
					jsonField.put("type", "numberInput");
				}

				jsonField.put("id", inputText.getInputID());
				jsonField.put("key", inputText.getInputName());
				jsonField.put("name", inputText.getLabeli18n(locale));
				jsonField.put("value", inputText.getValue());
				jsonField.put("required", inputText.isFieldRequired());

			}
			// TODO: TextArea // RadioButton // InputDate
			jsonRow.put(jsonField);
		}

		return jsonRow;

	}

	/**
	 * Gets the value of the attribute {@link #tableRows}.
	 * 
	 * @return the value of the attribute {@link #tableRows}.
	 */
	public String getTableRowsJSON() {

		JSONArray jsonRows = JSONFactoryUtil.createJSONArray();
		JSONObject jsonRow = null;

		for (int i = 0; i < tableRows_.length(); i++) {
			JSONArray rowData = tableRows_.getJSONArray(i);
			jsonRow = JSONFactoryUtil.createJSONObject();
			for (int j = 0; j < rowData.length(); j++) {
				JSONObject columnData = rowData.getJSONObject(j);
				jsonRow.put(columnData.getString("key"), columnData.getString("value"));
			}
			jsonRows.put(jsonRow);
		}

		return jsonRows.toString();
	}

	/**
	 * Gets the value of the attribute {@link #tableColumnsName}.
	 * 
	 * @return the value of the attribute {@link #tableColumnsName}.
	 */
	public JSONArray getTableColumnsJSON(Locale locale) {

		return tableRows_.getJSONArray(0);
	}

	/**
	 * Gets the value of the attribute {@link #erasable}.
	 * 
	 * @return the value of the attribute {@link #erasable}.
	 */
	public Boolean getErasable() {

		return erasable;
	}

	/**
	 * Sets the value of the attribute {@link #erasable}.
	 * 
	 * @param erasable
	 *            The value for the attribute {@link #erasable}.
	 */
	public void setErasable(Boolean erasable) {

		this.erasable = erasable;
	}

	/**
	 * Gets the value of the attribute {@link #excelMode}.
	 * 
	 * @return the value of the attribute {@link #excelMode}.
	 */
	public Boolean getExcelMode() {

		return excelMode;
	}

	/**
	 * Sets the value of the attribute {@link #excelMode}.
	 * 
	 * @param excelMode
	 *            The value for the attribute {@link #excelMode}.
	 */
	public void setExcelMode(Boolean excelMode) {

		this.excelMode = excelMode;
	}

	/**
	 * Gets the value of the attribute {@link #editable}.
	 * 
	 * @return the value of the attribute {@link #editable}.
	 */
	public Boolean getEditable() {

		return editable;
	}

	/**
	 * Sets the value of the attribute {@link #editable}.
	 * 
	 * @param editable
	 *            The value for the attribute {@link #editable}.
	 */
	public void setEditable(Boolean editable) {

		this.editable = editable;
	}

	/**
	 * Gets the value of the attribute {@link #creatable}.
	 * 
	 * @return the value of the attribute {@link #creatable}.
	 */
	public Boolean getCreatable() {

		return creatable;
	}

	/**
	 * Sets the value of the attribute {@link #creatable}.
	 * 
	 * @param creatable
	 *            The value for the attribute {@link #creatable}.
	 */
	public void setCreatable(Boolean creatable) {

		this.creatable = creatable;
	}

	/**
	 * Gets the value of the attribute {@link #tableID}.
	 * 
	 * @return the value of the attribute {@link #tableID}.
	 */
	public String getTableID() {

		return tableID;
	}

	/**
	 * Sets the value of the attribute {@link #tableID}.
	 * 
	 * @param tableID
	 *            The value for the attribute {@link #tableID}.
	 */
	public void setTableID(String tableID) {

		this.tableID = tableID;
	}

	/**
	 * Gets the value of the attribute {@link #tableParent}.
	 * 
	 * @return the value of the attribute {@link #tableParent}.
	 */
	public String getTableParent() {

		return tableParent;
	}

	/**
	 * Sets the value of the attribute {@link #tableParent}.
	 * 
	 * @param tableParent
	 *            The value for the attribute {@link #tableParent}.
	 */
	public void setTableParent(String tableParent) {

		this.tableParent = tableParent;
	}

	/**
	 * Gets the value of the attribute {@link #tableProperty}.
	 * 
	 * @return the value of the attribute {@link #tableProperty}.
	 */
	public String getTableProperty() {

		return tableProperty;
	}

	/**
	 * Sets the value of the attribute {@link #tableProperty}.
	 * 
	 * @param tableProperty
	 *            The value for the attribute {@link #tableProperty}.
	 */
	public void setTableProperty(String tableProperty) {

		this.tableProperty = tableProperty;
	}

	/**
	 * Gets the value of the attribute {@link #tableOrder}.
	 * 
	 * @return the value of the attribute {@link #tableOrder}.
	 */
	public Integer getTableOrder() {

		return tableOrder;
	}

	/**
	 * Sets the value of the attribute {@link #tableOrder}.
	 * 
	 * @param tableOrder
	 *            The value for the attribute {@link #tableOrder}.
	 */
	public void setTableOrder(Integer tableOrder) {

		this.tableOrder = tableOrder;
	}

	/**
	 * Gets the value of the attribute {@link #addItem}.
	 * 
	 * @return the value of the attribute {@link #addItem}.
	 */
	public LabelDAO getAddItem() {

		return addItem;
	}

	/**
	 * Sets the value of the attribute {@link #addItem}.
	 * 
	 * @param addItem
	 *            The value for the attribute {@link #addItem}.
	 */
	public void setAddItem(LabelDAO addItem) {

		this.addItem = addItem;
	}

	/**
	 * Gets the value of the attribute {@link #cancelItem}.
	 * 
	 * @return the value of the attribute {@link #cancelItem}.
	 */
	public LabelDAO getCancelItem() {

		return cancelItem;
	}

	/**
	 * Sets the value of the attribute {@link #cancelItem}.
	 * 
	 * @param cancelItem
	 *            The value for the attribute {@link #cancelItem}.
	 */
	public void setCancelItem(LabelDAO cancelItem) {

		this.cancelItem = cancelItem;
	}

	/**
	 * Gets the value of the attribute {@link #saveItem}.
	 * 
	 * @return the value of the attribute {@link #saveItem}.
	 */
	public LabelDAO getSaveItem() {

		return saveItem;
	}

	/**
	 * Sets the value of the attribute {@link #saveItem}.
	 * 
	 * @param saveItem
	 *            The value for the attribute {@link #saveItem}.
	 */
	public void setSaveItem(LabelDAO saveItem) {

		this.saveItem = saveItem;
	}

}
