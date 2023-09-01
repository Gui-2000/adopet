package com.challenger.backendadopet.dtos.responses;

import com.challenger.backendadopet.entities.Shelter;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ShelterResponse {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String uf;
    private String image;

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
