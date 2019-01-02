package com.footballteam.homesite.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.footballteam.homesite.model.News;

@Repository
public class HomesiteDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void editNews(News news) {
		entityManager.merge(news);
	}

	public News getNews(int id) {
		return entityManager.find(News.class, id);
	}
	
	public List<News> getAllNews(){
		Query query = entityManager.createQuery("SELECT n FROM News n");
		List<News> newsList = query.getResultList();
		return newsList ;
	}
}