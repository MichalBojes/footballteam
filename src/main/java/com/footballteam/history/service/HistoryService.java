package com.footballteam.history.service;

import org.springframework.stereotype.Service;

@Service
public class HistoryService {
	@Autowired
	HistoryDAO dao;
	
	public String getHistory(int id){
		return dao.getHistory(id);
	}
	public void editHistory(int id, String value) {
		dao.editHistory(id, value);
	}
}