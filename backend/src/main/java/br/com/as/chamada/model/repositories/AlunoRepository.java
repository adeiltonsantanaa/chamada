package br.com.as.chamada.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.as.chamada.model.entities.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

}
