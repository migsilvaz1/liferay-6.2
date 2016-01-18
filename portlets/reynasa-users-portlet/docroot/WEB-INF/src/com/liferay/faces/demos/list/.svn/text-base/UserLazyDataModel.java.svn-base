/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.demos.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.liferay.faces.demos.bean.UsersModelBean;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
//import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.interfaces.TO.UsuarioTO;
import com.near.reynasa.interfaces.action.UsuarioTOAction;
import com.near.reynasa.utils.IntegrationException;
import com.near.reynasa.utils.PlexException;


/**
 * This class extends the PrimeFaces {@link LazyDataModel} in order to provide a lazy-loaded list of {@link User}
 * objects to the p:dataTable in the users.xhtml Facelet view.
 *
 * @author  Neil Griffin
 * @author  Kyle Stiemann
 */
@ManagedBean(name = "userLazyDataModel")
@RequestScoped
public class UserLazyDataModel extends LazyDataModel<UsuarioTO> implements Serializable {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(UserLazyDataModel.class);

	@ManagedProperty(name = "usersModelBean", value = "#{usersModelBean}")
	private UsersModelBean usersModelBean;
	
	// serialVersionUID
	private static final long serialVersionUID = 2087063071907939066L;

	// Private Constants
	private static final String DEFAULT_SORT_CRITERIA = "lastName";

	// Private Data Members
	private long companyId;
	
	private static UsuarioTOAction usuarioTOAction=new UsuarioTOActionImpl();

	public UserLazyDataModel(long companyId, int pageSize) {

		this.companyId = companyId;
		setPageSize(pageSize);
		setRowCount(countRows());
	}

	public int countRows() {

		int totalCount = 0;
		List<UsuarioTO> users = null;
		Boolean activo = null;
		if(usersModelBean.getActivo().equals("0")){
			activo = true;
		}else if(usersModelBean.getActivo().equals("1")){
			activo = false;
		}
		
		Boolean activoLogico = true;
		if(usersModelBean.getActivoLogico().equals("0")){
			activoLogico = true;
		}else{
			activoLogico = false;
		}
		if(usersModelBean!=null &&(usersModelBean.getUserCode()!=null || usersModelBean.getName()!=null || usersModelBean.getSurname()!=null)){
			try {
				users=usuarioTOAction.findByParams(usersModelBean.getUserCode(), usersModelBean.getName(), usersModelBean.getSurname(), null, null, null, null, true, true);
			}
			catch (IntegrationException | PlexException e) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e.getMessage()));
			}
		}else{
			try {
				users = usuarioTOAction.findAllUsers(activo, activoLogico);
			}
			catch (IntegrationException | PlexException e) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e.getMessage()));
			}
		}
		
		
		totalCount=users.size();

//		try {
//			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
//			params.put("expandoAttributes", null);
//
//			Sort sort = SortFactoryUtil.getSort(UsuarioTO.class, DEFAULT_SORT_CRITERIA, "asc");
//
//			boolean andSearch = true;
//			int status = WorkflowConstants.STATUS_ANY;
//
//			String firstName = null;
//			String middleName = null;
//			String lastName = null;
//			String screenName = null;
//			String emailAddress = null;
//
//			Hits hits = UserLocalServiceUtil.search(companyId, firstName, middleName, lastName, screenName,
//					emailAddress, status, params, andSearch, QueryUtil.ALL_POS, QueryUtil.ALL_POS, sort);
//			totalCount = hits.getLength();
//
//		}
//		catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}

		return totalCount;
	}

	/**
	 * This method is called by the PrimeFaces {@link DataTable} according to the rows specified in the currently
	 * displayed page of data.
	 *
	 * @param  first      The zero-relative first row index.
	 * @param  pageSize   The number of rows to fetch.
	 * @param  sortField  The name of the field which the table is sorted by.
	 * @param  sortOrder  The sort order, which can be either ascending (default) or descending.
	 * @param  filters    The query criteria. Note that in order for the filtering to work with the Liferay API, the
	 *                    end-user must specify complete, matching words. Wildcards and partial matches are not
	 *                    supported.
	 */
	@Override
	public List<UsuarioTO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
		Map<String, Object> filters) {

		Boolean activo = null;
		if(usersModelBean.getActivo().equals("0")){
			activo = true;
		}else if(usersModelBean.getActivo().equals("1")){
			activo = false;
		}
		
		Boolean activoLogico = true;
		if(usersModelBean.getActivoLogico().equals("0")){
			activoLogico = true;
		}else{
			activoLogico = false;
		}
		
		List<UsuarioTO> users = null;
		//
		if(usersModelBean!=null &&(usersModelBean.getUserCode()!=null || usersModelBean.getName()!=null || usersModelBean.getSurname()!=null)){
			try {
				users=usuarioTOAction.findByParams(usersModelBean.getUserCode(), usersModelBean.getName(), usersModelBean.getSurname(), null, null, null, null, true, true);
			}
			catch (IntegrationException e) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e.getMessage()));
			}
			catch (PlexException e) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e.getMessage()));
			}
		}else{
			try {
				users = usuarioTOAction.findAllUsers(activo, activoLogico);
			}
			catch (IntegrationException e) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e.getMessage()));
			}
			catch (PlexException e) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e.getMessage()));
			}
		}

		
