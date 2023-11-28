package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	
	@Id
	public Integer Id;
	
	@Column(name="Nome_Curso")
	public String nomeCurso;
	
	@Column(name="matriculaAluno")
	public Integer matriculaAluno;
	
	

	public Curso(Integer id, String nomeCurso, Integer matriculaAluno) {
		super();
		Id = id;
		this.nomeCurso = nomeCurso;
		this.matriculaAluno = matriculaAluno;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Integer getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(Integer matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	
	
}