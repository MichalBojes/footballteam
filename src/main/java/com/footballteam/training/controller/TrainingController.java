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

import com.footballteam.repository.model.Stadium;
import com.footballteam.training.dto.TrainingDTO;
import com.footballteam.training.service.TrainingService;

@Controller
public class TrainingController {

	@Autowired
	TrainingService service;

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
}