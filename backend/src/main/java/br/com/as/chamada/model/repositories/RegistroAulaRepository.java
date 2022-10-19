package br.com.as.chamada.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.as.chamada.model.entities.RegistroAulaModel;

@Repository
public interface RegistroAulaRepository extends JpaRepository<RegistroAulaModel, Long> {

}