//		Sort sort;
//
//		// sort
//		if (sortField != null) {
//
//			if (sortOrder.equals(SortOrder.DESCENDING)) {
//				sort = SortFactoryUtil.getSort(UsuarioTO.class, sortField, "desc");
//			}
//			else {
//				sort = SortFactoryUtil.getSort(UsuarioTO.class, sortField, "asc");
//			}
//		}
//		else {
//			sort = SortFactoryUtil.getSort(UsuarioTO.class, DEFAULT_SORT_CRITERIA, "asc");
//		}
//
//		try {
//			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
//			int liferayOneRelativeFinishRow = first + pageSize + 1;
//
//			boolean andSearch = true;
//			int status = WorkflowConstants.STATUS_ANY;
//
//			String firstName = trimExpresssion((String) filters.get("nombre"));
//			String middleName = trimExpresssion((String) filters.get("middleName"));
//			String lastName = trimExpresssion((String) filters.get("apellidos"));
//			String screenName = trimExpresssion((String) filters.get("screenName"));
//			String emailAddress = trimExpresssion((String) filters.get("email"));
//
//			// For the sake of speed, search for users in the index rather than
//			// querying the database directly.
//			Hits hits = UserLocalServiceUtil.search(companyId, firstName, middleName, lastName, screenName,
//					emailAddress, status, params, andSearch, first, liferayOneRelativeFinishRow, sort);
//
//			List<Document> documentHits = hits.toList();
//
//			logger.debug(
//				("filters firstName=[{0}] middleName=[{1}] lastName=[{2}] screenName=[{3}] emailAddress=[{4}] active=[{5}] andSearch=[{6}] startRow=[{7}] liferayOneRelativeFinishRow=[{8}] sortColumn=[{9}] reverseOrder=[{10}] hitCount=[{11}]"),
//				firstName, middleName, lastName, screenName, emailAddress, status, andSearch, first,
//				liferayOneRelativeFinishRow, sortField, sort.isReverse(), documentHits.size());
//
//			// Convert the results from the search index into a list of user
//			// objects.
//			users = new ArrayList<UsuarioTO>(documentHits.size());
//
//			for (Document document : documentHits) {
//
//				long userId = GetterUtil.getLong(document.get(Field.USER_ID));
//
//				//UsuarioTO user = UserLocalServiceUtil.getUserById(userId);
//				UsuarioTO user = usuarioTOAction.findByUserCode(Long.toString(userId));
//				users.add(user);
//			}
//
//		}
//		catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}

		return users;

	}

	protected String trimExpresssion(String value) {

		String expression = null;

		if (value != null) {
			String trimmedValue = value.trim();

			if (trimmedValue.length() > 0) {
				expression = trimmedValue.toLowerCase();
			}
		}

		return expression;
	}

	@Override
	public UsuarioTO getRowData(String rowKey) {
		UsuarioTO user = null;

		try {
			//user = UserLocalServiceUtil.getUserById(Long.parseLong(rowKey));
			user = usuarioTOAction.findByUserCode(rowKey);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return user;
	}

	@Override
	public Object getRowKey(UsuarioTO user) {
		return user.getCodigo();
	}
}