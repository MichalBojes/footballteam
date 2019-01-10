package com.footballteam.training.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.repository.model.Stadium;
import com.footballteam.training.dao.TrainingDAO;
import com.footballteam.training.dto.TrainingDTO;

@Service
public class TrainingService {
	@Autowired
	TrainingDAO dao;

	public List<TrainingDTO> getAllTrainings() {

		List<TrainingDTO> trainingDTOS = new ArrayList<>();

		dao.getAllTrainings().forEach(training -> {
			TrainingDTO trainingDTO = new TrainingDTO();
			Date date = training.getData();
			DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");

			trainingDTO.setTrainingid(training.getTrainingid());
			trainingDTO.setData(outputFormatter.format(date));
			trainingDTO.setStadium(training.getStadium());
			trainingDTO.setType(training.getType());
			trainingDTOS.add(trainingDTO);
		});
		return trainingDTOS;
	}

	public List<Stadium> getAllStadiums() {
		return dao.getAllStadiums();
	}

	public void addNewTraining(TrainingDTO form) {
		dao.addNewTraining(form);
	}

}