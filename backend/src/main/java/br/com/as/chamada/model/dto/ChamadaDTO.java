package br.com.as.chamada.model.dto;

import java.util.Date;

import br.com.as.chamada.model.entities.ChamadaModel;
import br.com.as.chamada.model.entities.DisciplinaModel;

public class ChamadaDTO {

	private Long id;
	private Long matricula;
	private Long disciplina;
	private Date date;
	private String professor;

	public ChamadaDTO(Long id, Long matricula, Long disciplina, Date date, String professor) {
		this.id = id;
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.date = date;
		this.professor = professor;
	}

	public ChamadaDTO() {
	}

	public static ChamadaDTO transformaParaDTO(Long id, Long matricula, Long disciplina, Date date, String professor) {
		return new ChamadaDTO(id, matricula, disciplina, date, professor);
	}
	public static ChamadaModel transformaParaOBJ(Long matricula, DisciplinaModel disciplina, Date datetime) {
		return new ChamadaModel(matricula, disciplina, datetime);
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

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

}
