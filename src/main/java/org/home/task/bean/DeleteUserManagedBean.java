package org.home.task.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name = "deleteUser")
public class DeleteUserManagedBean {
	@ManagedProperty(value = "#{user}")
	private UserManagedBean userManagedBean;

	@ManagedProperty(value = "#{login}")
	private LoginManagedBean loginManagedBean;

	private String username;
	private String password;

	public LoginManagedBean getLoginManagedBean() {
		return loginManagedBean;
	}

	public void setLoginManagedBean(LoginManagedBean loginManagedBean) {
		this.loginManagedBean = loginManagedBean;
	}

	public UserManagedBean getUserManagedBean() {
		return userManagedBean;
	}

	public void setUserManagedBean(UserManagedBean userManagedBean) {
		this.userManagedBean = userManagedBean;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String delete() {
		if (username.equals(loginManagedBean.getUsername())) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "You cannot delete yourself.", null));
		} else if (this.userManagedBean.authenticate(username, password)) {
			this.userManagedBean.deleteUser(username);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "User was deleted successfully.", null));

			this.username = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "User does not exist.", null));
		}
		return null;
	}

}
