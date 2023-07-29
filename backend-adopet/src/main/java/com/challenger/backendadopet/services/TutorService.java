package com.challenger.backendadopet.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenger.backendadopet.dtos.requesties.TutorRequest;
import com.challenger.backendadopet.dtos.responses.TutorResponse;
import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.repositories.TutorRepository;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;
    
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
    public TutorRequest update(Long id,TutorRequest dto) {
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
       Optional<Tutor> obj =  repository.findById(id);
       Tutor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
       repository.delete(entity);
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
