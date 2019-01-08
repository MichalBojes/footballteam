package com.footballteam.players.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Contract")
public class Contract {

	@Id
	private int playerid;

	@Column(nullable = false)
	private long value;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "duration", nullable = false)
	private int durationInMonths;

	@Column(nullable = false)
	private int salary;

	@NotEmpty
	@Column(nullable = false)
	private String extras;

}