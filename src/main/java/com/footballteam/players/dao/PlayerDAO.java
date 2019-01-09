package com.footballteam.players.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.players.dto.ContractDTO;
import com.footballteam.players.dto.PlayerDTO;
import com.footballteam.players.model.Contract;
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
		Player player = entityManager.find(Player.class, playerDTO.getPlayerid());
		player.setPosition(playerDTO.getPosition());
		player.setMatchesPlayed(playerDTO.getMatchesPlayed());
		player.setGoalScored(playerDTO.getGoalScored());
		player.setPreferedFootRight(playerDTO.isPreferedFootRight());
		player.setShirtNumber(playerDTO.getShirtNumber());
		player.setCardsReceived(playerDTO.getCardsReceived());
		entityManager.merge(player);
	}

	public Contract getContractById(int playerid) {
		Contract contract = entityManager.find(Contract.class, playerid);
		return contract;
	}

	@Transactional
	public void editContract(ContractDTO contractDTO) {
		Contract contract = entityManager.find(Contract.class, contractDTO.getPlayerid());
		contract.setValue(contractDTO.getValue());
		contract.setStartDate(contractDTO.getStartDate());
		contract.setDurationInMonths(contractDTO.getDurationInMonths());
		contract.setSalary(contractDTO.getSalary());
		contract.setExtras(contractDTO.getExtras());
		entityManager.merge(contract);
	}
}