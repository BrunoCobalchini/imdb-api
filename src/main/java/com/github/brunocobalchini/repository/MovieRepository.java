package com.github.brunocobalchini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.brunocobalchini.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

}