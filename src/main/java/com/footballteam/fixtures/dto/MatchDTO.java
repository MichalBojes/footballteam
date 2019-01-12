package com.footballteam.fixtures.dto;

import com.footballteam.users.model.User;

import lombok.Data;

@Data
public class MatchDTO {
	int fixtureid;
	User user;
	String position;
	String username;
}