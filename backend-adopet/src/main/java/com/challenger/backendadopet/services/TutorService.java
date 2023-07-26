package com.challenger.backendadopet.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenger.backendadopet.dto.TutorDTO;
import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.repositories.TutorRepository;
import com.challenger.backendadopet.services.exceptions.DatabaseException;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    @Transactional(readOnly = true)
    public TutorDTO findById(Long id) {
        Optional<Tutor> obj =  repository.findById(id);
        Tutor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new TutorDTO(entity);
    }
    
    @Transactional(readOnly = true)
    public List<TutorDTO> findAll() {
    	List<Tutor> list = repository.findAll();
    	return list.stream().map(x -> new TutorDTO(x)).collect(Collectors.toList());
    }
    
    @Transactional
    public TutorDTO insert(TutorDTO dto) {
    	Tutor entity = new Tutor();
    	copyDtoToEntity(dto, entity);
    	entity = repository.save(entity);
    	return new TutorDTO(entity);
    }
    
    @Transactional
    public TutorDTO update(Long id,TutorDTO dto) {
    	try {
    		Tutor entity = repository.getReferenceById(id);
    		copyDtoToEntity(dto, entity);
        	entity = repository.save(entity);
        	return new TutorDTO(entity);
         } catch (EntityNotFoundException e) {
              throw new ResourceNotFoundException("Id not found " + id);
       }
    }
    
    public void delete(Long id) {
  	   try {
  		repository.deleteById(id);
  	  }
  	  catch(EmptyResultDataAccessException e) {
  	    throw new ResourceNotFoundException("Id not found " + id);
  	  }
  	  catch(DataIntegrityViolationException e) {
  		throw new DatabaseException("Integrity violation");
  	  }
  	}
    
    private void copyDtoToEntity(TutorDTO dto, Tutor entity) {
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
