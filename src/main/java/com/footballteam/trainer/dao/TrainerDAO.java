package com.footballteam.trainer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class TrainerDAO{
	@PersistenceContext
	EntityManager entityManager;

	
}