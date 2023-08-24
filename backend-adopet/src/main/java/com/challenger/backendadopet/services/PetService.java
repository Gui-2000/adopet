package com.challenger.backendadopet.services;

import com.challenger.backendadopet.dtos.requesties.PetRequest;
import com.challenger.backendadopet.dtos.responses.PetResponse;
import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.repositories.PetRepository;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    @Autowired
    private ShelterService shelterService;

    @Autowired
    private TutorService tutorService;

    @Autowired
    private PetResponse response;

    @Transactional(readOnly = true)
    public PetResponse findById(Long id) {
        Optional<Pet> obj =  repository.findById(id);
        Pet entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return response.convert(entity);
    }

    @Transactional(readOnly = true)
    public List<PetResponse> findAll() {
        List<Pet> list = repository.findAll();
        return list.stream().map(x -> response.convert(x)).collect(Collectors.toList());
    }

    public PetResponse insert(PetRequest dto) {
        Pet entity = new Pet();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return response.convert(entity);
    }

    @Transactional
    public PetRequest update(Long id, PetRequest dto) {
        try {
            Pet entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new PetRequest(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        Optional<Pet> obj =  repository.findById(id);
        Pet entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        repository.delete(entity);
    }

    private void copyDtoToEntity(PetRequest dto, Pet entity) {
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setDescription(dto.getDescription());
        entity.setSpecie(dto.getSpecie());
        entity.setPersonality(dto.getPersonality());
        entity.setDateCreate(dto.getDateCreate());
        entity.setAgeMonthOrYear(dto.getAgeMonthOrYear());
        entity.setGenre(dto.getGenre());
        entity.setStatus(dto.getStatus());
        entity.setCarrying(dto.getCarrying());
        entity.setOwner(tutorService.getBYId(dto.getOwnerId()));
        entity.setShelter(shelterService.getBYId(dto.getShelterId()));
    }
}
