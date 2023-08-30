package com.challenger.backendadopet.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_adoption")
public class Adoption implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime datAdoption = LocalDateTime.now();

    @OneToOne
    private Shelter shelter;
    @OneToOne
    private Pet pet;

    public Adoption() {
    }

    public Adoption(Long id, LocalDateTime datAdoption, Shelter shelter, Pet pet) {
        this.id = id;
        this.datAdoption = datAdoption;
        this.shelter = shelter;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatAdoption() {
        return datAdoption;
    }

    public void setDatAdoption(LocalDateTime datAdoption) {
        this.datAdoption = datAdoption;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
