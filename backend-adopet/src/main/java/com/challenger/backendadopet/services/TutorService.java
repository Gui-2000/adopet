package com.challenger.backendadopet.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenger.backendadopet.dto.TutorDTO;
import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.repositories.TutorRepository;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;

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
}
