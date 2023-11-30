package models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	@Id
	private Integer numeroMatricula;
	@Column
	private String nomeAluno;
	@Column
	private String dataNascimento;
	@Column
	private String endereco;

	@ManyToOne
	@JoinColumn(name = "Id_Curso")
	private Curso curso;
	
	public Aluno() {
		
	}
	
	public Aluno(Integer numeroMatricula, String nomeAluno, String dataNascimento, String endereco, Curso curso) {
		this.numeroMatricula = numeroMatricula;
		this.nomeAluno = nomeAluno;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Aluno [numeroMatricula=" + numeroMatricula + ", nomeAluno=" + nomeAluno + ", dataNascimento="
				+ dataNascimento + ", endereco=" + endereco + "]";
	}
	
	

}
