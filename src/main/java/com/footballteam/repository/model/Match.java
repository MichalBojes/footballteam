package com.footballteam.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.footballteam.fixtures.model.Fixture;
import com.footballteam.users.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "match")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matchid;

	@ManyToOne
	@JoinColumn(name = "fixtureid", nullable = false)
	private Fixture fixturesid;

	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private User username;

}