package com.challenger.backendadopet.dtos.responses;

import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.enums.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
public class PetResponse {

    private String name;
    private String age;
    private String description;
    private PetSpecie specie;
    private PetPersonality personality;
    private LocalDateTime dateCreate;
    private PetAgeMonthOrYear ageMonthOrYear;
    private PetGenre genre;
    private PetStatus status;
    private PetCarrying carrying;
    private Long ownerId;
    private Long shelterId;

    public PetResponse convert(Pet pet) {
        PetResponse response = new PetResponse();
        response.setName(pet.getName());
        response.setAge(pet.getAge());
        response.setDescription(pet.getDescription());
        response.setSpecie(pet.getSpecie());
        response.setPersonality(pet.getPersonality());
        response.setDateCreate(pet.getDateCreate());
        response.setAgeMonthOrYear(pet.getAgeMonthOrYear());
        response.setGenre(pet.getGenre());
        response.setStatus(pet.getStatus());
        response.setCarrying(pet.getCarrying());
        response.setOwnerId(pet.getOwner().getId());
        response.setShelterId(pet.getShelter().getId());
        return response;
    }
}
