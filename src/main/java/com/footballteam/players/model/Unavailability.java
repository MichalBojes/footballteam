	package com.footballteam.players.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.footballteam.fixtures.model.Fixture;

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
	@Column(nullable = false)
	private String reason;

	@Column(name = "duration", nullable = false)
	private int durationInDays;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "ocure_date", nullable = false)
	private Date occurreDate;
	
	@ManyToOne
	@JoinColumn(name = "playerid")
	private Player player;
	
	@ManyToOne
	@JoinColumn(name = "fixtureid")
	private Fixture fixture;
}