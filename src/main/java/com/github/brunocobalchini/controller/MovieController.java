package com.github.brunocobalchini.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.brunocobalchini.model.Movie;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

	public static final Map<String, Movie> MOVIES = new HashMap<>();

	@PostConstruct
	private void populate() {

		Movie movie = new Movie();
		movie.setId("mo987011");
		movie.setName("Titanic");
		movie.setReleaseDate(LocalDate.of(1970, 10, 12));
		movie.setRating(4.5f);
		movie.setDuration(130);
		MOVIES.put(movie.getId(), movie);

		movie = new Movie();
		movie.setId("mo132434");
		movie.setName("Hero");
		movie.setReleaseDate(LocalDate.of(1964, 11, 9));
		movie.setRating(4.1f);
		movie.setDuration(115);
		MOVIES.put(movie.getId(), movie);

		movie = new Movie();
		movie.setId("mo024343");
		movie.setName("Charg");
		movie.setReleaseDate(LocalDate.of(1935, 04, 11));
		movie.setRating(3.9f);
		movie.setDuration(140);
		MOVIES.put(movie.getId(), movie);
	}

	@GetMapping
	public Collection<Movie> getMovies() {
		return MOVIES.values();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
		if (MOVIES.containsKey(id)) {
			return ResponseEntity.ok(MOVIES.get(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteActorById(@PathVariable String id) {
		MOVIES.remove(id);
	}

	@PostMapping(path = "/{id}")
	public ResponseEntity<Movie> postMovie(@PathVariable String id, @RequestBody Movie movie) {
		if (MOVIES.containsKey(id)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();	
		}

		movie.setId(id);
		if (StringUtils.isEmpty(movie.getName()) || movie.getReleaseDate() == null || movie.getRating() == 0.0 || movie.getDuration() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		}

		movie = MOVIES.put(movie.getId(), movie);
		return ResponseEntity.status(HttpStatus.CREATED).body(movie);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Movie> putMovie(@PathVariable String id, @RequestBody Movie movie) {
		if (!MOVIES.containsKey(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		Movie oldMovie = MOVIES.get(id);	

		if (!StringUtils.isEmpty(movie.getName())) {
			oldMovie.setName(movie.getName());
		}

		if (movie.getReleaseDate() != null) {
			oldMovie.setReleaseDate(movie.getReleaseDate());
		}

		if ( movie.getRating() != 0.0) {
			oldMovie.setRating(movie.getRating());
		}

		oldMovie = MOVIES.put(movie.getId(), oldMovie);
		return ResponseEntity.status(HttpStatus.OK).body(oldMovie);
	}

}