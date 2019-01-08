package com.footballteam.history.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.footballteam.history.model.History;

@Repository
public class HistoryDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void editHistory(int id, String value) {
		History history = getHistory(id);
		history.setValue(value);
		entityManager.merge(history);
	}

	public History getHistory(int id) {
		return entityManager.find(History.class, id);
	}
}