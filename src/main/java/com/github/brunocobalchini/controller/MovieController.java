package com.github.brunocobalchini.controller;

import java.time.LocalDate;
import java.util.Collection;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.github.brunocobalchini.repository.MovieRepository;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

	@Autowired
	private MovieRepository movieRepo;

	@PostConstruct
	private void populate() {

		Movie movie  = new Movie();
		movie.setId("tt7286456");
		movie.setName("Joker");
		movie.setRating(8.5f);
		movie.setReleaseDate(LocalDate.of(2019, 10, 4));
		movieRepo.save(movie);

		movie = new Movie();
		movie.setId("mo132434");
		movie.setName("Hero");
		movie.setReleaseDate(LocalDate.of(1964, 11, 9));
		movie.setRating(4.1f);
		movie.setDuration(115);
		movieRepo.save(movie);

		movie = new Movie();
		movie.setId("mo024343");
		movie.setName("Charg");
		movie.setReleaseDate(LocalDate.of(1935, 04, 11));
		movie.setRating(3.9f);
		movie.setDuration(140);
		movieRepo.save(movie);
	}

	@GetMapping
	public Collection<Movie> getMovies() {
		return movieRepo.findAll();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
		if (movieRepo.existsById(id)) {
			return ResponseEntity.ok(movieRepo.findById(id).get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteMById(@PathVariable String id) {
		movieRepo.deleteById(id);
	}

	@PostMapping(path = "/{id}")
	public ResponseEntity<Movie> postMovie(@PathVariable String id, @RequestBody Movie movie) {
		
		if (movieRepo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();	
		}

		movie.setId(id);
		if (StringUtils.isEmpty(movie.getName()) || movie.getReleaseDate() == null || movie.getRating() == 0.0 || movie.getDuration() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		}

		movie = movieRepo.save(movie);
		return ResponseEntity.status(HttpStatus.CREATED).body(movie);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Movie> putMovie(@PathVariable String id, @RequestBody Movie movie) {
		if (!movieRepo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		Movie oldMovie = movieRepo.findById(id).get();	

		if (!StringUtils.isEmpty(movie.getName())) {
			oldMovie.setName(movie.getName());
		}

		if (movie.getReleaseDate() != null) {
			oldMovie.setReleaseDate(movie.getReleaseDate());
		}

		if ( movie.getRating() != 0.0) {
			oldMovie.setRating(movie.getRating());
		}

		if (movie.getDuration() != 0) {
			oldMovie.setDuration(movie.getDuration());
		}

		oldMovie = movieRepo.save(oldMovie);
		return ResponseEntity.status(HttpStatus.OK).body(oldMovie);
	}
}