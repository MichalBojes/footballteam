package com.footballteam.login.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginView(Model model) {
		return "login";
	}
}