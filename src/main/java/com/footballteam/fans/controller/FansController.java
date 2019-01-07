package com.footballteam.fans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.footballteam.fans.service.FansService;
import com.footballteam.fixtures.model.Fixture;
import com.footballteam.fixtures.service.FixturesService;

@Controller
public class FansController {
	@Autowired
	FixturesService fixturesService;
	
	@Autowired
	FansService fansService;

	@RequestMapping("/fans/gallery")
	public String showFansGalleryView(Model model) {
		return "fans";
	}

	@RequestMapping("/fans")
	public String showFansView(Model model) {
		List<Fixture> fixturesList = fixturesService.getAllFixtures();
		model.addAttribute("fixtures", fixturesList);
		return "fansFixtures";
	}

	@RequestMapping("/declarePresence/{id}")
	public String showFansGalleryView(Model model, @PathVariable("id") int fixtureId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		fansService.declarePresence(fixtureId, username);
		return "redirect:/fans/gallery";
	}

}