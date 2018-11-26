package com.footballteam.players.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayersController {
	@RequestMapping("/squad")
	public String showAllPlayers(Model model) {
		return "squad";
	}
}