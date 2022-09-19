package br.com.as.chamada.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.as.chamada.model.entities.ProfessorModel;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {

}
