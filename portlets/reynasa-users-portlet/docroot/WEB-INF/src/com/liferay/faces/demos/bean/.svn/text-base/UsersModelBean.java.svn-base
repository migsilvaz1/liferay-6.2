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
package com.liferay.faces.demos.bean;

import com.liferay.faces.demos.list.UserLazyDataModel;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.model.UploadedFile;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.near.reynasa.impl.action.CentroTOActionImpl;
import com.near.reynasa.impl.action.ClienteTOActionImpl;
import com.near.reynasa.impl.action.DistribuidorTOActionImpl;
import com.near.reynasa.impl.action.EmpleadoTOActionImpl;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.impl.action.UtilActionImpl;
import com.near.reynasa.interfaces.TO.CentroTO;
import com.near.reynasa.interfaces.TO.ClienteTO;
import com.near.reynasa.interfaces.TO.DistribuidorTO;
import com.near.reynasa.interfaces.TO.UsuarioTO;
import com.near.reynasa.interfaces.action.CentroTOAction;
import com.near.reynasa.interfaces.action.ClienteTOAction;
import com.near.reynasa.interfaces.action.DistribuidorTOAction;
import com.near.reynasa.interfaces.action.EmpleadoTOAction;
import com.near.reynasa.interfaces.action.UsuarioTOAction;
import com.near.reynasa.interfaces.action.UtilAction;
import com.near.reynasa.utils.IntegrationException;
import com.near.reynasa.utils.PlexException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


/**
 * This class serves as a model bean for the users.xhtml Facelet view. The bean is kept in view scope since the model
 * data needs to be maintained as long as the end-user is interacting with the view.
 *
 * @author  Neil Griffin
 * @author  Kyle Stiemann
 */
@ManagedBean(name = "usersModelBean")
@SessionScoped
public class UsersModelBean implements Serializable {

	// serialVersionUID Note: This class implements Serializable only to avoid extraneous stacktraces from being thrown
	// by Mojarra. All of the private data members are marked as transient, because it's not possible to de-serialize
	// instances of Liferay's User class due to classloader prolems.
	private static final long serialVersionUID = 5267378433060095710L;

	// Private Data Members
	private transient UserLazyDataModel userDataModel;
	
	/**
	 * Gets the value of the attribute {@link #userDataModel}.
	 * @return the value of the attribute {@link #userDataModel}.
	 */
	public UserLazyDataModel getUserDataModel() {
	
		return userDataModel;
	}

	
	/**
	 * Sets the value of the attribute {@link #userDataModel}.
	 * @param userDataModel The value for the attribute {@link #userDataModel}.
	 */
	public void setUserDataModel(UserLazyDataModel userDataModel) {
	
		this.userDataModel = userDataModel;
	}

	private transient UsuarioTO selectedUser;
	private transient String distrCod;
	private transient UsuarioTO searchUser;
	private transient List<UsuarioTO> userList;
	private transient List<SelectItem> statusSelectItems;
	private transient UploadedFile uploadedFile;
	//finder attributes
	private transient String userCode;
	private transient String role;
	private transient String activo;
	private transient String activoLogico;
	private transient Map<String,String> roleList;
	private transient Map<String,String> roleListEdit;
	private transient String center;
	private transient Map<String,String> centerList;
	private transient String employee;
	private transient Map<String,String> employeeList;
	private transient String client;
	private transient Map<String,String> clientList;
	private transient Map<String,String> clientListEdit;
	private transient boolean isDisableDistribuidor;
	private transient boolean isDisableClient;

	private transient String distributor;
	private transient Map<String,String> distributorList;
	private transient String delegacion;
	private transient Map<String,String> delegacionList;
	private transient String centro;
	private transient Map<String,String> centroList;
	private transient String empleado;
	private transient Map<String,String> empleadoList;


	private transient String password;
	private transient String name;
	private transient String surname;
	private transient boolean editable;
	private transient boolean editableEmpleado;
	private transient boolean editableCliente;
	private transient boolean editableDelegacion;
	private transient boolean editableCentro;
	
