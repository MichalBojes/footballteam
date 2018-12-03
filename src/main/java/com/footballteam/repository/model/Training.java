package com.footballteam.repository.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "training")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trainingid;

	@ManyToOne
	@JoinColumn(name = "stadiumid", nullable = false)
	private Stadium stadium;

	@ManyToOne
	@JoinColumn(name = "playerid", nullable = false)
	private Player plaryerid;

	@Column(nullable = false)
	private Date data;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String type;

}