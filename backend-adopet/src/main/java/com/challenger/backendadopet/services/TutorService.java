package com.challenger.backendadopet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenger.backendadopet.dto.TutorDTO;
import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.repositories.TutorRepository;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    @Transactional
    public TutorDTO findById(Long id) {
        Optional<Tutor> obj =  repository.findById(id);
        Tutor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new TutorDTO(entity);
    }
}
