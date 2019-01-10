package com.footballteam.fixtures.dto;

import com.footballteam.fixtures.model.Stadium;
import lombok.Data;

@Data
public class FixtureDTO {
	
	private int fixtureid;
	
    private String dataFormated;

    private int season;

    private int round;

    private Stadium stadium;

    private String opponent;

    private String league;

    private String referee;
}
