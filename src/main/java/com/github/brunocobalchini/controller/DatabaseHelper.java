package com.github.brunocobalchini.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.brunocobalchini.model.Actor;
import com.github.brunocobalchini.model.Movie;
import com.github.brunocobalchini.model.Participation;
import com.github.brunocobalchini.repository.ActorRepository;
import com.github.brunocobalchini.repository.MovieRepository;

@Component
public class DatabaseHelper {

	@Autowired
	private ActorRepository actorRepo; 

	@Autowired
	private MovieRepository movieRepo;
	
	@PostConstruct
	@Transactional
	public void populate() {
		Actor actor = new Actor();
		actor.setId("nm0001618");
		actor.setName("Joaquin Phoenix");
		actor.setBirthDate(LocalDate.of(1974, 10, 28));
		actorRepo.save(actor);
		
		Movie movie  = new Movie();
		movie.setId("tt7286456");
		movie.setName("Joker");
		movie.setRating(8.5f);
		movie.setReleaseDate(LocalDate.of(2019, 10, 4));
		
		Participation participation = new Participation();
		participation.setActor(actor);
		participation.setMovie(movie);
		
		movie.getCast().add(participation);
		
		movieRepo.save(movie);
	}


}