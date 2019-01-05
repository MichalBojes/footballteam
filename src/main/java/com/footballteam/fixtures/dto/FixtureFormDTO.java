package com.footballteam.fixtures.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FixtureFormDTO {

	private Date data;

	private int season;

	private int round;

	private int stadiumid;

	private String opponent;

	private String league;

	private String referee;
}