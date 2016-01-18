package ec.gob.snap.vuv;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class DocumentsPortletUtil {

	private static Log logger = LogFactoryUtil.getLog(DocumentsPortletUtil.class);

	public static Long getDirectorioUsuario(long groupId, long companyId, long userId, String userScreenName){
		Long idFolder = 0L;
		//Se configura el directorio del usuario. Si no existe su directorio se crea uno.
		DLFolder folderUsuario;
		try {
			try{
				folderUsuario = DLFolderLocalServiceUtil.getFolder(groupId, 0L, userScreenName);
			}catch(NoSuchFolderException e){
				logger.info("No existe el directorio del usuario " + userScreenName + ", va a crearse uno nuevo");
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				folderUsuario = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, 0L, userScreenName, "", false, serviceContext);
				//Cambiar los permisos del directorio del usuario
				Role role = RoleLocalServiceUtil.getRole(companyId, "Owner");
				ResourcePermission resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(companyId, DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folderUsuario.getFolderId(), role.getRoleId());
				if (Validator.isNotNull(resourcePermission)){
					ResourceAction resourceActionDelete = ResourceActionLocalServiceUtil.getResourceAction(DLFolder.class.getName(), ActionKeys.DELETE);
					if (ResourcePermissionLocalServiceUtil.hasActionId(resourcePermission, resourceActionDelete)){
						resourcePermission.setActionIds(resourcePermission.getActionIds() - resourceActionDelete.getBitwiseValue());
					}
					ResourceAction resourceActionPermission = ResourceActionLocalServiceUtil.getResourceAction(DLFolder.class.getName(), ActionKeys.PERMISSIONS);
					if (Validator.isNotNull(resourcePermission) && ResourcePermissionLocalServiceUtil.hasActionId(resourcePermission, resourceActionPermission)){
						resourcePermission.setActionIds(resourcePermission.getActionIds() - resourceActionPermission.getBitwiseValue());
					}
					ResourceAction resourceActionUpdate = ResourceActionLocalServiceUtil.getResourceAction(DLFolder.class.getName(), ActionKeys.UPDATE);
					if (Validator.isNotNull(resourcePermission) && ResourcePermissionLocalServiceUtil.hasActionId(resourcePermission, resourceActionUpdate)){
						resourcePermission.setActionIds(resourcePermission.getActionIds() - resourceActionUpdate.getBitwiseValue());
					}
					ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
				}
			}
			if(folderUsuario != null){
				idFolder = folderUsuario.getFolderId();
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return idFolder;
	}
}