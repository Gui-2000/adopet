package com.challenger.backendadopet.entities;

import com.challenger.backendadopet.enums.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_pet")
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @ManyToOne
    private Tutor owner;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    public Pet() {
    }

    public Pet(Long id, String name, String age, String description, Shelter shelter, PetSpecie specie, PetPersonality personality, Tutor owner, LocalDateTime dateCreate, PetAgeMonthOrYear ageMonthOrYear, PetGenre genre, PetStatus status, PetCarrying carrying) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.shelter = shelter;
        this.specie = specie;
        this.personality = personality;
        this.owner = owner;
        this.dateCreate = dateCreate;
        this.ageMonthOrYear = ageMonthOrYear;
        this.genre = genre;
        this.status = status;
        this.carrying = carrying;
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

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
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

    public Tutor getOwner() {
        return owner;
    }

    public void setOwner(Tutor owner) {
        this.owner = owner;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
