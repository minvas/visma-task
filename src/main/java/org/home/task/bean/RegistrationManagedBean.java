package org.home.task.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.home.task.entity.User;

@ManagedBean(name = "registration")
public class RegistrationManagedBean {

	@ManagedProperty(value = "#{user}")
	private UserManagedBean userManagedBean;

	private String username;
	private String email;
	private String password1;
	private String password2;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	private void clear() {
		this.email = null;
		this.username = null;
	}

	public String register() {
		User user = this.userManagedBean.getByUsername(this.username);
		if (user != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "This username was taken by someone else.", null));
		} else {
			this.userManagedBean.createUser(this.username, this.password1, this.email);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration completed successfully.", null));
			clear();
		}
		return null;
	}
}
