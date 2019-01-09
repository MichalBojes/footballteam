package com.footballteam.players.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ContractDTO {
	private int playerid;
	private long value;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date startDate;
	private int durationInMonths;
	private int salary;
	private String extras;
}