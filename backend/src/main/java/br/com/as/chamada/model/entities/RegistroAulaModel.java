package br.com.as.chamada.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.as.chamada.model.vo.RegistroAulaRequestVO;

@Entity
@Table(name = "tb_registro_aula")
public class RegistroAulaModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;

	private LocalDate dataRegistro;

	@ManyToOne
	@JoinColumn(name = "professor")
	private ProfessorModel professor;

	@ManyToOne
	@JoinColumn(name = "fk_turmaDisc")
	private DisciplinaModel discModel;

	public RegistroAulaModel() {
	}

	public RegistroAulaModel(String descricao, LocalDate dataRegistro, ProfessorModel professor,
			DisciplinaModel discModel) {
		this.descricao = descricao;
		this.dataRegistro = dataRegistro;
		this.professor = professor;
		this.discModel = discModel;
	}

	public static RegistroAulaModel parseToRegistroAulaModel(RegistroAulaRequestVO vo, ProfessorModel professor,
			DisciplinaModel disciplina) {
		return new RegistroAulaModel(vo.getDescricao(), vo.getDataRegistro(), professor, disciplina);
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

	public ProfessorModel getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorModel professor) {
		this.professor = professor;
	}

	public DisciplinaModel getDiscModel() {
		return discModel;
	}

	public void setDiscModel(DisciplinaModel discModel) {
		this.discModel = discModel;
	}

}
