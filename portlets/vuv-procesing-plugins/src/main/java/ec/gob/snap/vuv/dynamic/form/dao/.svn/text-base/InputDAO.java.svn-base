/* 
 * This file is part of the VUV Electronic Office of Government of Ecuador.
 * Copyright 2015.
 */

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.dao.InputDAO.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of xxxxxxxxxx.</p>
 * <b>Date:</b><p>10/7/2015.</p>
 * @version 1.0, 10/7/2015.
 */

package ec.gob.snap.vuv.dynamic.form.dao;

import ec.gob.snap.vuv.dynamic.form.entities.Input;
import ec.gob.snap.vuv.dynamic.form.entities.Properties;
import ec.gob.snap.vuv.dynamic.form.entities.Properties.Label;
import ec.gob.snap.vuv.dynamic.form.entities.Properties.Title;
import ec.gob.snap.vuv.dynamic.form.entities.Tipo;
import ec.gob.snap.vuv.dynamic.form.entities.TipoBoolean;

import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.TransformerConfigurationException;

/**
 * <p>Class InputDAO.</p> <b>Project:</b><p>VUV Electronic Office of Government
 * of Ecuador</p>
 * 
 * @version 1.0, 10/7/2015.
 */
public class InputDAO {

	private String inputID;
	private String inputName;
	private Integer order;
	private String parent;
	private LabelDAO labeli18n;
	private String action;
	private String value;
	private String type;
	private Boolean fieldRequired;
	private Boolean groupWithPrevious;
	private Boolean readOnly;
	private LabelDAO titlei18n;
	private Integer size;
	private Integer maxLength;
	private Integer height; 
	private String onChangeScript;

	/**
	 * Constructor method for the class {@link InputDAO}.
	 * @throws TransformerConfigurationException 
	 */
	public InputDAO(Input inputField) throws TransformerConfigurationException {

		this.inputID = inputField.getId();
		this.inputName = (inputField.getProperty() != null) ? inputField.getProperty() : inputField.getId();
		this.order = inputField.getOrder();
		this.parent = (inputField.getParent() != null) ? inputField.getParent() : "";
		this.setHeight(0);

		Properties prop = inputField.getProperties();
		List<JAXBElement<?>> properties = prop.getLabelOrAccionOrValue();
		for (JAXBElement<?> property : properties) {
			if (property.getValue() instanceof Label) {
				labeli18n = new LabelDAO((Label) property.getValue());
			}
			else if (property.getValue() instanceof String) {
				switch (property.getName().toString()) {
				case "accion":
					action = (String) property.getValue();
					break;
				case "value":
					value = (String) property.getValue();
					break;
				case "onChangeScript":
					onChangeScript = (String) property.getValue();
					onChangeScript = onChangeScript.replaceAll("<!\\[CDATA\\[(.*)\\]\\]>", "$1");
					break;
				}
			}
			else if (property.getValue() instanceof Tipo) {
				type = ((Tipo) property.getValue()).value();
			}
			else if (property.getValue() instanceof TipoBoolean) {
				switch (property.getName().toString()) {
				case "fieldRequired":
					fieldRequired = Boolean.parseBoolean(((TipoBoolean) property.getValue()).name());
					break;
				case "readOnly":
					readOnly = Boolean.parseBoolean(((TipoBoolean) property.getValue()).name());
					break;
				case "groupWithPrevious":
					groupWithPrevious = Boolean.parseBoolean(((TipoBoolean) property.getValue()).name());
					break;
				}
			}
			else if (property.getValue() instanceof Integer) {
				switch (property.getName().toString()) {
				case "size":
					size = (Integer) property.getValue();
					break;
				case "maxLength":
					maxLength = (Integer) property.getValue();
					break;
				case "height":
					setHeight((Integer) property.getValue());
					break;
				}
			}
			else if (property.getValue() instanceof Title) {
				titlei18n = new LabelDAO((Title) property.getValue());
			}
		}
	}

	/**
	 * Gets the value of the attribute {@link #inputID}.
	 * 
	 * @return the value of the attribute {@link #inputID}.
	 */
	public String getInputID() {

		return inputID;
	}

	/**
	 * Sets the value of the attribute {@link #inputID}.
	 * 
	 * @param inputID
	 *            The value for the attribute {@link #inputID}.
	 */
	public void setInputID(String inputID) {

		this.inputID = inputID;
	}

	/**
	 * Gets the value of the attribute {@link #inputName}.
	 * 
	 * @return the value of the attribute {@link #inputName}.
	 */
	public String getInputName() {

		return inputName;
	}

	/**
	 * Sets the value of the attribute {@link #inputName}.
	 * 
	 * @param inputName
	 *            The value for the attribute {@link #inputName}.
	 */
	public void setInputName(String inputName) {

		this.inputName = inputName;
	}

	/**
	 * Gets the value of the attribute {@link #order}.
	 * 
	 * @return the value of the attribute {@link #order}.
	 */
	public Integer getOrder() {

		return order;
	}

	/**
	 * Sets the value of the attribute {@link #order}.
	 * 
	 * @param order
	 *            The value for the attribute {@link #order}.
	 */
	public void setOrder(Integer order) {

		this.order = order;
	}

	/**
	 * Gets the value of the attribute {@link #parent}.
	 * 
	 * @return the value of the attribute {@link #parent}.
	 */
	public String getParent() {

		return parent;
	}

	/**
	 * Sets the value of the attribute {@link #parent}.
	 * 
	 * @param parent
	 *            The value for the attribute {@link #parent}.
	 */
	public void setParent(String parent) {

		this.parent = parent;
	}

	/**
	 * Gets the value of the attribute {@link #action}.
	 * 
	 * @return the value of the attribute {@link #action}.
	 */
	public String getAction() {

		return action;
	}

