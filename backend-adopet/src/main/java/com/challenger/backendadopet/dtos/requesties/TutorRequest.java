package com.challenger.backendadopet.dtos.requesties;

import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.services.validation.TutorValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
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

    public static TutorRequest convertTutorRequest(Tutor entity) {
        TutorRequest tutorRequest = new TutorRequest();
        tutorRequest.setId(entity.getId());
        tutorRequest.setName(entity.getName());
        tutorRequest.setEmail(entity.getEmail());
        tutorRequest.setPassword(entity.getPassword());
        tutorRequest.setCpf(entity.getCpf());
        tutorRequest.setAddress(entity.getAddress());
        tutorRequest.setCity(entity.getCity());
        tutorRequest.setUf(entity.getUf());
        tutorRequest.setPhone(entity.getPhone());
        tutorRequest.setImage(entity.getImage());
        return tutorRequest;
    }
}

