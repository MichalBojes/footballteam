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
import com.footballteam.fixtures.model.Stadium;
import com.footballteam.training.dto.TrainingDTO;
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

	public List<Training> getAllTrainings() {
		Query query = entityManager.createQuery("SELECT t FROM Training t where data > CURRENT_DATE ");
		List<Training> trainingList = query.getResultList();
		return trainingList;
	}

	public List<Stadium> getAllStadiums() {
		Query query = entityManager.createQuery("SELECT s FROM Stadium s");
		List<Stadium> stadiumList = query.getResultList();
		return stadiumList;
	}

}