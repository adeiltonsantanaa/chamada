package br.com.as.chamada.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_turmaDisciplina")
public class TurmaDisciplinaModel {

	@Id
	private Long id;
	private String turmaNome;
	private String disciplinaNome;
	
	@ManyToOne
	@JoinColumn(name = "professor")
	private ProfessorModel professor;
}
