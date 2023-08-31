package com.challenger.backendadopet.controllers;

import com.challenger.backendadopet.dtos.requesties.AdoptionRequest;
import com.challenger.backendadopet.dtos.responses.AdoptionResponse;
import com.challenger.backendadopet.services.AdoptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/adoptions")
public class AdoptionController {

    @Autowired
    private AdoptionService service;

    @GetMapping
    public ResponseEntity<Page<AdoptionResponse>> findAll(
            AdoptionRequest dto,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        Page<AdoptionResponse> list = service.findAllPaged(pageRequest, dto);
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<AdoptionResponse> insert(@Valid @RequestBody AdoptionRequest dto){
        AdoptionResponse response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getAdoptionId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
