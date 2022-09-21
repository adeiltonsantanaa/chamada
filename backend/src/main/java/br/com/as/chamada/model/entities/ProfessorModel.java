package br.com.as.chamada.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_professor")
public class ProfessorModel {

	public ProfessorModel(Long id, String nome, List<DisciplinaModel> turmaDisciplina) {
		this.id = id;
		this.nome = nome;
		this.turmaDisciplina = turmaDisciplina;
	}

	public ProfessorModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false, unique = false)
	private String nome;

	@OneToMany(mappedBy = "professor")
	List<DisciplinaModel> turmaDisciplina;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public List<DisciplinaModel> getTurmaDisciplina() {
		return turmaDisciplina;
	}

}
