package com.challenger.backendadopet.dtos.responses;

import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.entities.Tutor;
import org.springframework.stereotype.Service;

@Service
public class ShelterResponse {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String uf;
    private String image;

    public ShelterResponse() {
    }

    public ShelterResponse(String name, String email, String phone, String address, String city, String uf, String image) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.uf = uf;
        this.image = image;
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

    public ShelterResponse convert(Shelter shelter) {
        ShelterResponse response = new ShelterResponse();
        response.setName(shelter.getName());
        response.setEmail(shelter.getEmail());
        response.setPhone(shelter.getPhone());
        response.setAddress(shelter.getAddress());
        response.setCity(shelter.getCity());
        response.setUf(shelter.getUf());
        response.setImage(shelter.getImage());
        return response;
    }
}
