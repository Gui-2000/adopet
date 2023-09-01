package com.challenger.backendadopet.dtos.requesties;

import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PetRequest {

    private Long id;
    @Size(min = 3, max = 50, message = "Deve ter entre 3 e 50 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    private String age;
    @NotNull(message = "Campo requerido")
    private String description;
    @NotNull(message = "Campo requerido")
    private PetSpecie specie;
    @NotNull(message = "Campo requerido")
    private PetPersonality personality;
    @NotNull(message = "Campo requerido")
    private LocalDateTime dateCreate;
    @NotNull(message = "Campo requerido")
    private PetAgeMonthOrYear ageMonthOrYear;
    @NotNull(message = "Campo requerido")
    private PetGenre genre;
    @NotNull(message = "Campo requerido")
    private PetStatus status;
    @NotNull(message = "Campo requerido")
    private PetCarrying carrying;
    @NotNull(message = "Campo requerido")
    private Long ownerId;
    @NotNull(message = "Campo requerido")
    private Long shelterId;

    public static PetRequest convertPetRequest(Pet entity) {
        PetRequest petRequest = new PetRequest();
        petRequest.setId(entity.getId());
        petRequest.setName(entity.getName());
        petRequest.setAge(entity.getAge());
        petRequest.setDescription(entity.getDescription());
        petRequest.setSpecie(entity.getSpecie());
        petRequest.setPersonality(entity.getPersonality());
        petRequest.setDateCreate(entity.getDateCreate());
        petRequest.setAgeMonthOrYear(entity.getAgeMonthOrYear());
        petRequest.setGenre(entity.getGenre());
        petRequest.setStatus(entity.getStatus());
        petRequest.setCarrying(entity.getCarrying());
        petRequest.setOwnerId(entity.getOwner().getId());
        petRequest.setShelterId(entity.getShelter().getId());
        return petRequest;
    }
}
