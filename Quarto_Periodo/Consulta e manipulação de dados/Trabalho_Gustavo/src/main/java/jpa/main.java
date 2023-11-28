package jpa;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			
		do{
			System.out.println("---------------------------------");
			System.out.println("| Olá! Oque você deseja fazer?");
			System.out.println("| 1- Adicionar");
			System.out.println("| 2- Consultar");
			System.out.println("| 3- Deletar");
			System.out.println("| 4- Atualizar");
			System.out.println("| 5- Sair");
			System.out.println("---------------------------------");

			
			Integer opcao = scanner.nextInt();
		
			if(opcao == 1) {
				System.out.println("---------------------------------------");
				System.out.println("| Deseja adicionar um Aluno ou Curso?");
				System.out.println("| 1- Aluno // 2- Curso // 3- para sair");
				System.out.println("---------------------------------------");
				opcao = scanner.nextInt();
				if(opcao == 1) {
					Adiciona_Aluno i = new Adiciona_Aluno();
				}else if(opcao == 2) {
					Adiciona_Curso i = new Adiciona_Curso();
				}
			}
			else if(opcao == 2) {
				System.out.println("---------------------------------------");
				System.out.println("Deseja Consultar um Aluno ou Curso?");
				System.out.println("1- Aluno // 2- Curso // 3- para sair");
				System.out.println("---------------------------------------");
				opcao = scanner.nextInt();
				if(opcao == 1) {
					Consulta_Aluno i = new Consulta_Aluno();
				}else if(opcao == 2) {
					Consulta_Curso i = new Consulta_Curso();
				}
			}
			else if(opcao == 3) {
				System.out.println("---------------------------------------");
				System.out.println("Deseja atualizar um Aluno ou Curso?");
				System.out.println("1- Aluno // 2- Curso // 3- para sair");
				System.out.println("---------------------------------------");
				opcao = scanner.nextInt();
				if(opcao == 1) {
					Edita_Aluno i = new Edita_Aluno();
				}else if(opcao == 2) {
					Edita_Curso i = new Edita_Curso();
				}
			}
			else if(opcao == 4) {
				System.out.println("---------------------------------------");
				System.out.println("Deseja excluir um Aluno ou Curso?");
				System.out.println("1- Aluno // 2- Curso // 3- para sair");
				System.out.println("---------------------------------------");
				opcao = scanner.nextInt();
				if(opcao == 1) {
					Exclui_Aluno i = new Exclui_Aluno();
				}else if(opcao == 2) {
					Exclui_Curso i = new Exclui_Curso();
				}
			}else if(opcao == 5){
				System.out.println("--------------------------");
				System.out.println("| Programa encerrado!");
				System.out.println("--------------------------");
				break;
			}
			else {
				System.out.println("Opção inválida!");
			}
		}while(true);
		
		
	}
}