package com.footballteam.homesite.controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.homesite.dto.NewsDTO;
import com.footballteam.homesite.model.News;
import com.footballteam.homesite.service.HomesiteService;
import com.footballteam.players.dto.ContractDTO;
import com.footballteam.players.model.Contract;

@Controller
public class HomesiteController {

	@Autowired
	HomesiteService service;

	private static final String HOMESITE_JSP_NAME = "homesite";

	@RequestMapping("/")
	public String showDefaultView(Model model) {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String showHomesiteView(Model model) {
		List<NewsDTO> newsList = service.getAllNews();
		model.addAttribute("news", newsList);
		return HOMESITE_JSP_NAME;
	}
	
	@Secured({"ROLE_TRAINER", "ROLE_ADMIN"})
	@RequestMapping("/editNews")
	public String showEditNewsView(Model model, @RequestParam("id") int newsid) {
		News news = service.getNewsById(newsid);
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setNewsid(newsid);
		newsDTO.setValue(news.getValue());
		Date date = news.getData();
		DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
		newsDTO.setData(outputFormatter.format(date));
		model.addAttribute("newsDTO", newsDTO);
		return "edit_news";
	}

	@Secured({"ROLE_TRAINER", "ROLE_ADMIN"})
	@RequestMapping("/addNews")
	public String showEditNewsView(Model model) {
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setNewsid(0);
		newsDTO.setValue(" ");
		DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
		newsDTO.setData(outputFormatter.format(new Date()));
		model.addAttribute("newsDTO", newsDTO);
		return "edit_news";
	}

	@Secured({"ROLE_TRAINER", "ROLE_ADMIN"})
	@RequestMapping(value = "/confirmEditNews", method = RequestMethod.POST)
	public String confirmEditContract(@ModelAttribute("newsDTO") NewsDTO newsDTO) {
		service.editNews(newsDTO);
		return "redirect:/home";
	}

}
