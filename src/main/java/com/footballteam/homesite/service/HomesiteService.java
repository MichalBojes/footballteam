package com.footballteam.homesite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.homesite.dao.HomesiteDAO;
import com.footballteam.homesite.model.News;

@Service
public class HomesiteService {
	@Autowired
	HomesiteDAO dao;

	public News getNews(int id) {
		return dao.getNews(id);
	}

	public void editNews(int id, String value) {
		News news = new News();
		news.setNewsid(id);
		news.setValue(value);
		dao.editNews(news);
	}
	
	public List<News> getAllNews(){
		return dao.getAllNews();
	}
	
}