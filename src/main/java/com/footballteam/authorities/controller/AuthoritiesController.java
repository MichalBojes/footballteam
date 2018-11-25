package com.footballteam.authorities.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthoritiesController {

	@RequestMapping("/authorities")
	public String showAuthoritiesView(Model model) {
		return "authorities";
	}
}