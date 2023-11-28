package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Adiciona_Curso {
	public static void main(String[]args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoRelacionamento");
		EntityManager em = emf.createEntityManager();
	    Scanner scanner = new Scanner(System.in);
	    
	    
	    	System.out.println("Digite o ID do curso:");
	    	Integer idCurso = scanner.nextInt();
	  
	    	System.out.println("Digite a Materia do curso:");
	    	scanner.next();
		    String Materia = scanner.nextLine();
		    
		    System.out.println("Digite a matricula do aluno:");
		    Integer matriculaAluno = scanner.nextInt();
		    
		    Curso curso = new Curso(idCurso, Materia, matriculaAluno);
		   
		    em.getTransaction().begin();
		 
		    em.persist(curso);
		   
		    em.getTransaction().commit();
		    
		    em.close();
		    emf.close();
		    
		    System.out.println("\nCurso adicionado com sucesso!\n");
	}
}
