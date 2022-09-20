package br.com.as.chamada.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class AlunoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 12, nullable = false, unique = true)
	private Long matricula;

	@Column(length = 50, unique = false)
	private String nome;

	@ManyToMany(mappedBy = "alunos")
	List<TurmaDisciplinaModel> turmaDisc;

}
