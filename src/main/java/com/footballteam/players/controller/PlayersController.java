package com.footballteam.players.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.fixtures.dto.FixtureDTO;
import com.footballteam.fixtures.model.Fixture;
import com.footballteam.fixtures.service.FixturesService;
import com.footballteam.players.dto.ContractDTO;
import com.footballteam.players.dto.PlayerDTO;
import com.footballteam.players.dto.UnavailabilityDTO;
import com.footballteam.players.model.Contract;
import com.footballteam.players.model.Player;
import com.footballteam.players.model.Unavailability;
import com.footballteam.players.service.PlayerService;

@Controller
public class PlayersController {
	@Autowired
	PlayerService service;

	@Autowired
	FixturesService fixturesService;

	@RequestMapping("/squad")
	public String showAllPlayers(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		List<Player> players = service.getAllPlayers();
		model.addAttribute("players", players);
		model.addAttribute("username", username);
		return "squad";
	}

	@RequestMapping("/stats")
	public String showPlayerStats(Model model, @RequestParam("id") int playerid) {
		Player player = service.getPlayerById(playerid);
		model.addAttribute("player", player);
		return "stats_view";
	}

	@Secured({ "ROLE_TRAINER", "ROLE_ADMIN" })
	@RequestMapping("/editStats")
	public String showEditStatsView(Model model, @RequestParam("id") int playerid) {
		Player player = service.getPlayerById(playerid);
		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setPlayerid(playerid);
		playerDTO.setUsername(player.getUsername());
		playerDTO.setPosition(player.getPosition());
		playerDTO.setMatchesPlayed(player.getMatchesPlayed());
		playerDTO.setGoalScored(player.getGoalScored());
		playerDTO.setPreferedFootRight(player.isPreferedFootRight());
		playerDTO.setShirtNumber(player.getShirtNumber());
		playerDTO.setCardsReceived(player.getCardsReceived());
		model.addAttribute("playerDTO", playerDTO);
		return "edit_stats";
	}

	@Secured({ "ROLE_TRAINER", "ROLE_ADMIN" })
	@RequestMapping(value = "/confirmEditStats", method = RequestMethod.POST)
	public String confirmEditStats(@ModelAttribute("playerDTO") PlayerDTO playerDTO) {
		service.editStats(playerDTO);
		return "redirect:/squad";
	}

	@RequestMapping("/contract")
	public String showPlayerContract(Model model, @RequestParam("id") int playerid) {
		Contract contract = service.getContractById(playerid);
		ContractDTO contractDTO = new ContractDTO();
		contractDTO.setPlayerid(playerid);
		contractDTO.setValue(contract.getValue());
		Date date = contract.getStartDate();
		DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
		contractDTO.setStartDate(outputFormatter.format(date));
		contractDTO.setDurationInMonths(contract.getDurationInMonths());
		contractDTO.setSalary(contract.getSalary());
		contractDTO.setExtras(contract.getExtras());
		Player player = service.getPlayerById(playerid);
		model.addAttribute("contract", contractDTO);
		model.addAttribute("player", player);
		return "contract_view";
	}

	@Secured({ "ROLE_TRAINER", "ROLE_ADMIN" })
	@RequestMapping("/editContract")
	public String showEditContractView(Model model, @RequestParam("id") int playerid) {
		Player player = service.getPlayerById(playerid);
		Contract contract = service.getContractById(playerid);
		ContractDTO contractDTO = new ContractDTO();
		contractDTO.setPlayerid(playerid);
		contractDTO.setValue(contract.getValue());
		Date date = contract.getStartDate();
		DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
		contractDTO.setStartDate(outputFormatter.format(date));
		contractDTO.setDurationInMonths(contract.getDurationInMonths());
		contractDTO.setSalary(contract.getSalary());
		contractDTO.setExtras(contract.getExtras());
		model.addAttribute("contractDTO", contractDTO);
		model.addAttribute("player", player);
		return "edit_contract";
	}

	@Secured({ "ROLE_TRAINER", "ROLE_ADMIN" })
	@RequestMapping(value = "/confirmEditContract", method = RequestMethod.POST)
	public String confirmEditContract(@ModelAttribute("contractDTO") ContractDTO contractDTO) {
		service.editContract(contractDTO);
		return "redirect:/squad";
	}

	@Secured({ "ROLE_PLAYER", "ROLE_TRAINER" })
	@RequestMapping(value = "/unavailability")
	public String showUnavailabilityView(Model model, @RequestParam("id") int playerid) {
		Player player = service.getPlayerById(playerid);
		List<Unavailability> unavailabilities = service.getUnavailabilities(playerid);
		List<UnavailabilityDTO> unavailabilitiesDTO;
		if (unavailabilities.isEmpty()) {
			unavailabilitiesDTO = null;
		} else {
			UnavailabilityDTO unavailabilityDTO;
			unavailabilitiesDTO = new ArrayList<UnavailabilityDTO>();
			for (Unavailability unavailability : unavailabilities) {
				unavailabilityDTO = new UnavailabilityDTO();
				unavailabilityDTO.setUnavailabilityid(unavailability.getUnavailabilityid());
				unavailabilityDTO.setPlayer(player);
				Date date = unavailability.getOccurreDate();
				DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
				unavailabilityDTO.setOccurreDate(outputFormatter.format(date));
				unavailabilityDTO.setReason(unavailability.getReason());
				unavailabilityDTO.setDurationInDays(unavailability.getDurationInDays());
				unavailabilityDTO.setFixture(unavailability.getFixture());
				unavailabilitiesDTO.add(unavailabilityDTO);
			}
		}
		model.addAttribute("unavailabiltiesDTO", unavailabilitiesDTO);
		return "unavailability_view";
	}

	@Secured({ "ROLE_PLAYER", "ROLE_TRAINER" })
	@RequestMapping(value = "/addUnavailability")
	public String showAddUnavailabilityView(Model model, @RequestParam("id") int playerid) {
		Player player = service.getPlayerById(playerid);
		UnavailabilityDTO unavailabilityDTO = new UnavailabilityDTO();
		unavailabilityDTO.setPlayer(player);
		DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
		unavailabilityDTO.setOccurreDate(outputFormatter.format(new Date()));
		List<FixtureDTO> fixturesList = fixturesService.getAllFixtures();
		model.addAttribute("fixturesList", fixturesList);
		model.addAttribute("unavailabilityDTO", unavailabilityDTO);
		return "add_unavailability";
	}

	@Secured({ "ROLE_PLAYER", "ROLE_TRAINER" })
	@RequestMapping(value = "/confirmUnavailability", method = RequestMethod.POST)
	public String confirmUnavailability(@ModelAttribute("unavailabilityDTO") UnavailabilityDTO unavailabilityDTO) {
		service.addUnavailability(unavailabilityDTO);
		return "redirect:/squad";
	}

}