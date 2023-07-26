package com.challenger.backendadopet.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challenger.backendadopet.dto.TutorDTO;
import com.challenger.backendadopet.services.TutorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tutors")
public class TutorController {

    @Autowired
    private TutorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TutorDTO> findById(@PathVariable Long id) {
        TutorDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    
    @GetMapping
    public ResponseEntity<List<TutorDTO>> findAll() {
    	List<TutorDTO> list = service.findAll();
    	return ResponseEntity.ok().body(list);
    }
    
    @PostMapping
	public ResponseEntity<TutorDTO> insert(@Valid @RequestBody TutorDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
    
    @PutMapping(value = "/{id}")
	public ResponseEntity<TutorDTO> update(@PathVariable Long id, @Valid @RequestBody TutorDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
    
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<TutorDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
