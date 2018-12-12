package com.footballteam.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "stadium")
public class Stadium {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stadiumid;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int capacity;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String address;

}