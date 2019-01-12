package com.footballteam.training.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.fixtures.dto.FixtureDTO;
import com.footballteam.fixtures.dto.MatchDTO;
import com.footballteam.fixtures.model.Match;
import com.footballteam.fixtures.model.Stadium;
import com.footballteam.fixtures.service.FixturesService;
import com.footballteam.players.model.Player;
import com.footballteam.players.service.PlayerService;
import com.footballteam.training.dto.PlayerTrainingDTO;
import com.footballteam.training.dto.TrainingDTO;
import com.footballteam.training.model.PlayerTraining;
import com.footballteam.training.service.TrainingService;
import com.footballteam.users.model.User;
import com.footballteam.users.service.UsersService;

@Controller
public class TrainingController {

	@Autowired
	TrainingService service;

	@Autowired
	PlayerService playerService;

	@Autowired
	FixturesService fixturesService;

	private static final String ADD_TRAINING_VIEW_JSP_NAME = "add_training";

	@RequestMapping("/trainings")
	public String showTrainingsView(Model model) {
		List<TrainingDTO> trainingsList = service.getAllTrainings();
		model.addAttribute("trainingsList", trainingsList);
		return "trainings_view";
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/addTraining", method = RequestMethod.GET)
	public String addNewTraining(Model model) {
		List<Stadium> stadiumsList = service.getAllStadiums();
		TrainingDTO form = new TrainingDTO();
		DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
		form.setData(outputFormatter.format(new Date()));
		model.addAttribute("form", form);
		model.addAttribute("stadiums", stadiumsList);
		return ADD_TRAINING_VIEW_JSP_NAME;
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/addTraining", method = RequestMethod.POST)
	public String confirmAddNewTraining(@ModelAttribute("form") TrainingDTO form) {
		service.addNewTraining(form);
		return "redirect:/trainings";
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/training", method = RequestMethod.GET)
	public String setSquadForMatch(Model model, @RequestParam("id") int trainingid) {
		TrainingDTO training = service.getTrainingById(trainingid);
		PlayerTrainingDTO trainingDTO = new PlayerTrainingDTO();
		training.setTrainingid(trainingid);
		List<PlayerTraining> selectedPlayers = service.getSelectedPlayers(trainingid);
		List<Player> avaliablePlayers = service.getAvaliablePlayers(trainingid);
		model.addAttribute("trainingDTO", trainingDTO);
		model.addAttribute("selectedPlayers", selectedPlayers);
		model.addAttribute("avaliablePlayers", avaliablePlayers);
		model.addAttribute("training", training);
		return "training_view";
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/addPlayerToTraining", method = RequestMethod.POST)
	public String confirmAddPlayerToMatch(@ModelAttribute("trainingDTO") PlayerTrainingDTO training) {
		Player player = playerService.getPlayerById(training.getPlayerid());
		training.setPlayer(player);
		service.addPlayerToTraining(training);
		return "redirect:/training?id=" + training.getTrainingid();
	}

}