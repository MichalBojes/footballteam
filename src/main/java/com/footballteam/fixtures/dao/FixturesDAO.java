package com.footballteam.fixtures.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.footballteam.fixtures.dto.FixtureFormDTO;
import com.footballteam.fixtures.model.Fixture;
import com.footballteam.fixtures.model.Match;
import com.footballteam.fixtures.model.Stadium;
import com.footballteam.players.model.Player;

@Service
public class FixturesDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void addNewFixture(FixtureFormDTO form) {
		Fixture fixture = new Fixture();
		fixture.setData(form.getData());
		fixture.setLeague(form.getLeague());
		fixture.setOpponent(form.getOpponent());
		fixture.setReferee(form.getReferee());
		fixture.setRound(form.getRound());
		fixture.setSeason(form.getSeason());
		Stadium stadium = entityManager.find(Stadium.class, form.getStadiumid());
		fixture.setStadiumid(stadium);
		entityManager.merge(fixture);
	}

	public Stadium getStadium(int id) {
		return entityManager.find(Stadium.class, id);
	}

	public List<Fixture> getAllFixtures() {
		Query query = entityManager.createQuery("SELECT f FROM Fixture f where data >= CURRENT_DATE ");
		List<Fixture> fixturesList = query.getResultList();
		return fixturesList;
	}

	public List<Stadium> getAllStadiums() {
		Query query = entityManager.createQuery("SELECT s FROM Stadium s");
		List<Stadium> stadiumList = query.getResultList();
		return stadiumList;
	}

	public Fixture getFixtureById(int fixtureid) {
		return entityManager.find(Fixture.class, fixtureid);
	}

	@Transactional
	public void addPlayerToMatch(Match match) {
		entityManager.merge(match);
	}

	public List<Match> getSelectedPlayers(int fixtureid) {
		Query queryForUsers = entityManager
				.createQuery(
						"SELECT m FROM Match m where m.position <> 'KIBIC' and m.fixtureid.fixtureid = :fixtureid1")
				.setParameter("fixtureid1", fixtureid);
		List<Match> userList = queryForUsers.getResultList();
		return userList;
	}

	public List<Player> getAvaliablePlayers(int fixtureid) {
		Query queryForPlayersWithUnavailability = entityManager.createQuery(
				"SELECT u.player.username.username FROM Unavailability u where u.fixture.fixtureid = :fixtureid1")
				.setParameter("fixtureid1", fixtureid);
		List<String> usersWithUnavailabilityOrChosenList = queryForPlayersWithUnavailability.getResultList();
		Query queryForUsers = entityManager
				.createQuery("SELECT m.username.username FROM Match m where m.fixtureid.fixtureid = :fixtureid1")
				.setParameter("fixtureid1", fixtureid);
		List<String> choosenUsersList = queryForUsers.getResultList();
		for (String username : choosenUsersList)
			usersWithUnavailabilityOrChosenList.add(username);
		if (usersWithUnavailabilityOrChosenList.isEmpty())
			usersWithUnavailabilityOrChosenList.add("none");
		Query query = entityManager.createQuery(
				"SELECT p FROM Player p where p.username.role = 'ROLE_PLAYER' and p.username.username not in (:userlist)")
				.setParameter("userlist", usersWithUnavailabilityOrChosenList);
		List<Player> fixturesList = query.getResultList();
		return fixturesList;
	}
}