package org.home.task.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "login")
@SessionScoped
public class LoginManagedBean implements Serializable {
	private static final long serialVersionUID = 3144870497256690367L;

	public static final String AUTH_KEY = "username";

	@ManagedProperty(value = "#{user}")
	private UserManagedBean userManagedBean;

	private String username;
	private String password;

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

	public String login() {
		if (this.userManagedBean.authenticate(username, password)) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, username);
			return "internal?faces-redirect=true";
		}
		return null;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";
	}
}
