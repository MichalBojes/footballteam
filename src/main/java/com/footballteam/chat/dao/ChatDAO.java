package com.footballteam.chat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.footballteam.chat.model.Message;

@Repository
public class ChatDAO {

	@PersistenceContext
	EntityManager entityManager;

	public List<Message> getMessages(int pageNumber) {
		Query queryTotal = entityManager.createQuery("Select count(m.messageid) from Message m");
		int lastResult = ((Long) queryTotal.getSingleResult()).intValue();
		Query query = entityManager.createQuery("From Message");
		int pageSize = 20;
		int firstResult = lastResult - (pageNumber * pageSize);
		if (firstResult < 0)
			firstResult = 0;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List<Message> messagesList = query.getResultList();
		return messagesList;
	}

	@Transactional
	public void addMessage(Message message) {
		entityManager.merge(message);
	}

	public int getLastPageNumber() {
		Query queryTotal = entityManager.createQuery("Select count(m.messageid) from Message m");
		double lastPage = (double) (((Long) queryTotal.getSingleResult()).intValue()) / 20.0;
		if (lastPage % 1.0 == 0.0) {
			return (int) lastPage;
		}
		return (int) lastPage + 1;
	}

}
