package com.footballteam.registration.service;

import com.footballteam.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.registration.dao.RegistrationDAO;
import com.footballteam.registration.model.User;

import java.util.List;

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