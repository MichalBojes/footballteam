package com.footballteam.repository.model;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "unavailability")
public class Unavailability {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int unavailabilityid;

	@NotEmpty
	private String reason;

	@Column(name = "duration")
	private int durationInDays;

	@Column(name = "ocure_date")
	private Date occurreDate;

}