package com.challenger.backendadopet.dtos.requesties;

import com.challenger.backendadopet.entities.Adoption;

public class AdoptionRequest {

    private Long shelterId;
    private Long petId;

    public AdoptionRequest() {}

    public AdoptionRequest(Long shelterId, Long petId) {
        this.shelterId = shelterId;
        this.petId = petId;
    }

    public AdoptionRequest(Adoption entity) {
        shelterId = entity.getShelter().getId();
        petId = entity.getPet().getId();
    }

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
