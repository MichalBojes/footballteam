package com.footballteam.chat.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballteam.chat.dto.MessageDTO;
import com.footballteam.chat.service.ChatService;
import com.footballteam.users.model.User;
import com.footballteam.users.service.UsersService;

@Controller
public class ChatController {
	@Autowired
	ChatService service;
	@Autowired
	UsersService userService;

	@RequestMapping("/chat")
	public String showChatView(Model model, @RequestParam("page") int pageNumber) {
		List<MessageDTO> messages = service.getMessages(pageNumber);
		int lastPageNumber = service.getLastPageNumber();
		MessageDTO newMessage = new MessageDTO();

		model.addAttribute("messagesList", messages);
		model.addAttribute("newMessage", newMessage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("next", pageNumber + 1);
		model.addAttribute("previous", pageNumber - 1);
		return "chat_view";
	}

	@RequestMapping("/addMessage")
	public String addNewMessage(@ModelAttribute("newMessage") MessageDTO message, @RequestParam("page") int pageNumber) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getUserByUsername(username);
		message.setData(new Date());
		message.setUser(user);
		service.addMessage(message);
		return "redirect:/chat?page="+pageNumber;
	}
}