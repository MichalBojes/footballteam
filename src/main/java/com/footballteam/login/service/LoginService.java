package com.footballteam.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.login.dao.LoginDAO;

@Service
public class LoginService {
	@Autowired
	LoginDAO dao;

	public boolean userExists(String username) {
		return dao.userExists(username);
	}
	public String getPassword(String username) {
		return dao.getPassword(username);
	}
}