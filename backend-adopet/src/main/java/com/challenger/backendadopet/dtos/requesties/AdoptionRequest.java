package com.challenger.backendadopet.dtos.requesties;

import lombok.Data;

@Data
public class AdoptionRequest {

    private Long shelterId;
    private Long petId;
}
