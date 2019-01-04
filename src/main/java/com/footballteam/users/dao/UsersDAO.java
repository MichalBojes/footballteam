package com.footballteam.users.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.users.model.User;

@Repository
public class UsersDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void addUser(User user) {
		entityManager.merge(user);
	}

	@Transactional
	public void changeRole(String username, String role) {
		User user = entityManager.find(User.class, username);
		user.setRole(role);
		entityManager.merge(user);
	}

	@Transactional
	public void deleteUser(String username) {
		User user = entityManager.find(User.class, username);
		entityManager.remove(user);
	}

	public boolean userExists(String username) {
		return entityManager.find(User.class, username) != null;
	}

	public List<User> getAllUsers() {
		Query query = entityManager.createQuery("SELECT u FROM User u");
		List<User> usersList = query.getResultList();
		return usersList;
	}
}