package com.footballteam.registration.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.footballteam.registration.dto.RegistrationFormDTO;
import com.footballteam.registration.service.RegistrationService;

@Component
public class RegistrationValidator implements Validator {

	@Autowired
	RegistrationService service;

	@Override
	public boolean supports(Class<?> arg0) {
		return RegistrationFormDTO.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		RegistrationFormDTO slownik = (RegistrationFormDTO) target;

		org.springframework.validation.ValidationUtils.rejectIfEmpty(errors, "username", "To pole nie może być puste",
				"To pole nie może być puste");
		if (service.userExists(slownik.getUsername()))
			errors.rejectValue("username", "Użytkownik o takiej nazwie juz istnieje",
					"Użytkownik o takiej nazwie juz istnieje");

		org.springframework.validation.ValidationUtils.rejectIfEmpty(errors, "name", "To pole nie może być puste",
				"To pole nie może być puste");
		org.springframework.validation.ValidationUtils.rejectIfEmpty(errors, "surname", "To pole nie może być puste",
				"To pole nie może być puste");
		if (slownik.getAge() < 12)
			errors.rejectValue("age", "Musisz mieć przynajmniej 12 lat aby korzystać z portalu",
					"Musisz mieć przynajmniej 12 lat aby korzystać z portalu");

		org.springframework.validation.ValidationUtils.rejectIfEmpty(errors, "password", "To pole nie może być puste",
				"To pole nie może być puste");

		/*
		 * EXPLANATION OF REGEX ^ # start-of-string (?=.*[0-9]) # a digit must occur at
		 * least once (?=.*[a-z]) # a lower case letter must occur at least once
		 * (?=.*[A-Z]) # an upper case letter must occur at least once (?=.*[@#$%^&+=])
		 * # a special character must occur at least once (?=\S+$) # no whitespace
		 * allowed in the entire string .{8,} # anything, at least eight places though $
		 * # end-of-string
		 */

		Pattern compiledPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		Matcher matcher = compiledPattern.matcher(slownik.getPassword());
		if (!matcher.matches()) {
			errors.rejectValue("password", "Hasło musi zawierać dużą i małą literę, mieć minimum 8 znaków oraz zawierać znak specjalny",
					"Hasło musi zawierać dużą literę i mieć minimum 6 znaków");
		}

		org.springframework.validation.ValidationUtils.rejectIfEmpty(errors, "passwordConfirm",
				"To pole nie może być puste", "To pole nie może być puste");
		if ((slownik.getPassword()!=null||slownik.getPassword()!="")&&!slownik.getPassword().equals(slownik.getPasswordConfirm()))
			errors.rejectValue("passwordConfirm", "Pole \"Hasło\" i \"Powtórz hasło\" muszą mieć taką samą wartość",
					"Pole hasło i powtórz hasło muszą mieć taką samą wartość");

	}
}