package com.footballteam.fans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FansService {
	@Autowired
	FansDAO dao;

	public void declarePresence(int fixtureId, String username) {
		dao.devlarePersence(fixtureId, username);
	}
}