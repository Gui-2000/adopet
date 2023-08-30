package com.challenger.backendadopet.controllers;

import com.challenger.backendadopet.dtos.requesties.PetRequest;
import com.challenger.backendadopet.dtos.responses.PetResponse;
import com.challenger.backendadopet.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetResponse> findById(@PathVariable Long id) {
        PetResponse resp = service.findById(id);
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping
    public ResponseEntity<Page<PetResponse>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage
            ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        Page<PetResponse> list = service.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<PetResponse> insert(@Valid @RequestBody PetRequest dto){
        PetResponse response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PetRequest> update(@PathVariable Long id, @Valid @RequestBody PetRequest dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
