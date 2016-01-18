/* 
 * This file is part of the VUV Electronic Office of Government of Ecuador.
 * Copyright 2015.
 */

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.dao.LabelDAO.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of VUV Electronic Office of Government of Ecuador.</p>
 * <b>Date:</b><p>10/7/2015.</p>
 * @version 1.0, 10/7/2015.
 */

package ec.gob.snap.vuv.dynamic.form.dao;

import ec.gob.snap.vuv.dynamic.form.entities.Properties;
import ec.gob.snap.vuv.dynamic.form.entities.PropertiesDate;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm.AddItemText;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm.CancelItemText;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm.NewItemText;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SelectBox;
import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.SubForm;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.apache.xerces.dom.ElementNSImpl;

/**
 * <p>Class LabelDAO.</p> <b>Project:</b><p>VUV Electronic Office of Government
 * of Ecuador</p>
 * 
 * @version 1.0, 10/7/2015.
 */
public class LabelDAO {

	private Map<Locale, String> labeli18n;

	/**
	 * Constructor method for the class {@link LabelDAO}.
	 */
	public LabelDAO(Properties.Label labelJAXB) {

		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";
		if (((ElementNSImpl) labelJAXB.getEs()).getFirstChild() != null) {
			labelES = ((ElementNSImpl) labelJAXB.getEs()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) labelJAXB.getEn()).getFirstChild() != null) {
			labelEN = ((ElementNSImpl) labelJAXB.getEn()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) labelJAXB.getQu()).getFirstChild() != null) {
			labelQU = ((ElementNSImpl) labelJAXB.getQu()).getFirstChild().getNodeValue();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}
	
	public LabelDAO(PropertiesDate.Label labelJAXB) {
		
		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";
		if (((ElementNSImpl) labelJAXB.getEs()).getFirstChild() != null) {
			labelES = ((ElementNSImpl) labelJAXB.getEs()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) labelJAXB.getEn()).getFirstChild() != null) {
			labelEN = ((ElementNSImpl) labelJAXB.getEn()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) labelJAXB.getQu()).getFirstChild() != null) {
			labelQU = ((ElementNSImpl) labelJAXB.getQu()).getFirstChild().getNodeValue();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}

	public LabelDAO(SelectBox.Options.Option.Label labelJAXB) {

		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";
		if (((ElementNSImpl) labelJAXB.getEs()).getFirstChild() != null) {
			labelES = ((ElementNSImpl) labelJAXB.getEs()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) labelJAXB.getEn()).getFirstChild() != null) {
			labelEN = ((ElementNSImpl) labelJAXB.getEn()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) labelJAXB.getQu()).getFirstChild() != null) {
			labelQU = ((ElementNSImpl) labelJAXB.getQu()).getFirstChild().getNodeValue();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}

	public LabelDAO(SubForm.SelectBox.Options.Option.Label labelJAXB) {

		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";
		if (((ElementNSImpl) labelJAXB.getEs()).getFirstChild() != null) {
			labelES = ((ElementNSImpl) labelJAXB.getEs()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) labelJAXB.getEn()).getFirstChild() != null) {
			labelEN = ((ElementNSImpl) labelJAXB.getEn()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) labelJAXB.getQu()).getFirstChild() != null) {
			labelQU = ((ElementNSImpl) labelJAXB.getQu()).getFirstChild().getNodeValue();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}
	public LabelDAO(MultipleSubForm.SubForm.SelectBox.Options.Option.Label labelJAXB) {
		
		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";

		labelJAXB.getContent().get(0);

		if (labelJAXB.getContent() != null) {
			if(((ElementNSImpl)((JAXBElement<?>)labelJAXB.getContent().get(1)).getValue()).getFirstChild() != null){
				labelES = ((ElementNSImpl)((JAXBElement<?>)labelJAXB.getContent().get(1)).getValue()).getFirstChild().getNodeValue();
			}
			if(((ElementNSImpl)((JAXBElement<?>)labelJAXB.getContent().get(3)).getValue()).getFirstChild() != null){
				labelEN = ((ElementNSImpl)((JAXBElement<?>)labelJAXB.getContent().get(3)).getValue()).getFirstChild().getNodeValue();
			}
			if(((ElementNSImpl)((JAXBElement<?>)labelJAXB.getContent().get(5)).getValue()).getFirstChild() != null){
				labelQU = ((ElementNSImpl)((JAXBElement<?>)labelJAXB.getContent().get(5)).getValue()).getFirstChild().getNodeValue();
			}
		}

		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}

	public LabelDAO(Properties.Title titleJAXB) {

		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";
		if (((ElementNSImpl) titleJAXB.getEs()).getFirstChild() != null) {
			labelES = ((ElementNSImpl) titleJAXB.getEs()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) titleJAXB.getEn()).getFirstChild() != null) {
			labelEN = ((ElementNSImpl) titleJAXB.getEn()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) titleJAXB.getQu()).getFirstChild() != null) {
			labelQU = ((ElementNSImpl) titleJAXB.getQu()).getFirstChild().getNodeValue();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}
	
	public LabelDAO(PropertiesDate.Title titleJAXB) {
		
		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";
		if (((ElementNSImpl) titleJAXB.getEs()).getFirstChild() != null) {
			labelES = ((ElementNSImpl) titleJAXB.getEs()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) titleJAXB.getEn()).getFirstChild() != null) {
			labelEN = ((ElementNSImpl) titleJAXB.getEn()).getFirstChild().getNodeValue();
		}
		if (((ElementNSImpl) titleJAXB.getQu()).getFirstChild() != null) {
			labelQU = ((ElementNSImpl) titleJAXB.getQu()).getFirstChild().getNodeValue();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}

	public LabelDAO(AddItemText labelADDItem) {

		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";

		labelADDItem.getContent().get(0);

		if (labelADDItem.getContent() != null) {
			labelES = labelADDItem.getContent().get(0).toString();
			labelEN = labelADDItem.getContent().get(1).toString();
			labelQU = labelADDItem.getContent().get(2).toString();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}

	public LabelDAO(NewItemText labelNewItem) {

		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";

		labelNewItem.getContent().get(0);

		if (labelNewItem.getContent() != null) {
			labelES = labelNewItem.getContent().get(0).toString();
			labelEN = labelNewItem.getContent().get(1).toString();
			labelQU = labelNewItem.getContent().get(2).toString();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}

	public LabelDAO(CancelItemText labelCancelItem) {

		labeli18n = new HashMap<Locale, String>();
		String labelES = "";
		String labelEN = "";
		String labelQU = "";

		labelCancelItem.getContent().get(0);

		if (labelCancelItem.getContent() != null) {
			labelES = labelCancelItem.getContent().get(0).toString();
			labelEN = labelCancelItem.getContent().get(1).toString();
			labelQU = labelCancelItem.getContent().get(2).toString();
		}
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}

	public LabelDAO() {
		labeli18n = new HashMap<Locale, String>();

		String labelES = "";
		String labelEN = "";
		String labelQU = "";
		
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}
	public LabelDAO(String defaultValue) {
		labeli18n = new HashMap<Locale, String>();
		
		String labelES = defaultValue;
		String labelEN = defaultValue;
		String labelQU = defaultValue;
		
		labeli18n.put(new Locale("es", "ES"), labelES);
		labeli18n.put(new Locale("en", "US"), labelEN);
		labeli18n.put(new Locale("qu", "EC"), labelQU);
	}

	/**
	 * Gets the value of the attribute {@link #labeli18n}.
	 * 
	 * @return the value of the attribute {@link #labeli18n}.
	 */
	public String getLabeli18n(Locale locale) {

		return labeli18n.get(locale);
	}
	/**
	 * Gets the value of the attribute {@link #labeli18n}.
	 * 
	 * @return the value of the attribute {@link #labeli18n}.
	 */
	public Map<Locale, String> getLabeli18n() {
		
		return labeli18n;
	}

	/**
	 * Sets the value of the attribute {@link #labeli18n}.
	 * 
	 * @param labeli18n
	 *            The value for the attribute {@link #labeli18n}.
	 */
	public void setLabeli18n(Locale locale, String labeli18n) {

		this.labeli18n.put(locale, labeli18n);
	}

}
