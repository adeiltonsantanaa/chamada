package br.com.as.chamada.model.vo;

import java.io.Serializable;
import java.time.LocalDate;

public class RegistroAulaVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private LocalDate dataRegistro;
	private Long professor;
	private Long discModel;

	public RegistroAulaVO() {
	}

	public RegistroAulaVO(String descricao, LocalDate dataRegistro, Long professor, Long discModel) {
		this.descricao = descricao;
		this.dataRegistro = dataRegistro;
		this.professor = professor;
		this.discModel = discModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Long getProfessor() {
		return professor;
	}

	public void setProfessor(Long professor) {
		this.professor = professor;
	}

	public Long getDiscModel() {
		return discModel;
	}

	public void setDiscModel(Long discModel) {
		this.discModel = discModel;
	}

}
