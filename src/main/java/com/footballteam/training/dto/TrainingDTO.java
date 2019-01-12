package com.footballteam.training.dto;

import com.footballteam.fixtures.model.Stadium;

import lombok.Data;

@Data
public class TrainingDTO {
	private int trainingid;
	private Stadium stadium;
	private String data;
	private String type;
}
