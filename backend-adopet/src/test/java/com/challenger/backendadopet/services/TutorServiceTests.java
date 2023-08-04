package com.challenger.backendadopet.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.challenger.backendadopet.dtos.responses.TutorResponse;
import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.repositories.TutorRepository;
import com.challenger.backendadopet.tests.Factory;

@ExtendWith(SpringExtension.class)
public class TutorServiceTests {
	
	@InjectMocks
	private TutorService service;
	
	@Mock
    private TutorRepository repository;

	private Long existingId;
	private Long nonExistingId;
	private Tutor tutor;
	private TutorResponse response;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		tutor = Factory.createdTutor();
		response = Factory.createdTutorResponse();
		
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(tutor));
		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
	
	}
	
	@Test
	public void findByIdShouldReturnTutorResponseWhenIdExists() {
		
		TutorResponse result = service.findById(existingId);
		Assertions.assertNotNull(result);
		
	    Mockito.verify(repository, Mockito.times(1)).findById(existingId);
	}

	

}
