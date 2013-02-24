package org.home.task.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.home.task.entity.User;

@ManagedBean(name = "login")
@SessionScoped
public class LoginManagedBean implements Serializable {
	private static final long serialVersionUID = 3144870497256690367L;

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
		User user = this.userManagedBean.getByUsername(this.username);
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("User logged-in: " + username);
			return "internal?faces-redirect=true";
		}
		return null;
	}
}
