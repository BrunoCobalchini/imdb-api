package com.github.brunocobalchini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Participation in the movie")
public class Participation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int idMovie;
	private int idActor;
	
	public int getId() {
		return id;
	}	
	public int getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	public int getIdActor() {
		return idActor;
	}
	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}
}