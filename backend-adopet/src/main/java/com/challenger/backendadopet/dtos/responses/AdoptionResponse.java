package com.challenger.backendadopet.dtos.responses;

import com.challenger.backendadopet.entities.Adoption;
import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.enums.PetStatus;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
public class AdoptionResponse {

    private Long AdoptionId;
    private String namePet;
    private String nameTutor;
    private LocalDateTime dateAdoption;
    private PetStatus status;

    public AdoptionResponse convert(Adoption adoption, Pet pet, Shelter shelter) {
        AdoptionResponse response = new AdoptionResponse();
        response.setAdoptionId(adoption.getId());
        response.setNamePet(pet.getName());
        response.setNameTutor(shelter.getResponsible().getName());
        response.setDateAdoption(adoption.getDatAdoption());
        response.setStatus(pet.getStatus());
        return response;
    }
}
