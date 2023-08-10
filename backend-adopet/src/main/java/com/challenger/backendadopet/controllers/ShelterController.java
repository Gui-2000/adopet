package com.challenger.backendadopet.controllers;

import com.challenger.backendadopet.dtos.responses.ShelterResponse;
import com.challenger.backendadopet.services.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shelters")
public class ShelterController {

    @Autowired
    private ShelterService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ShelterResponse> findById(@PathVariable Long id) {
        ShelterResponse resp = service.findById(id);
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping
    public ResponseEntity<List<ShelterResponse>> findAll() {
        List<ShelterResponse> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
