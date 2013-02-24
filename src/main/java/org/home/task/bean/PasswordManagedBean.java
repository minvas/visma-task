package org.home.task.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name = "password")
public class PasswordManagedBean {

	@ManagedProperty(value = "#{user}")
	private UserManagedBean userManagedBean;

	@ManagedProperty(value = "#{login}")
	private LoginManagedBean loginManagedBean;

	private String currentPassword;
	private String newPassword1;
	private String newPassword2;

	public UserManagedBean getUserManagedBean() {
		return userManagedBean;
	}

	public void setUserManagedBean(UserManagedBean userManagedBean) {
		this.userManagedBean = userManagedBean;
	}

	public LoginManagedBean getLoginManagedBean() {
		return loginManagedBean;
	}

	public void setLoginManagedBean(LoginManagedBean loginManagedBean) {
		this.loginManagedBean = loginManagedBean;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	public String changePassword() {
		if (!userManagedBean.authenticate(this.loginManagedBean.getUsername(), this.currentPassword)) {
			FacesContext.getCurrentInstance().addMessage("passwordChangeForm:currentPassword",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password is not correct", null));
			return null;
		} else {
			userManagedBean.changePassword(this.loginManagedBean.getUsername(), this.newPassword1);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Password was changed successfully.", null));
		}

		return null;
	}
}
