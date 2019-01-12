package com.footballteam.fixtures.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.footballteam.fixtures.dto.FixtureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.fixtures.dao.FixturesDAO;
import com.footballteam.fixtures.dto.FixtureFormDTO;
import com.footballteam.fixtures.dto.MatchDTO;
import com.footballteam.fixtures.model.Fixture;
import com.footballteam.fixtures.model.Match;
import com.footballteam.fixtures.model.Stadium;
import com.footballteam.players.dto.PlayerDTO;
import com.footballteam.players.model.Player;

@Service
public class FixturesService {
	@Autowired
	FixturesDAO dao;

	public List<FixtureDTO> getAllFixtures() {

		List<FixtureDTO> fixtureDTOS = new ArrayList<>();

		dao.getAllFixtures().forEach(fixture -> {
			FixtureDTO fixtureDTO = new FixtureDTO();
			Date date = fixture.getData();
			DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
			fixtureDTO.setFixtureid(fixture.getFixtureid());
			fixtureDTO.setDataFormated(outputFormatter.format(date));
			fixtureDTO.setLeague(fixture.getLeague());
			fixtureDTO.setOpponent(fixture.getOpponent());
			fixtureDTO.setReferee(fixture.getReferee());
			fixtureDTO.setRound(fixture.getRound());
			fixtureDTO.setSeason(fixture.getSeason());
			fixtureDTO.setStadium(fixture.getStadiumid());

			fixtureDTOS.add(fixtureDTO);
		});
		return fixtureDTOS;
	}

	public Stadium getStadium(int id) {
		return dao.getStadium(id);
	}

	public List<Stadium> getAllStadiums() {
		return dao.getAllStadiums();
	}

	public void addNewFixture(FixtureFormDTO form) {
		dao.addNewFixture(form);
	}

	public FixtureDTO getFixtureById(int fixtureid) {
		Fixture fixture = dao.getFixtureById(fixtureid);
		FixtureDTO fixtureDTO = new FixtureDTO();
		Date date = fixture.getData();
		DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
		fixtureDTO.setFixtureid(fixture.getFixtureid());
		fixtureDTO.setDataFormated(outputFormatter.format(date));
		fixtureDTO.setLeague(fixture.getLeague());
		fixtureDTO.setOpponent(fixture.getOpponent());
		fixtureDTO.setReferee(fixture.getReferee());
		fixtureDTO.setRound(fixture.getRound());
		fixtureDTO.setSeason(fixture.getSeason());
		fixtureDTO.setStadium(fixture.getStadiumid());
		return fixtureDTO;
	}

	public void addPlayerToMatch(MatchDTO matchDTO) {
		Match match = new Match();
		Fixture fixture = dao.getFixtureById(matchDTO.getFixtureid());
		match.setFixtureid(fixture);
		match.setUsername(matchDTO.getUser());
		match.setPosition(matchDTO.getPosition());

		dao.addPlayerToMatch(match);
	}

	public List<Match> getSelectedPlayers(int fixtureid) {
		return dao.getSelectedPlayers(fixtureid);
	}

	public List<Player> getAvaliablePlayers(int fixtureid) {
		return dao.getAvaliablePlayers(fixtureid);
	}

}