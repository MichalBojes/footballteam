package com.footballteam.fans.controller;

import java.util.List;

import com.footballteam.fixtures.dto.FixtureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.fans.service.FansService;
import com.footballteam.fixtures.model.Fixture;
import com.footballteam.fixtures.service.FixturesService;
import com.footballteam.players.model.Match;

@Controller
public class FansController {
	@Autowired
	FixturesService fixturesService;
	
	@Autowired
	FansService fansService;

	@RequestMapping("/fans_gallery")
	public String showFansGalleryView(Model model) {
		return "fans_gallery";
	}

	@RequestMapping("/persenceFans")
	public String showFansView(Model model, @RequestParam("id") int fixtureid) {
		FixtureDTO fixture = fixturesService.getFixtureById(fixtureid);
		List <String> matches = fansService.getMatchesByFixture(fixtureid);
		model.addAttribute("fixture", fixture);
		model.addAttribute("matches", matches);
		return "persence_fans_view";
	}

	@RequestMapping("/declarePresence")
	public String declarePersence(Model model, @RequestParam("id") int fixtureId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		fansService.declarePresence(fixtureId, username);
		return "redirect:/persenceFans?id="+fixtureId;
	}

}