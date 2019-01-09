package com.footballteam.homesite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.homesite.dao.HomesiteDAO;
import com.footballteam.homesite.dto.NewsDTO;
import com.footballteam.homesite.model.News;

@Service
public class HomesiteService {
	@Autowired
	HomesiteDAO dao;

	public News getNewsById(int id) {
		return dao.getNewsById(id);
	}
	
	public List<News> getAllNews(){
		return dao.getAllNews();
	}

	public void editNews(NewsDTO newsDTO) {
		dao.editNews(newsDTO);
	}
	
}