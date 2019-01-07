package com.footballteam.trainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.trainer.dao.TrainerDAO;

@Service
public class TrainerService{
	@Autowired
	TrainerDAO dao;
	
}