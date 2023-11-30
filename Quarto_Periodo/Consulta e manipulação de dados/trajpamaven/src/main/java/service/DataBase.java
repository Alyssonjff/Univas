package service;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Curso;
import models.Aluno;

public class DataBase {
	public static void cadastrarAluno() {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Matricula: ");
		Integer matricula = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Nome: ");
		String nomeAluno = scanner.nextLine();
		
		System.out.println("Data de Nascimento: ");
		String nascimento = scanner.nextLine();
		
		System.out.println("Endereco: ");
		String endereco = scanner.nextLine();
		scanner.nextLine();
		
		System.out.println("ID do Curso: ");
		Integer idCurso = scanner.nextInt();
		
		Curso curso = em.find(Curso.class, idCurso);
		
		Aluno aluno = new Aluno(matricula, nomeAluno, nascimento, endereco, curso);
		
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		
		curso.AdicionaAluno(aluno);
		
		em.getTransaction().begin();
		em.merge(curso);
		em.getTransaction().commit();

		
		System.out.println("Aluno Adicionado:");
		System.out.println("Matricula: " + matricula);
        System.out.println("Nome: " + nomeAluno);
        System.out.println("Nascimento: " + nascimento);
        System.out.println("Endereco: " + endereco);
	}
	
	public static void consultarAluno() {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        try {
        	System.out.println("Digite a Matricula: ");
            String matricula = scanner.nextLine();
            
            Aluno aluno = em.find(Aluno.class, matricula);

            if (aluno != null) {
            	System.out.println("aluno encontrado: ");
                System.out.println("Matricula: " + aluno.getNumeroMatricula());
                System.out.println("Nome: " + aluno.getNomeAluno());
                System.out.println("Data de nascimento: " + aluno.getDataNascimento());
                System.out.println("Endereco: " + aluno.getEndereco());
            } else {
                System.out.println("Aluno com a Matricula " + matricula + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a consulta: " + e.getMessage());
        } finally {
            em.close();
        }
    }
	
	public static void atualizarAluno() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a Matricula: ");
		String matricula = scanner.nextLine();
			
		em.getTransaction().begin();
			
		Aluno aluno = em.find(Aluno.class, matricula);
		
		if(aluno != null) {		
			System.out.println("Digite o novo nome: ");
			String novoNome = scanner.nextLine();
			
			System.out.println("Digite a novo endereco: ");
			String novoEnd = scanner.nextLine();
			
			System.out.println("Digite a nova data de nascimento: ");
			String novoAno = scanner.nextLine();
			scanner.nextLine();
			
			
			try {
				aluno.setNomeAluno(novoNome);
				aluno.setEndereco(novoEnd);
				aluno.setDataNascimento(novoAno);
				em.merge(aluno);
				
				em.getTransaction().commit();
				
                System.out.println("Aluno Atualizado: ");
                System.out.println("Matricula: " + aluno.getNumeroMatricula());
                System.out.println("Nome: " + aluno.getNomeAluno());
                System.out.println("Data de nascimento: " + aluno.getDataNascimento());
                System.out.println("Endereco: " + aluno.getEndereco());
          
			} catch(NumberFormatException e) {
				System.out.println("Matricula Invalida");
			}
		} else {
			System.out.println("Aluno com a matricula " + matricula + " não encontrado.");
		}
		em.close();
	}
	
	public static void removerAluno() {
		 Scanner scanner = new Scanner(System.in);
	     EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	     EntityManager em = emf.createEntityManager();
	     
	     try {
	           	System.out.print("Informe a Matricula do Aluno a ser deletado: ");
	            String mat = scanner.nextLine();

	            em.getTransaction().begin();
	            Aluno aluno = em.find(Aluno.class, mat);

	            if (aluno != null) {
	                System.out.println("Detalhes do Aluno ");
	                System.out.println("Matricula: " + aluno.getNumeroMatricula());
	                System.out.println("Nome: " + aluno.getNomeAluno());
	                System.out.println("Data de nascimento: " + aluno.getDataNascimento());
	                System.out.println("Endereco: " + aluno.getEndereco());
	                
	                System.out.print("Tem certeza de que deseja deletar este carro? (S/N): ");
	                String confirmacao = scanner.next();

	                if (confirmacao.equalsIgnoreCase("S")) {
	                    em.remove(aluno);
	                    em.getTransaction().commit();
	                    System.out.println("aluno deletado com sucesso.");
	                } else {
	                    System.out.println("Operação de exclusão cancelada.");
	                }
	            } else {
	                System.out.println("\nAluno com a Matricula " + aluno + " não encontrado. Operação de exclusão cancelada.");
	            }
	        } catch (Exception e) {
	            System.out.println("Ocorreu um erro durante a exclusão: " + e.getMessage());
	        } finally {
	            em.close();
	        }
	}
	
	static void addEm(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }
	
	public static void cadastrarCurso() {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("ID: ");
		Integer id = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Nome do Curso: ");
		String nome = scanner.nextLine();
		
		Curso curso = new Curso(id, nome);
		
		addEm(curso);
		
		
		System.out.println("Curso Adicionado: ");
		System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);

	}
	
