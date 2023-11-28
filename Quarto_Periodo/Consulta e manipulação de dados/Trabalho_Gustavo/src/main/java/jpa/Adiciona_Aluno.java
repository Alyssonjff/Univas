package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Adiciona_Aluno {
	public static void main(String[]args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoRelacionamento");
		EntityManager em = emf.createEntityManager();
	    Scanner scanner = new Scanner(System.in);
	    
	    
	    	System.out.println("Digite a Matricula do Aluno:");
	    	Integer matriculaAluno = scanner.nextInt();
	  
	    	System.out.println("Digite o nome do Aluno:");
		    String nomeAluno = scanner.nextLine();
		    
		    System.out.println("Digite o Endereço do Aluno:");
		    String endereco = scanner.nextLine();
		    
		    System.out.println("Digite a data de nascimento do Aluno:");
		    String nascimento = scanner.nextLine();
		    
		    System.out.println("Digite ID do curso que o Aluno participara:");
		    String IdCurso = scanner.nextLine();
		    
		    Aluno aluno = new Aluno(matriculaAluno, nomeAluno, endereco, nascimento);
		   
		    em.getTransaction().begin();
		 
		    em.persist(aluno);
		   
		    em.getTransaction().commit();
		    
		    em.close();
		    emf.close();
		    
		    System.out.println("\nAluno adicionado com sucesso!\n");
	}
}
