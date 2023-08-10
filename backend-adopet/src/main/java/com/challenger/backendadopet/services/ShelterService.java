package com.challenger.backendadopet.services;

import com.challenger.backendadopet.dtos.requesties.ShelterRequest;
import com.challenger.backendadopet.dtos.requesties.TutorRequest;
import com.challenger.backendadopet.dtos.responses.ShelterResponse;
import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.repositories.ShelterRepository;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;
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

    private void copyDtoToEntity(ShelterRequest dto, Shelter entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setCnpj(dto.getCnpj());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setUf(dto.getUf());
        entity.setImage(dto.getImage());
        entity.setResponsible(entity.getResponsible());
    }
}
