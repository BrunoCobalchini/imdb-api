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

import com.github.brunocobalchini.model.Actor;

@RestController
@RequestMapping(path = "/actors")
public class ActorController {

	public static final Map<String, Actor> ACTORS = new HashMap<>();

	@PostConstruct
	private void populate() {
		Actor actor = new Actor();
		actor.setId("nm0001191");
		actor.setName("Adam Sandler");
		actor.setBirthDate(LocalDate.of(1966, 9, 9));
		ACTORS.put(actor.getId(), actor);

		actor = new Actor();
		actor.setId("nm0001618");
		actor.setName("Joaquin Phoenix");
		actor.setBirthDate(LocalDate.of(1974, 10, 28));
		ACTORS.put(actor.getId(), actor);

		actor = new Actor();
		actor.setId("nm0000375");
		actor.setName("Robert Downey Jr");
		actor.setBirthDate(LocalDate.of(1965, 4, 4));
		ACTORS.put(actor.getId(), actor);
	}

	@GetMapping
	public Collection<Actor> getActors() {
		return ACTORS.values();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Actor> getActorById(@PathVariable String id) {
		if (ACTORS.containsKey(id)) {
			return ResponseEntity.ok(ACTORS.get(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteActorById(@PathVariable String id) {
		ACTORS.remove(id);
	}

	@PostMapping(path = "/{id}")
	public ResponseEntity<Actor> postActor(@PathVariable String id, @RequestBody Actor actor) {
		if (ACTORS.containsKey(id)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();	
		}

		actor.setId(id);
		if (StringUtils.isEmpty(actor.getName()) || actor.getBirthDate() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		}

		actor = ACTORS.put(actor.getId(), actor);
		return ResponseEntity.status(HttpStatus.CREATED).body(actor);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Actor> putActor(@PathVariable String id, @RequestBody Actor actor) {
		if (!ACTORS.containsKey(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		Actor oldActor = ACTORS.get(id);
		
		if (!StringUtils.isEmpty(actor.getName())) {
			oldActor.setName(actor.getName());
		}

		if (actor.getBirthDate() != null) {
			oldActor.setBirthDate(actor.getBirthDate());
		}

		oldActor = ACTORS.put(actor.getId(), oldActor);
		return ResponseEntity.status(HttpStatus.OK).body(oldActor);
	}

}