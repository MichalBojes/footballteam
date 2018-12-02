package com.footballteam.users.service;

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

	public boolean userExists(String username) {
		return dao.userExists(username);
	}
}