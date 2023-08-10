package com.challenger.backendadopet.repositories;

import com.challenger.backendadopet.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

	Tutor findByEmail(String email);
	Tutor findByCpf (String cpf);
}
