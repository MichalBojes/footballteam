package com.footballteam.repository.model;

import javax.persistence.Entity;
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

	@ManyToOne
	@JoinColumn(name = "fixtureid")
	private Fixture fixturesid;

	@ManyToOne
	@JoinColumn(name = "username")
	private User username;

}