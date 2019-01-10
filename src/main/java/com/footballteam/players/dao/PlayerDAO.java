package com.footballteam.players.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.fixtures.model.Fixture;
import com.footballteam.players.dto.ContractDTO;
import com.footballteam.players.dto.PlayerDTO;
import com.footballteam.players.dto.UnavailabilityDTO;
import com.footballteam.players.model.Contract;
import com.footballteam.players.model.Match;
import com.footballteam.players.model.Player;
import com.footballteam.players.model.Unavailability;

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
		Date date = new Date();
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(contractDTO.getStartDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		contract.setStartDate(date);
		contract.setDurationInMonths(contractDTO.getDurationInMonths());
		contract.setSalary(contractDTO.getSalary());
		contract.setExtras(contractDTO.getExtras());
		entityManager.merge(contract);
	}

	public List<Unavailability> getUnavailabilities(int id) {
		List<Unavailability> unavailabilityList = entityManager
				.createQuery("SELECT u FROM Unavailability u where u.player.playerid = :playerid1")
				.setParameter("playerid1", id).getResultList();
		return unavailabilityList;
	}

	@Transactional
	public void addUnavailability(UnavailabilityDTO unavailabilityDTO) {
		Unavailability unavailability = new Unavailability();
		Player player = entityManager.find(Player.class, unavailabilityDTO.getPlayer().getPlayerid());
		unavailability.setPlayer(player);
		Date date = new Date();
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(unavailabilityDTO.getOccurreDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		unavailability.setOccurreDate(date);
		unavailability.setReason(unavailabilityDTO.getReason());
		unavailability.setDurationInDays(unavailabilityDTO.getDurationInDays());
		Fixture fixture = entityManager.find(Fixture.class, unavailabilityDTO.getFixture().getFixtureid());
		unavailability.setFixture(fixture);
		entityManager.merge(unavailability);
	}
}