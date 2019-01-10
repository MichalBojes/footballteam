package com.footballteam.homesite.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NewsDTO {
	private int newsid;
	private String value;
	private String data;
}