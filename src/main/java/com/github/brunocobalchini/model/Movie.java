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
@Table(name = "Movie")
public class Movie {

	@Id
	@Column(nullable = false, length = 10)
	private String id;
	
	@Column(name =  "name", nullable = false, length = 100)
	private String name;
	
	@Column(name =  "release_date", nullable = false)
	private LocalDate releaseDate;
	
	@Column(nullable = false)
	private float rating;
	
	@Column(name =  "duration")
	private int duration;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movie") 
	private List<Participation> cast = new ArrayList<>();
	
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
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Participation> getCast() {
		return cast;
	}
	public void setCast(List<Participation> cast) {
		this.cast = cast;
	}
}	
