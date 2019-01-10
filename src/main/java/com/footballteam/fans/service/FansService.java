package com.footballteam.fans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.fans.dao.FansDAO;
import com.footballteam.players.model.Match;

@Service
public class FansService {
	@Autowired
	FansDAO dao;

	public void declarePresence(int fixtureId, String username) {
		dao.declarePresence(fixtureId, username);
	}

	public List<String> getMatchesByFixture(int fixtureid) {
		return dao.getMatchesByFixture(fixtureid);
	}
}