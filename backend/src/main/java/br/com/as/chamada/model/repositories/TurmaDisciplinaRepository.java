package br.com.as.chamada.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.as.chamada.model.entities.TurmaDisciplinaModel;

public interface TurmaDisciplinaRepository extends JpaRepository<TurmaDisciplinaModel, Long> {

}
