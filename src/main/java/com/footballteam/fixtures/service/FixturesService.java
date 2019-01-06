package com.footballteam.fixtures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.fixtures.dao.FixturesDAO;
import com.footballteam.fixtures.model.Fixture;

@Service
public class FixturesService {
	@Autowired
	FixturesDAO dao;

	public List<Fixture> getAllFixtures() {
		return dao.getAllFixtures();
	}
}