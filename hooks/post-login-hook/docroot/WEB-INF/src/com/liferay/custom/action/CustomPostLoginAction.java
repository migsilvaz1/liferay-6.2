package com.liferay.custom.action;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.interfaces.action.UsuarioTOAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomPostLoginAction extends Action{
	@Override
	public void run(HttpServletRequest httpreq, HttpServletResponse httpres) throws ActionException {
		User user= null;
		try {
			user = PortalUtil.getUser(httpreq);
			HttpSession session = httpreq.getSession();
			@SuppressWarnings("deprecation")
			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user, true);
			PermissionThreadLocal.setPermissionChecker(permissionChecker);
			long roleAdministradorFuncionalId = RoleLocalServiceUtil.getRole(PortalUtil.getCompanyId(httpreq), PropsUtil.get("rol.administradorFuncional")).getRoleId();
			long roleRemoteId = RoleLocalServiceUtil.getRole(PortalUtil.getCompanyId(httpreq), PropsUtil.get("rol.remote")).getRoleId();
//			long roleProveedorId = RoleLocalServiceUtil.getRole(PortalUtil.getCompanyId(httpreq), "Proveedor").getRoleId();
			String pathLogin;
			if(permissionChecker.isOmniadmin() || UserLocalServiceUtil.hasRoleUser(roleRemoteId, user.getUserId())){
				//Si el usuario es owner, la redirección se hará a la página de login sin validaciones plex
				pathLogin = "/login";
				httpres.sendRedirect(pathLogin);
			}else{
				//Validaciones de plex, se registra el usuario si todavía no está registrado
				UsuarioTOAction usuarioTOAction = new UsuarioTOActionImpl();
				Boolean isRegistrado = usuarioTOAction.isRegistered(user.getScreenName());
				if(!isRegistrado){
					usuarioTOAction.register(user.getScreenName());
					System.out.println("Registrada la primera entrada del usuario " + user.getScreenName());
				}
				if(UserLocalServiceUtil.hasRoleUser(roleAdministradorFuncionalId, user.getUserId())/* || UserLocalServiceUtil.hasRoleUser(roleProveedorId, user.getUserId())*/){
					//Si el usuario es administrador funcional se redirige al login
					pathLogin = "/group/guest/catalogo";
					httpres.sendRedirect(pathLogin);
				}else{
					//Si el usuario no es administrador ni administrador funcional se le redirige a la página de su ultimo site
					@SuppressWarnings("deprecation")
					List<Group> sites = user.getMySites();
					String url = "";
					for(Group g : sites){
						if(g.getSite()){
							url = PropsUtil.get(PropsKeys.LAYOUT_FRIENDLY_URL_PRIVATE_GROUP_SERVLET_MAPPING)+g.getFriendlyURL();
							LastPath publiclastPath = new LastPath(httpreq.getContextPath(), url);
							session.setAttribute(WebKeys.LAST_PATH, publiclastPath);
						}
					}
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}