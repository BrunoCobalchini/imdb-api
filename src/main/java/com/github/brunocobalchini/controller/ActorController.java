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

import com.github.brunocobalchini.model.Actor;
import com.github.brunocobalchini.repository.ActorRepository;

@RestController
@RequestMapping(path = "/actors")
public class ActorController {

	@Autowired
	private ActorRepository actorRepo;

	@PostConstruct
	private void populate() {
		Actor actor = new Actor();
		actor.setId("nm0001191");
		actor.setName("Adam Sandler");
		actor.setBirthDate(LocalDate.of(1966, 9, 9));
		actorRepo.save(actor);

		actor = new Actor();
		actor.setId("nm0001618");
		actor.setName("Joaquin Phoenix");
		actor.setBirthDate(LocalDate.of(1974, 10, 28));
		actorRepo.save(actor);

		actor = new Actor();
		actor.setId("nm0000375");
		actor.setName("Robert Downey Jr");
		actor.setBirthDate(LocalDate.of(1965, 4, 4));
		actorRepo.save(actor);
	}

	@GetMapping
	public Collection<Actor> getActors() {
		return actorRepo.findAll();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Actor> getActorById(@PathVariable String id) {
		if (actorRepo.existsById(id)) {
			return ResponseEntity.ok(actorRepo.findById(id).get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteActorById(@PathVariable String id) {
		actorRepo.deleteById(id);
	}

	@PostMapping(path = "/{id}")
	public ResponseEntity<Actor> postActor(@PathVariable String id, @RequestBody Actor actor) {
		if (actorRepo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();	
		}

		actor.setId(id);
		if (StringUtils.isEmpty(actor.getName()) || actor.getBirthDate() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		}

		actor = actorRepo.save(actor);
		return ResponseEntity.status(HttpStatus.CREATED).body(actor);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Actor> putActor(@PathVariable String id, @RequestBody Actor actor) {
		if (!actorRepo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		Actor oldActor = actorRepo.findById(id).get();

		if (!StringUtils.isEmpty(actor.getName())) {
			oldActor.setName(actor.getName());
		}

		if (actor.getBirthDate() != null) {
			oldActor.setBirthDate(actor.getBirthDate());
		}

		oldActor = actorRepo.save(oldActor);
		return ResponseEntity.status(HttpStatus.OK).body(oldActor);
	}

}