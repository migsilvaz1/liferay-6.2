/* 
* This file is part of the VUV Electronic Office of Government of Ecuador.
* Copyright 2015.
*/

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.dao.SelectBoxDAO.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of VUV Electronic Office of Government of Ecuador.</p>
 * <b>Date:</b><p>13/7/2015.</p>
 * @version 1.0, 13/7/2015.
 */
package ec.gob.snap.vuv.dynamic.form.dao;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import ec.gob.snap.vuv.dynamic.form.entities.Properties;
import ec.gob.snap.vuv.dynamic.form.entities.Properties.Title;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox.Options;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox.Options.Option;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SubForm;
import ec.gob.snap.vuv.dynamic.form.entities.Tipo;
import ec.gob.snap.vuv.dynamic.form.entities.TipoBoolean;
import ec.gob.snap.vuv.dynamic.form.entities.Properties.Label;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;


/** 
 * <p>Class SelectBoxDAO.</p>
 * <b>Project:</b><p>VUV Electronic Office of Government of Ecuador</p>
 * @version 1.0, 13/7/2015.
 */
public class SelectBoxDAO {
	private String selectID;
	private String selectName;
	private Integer order;
	private String parent;
	private LabelDAO labeli18n;
	private String value;
	private String type;
	private Boolean fieldRequired;
	private Boolean readOnly;
	private Boolean groupWithPrevious;
	private LabelDAO titlei18n;
	private Integer size;
	private String onChangeScript;
	private Map<String,LabelDAO> options;
	/**
	 * Constructor method for the class {@link SelectBoxDAO}. 
	 */
	public SelectBoxDAO(SelectBox selectBox) {
		
		this.selectID = selectBox.getId();
		this.selectName = selectBox.getProperty();
		this.order = selectBox.getOrder();
		this.parent = selectBox.getParent();
		
		Properties prop = selectBox.getProperties();
		List<JAXBElement<?>> properties = prop.getLabelOrAccionOrValue();
		for(JAXBElement<?> property: properties){
			if(property.getValue() instanceof Label){
				labeli18n = new LabelDAO((Label) property.getValue());
			}else if(property.getValue() instanceof String){
				switch (property.getName().toString()) {
				case "onChangeScript":
					onChangeScript = (String) property.getValue();
					onChangeScript = onChangeScript.replaceAll("<!\\[CDATA\\[(.*)\\]\\]>", "$1");
					break;
				case "value":
					value = (String) property.getValue();
					break;
				}
			}else if(property.getValue() instanceof Tipo){
				type = ((Tipo) property.getValue()).value();
			}else if(property.getValue() instanceof TipoBoolean){
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
			}else if (property.getValue() instanceof Title){
				titlei18n = new LabelDAO((Title) property.getValue());
			}else if (property.getValue() instanceof Integer){
				size = (Integer) property.getValue();
			}
		}	
		
		Options options = selectBox.getOptions();
		this.options = new HashMap<String, LabelDAO>();
		
		for(Option option: options.getOption()){
			this.options.put(option.getValue(), new LabelDAO((SelectBox.Options.Option.Label) option.getLabel()));
		}
	}
	
	public SelectBoxDAO(SubForm.SelectBox selectBox) {
		
		this.selectID = selectBox.getId();
		this.selectName = selectBox.getProperty();
		this.order = selectBox.getOrder();
		this.parent = selectBox.getParent();
		
		Properties prop = selectBox.getProperties();
		List<JAXBElement<?>> properties = prop.getLabelOrAccionOrValue();
		for(JAXBElement<?> property: properties){
			if(property.getValue() instanceof Label){
				labeli18n = new LabelDAO((Label) property.getValue());
			}else if(property.getValue() instanceof String){
				switch (property.getName().toString()) {
				case "onChangeScript":
					onChangeScript = (String) property.getValue();
					onChangeScript = onChangeScript.replaceAll("<!\\[CDATA\\[(.*)\\]\\]>", "$1");
					break;
				case "value":
					value = (String) property.getValue();
					break;
				}
			}else if(property.getValue() instanceof Tipo){
				type = ((Tipo) property.getValue()).value();
			}else if(property.getValue() instanceof TipoBoolean){
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
			}else if (property.getValue() instanceof Title){
				titlei18n = new LabelDAO((Title) property.getValue());
			}else if (property.getValue() instanceof Integer){
				size = (Integer) property.getValue();
			}
		}	
		
		SubForm.SelectBox.Options options = selectBox.getOptions();
		this.options = new HashMap<String, LabelDAO>();
		
		for(SubForm.SelectBox.Options.Option option: options.getOption()){
			this.options.put(option.getValue(), new LabelDAO((SubForm.SelectBox.Options.Option.Label) option.getLabel()));
		}
	}
	public SelectBoxDAO(MultipleSubForm.SubForm.SelectBox selectBox) {
		
		this.selectID = selectBox.getId();
		this.selectName = selectBox.getProperty();
		this.order = selectBox.getOrder();
		this.parent = selectBox.getParent();
		
		Properties prop = selectBox.getProperties();
		List<JAXBElement<?>> properties = prop.getLabelOrAccionOrValue();
		for(JAXBElement<?> property: properties){
			if(property.getValue() instanceof Label){
				labeli18n = new LabelDAO((Label) property.getValue());
			}else if(property.getValue() instanceof String){
				switch (property.getName().toString()) {
				case "onChangeScript":
					onChangeScript = (String) property.getValue();
					onChangeScript = onChangeScript.replaceAll("<!\\[CDATA\\[(.*)\\]\\]>", "$1");
					break;
				case "value":
					value = (String) property.getValue();
					break;
				}
			}else if(property.getValue() instanceof Tipo){
				type = ((Tipo) property.getValue()).value();
			}else if(property.getValue() instanceof TipoBoolean){
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
			}else if (property.getValue() instanceof Title){
				titlei18n = new LabelDAO((Title) property.getValue());
			}else if (property.getValue() instanceof Integer){
				size = (Integer) property.getValue();
			}
		}	
		
		MultipleSubForm.SubForm.SelectBox.Options options = selectBox.getOptions();
		this.options = new HashMap<String, LabelDAO>();
		
		for(MultipleSubForm.SubForm.SelectBox.Options.Option option: options.getOption()){
			this.options.put(option.getValue(), new LabelDAO((MultipleSubForm.SubForm.SelectBox.Options.Option.Label) option.getLabel()));
		}
	}
	
