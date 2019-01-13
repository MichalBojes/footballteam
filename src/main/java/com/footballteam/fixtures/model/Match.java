package com.footballteam.fixtures.model;

import javax.persistence.Column;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	private Fixture fixtureid;

	@ManyToOne
	
	@JoinColumn(name = "username", nullable = false)
	private User username;
	
	@Column(name = "position", nullable = false)
	private String position;

}