package com.footballteam.chat.dto;

import java.io.Serializable;
import java.util.Date;

import com.footballteam.users.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO implements Serializable {

	private int messageid;
	private User user;
	private Date data;
	private String content;
	private String time;
}
