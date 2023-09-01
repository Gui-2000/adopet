package com.challenger.backendadopet.services;

import com.challenger.backendadopet.dtos.requesties.PetRequest;
import com.challenger.backendadopet.dtos.responses.PetResponse;
import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.repositories.PetRepository;
import com.challenger.backendadopet.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Page<PetResponse> findAllPaged(PageRequest pageRequest) {
        Page<Pet> list = repository.findAll(pageRequest);
        return list.map(x -> response.convert(x));
    }

    public PetResponse insert(PetRequest dto) {
        Pet entity = new Pet();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return response.convert(entity);
    }

    @Transactional
    public PetRequest update(Long id, PetRequest dto) {
        Optional<Pet> possiblePet = repository.findById(id);
        Pet pet = possiblePet.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        copyDtoToEntity(dto, pet);
        Pet save = repository.save(pet);
        return PetRequest.convertPetRequest(save);
    }

    public void delete(Long id) {
        Optional<Pet> obj =  repository.findById(id);
        Pet entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        repository.delete(entity);
    }

    public Pet getBYId(Long id) {
        return repository.getReferenceById(id);
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
