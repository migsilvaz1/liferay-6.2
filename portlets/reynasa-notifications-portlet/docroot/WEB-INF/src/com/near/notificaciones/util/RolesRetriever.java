package com.near.notificaciones.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class RolesRetriever {

	/**
	 * Devuelve un listado de los roles permitidos como destinatarios a un usuario determinado para enviar una notificación.
	 * @param isEnvioGeneral Indica el tipo de envío que se va a realizar. El valor será true si es general y false si es personal.
	 * @param user Usuario remitente de la notificación.
	 * @return Listado de los roles permitidos como destinatarios.
	 */
	public static List<Role> getRolesPermitidos(Boolean isEnvioGeneral, long companyId, User user){
		List<Role> rolesPermitidosList = new ArrayList<Role>();
		try{
			long[] rolesUsuario = user.getRoleIds();
			for(int i = 0; i < rolesUsuario.length; i++){
				if(rolesUsuario[i] == RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.administradorDistribuidor")).getRoleId()){
					if(!isEnvioGeneral){
						rolesPermitidosList.add(RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.centro")));
					}
					rolesPermitidosList.add(RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.cliente")));
					rolesPermitidosList.add(RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.administradorFuncional")));
				}
				if(rolesUsuario[i] == RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.cliente")).getRoleId()){
					rolesPermitidosList.add(RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.administradorDistribuidor")));
				}
				if(rolesUsuario[i] == RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.centro")).getRoleId()){
					rolesPermitidosList.add(RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.administradorDistribuidor")));
				}
				if(rolesUsuario[i] == RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.administradorFuncional")).getRoleId()){
					rolesPermitidosList.add(RoleLocalServiceUtil.getRole(companyId, PropsUtil.get("rol.administradorDistribuidor")));
				}
			}
		}catch(PortalException | SystemException e){
			System.out.println("Excepción en RolesRetriever línea 76 - " + e.toString() + ": " + e.getLocalizedMessage());
		}
		return rolesPermitidosList;
	}
}
