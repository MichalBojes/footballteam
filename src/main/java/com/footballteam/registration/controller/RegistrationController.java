package com.footballteam.registration.controller;

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
import com.footballteam.recaptcha.service.RecaptchaService;
import com.footballteam.registration.validator.RegistrationValidator;

@Controller
public class RegistrationController {
	@Autowired
	RecaptchaService captchaService;

	@Autowired
	RegistrationValidator validator;

	@Autowired
	RegistrationService service;

	private static final String REGISTER_VIEW_JSP_NAME = "register";

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterView(Model model) {
		model.addAttribute("form", new RegistrationFormDTO());
		return REGISTER_VIEW_JSP_NAME;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String confirmRegistration(@ModelAttribute("form") RegistrationFormDTO form, BindingResult result,
			@RequestParam(name = "g-recaptcha-response") String recaptchaResponse, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		String captchaVerifyMessage = captchaService.verifyRecaptcha(ip, recaptchaResponse);
		validator.validate(form, result);
		if (result.hasErrors()) {
			return REGISTER_VIEW_JSP_NAME;
		}
		if (!captchaVerifyMessage.isEmpty()) {
			return REGISTER_VIEW_JSP_NAME;
		}
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		user.setRole("ROLE_ADMIN"); // K-kibic, Z-zawodnik, T-trener, A-admin MOŻE ENUM??
		user.setName(form.getName());
		user.setSurname(form.getSurname());
		user.setAge(form.getAge());
		service.addUser(user);
		return "redirect:/login";

	}

}
