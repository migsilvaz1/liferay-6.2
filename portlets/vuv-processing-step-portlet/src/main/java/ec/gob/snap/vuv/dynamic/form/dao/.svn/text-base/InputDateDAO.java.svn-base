/* 
* This file is part of the VUV Electronic Office of Government of Ecuador.
* Copyright 2015.
*/

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.dao.InputDateDAO.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of xxxxxxxxxx.</p>
 * <b>Date:</b><p>23/7/2015.</p>
 * @version 1.0, 23/7/2015.
 */
package ec.gob.snap.vuv.dynamic.form.dao;

import ec.gob.snap.vuv.dynamic.form.entities.InputD;
import ec.gob.snap.vuv.dynamic.form.entities.PropertiesDate;
import ec.gob.snap.vuv.dynamic.form.entities.PropertiesDate.Label;
import ec.gob.snap.vuv.dynamic.form.entities.PropertiesDate.Title;
import ec.gob.snap.vuv.dynamic.form.entities.TipoBoolean;
import ec.gob.snap.vuv.dynamic.form.entities.TipoDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBElement;

import org.apache.xerces.dom.ElementNSImpl;


/** 
 * <p>Class InputDateDAO.</p>
 * <b>Project:</b><p>VUV Electronic Office of Government of Ecuador</p>
 * @version 1.0, 23/7/2015.
 */
public class InputDateDAO {

	
	private String inputDateID;
	private String inputDateName;
	private Integer order;
	private String parent;
	private LabelDAO labeli18n;
	private Date value;
	private String type;
	private Boolean fieldRequired;
	private Boolean groupWithPrevious;
	private Boolean readOnly;
	private LabelDAO titlei18n;
	private String onChangeScript;
	/**
	 * Constructor method for the class {@link InputDateDAO}. 
	 * @throws ParseException 
	 */
	public InputDateDAO(InputD inputField) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		this.inputDateID = inputField.getId();
		this.inputDateName = inputField.getProperty();
		this.order = inputField.getOrder();
		this.parent = inputField.getParent();

		PropertiesDate prop = inputField.getProperties();
		List<JAXBElement<?>> properties = prop.getLabelOrValueOrType();
		for (JAXBElement<?> property : properties) {
			if (property.getValue() instanceof Label) {
				labeli18n = new LabelDAO((Label) property.getValue());
			}
			else if(property.getValue() instanceof ElementNSImpl){
				
				String value_ = ((ElementNSImpl) property.getValue()).getFirstChild().getNodeValue();
				value = dateFormat.parse(value_);
				
			}
			else if (property.getValue() instanceof String) {
				switch (property.getName().toString()) {
				case "onChangeScript":
					onChangeScript = (String) property.getValue();
					onChangeScript = onChangeScript.replaceAll("<!\\[CDATA\\[(.*)\\]\\]>", "$1");
					break;
				}
			}
			else if (property.getValue() instanceof TipoDate) {
				type = ((TipoDate) property.getValue()).value();
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
			else if (property.getValue() instanceof Title) {
				titlei18n = new LabelDAO((Title) property.getValue());
			}
		}
	}
	
	/**
	 * Gets the value of the attribute {@link #inputDateID}.
	 * @return the value of the attribute {@link #inputDateID}.
	 */
	public String getInputDateID() {
	
		return inputDateID;
	}
	
	/**
	 * Sets the value of the attribute {@link #inputDateID}.
	 * @param inputDateID The value for the attribute {@link #inputDateID}.
	 */
	public void setInputDateID(String inputDateID) {
	
		this.inputDateID = inputDateID;
	}
	
	/**
	 * Gets the value of the attribute {@link #inputDateName}.
	 * @return the value of the attribute {@link #inputDateName}.
	 */
	public String getInputDateName() {
	
		return inputDateName;
	}
	
	/**
	 * Sets the value of the attribute {@link #inputDateName}.
	 * @param inputDateName The value for the attribute {@link #inputDateName}.
	 */
	public void setInputDateName(String inputDateName) {
	
		this.inputDateName = inputDateName;
	}
	
	/**
	 * Gets the value of the attribute {@link #order}.
	 * @return the value of the attribute {@link #order}.
	 */
	public Integer getOrder() {
	
		return order;
	}
	
	/**
	 * Sets the value of the attribute {@link #order}.
	 * @param order The value for the attribute {@link #order}.
	 */
	public void setOrder(Integer order) {
	
		this.order = order;
	}
	
