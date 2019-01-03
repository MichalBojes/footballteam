package com.footballteam.homesite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.footballteam.homesite.model.News;
import com.footballteam.homesite.service.HomesiteService;

@Controller
public class HomesiteController {

	@Autowired
	HomesiteService service;

	private static final String HOMESITE_JSP_NAME = "homesite";

	@RequestMapping("/")
	public String showDefaultView(Model model) {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String showHomesiteView(Model model) {
		List<News> newsList = service.getAllNews();
		model.addAttribute("news", newsList);
		return HOMESITE_JSP_NAME;
	}

}
