/* 
* This file is part of the VUV Electronic Office of Government of Ecuador.
* Copyright 2015.
*/

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.dao.OutputTextDAO.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of xxxxxxxxxx.</p>
 * <b>Date:</b><p>10/7/2015.</p>
 * @version 1.0, 10/7/2015.
 */
package ec.gob.snap.vuv.dynamic.form.dao;

import ec.gob.snap.vuv.dynamic.form.entities.InputLabel;
import ec.gob.snap.vuv.dynamic.form.entities.Properties;
import ec.gob.snap.vuv.dynamic.form.entities.Properties.Label;
import ec.gob.snap.vuv.dynamic.form.entities.TipoBoolean;

import java.util.List;

import javax.xml.bind.JAXBElement;


/** 
 * <p>Class OutputTextDAO.</p>
 * <b>Project:</b><p>VUV Electronic Office of Government of Ecuador</p>
 * @version 1.0, 10/7/2015.
 */
public class OutputTextDAO {
	private String outputID;
	private Integer order;
	private LabelDAO labeli18n;
	private Boolean fieldRequired;
	private Boolean readOnly;
	private Boolean groupWithPrevious;
	
	/**
	 * Constructor method for the class {@link OutputTextDAO}. 
	 */
	public OutputTextDAO(InputLabel outputText) {
		this.outputID = outputText.getId();
		this.order = outputText.getOrder();
		
		Properties prop = outputText.getProperties();
		List<JAXBElement<?>> properties = prop.getLabelOrAccionOrValue();
		for(JAXBElement<?> property: properties){
			if(property.getValue() instanceof Label){
				labeli18n = new LabelDAO((Label) property.getValue());
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
			}
		}		
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
	public void setLabeli18n(LabelDAO labeli18n) {
	
		this.labeli18n = labeli18n;
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
	 * Gets the value of the attribute {@link #outputID}.
	 * @return the value of the attribute {@link #outputID}.
	 */
	public String getOutputID() {
	
		return outputID;
	}
	
	/**
	 * Sets the value of the attribute {@link #outputID}.
	 * @param inputID The value for the attribute {@link #outputID}.
	 */
	public void setOutputID(String inputID) {
	
		this.outputID = inputID;
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

}
