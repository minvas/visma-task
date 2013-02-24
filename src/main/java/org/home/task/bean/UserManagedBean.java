package org.home.task.bean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.home.task.service.UserService;

@ManagedBean(name = "user")
@ApplicationScoped
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = 6753231835741060726L;

	private UserService userService = new UserService();

	public void createUser(String username, String password, String email, String gender) {
		this.userService.createUser(username, password, email, gender);
	}

	public void changePassword(String username, String newPassword) {
		this.userService.updateUserPassword(username, newPassword);
	}

	public boolean isUsernameTaken(String username) {
		return userService.userExists(username);
	}

	public boolean authenticate(String username, String password) {
		return userService.authenticate(username, password);
	}

	public void deleteUser(String username) {
		this.userService.deleteUser(username);
	}
}