	public static void consultarCurso() {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        try {
        	System.out.println("Digite o Id do curso: ");
            String id = scanner.nextLine();
            
            Curso curso = em.find(Curso.class, id);

            if (curso != null) {
            	System.out.println("Curso encontrado: ");
                System.out.println("Id: " + curso.getId());
                System.out.println("Nome: " + curso.getNomeCurso());
            } else {
                System.out.println("Curso com o ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a consulta: " + e.getMessage());
        } finally {
            em.close();
        }
    }
	
	public static void atualizarCurso() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do curso: ");
		String id = scanner.nextLine();
			
		em.getTransaction().begin();
			
		Curso c = em.find(Curso.class, id);
		
		if(c != null) {		
			System.out.println("Digite o novo Nome do Curso: ");
			String novoNome = scanner.nextLine();
			
			try {
				c.setNomeCurso(novoNome);
								
				em.merge(c);
				
				em.getTransaction().commit();
				
                System.out.println("Curso Atualizado: ");
                System.out.println("Id: " + c.getId());
                System.out.println("Nome: " + c.getNomeCurso());
          
			} catch(NumberFormatException e) {
				System.out.println("Curso Invalido");
			}
		} else {
			System.out.println("Curso com o ID " + id + " não encontrado.");
		}
		em.close();
	}
	
	public static void removerCurso() {
		 Scanner scanner = new Scanner(System.in);
	     EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	     EntityManager em = emf.createEntityManager();
	     
	     try {
	           	System.out.print("Informe o ID do curso a ser deletado: ");
	            String id = scanner.nextLine();

	            em.getTransaction().begin();
	            Curso c = em.find(Curso.class, id);

	            if (c != null) {
	                System.out.println("Detalhes do Curso ");
	                System.out.println("Id: " + c.getId());
	                System.out.println("Nome: " + c.getNomeCurso());

	                System.out.print("Tem certeza de que deseja deletar este Curso? (S/N): ");
	                String confirmacao = scanner.next();

	                if (confirmacao.equalsIgnoreCase("S")) {
	                    em.remove(c);
	                    em.getTransaction().commit();
	                    System.out.println("Curso deletado com sucesso.");
	                } else {
	                    System.out.println("Operação de exclusão cancelada.");
	                }
	            } else {
	                System.out.println("\nCurso com o ID " + id + " não encontrado. Operação de exclusão cancelada.");
	            }
	        } catch (Exception e) {
	            System.out.println("Ocorreu um erro durante a exclusão: " + e.getMessage());
	        } finally {
	            em.close();
	        }
	}
	
	static void addEm(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        em.close();
    }
}