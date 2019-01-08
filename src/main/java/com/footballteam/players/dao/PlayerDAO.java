package com.footballteam.players.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.footballteam.players.model.Player;

@Repository
public class PlayerDAO {

	@PersistenceContext
	EntityManager entityManager;

	public Player getPlayerById(int playerid) {
		Player player = entityManager.find(Player.class, playerid);
		return player;
	}

	public List<Player> getAllPlayers() {
		List<Player> playersList = entityManager.createQuery("SELECT p FROM Player p").getResultList();
		return playersList;
	}
}