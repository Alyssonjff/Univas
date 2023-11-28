package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exclui_Aluno {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoRelacionamento");
		EntityManager em = emf.createEntityManager();
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.print("Matricula do Aluno: ");
	    Integer matricula = scanner.nextInt();
	    
	    em.getTransaction().begin();
	    Aluno x = em.find(Aluno.class, matricula);
	    System.out.println("Aluno com a matricula "+ x.getNumeroMatricula()+ " deletado com sucesso!\n");
	    
	    em.remove(x);
	    em.getTransaction().commit();
	    
	    em.close();

	}
}
