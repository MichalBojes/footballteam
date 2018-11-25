package com.footballteam.squad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SquadController {
	@RequestMapping("/squad")
	public String showSquadView(Model model) {
		return "squad";
	}
}