package com.footballteam.registration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.registration.dto.RegistrationFormDTO;
import com.footballteam.users.model.User;
import com.footballteam.users.service.UsersService;
import com.footballteam.recaptcha.service.RecaptchaService;
import com.footballteam.registration.validator.RegistrationValidator;

@EnableJpaRepositories
@Controller
public class RegistrationController {
	@Autowired
	RecaptchaService captchaService;

	@Autowired
	RegistrationValidator validator;

	@Autowired
	UsersService service;

	private static final String REGISTER_VIEW_JSP_NAME = "register";

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterView(Model model) {
		RegistrationFormDTO registrationFormDTO = new RegistrationFormDTO();
		registrationFormDTO.setRole("ROLE_FAN");
		model.addAttribute("form", registrationFormDTO);
		model.addAttribute("type", "registration");
		return REGISTER_VIEW_JSP_NAME;
	}

	@Secured({ "ROLE_FAN", "ROLE_TRAINER", "ROLE_ADMIN", "ROLE_PLAYER" })
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String showEditUserView(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = service.getUserByUsername(username);
		RegistrationFormDTO form = new RegistrationFormDTO();
		form.setUsername(user.getUsername());
		form.setPassword(user.getPassword());
		form.setPasswordConfirm(user.getPassword());
		form.setRole(user.getRole()); // ROLE_FAN-kibic, ROLE_PLAYER-zawodnik, ROLE_TRAINER-trener, ROLE_ADMIN-admin
		form.setName(user.getName());
		form.setSurname(user.getSurname());
		form.setAge(user.getAge());
		model.addAttribute("form", form);
		model.addAttribute("type", "edituser");
		return REGISTER_VIEW_JSP_NAME;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String confirmRegistration(@ModelAttribute("form") RegistrationFormDTO form, BindingResult result,
			@RequestParam(name = "g-recaptcha-response") String recaptchaResponse, HttpServletRequest request,
			@RequestParam(name = "type") String type) {
		String ip = request.getRemoteAddr();
		String captchaVerifyMessage = captchaService.verifyRecaptcha(ip, recaptchaResponse);
		User user;
		if (type.equals("registration")) {
			validator.validate(form, result);
			user = new User();
			user.setUsername(form.getUsername());
			if (result.hasErrors()) {
				return REGISTER_VIEW_JSP_NAME;
			}
		} else {
			user = service.getUserByUsername(form.getUsername());
		}
		if (!captchaVerifyMessage.isEmpty()) {
			return REGISTER_VIEW_JSP_NAME;
		}

		user.setPassword(form.getPassword());
		user.setRole("ROLE_FAN"); // ROLE_FAN-kibic, ROLE_PLAYER-zawodnik, ROLE_TRAINER-trener, ROLE_ADMIN-admin
		user.setName(form.getName());
		user.setSurname(form.getSurname());
		user.setAge(form.getAge());
		service.addUser(user);
		if (type.equals("registration")) {
			return "redirect:/login";
		} else {
			return "redirect:/home";
		}

	}

}
