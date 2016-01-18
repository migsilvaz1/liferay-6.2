package com.near.reynasa.masiveLoadUser.portlet.model;

/**
 * @author Filippo Maria Del Prete
 * 
 * based on the original work of Paul Butenko
 * http://java-liferay.blogspot.it/2012/09/how-to-make-users-import-into-liferay.html
 *
*/

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.near.reynasa.impl.action.UsuarioTOActionImpl;
import com.near.reynasa.interfaces.TO.UsuarioTO;
import com.near.reynasa.interfaces.action.UsuarioTOAction;
import com.near.reynasa.utils.IntegrationException;
import com.near.reynasa.utils.PlexException;

import java.util.Date;

public class CsvUserBean {
	long liferayUserId;
	String impStatus;
	String username;
	String correoElectronico;
	Date birthday;
	String nombre;
	String apellidos;
	String password;
	String activo;
	String rol;
	String codigoCentro;
	String denCentro;
	String codigoCliente;
	String denCliente;
	String codigoEmpleado;
	String codigoDelegacion;
	String denDelegacion;
	String cif;
	String direccion;
	String municipio;
	String codigoPostal;
	String provincia;
	String telefonoMovil;
	String telefonoFijo;
	String usuarioPuedeCanjear;
	String usuarioPuedeAdministrar;
	String usuarioPuedeSuplantar;
	private static UsuarioTOAction usuarioTOAction=new UsuarioTOActionImpl();
	
	
	
