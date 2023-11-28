package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exclui_Curso {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoRelacionamento");
		EntityManager em = emf.createEntityManager();
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.print("Id do curso: ");
	    Integer id = scanner.nextInt();
	    
	    em.getTransaction().begin();
	    Curso x = em.find(Curso.class, id);
	    System.out.println("Curso com o ID "+ x.getId()+ " deletado com sucesso!\n");
	    
	    em.remove(x);
	    em.getTransaction().commit();
	    
	    em.close();

	}
}
