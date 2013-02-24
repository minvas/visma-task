package org.home.task.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.home.task.entity.User;
import org.home.task.service.UserService;

@ManagedBean(name = "user")
@ApplicationScoped
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = 6753231835741060726L;

	private UserService userService = new UserService();

	public void createUser(String username, String password, String email) {
		this.userService.createUser(username, password, email);
	}

	public void changePassword(String username, String newPassword) {
		this.userService.updateUserPassword(username, newPassword);
	}

	public User getByUsername(String username) {
		return this.userService.getUserByUsername(username);
	}

	public Collection<User> getUsers() {
		return this.userService.getAllUsers();
	}
}
