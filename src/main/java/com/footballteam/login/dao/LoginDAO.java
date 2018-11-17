package com.footballteam.login.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.registration.model.User;

@Repository
public class LoginDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional

	public boolean userExists(String username) {
		if (entityManager.find(User.class, username) == null)
			return false;
		return true;
	}

	public String getPassword(String username) {
		User user = new User();
		user = entityManager.find(User.class, username);
		return user.getPassword();
	}
}