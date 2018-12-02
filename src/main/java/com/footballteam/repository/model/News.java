package com.footballteam.repository.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "News")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int newsid;

	@NotEmpty
	private String value;
	
	private Date date;

}