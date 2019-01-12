package com.footballteam.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footballteam.history.model.History;
import com.footballteam.history.service.HistoryService;

@Controller
public class HistoryController {
	private static final String EDIT_HISTORY_VIEW_JSP_NAME = "edit_history";
	@Autowired
	HistoryService service;

	@RequestMapping("/history")
	public String showHistoryView(Model model) {
		History historia = service.getHistory(1);
		model.addAttribute("history", historia);
		return "history";
	}

	@Secured(value = "ROLE_ADMIN")
	@RequestMapping(value = "/editHistory", method = RequestMethod.GET)
	public String editHistory(Model model) {
		History historia = service.getHistory(1);
		model.addAttribute("history", historia);
		return EDIT_HISTORY_VIEW_JSP_NAME;
	}

	@RequestMapping(value = "/editHistory/{id}", method = RequestMethod.POST)
	public String confirmEditHistory(@ModelAttribute("history") History history,  @PathVariable("id") int id) {
		service.editHistory(id, history.getValue());
		return "redirect:/history";
	}
}