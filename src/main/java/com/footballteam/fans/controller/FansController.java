package com.footballteam.fans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FansController {

	@RequestMapping("/fans_gallery")
	public String showFansGalleryView(Model model) {
		return "fans";
	}

}