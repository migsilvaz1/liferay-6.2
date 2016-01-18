/* 
 * This file is part of the VUV Electronic Office of Government of Ecuador.
 * Copyright 2015.
 */

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.tags.FormField.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of VUV Electronic Office of Government of Ecuador.</p>
 * <b>Date:</b><p>24/7/2015.</p>
 * @version 1.0, 24/7/2015.
 */

package ec.gob.snap.vuv.dynamic.form.tags;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBElement;

/**
 * <p>Class FormField.</p> <b>Project:</b><p>VUV Electronic Office of
 * Government of Ecuador</p>
 * 
 * @version 1.0, 24/7/2015.
 */

public class FormField extends IncludeTag {

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;

	private static final String _PAGE = "/html/taglib/vuv/form-field.jsp";

	private JAXBElement<?> element;

	@Override
	protected String getPage() {

		return _PAGE;
	}

	@Override
	public int doStartTag() {

		return EVAL_BODY_INCLUDE;
	}

	@Override
	protected void cleanUp() {

		setElement(null);
	}

	@Override
	protected boolean isCleanUpSetAttributes() {

		return _CLEAN_UP_SET_ATTRIBUTES;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {

		request.setAttribute("vuv:form-field:element", getElement());
	}

	public JAXBElement<?> getElement() {

		return element;
	}

	public void setElement(JAXBElement<?> element) {

		this.element = element;
	}

}
