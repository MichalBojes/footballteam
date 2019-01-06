package com.footballteam.trainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

@Secured(value = "ROLE_TRAINER")
@Controller
public class TrainerController {
	@Autowired
	TrainerService service;
	
}