package com.footballteam.registration.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.users.model.User;

@Repository
public class RegistrationDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void addUser(User user) {
		entityManager.merge(user);
	}

	public boolean userExists(String username) {
		if (entityManager.find(User.class, username) == null)
			return false;
		return true;
	}
}