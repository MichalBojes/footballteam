package com.footballteam.repository.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@OneToOne
	@JoinColumn(name = "playerid")
	private Player playerid;

	private long value;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "duration")
	private int durationInMonths;

	private int salary;

	@NotEmpty
	private String extras;

}