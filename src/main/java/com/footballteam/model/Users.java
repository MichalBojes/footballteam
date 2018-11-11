package com.footballteam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@NotEmpty
	@Size(max = 50)
	private String firstName;

	@NotEmpty
	@Size(max = 50)
	private String lastName;

	@NotEmpty
	@Size(max = 128)
	private String email;

	@NotEmpty
	@Size(max = 60)
	@JsonIgnore
	private String password;

	@Transient
	@JsonIgnore
	private String confirmPassword;

}