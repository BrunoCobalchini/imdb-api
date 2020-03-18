package com.github.brunocobalchini.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "List of films")
public class Movie {

	@Id
	private String id;

	private String name;
	private LocalDate releaseDate;
	private int rating;
	private double durationTime;
	private List<Participation> cast = new ArrayList<Participation>();

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
	public double getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(double durationTime) {
		this.durationTime = durationTime;
	}
	public List<Participation> getCast() {
		return cast;
	}
	public void setCast(List<Participation> cast) {
		this.cast = cast;
	}
}	