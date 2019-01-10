package com.footballteam.homesite.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	public List<NewsDTO> getAllNews(){
		List<NewsDTO> newsDTOS = new ArrayList<>();
		dao.getAllNews().forEach(news -> {
			NewsDTO newsDTO = new NewsDTO();
			Date date = news.getData();
			DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");
			newsDTO.setData(outputFormatter.format(date));
			newsDTO.setNewsid(news.getNewsid());
			newsDTO.setValue(news.getValue());
			newsDTOS.add(newsDTO);
		});

		return newsDTOS;
	}

	public void editNews(NewsDTO newsDTO) {
		dao.editNews(newsDTO);
	}

	
}