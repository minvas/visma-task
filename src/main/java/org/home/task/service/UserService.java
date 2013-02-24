package org.home.task.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.home.task.entity.User;

public class UserService implements Serializable {
	private static final long serialVersionUID = 6687400456411565560L;

	private static final Map<Integer, User> USERS;

	static {
		USERS = new HashMap<Integer, User>();

		USERS.put(USERS.size(), new User("demo", "demo", "demo@demo.demo", "male"));
		USERS.put(USERS.size(), new User("test", "test", "test@test.test", "female"));
		USERS.put(USERS.size(), new User("abcd", "abcd", "abcd@abcd.abcd", "male"));
	}

	private Integer getNextID() {
		Integer maxID = -1;
		for (Integer id : USERS.keySet()) {
			if (maxID < id) {
				maxID = id;
			}
		}
		return maxID + 1;
	}

	public User getUserByUsername(String username) {
		for (User user : USERS.values()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public void addUser(User user) {
		USERS.put(getNextID(), user);
	}

	public void createUser(String username, String password, String email, String gender) {
		User user = new User(username, password, email, gender);
		addUser(user);
	}

	public void updateUserPassword(String username, String password) {
		for (User user : USERS.values()) {
			if (user.getUsername().equals(username)) {
				user.setPassword(password);
			}
		}
	}

	public Collection<User> getAllUsers() {
		return USERS.values();
	}
}
