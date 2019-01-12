package com.footballteam.history.model;

import javax.persistence.Column;
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

	@Column(length=3064)
	private String value;

}