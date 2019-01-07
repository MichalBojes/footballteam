package com.footballteam.fixtures.service;

import java.util.List;

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

	public List<Fixture> getAllFixtures() {
		return dao.getAllFixtures();
	}
	
	public List<Stadium> getAllStadiums(){
		return dao.getAllStadiums();
	}

	public void addNewFixture(FixtureFormDTO form) {
		dao.addNewFixture(form);
	}

}