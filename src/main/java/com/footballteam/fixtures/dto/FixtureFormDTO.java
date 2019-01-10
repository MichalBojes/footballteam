package com.footballteam.fixtures.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FixtureFormDTO {

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date data;

	private Date dataFormated;

	private int season;

	private int round;

	private int stadiumid;

	private String opponent;

	private String league;

	private String referee;
}