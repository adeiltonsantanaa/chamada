package br.com.as.chamada.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_Disciplina")
public class DisciplinaModel {

	public DisciplinaModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false, unique = false)
	private String turmaNome;

	@Column(length = 50, nullable = false, unique = false)
	private String disciplinaNome;

	@ManyToOne
	@JoinColumn(name = "professor")
	private ProfessorModel professor;

	@JsonIgnore
	@OneToMany(mappedBy = "discModel")
	List<ChamadaModel> chamadaModel;

	@OneToMany(mappedBy = "discModel")
	List<RegistroAulaModel> regAula;

	@ManyToMany
	@JoinTable(name = "tb_disciplina_aluno", joinColumns = @JoinColumn(name = "desc_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private List<AlunoModel> aluno;

	public Long getId() {
		return id;
	}

	public String getTurmaNome() {
		return turmaNome;
	}

	public String getDisciplinaNome() {
		return disciplinaNome;
	}

	@JsonBackReference
	public ProfessorModel getProfessor() {
		return professor;
	}

	public List<ChamadaModel> getChamadaModel() {
		return chamadaModel;
	}

}
