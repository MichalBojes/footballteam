package com.footballteam.fixtures.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.footballteam.repository.model.Stadium;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "fixtures")
public class Fixture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fixtureid;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(nullable = false)
	private Date data;

	@Column(nullable = false)
	private int season;

	@Column(nullable = false)
	private int round;

	@ManyToOne
	@JoinColumn(name = "stadiumid", nullable = false)
	private Stadium stadiumid;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String opponent;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String league;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String referee;

}