	/**
	 * Sets the value of the attribute {@link #action}.
	 * 
	 * @param action
	 *            The value for the attribute {@link #action}.
	 */
	public void setAction(String action) {

		this.action = action;
	}

	/**
	 * Gets the value of the attribute {@link #type}.
	 * 
	 * @return the value of the attribute {@link #type}.
	 */
	public String getType() {

		return type;
	}

	/**
	 * Sets the value of the attribute {@link #type}.
	 * 
	 * @param type
	 *            The value for the attribute {@link #type}.
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 * Gets the value of the attribute {@link #value}.
	 * 
	 * @return the value of the attribute {@link #value}.
	 */
	public String getValue() {

		return value;
	}

	/**
	 * Sets the value of the attribute {@link #value}.
	 * 
	 * @param value
	 *            The value for the attribute {@link #value}.
	 */
	public void setValue(String value) {

		this.value = value;
	}

	/**
	 * Gets the value of the attribute {@link #fieldRequired}.
	 * 
	 * @return the value of the attribute {@link #fieldRequired}.
	 */
	public Boolean isFieldRequired() {

		return fieldRequired;
	}

	/**
	 * Sets the value of the attribute {@link #fieldRequired}.
	 * 
	 * @param fieldRequired
	 *            The value for the attribute {@link #fieldRequired}.
	 */
	public void setFieldRequired(Boolean fieldRequired) {

		this.fieldRequired = fieldRequired;
	}

	/**
	 * Gets the value of the attribute {@link #groupWithPrevious}.
	 * 
	 * @return the value of the attribute {@link #groupWithPrevious}.
	 */
	public Boolean isGroupWithPrevious() {

		return groupWithPrevious;
	}

	/**
	 * Sets the value of the attribute {@link #groupWithPrevious}.
	 * 
	 * @param groupWithPrevious
	 *            The value for the attribute {@link #groupWithPrevious}.
	 */
	public void setGroupWithPrevious(Boolean groupWithPrevious) {

		this.groupWithPrevious = groupWithPrevious;
	}

	/**
	 * Gets the value of the attribute {@link #readOnly}.
	 * 
	 * @return the value of the attribute {@link #readOnly}.
	 */
	public Boolean isReadOnly() {

		return readOnly;
	}

	/**
	 * Sets the value of the attribute {@link #readOnly}.
	 * 
	 * @param readOnly
	 *            The value for the attribute {@link #readOnly}.
	 */
	public void setReadOnly(Boolean readOnly) {

		this.readOnly = readOnly;
	}

	/**
	 * Sets the value of the attribute {@link #labeli18n}.
	 * 
	 * @param labeli18n
	 *            The value for the attribute {@link #labeli18n}.
	 */
	public void setLabeli18n(Locale locale, String value) {

		this.labeli18n.setLabeli18n(locale, value);
	}

	/**
	 * Gets the value of the attribute {@link #labeli18n}.
	 * 
	 * @return the value of the attribute {@link #labeli18n}.
	 */
	public String getLabeli18n(Locale locale) {

		return labeli18n.getLabeli18n(locale);
	}
	/**
	 * Gets the value of the attribute {@link #labeli18n}.
	 * 
	 * @return the value of the attribute {@link #labeli18n}.
	 */
	public LabelDAO getLabeli18n() {
		
		return labeli18n;
	}

	/**
	 * Gets the value of the attribute {@link #titlei18n}.
	 * 
	 * @return the value of the attribute {@link #titlei18n}.
	 */
	public String getTitlei18n(Locale locale) {

		return titlei18n.getLabeli18n(locale);
	}

	/**
	 * Sets the value of the attribute {@link #titlei18n}.
	 * 
	 * @param titlei18n
	 *            The value for the attribute {@link #titlei18n}.
	 */
	public void setTitlei18n(Locale locale, String title) {

		this.titlei18n.setLabeli18n(locale, title);
	}

	/**
	 * Gets the value of the attribute {@link #size}.
	 * 
	 * @return the value of the attribute {@link #size}.
	 */
	public Integer getSize() {

		return size;
	}

	/**
	 * Sets the value of the attribute {@link #size}.
	 * 
	 * @param size
	 *            The value for the attribute {@link #size}.
	 */
	public void setSize(Integer size) {

		this.size = size;
	}

	/**
	 * Gets the value of the attribute {@link #maxLength}.
	 * 
	 * @return the value of the attribute {@link #maxLength}.
	 */
	public Integer getMaxLength() {

		return maxLength;
	}

	/**
	 * Sets the value of the attribute {@link #maxLength}.
	 * 
	 * @param maxLength
	 *            The value for the attribute {@link #maxLength}.
	 */
	public void setMaxLength(Integer maxLength) {

		this.maxLength = maxLength;
	}

	/**
	 * Gets the value of the attribute {@link #height}.
	 * @return the value of the attribute {@link #height}.
	 */
	public Integer getHeight() {

		return height;
	}

	/**
	 * Sets the value of the attribute {@link #height}.
	 * @param height The value for the attribute {@link #height}.
	 */
	public void setHeight(Integer height) {

		this.height = height;
	}

	/**
	 * Gets the value of the attribute {@link #onChangeScript}.
	 * 
	 * @return the value of the attribute {@link #onChangeScript}.
	 */
	public String getOnChangeScript() {

		return onChangeScript;
	}

	/**
	 * Sets the value of the attribute {@link #onChangeScript}.
	 * 
	 * @param onChangeScript
	 *            The value for the attribute {@link #onChangeScript}.
	 */
	public void setOnChangeScript(String onChangeScript) {

		this.onChangeScript = onChangeScript;
	}

}
