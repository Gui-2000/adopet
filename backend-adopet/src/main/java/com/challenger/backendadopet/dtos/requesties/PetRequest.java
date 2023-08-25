package com.challenger.backendadopet.dtos.requesties;

import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public PetRequest() {
    }

    public PetRequest(Long id, String name, String age, String description, PetSpecie specie, PetPersonality personality, LocalDateTime dateCreate, PetAgeMonthOrYear ageMonthOrYear, PetGenre genre, PetStatus status, PetCarrying carrying, long ownerId, Long shelterId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.specie = specie;
        this.personality = personality;
        this.dateCreate = dateCreate;
        this.ageMonthOrYear = ageMonthOrYear;
        this.genre = genre;
        this.status = status;
        this.carrying = carrying;
        this.ownerId = ownerId;
        this.shelterId = shelterId;
    }

    public PetRequest(Pet entity) {
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        description = entity.getDescription();
        specie = entity.getSpecie();
        personality = entity.getPersonality();
        dateCreate = entity.getDateCreate();
        ageMonthOrYear = entity.getAgeMonthOrYear();
        genre = entity.getGenre();
        status = entity.getStatus();
        carrying = entity.getCarrying();
        ownerId = entity.getOwner().getId();
        shelterId = entity.getShelter().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetSpecie getSpecie() {
        return specie;
    }

    public void setSpecie(PetSpecie specie) {
        this.specie = specie;
    }

    public PetPersonality getPersonality() {
        return personality;
    }

    public void setPersonality(PetPersonality personality) {
        this.personality = personality;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public PetAgeMonthOrYear getAgeMonthOrYear() {
        return ageMonthOrYear;
    }

    public void setAgeMonthOrYear(PetAgeMonthOrYear ageMonthOrYear) {
        this.ageMonthOrYear = ageMonthOrYear;
    }

    public PetGenre getGenre() {
        return genre;
    }

    public void setGenre(PetGenre genre) {
        this.genre = genre;
    }

    public PetStatus getStatus() {
        return status;
    }

    public void setStatus(PetStatus status) {
        this.status = status;
    }

    public PetCarrying getCarrying() {
        return carrying;
    }

    public void setCarrying(PetCarrying carrying) {
        this.carrying = carrying;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetRequest that = (PetRequest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
