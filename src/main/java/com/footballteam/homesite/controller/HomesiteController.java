package com.footballteam.homesite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomesiteController {

	private static final String HOMESITE_JSP_NAME = "homesite";

	@RequestMapping("/")
	public String showDefaultView(Model model) {
		return "redirect:/home";
	}
	
	@RequestMapping("/my_profile")
	public String shoMyProfileView(Model model) {
		return "redirect:/my_profile";
	}
	
	@RequestMapping("/home")
	public String showHomesiteView(Model model) {
		return HOMESITE_JSP_NAME;
	}
}
