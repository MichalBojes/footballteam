package com.footballteam.history.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoryController {
	@Autowired
	HistoryService service;
	
	@RequestMapping("/history")
	public String showHistoryView(Model model) {
		String historia = service.getHistory();
		model.addAttribute("history", historia);
		return "history";
	}
}