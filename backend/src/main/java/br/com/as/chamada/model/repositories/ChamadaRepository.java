package br.com.as.chamada.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.as.chamada.model.entities.ChamadaModel;

public interface ChamadaRepository extends JpaRepository<ChamadaModel, Long> {

}
