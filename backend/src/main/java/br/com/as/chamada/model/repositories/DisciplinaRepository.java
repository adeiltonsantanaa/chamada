package br.com.as.chamada.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.as.chamada.model.entities.DisciplinaModel;

public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Long> {

}
