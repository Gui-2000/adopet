package com.challenger.backendadopet.services;

import java.util.Optional;

import com.challenger.backendadopet.dtos.requesties.TutorRequest;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
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

	Long existingId;
	Long nonExistingId;
	Tutor tutor;
	TutorResponse response;
	TutorRequest request;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
	//	request = new TutorRequest(existingId, "Angela Maria", "angel@gmail.com", "6594265", "36985214730", "Presidente Wilson, 117", "Santos", "SP", "13 997564329", "www.imagem-1.com.br");
	//	tutor = new Tutor(existingId, "Angela Maria", "angel@gmail.com", "6594265", "36985214730", "Presidente Wilson, 117", "Santos", "SP", "13 997564329", "www.imagem-1.com.br");
	//	response = new TutorResponse("Angela Maria", "angel@gmail.com");
		
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(tutor));
		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());

		Mockito.when(repository.getReferenceById(existingId)).thenReturn(tutor);
		Mockito.when(repository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
	
	}

	@Test
	public void updateShouldReturnTutorRequestWhenIdExists() {

		TutorRequest result = service.update(existingId, request);

		Assertions.assertNotNull(result);
	}

	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

		Assertions.assertThrows(ResourceNotFoundException.class,() -> {
			service.update(nonExistingId, request);
		});
	}
	
	@Test
	public void findByIdShouldReturnTutorResponseWhenIdExists() {
		TutorResponse result = service.findById(existingId);
		Assertions.assertNotNull(result);

        Mockito.verify(repository, Mockito.times(1)).findById(existingId);
	    }

	@Test
	public void findByIdShouldReturnResourceNotFoundExceptionWhenIdNotExists() {
		Assertions.assertThrows(ResourceNotFoundException.class,() -> {
			service.findById(nonExistingId);
		});
		Mockito.verify(repository, Mockito.times(1)).findById(nonExistingId);
	}


}
