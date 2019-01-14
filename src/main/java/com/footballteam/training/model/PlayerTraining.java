package com.footballteam.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.footballteam.players.model.Player;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	private Training training;

	@ManyToOne
	
	@JoinColumn(name = "playerid", nullable = false)
	private Player player;

}
