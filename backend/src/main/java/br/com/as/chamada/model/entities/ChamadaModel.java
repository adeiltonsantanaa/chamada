package br.com.as.chamada.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_registro_chamada")
public class ChamadaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_aluno")
	private AlunoModel alunoModel;
	
	@ManyToOne
	@JoinColumn(name = "fk_turmaDisc")
	private TurmaDisciplinaModel turmaDiscModel;
	
	@Column(name = "data_registro")
	private Date datetime;

	public AlunoModel getAlunoModel() {
		return alunoModel;
	}

	public void setAlunoModel(AlunoModel alunoModel) {
		this.alunoModel = alunoModel;
	}

	public TurmaDisciplinaModel getTurmaDiscModel() {
		return turmaDiscModel;
	}

	public void setTurmaDiscModel(TurmaDisciplinaModel turmaDiscModel) {
		this.turmaDiscModel = turmaDiscModel;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
