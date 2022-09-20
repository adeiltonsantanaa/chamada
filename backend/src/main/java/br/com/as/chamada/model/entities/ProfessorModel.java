package br.com.as.chamada.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class ProfessorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	List<TurmaDisciplinaModel> turmaDisc;

	public String getNome() {
		return nome;
	}

	public List<TurmaDisciplinaModel> getTurmaDisc() {
		return turmaDisc;
	}

	public void setTurmaDisc(List<TurmaDisciplinaModel> turmaDisc) {
		this.turmaDisc = turmaDisc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	
	
	
}