	//private transient String selectedUserPortraitURL;
	private static UsuarioTOAction usuarioTOAction=new UsuarioTOActionImpl();
	private static UtilAction utilAction=new UtilActionImpl();
	private static DistribuidorTOAction distributorTOAction=new DistribuidorTOActionImpl();
	private static ClienteTOAction clienteTOAction=new ClienteTOActionImpl();
	private static EmpleadoTOAction empleadoTOAction=new EmpleadoTOActionImpl();
	private static CentroTOAction centroTOAction=new CentroTOActionImpl();

	private UsuarioTO usuarioTO = null;
	public void forceListReload() {

		selectedUser = null;
		searchUser=null;
		//selectedUserPortraitURL = null;
		userDataModel = null;
		uploadedFile = null;
	}

	public UserLazyDataModel getDataModel() {

		if (userDataModel == null) {
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			int rowsPerPage = liferayFacesContext.getPortletPreferenceAsInt("rowsPerPage",
				SearchContainer.DEFAULT_DELTA);
			userDataModel = new UserLazyDataModel(liferayFacesContext.getCompanyId(), rowsPerPage);
		}

		return userDataModel;
	}

	public String getDistrCod(){
		if(selectedUser.getDistrCod() != null && selectedUser.getDistrCod() != ""){
			Long distrCodL = Long.parseLong(selectedUser.getDistrCod());
			distrCod = distrCodL.toString();
		}else{
			distrCod = "";
		}
		if(usuarioTO.getRolCod().equals("3") || usuarioTO.getRolCod().equals("4") || usuarioTO.getRolCod().equals("5") || usuarioTO.getRolCod().equals("6")){
			Long distrCodL = Long.parseLong(usuarioTO.getDistrCod());
			distrCod = distrCodL.toString();
		}
		return distrCod;	
	}
	
	public void setDistrCod(String cod){
		distrCod = cod;
		selectedUser.setDistrCod(distrCod);
	}
	
