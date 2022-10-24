package br.com.as.chamada.model.vo;

import br.com.as.chamada.model.entities.AlunoModel;

public class AlunoVO {

	private Long id;
	private Long matricula;
	private String nome;

	public AlunoVO() {
	}

	public AlunoVO(Long id, Long matricula, String nome) {
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
	}

	public static AlunoVO parseToVO(AlunoModel aluno) {
		return new AlunoVO(aluno.getId(), aluno.getMatricula(), aluno.getNome());
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
