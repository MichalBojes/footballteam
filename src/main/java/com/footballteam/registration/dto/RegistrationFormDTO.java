package com.footballteam.registration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationFormDTO {

	private String username;
	private String name;
	private String surname;
	private int age;
	private String password;
	private String passwordConfirm;

}