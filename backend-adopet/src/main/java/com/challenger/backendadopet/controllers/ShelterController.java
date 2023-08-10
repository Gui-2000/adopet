package com.challenger.backendadopet.controllers;

import com.challenger.backendadopet.dtos.requesties.ShelterRequest;
import com.challenger.backendadopet.dtos.responses.ShelterResponse;
import com.challenger.backendadopet.services.ShelterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<ShelterResponse> insert(@RequestBody ShelterRequest dto){
        ShelterResponse response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ShelterRequest> update(@PathVariable Long id, @Valid @RequestBody ShelterRequest dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
