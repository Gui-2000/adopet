package com.challenger.backendadopet.dtos.requesties;

import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.services.validation.TutorValid;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@TutorValid
public class TutorRequest {

    private Long id;
    
    @Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    
    @Email(message = "Favor coloca um email valido")
    private String email;
    
    @NotBlank(message = "Campo requerido")
    private String password;
    
    @NotBlank(message = "Campo requerido")
    private String cpf;
    
    @NotBlank(message = "Campo requerido")
    private String address;
    
    @NotBlank(message = "Campo requerido")
    private String city;
    
    @NotBlank(message = "Campo requerido")
    private String uf;
    
    @NotBlank(message = "Campo requerido")
    @Size(min = 11, max = 11, message = "Deve ter exatos 11 numeros para ser valido")
    private String phone;
    
    @NotBlank(message = "Campo requerido")
    private String image;

    public TutorRequest() {
    }

    public TutorRequest(Long id, String name, String email, String password, String cpf, String address, String city, String uf, String phone, String image) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.address = address;
        this.city = city;
        this.uf = uf;
        this.phone = phone;
        this.image = image;
    }

    public TutorRequest(Tutor entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        password = entity.getPassword();
        cpf = entity.getCpf();
        address = entity.getAddress();
        city = entity.getCity();
        uf = entity.getUf();
        phone = entity.getPhone();
        image = entity.getImage();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

