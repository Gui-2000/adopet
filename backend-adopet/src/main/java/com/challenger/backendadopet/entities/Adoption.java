package com.challenger.backendadopet.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_adoption")
@Data
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
}
