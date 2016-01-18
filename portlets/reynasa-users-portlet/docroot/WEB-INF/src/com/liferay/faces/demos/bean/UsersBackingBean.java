package com.liferay.faces.demos.bean;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.trash.DuplicateEntryException;
import com.liferay.util.Encryptor;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.interfaces.TO.UsuarioTO;
import com.near.reynasa.interfaces.action.UsuarioTOAction;
import com.near.reynasa.utils.IntegrationException;
import com.near.reynasa.utils.PlexException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


@ManagedBean(name = "usersBackingBean")
@RequestScoped
public class UsersBackingBean {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(UsersBackingBean.class);

	// Injections
	@ManagedProperty(name = "usersModelBean", value = "#{usersModelBean}")
	private UsersModelBean usersModelBean;

	@ManagedProperty(name = "usersViewBean", value = "#{usersViewBean}")
	private UsersViewBean usersViewBean;


	private static UsuarioTOAction usuarioTOAction=new UsuarioTOActionImpl();

	public void cancel(ActionEvent actionEvent) {
		usersViewBean.setFormRendered(false);
		usersViewBean.setViewMode(false);
		usersViewBean.setFindMode(true);
		RequestContext context = RequestContext.getCurrentInstance();
		context.reset("f1:rol");
		context.reset("f1:codigoCentro");
		context.reset("f1:email");
		context.reset("f1:nombre");
		context.reset("f1:distribuidorEdicion");
		context.reset("f1:codigoDelegacion");
		context.reset("f1:cif");
		context.reset("f1:apellidos");
		context.reset("f1:codigoCliente");
		context.reset("f1:codigoEmpleado");
		context.reset("f1:button");
		context.reset("f1:direccion");
		context.reset("f1:municipio");
		context.reset("f1:telefonoMovil");
		context.reset("f1:codigoPostal");
		context.reset("f1:provincia");
		context.reset("f1:telefonoFijo");
		context.reset("f1:canjearCheckbox");
		context.reset("f1:administrarCheckbox");
		context.reset("f1:suplantarCheckbox");
		context.reset("f1:activoCheckbox");
	}

	@SuppressWarnings("static-access")
	public void save(ActionEvent actionEvent) {
		UsuarioTO usuarioTO2 = null;
		try {
			boolean actualizaPlex = false;
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			// Update the selected user in the Liferay database.
			User user2 = themeDisplay.getUser();
			UsuarioTO usuarioTO = usersModelBean.getSelectedUser();
			usuarioTO.setAuditUsuarioUltAccion(themeDisplay.getRealUser().getFullName());
			Calendar calendar = GregorianCalendar.getInstance();
			usuarioTO.setAuditFechaUltAccion(String.valueOf(calendar.YEAR)+String.valueOf(calendar.MONTH)+String.valueOf(calendar.DAY_OF_MONTH));
			usuarioTO.setUsuarioSuplantacion(user2.getScreenName());
			usuarioTO2 = usuarioTOAction.findByUserCode(usuarioTO.getCodigo());
			usuarioTO2.setAuditFechaUltAccion(String.valueOf(calendar.YEAR)+String.valueOf(calendar.MONTH)+String.valueOf(calendar.DAY_OF_MONTH));
			usuarioTO2.setUsuarioSuplantacion(user2.getScreenName());
			usuarioTO2.setAuditUsuarioUltAccion(themeDisplay.getRealUser().getFullName());
			actualizaPlex = usuarioTOAction.updateUser(usuarioTO);			

			User user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), usuarioTO.getCodigo());
			long companyId = PortalUtil.getDefaultCompanyId();
			String rol = getRol(usuarioTO.getRolCod());
			Role role = RoleLocalServiceUtil.getRole(companyId, rol);
			RoleLocalServiceUtil.addUserRole(user.getUserId(), role.getRoleId());
			user.setEmailAddress(usuarioTO.getEmail());
			user.setFirstName(usuarioTO.getNombre());
			user.setLastName(usuarioTO.getApellidos());

			String password = usersModelBean.getPassword();
			if(!Validator.isBlank(password)){
				user.setPassword(password);
				user.setPasswordModified(true);
				user.setPasswordModifiedDate(new Date());
			}
			boolean userbyemail_exists = true;
			
			try {
				UserLocalServiceUtil.getUserByEmailAddress(companyId, user.getEmailAddress());
			} catch (NoSuchUserException nsue) {
				userbyemail_exists = false;
			}

