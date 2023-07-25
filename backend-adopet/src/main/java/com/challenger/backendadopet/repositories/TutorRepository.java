package com.challenger.backendadopet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenger.backendadopet.entities.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
