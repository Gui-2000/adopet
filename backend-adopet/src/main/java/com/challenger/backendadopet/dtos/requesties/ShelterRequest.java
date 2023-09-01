package com.challenger.backendadopet.dtos.requesties;

import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.services.validation.ShelterValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
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

    public static ShelterRequest convertShelterRequest(Shelter entity) {
        ShelterRequest shelterRequest = new ShelterRequest();
        shelterRequest.setId(entity.getId());
        shelterRequest.setName(entity.getName());
        shelterRequest.setEmail(entity.getEmail());
        shelterRequest.setCnpj(entity.getCnpj());
        shelterRequest.setPhone(entity.getPhone());
        shelterRequest.setAddress(entity.getAddress());
        shelterRequest.setCity(entity.getCity());
        shelterRequest.setUf(entity.getUf());
        shelterRequest.setImage(entity.getImage());
        shelterRequest.setTutorId(entity.getResponsible().getId());
        return shelterRequest;
    }
}
