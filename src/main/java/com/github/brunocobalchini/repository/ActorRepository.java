package com.github.brunocobalchini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.brunocobalchini.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, String>{

}