package com.footballteam.chat.dto;

import java.util.Date;

import com.footballteam.users.model.User;

import lombok.Data;

@Data
public class MessageDTO {

	private int messageid;
	private User user;
	private Date data;
	private String content;
}
