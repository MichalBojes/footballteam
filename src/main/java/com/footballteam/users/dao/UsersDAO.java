package com.footballteam.users.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.registration.model.User;

@Repository
public class UsersDAO {

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