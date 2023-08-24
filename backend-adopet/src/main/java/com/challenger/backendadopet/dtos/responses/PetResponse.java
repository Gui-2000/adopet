package com.challenger.backendadopet.dtos.responses;

import com.challenger.backendadopet.entities.Pet;
import com.challenger.backendadopet.enums.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public PetResponse() {
    }

    public PetResponse(String name, String age, String description, PetSpecie specie, PetPersonality personality, LocalDateTime dateCreate, PetAgeMonthOrYear ageMonthOrYear, PetGenre genre, PetStatus status, PetCarrying carrying, Long ownerId, Long shelterId) {
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
