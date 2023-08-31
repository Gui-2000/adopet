package com.challenger.backendadopet.services;

import com.challenger.backendadopet.dtos.requesties.AdoptionRequest;
import com.challenger.backendadopet.dtos.responses.AdoptionResponse;
import com.challenger.backendadopet.dtos.responses.PetResponse;
import com.challenger.backendadopet.entities.Adoption;
import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.repositories.AdoptionRepository;
import com.challenger.backendadopet.repositories.PetRepository;
import com.challenger.backendadopet.repositories.ShelterRepository;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdoptionService {
    @Autowired
    private AdoptionRepository repository;

    @Autowired
    private ShelterRepository repositoryShelter;

    @Autowired
    private PetRepository repositoryPet;

    @Autowired
    private PetService petService;

    @Autowired
    private ShelterService shelterService;

    @Autowired
    private AdoptionResponse response;

    @Transactional(readOnly = true)
    public Page<AdoptionResponse> findAllPaged(PageRequest pageRequest, AdoptionRequest dto) {
        Optional<Shelter> possibleShelter = repositoryShelter.findById(dto.getShelterId());
        Shelter shelter = possibleShelter.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        Optional<Pet> possiblePet = repositoryPet.findById(dto.getPetId());
        Pet pet = possiblePet.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        Page<Adoption> list = repository.findAll(pageRequest);
        return list.map(x -> response.convert(x, pet, shelter));
    }

    public void delete(Long id) {
        Optional<Adoption> obj =  repository.findById(id);
        Adoption entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        repository.delete(entity);
    }

    public AdoptionResponse insert(AdoptionRequest dto) {
        Optional<Shelter> possibleShelter = repositoryShelter.findById(dto.getShelterId());
        Shelter shelter = possibleShelter.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        Optional<Pet> possiblePet = repositoryPet.findById(dto.getPetId());
        Pet pet = possiblePet.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        Adoption entity = new Adoption();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return response.convert(entity, pet, shelter);
    }

    private void copyDtoToEntity(AdoptionRequest dto, Adoption entity) {
        entity.setPet(petService.getBYId(dto.getPetId()));
        entity.setShelter(shelterService.getBYId(dto.getShelterId()));
    }
}
