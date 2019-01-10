package com.footballteam.trainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.fixtures.model.Fixture;
import com.footballteam.fixtures.service.FixturesService;
import com.footballteam.trainer.service.TrainerService;

@Secured(value = "ROLE_TRAINER")
@Controller
public class TrainerController {
	@Autowired
	TrainerService service;
	
	@Autowired
	FixturesService fixturesService;
	
	@RequestMapping("/match")
	public String showMatchSquadView(Model model, @RequestParam ("id") int id) {
		
		return "fixtures";
	}
	
}