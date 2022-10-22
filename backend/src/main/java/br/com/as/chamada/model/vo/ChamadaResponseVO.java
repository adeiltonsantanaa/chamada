package br.com.as.chamada.model.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ChamadaResponseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long matricula;
	@JsonBackReference
	private Long disciplina;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date datetime;

	public ChamadaResponseVO() {
	}

	public ChamadaResponseVO(Long id, Long matricula, Long disciplina, Date datetime) {
		this.id = id;
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.datetime = datetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Long getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Long disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
