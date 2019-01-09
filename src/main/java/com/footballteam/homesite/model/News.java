package com.footballteam.homesite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Column(nullable = false, length = 3064)
	private String value;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(nullable = false)
	private Date data;

}