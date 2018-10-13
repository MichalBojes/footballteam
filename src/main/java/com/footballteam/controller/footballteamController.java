package com.footballteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FootballteamController {

	private static final String FIRST_VIEW_JSP_NAME = "first_view";

	@RequestMapping("/first/view")
	public String showFirstView(Model model) {
		return FIRST_VIEW_JSP_NAME;
	}

}
