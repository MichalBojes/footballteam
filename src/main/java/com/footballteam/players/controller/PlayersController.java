package com.footballteam.players.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footballteam.players.dto.UnavailabilityDTO;
import com.footballteam.players.service.PlayerService;

@Controller
public class PlayersController {
	@Autowired
	PlayerService service;

	@RequestMapping("/squad")
	public String showAllPlayers(Model model) {
		return "squad";
	}

	@Secured({ "ROLE_PLAYER", "ROLE_TRAINER" })
	@RequestMapping(value = "/unavailability/{id}", method = RequestMethod.GET)
	public String showUnavailabilityView(Model model, @PathVariable("id") String username) {
		model.addAttribute("username", username);
		return "unavailability";
	}

	@Secured({ "ROLE_PLAYER", "ROLE_TRAINER" })
	@RequestMapping(value = "/unavailability/{id}", method = RequestMethod.POST)
	public String confirmRegistration(@ModelAttribute("form") UnavailabilityDTO form,
			@PathVariable("id") String username) {
		service.addUnavailability(username, form);
		return "redirect:/unavailability";
	}

}