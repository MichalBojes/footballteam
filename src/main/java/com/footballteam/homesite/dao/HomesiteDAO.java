package com.footballteam.homesite.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.footballteam.homesite.dto.NewsDTO;
import com.footballteam.homesite.model.News;

@Repository
public class HomesiteDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void editNews(NewsDTO newsDTO) {
		News news = new News();
		if (newsDTO.getNewsid() != 0)
			news.setNewsid(newsDTO.getNewsid());
		news.setValue(newsDTO.getValue());
		news.setData(new Date());
		entityManager.merge(news);
	}

	public News getNewsById(int id) {
		return entityManager.find(News.class, id);
	}

	public List<News> getAllNews() {
		Query query = entityManager.createQuery("SELECT n FROM News n");
		List<News> newsList = query.getResultList();
		return newsList;
	}
}