	public UsuarioTO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UsuarioTO selectedUser) {
		this.selectedUser = selectedUser;
	}

	public boolean getIsDisableDistribuidor(){
		ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
		User user =themeDisplay.getUser();
		try {
			if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidorPersonal"), user.getUserId(), false) ||
							UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false) ||
							UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
				
				Long disLong = Long.parseLong(usuarioTO.getDistrCod());
				distributor = disLong.toString();
				return true;
			}
		}
		catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getIsDisableClient(){
		ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
		User user =themeDisplay.getUser();
		try {
			if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false) ||
							UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
				return true;
			}
		}
		catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getIsDisableCenter(){
		ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
		User user =themeDisplay.getUser();
		try {
			if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
				return true;
			}
		}
		catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<SelectItem> getStatusSelectItems() {

		if (statusSelectItems == null) {
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			statusSelectItems = new ArrayList<SelectItem>();
			statusSelectItems.add(new SelectItem(WorkflowConstants.STATUS_ANY,
				liferayFacesContext.getMessage("any-status")));
			statusSelectItems.add(new SelectItem(WorkflowConstants.STATUS_APPROVED,
				liferayFacesContext.getMessage("active")));
			statusSelectItems.add(new SelectItem(WorkflowConstants.STATUS_INACTIVE,
				liferayFacesContext.getMessage("inactive")));
		}

		return statusSelectItems;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public UsuarioTO getSearchUser() {
		return searchUser;
	}

	public void setSearchUser(UsuarioTO searchUser) {
		this.searchUser = searchUser;
	}

	public List<UsuarioTO> getUserList() {
		
		if (userList==null) {
			try {
				userList = usuarioTOAction.findAllUsers(null, true);
			}
			catch (IntegrationException | PlexException e1) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e1.getMessage()));	
			}
			Iterator<UsuarioTO> itUsuario=userList.iterator();
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			User user =themeDisplay.getUser();
			try {
				if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidorPersonal"), user.getUserId(), false)){
					while(itUsuario.hasNext()){
						UsuarioTO usuarioAux=itUsuario.next();
						if(usuarioAux.getRolCod()!=null &&("1".equals(usuarioAux.getRolCod())||"2".equals(usuarioAux.getRolCod())||"7".equals(usuarioAux.getRolCod())) ){
							itUsuario.remove();
						}
					}
				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false)){
					while(itUsuario.hasNext()){
						UsuarioTO usuarioAux=itUsuario.next();
						if(usuarioAux.getRolCod()!=null &&("1".equals(usuarioAux.getRolCod())||"2".equals(usuarioAux.getRolCod())||"3".equals(usuarioAux.getRolCod())||"6".equals(usuarioAux.getRolCod())||"7".equals(usuarioAux.getRolCod())) ){
							itUsuario.remove();
						}
					}
				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
					while(itUsuario.hasNext()){
						UsuarioTO usuarioAux=itUsuario.next();
						if(usuarioAux.getRolCod()!=null &&("1".equals(usuarioAux.getRolCod())||"2".equals(usuarioAux.getRolCod())||"3".equals(usuarioAux.getRolCod())||"4".equals(usuarioAux.getRolCod())||"6".equals(usuarioAux.getRolCod())||"7".equals(usuarioAux.getRolCod())) ){
							itUsuario.remove();
						}
					}
				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.empleado"), user.getUserId(), false)){
					while(itUsuario.hasNext()){
						UsuarioTO usuarioAux=itUsuario.next();
						if(usuarioAux.getRolCod()!=null &&("1".equals(usuarioAux.getRolCod())||"2".equals(usuarioAux.getRolCod())||"3".equals(usuarioAux.getRolCod())||"4".equals(usuarioAux.getRolCod())||"5".equals(usuarioAux.getRolCod())||"7".equals(usuarioAux.getRolCod())) ){
							itUsuario.remove();
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return userList;
	}

	public void setUserList(List<UsuarioTO> userList) {
		this.userList = userList;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode.toLowerCase();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public Map<String, String> getRoleList() {

		if(roleList==null || (roleList!=null && roleList.isEmpty())){
			roleList= new HashMap<String, String>();
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			User user =themeDisplay.getUser();
			try {
				if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administrator"), user.getUserId(), false)){
					roleList.put("3", PropsUtil.get("rol.administradorDistribuidor"));
					roleList.put("4", PropsUtil.get("rol.cliente"));
					roleList.put("5", PropsUtil.get("rol.centro"));
					roleList.put("6", PropsUtil.get("rol.empleado"));
					roleList.put("7", PropsUtil.get("rol.proveedor"));
					roleList.put("2", PropsUtil.get("rol.administradorFuncional"));
					roleList.put("1", PropsUtil.get("rol.administrator"));
				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorFuncional"), user.getUserId(), false)){
					roleList.put("3", PropsUtil.get("rol.administradorDistribuidor"));
					roleList.put("4", PropsUtil.get("rol.cliente"));
					roleList.put("5", PropsUtil.get("rol.centro"));
					roleList.put("6", PropsUtil.get("rol.empleado"));
					roleList.put("7", PropsUtil.get("rol.proveedor"));
					roleList.put("2", PropsUtil.get("rol.administradorFuncional"));
					roleList.put("1", PropsUtil.get("rol.administrator"));
				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidorPersonal"), user.getUserId(), false)){
					roleList.put("3", PropsUtil.get("rol.administradorDistribuidor"));
					roleList.put("4", PropsUtil.get("rol.cliente"));
					roleList.put("5", PropsUtil.get("rol.centro"));
					roleList.put("6", PropsUtil.get("rol.empleado"));
				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false)){
					roleList.put("4", PropsUtil.get("rol.cliente"));
					roleList.put("5", PropsUtil.get("rol.centro"));
				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
					roleList.put("5", PropsUtil.get("rol.centro"));
				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.empleado"), user.getUserId(), false)){
					roleList.put("6", PropsUtil.get("rol.empleado"));
				}
			} catch (PortalException | SystemException e) {
				e.printStackTrace();
			}
		}
		return roleList;
	}

	public void setRoleList(Map<String, String> roleList) {
		this.roleList = roleList;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public Map<String, String> getCenterList() {
		ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
		User user =themeDisplay.getUser();
		try {
			if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false) || 
							UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.empleado"), user.getUserId(), false)){
				if(usuarioTO!=null&& usuarioTO.getDistrCod()!=null){
					CentroTO cen=centroTOAction.getCentroByCodigoCentro(Long.parseLong(usuarioTO.getDistrCod()) ,usuarioTO.getCentroCod());
					centerList= new HashMap<String, String>();
					centerList.put(cen.getCodigo().toString(), cen.getDenominacion());
					center=cen.getCodigo().toString();
				}
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return centerList;
	}

	public void setCenterList(Map<String, String> centerList) {
		this.centerList = centerList;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public Map<String, String> getEmployeeList() {
		if(employeeList==null){
			//List<EmpleadoTO> listAux=empleadoTOAction.getAll(true);
			employeeList= new HashMap<String, String>();
			//			for(ClienteTO dis:listAux){
			//				clientList.put(dis.getCodigo().toString(), dis.getDenominacion());
			//			}

		}
		return employeeList;
	}

	public void setEmployeeList(Map<String, String> employeeList) {
		this.employeeList = employeeList;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Map<String, String> getClientList() {
		if(distributor != null){
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			User user =themeDisplay.getUser();

			try{
				if((UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false) || 
								UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false) || 
								UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.empleado"), user.getUserId(), false))){
					if(usuarioTO!=null&& distributor!=null){
						ClienteTO cli=clienteTOAction.findClienteById(Long.parseLong(distributor) ,usuarioTO.getClienteCod(), true);
						clientList= new HashMap<String, String>();
						clientList.put(cli.getCodigo().toString(), cli.getNombre());
						client=cli.getCodigo().toString();
					}
					onClientChange();
				}else{
					clientList=utilAction.getAllClientes(Long.parseLong(distributor));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			} 


		}
		return clientList;
	}

	public void setClientList(Map<String, String> clientList) {
		this.clientList = clientList;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public Map<String, String> getDistributorList() {
		if (distributorList == null) {
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext
					.getCurrentInstance().getExternalContext().getRequestMap()
					.get(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			try {
				usuarioTO = usuarioTOAction
						.findByUserCode(user.getScreenName());
			} catch (IntegrationException | PlexException e1) {
				FacesContext.getCurrentInstance().addMessage("global",
						new FacesMessage(e1.getMessage()));
			}
			try {
				if ((UserLocalServiceUtil.hasRoleUser(
						themeDisplay.getCompanyId(),
						PropsUtil.get("rol.cliente"), user.getUserId(), false)
						|| UserLocalServiceUtil.hasRoleUser(
								themeDisplay.getCompanyId(),
								PropsUtil.get("rol.centro"), user.getUserId(),
								false)
						|| UserLocalServiceUtil.hasRoleUser(
								themeDisplay.getCompanyId(),
								PropsUtil.get("rol.empleado"),
								user.getUserId(), false) || UserLocalServiceUtil
							.hasRoleUser(
									themeDisplay.getCompanyId(),
									PropsUtil
											.get("rol.administradorDistribuidorPersonal"),
									user.getUserId(), false))) {
					if (usuarioTO != null && usuarioTO.getDistrCod() != null) {
						DistribuidorTO dis = distributorTOAction
								.findDistribuidorById(
										Long.parseLong(usuarioTO.getDistrCod()),
										true);
						distributorList = new HashMap<String, String>();
						String code = dis.getCodigo().toString();
//						while(code.length()<3){
//							code = "0" + code;
//						}
						distributorList.put(code, dis.getDenominacion());
					}
					onDistributorChange();
					getIsDisableDistribuidor();
				} else {
					List<DistribuidorTO> listAux = distributorTOAction
							.getAll(true);
					distributorList = new HashMap<String, String>();
					for (DistribuidorTO dis : listAux) {
						String code = dis.getCodigo().toString();
//						while(code.length()<3){
//							code = "0" + code;
//						}
						distributorList.put(code, dis.getDenominacion());
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		return distributorList;
	}

	public void setDistributorList(Map<String, String> distributorList) {
		this.distributorList = distributorList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void onDistributorChange() {
		if(distributor != null && distributor != ""){
			clientList=utilAction.getAllClientes(Long.parseLong(distributor));
			centerList=utilAction.getAllCentros(Long.parseLong(distributor));
		}else{
			clientList = null;
			centerList = null;
		}
	}

	public void onClientChange() {
		if(distributor != null && client != null){
			centerList=centroTOAction.getAllCentros(Long.parseLong(distributor), client);
		}else{
			centerList = null;
		}
	}

	public void onRoleChange() {
		
		selectedUser.setDistrCod(null);
		selectedUser.setCentroCod(null);
		selectedUser.setClienteCod(null);
		selectedUser.setDelegCod(null);
		selectedUser.setEmpleadoCod(null);
		
		if(selectedUser.getRolCod()!=null){
			if("3".equals(selectedUser.getRolCod())){
				try {
					List<DistribuidorTO> distList = distributorTOAction.getAll(true);
					distributorList= new HashMap<String, String>();
					for(DistribuidorTO d: distList){
						distributorList.put(d.getCodigo().toString(), d.getDenominacion());
					}
					if(usuarioTO.getRolCod().equals("2")){
						setDistrCod("");
					}else{
						setDistrCod(usuarioTO.getDistrCod());
					}
				} catch (PlexException e) {
					e.printStackTrace();
				}
			}else if("1".equals(selectedUser.getRolCod()) || "2".equals(selectedUser.getRolCod()) || "7".equals(selectedUser.getRolCod())){
				DistribuidorTO dist;
				try {
					dist = distributorTOAction.findDistribuidorById(0l, null);
				
					selectedUser.setDistrCod("0");
					selectedUser.setDistrDen(dist.getDenominacion());
					distributorList= new HashMap<String, String>();
					distributorList.put("0", dist.getDenominacion());
				}
				catch (IntegrationException | PlexException e) {
					e.printStackTrace();
				}
				
			}else if("4".equals(selectedUser.getRolCod()) || "5".equals(selectedUser.getRolCod()) || "6".equals(selectedUser.getRolCod())){
				
				try {
					DistribuidorTO dis = distributorTOAction.findDistribuidorById(Long.parseLong(usuarioTO.getDistrCod()), null);
					
					distributorList= new HashMap<String, String>();
				
					distributorList.put(dis.getCodigo().toString(), dis.getDenominacion());
				
					setDistrCod(dis.getCodigo().toString());
				}
				catch (PlexException e) {
					e.printStackTrace();
				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				catch (IntegrationException e) {
					e.printStackTrace();
				}
			}
//			Actualization of other related data
			if("4".equals(selectedUser.getRolCod())){
				clientList=utilAction.getAllClientes(Long.parseLong(selectedUser.getDistrCod()));
				String clienteCod = usuarioTO.getClienteCod();
				selectedUser.setClienteCod(clienteCod);
			}else if("5".equals(selectedUser.getRolCod())){
				clientList=utilAction.getAllClientes(Long.parseLong(selectedUser.getDistrCod()));
				centerList=centroTOAction.getAllCentros(Long.parseLong(selectedUser.getDistrCod()), selectedUser.getClienteCod());
				delegacionList=utilAction.findAllDelegaciones(Long.parseLong(selectedUser.getDistrCod()));
				if(usuarioTO.getRolCod().equals("4") || usuarioTO.getRolCod().equals("5")){
					String clienteCod = usuarioTO.getClienteCod();
					String centroCod = usuarioTO.getCentroCod();
					selectedUser.setClienteCod(clienteCod);
					selectedUser.setCentroCod(centroCod);
				}
			}else if("6".equals(selectedUser.getRolCod())){
				delegacionList=utilAction.findAllDelegaciones(Long.parseLong(selectedUser.getDistrCod()));
				empleadoList=utilAction.findAllEmpleados(Long.parseLong(selectedUser.getDistrCod()));
			}
		}
	}
	
	/**
	 * Gets the value of the attribute {@link #editableEmpleado}.
	 * @return the value of the attribute {@link #editableEmpleado}.
	 */
	public boolean isEditableEmpleado() {
		if(selectedUser.getRolCod()!=null && "6".equals(selectedUser.getRolCod())){
			editableEmpleado = true;
		}else{
			editableEmpleado = false;
		}
		return editableEmpleado;
	}


	
	/**
	 * Sets the value of the attribute {@link #editableEmpleado}.
	 * @param editableEmpleado The value for the attribute {@link #editableEmpleado}.
	 */
	public void setEditableEmpleado(boolean editableEmpleado) {
	
		this.editableEmpleado = editableEmpleado;
	}

	public boolean isEditable(){
		
		if(selectedUser.getRolCod()!=null && ("3".equals(selectedUser.getRolCod()) || "4".equals(selectedUser.getRolCod()) || "5".equals(selectedUser.getRolCod()) || "6".equals(selectedUser.getRolCod()))){
			editable = true;
		}else{
			editable = false;
		}
		return editable;
	}
	
	public boolean isEditableCliente() {
		if(selectedUser.getRolCod()!=null && ("4".equals(selectedUser.getRolCod()) || "5".equals(selectedUser.getRolCod()) )){
			editableCliente = true;
		}else{
			editableCliente = false;
		}
		return editableCliente;
	}
	
	public void setEditableCliente(boolean editableCliente) {
		
		this.editableCliente = editableCliente;
	}
	
	public boolean isEditableDelegacion() {
		if(selectedUser.getRolCod()!=null && ("5".equals(selectedUser.getRolCod()) || "6".equals(selectedUser.getRolCod()) )){
			editableDelegacion = true;
		}else{
			editableDelegacion = false;
		}
		return editableDelegacion;
	}
	
	public void setEditableDelegacion(boolean editableDelegacion) {
		
		this.editableDelegacion = editableDelegacion;
	}
	
	public boolean isEditableCentro() {
		if(selectedUser.getRolCod()!=null && ("5".equals(selectedUser.getRolCod()))){
			editableCentro = true;
		}else{
			editableCentro = false;
		}
		return editableCentro;
	}
	
	public void setEditableCentro(boolean editableCentro) {
		
		this.editableCentro = editableCentro;
	}
	
	public void onDistributorEditChange() {
		if(selectedUser.getDistrCod() != "" && selectedUser.getDistrCod() != null){
			try {
				selectedUser.setDistrDen(distributorTOAction.findDistribuidorById(Long.parseLong(selectedUser.getDistrCod()), null).getDenominacion());
			}
			catch (NumberFormatException | IntegrationException | PlexException e) {
				e.printStackTrace();
			}
		}
		if(selectedUser.getRolCod()!=null){
			if("4".equals(selectedUser.getRolCod())){
				clientList=utilAction.getAllClientes(Long.parseLong(selectedUser.getDistrCod()));
			}else if("5".equals(selectedUser.getRolCod())){
				clientList=utilAction.getAllClientes(Long.parseLong(selectedUser.getDistrCod()));
				centerList=centroTOAction.getAllCentros(Long.parseLong(selectedUser.getDistrCod()), selectedUser.getClienteCod());
				delegacionList=utilAction.findAllDelegaciones(Long.parseLong(selectedUser.getDistrCod()));
			}else if("6".equals(selectedUser.getRolCod())){
				delegacionList=utilAction.findAllDelegaciones(Long.parseLong(selectedUser.getDistrCod()));
				empleadoList=utilAction.findAllEmpleados(Long.parseLong(selectedUser.getDistrCod()));
			}

		}

	}


	public Map<String, String> getClientListEdit() {
		if(selectedUser!=null && selectedUser.getDistrCod()!=null && selectedUser.getDistrCod()!=""){
			clientListEdit=utilAction.getAllClientes(Long.parseLong(selectedUser.getDistrCod()));
		}else{
			clientListEdit=null;
		}

		return clientListEdit;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public Map<String, String> getDelegacionList() {
		if(selectedUser!=null && selectedUser.getDistrCod()!=null && selectedUser.getDistrCod()!=""){
			delegacionList=utilAction.findAllDelegaciones(Long.parseLong(selectedUser.getDistrCod()));
		}else{
			delegacionList=null;
		}

		return delegacionList;
	}

	public void setDelegacionList(Map<String, String> delegacionList) {
		this.delegacionList = delegacionList;
	}

	public void setClientListEdit(Map<String, String> clientListEdit) {
		this.clientListEdit = clientListEdit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getRoleListEdit() {
		if(roleListEdit==null || (roleListEdit!=null && roleListEdit.isEmpty())){
			//List<EmpleadoTO> listAux=empleadoTOAction.getAll(true);

			roleListEdit= new HashMap<String, String>();
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			User user =themeDisplay.getUser();
			try {
				if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administrator"), user.getUserId(), false)){
					roleListEdit.put("2", PropsUtil.get("rol.administradorFuncional"));
					roleListEdit.put("1", PropsUtil.get("rol.administrator"));

				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorFuncional"), user.getUserId(), false)){
					roleListEdit.put("3", PropsUtil.get("rol.administradorDistribuidorPersonal"));
					roleListEdit.put("7", PropsUtil.get("rol.proveedor"));
					roleListEdit.put("2", PropsUtil.get("rol.administradorFuncional"));

				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidorPersonal"), user.getUserId(), false)){
					roleListEdit.put("3", PropsUtil.get("rol.administradorDistribuidorPersonal"));
					roleListEdit.put("4", PropsUtil.get("rol.cliente"));
					roleListEdit.put("5", PropsUtil.get("rol.centro"));
					roleListEdit.put("6", PropsUtil.get("rol.empleado"));

				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false)){
					roleListEdit.put("4", PropsUtil.get("rol.cliente"));
					roleListEdit.put("5", PropsUtil.get("rol.centro"));


				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){


					roleListEdit.put("5", PropsUtil.get("rol.centro"));


				}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.empleado"), user.getUserId(), false)){


					roleListEdit.put("6", PropsUtil.get("rol.empleado"));


				}



			} catch (PortalException | SystemException e) {
				e.printStackTrace();
			}

		}
		return roleListEdit;
	}

	public void setRoleListEdit(Map<String, String> roleListEdit) {
		this.roleListEdit = roleListEdit;
	}


	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public Map<String, String> getCentroList() {

		if(selectedUser!=null && selectedUser.getDistrCod()!=null && selectedUser.getDistrCod()!=""){
			centroList=utilAction.getAllCentros(Long.parseLong(selectedUser.getDistrCod()));
		}else{
			centroList=null;
		}

		return centroList;
	}

	public void setCentroList(Map<String, String> centroList) {
		this.centroList = centroList;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public Map<String, String> getEmpleadoList() {

		return empleadoList;
	}

	public void setEmpleadoList(Map<String, String> empleadoList) {
		this.empleadoList = empleadoList;
	}
	
	public String getActivo(){
		return activo;
	}
	
	public void setActivo(String activo){
		this.activo = activo;
	}
	public String getActivoLogico(){
		return activoLogico;
	}
	
	public void setActivoLogico(String activo){
		this.activoLogico = activo;
	}

}