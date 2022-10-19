package br.com.as.chamada.model.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.as.chamada.model.entities.ProfessorModel;

public class DisciplinaVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonIgnore
	private String turmaNome;
	private String disciplinaNome;
	@JsonIgnore
	private ProfessorModel professor;

	public DisciplinaVO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
