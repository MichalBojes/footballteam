package com.footballteam.repository.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.footballteam.users.model.User;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int messageid;

	@ManyToOne
	@JoinColumn(name = "username")
	private User username;

	private Date date;

	@NotEmpty
	private String content;

}