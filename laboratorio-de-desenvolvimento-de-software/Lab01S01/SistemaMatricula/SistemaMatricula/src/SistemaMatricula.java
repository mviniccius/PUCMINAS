import models.*;
import services.SistemaAutenticacao;

import java.util.Scanner;


public class SistemaMatricula {

	private static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//dados mocados
		
		Aluno aluno = new Aluno("marcao", "marcus@hotmail", "123", "1", "Eng software", 4);
		Professor professor = new Professor("Arurani", "Arunani@hotmail", "123", "Laboratorio");
		Secretaria secretaria = new Secretaria("Dirce", "dirce@hotmail", "123");


		
		System.out.println(aluno.toString());
		System.out.println("-------------------------------------");		
		System.out.println(professor.toString());
		System.out.println("-------------------------------------");
		System.out.println(secretaria.toString());
		System.out.println("-------------------------------------");


		//------------------variaveis---------------------------

		Scanner sc = new Scanner(System.in);

		SistemaAutenticacao sistema = new SistemaAutenticacao();
		//--------------------inicio-----------------------------
		System.out.println("*****************");
		System.out.println("*   Bem vido!   *");
		System.out.println("*****************");
		
		while (true) {
			System.out.println("\n=== SISTEMA DE LOGIN ===");
			System.out.println("1- Login como Aluno");
			System.out.println("2- Login como Professor");
			System.out.println("3- Login como Secretaria");
			System.out.println("4- Sair");
			System.out.println("Escolha uma opcao: ");
			
			int opcao = sc.nextInt();
			sc.nextLine();

			if(opcao == 4){
				System.out.println("Saiu");
				System.out.println("Obrigado por utilizar!");
				break;
			}
			System.out.println("Digite seu email ou matricula: ");
			String usuario = sc.nextLine();
			System.out.println("Digite sua senha: ");
			String senha = sc.nextLine();

			Usuario logado = null;
			switch (opcao) {
				case 1:
					logado = sistema.autenticarAluno(usuario, senha);	
					break;
				case 2:
					logado = sistema.autenticarProfessor(usuario, senha);
					break;
				case 3:
					logado = sistema.autenticarSecretaria(usuario, senha);
					break;
				default:
					break;
			}
			if(logado != null){
				System.out.println("\nSeja bem vindo, " + logado.getNome());
			}else{
				System.out.println("\nUsuario ou senha incorretos\n");
			}

		}

		sc.close();

	}	
}
