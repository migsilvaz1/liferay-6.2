/* 
* This file is part of the VUV Electronic Office of Government of Ecuador.
* Copyright 2015.
*/

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.dynamic.form.tags.FormActionSection.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of VUV Electronic Office of Government of Ecuador.</p>
 * <b>Date:</b><p>24/7/2015.</p>
 * @version 1.0, 24/7/2015.
 */
package ec.gob.snap.vuv.dynamic.form.tags;
import com.liferay.taglib.util.IncludeTag;

import ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.Acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


/** 
 * <p>Class FormActionSection.</p>
 * <b>Project:</b><p>VUV Electronic Office of Government of Ecuador</p>
 * @version 1.0, 24/7/2015.
 */
public class FormActionSection extends IncludeTag  {
     
    	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = true;
     
    	private static final String _PAGE = "/html/taglib/vuv/form-actions-section.jsp";
     
    	private List<Acciones> actions;
     
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
    		setActions(null);
    	}
     
    	@Override
    	protected boolean isCleanUpSetAttributes() {
    		return _CLEAN_UP_SET_ATTRIBUTES;
    	}
     
    	@Override
    	protected void setAttributes(HttpServletRequest request) {
    		request.setAttribute("vuv:form-actions-section:actions", getActions());
    	}
     
    	public List<Acciones>  getActions() {
    		return actions;
    	}
     
    	public void setActions(List<Acciones>  actions) {
    		this.actions = actions;
    	}
     
}
