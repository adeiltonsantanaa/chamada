package br.com.as.chamada.model.vo;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.as.chamada.model.entities.RegistroAulaModel;

public class RegistroAulaResponseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataRegistro;
	private String professor;
	private String discModel;

	public RegistroAulaResponseVO() {
	}

	public RegistroAulaResponseVO(Long id, String descricao, LocalDate dataRegistro, String professor,
			String discModel) {
		this.id = id;
		this.descricao = descricao;
		this.dataRegistro = dataRegistro;
		this.professor = professor;
		this.discModel = discModel;
	}

	public static RegistroAulaResponseVO parseToVO(RegistroAulaModel reg) {
		return new RegistroAulaResponseVO(reg.getId(), reg.getDescricao(), reg.getDataRegistro(),
				reg.getProfessor().getNome(), reg.getDiscModel().getDisciplinaNome());
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

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getDiscModel() {
		return discModel;
	}

	public void setDiscModel(String discModel) {
		this.discModel = discModel;
	}

}
