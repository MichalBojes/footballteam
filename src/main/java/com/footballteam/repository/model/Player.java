package com.footballteam.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.footballteam.users.model.User;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int playerid;

	@ManyToOne
	@JoinColumn(name = "username")
	private User username;

	@NotEmpty
	@Size(max = 128)
	private String position;

	@Column(name = "matches_played")
	private int matchesPlayed;

	@Column(name = "goal_scored")
	private int goalScored;

	@Column(name = "prefered_foot_right")
	private boolean preferedFootRight;

	@Column(name = "shirt_number")
	private int shirtNumber;

	@Column(name = "cards_received")
	private int cardsReceived;

	@ManyToOne
	@JoinColumn(name = "unavailibityid")
	private Unavailability unavailibalityid;

}