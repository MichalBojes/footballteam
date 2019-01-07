package com.footballteam.fixtures.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.footballteam.fixtures.dto.FixtureFormDTO;
import com.footballteam.fixtures.model.Fixture;
import com.footballteam.repository.model.Stadium;

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
	public List<Fixture> getAllFixtures() {
		Query query = entityManager.createQuery("SELECT f FROM Fixture f where data > CURRENT_DATE ");
		List<Fixture> fixturesList = query.getResultList();
		return fixturesList;
	}
	public List<Stadium> getAllStadiums(){
		Query query = entityManager.createQuery("SELECT s FROM Stadium s");
		List<Stadium> stadiumList = query.getResultList();
		return stadiumList;
	}
}