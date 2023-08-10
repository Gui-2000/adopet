package com.challenger.backendadopet.dtos.requesties;

import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.services.validation.ShelterValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@ShelterValid
public class ShelterRequest {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Email(message = "Favor coloca um email valido")
    private String email;
    @NotBlank(message = "Campo requerido")
    private String cnpj;

    @NotBlank(message = "Campo requerido")
    @Size(min = 11, max = 11, message = "Deve ter exatos 11 numeros para ser valido")
    private String phone;
    @NotBlank(message = "Campo requerido")
    private String address;
    @NotBlank(message = "Campo requerido")
    private String city;
    @NotBlank(message = "Campo requerido")
    private String uf;
    @NotBlank(message = "Campo requerido")
    private String image;
    @NotNull(message = "Campo requerido")
    private Long tutorId;

    public ShelterRequest() {
    }

    public ShelterRequest(Long id, String name, String email, String cnpj, String phone, String address, String city, String uf, String image, Long tutorId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cnpj = cnpj;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.uf = uf;
        this.image = image;
        this.tutorId = tutorId;
    }

    public ShelterRequest(Shelter entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        cnpj = entity.getCnpj();
        phone = entity.getPhone();
        address = entity.getAddress();
        city = entity.getCity();
        uf = entity.getUf();
        image = entity.getImage();
        tutorId = entity.getResponsible().getId();
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelterRequest that = (ShelterRequest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
