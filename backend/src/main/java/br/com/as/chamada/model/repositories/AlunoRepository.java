package br.com.as.chamada.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.as.chamada.model.entities.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
	
	
	boolean findByMatricula(Long matricula);
	
	@Query("SELECT a FROM AlunoModel a WHERE a.matricula = :matricula")
	AlunoModel buscaPorMatricula(@Param("matricula") Long matricula);

}
