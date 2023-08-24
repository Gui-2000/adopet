package com.challenger.backendadopet.services;

import com.challenger.backendadopet.dtos.requesties.TutorRequest;
import com.challenger.backendadopet.dtos.responses.TutorResponse;
import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.repositories.TutorRepository;
import com.challenger.backendadopet.services.exceptions.DatabaseException;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;
    
    @Autowired
    private TutorResponse response;

    @Transactional(readOnly = true)
    public TutorResponse findById(Long id) {
        Optional<Tutor> obj =  repository.findById(id);
        Tutor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return response.convert(entity);
    }
    
    @Transactional(readOnly = true)
    public List<TutorResponse> findAll() {
    	List<Tutor> list = repository.findAll();
    	return list.stream().map(x -> response.convert(x)).collect(Collectors.toList());
    }
    
    @Transactional
    public TutorResponse insert(TutorRequest dto) {
    	Tutor entity = new Tutor();
    	copyDtoToEntity(dto, entity);
    	entity = repository.save(entity);
    	return response.convert(entity);
    }
    
    @Transactional
    public TutorRequest update(Long id, TutorRequest dto) {
    	try {
    		Tutor entity = repository.getReferenceById(id);
    		copyDtoToEntity(dto, entity);
        	entity = repository.save(entity);
        	return new TutorRequest(entity);
         } catch (EntityNotFoundException e) {
              throw new ResourceNotFoundException("Id not found " + id);
       }
    }
    
    public void delete(Long id) {
      try {
          Optional<Tutor> obj = repository.findById(id);
          Tutor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
          repository.delete(entity);
      } catch (DataIntegrityViolationException e) {
          throw new DatabaseException("Integrity violation");
      }
  	}
      public Tutor getBYId(Long id) {
        return repository.getReferenceById(id);
    }

    private void copyDtoToEntity(TutorRequest dto, Tutor entity) {
    	entity.setName(dto.getName());
    	entity.setEmail(dto.getEmail());
    	entity.setPassword(dto.getPassword());
    	entity.setCpf(dto.getCpf());
    	entity.setAddress(dto.getAddress());
    	entity.setCity(dto.getCity());
    	entity.setUf(dto.getUf());
    	entity.setPhone(dto.getPhone());
    	entity.setImage(dto.getImage());
    }
}