	/**
	 * Gets the value of the attribute {@link #parent}.
	 * @return the value of the attribute {@link #parent}.
	 */
	public String getParent() {
	
		return parent;
	}
	
	/**
	 * Sets the value of the attribute {@link #parent}.
	 * @param parent The value for the attribute {@link #parent}.
	 */
	public void setParent(String parent) {
	
		this.parent = parent;
	}
	
	/**
	 * Gets the value of the attribute {@link #labeli18n}.
	 * @return the value of the attribute {@link #labeli18n}.
	 */
	public String getLabeli18n(Locale locale) {

		return labeli18n.getLabeli18n(locale);
	}
	
	/**
	 * Sets the value of the attribute {@link #labeli18n}.
	 * @param labeli18n The value for the attribute {@link #labeli18n}.
	 */
	public void setLabeli18n(Locale locale, String value) {

		this.labeli18n.setLabeli18n(locale, value);
	}
	
	/**
	 * Gets the value of the attribute {@link #value}.
	 * @return the value of the attribute {@link #value}.
	 */
	public Date getValue() {
	
		return value;
	}
	
	/**
	 * Sets the value of the attribute {@link #value}.
	 * @param value The value for the attribute {@link #value}.
	 */
	public void setValue(Date value) {
	
		this.value = value;
	}
	
	/**
	 * Gets the value of the attribute {@link #type}.
	 * @return the value of the attribute {@link #type}.
	 */
	public String getType() {
	
		return type;
	}
	
	/**
	 * Sets the value of the attribute {@link #type}.
	 * @param type The value for the attribute {@link #type}.
	 */
	public void setType(String type) {
	
		this.type = type;
	}
	
	/**
	 * Gets the value of the attribute {@link #fieldRequired}.
	 * @return the value of the attribute {@link #fieldRequired}.
	 */
	public Boolean isFieldRequired() {
	
		return fieldRequired;
	}
	
	/**
	 * Sets the value of the attribute {@link #fieldRequired}.
	 * @param fieldRequired The value for the attribute {@link #fieldRequired}.
	 */
	public void setFieldRequired(Boolean fieldRequired) {
	
		this.fieldRequired = fieldRequired;
	}
	
	/**
	 * Gets the value of the attribute {@link #groupWithPrevious}.
	 * @return the value of the attribute {@link #groupWithPrevious}.
	 */
	public Boolean isGroupWithPrevious() {
	
		return groupWithPrevious;
	}
	
	/**
	 * Sets the value of the attribute {@link #groupWithPrevious}.
	 * @param groupWithPrevious The value for the attribute {@link #groupWithPrevious}.
	 */
	public void setGroupWithPrevious(Boolean groupWithPrevious) {
	
		this.groupWithPrevious = groupWithPrevious;
	}
	
	/**
	 * Gets the value of the attribute {@link #readOnly}.
	 * @return the value of the attribute {@link #readOnly}.
	 */
	public Boolean isReadOnly() {
	
		return readOnly;
	}
	
	/**
	 * Sets the value of the attribute {@link #readOnly}.
	 * @param readOnly The value for the attribute {@link #readOnly}.
	 */
	public void setReadOnly(Boolean readOnly) {
	
		this.readOnly = readOnly;
	}
	
	/**
	 * Gets the value of the attribute {@link #titlei18n}.
	 * @return the value of the attribute {@link #titlei18n}.
	 */
	public String getTitlei18n(Locale locale) {

		return titlei18n.getLabeli18n(locale);
	}
	
	/**
	 * Sets the value of the attribute {@link #titlei18n}.
	 * @param titlei18n The value for the attribute {@link #titlei18n}.
	 */
	public void setTitlei18n(Locale locale, String title) {

		this.titlei18n.setLabeli18n(locale, title);
	}
	
	/**
	 * Gets the value of the attribute {@link #onChangeScript}.
	 * @return the value of the attribute {@link #onChangeScript}.
	 */
	public String getOnChangeScript() {
	
		return onChangeScript;
	}
	
	/**
	 * Sets the value of the attribute {@link #onChangeScript}.
	 * @param onChangeScript The value for the attribute {@link #onChangeScript}.
	 */
	public void setOnChangeScript(String onChangeScript) {
	
		this.onChangeScript = onChangeScript;
	}

}
