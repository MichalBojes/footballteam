package com.footballteam.fixtures.controller;

import java.util.ArrayList;
import java.util.List;

import com.footballteam.fixtures.dto.FixtureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.fixtures.dto.FixtureFormDTO;
import com.footballteam.fixtures.dto.MatchDTO;
import com.footballteam.fixtures.model.Match;
import com.footballteam.fixtures.model.Stadium;
import com.footballteam.fixtures.service.FixturesService;
import com.footballteam.players.model.Player;
import com.footballteam.users.model.User;
import com.footballteam.users.service.UsersService;

@Controller
public class FixturesController {

	@Autowired
	FixturesService service;

	@Autowired
	UsersService usersService;

	private static final String ADD_FIXTURE_VIEW_JSP_NAME = "new_fixture";

	@RequestMapping("/fixtures")
	public String showFixturesView(Model model) {
		List<FixtureDTO> fixturesList = service.getAllFixtures();
		model.addAttribute("fixturesList", fixturesList);
		return "fixtures";
	}

	@RequestMapping("/fixture")
	public String showFixtureView(Model model, @RequestParam("id") int fixtureid) {
		List<FixtureDTO> fixturesList = new ArrayList<>();
		FixtureDTO fixture = service.getFixtureById(fixtureid);
		fixturesList.add(fixture);
		model.addAttribute("fixturesList", fixturesList);
		return "fixtures";
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/addFixture", method = RequestMethod.GET)
	public String addNewFixture(Model model) {
		List<Stadium> stadiumsList = service.getAllStadiums();
		model.addAttribute("form", new FixtureFormDTO());
		model.addAttribute("stadiums", stadiumsList);
		return ADD_FIXTURE_VIEW_JSP_NAME;
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/addFixture", method = RequestMethod.POST)
	public String confirmAddNewFixture(@ModelAttribute("form") FixtureFormDTO form) {
		service.addNewFixture(form);
		return "redirect:/fixtures";
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/match", method = RequestMethod.GET)
	public String setSquadForMatch(Model model, @RequestParam("id") int fixtureid) {
		FixtureDTO fixture = service.getFixtureById(fixtureid);
		MatchDTO match = new MatchDTO();
		match.setFixtureid(fixtureid);
		List<Match> selectedPlayers = service.getSelectedPlayers(fixtureid);
		List<Player> avaliablePlayers = service.getAvaliablePlayers(fixtureid);
		model.addAttribute("fixture", fixture);
		model.addAttribute("selectedPlayers", selectedPlayers);
		model.addAttribute("avaliablePlayers", avaliablePlayers);
		model.addAttribute("match", match);
		return "match_view";
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/addPlayerToMatch", method = RequestMethod.POST)
	public String confirmAddPlayerToMatch(@ModelAttribute("match") MatchDTO match) {
		User user = usersService.getUserByUsername(match.getUsername());
		match.setUser(user);
		service.addPlayerToMatch(match);
		return "redirect:/match?id=" + match.getFixtureid();
	}
}