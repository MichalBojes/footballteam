package com.footballteam.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "History")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int historyid;
	
	private String value;

}