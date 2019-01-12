package com.footballteam.training.dto;

import com.footballteam.players.model.Player;

import lombok.Data;

@Data
public class PlayerTrainingDTO {
	int trainingid;
	Player player;
	int playerid;
}