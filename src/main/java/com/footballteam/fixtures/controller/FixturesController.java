package com.footballteam.fixtures.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footballteam.fixtures.dto.FixtureFormDTO;
import com.footballteam.registration.dto.RegistrationFormDTO;

@Controller
public class FixturesController {

	private final String ADD_FIXTURE_VIEW_JSP_NAME = "addFixture";

	@RequestMapping("/fixtures")
	public String showFixturesView(Model model) {
		return "fixtures";
	}

	@Secured({ "ROLE_TRAINER", "ROLE_ADMIN" })
	@RequestMapping(value = "/addFixture", method = RequestMethod.GET)
	public String addNewFixture(Model model) {
		model.addAttribute("form", new FixtureFormDTO());
		return ADD_FIXTURE_VIEW_JSP_NAME;
	}
}