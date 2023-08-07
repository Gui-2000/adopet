package com.challenger.backendadopet.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;

@DataJpaTest
public class TutorRepositoryTests {

	@Autowired
	private TutorRepository repository;
		
	private Long exintingId;
	private Long nonexintingId;
	
	@BeforeEach
	void setUp() throws Exception {
		exintingId = 1L;
		nonexintingId = 1000L;
	}
	
	@Test
	public void findByIdShouldTurnBackOptionalNotEmptyWhenIdExists() {
		
		repository.findById(exintingId);
		
		Optional<Tutor> result = repository.findById(exintingId); 
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldTurnBackOptionalEmptyWhenIdNonExists() {
		
		repository.findById(nonexintingId);
		
		Optional<Tutor> result = repository.findById(nonexintingId); 
		Assertions.assertTrue(result.isEmpty());
	}
	
	@Test
	public void findAllShouldTurnBackListNonEmpty() {
		
		List<Tutor> result = repository.findAll();
		
		Assertions.assertFalse(result.isEmpty());
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {

		Optional<Tutor> result = repository.findById(exintingId);
		Tutor entity = result.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		repository.delete(entity);
		Assertions.assertTrue(entity.getName().isEmpty());
	}
	
	@Test
	public void deleteShouldDeleteObjectReturnResourceNotFoundExceptionWhenIdNonExists() {
		
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			Optional<Tutor> obj =  repository.findById(nonexintingId);
		    Tutor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		});
	}
}
