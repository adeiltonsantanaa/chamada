package br.com.as.chamada.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.as.chamada.model.entities.ChamadaModel;

@Repository
public interface ChamadaRepository extends JpaRepository<ChamadaModel, Long> {

	@Query("SELECT c FROM ChamadaModel c")
	List<ChamadaModel> buscarTodas();

}
