package com.challenger.backendadopet.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_shelter")
@Data
public class Shelter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cnpj;
    private String phone;
    private String address;
    private String city;
    private String uf;
    private String image;

    @ManyToOne
    private Tutor responsible;

    @OneToMany(mappedBy = "shelter")
    private List<Pet> pets = new ArrayList<>();
}
