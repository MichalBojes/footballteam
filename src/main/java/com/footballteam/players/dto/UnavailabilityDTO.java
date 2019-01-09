package com.footballteam.players.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date occurreDate;
	private Player player;
	private Fixture fixture;
}