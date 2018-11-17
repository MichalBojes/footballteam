package com.footballteam.administrator.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Secured(value ="ROLE_ADMIN")
public class AdministratorControler{
	private static final String ADMINISTRATOR_JSP_NAME = "administrator";

	@RequestMapping("/admin")
	public String showAdmintView(Model model) {
		return ADMINISTRATOR_JSP_NAME;
	}
}