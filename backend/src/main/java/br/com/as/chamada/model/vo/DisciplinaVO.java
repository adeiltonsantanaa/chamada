package br.com.as.chamada.model.vo;

import java.io.Serializable;

import br.com.as.chamada.model.entities.DisciplinaModel;

public class DisciplinaVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String turmaNome;
	private String disciplinaNome;
	private String professor;

	public DisciplinaVO(Long id, String turmaNome, String disciplinaNome, String professor) {
		this.id = id;
		this.turmaNome = turmaNome;
		this.disciplinaNome = disciplinaNome;
		this.professor = professor;
	}

	public DisciplinaVO() {
	}

	public static DisciplinaVO parseToVO(DisciplinaModel disciplina) {
		return new DisciplinaVO(disciplina.getId(), disciplina.getTurmaNome(), disciplina.getDisciplinaNome(),
				disciplina.getProfessor().getNome());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTurmaNome() {
		return turmaNome;
	}

	public void setTurmaNome(String turmaNome) {
		this.turmaNome = turmaNome;
	}

	public String getDisciplinaNome() {
		return disciplinaNome;
	}

	public void setDisciplinaNome(String disciplinaNome) {
		this.disciplinaNome = disciplinaNome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

}
