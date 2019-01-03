package com.footballteam.fixtures.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FixturesController {

	@RequestMapping("/fixtures")
	public String showFixturesView(Model model) {
		return "fixtures";
	}
}