package com.challenger.backendadopet.controllers;

import com.challenger.backendadopet.dtos.requesties.TutorRequest;
import com.challenger.backendadopet.dtos.responses.TutorResponse;
import com.challenger.backendadopet.services.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tutors")
public class TutorController {

    @Autowired
    private TutorService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<TutorResponse> findById(@PathVariable Long id) {
    	TutorResponse resp = service.findById(id);
        return ResponseEntity.ok().body(resp);
    }
    
    @GetMapping
    public ResponseEntity<List<TutorResponse>> findAll() {
    	List<TutorResponse> list = service.findAll();
    	return ResponseEntity.ok().body(list);
    }
    
    @PostMapping
	public ResponseEntity<TutorResponse> insert(@Valid @RequestBody TutorRequest dto){
    	TutorResponse response = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(response);
	}
    
    @PutMapping(value = "/{id}")
	public ResponseEntity<TutorRequest> update(@PathVariable Long id, @Valid @RequestBody TutorRequest dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
    
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
