package com.footballteam.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.users.dao.UsersDAO;
import com.footballteam.users.model.User;

@Service
public class UsersService {
	@Autowired
	UsersDAO dao;

	public void addUser(User user) {
		dao.addUser(user);
	}

	public void deleteUser(String username) {
		dao.deleteUser(username);
	}

	public void changeRole(String username, String role) {
		dao.changeRole(username, role);
	}

	public boolean userExists(String username) {
		return dao.userExists(username);
	}

	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	public User getUserByUsername(String username) {
		return dao.getUserByUsername(username);
	}
}