package com.footballteam.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@NotEmpty
	@Size(max = 128)
	private String username;

	@NotEmpty
	@Size(max = 128)
	private String role;

	@NotEmpty
	@Size(max = 128)
	private String password;

	@NotEmpty
	@Size(max = 128)
	private String name;

	@NotEmpty
	@Size(max = 128)
	private String surname;

	private int age;

}