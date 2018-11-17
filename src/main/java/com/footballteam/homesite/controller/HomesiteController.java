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
	
	@RequestMapping("/squad")
	public String showSquadView(Model model) {
		return "squad";
	}
	
	@RequestMapping("/fixtures")
	public String showFixturesView(Model model) {
		return "fixtures";
	}
	@RequestMapping("/authorities")
	public String showAuthoritiesView(Model model) {
		return "authorities";
	}
	@RequestMapping("/history")
	public String showHistoryView(Model model) {
		return "history";
	}
	@RequestMapping("/fans")
	public String showFansView(Model model) {
		return "fans";
	
	
	
}
