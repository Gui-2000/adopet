package com.challenger.backendadopet.dtos.requesties;

import com.challenger.backendadopet.entities.Shelter;

import java.util.Objects;

public class ShelterRequest {

    private Long id;
    private String name;
    private String email;
    private String cnpj;
    private String phone;
    private String address;
    private String city;
    private String uf;
    private String image;
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
