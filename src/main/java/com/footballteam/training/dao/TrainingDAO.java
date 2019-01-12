package com.footballteam.training.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.footballteam.fixtures.dto.FixtureFormDTO;
import com.footballteam.fixtures.model.Fixture;
import com.footballteam.fixtures.model.Match;
import com.footballteam.fixtures.model.Stadium;
import com.footballteam.players.model.Player;
import com.footballteam.training.dto.TrainingDTO;
import com.footballteam.training.model.PlayerTraining;
import com.footballteam.training.model.Training;

@Service
public class TrainingDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void addNewTraining(TrainingDTO form) {

		Training training = new Training();
		Date date = new Date();
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(form.getData());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		training.setData(date);
		training.setType(form.getType());
		Stadium stadium = entityManager.find(Stadium.class, form.getStadium().getStadiumid());
		training.setStadium(stadium);
		entityManager.merge(training);
	}

	public Stadium getStadium(Long id) {
		return entityManager.find(Stadium.class, id);
	}

	public List<Stadium> getAllStadiums() {
		Query query = entityManager.createQuery("SELECT s FROM Stadium s");
		List<Stadium> stadiumList = query.getResultList();
		return stadiumList;
	}

	public List<Training> getAllTrainings() {
		Query query = entityManager.createQuery("SELECT t FROM Training t where data >= CURRENT_DATE ");
		List<Training> trainingList = query.getResultList();
		return trainingList;
	}

	public Training getTrainingById(int trainingid) {
		return entityManager.find(Training.class, trainingid);
	}

	@Transactional
	public void addPlayerToTraining(PlayerTraining training) {
		System.out.println(training.getPlayertrainingid());
		System.out.println(training.getPlayer().getPlayerid());
		System.out.println(training.getTraining().getTrainingid());
		entityManager.merge(training);
	}

	public List<PlayerTraining> getSelectedPlayers(int trainingid) {
		Query queryForUsers = entityManager
				.createQuery("SELECT t FROM PlayerTraining t where t.training.trainingid = :trainingid1")
				.setParameter("trainingid1", trainingid);
		List<PlayerTraining> userList = queryForUsers.getResultList();
		return userList;
	}

	public List<Player> getAvaliablePlayers(int fixtureid) {
		Query queryForUsers = entityManager
				.createQuery(
						"SELECT t.player.playerid FROM PlayerTraining t where t.training.trainingid = :trainingid1")
				.setParameter("trainingid1", fixtureid);
		List<Integer> choosenPlayersList = queryForUsers.getResultList();
		if (choosenPlayersList.isEmpty())
			choosenPlayersList.add(1);
		Query query = entityManager.createQuery("SELECT p FROM Player p where p.playerid not in (:playerslist)")
				.setParameter("playerslist", choosenPlayersList);
		List<Player> playersList = query.getResultList();
		return playersList;
	}

}