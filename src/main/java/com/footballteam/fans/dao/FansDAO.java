package com.footballteam.fans.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.fixtures.model.Fixture;
import com.footballteam.repository.model.Match;
import com.footballteam.users.model.User;

@Repository
public class FansDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void declarePresence(int fixtureId, String username) {
		Fixture fixture = entityManager.find(Fixture.class, fixtureId);
		User user = entityManager.find(User.class, username);
		Match match = new Match();
		match.setFixturesid(fixture);
		match.setUsername(user);
		entityManager.merge(match);
	}
}