package com.footballteam.history.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.history.dao.HistoryDAO;
import com.footballteam.history.model.History;

@Service
public class HistoryService {
	@Autowired
	HistoryDAO dao;

	public History getHistory(int id) {
		return dao.getHistory(id);
	}

	public void editHistory(int id, String value) {
		dao.editHistory(id, value);
	}
}