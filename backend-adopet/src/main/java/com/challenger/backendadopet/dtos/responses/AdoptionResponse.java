package com.challenger.backendadopet.dtos.responses;

import com.challenger.backendadopet.entities.Adoption;
import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.enums.PetStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdoptionResponse {

    private Long AdoptionId;
    private String namePet;
    private String nameTutor;
    private LocalDateTime dateAdoption;
    private PetStatus status;

    public AdoptionResponse() {}

    public AdoptionResponse(Long adoptionId, String namePet, String nameTutor, LocalDateTime dateAdoption, PetStatus status) {
        AdoptionId = adoptionId;
        this.namePet = namePet;
        this.nameTutor = nameTutor;
        this.dateAdoption = dateAdoption;
        this.status = status;
    }

    public Long getAdoptionId() {
        return AdoptionId;
    }

    public void setAdoptionId(Long adoptionId) {
        AdoptionId = adoptionId;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getNameTutor() {
        return nameTutor;
    }

    public void setNameTutor(String nameTutor) {
        this.nameTutor = nameTutor;
    }

    public LocalDateTime getDateAdoption() {
        return dateAdoption;
    }

    public void setDateAdoption(LocalDateTime dateAdoption) {
        this.dateAdoption = dateAdoption;
    }

    public PetStatus getStatus() {
        return status;
    }

    public void setStatus(PetStatus status) {
        this.status = status;
    }

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
