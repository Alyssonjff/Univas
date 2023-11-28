package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	public Integer numeroMatricula;
	
	@Column(name="nome")
	public String nomeAluno;
	
	@Column(name="endereco")
	public String endereco;
	
	@Column(name="dataNascimento")
	public String dataNasc;
	
	

	public Aluno(Integer numeroMatricula, String nomeAluno, String endereco, String dataNasc) {
		super();
		this.numeroMatricula = numeroMatricula;
		this.nomeAluno = nomeAluno;
		this.endereco = endereco;
		this.dataNasc = dataNasc;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
	
	
}