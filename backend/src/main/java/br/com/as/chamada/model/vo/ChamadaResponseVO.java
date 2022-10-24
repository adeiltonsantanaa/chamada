package br.com.as.chamada.model.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.as.chamada.model.entities.ChamadaModel;

public class ChamadaResponseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long matricula;
	@JsonBackReference
	private String disciplina;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date datetime;

	public ChamadaResponseVO() {
	}

	public ChamadaResponseVO(Long id, Long matricula, String disciplina, Date datetime) {
		this.id = id;
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.datetime = datetime;
	}

	public static ChamadaResponseVO parseToVO(ChamadaModel chamada) {
		return new ChamadaResponseVO(chamada.getId(), chamada.getMatricula(),
				chamada.getDiscModel().getDisciplinaNome(), chamada.getDatetime());

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

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
