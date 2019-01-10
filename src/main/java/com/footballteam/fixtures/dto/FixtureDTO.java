package com.footballteam.fixtures.dto;

import com.footballteam.repository.model.Stadium;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
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
