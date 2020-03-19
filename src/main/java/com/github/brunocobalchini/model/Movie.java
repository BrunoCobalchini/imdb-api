package com.github.brunocobalchini.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {  //Endpoint: /Movie - GET // Saida: {"movieId": " ", "name": " ", release: 00/00/00, rating: 0, duration: 0, ["castMovie": " ", " "]}


	@Id
	@Column(name = "movieId", nullable = false)
	private String id; // EndPoint: /Movie/movieId |POST- {"id": "eod1212"} 
	//EndPoint: /Movie/movieId - GET // Saida: {"movieId": "eod1212", "name": "", "release": "", "release": 00/00/00, "rating": 0, "duration": 0.0}

	@Column(name =  "name")
	private String name; // EndPoint: /Movie/name |POST- {"name": "Michael"} 
	//EndPoint: /Movie/name - GET // Saida: {"movieId": " ", "name": "Michael"}

	@Column(name =  "release")
	private LocalDate releaseDate; // EndPoint: /Movie/release |POST- {"release": "02/01/99"} 
	//EndPoint: /Movie/release - GET // Saida: {"movieId": " ", "release": "02/01/99"}

	@Column
	private int rating; // EndPoint: /Movie/rating |POST- {"rating": 5} 
	//EndPoint: /Movie/rating - GET // Saida: {"movieId": " ", "rating": 5}

	@Column(name =  "duration")
	private int durationTime; // EndPoint: /Movie/duration |POST- {"duration": 122 } // duration = 122 (minutos)
	//EndPoint: /Movie/duration - GET // Saida: {"movieId": " ", "duration": 122}

	@OneToMany 
	@Column(name = "castMovie")
	private List<Participation> cast = new ArrayList<Participation>(); // EndPoint: /Movie/cast |POST- [{"castMovie": "Anne", "Canda"}]
	//EndPoint: /Movie/castMovie - GET // Saida: {"movieId": " ", ["castMovie": "Anne", "Canda"]}


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
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(int durationTime) {
		this.durationTime = durationTime;
	}
	public List<Participation> getCast() {
		return cast;
	}
	public void setCast(List<Participation> cast) {
		this.cast = cast;
	}
}	