package com.footballteam.training.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.footballteam.repository.model.Stadium;

@Controller
public class TrainingController {

	@Autowired
	TrainingService service;

	private static final String ADD_TRAINING_VIEW_JSP_NAME = "add_training";

	@RequestMapping("/trainings")
	public String showTrainingsView(Model model) {
		List<TrainingDTO> training = service.getAllTrainings();
		model.addAttribute("fixturesList", trainingsList);
		return "fixtures";
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/addTraining", method = RequestMethod.GET)
	public String addNewTraining(Model model) {
		List<Stadium> stadiumsList = service.getAllStadiums();
		model.addAttribute("form", new TrainingDTO());
		model.addAttribute("stadiums", stadiumsList);
		return ADD_TRAINING_VIEW_JSP_NAME;
	}

	@Secured(value = "ROLE_TRAINER")
	@RequestMapping(value = "/addTraining", method = RequestMethod.POST)
	public String confirmAddNewTraining(@ModelAttribute("form") TrainingDTO form) {
		service.addNewTraining(form);
		return "redirect:/trainings";
	}
}