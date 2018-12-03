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
	@JoinColumn(name = "username", nullable = false)
	private User username;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String position;

	@Column(name = "matches_played", nullable = false)
	private int matchesPlayed;

	@Column(name = "goal_scored", nullable = false)
	private int goalScored;

	@Column(name = "prefered_foot_right", nullable = false)
	private boolean preferedFootRight;

	@Column(name = "shirt_number", nullable = false)
	private int shirtNumber;

	@Column(name = "cards_received", nullable = false)
	private int cardsReceived;

	@ManyToOne
	@JoinColumn(name = "unavailibityid")
	private Unavailability unavailibalityid;

}