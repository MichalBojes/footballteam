package com.footballteam.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.footballteam.fixtures.model.Fixture;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "playertraining")
public class PlayerTraining {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int playertrainingid;

	@ManyToOne
	@JoinColumn(name = "trainingid", nullable = false)
	private Fixture trainingid;

	@ManyToOne
	@JoinColumn(name = "playerid", nullable = false)
	private Player plaryerid;

}
