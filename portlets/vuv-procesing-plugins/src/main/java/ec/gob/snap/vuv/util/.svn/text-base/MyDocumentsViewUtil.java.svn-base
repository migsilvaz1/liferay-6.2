package ec.gob.snap.vuv.util;

import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class MyDocumentsViewUtil {

	public static Long getDirectorioUsuarioId(long groupId, String userScreenName){
		Long idFolderUsuario = 0L;
		try{
			DLFolder folderUsuario = DLFolderLocalServiceUtil.getFolder(groupId, 0L, userScreenName);
			if(folderUsuario != null){
				idFolderUsuario = folderUsuario.getFolderId();
			}
		}catch(Exception e){
			idFolderUsuario = 0L;
		}
		return idFolderUsuario;
	}
}
