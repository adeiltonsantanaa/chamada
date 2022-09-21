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

@Entity
@Table(name = "tb_turmaDisciplina")
public class TurmaDisciplinaModel {

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
	
	@OneToMany(mappedBy = "turmaDiscModel")
	List<ChamadaModel> chamadaModel;

	@ManyToMany
	@JoinTable(name = "tb_disciplina_aluno", 
	joinColumns = @JoinColumn(name = "fk_turmaDisc"), 
	inverseJoinColumns = @JoinColumn(name = "fk_aluno"))
	List<AlunoModel> alunos;

	public String getTurmaNome() {
		return turmaNome;
	}

	public void setTurmaNome(String turmaNome) {
		this.turmaNome = turmaNome;
	}

	public String getDisciplinaNome() {
		return disciplinaNome;
	}

	public void setDisciplinaNome(String disciplinaNome) {
		this.disciplinaNome = disciplinaNome;
	}

	public ProfessorModel getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorModel professor) {
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}
	
	
	
	

}
