package com.footballteam.fixtures.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.footballteam.fixtures.dto.FixtureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.fixtures.dao.FixturesDAO;
import com.footballteam.fixtures.dto.FixtureFormDTO;
import com.footballteam.fixtures.model.Fixture;
import com.footballteam.repository.model.Stadium;

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

}