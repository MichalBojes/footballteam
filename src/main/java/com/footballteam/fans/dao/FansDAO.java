package com.footballteam.fans.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.fixtures.model.Fixture;
import com.footballteam.players.model.Match;
import com.footballteam.players.model.Player;
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
		match.setFixtureid(fixture);
		match.setUsername(user);
		entityManager.merge(match);
	}

	public List<String> getMatchesByFixture(int fixtureid) {
		List<String>maches= entityManager
				.createQuery("Select Distinct (m.username.username) From Match m where m.fixtureid.fixtureid = :fixtureid1")
				.setParameter("fixtureid1", fixtureid).getResultList();
		return maches;
	}
}