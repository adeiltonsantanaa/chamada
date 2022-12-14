package br.com.as.chamada.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.as.chamada.model.vo.ChamadaRequestVO;

@Entity
@Table(name = "tb_registro_chamada")
public class ChamadaModel implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChamadaModel(Long matricula, DisciplinaModel discModel, Date datetime) {
		this.matricula = matricula;
		this.discModel = discModel;
		this.datetime = datetime;
	}

	public static ChamadaModel parseToChamadaModel(ChamadaRequestVO vo, DisciplinaModel disciplina) {
		return new ChamadaModel(vo.getMatricula(), disciplina, new Date());
	}

	public ChamadaModel() {
	}

	public ChamadaModel(Long matricula) {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long matricula;

	@ManyToOne
	@JoinColumn(name = "fk_turmaDisc")
	private DisciplinaModel discModel;

	@Column(name = "data_registro")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date datetime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DisciplinaModel getDiscModel() {
		return discModel;
	}

	public void setDiscModel(DisciplinaModel discModel) {
		this.discModel = discModel;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

}
