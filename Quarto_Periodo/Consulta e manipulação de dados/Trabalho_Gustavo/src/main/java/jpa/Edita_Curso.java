package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Edita_Curso {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoRelacionamento");
		EntityManager em = emf.createEntityManager();
		Scanner scanner = new Scanner(System.in);
	    
	    System.out.print("ID do curso: ");
	    Integer id = scanner.nextInt();
		
		em.getTransaction().begin();
		
		Curso x = em.find(Curso.class, id);
		
		if(x != null) {
			System.out.println("Atualizar Nome do curso: ");
			scanner.nextLine();
			String novoNome = scanner.nextLine();
			
			//System.out.println("Nova Endereco: ");
			//String novoEndereco = scanner.nextLine();
				
			try {
				x.setNomeCurso(novoNome);
				//x.setEndereco(novoEndereco);
				
				em.merge(x);
				
				em.getTransaction().commit();
				System.out.println("Atualizado com sucesso.");
			} catch(NumberFormatException e) {
				System.out.println("Erro! tente novamente.");
			}
		} else {
			System.out.println("Curso não encontrado.");
		}
		
		em.close();
		
		
	}
}
