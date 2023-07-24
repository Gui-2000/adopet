package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.TutorDTO;
import services.TutorService;

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
}
