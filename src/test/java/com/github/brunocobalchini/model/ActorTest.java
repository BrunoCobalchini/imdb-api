package com.github.brunocobalchini.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ActorTest {

	@Test
	public void shouldCreateEmptyActor() {
		Actor actor = new Actor();
		assertNull(actor.getId());
		assertNull(actor.getName());
		assertNull(actor.getBirthDate());
		assertNotNull(actor.getParticipations());
		assertTrue(actor.getParticipations().isEmpty());
	}

}
