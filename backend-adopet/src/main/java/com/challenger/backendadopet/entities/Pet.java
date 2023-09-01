package com.challenger.backendadopet.entities;

import com.challenger.backendadopet.enums.*;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pet")
@Data
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
    private LocalDateTime dateCreate = LocalDateTime.now();
    private PetAgeMonthOrYear ageMonthOrYear;
    private PetGenre genre;
    private PetStatus status;
    private PetCarrying carrying;

    @ManyToOne
    private Tutor owner;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;
}
