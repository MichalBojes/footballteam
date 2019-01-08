package com.footballteam.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.players.dto.PlayerDTO;
import com.footballteam.players.dto.UnavailabilityDTO;
import com.footballteam.players.model.Player;
import com.footballteam.players.service.PlayerService;
import com.footballteam.users.model.User;

@Controller
public class PlayersController {
	@Autowired
	PlayerService service;

	@RequestMapping("/squad")
	public String showAllPlayers(Model model) {
		List<Player> players = service.getAllPlayers();
		model.addAttribute("players", players);
		return "squad";
	}

	@RequestMapping("/stats")
	public String showAllPlayerStats(Model model, @RequestParam("id") int playerid) {
		Player player = service.getPlayerById(playerid);
		model.addAttribute("player", player);
		return "stats_view";
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping("/editStats")
	public String showEditStatsView(Model model, @RequestParam("id") int playerid) {
		Player player = service.getPlayerById(playerid);
		PlayerDTO playerDTO=new PlayerDTO();
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

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/confirmEditStats", method = RequestMethod.POST)
	public String confirmEditStats(@ModelAttribute("playerDTO") PlayerDTO playerDTO) {
		service.editStats(playerDTO);
		return "redirect:/squad";
	}

	@Secured({ "ROLE_PLAYER", "ROLE_TRAINER" })
	@RequestMapping(value = "/unavailability")
	public String showUnavailabilityView(Model model, @RequestParam("username") String username) {
		model.addAttribute("username", username);
		return "unavailability";
	}

	@Secured({ "ROLE_PLAYER", "ROLE_TRAINER" })
	@RequestMapping(value = "/confirmUnavailability/{id}", method = RequestMethod.POST)
	public String confirmUnavailability(@ModelAttribute("form") UnavailabilityDTO form,
			@PathVariable("id") String username) {
		service.addUnavailability(username, form);
		return "redirect:/unavailability";
	}

}