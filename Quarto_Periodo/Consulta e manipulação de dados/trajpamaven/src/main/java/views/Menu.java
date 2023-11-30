package views;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Aluno;
import models.Curso;
import service.DataBase;


public class Menu {
	public static void menuEscola() {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	     EntityManager em = emf.createEntityManager();
		 Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("\nMenu Escola:");
	            System.out.println("1. Aluno");
	            System.out.println("2. Curso");
	            System.out.println("3. Tranferir");
	            System.out.println("4. Sair");

	            System.out.print("Escolha uma opção: ");
	            int opcaoAcoes = scanner.nextInt();
	            switch (opcaoAcoes) {
	            case 1:
	            	menuAluno();
	                break;
	            case 2:
	            	menuCurso();
	                break;
	            case 3:
	            	scanner.nextLine(); 
                    System.out.println("ID do curso: ");
                    Integer IdJoin = scanner.nextInt();

                    
                    Curso cg = em.find(Curso.class, IdJoin);

                    if (cg != null) {
                        System.out.println("Transferencia encontrada:");
                        System.out.println("Curso: "+cg.getId());
                        System.out.println("Aluno(s): ");
                        
                        for (Aluno aluno : cg.getAluno()) {
                        	System.out.println(aluno);
                        }
                        
                    } else {
                        System.out.println("Transação não encontrada.");
                    }      	
                break;
	            case 4:
	            	break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	        }
	    }
	}
	public static void menuCurso() {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Curso:");
            System.out.println("1. Cadastrar Curso");
            System.out.println("2. Consultar Curso");
            System.out.println("3. Atualizar Curso");
            System.out.println("4. Sair");
            System.out.println("0. Voltar para o Menu Escola");

            System.out.print("Escolha uma opção: ");
            int opcaoCurso = scanner.nextInt();

            switch (opcaoCurso) {
                case 1:
                	DataBase.cadastrarCurso();
                    break;
                case 2:
                    DataBase.consultarCurso();
                    break;
                case 3:
                    DataBase.atualizarCurso();
                    break;
                case 4:
	            	break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
	}
	}
	
	public static void menuAluno() {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Aluno:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Consultar Aluno");
            System.out.println("3. Atualizar Aluno");
            System.out.println("4. Sair");
            System.out.println("0. Voltar para o Menu Escola");

            System.out.print("Escolha uma opção: ");
            int opcaoAluno = scanner.nextInt();

            switch (opcaoAluno) {
                case 1:
                	DataBase.cadastrarAluno();
                    break;
                case 2:
                    DataBase.consultarAluno();
                    break;
                case 3:
                    DataBase.atualizarAluno();
                    break;
                case 4:
	            	break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
	}
	}
}
