package com.github.brunocobalchini.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ActorTest {

	@Test
	public void shouldCreateEmptyActor() {
		Actor actor = new Actor();
		assertNull(actor.getId());
		assertNull(actor.getName());
		assertNull(actor.getBirthDate());
//		assertNotNull(actor.getParticipations());
//		assertTrue(actor.getParticipations().isEmpty());
	}

	@Test
	public void shouldCreateActor() {
		Actor actor = new Actor();
		actor.setId("W01@#$%><?}{^>`\\\\|s~^`´+=-_/!'");
		assertNotNull(actor.getId());
		actor.setName("W01@#$%><?}{^>`\\\\\\\\|s~^`´+=-_/!'");
		assertNotNull(actor.getName());
		actor.setBirthDate(LocalDate.of(1, 1, 1));
		assertNotNull(actor.getBirthDate());
//		actor.setParticipations(null);
//		assertNull(actor.getParticipations());
	}	
}