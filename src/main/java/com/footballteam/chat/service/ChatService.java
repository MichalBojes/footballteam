package com.footballteam.chat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.chat.dao.ChatDAO;
import com.footballteam.chat.dto.MessageDTO;
import com.footballteam.chat.model.Message;

@Service
public class ChatService {

	@Autowired
	ChatDAO dao;

	public List<MessageDTO> getMessages(int pageNumber) {
		List<Message> messages = dao.getMessages(pageNumber);
		List<MessageDTO> messagesDTO = new ArrayList<>();
		MessageDTO messageDTO;
		for (Message message : messages) {
			messageDTO = new MessageDTO();
			messageDTO.setMessageid(message.getMessageid());
			messageDTO.setContent(message.getContent());
			messageDTO.setData(message.getData());
			messageDTO.setUser(message.getUsername());
			messagesDTO.add(messageDTO);
		}
		return messagesDTO;
	}

	public void addMessage(MessageDTO messageDTO) {
		Message message = new Message();
		message.setContent(messageDTO.getContent());
		message.setData(messageDTO.getData());
		message.setUsername(messageDTO.getUser());
		dao.addMessage(message);
	}

	public int getLastPageNumber() {
		return dao.getLastPageNumber();
	}

}
