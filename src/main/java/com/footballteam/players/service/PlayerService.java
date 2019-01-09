package com.footballteam.players.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.players.dao.PlayerDAO;
import com.footballteam.players.dto.ContractDTO;
import com.footballteam.players.dto.PlayerDTO;
import com.footballteam.players.dto.UnavailabilityDTO;
import com.footballteam.players.model.Contract;
import com.footballteam.players.model.Player;

@Service
public class PlayerService {
	@Autowired
	PlayerDAO dao;

	public void addUnavailability(String username, UnavailabilityDTO form) {
	}

	public Player getPlayerById(int playerid) {
		return dao.getPlayerById(playerid);
	}

	public List<Player> getAllPlayers() {
		return dao.getAllPlayers();
	}

	public void editStats(PlayerDTO playerDTO) {
		dao.editStats(playerDTO);
	}

	public Contract getContractById(int playerid) {
		return dao.getContractById(playerid);
	}

	public void editContract(ContractDTO contractDTO) {
		dao.editContract(contractDTO);
	}
}