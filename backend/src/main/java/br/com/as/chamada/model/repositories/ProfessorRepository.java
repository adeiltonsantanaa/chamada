package br.com.as.chamada.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.as.chamada.model.entities.ProfessorModel;
@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {

}
