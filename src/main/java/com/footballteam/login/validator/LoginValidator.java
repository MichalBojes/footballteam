package com.footballteam.login.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.footballteam.login.dto.LoginFormDTO;
import com.footballteam.login.service.LoginService;
import com.footballteam.registration.dto.RegistrationFormDTO;
import com.footballteam.registration.service.RegistrationService;

@Component
public class LoginValidator implements Validator {

	@Autowired
	LoginService service;

	@Override
	public boolean supports(Class<?> arg0) {
		return RegistrationFormDTO.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		LoginFormDTO uzytkownik = (LoginFormDTO) target;

		org.springframework.validation.ValidationUtils.rejectIfEmpty(errors, "username", "To pole nie może być puste",
				"To pole nie może być puste");
		if (!service.userExists(uzytkownik.getUsername()))
			errors.rejectValue("username", "Użytkownik o takiej nazwie juz istnieje",
					"Użytkownik o takiej nazwie nie istnieje");
		if (service.getPassword(uzytkownik.getUsername()).equals(uzytkownik.getPassword())) {
			errors.rejectValue("password", "Podano nieprawidłowe hasło", "Podano nieprawidłowe hasło");
		} else {
			org.springframework.validation.ValidationUtils.rejectIfEmpty(errors, "password",
					"To pole nie może być puste", "To pole nie może być puste");
		}

	}
}