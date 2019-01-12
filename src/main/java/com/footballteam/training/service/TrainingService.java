package com.footballteam.training.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballteam.fixtures.model.Stadium;
import com.footballteam.players.model.Player;
import com.footballteam.training.dao.TrainingDAO;
import com.footballteam.training.dto.PlayerTrainingDTO;
import com.footballteam.training.dto.TrainingDTO;
import com.footballteam.training.model.PlayerTraining;
import com.footballteam.training.model.Training;

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

	public TrainingDTO getTrainingById(int id) {
		Training training = dao.getTrainingById(id);
		TrainingDTO trainingDTO = new TrainingDTO();
		Date date = training.getData();
		DateFormat outputFormatter = new SimpleDateFormat("dd-MM-yyyy");

		trainingDTO.setTrainingid(training.getTrainingid());
		trainingDTO.setData(outputFormatter.format(date));
		trainingDTO.setStadium(training.getStadium());
		trainingDTO.setType(training.getType());

		return trainingDTO;
	}

	public List<Stadium> getAllStadiums() {
		return dao.getAllStadiums();
	}

	public void addNewTraining(TrainingDTO form) {
		dao.addNewTraining(form);
	}

	public void addPlayerToTraining(PlayerTrainingDTO trainingDTO) {
		PlayerTraining playerTraining = new PlayerTraining();
		Training training = dao.getTrainingById(trainingDTO.getTrainingid());
		playerTraining.setTraining(training);
		playerTraining.setPlayer(trainingDTO.getPlayer());

		dao.addPlayerToTraining(playerTraining);
	}

	public List<PlayerTraining> getSelectedPlayers(int trainingid) {
		return dao.getSelectedPlayers(trainingid);
	}

	public List<Player> getAvaliablePlayers(int fixtureid) {
		return dao.getAvaliablePlayers(fixtureid);
	}

}