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

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 * This class serves as a bean that remembers the rendered/non-rendered state of the list and form in the users.xhtml
 * Facelet view.
 *
 * @author  Neil Griffin
 */
@ManagedBean(name = "usersViewBean")
@ViewScoped
public class UsersViewBean implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 3791285914294079003L;

	// Private Data Members
	private boolean formRendered = false;
	
	private boolean updateRendered = false;
	
	private boolean resultRendered = false;
	
	private boolean selectable = false;
	
	private boolean editable = false;
	
	private boolean impersonatable = false;
	
	private boolean clienteVisible = false;
	
	private boolean centroVisible = false;
	
	private boolean empleadoVisible = false;
	
	private boolean delegacionVisible = false;
	
	private boolean viewMode = false;
	
	private boolean canMakeImpersonatable = false;
	
	private boolean canEditDistribuidor = false;
	
	private boolean activable = false;
	
	private boolean removable = false;
	
	public boolean isFindMode() {
		return findMode;
	}

	public void setFindMode(boolean findMode) {
		this.findMode = findMode;
	}

	private boolean findMode = true;
	
	public boolean isViewMode() {
		return viewMode;
	}

	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}

	public boolean isClienteVisible() {
		return clienteVisible;
	}

	public void setClienteVisible(boolean clienteVisible) {
		this.clienteVisible = clienteVisible;
	}

	public boolean isCentroVisible() {
		return centroVisible;
	}

	public void setCentroVisible(boolean centroVisible) {
		this.centroVisible = centroVisible;
	}

	public boolean isEmpleadoVisible() {
		return empleadoVisible;
	}

	public void setEmpleadoVisible(boolean empleadoVisible) {
		this.empleadoVisible = empleadoVisible;
	}

	public boolean isDelegacionVisible() {
		return delegacionVisible;
	}

	public void setDelegacionVisible(boolean delegacionVisible) {
		this.delegacionVisible = delegacionVisible;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isImpersonatable() {
		return impersonatable;
	}

	public void setImpersonatable(boolean impersonatable) {
		this.impersonatable = impersonatable;
	}

	public boolean isRemovable() {
		return removable;
	}

	public void setRemovable(boolean removable) {
		this.removable = removable;
	}

	public boolean isResultRendered() {
		return resultRendered;
	}

	public void setResultRendered(boolean resultRendered) {
		this.resultRendered = resultRendered;
	}

	public boolean isUpdateRendered() {
		return updateRendered;
	}

	public void setUpdateRendered(boolean updateRendered) {
		this.updateRendered = updateRendered;
	}

	public boolean isFormRendered() {
		return formRendered;
	}

	public void setFormRendered(boolean formRendered) {
		this.formRendered = formRendered;
	}

	public boolean isCanMakeImpersonatable() {
		return canMakeImpersonatable;
	}

	public void setCanMakeImpersonatable(boolean canMakeImpersonatable) {
		this.canMakeImpersonatable = canMakeImpersonatable;
	}

	public boolean isActivable() {
		return activable;
	}

	public void setActivable(boolean activable) {
		this.activable = activable;
	}

	public boolean isCanEditDistribuidor() {
		return canEditDistribuidor;
	}

	public void setCanEditDistribuidor(boolean canEditDistribuidor) {
		this.canEditDistribuidor = canEditDistribuidor;
	}
}