	public UsuarioTO getUsuarioTO(long userId){
		UsuarioTO usuarioTO=new UsuarioTO();
		UsuarioTO padre=null;
		try {
			User user = UserLocalServiceUtil.getUserById(userId);
			
			usuarioTO.setRegActBLogica(true);
			usuarioTO.setUsuarioRegistrado(false);
			usuarioTO.setUsuarioSuplantacion(user.getScreenName());
			usuarioTO.setFechaAlta(new Date());
			padre = usuarioTOAction.findByUserCode(user.getScreenName());
			usuarioTO.setDistrCod(padre.getDistrCod());
			usuarioTO.setDistrDen(padre.getDistrDen());
			
			
			usuarioTO.setCodigo(username);
			usuarioTO.setEmail(correoElectronico);
			usuarioTO.setNombre(nombre);
			usuarioTO.setApellidos(apellidos);
			usuarioTO.setFechaNacimiento(birthday);
			usuarioTO.setUsuarioActivo(activo.equals("1"));
			usuarioTO.setRolCod(rol);
			usuarioTO.setCif(cif);
			usuarioTO.setDireccion1(direccion);
			usuarioTO.setMunicipio(municipio);
			usuarioTO.setCodigoPostal(codigoPostal);
			usuarioTO.setProvincia(provincia);
			usuarioTO.setTelefonoMovil(telefonoMovil);
			usuarioTO.setTelefonoFijo(telefonoFijo);
			usuarioTO.setUsuarioPuedeCanjear(usuarioPuedeCanjear.equals("1"));
			usuarioTO.setUsuarioPuedeAdministrarRol(usuarioPuedeAdministrar.equals("1"));
			usuarioTO.setUsuarioPuedeSuplantar(usuarioPuedeSuplantar.equals("1"));
			switch (rol) {
			case "3":
				break;
			case "4":
				usuarioTO.setClienteCod(codigoCliente);
				usuarioTO.setClienteDen(denCliente);
				break;
			case "5":
				usuarioTO.setClienteCod(codigoCliente);
				usuarioTO.setClienteDen(denCliente);
				
				usuarioTO.setCentroCod(codigoCentro);
				usuarioTO.setCentroDen(denCentro);
				usuarioTO.setDelegCod(codigoDelegacion);
				usuarioTO.setDelegDen(denDelegacion);
				break;
			case "6":
				usuarioTO.setEmpleadoCod(codigoEmpleado);
				break;

			default:
				//Error
				break;
			}
			
			
		}
		
		catch (IntegrationException e) {
			e.printStackTrace();
		}
		catch (PlexException e) {
			e.printStackTrace();
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarioTO;
		
	}


	
	/**
	 * Gets the value of the attribute {@link #liferayUserId}.
	 * @return the value of the attribute {@link #liferayUserId}.
	 */
	public long getLiferayUserId() {
	
		return liferayUserId;
	}


	
	/**
	 * Sets the value of the attribute {@link #liferayUserId}.
	 * @param liferayUserId The value for the attribute {@link #liferayUserId}.
	 */
	public void setLiferayUserId(long liferayUserId) {
	
		this.liferayUserId = liferayUserId;
	}


	
	/**
	 * Gets the value of the attribute {@link #username}.
	 * @return the value of the attribute {@link #username}.
	 */
	public String getUsername() {
	
		return username;
	}


	
	/**
	 * Sets the value of the attribute {@link #username}.
	 * @param username The value for the attribute {@link #username}.
	 */
	public void setUsername(String username) {
	
		this.username = username;
	}


	
	/**
	 * Gets the value of the attribute {@link #correoElectronico}.
	 * @return the value of the attribute {@link #correoElectronico}.
	 */
	public String getCorreoElectronico() {
	
		return correoElectronico;
	}


	
	/**
	 * Sets the value of the attribute {@link #correoElectronico}.
	 * @param correoElectronico The value for the attribute {@link #correoElectronico}.
	 */
	public void setCorreoElectronico(String correoElectronico) {
	
		this.correoElectronico = correoElectronico;
	}


	
	/**
	 * Gets the value of the attribute {@link #birthday}.
	 * @return the value of the attribute {@link #birthday}.
	 */
	public Date getBirthday() {
	
		return birthday;
	}


	
	/**
	 * Sets the value of the attribute {@link #birthday}.
	 * @param birthday The value for the attribute {@link #birthday}.
	 */
	public void setBirthday(Date birthday) {
	
		this.birthday = birthday;
	}


	
	/**
	 * Gets the value of the attribute {@link #nombre}.
	 * @return the value of the attribute {@link #nombre}.
	 */
	public String getNombre() {
	
		return nombre;
	}


	
	/**
	 * Sets the value of the attribute {@link #nombre}.
	 * @param nombre The value for the attribute {@link #nombre}.
	 */
	public void setNombre(String nombre) {
	
		this.nombre = nombre;
	}


	
	/**
	 * Gets the value of the attribute {@link #apellidos}.
	 * @return the value of the attribute {@link #apellidos}.
	 */
	public String getApellidos() {
	
		return apellidos;
	}


	
	/**
	 * Sets the value of the attribute {@link #apellidos}.
	 * @param apellidos The value for the attribute {@link #apellidos}.
	 */
	public void setApellidos(String apellidos) {
	
		this.apellidos = apellidos;
	}


	
	/**
	 * Gets the value of the attribute {@link #password}.
	 * @return the value of the attribute {@link #password}.
	 */
	public String getPassword() {
	
		return password;
	}


	
	/**
	 * Sets the value of the attribute {@link #password}.
	 * @param password The value for the attribute {@link #password}.
	 */
	public void setPassword(String password) {
	
		this.password = password;
	}


	
	/**
	 * Gets the value of the attribute {@link #activo}.
	 * @return the value of the attribute {@link #activo}.
	 */
	public String getActivo() {
	
		return activo;
	}


	
	/**
	 * Sets the value of the attribute {@link #activo}.
	 * @param activo The value for the attribute {@link #activo}.
	 */
	public void setActivo(String activo) {
	
		this.activo = activo;
	}


	
	/**
	 * Gets the value of the attribute {@link #rol}.
	 * @return the value of the attribute {@link #rol}.
	 */
	public String getRol() {
	
		return rol;
	}


	
	/**
	 * Sets the value of the attribute {@link #rol}.
	 * @param rol The value for the attribute {@link #rol}.
	 */
	public void setRol(String rol) {
	
		this.rol = rol;
	}


	
	/**
	 * Gets the value of the attribute {@link #codigoCentro}.
	 * @return the value of the attribute {@link #codigoCentro}.
	 */
	public String getCodigoCentro() {
	
		return codigoCentro;
	}


	
	/**
	 * Sets the value of the attribute {@link #codigoCentro}.
	 * @param codigoCentro The value for the attribute {@link #codigoCentro}.
	 */
	public void setCodigoCentro(String codigoCentro) {
	
		this.codigoCentro = codigoCentro;
	}


	
	/**
	 * Gets the value of the attribute {@link #denCentro}.
	 * @return the value of the attribute {@link #denCentro}.
	 */
	public String getDenCentro() {
	
		return denCentro;
	}


	
	/**
	 * Sets the value of the attribute {@link #denCentro}.
	 * @param denCentro The value for the attribute {@link #denCentro}.
	 */
	public void setDenCentro(String denCentro) {
	
		this.denCentro = denCentro;
	}


	
	/**
	 * Gets the value of the attribute {@link #codigoCliente}.
	 * @return the value of the attribute {@link #codigoCliente}.
	 */
	public String getCodigoCliente() {
	
		return codigoCliente;
	}


	
	/**
	 * Sets the value of the attribute {@link #codigoCliente}.
	 * @param codigoCliente The value for the attribute {@link #codigoCliente}.
	 */
	public void setCodigoCliente(String codigoCliente) {
	
		this.codigoCliente = codigoCliente;
	}


	
	/**
	 * Gets the value of the attribute {@link #denCliente}.
	 * @return the value of the attribute {@link #denCliente}.
	 */
	public String getDenCliente() {
	
		return denCliente;
	}


	
	/**
	 * Sets the value of the attribute {@link #denCliente}.
	 * @param denCliente The value for the attribute {@link #denCliente}.
	 */
	public void setDenCliente(String denCliente) {
	
		this.denCliente = denCliente;
	}


	
	/**
	 * Gets the value of the attribute {@link #codigoEmpleado}.
	 * @return the value of the attribute {@link #codigoEmpleado}.
	 */
	public String getCodigoEmpleado() {
	
		return codigoEmpleado;
	}


	
	/**
	 * Sets the value of the attribute {@link #codigoEmpleado}.
	 * @param codigoEmpleado The value for the attribute {@link #codigoEmpleado}.
	 */
	public void setCodigoEmpleado(String codigoEmpleado) {
	
		this.codigoEmpleado = codigoEmpleado;
	}


	/**
	 * Gets the value of the attribute {@link #codigoDelegacion}.
	 * @return the value of the attribute {@link #codigoDelegacion}.
	 */
	public String getCodigoDelegacion() {
	
		return codigoDelegacion;
	}


	
	/**
	 * Sets the value of the attribute {@link #codigoDelegacion}.
	 * @param codigoDelegacion The value for the attribute {@link #codigoDelegacion}.
	 */
	public void setCodigoDelegacion(String codigoDelegacion) {
	
		this.codigoDelegacion = codigoDelegacion;
	}


	
	/**
	 * Gets the value of the attribute {@link #denDelegacion}.
	 * @return the value of the attribute {@link #denDelegacion}.
	 */
	public String getDenDelegacion() {
	
		return denDelegacion;
	}


	
	/**
	 * Sets the value of the attribute {@link #denDelegacion}.
	 * @param denDelegacion The value for the attribute {@link #denDelegacion}.
	 */
	public void setDenDelegacion(String denDelegacion) {
	
		this.denDelegacion = denDelegacion;
	}


	
	/**
	 * Gets the value of the attribute {@link #cif}.
	 * @return the value of the attribute {@link #cif}.
	 */
	public String getCif() {
	
		return cif;
	}


	
	/**
	 * Sets the value of the attribute {@link #cif}.
	 * @param cif The value for the attribute {@link #cif}.
	 */
	public void setCif(String cif) {
	
		this.cif = cif;
	}


	
	/**
	 * Gets the value of the attribute {@link #direccion}.
	 * @return the value of the attribute {@link #direccion}.
	 */
	public String getDireccion() {
	
		return direccion;
	}


	
	/**
	 * Sets the value of the attribute {@link #direccion}.
	 * @param direccion The value for the attribute {@link #direccion}.
	 */
	public void setDireccion(String direccion) {
	
		this.direccion = direccion;
	}


	
	/**
	 * Gets the value of the attribute {@link #municipio}.
	 * @return the value of the attribute {@link #municipio}.
	 */
	public String getMunicipio() {
	
		return municipio;
	}


	
	/**
	 * Sets the value of the attribute {@link #municipio}.
	 * @param municipio The value for the attribute {@link #municipio}.
	 */
	public void setMunicipio(String municipio) {
	
		this.municipio = municipio;
	}


	
	/**
	 * Gets the value of the attribute {@link #codigoPostal}.
	 * @return the value of the attribute {@link #codigoPostal}.
	 */
	public String getCodigoPostal() {
	
		return codigoPostal;
	}


	
	/**
	 * Sets the value of the attribute {@link #codigoPostal}.
	 * @param codigoPostal The value for the attribute {@link #codigoPostal}.
	 */
	public void setCodigoPostal(String codigoPostal) {
	
		this.codigoPostal = codigoPostal;
	}


	
	/**
	 * Gets the value of the attribute {@link #provincia}.
	 * @return the value of the attribute {@link #provincia}.
	 */
	public String getProvincia() {
	
		return provincia;
	}


	
	/**
	 * Sets the value of the attribute {@link #provincia}.
	 * @param provincia The value for the attribute {@link #provincia}.
	 */
	public void setProvincia(String provincia) {
	
		this.provincia = provincia;
	}


	
	/**
	 * Gets the value of the attribute {@link #telefonoMovil}.
	 * @return the value of the attribute {@link #telefonoMovil}.
	 */
	public String getTelefonoMovil() {
	
		return telefonoMovil;
	}


	
	/**
	 * Sets the value of the attribute {@link #telefonoMovil}.
	 * @param telefonoMovil The value for the attribute {@link #telefonoMovil}.
	 */
	public void setTelefonoMovil(String telefonoMovil) {
	
		this.telefonoMovil = telefonoMovil;
	}


	
	/**
	 * Gets the value of the attribute {@link #telefonoFijo}.
	 * @return the value of the attribute {@link #telefonoFijo}.
	 */
	public String getTelefonoFijo() {
	
		return telefonoFijo;
	}


	
	/**
	 * Sets the value of the attribute {@link #telefonoFijo}.
	 * @param telefonoFijo The value for the attribute {@link #telefonoFijo}.
	 */
	public void setTelefonoFijo(String telefonoFijo) {
	
		this.telefonoFijo = telefonoFijo;
	}


	
	/**
	 * Gets the value of the attribute {@link #usuarioPuedeCanjear}.
	 * @return the value of the attribute {@link #usuarioPuedeCanjear}.
	 */
	public String getUsuarioPuedeCanjear() {
	
		return usuarioPuedeCanjear;
	}


	
	/**
	 * Sets the value of the attribute {@link #usuarioPuedeCanjear}.
	 * @param usuarioPuedeCanjear The value for the attribute {@link #usuarioPuedeCanjear}.
	 */
	public void setUsuarioPuedeCanjear(String usuarioPuedeCanjear) {
	
		this.usuarioPuedeCanjear = usuarioPuedeCanjear;
	}


	
	/**
	 * Gets the value of the attribute {@link #usuarioPuedeAdministrar}.
	 * @return the value of the attribute {@link #usuarioPuedeAdministrar}.
	 */
	public String getUsuarioPuedeAdministrar() {
	
		return usuarioPuedeAdministrar;
	}


	
	/**
	 * Sets the value of the attribute {@link #usuarioPuedeAdministrar}.
	 * @param usuarioPuedeAdministrar The value for the attribute {@link #usuarioPuedeAdministrar}.
	 */
	public void setUsuarioPuedeAdministrar(String usuarioPuedeAdministrar) {
	
		this.usuarioPuedeAdministrar = usuarioPuedeAdministrar;
	}


	
	/**
	 * Gets the value of the attribute {@link #usuarioPuedeSuplantar}.
	 * @return the value of the attribute {@link #usuarioPuedeSuplantar}.
	 */
	public String getUsuarioPuedeSuplantar() {
	
		return usuarioPuedeSuplantar;
	}


	
	/**
	 * Sets the value of the attribute {@link #usuarioPuedeSuplantar}.
	 * @param usuarioPuedeSuplantar The value for the attribute {@link #usuarioPuedeSuplantar}.
	 */
	public void setUsuarioPuedeSuplantar(String usuarioPuedeSuplantar) {
	
		this.usuarioPuedeSuplantar = usuarioPuedeSuplantar;
	}
	
	public String getImpStatus() {
		return impStatus;
	}

	public void setImpStatus(String impStatus) {
		this.impStatus = impStatus;
	}



	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return username+","+correoElectronico+","+nombre+","+apellidos+
						","+password+","+birthday+","+activo+","+rol+","+codigoCentro+","+denCentro+
						","+codigoCliente+","+denCliente+","+codigoEmpleado+","+codigoDelegacion+","+
						denDelegacion+","+cif+","+direccion+","+municipio+","+codigoPostal+","+provincia+
						","+telefonoMovil+","+telefonoFijo+","+usuarioPuedeCanjear+","+usuarioPuedeAdministrar+
						","+usuarioPuedeSuplantar+","+impStatus+"\n";
	}

}
