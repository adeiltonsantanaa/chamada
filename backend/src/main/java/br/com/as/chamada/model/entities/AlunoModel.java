package br.com.as.chamada.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class AlunoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long matricula;
	private String nome;
	
	@ManyToMany(mappedBy = "aluno")
	List<DisciplinaModel> discModel;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<DisciplinaModel> getDiscModel() {
		return discModel;
	}

	public void setDiscModel(List<DisciplinaModel> discModel) {
		this.discModel = discModel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(discModel, id, matricula, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoModel other = (AlunoModel) obj;
		return Objects.equals(discModel, other.discModel) && Objects.equals(id, other.id)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nome, other.nome);
	}
	
	
}
