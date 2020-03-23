package com.github.brunocobalchini.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MovieTest {

	@Test
	public void shouldCreateEmptyMovie() {
		Movie movie = new Movie();
		assertNull(movie.getId());
		assertNull(movie.getName());
		assertNull(movie.getReleaseDate());
		assertEquals(0.0, movie.getRating());
		assertEquals(0, movie.getDuration());
		assertNotNull(movie.getCast());
	}

	@Test
	public void shouldCreateMovie() {
		Movie movie = new Movie();
		movie.setId("W01@#$%><?}{^>`\\\\\\\\|s~^`´+=-_/!'");
		assertNotNull(movie.getId());
		movie.setName("W01@#$%><?}{^>`\\\\\\\\|s~^`´+=-_/!'1");
		assertNotNull(movie.getName());
		movie.setReleaseDate(LocalDate.of(12, 12, 12));
		assertNotNull(movie.getReleaseDate());
		movie.setRating(4);
		assertNotNull(movie.getRating());
		movie.setDuration(130);
		assertNotNull(movie.getDuration());
		movie.setCast(null);
		assertNull(movie.getCast());

	}
}