	/**
	 * Gets the value of the attribute {@link #labeli18n}.
	 * @return the value of the attribute {@link #labeli18n}.
	 */
	public String getLabeli18n(Locale locale) {
	
		return labeli18n.getLabeli18n(locale);
	}
	
	/**
	 * Gets the value of the attribute {@link #labeli18n}.
	 * @return the value of the attribute {@link #labeli18n}.
	 */
	public LabelDAO getLabeli18n() {
		
		return labeli18n;
	}
	
	/**
	 * Sets the value of the attribute {@link #labeli18n}.
	 * @param labeli18n The value for the attribute {@link #labeli18n}.
	 */
	public void setLabeli18n(Locale locale, String label) {
	
		this.labeli18n.setLabeli18n(locale, label); 
	}
	
	/**
	 * Gets the value of the attribute {@link #value}.
	 * @return the value of the attribute {@link #value}.
	 */
	public String getValue() {
	
		return value;
	}
	
	/**
	 * Sets the value of the attribute {@link #value}.
	 * @param value The value for the attribute {@link #value}.
	 */
	public void setValue(String value) {
	
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
	 * Gets the value of the attribute {@link #titlei18n}.
	 * @return the value of the attribute {@link #titlei18n}.
	 */
	public LabelDAO getTitlei18n() {
	
		return titlei18n;
	}
	
	/**
	 * Sets the value of the attribute {@link #titlei18n}.
	 * @param titlei18n The value for the attribute {@link #titlei18n}.
	 */
	public void setTitlei18n(LabelDAO titlei18n) {
	
		this.titlei18n = titlei18n;
	}
	
	/**
	 * Gets the value of the attribute {@link #size}.
	 * @return the value of the attribute {@link #size}.
	 */
	public Integer getSize() {
	
		return size;
	}
	
	/**
	 * Sets the value of the attribute {@link #size}.
	 * @param size The value for the attribute {@link #size}.
	 */
	public void setSize(Integer size) {
	
		this.size = size;
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
	
	/**
	 * Gets the value of the attribute {@link #options}.
	 * @return the value of the attribute {@link #options}.
	 */
	public String getOption(String value, Locale locale) {
	
		return options.get(value).getLabeli18n(locale);
	}
	/**
	 * Gets the value of the attribute {@link #options}.
	 * @return the value of the attribute {@link #options}.
	 */
	public Map<String, LabelDAO> getOptions() {
		
		return options;
	}
	
	
	public JSONObject getJSONOptions(Locale locale) {
		JSONObject jsonOptions = JSONFactoryUtil.createJSONObject();
		
		for(Entry<String, LabelDAO> option: options.entrySet()){
			jsonOptions.put(option.getKey(), option.getValue().getLabeli18n(locale));
		}
		return jsonOptions;
	}
	
	/**
	 * Sets the value of the attribute {@link #options}.
	 * @param options The value for the attribute {@link #options}.
	 */
	public void setOption(String value, Locale locale,String label) {
	
		if(options.containsKey(value)){
			options.get(value).setLabeli18n(locale, label);
		}else{
			LabelDAO labeli18n = new LabelDAO();
			labeli18n.setLabeli18n(locale, label);
			this.options.put(value,labeli18n);
		}
	}

	
	/**
	 * Gets the value of the attribute {@link #selectID}.
	 * @return the value of the attribute {@link #selectID}.
	 */
	public String getSelectID() {
	
		return selectID;
	}

	
	/**
	 * Sets the value of the attribute {@link #selectID}.
	 * @param selectID The value for the attribute {@link #selectID}.
	 */
	public void setSelectID(String selectID) {
	
		this.selectID = selectID;
	}

	
	/**
	 * Gets the value of the attribute {@link #selectName}.
	 * @return the value of the attribute {@link #selectName}.
	 */
	public String getSelectName() {
	
		return selectName;
	}

	
	/**
	 * Sets the value of the attribute {@link #selectName}.
	 * @param selectName The value for the attribute {@link #selectName}.
	 */
	public void setSelectName(String selectName) {
	
		this.selectName = selectName;
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

}
