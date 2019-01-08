package com.footballteam.users.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.footballteam.players.model.Player;
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
		if (role.equals("ROLE_PLAYER")) {
			Player player;
			try {
			  player = (Player) entityManager.createQuery("Select p From Player p where p.username.username = :username1").setParameter("username1", username).getSingleResult();
			}catch(Exception e) {
			player = new Player();
			player.setPosition("brak");
			player.setMatchesPlayed(0);
			player.setGoalScored(0);
			player.setPreferedFootRight(true);
			player.setShirtNumber(0);
			player.setCardsReceived(0);
			player.setUsername(user);
			entityManager.merge(player);
			 }
		}
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