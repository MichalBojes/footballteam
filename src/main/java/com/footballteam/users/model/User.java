package com.footballteam.users.model;

import javax.persistence.Column;
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
	@Size(max = 64)
	@Column(nullable = false)
	private String role;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String password;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String name;

	@NotEmpty
	@Size(max = 128)
	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private int age;

}