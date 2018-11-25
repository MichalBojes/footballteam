package com.footballteam.history.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoryController {
	@RequestMapping("/history")
	public String showHistoryView(Model model) {
		return "history";
	}
}