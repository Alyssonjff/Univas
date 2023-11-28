package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Edita_Aluno {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoRelacionamento");
		EntityManager em = emf.createEntityManager();
		Scanner scanner = new Scanner(System.in);
	    
	    System.out.print("Matricula do Aluno: ");
	    Integer matricula = scanner.nextInt();
		
		em.getTransaction().begin();
		
		Aluno x = em.find(Aluno.class, matricula);
		
		if(x != null) {
			System.out.println("Atualizar Nome: ");
			scanner.nextLine();
			String novoNome = scanner.nextLine();
			
			System.out.println("Novo Endereco: ");
			String novoEndereco = scanner.nextLine();
			
			System.out.println("Atualiza Nascimento: ");
			String novaData = scanner.nextLine();
				
			try {
				x.setNomeAluno(novoNome);
				x.setEndereco(novoEndereco);
				x.setDataNasc(novaData);
				
				em.merge(x);
				
				em.getTransaction().commit();
				System.out.println("Atualizado com sucesso.");
			} catch(NumberFormatException e) {
				System.out.println("Erro! tente novamente.");
			}
		} else {
			System.out.println("Aluno não encontrado.");
		}
		
		em.close();
		
		
	}
}
