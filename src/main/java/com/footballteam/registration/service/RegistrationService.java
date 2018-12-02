package com.footballteam.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.registration.dao.RegistrationDAO;
import com.footballteam.users.model.User;

@Service
public class RegistrationService {
	@Autowired
	RegistrationDAO dao;

	public void addUser(User user) {
		dao.addUser(user);
	}

	public boolean userExists(String username) {
		return dao.userExists(username);
	}
}