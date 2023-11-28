package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Consulta_Aluno {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoRelacionamento");
		EntityManager em = emf.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
	    
	    System.out.print("Digite a Matricula do Aluno: ");
	    Integer matricula = scanner.nextInt();
		
		em.getTransaction().begin();
		
		System.out.println(em.find(Aluno.class, matricula));
		
		Aluno x = em.find(Aluno.class, matricula);
				
		em.close();
		emf.close();

	}
}
