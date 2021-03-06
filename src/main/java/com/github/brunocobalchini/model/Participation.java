//package com.github.brunocobalchini.model;
//
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//@Entity
//@Table(name = "Participation")
//public class Participation {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//
//	@ManyToOne(optional = false)
//	@JoinColumn(foreignKey = @ForeignKey(name = "fk_participation_actor"))
//	@JsonBackReference("actor")
//	private Actor actor;
//
//	@ManyToOne(optional = false)
//	@JoinColumn(foreignKey = @ForeignKey(name = "fk_participation_movie"))
//	@JsonBackReference("movie")
//	private Movie movie;
//
//	public Actor getActor() {
//		return actor;
//	}
//
//	public void setActor(Actor actor) {
//		this.actor = actor;
//	}
//
//		public Movie getMovie() {
//			return movie;
//		}
//	
//		public void setMovie(Movie movie) {
//			this.movie = movie;
//		}
//
//	public int getId() {
//		return id;
//	}
//
//}
