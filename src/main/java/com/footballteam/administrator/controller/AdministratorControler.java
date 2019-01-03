package com.footballteam.administrator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.footballteam.users.model.User;
import com.footballteam.users.service.UsersService;

@Controller
@Secured(value = "ROLE_ADMIN")
public class AdministratorControler {
	@Autowired
	UsersService service;
	private static final String ADMINISTRATOR_JSP_NAME = "administrator";

	@RequestMapping("/admin")
	public String showAdmintView(Model model) {
		List<User> usersList = service.getAllUsers();
		model.addAttribute("users", usersList);
		return ADMINISTRATOR_JSP_NAME;
	}

	@RequestMapping("/changeRole/{id}/{role}")
	public String changeUserRole(Model model, @PathVariable("id") String username, @PathVariable("role") String role) {
		String roleToSave = "ROLE_FAN";
		if (role.equals("A"))
			roleToSave = "ROLE_ADMIN";
		else if (role.equals("T"))
			roleToSave = "ROLE_TRAINER";
		else if (role.equals("P"))
			roleToSave = "ROLE_PLAYER";
		else if (role.equals("F"))
			roleToSave = "ROLE_FAN";
		service.changeRole(username, roleToSave);
		return "redirect:/admin";
	}
}