package models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	private Integer Id;
	
	@Column
	private String NomeCurso;
	
	@OneToMany
	@JoinTable(name="aluno_curso",  joinColumns = @JoinColumn(name="aluno_matricula"), inverseJoinColumns = @JoinColumn(name="curso_id"))
	private List<Aluno> aluno;
	
	private Curso() {
		
	}
	
	public Curso(Integer id, String nomeCurso) {
		Id = id;
		NomeCurso = nomeCurso;
	}
	
	public List<Aluno> getAluno(){
		return aluno;
	}
	public void AdicionaAluno(Aluno a) {
		aluno.add(a);
	}
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNomeCurso() {
		return NomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		NomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "Curso [Id=" + Id + ", NomeCurso=" + NomeCurso + "]";
	}

}
