package br.com.as.chamada.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class ProfessorModel {
	
	@Id
	private Long id;
	private String nome;

}
