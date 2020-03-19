package com.github.brunocobalchini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Participation") //Endpoint: /Actor - GET // Saida: {"id": 0 , "actor": 0, "movie": 0}
public class Participation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // ID auto
	@Column(name = "partId")
	private int id;  // EndPoint: /Participation/partId |POST- {"partId": "eih2021"} 
	//EndPoint: /Participation/partId - GET // Saida: {"partId": 1, "actor": 0, "movie": 0}

	@ManyToOne
	@JoinTable(name = "Actor", joinColumns =
	{ @JoinColumn(name = "castActor")})
	private int actor;  // EndPoint: /Participation/actor |POST- {"actor": 1} 
	//EndPoint: /Participation/actor - GET // Saida: {"partId": 2, "actor": 1}


	@ManyToOne
	@JoinTable(name = "Movie", joinColumns =
	{ @JoinColumn(name = "castMovie")})
	private int movie;  // EndPoint: /Participation/movie |POST- {"movie": 2} 
	//EndPoint: /Participation/movie - GET // Saida: {"partId": 3, "movie": 2}


	public int getActor() {
		return actor;
	}

	public void setActor(int actor) {
		this.actor = actor;
	}

	public int getMovie() {
		return movie;
	}

	public void setMovie(int movie) {
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

}