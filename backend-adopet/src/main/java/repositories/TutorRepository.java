package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
