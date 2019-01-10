package com.footballteam.players.dto;

import lombok.Data;

@Data
public class ContractDTO {
	private int playerid;
	private long value;
	private String startDate;
	private int durationInMonths;
	private int salary;
	private String extras;
}