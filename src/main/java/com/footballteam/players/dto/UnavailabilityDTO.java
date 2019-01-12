package com.footballteam.players.dto;

import com.footballteam.fixtures.model.Fixture;
import com.footballteam.players.model.Player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnavailabilityDTO {
	private int unavailabilityid;
	private String reason;
	private int durationInDays;
	private String occurreDate;
	private Player player;
	private Fixture fixture;
}