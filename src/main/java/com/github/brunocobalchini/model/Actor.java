package com.github.brunocobalchini.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Actor")
public class Actor {

	@Id
	@Column(nullable = false, length = 10)
	private String id;

	@Column(nullable = false, length = 100)
	private	String name;

	@Column(name =  "birth_date", nullable = false)
	private	LocalDate birthDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "actor")
	private List<Participation> participations = new ArrayList<Participation>();

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
