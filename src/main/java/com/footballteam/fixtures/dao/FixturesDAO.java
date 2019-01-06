package com.footballteam.fixtures.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.footballteam.fixtures.model.Fixture;

@Service
public class FixturesDAO {
	@PersistenceContext
	EntityManager entityManager;

	public List<Fixture> getAllFixtures() {
		Query query = entityManager.createQuery("SELECT f FROM Fixture f where data > CURRENT_DATE ");
		List<Fixture> fixturesList = query.getResultList();
		return fixturesList;
	}
}