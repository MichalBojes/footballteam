package com.footballteam.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.footballteam.history.model.History;
import com.footballteam.history.service.HistoryService;

@Controller
public class HistoryController {
	@Autowired
	HistoryService service;
	
	@RequestMapping("/history")
	public String showHistoryView(Model model) {
		History historia = service.getHistory(1);
		model.addAttribute("history", historia.getValue());
		return "history";
	}
}