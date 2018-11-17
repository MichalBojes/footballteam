package com.footballteam.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.registration.dto.RegistrationFormDTO;
import com.footballteam.registration.model.User;
import com.footballteam.registration.service.RegistrationService;
import com.footballteam.login.dto.LoginFormDTO;
import com.footballteam.login.service.LoginService;
import com.footballteam.login.validator.LoginValidator;
import com.footballteam.recaptcha.service.RecaptchaService;
import com.footballteam.registration.validator.RegistrationValidator;

@Controller
public class LoginController {

	@Autowired
	LoginValidator validator;

	@Autowired
	LoginService service;

	private static final String LOGIN_VIEW_JSP_NAME = "login";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showRegisterView(Model model) {
		model.addAttribute("form", new RegistrationFormDTO());
		return LOGIN_VIEW_JSP_NAME;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String confirmRegistration(@ModelAttribute("form") LoginFormDTO form, BindingResult result,
		 HttpServletRequest request) {
		validator.validate(form, result);
		if (result.hasErrors()) {
			return LOGIN_VIEW_JSP_NAME;
		}
		return "redirect:/my_profile";

	}

}
