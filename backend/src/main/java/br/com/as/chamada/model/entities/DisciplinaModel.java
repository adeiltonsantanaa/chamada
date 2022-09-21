package br.com.as.chamada.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_Disciplina")
public class DisciplinaModel {

	public DisciplinaModel(Long id, String turmaNome, String disciplinaNome, ProfessorModel professor,
			List<ChamadaModel> chamadaModel) {
		this.id = id;
		this.turmaNome = turmaNome;
		this.disciplinaNome = disciplinaNome;
		this.professor = professor;
		this.chamadaModel = chamadaModel;
	}

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

	@OneToMany(mappedBy = "discModel")
	List<ChamadaModel> chamadaModel;

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
