package br.com.as.chamada.model.dto;

import java.util.Date;

public class ChamadaDTO {

	private Long id;
	private Long disciplina;
	private Date date;
	private Long professor;

	public ChamadaDTO(Long id, Long disciplina, Date date, Long professor) {
		this.id = id;
		this.disciplina = disciplina;
		this.date = date;
		this.professor = professor;
	}

	public ChamadaDTO() {
	}

	public ChamadaDTO transformaParaDTO(Long id, Long disciplina, Date date, Long professor) {
		return new ChamadaDTO(id, disciplina, date, professor);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Long disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getProfessor() {
		return professor;
	}

	public void setProfessor(Long professor) {
		this.professor = professor;
	}

}
