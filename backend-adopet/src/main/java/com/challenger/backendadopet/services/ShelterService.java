package com.challenger.backendadopet.services;

import com.challenger.backendadopet.dtos.requesties.ShelterRequest;
import com.challenger.backendadopet.dtos.responses.ShelterResponse;
import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.repositories.ShelterRepository;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShelterService {
    @Autowired
    private ShelterRepository repository;
    @Autowired
    private TutorService tutorService;

    @Autowired
    private ShelterResponse response;

    @Transactional(readOnly = true)
    public ShelterResponse findById(Long id) {
        Optional<Shelter> obj =  repository.findById(id);
        Shelter entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return response.convert(entity);
    }

    @Transactional(readOnly = true)
    public List<ShelterResponse> findAll() {
        List<Shelter> list = repository.findAll();
        return list.stream().map(x -> response.convert(x)).collect(Collectors.toList());
    }

    public ShelterResponse insert(ShelterRequest dto) {
        Shelter entity = new Shelter();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return response.convert(entity);
    }

    @Transactional
    public ShelterRequest update(Long id, ShelterRequest dto) {
        try {
            Shelter entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ShelterRequest(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }
    public void delete(Long id) {
        Optional<Shelter> obj =  repository.findById(id);
        Shelter entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        repository.delete(entity);
    }

    public Shelter getBYId(Long id) {
        return repository.getReferenceById(id);
    }

    private void copyDtoToEntity(ShelterRequest dto, Shelter entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setCnpj(dto.getCnpj());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setUf(dto.getUf());
        entity.setImage(dto.getImage());
        entity.setResponsible(tutorService.getBYId(dto.getTutorId()));
    }
}
