package com.footballteam.players.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.players.dto.PlayerDTO;
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

	@Transactional
	public void editStats(PlayerDTO playerDTO) {
		System.out.println(playerDTO.toString());
		Player player = entityManager.find(Player.class, playerDTO.getPlayerid());
		player.setPosition(playerDTO.getPosition());
		player.setMatchesPlayed(playerDTO.getMatchesPlayed());
		player.setGoalScored(playerDTO.getGoalScored());
		player.setPreferedFootRight(playerDTO.isPreferedFootRight());
		player.setShirtNumber(playerDTO.getShirtNumber());
		player.setCardsReceived(playerDTO.getCardsReceived());
		entityManager.merge(player);
	}
}