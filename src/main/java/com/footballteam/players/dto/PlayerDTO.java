package com.footballteam.players.dto;

import com.footballteam.users.model.User;

import lombok.Data;

@Data
public class PlayerDTO {

	private int playerid;
	private User username;
	private String position;
	private int matchesPlayed;
	private int goalScored;
	private boolean preferedFootRight;
	private int shirtNumber;
	private int cardsReceived;

}