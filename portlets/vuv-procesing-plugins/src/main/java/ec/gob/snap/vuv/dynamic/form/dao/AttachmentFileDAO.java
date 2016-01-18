package ec.gob.snap.vuv.dynamic.form.dao;

import java.util.List;

import ec.gob.snap.vuv.dynamic.form.entities.Properties.Label;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.AttachmentFile;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.AttachmentFile.Properties;
import ec.gob.snap.vuv.dynamic.form.entities.TipoArchivo;
import ec.gob.snap.vuv.dynamic.form.entities.TipoBoolean;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.TransformerConfigurationException;

public class AttachmentFileDAO {
	
	private String attachmentFileId;
	private String attachmentFileName;
	private LabelDAO labelDAO;
	private byte[] value;
//	private Object encoding;
	private String nameFile;
	private String typeFile;
	private String pathFile;
	private Boolean fieldRequired;
	private Boolean readOnly;
	private Boolean groupWithPrevious;

//-------------------------------------------------------------------------
	public AttachmentFileDAO(String attachmentFileId){
		this.attachmentFileId = attachmentFileId;
	}
//-------------------------------------------------------------------------

	public AttachmentFileDAO(AttachmentFile attachmentFile) throws TransformerConfigurationException {
		this.attachmentFileId = attachmentFile.getId();
		this.attachmentFileName = (attachmentFile.getProperty() != null) ? attachmentFile.getProperty() : attachmentFile.getId();
		Properties prop = attachmentFile.getProperties();
		List<JAXBElement<?>> properties = prop.getLabelOrValueOrEncoding();
		for (JAXBElement<?> property : properties) {
			if(property.getValue() instanceof Label) {
				labelDAO = new LabelDAO((Label) property.getValue());
			}else if(property.getValue() instanceof String) {
				switch (property.getName().toString()) {
				case "nameFile":
					nameFile = (String) property.getValue();
					break;
				case "typeFile":
					typeFile = (String) property.getValue();
					break;
				case "pathFile":
					pathFile = (String) property.getValue();
					break;
				}
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
			}else if(property.getValue() instanceof byte[]){
				value = (byte[]) property.getValue();
			}else if(property.getValue() instanceof TipoArchivo){
				//TODO definir tipo para encoding
				//encoding = property.getValue();
			}
		}
	}
	
	/**
	 * Gets the value of the attribute {@link #attachmentFileId}.
	 * @return the value of the attribute {@link #attachmentFileId}.
	 */
	public String getAttachmentFileId() {
		return attachmentFileId;
	}

	/**
	 * Sets the value of the attribute {@link #attachmentFileId}.
	 * @param attachmentFileId The value for the attribute {@link #attachmentFileId}.
	 */
	public void setAttachmentFileId(String attachmentFileId) {
		this.attachmentFileId = attachmentFileId;
	}

	/**
	 * Gets the value of the attribute {@link #attachmentFileName}.
	 * @return the value of the attribute {@link #attachmentFileName}.
	 */
	public String getAttachmentFileName() {
		return attachmentFileName;
	}

	/**
	 * Sets the value of the attribute {@link #attachmentFileName}.
	 * @param attachmentFileName The value for the attribute {@link #attachmentFileName}.
	 */
	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

	/**
	 * Gets the value of the attribute {@link #labelDAO}.
	 * @return the value of the attribute {@link #labelDAO}.
	 */
	public LabelDAO getLabelDAO() {
		return labelDAO;
	}

	/**
	 * Sets the value of the attribute {@link #labelDAO}.
	 * @param labelDAO The value for the attribute {@link #labelDAO}.
	 */
	public void setLabelDAO(LabelDAO labelDAO) {
		this.labelDAO = labelDAO;
	}

	/**
	 * Gets the value of the attribute {@link #value}.
	 * @return the value of the attribute {@link #value}.
	 */
	public byte[] getValue() {
		return value;
	}

	/**
	 * Sets the value of the attribute {@link #value}.
	 * @param value The value for the attribute {@link #value}.
	 */
	public void setValue(byte[] value) {
		this.value = value;
	}

	/**
	 * Gets the value of the attribute {@link #nameFile}.
	 * @return the value of the attribute {@link #nameFile}.
	 */
	public String getNameFile() {
		return nameFile;
	}

	/**
	 * Sets the value of the attribute {@link #nameFile}.
	 * @param nameFile The value for the attribute {@link #nameFile}.
	 */
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	/**
	 * Gets the value of the attribute {@link #typeFile}.
	 * @return the value of the attribute {@link #typeFile}.
	 */
	public String getTypeFile() {
		return typeFile;
	}

	/**
	 * Sets the value of the attribute {@link #typeFile}.
	 * @param typeFile The value for the attribute {@link #typeFile}.
	 */
	public void setTypeFile(String typeFile) {
		this.typeFile = typeFile;
	}

	/**
	 * Gets the value of the attribute {@link #pathFile}.
	 * @return the value of the attribute {@link #pathFile}.
	 */
	public String getPathFile() {
		return pathFile;
	}

	/**
	 * Sets the value of the attribute {@link #pathFile}.
	 * @param pathFile The value for the attribute {@link #pathFile}.
	 */
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	/**
	 * Gets the value of the attribute {@link #fieldRequired}.
	 * @return the value of the attribute {@link #fieldRequired}.
	 */
	public Boolean getFieldRequired() {
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
	public Boolean getReadOnly() {
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
	public Boolean getGroupWithPrevious() {
		return groupWithPrevious;
	}

	/**
	 * Sets the value of the attribute {@link #groupWithPrevious}.
	 * @param groupWithPrevious The value for the attribute {@link #groupWithPrevious}.
	 */
	public void setGroupWithPrevious(Boolean groupWithPrevious) {
		this.groupWithPrevious = groupWithPrevious;
	}
}
