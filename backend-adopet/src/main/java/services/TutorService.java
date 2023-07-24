package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.TutorDTO;
import entities.Tutor;
import jakarta.transaction.Transactional;
import repositories.TutorRepository;
import services.exceptions.ResourceNotFoundException;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    @Transactional
    public TutorDTO findById(Long id) {
        Optional<Tutor> obj =  repository.findById(id);
        Tutor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new TutorDTO(entity);
    }
}