			if((!userbyemail_exists) && (actualizaPlex))
			{
			UserLocalServiceUtil.updateUser(user);
			}else{
				try {
					usuarioTOAction.updateUser(usuarioTO2);
				}
				catch (IntegrationException e1) {
					LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
					liferayFacesContext.addGlobalUnexpectedErrorMessage();
				}
				catch (PlexException e1) {
					LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
					liferayFacesContext.addGlobalUnexpectedErrorMessage();
				}
			}
			

			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalSuccessInfoMessage();
		}catch(SystemException e){
			logger.error(e.getMessage(), e);
			try {
				usuarioTOAction.updateUser(usuarioTO2);
			}
			catch (IntegrationException e1) {
				logger.error(e1.getMessage(), e1);
				LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
				liferayFacesContext.addGlobalUnexpectedErrorMessage();
			}
			catch (PlexException e1) {
				logger.error(e1.getMessage(), e1);
				LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
				liferayFacesContext.addGlobalUnexpectedErrorMessage();
			}
		}catch (PortalException e) {
			logger.error(e.getMessage(), e);
			try {
				usuarioTOAction.updateUser(usuarioTO2);
			}
			catch (IntegrationException e1) {
				logger.error(e1.getMessage(), e1);
				LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
				liferayFacesContext.addGlobalUnexpectedErrorMessage();
			}
			catch (PlexException e1) {
				logger.error(e1.getMessage(), e1);
				LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
				liferayFacesContext.addGlobalUnexpectedErrorMessage();
			}
		}catch (IntegrationException e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		} catch (PlexException e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
		usersViewBean.setFormRendered(false);
		usersViewBean.setFindMode(true);
		usersViewBean.setViewMode(false);
		usersModelBean.forceListReload();
	}

	private String getRol(String rol) {
		String res = "";
		if("1".equals(rol)){
			res=PropsUtil.get("rol.administrator");
		}else if("2".equals(rol)){
			res=PropsUtil.get("rol.administradorFuncional");
		}else if("3".equals(rol)){
			res=PropsUtil.get("rol.administradorDistribuidorPersonal");
		}else if("4".equals(rol)){
			res=PropsUtil.get("rol.cliente");
		}else if("5".equals(rol)){
			res=PropsUtil.get("rol.centro");
		}else if("6".equals(rol)){
			res=PropsUtil.get("rol.empleado");
		}else if("7".equals(rol)){
			res=PropsUtil.get("rol.proveedor");
		}
		return res;
	}

	@SuppressWarnings("deprecation")
	public void removeUser(ActionEvent actionEvent) {
		UsuarioTO usuarioTO = usersModelBean.getSelectedUser();
		List<UsuarioTO> userListSearch=null;
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			// Update the selected user in the Liferay database.
			User user2 = themeDisplay.getUser();

			usuarioTO.setAuditUsuarioUltAccion(themeDisplay.getRealUser().getFullName());
			Calendar calendar = GregorianCalendar.getInstance();
			usuarioTO.setAuditFechaUltAccion(calendar.getTime().toString());
			usuarioTO.setUsuarioSuplantacion(user2.getScreenName());
			usuarioTOAction.removeUser(usuarioTO.getCodigo(), themeDisplay.getRealUser().getFullName());
			User user=UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), usersModelBean.getSelectedUser().getCodigo());
			UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_INACTIVE);

		}catch(SystemException e){
			try {
				usuarioTOAction.createUser(usuarioTO);
			}
			catch (IntegrationException e1) {
				logger.error(e1.getMessage(), e1);
				LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
				liferayFacesContext.addGlobalUnexpectedErrorMessage();
			}
			catch (PlexException e1) {
				logger.error(e1.getMessage(), e1);
				LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
				liferayFacesContext.addGlobalUnexpectedErrorMessage();
			}
		}catch (PortalException e) {
			try {
				usuarioTOAction.createUser(usuarioTO);
			}
			catch (IntegrationException e1) {
				logger.error(e1.getMessage(), e1);
				LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
				liferayFacesContext.addGlobalUnexpectedErrorMessage();
			}
			catch (PlexException e1) {
				logger.error(e1.getMessage(), e1);
				LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
				liferayFacesContext.addGlobalUnexpectedErrorMessage();
			}
		}catch (IntegrationException e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		} catch (PlexException e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
		usersModelBean.setUserList(userListSearch);
		usersViewBean.setFormRendered(false);
		usersViewBean.setFindMode(true);
		usersViewBean.setViewMode(false);
		usersModelBean.forceListReload();
	}

	public void selectUser(SelectEvent selectEvent) {
		try {
			UsuarioTO selectedUser = (UsuarioTO) selectEvent.getObject();
			usersModelBean.setSelectedUser(selectedUser);
			usersViewBean.setViewMode(true);
			usersViewBean.setFindMode(false);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalUnexpectedErrorMessage();
		}
	}

	public void editUser(SelectEvent selectEvent) {
		try {
			UsuarioTO selectedUser = (UsuarioTO) selectEvent.getObject();
			usersModelBean.setSelectedUser(selectedUser);
			usersViewBean.setFormRendered(true);
			usersViewBean.setFindMode(false);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalUnexpectedErrorMessage();
		}
	}

	public void setUsersModelBean(UsersModelBean usersModelBean) {
		// Injected via ManagedProperty annotation
		this.usersModelBean = usersModelBean;
	}

	public void setUsersViewBean(UsersViewBean usersViewBean) {
		// Injected via ManagedProperty annotation
		this.usersViewBean = usersViewBean;
	}


	public void seekUsers(){
		UsuarioTO selectedUser = usersModelBean.getSearchUser();
		List<UsuarioTO> userListSearch=null;
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
		if((usersModelBean.getUserCode()!=null&&!"".equals(usersModelBean.getUserCode()))||
						(usersModelBean.getName()!=null&&!"".equals(usersModelBean.getName()))||
						(usersModelBean.getSurname()!=null&&!"".equals(usersModelBean.getSurname()))||
						(usersModelBean.getClient()!=null&&!"".equals(usersModelBean.getClient()))||
						(usersModelBean.getCenter()!=null&&!"".equals(usersModelBean.getCenter()))||
						(usersModelBean.getDistributor()!=null&&!"".equals(usersModelBean.getDistributor()))){
			try {
				userListSearch=usuarioTOAction.findByParams(usersModelBean.getUserCode(), usersModelBean.getName(), usersModelBean.getSurname(), usersModelBean.getDistributor(), usersModelBean.getClient(), null, usersModelBean.getCenter()	, activo, activoLogico);
			}
			catch (IntegrationException | PlexException e) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e.getMessage()));
			}
		}else{
			try {
				userListSearch=usuarioTOAction.findAllUsers(activo, activoLogico);
			}
			catch (IntegrationException | PlexException e) {
				FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e.getMessage()));
			}
		}
		if(usersModelBean.getRole()!=null&&!"".equals(usersModelBean.getRole())){
			Iterator<UsuarioTO> itUsuarioTO = userListSearch.iterator();
			while(itUsuarioTO.hasNext()){
				UsuarioTO usuarioAux =itUsuarioTO.next();
				if(usersModelBean.getRole()!=null &&  !"".equals(usersModelBean.getRole())){
					String role = usersModelBean.getRole();
					if(!role.equals(usuarioAux.getRolCod())){
						itUsuarioTO.remove();
					}
				}
			}
		}
		Iterator<UsuarioTO> itUsuario=userListSearch.iterator();
		ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
		User user =themeDisplay.getUser();
		UsuarioTO usuarioTO=null;
		try {
			usuarioTO = usuarioTOAction.findByUserCode(user.getScreenName());
		}
		catch (IntegrationException e1){
			FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e1.getMessage()));
		}
		catch(PlexException e1) {
			FacesContext.getCurrentInstance().addMessage("global", new FacesMessage(e1.getMessage()));
		}
		try {
			if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidorPersonal"), user.getUserId(), false)){
				while(itUsuario.hasNext()){
					UsuarioTO usuarioAux=itUsuario.next();
					if(usuarioAux.getRolCod()!=null &&("1".equals(usuarioAux.getRolCod())||"2".equals(usuarioAux.getRolCod())||"7".equals(usuarioAux.getRolCod())) ){
						itUsuario.remove();
					}else if(usuarioTO!=null&&!usuarioTO.getDistrCod().equals(usuarioAux.getDistrCod())){
						itUsuario.remove();
					}
				}
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false)){
				while(itUsuario.hasNext()){
					UsuarioTO usuarioAux=itUsuario.next();
					if(usuarioAux.getRolCod()!=null &&("1".equals(usuarioAux.getRolCod())||"2".equals(usuarioAux.getRolCod())||"3".equals(usuarioAux.getRolCod())||"6".equals(usuarioAux.getRolCod())||"7".equals(usuarioAux.getRolCod())) ){
						itUsuario.remove();
					}else if(usuarioTO!=null&&!usuarioTO.getDistrCod().equals(usuarioAux.getDistrCod())){
						itUsuario.remove();
					}else if(usuarioTO!=null&&!usuarioTO.getDistrCod().equals(usuarioAux.getDistrCod())){
						itUsuario.remove();
					}else if(usuarioTO!=null&&usuarioTO.getClienteCod()!=null&&!usuarioTO.getClienteCod().equals(usuarioAux.getClienteCod())){
						itUsuario.remove();
					}
				}
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
				while(itUsuario.hasNext()){
					UsuarioTO usuarioAux=itUsuario.next();
					if(usuarioAux.getRolCod()!=null &&("1".equals(usuarioAux.getRolCod())||"2".equals(usuarioAux.getRolCod())||"3".equals(usuarioAux.getRolCod())||"4".equals(usuarioAux.getRolCod())||"6".equals(usuarioAux.getRolCod())||"7".equals(usuarioAux.getRolCod())) ){
						itUsuario.remove();
					}else if(usuarioTO!=null&&!usuarioTO.getDistrCod().equals(usuarioAux.getDistrCod())){
						itUsuario.remove();
					}else if(usuarioTO!=null&&usuarioTO.getCentroCod()!=null&&!usuarioTO.getCentroCod().equals(usuarioAux.getCentroCod())){
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
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalUnexpectedErrorMessage();
		}
		usersModelBean.setUserList(userListSearch);
		usersModelBean.setSelectedUser(selectedUser);
		usersViewBean.setResultRendered(true);
		usersViewBean.setFindMode(true);
		usersViewBean.setViewMode(false);
		usersViewBean.setFormRendered(false);
		usersModelBean.forceListReload();
	}

	public String doImpersonate() {
		String redirect="";
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			User user=UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), usersModelBean.getSelectedUser().getCodigo());
			redirect=themeDisplay.getPortalURL();
			@SuppressWarnings("deprecation")
			List<Group> sites = user.getMySites();
			for(Group g : sites){
				if(g.getSite()){
					redirect = PropsUtil.get(PropsKeys.LAYOUT_FRIENDLY_URL_PRIVATE_GROUP_SERVLET_MAPPING)+g.getFriendlyURL();
				}
			}
			if(user!=null){
				long doAsUserId = user.getUserId();
				long realUserId = themeDisplay.getRealUser().getUserId();
				if (doAsUserId != realUserId) {
					Company company = themeDisplay.getCompany();
					String encDoAsUserId = Encryptor.encrypt(
						company.getKeyObj(), String.valueOf(doAsUserId));
					redirect = HttpUtil.addParameter(redirect, "doAsUserId", encDoAsUserId);
				}

				FacesContext fc = FacesContext.getCurrentInstance();
				ExternalContext externalContext = fc.getExternalContext();
				externalContext.redirect(redirect);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
		return redirect;
	}

	public void selectUser() {
		try {
			usersViewBean.setViewMode(true);
			usersViewBean.setFindMode(false);
			usersViewBean.setFormRendered(false);
			usersViewBean.setResultRendered(false);
			usersViewBean.setUpdateRendered(true);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
	}

	public void editUser() {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			User user=themeDisplay.getUser();
			usersViewBean.setFormRendered(true);
			usersViewBean.setFindMode(false);
			usersViewBean.setViewMode(false);
			usersViewBean.setResultRendered(false);
			usersViewBean.setUpdateRendered(true);
			if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administrator"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(false);
				usersViewBean.setClienteVisible(false);
				usersViewBean.setCentroVisible(false);
				usersViewBean.setDelegacionVisible(false);
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(true);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorFuncional"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(false);
				usersViewBean.setClienteVisible(false);
				usersViewBean.setCentroVisible(false);
				usersViewBean.setDelegacionVisible(false);
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(true);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidorPersonal"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(true);
				usersViewBean.setClienteVisible(true);
				usersViewBean.setCentroVisible(true);
				usersViewBean.setDelegacionVisible(true);
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(false);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(false);
				usersViewBean.setClienteVisible(true);
				usersViewBean.setCentroVisible(true);
				usersViewBean.setDelegacionVisible(true);
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(false);
				usersViewBean.setClienteVisible(true);
				usersViewBean.setCentroVisible(true);
				usersViewBean.setDelegacionVisible(true);
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.empleado"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(true);
				usersViewBean.setClienteVisible(false);
				usersViewBean.setCentroVisible(false);
				usersViewBean.setDelegacionVisible(true);
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public void removeUser() {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			UsuarioTO usuarioTO = usersModelBean.getSelectedUser();
			Calendar calendar = GregorianCalendar.getInstance();
			usuarioTO.setAuditFechaUltAccion(calendar.getTime().toString());
			usuarioTO.setAuditUsuarioUltAccion(themeDisplay.getRealUser().getFullName());
			usuarioTOAction.removeUser(usuarioTO.getCodigo(), themeDisplay.getRealUser().getFullName());
			User user=UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), usersModelBean.getSelectedUser().getCodigo());
			UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_INACTIVE);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
		usersViewBean.setFormRendered(false);
		usersViewBean.setFindMode(true);
		usersViewBean.setViewMode(false);
		usersViewBean.setResultRendered(true);
		usersModelBean.forceListReload();
	}


	public void createUser() {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			User user=themeDisplay.getUser();
			usersViewBean.setFormRendered(true);
			usersViewBean.setResultRendered(false);
			usersViewBean.setUpdateRendered(false);
			usersViewBean.setFindMode(false);
			if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administrator"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(false);
				usersViewBean.setClienteVisible(false);
				usersViewBean.setCentroVisible(false);
				usersViewBean.setDelegacionVisible(false);
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(true);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorFuncional"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(false);
				usersViewBean.setClienteVisible(false);
				usersViewBean.setCentroVisible(false);
				usersViewBean.setDelegacionVisible(false);
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(true);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidorPersonal"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(true);
				usersViewBean.setClienteVisible(true);
				usersViewBean.setCentroVisible(true);
				usersViewBean.setDelegacionVisible(true);
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(false);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(false);
				usersViewBean.setClienteVisible(true);
				usersViewBean.setCentroVisible(true);
				usersViewBean.setDelegacionVisible(true);
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(false);
				usersViewBean.setClienteVisible(true);
				usersViewBean.setCentroVisible(true);
				usersViewBean.setDelegacionVisible(true);
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.empleado"), user.getUserId(), false)){
				usersViewBean.setEmpleadoVisible(true);
				usersViewBean.setClienteVisible(false);
				usersViewBean.setCentroVisible(false);
				usersViewBean.setDelegacionVisible(true);
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
			}

			usersModelBean.setSelectedUser(new UsuarioTO());
			UsuarioTO selectedUser = usersModelBean.getSelectedUser();
			selectedUser.setUsuarioPuedeCanjear(true);
			selectedUser.setUsuarioPuedeAdministrarRol(true);
			selectedUser.setUsuarioActivo(true);
			selectedUser.setUsuarioPuedeSuplantar(false);
			selectedUser.setUsuarioRegistrado(false);
			usersModelBean.setSelectedUser(selectedUser);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
	}


	public void create(ActionEvent actionEvent) {
		try {
			boolean plexCreate=false;
			User liferayUser=null;
			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
			// Update the selected user in the Liferay database.
			UsuarioTO usuarioTO = usersModelBean.getSelectedUser();
			usuarioTO.setFechaAlta(new Date());
			usuarioTO.setAuditUsuarioUltAccion(themeDisplay.getRealUser().getFullName());
			Calendar calendar = GregorianCalendar.getInstance();
			usuarioTO.setAuditFechaUltAccion(calendar.getTime().toString());
			usuarioTO.setUsuarioRegistrado(false);
			User user =themeDisplay.getUser();
			usuarioTO.setUsuarioSuplantacion(user.getScreenName());

			String rolDescrip="";
			if("1".equals(usuarioTO.getRolCod())){
				rolDescrip=PropsUtil.get("rol.administrator");
			}else if("2".equals(usuarioTO.getRolCod())){
				rolDescrip=PropsUtil.get("rol.administradorFuncional");
			}else if("3".equals(usuarioTO.getRolCod())){
				rolDescrip=PropsUtil.get("rol.administradorDistribuidorPersonal");;
			}else if("4".equals(usuarioTO.getRolCod())){
				rolDescrip=PropsUtil.get("rol.cliente");
			}else if("5".equals(usuarioTO.getRolCod())){
				rolDescrip=PropsUtil.get("rol.centro");
			}else if("6".equals(usuarioTO.getRolCod())){
				rolDescrip=PropsUtil.get("rol.empleado");
			}else if("7".equals(usuarioTO.getRolCod())){
				rolDescrip=PropsUtil.get("rol.proveedor");
			}
			String rolDescrip2="";
			Role role2=null;
			if("3".equals(usuarioTO.getRolCod())){
				rolDescrip2=PropsUtil.get("rol.administradorDistribuidor");
				role2=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), rolDescrip2);
			}
			Role role=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), rolDescrip);
			if("3".equals(usuarioTO.getRolCod()) && role2 != null){
				long site = themeDisplay.getLayout().getGroupId();
				if(GroupLocalServiceUtil.getGroup(site).getChildren(true).size() > 0){
					liferayUser = addLiferayUser(themeDisplay, 
						usuarioTO, role.getRoleId(), role2.getRoleId(), themeDisplay.getLayout().getGroupId());
				}else{
					liferayUser = addLiferayUser(themeDisplay, 
						usuarioTO, role.getRoleId(), role2.getRoleId(), 0l);

				}
			}else{
				long site = themeDisplay.getLayout().getGroupId();
				System.out.println(GroupLocalServiceUtil.getGroup(site).getChildren(true).size());

				liferayUser = addLiferayUser(themeDisplay, 
					usuarioTO, role.getRoleId(), themeDisplay.getLayout().getGroupId());
			}
			if(liferayUser != null){
				plexCreate = usuarioTOAction.createUser(usuarioTO);

				if(plexCreate == false){
					UserLocalServiceUtil.deleteUser(liferayUser.getUserId());
				}
			}
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalSuccessInfoMessage();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
		usersViewBean.setFormRendered(false);
		usersViewBean.setViewMode(false);
		usersViewBean.setFindMode(true);
		usersViewBean.setResultRendered(false);
		usersViewBean.setUpdateRendered(true);
		usersModelBean.forceListReload();
	}

	public void loadPerms(){
		ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
		User user =themeDisplay.getUser();
		UsuarioTO usuarioTO = usersModelBean.getSelectedUser();
		Boolean userActivoLogico = usuarioTO.getRegActBLogica();
		try {
			if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administrator"), user.getUserId(), false)){
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(true);
				if("1".equals(usuarioTO.getRolCod()) || "2".equals(usuarioTO.getRolCod())){
					usersViewBean.setSelectable(true);
					usersViewBean.setImpersonatable(false);
					if(userActivoLogico){
						usersViewBean.setRemovable(true);
						usersViewBean.setActivable(false);
						usersViewBean.setEditable(true);
					}else{
						usersViewBean.setRemovable(false);
						usersViewBean.setActivable(true);
						usersViewBean.setEditable(false);
					}
				}else{
					usersViewBean.setSelectable(true);
					usersViewBean.setEditable(false);
					usersViewBean.setRemovable(false);
					usersViewBean.setImpersonatable(false);
					usersViewBean.setActivable(false);
				}
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorFuncional"), user.getUserId(), false)){
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(true);
				if("2".equals(usuarioTO.getRolCod()) || "3".equals(usuarioTO.getRolCod())|| "7".equals(usuarioTO.getRolCod())){
					usersViewBean.setSelectable(true);
					if("3".equals(usuarioTO.getRolCod())){
						usersViewBean.setImpersonatable(true);
					}else{
						usersViewBean.setImpersonatable(false);
					}
					if(userActivoLogico){
						usersViewBean.setRemovable(true);
						usersViewBean.setActivable(false);
						usersViewBean.setEditable(true);
					}else{
						usersViewBean.setRemovable(false);
						usersViewBean.setActivable(true);
						usersViewBean.setEditable(false);
					}
				}else{
					usersViewBean.setSelectable(true);
					usersViewBean.setEditable(false);
					usersViewBean.setRemovable(false);
					usersViewBean.setActivable(false);
					usersViewBean.setImpersonatable(false);
				}
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.administradorDistribuidorPersonal"), user.getUserId(), false)){
				usersViewBean.setCanMakeImpersonatable(true);
				usersViewBean.setCanEditDistribuidor(false);
				if("3".equals(usuarioTO.getRolCod()) || "4".equals(usuarioTO.getRolCod())|| "5".equals(usuarioTO.getRolCod())|| "6".equals(usuarioTO.getRolCod())){
					usersViewBean.setSelectable(true);
					if("4".equals(usuarioTO.getRolCod())|| "5".equals(usuarioTO.getRolCod())|| "6".equals(usuarioTO.getRolCod())){
						usersViewBean.setImpersonatable(true);
					}else{
						usersViewBean.setImpersonatable(false);
					}
					if(userActivoLogico){
						usersViewBean.setRemovable(true);
						usersViewBean.setActivable(false);
						usersViewBean.setEditable(true);
					}else{
						usersViewBean.setRemovable(false);
						usersViewBean.setActivable(true);
						usersViewBean.setEditable(false);
					}
				}else{
					usersViewBean.setSelectable(false);
					usersViewBean.setEditable(false);
					usersViewBean.setRemovable(false);
					usersViewBean.setImpersonatable(false);
					usersViewBean.setActivable(false);
				}
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.cliente"), user.getUserId(), false)){
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
				if("4".equals(usuarioTO.getRolCod())|| "5".equals(usuarioTO.getRolCod())){
					usersViewBean.setSelectable(true);
					usersViewBean.setImpersonatable(false);
					if(userActivoLogico){
						usersViewBean.setRemovable(true);
						usersViewBean.setActivable(false);
						usersViewBean.setEditable(true);
					}else{
						usersViewBean.setRemovable(false);
						usersViewBean.setActivable(true);
						usersViewBean.setEditable(false);
					}
				}else{
					usersViewBean.setSelectable(false);
					usersViewBean.setEditable(false);
					usersViewBean.setRemovable(false);
					usersViewBean.setImpersonatable(false);
					usersViewBean.setActivable(false);
				}
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.centro"), user.getUserId(), false)){
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
				if("5".equals(usuarioTO.getRolCod())){
					usersViewBean.setSelectable(true);
					usersViewBean.setImpersonatable(false);
					if(userActivoLogico){
						usersViewBean.setRemovable(true);
						usersViewBean.setActivable(false);
						usersViewBean.setEditable(true);
					}else{
						usersViewBean.setRemovable(false);
						usersViewBean.setActivable(true);
						usersViewBean.setEditable(false);
					}
				}else{
					usersViewBean.setSelectable(false);
					usersViewBean.setEditable(false);
					usersViewBean.setRemovable(false);
					usersViewBean.setImpersonatable(false);
					usersViewBean.setActivable(false);
				}
			}else if(UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), PropsUtil.get("rol.empleado"), user.getUserId(), false)){
				usersViewBean.setCanMakeImpersonatable(false);
				usersViewBean.setCanEditDistribuidor(false);
				if("6".equals(usuarioTO.getRolCod())){
					usersViewBean.setSelectable(true);
					usersViewBean.setImpersonatable(false);
					if(userActivoLogico){
						usersViewBean.setRemovable(true);
						usersViewBean.setActivable(false);
						usersViewBean.setEditable(true);
					}else{
						usersViewBean.setRemovable(false);
						usersViewBean.setActivable(true);
						usersViewBean.setEditable(false);
					}
				}else{
					usersViewBean.setSelectable(false);
					usersViewBean.setEditable(false);
					usersViewBean.setRemovable(false);
					usersViewBean.setImpersonatable(false);
					usersViewBean.setActivable(false);
				}
			}
		}catch(Exception e){
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}

	}

	private User addLiferayUser(ThemeDisplay themeDisplay,
		UsuarioTO usuarioTO, Long roleId, Long groupId) {
		User user = null;
		try {
			//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			long creatorUserId = themeDisplay.getUserId(); 
			long companyId = themeDisplay.getCompanyId(); 
			boolean autoPassword = false;
			String password1 = usersModelBean.getPassword();
			//String password1 = "test";
			String password2 = usersModelBean.getPassword();
			//String password2 = "test";
			boolean autoScreenName = false;
			String screenName = usuarioTO.getCodigo();
			String emailAddress = usuarioTO.getEmail();
			long facebookId = 0;
			String openId = "";
			Locale locale = themeDisplay.getLocale();
			String firstName = usuarioTO.getNombre();
			String middleName = "";
			String lastName = usuarioTO.getApellidos();

			int prefixId = 0;

			int suffixId = 0;
			boolean male = true;

			int birthdayMonth = 1;
			int birthdayDay = 1;
			int birthdayYear = 1970;

			if (usuarioTO.getFechaNacimiento() != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(usuarioTO.getFechaNacimiento());
				birthdayMonth = cal.get(Calendar.MONTH);
				birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
				birthdayYear = cal.get(Calendar.YEAR);
			}

			String jobTitle = "";

			long[] groupIds = {};
			if (groupId != 0 ) {
				groupIds = new long[1];
				groupIds[0] = groupId;
			}

			long[] organizationIds = {};


			long[] roleIds = null;
			if (roleId != 0 ) {
				roleIds = new long[1];
				roleIds[0] = roleId;
			}

			//			If user has role 1 or 2, add to father site
			long[] userGroupIds = {};
			

			boolean sendEmail = false;
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			ServiceContext serviceContext = liferayFacesContext.getServiceContext();
			user = null;
			boolean userbyscreeenname_exists = true;
			boolean userbyemail_exists = true;

			try {
				user = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
			} catch (NoSuchUserException nsue) {
				userbyscreeenname_exists = false;
			}
			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			} catch (NoSuchUserException nsue) {
				userbyemail_exists = false;
			}

			if((!userbyscreeenname_exists) & (!userbyemail_exists))
			{

				//				long userId = CounterLocalServiceUtil.increment(UserLocalServiceUtil.class.getName());
				//				user = UserLocalServiceUtil.createUser(userId);
				//				user.setCompanyId(companyId);
				//				user.setPassword(password1);
				//				user.setScreenName(screenName);
				//				user.setEmailAddress(emailAddress);
				//				user.setFirstName(firstName);
				//				user.setLastName(lastName);

				user = UserLocalServiceUtil.addUser(creatorUserId,
					companyId,
					autoPassword,
					password1,
					password2,
					autoScreenName,
					screenName,
					emailAddress,
					facebookId,
					openId,
					locale,
					firstName,
					middleName,
					lastName,
					prefixId,
					suffixId,
					male,
					birthdayMonth,
					birthdayDay,
					birthdayYear,
					jobTitle,
					groupIds,
					organizationIds,
					roleIds,
					userGroupIds,
					sendEmail,
					serviceContext);

				user.setPasswordReset(false);
				user = UserLocalServiceUtil.updateUser(user);

				UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED, serviceContext);
				Indexer indexer = IndexerRegistryUtil.getIndexer(User.class);

				indexer.reindex(user);

			} else {
				String msg_exists = "";
				if (userbyscreeenname_exists) {
					msg_exists = msg_exists + "Screen Name is not unique.";
				}
				if (userbyemail_exists) {
					msg_exists = msg_exists + " Email Address is not unique.";
				}


				user = null;
			}

			if(user == null){
				try {
					usuarioTOAction.removeUser(usuarioTO.getCodigo(), themeDisplay.getRealUser().getFullName());
				}
				catch (IntegrationException e1){
					logger.error(e1);
				}
				catch(PlexException e1) {
					logger.error(e1);
				}
			}

		} catch (PortalException e) {
			try {
				usuarioTOAction.removeUser(usuarioTO.getCodigo(), themeDisplay.getRealUser().getFullName());
			}
			catch (IntegrationException e1){
				logger.error(e);
			}
			catch(PlexException e1) {
				logger.error(e);
			}

		} catch (SystemException e) {
			try {
				usuarioTOAction.removeUser(usuarioTO.getCodigo(), themeDisplay.getRealUser().getFullName());
			}
			catch (IntegrationException e1){
				logger.error(e);
			}
			catch(PlexException e1) {
				logger.error(e);
			}
		}
		return user;
	}

	private User addLiferayUser(ThemeDisplay themeDisplay,
		UsuarioTO usuarioTO, Long roleId, Long roleId2, Long groupId) {
		User user = null;
		try {
			//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			long creatorUserId = themeDisplay.getUserId(); 
			long companyId = themeDisplay.getCompanyId(); 
			boolean autoPassword = false;
			String password1 = usersModelBean.getPassword();
			//String password1 = "test";
			String password2 = usersModelBean.getPassword();
			//String password2 = "test";
			boolean autoScreenName = false;
			String screenName = usuarioTO.getCodigo();
			String emailAddress = usuarioTO.getEmail();
			long facebookId = 0;
			String openId = "";
			Locale locale = themeDisplay.getLocale();
			String firstName = usuarioTO.getNombre();
			String middleName = "";
			String lastName = usuarioTO.getApellidos();

			int prefixId = 0;

			int suffixId = 0;
			boolean male = true;

			int birthdayMonth = 1;
			int birthdayDay = 1;
			int birthdayYear = 1970;

			if (usuarioTO.getFechaNacimiento() != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(usuarioTO.getFechaNacimiento());
				birthdayMonth = cal.get(Calendar.MONTH);
				birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
				birthdayYear = cal.get(Calendar.YEAR);
			}

			String jobTitle = "";

			long[] groupIds = {};
			if (groupId != 0 ) {
				groupIds = new long[1];
				groupIds[0] = groupId;
			}
			long[] organizationIds = null;


			long[] roleIds = null;
			if (roleId != 0 && roleId2 != 0 ) {
				roleIds = new long[2];
				roleIds[0] = roleId;
				roleIds[1] = roleId2;
			}else if (roleId != 0 ) {
				roleIds = new long[1];
				roleIds[0] = roleId;
			}


			long[] userGroupIds = {};

			boolean sendEmail = false;
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			ServiceContext serviceContext = liferayFacesContext.getServiceContext();
			user = null;
			boolean userbyscreeenname_exists = true;
			boolean userbyemail_exists = true;

			try {
				user = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
			} catch (NoSuchUserException nsue) {
				userbyscreeenname_exists = false;
			}
			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			} catch (NoSuchUserException nsue) {
				userbyemail_exists = false;
			}

			if((!userbyscreeenname_exists) & (!userbyemail_exists))
			{

				//			long userId = CounterLocalServiceUtil.increment(UserLocalServiceUtil.class.getName());
				//			user = UserLocalServiceUtil.createUser(userId);
				//			user.setCompanyId(companyId);
				//			user.setPassword(password1);
				//			user.setScreenName(screenName);
				//			user.setEmailAddress(emailAddress);
				//			user.setFirstName(firstName);
				//			user.setLastName(lastName);

				user = UserLocalServiceUtil.addUser(creatorUserId,
					companyId,
					autoPassword,
					password1,
					password2,
					autoScreenName,
					screenName,
					emailAddress,
					facebookId,
					openId,
					locale,
					firstName,
					middleName,
					lastName,
					prefixId,
					suffixId,
					male,
					birthdayMonth,
					birthdayDay,
					birthdayYear,
					jobTitle,
					groupIds,
					organizationIds,
					roleIds,
					userGroupIds,
					sendEmail,
					serviceContext);

				user.setPasswordReset(false);
				user = UserLocalServiceUtil.updateUser(user);

				UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED, serviceContext);
				Indexer indexer = IndexerRegistryUtil.getIndexer(User.class);

				indexer.reindex(user);

			} else {
				String msg_exists = "";
				if (userbyscreeenname_exists) {
					msg_exists = msg_exists + "Screen Name is not unique.";
				}
				if (userbyemail_exists) {
					msg_exists = msg_exists + " Email Address is not unique.";
				}


				user = null;
			}

		} catch (PortalException e) {
		} catch (SystemException e) {
		}
		return user;
	}


	public void activeUser(ActionEvent actionEvent) {
		ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(WebKeys.THEME_DISPLAY);
		User auditor = themeDisplay.getUser();
		UsuarioTO usuarioTO = usersModelBean.getSelectedUser();
		try {
			usuarioTOAction.reactivateUser(usuarioTO.getCodigo(), auditor.getScreenName());
			Calendar calendar = GregorianCalendar.getInstance();
			usuarioTO.setAuditFechaUltAccion(calendar.getTime().toString());
			usuarioTO.setAuditUsuarioUltAccion(themeDisplay.getRealUser().getFullName());
			User user=UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), usersModelBean.getSelectedUser().getCodigo());
			UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED);
		} catch (PortalException e) {

			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalUnexpectedErrorMessage();
		} catch (SystemException e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalUnexpectedErrorMessage();
		} catch (IntegrationException e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		} catch (PlexException e) {
			logger.error(e.getMessage(), e);
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			liferayFacesContext.addGlobalErrorMessage(e.getLocalizedMessage());
		}
		List<UsuarioTO> userListSearch=null;
		usersModelBean.setUserList(userListSearch);
		usersViewBean.setFormRendered(false);
		usersViewBean.setFindMode(true);
		usersViewBean.setViewMode(false);
		usersModelBean.forceListReload();
	}

}