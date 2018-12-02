package com.footballteam.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.registration.dao.RegistrationDAO;
import com.footballteam.registration.model.User;

@Service
public class UsersService {
	@Autowired
	RegistrationDAO dao;

	public void addUser(User user) {
		dao.addUser(user);
	}

	public boolean userExists(String username) {
		return dao.userExists(username);
	}
}