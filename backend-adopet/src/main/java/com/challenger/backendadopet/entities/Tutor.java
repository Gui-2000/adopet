package com.challenger.backendadopet.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_tutor")
@Data
public class Tutor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Column(unique = true)
    private String email;
    private String password;
    
    @Column(unique = true)
    private String cpf;
    private String address;
    private String city;
    private String uf;
    private String phone;
    private String image;

    @OneToMany(mappedBy = "responsible")
    private List<Shelter> shelters = new ArrayList<>();
}
