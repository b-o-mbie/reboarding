package com.szkhb.accenture.reboarding.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
}
