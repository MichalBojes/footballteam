package com.footballteam.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footballteam.login.dto.LoginFormDTO;
import com.footballteam.login.service.LoginService;
import com.footballteam.login.validator.LoginValidator;

@Controller
public class LoginController {

	@Autowired
	LoginValidator validator;

	@Autowired
	LoginService service;

	private static final String LOGIN_VIEW_JSP_NAME = "login";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginView(Model model) {
		model.addAttribute("form", new LoginFormDTO());
		return LOGIN_VIEW_JSP_NAME;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String confirmLogin(//@ModelAttribute("form") LoginFormDTO form,
			BindingResult result,
		 HttpServletRequest request) {
		//validator.validate(form, result);
		if (result.hasErrors()) {
			return LOGIN_VIEW_JSP_NAME;
		}
		return "redirect:/my_profile";

	}

}
