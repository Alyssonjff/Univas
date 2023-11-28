package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Consulta_Curso {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoRelacionamento");
		EntityManager em = emf.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
	    
	    System.out.print("Digite o id do curso: ");
	    Integer id = scanner.nextInt();
		
		em.getTransaction().begin();
		
		System.out.println(em.find(Curso.class, id));
		
		Curso x = em.find(Curso.class, id);
				
		em.close();
		emf.close();

	}
}
