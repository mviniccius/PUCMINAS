import models.*;
import services.SistemaAutenticacao;
import services.SistemaCursos;

import java.util.Scanner;


public class SistemaMatricula {

	//private static Scanner sc = new Scanner(System.in);
	
	private static SistemaCursos sistemaCursos = new SistemaCursos();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
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
			System.out.println("4- Cadastro");
			System.out.println("5- Sair");
			System.out.println("Escolha uma opcao: ");
			
			int opcao = sc.nextInt();
			sc.nextLine();

			if(opcao == 5){
				System.out.println("Saiu");
				System.out.println("Obrigado por utilizar!");
				break;
			}	

			
			switch (opcao) {
				case 1:					
				case 2:					
				case 3:
					realizarLogin(sc, sistema, opcao);
					break;
				case 4:
					cadastrarUsuario(sc, sistema);
					break;
				case 50:
					sistema.imprimirAlunos();
					break;
				case 51:
					sistema.imprimirProfessores();
					break;
				case 52:
					sistema.imprimirSecretarias();
					break;
				default:
					System.out.println("Opcao invalida");
			}
					

		}
		sc.close();
	}	

	private static void realizarLogin(Scanner sc, SistemaAutenticacao sistema, int tipo){
		System.out.print("Digite seu usuário (Matrícula ou E-mail): ");
        String usuario = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

       Usuario logado = null;
        switch (tipo) {
            case 1:
                logado = sistema.autenticarAluno(usuario, senha);
                break;
            case 2:
                logado = sistema.autenticarProfessor(usuario, senha);
                break;
            case 3:
                logado = sistema.autenticarSecretaria(usuario, senha);
                break;
        }
		if(logado != null){
			System.out.println("Bem vindo, " + logado.getNome());
		}else{
			System.out.println("Usuario ou senha incorreta");
		}
	}


	private static void cadastrarUsuario(Scanner sc, SistemaAutenticacao sistema){
        System.out.println("\n=== CADASTRO DE NOVO USUÁRIO ===");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Cadastrar Professor");
        System.out.println("3. Cadastrar Secretaria");
        System.out.print("Escolha uma opção: ");

        int tipo = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();        

        switch (tipo) {
            case 1:
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();
                System.out.print("Curso: ");
                String curso = sc.nextLine();
                System.out.print("Período: ");
                int periodo = sc.nextInt();
                sc.nextLine(); 
                sistema.cadastrarAluno(nome, email, senha, matricula, curso, periodo);
                break;
            case 2:
                System.out.print("Disciplina: ");
                String disciplina = sc.nextLine();
                sistema.cadastrarProfessor(nome, email, senha, disciplina);
                break;
            case 3:
                sistema.cadastrarSecretaria(nome, email, senha);
                break;			
            default:
                System.out.println("Opção inválida.");
        }       
    }


	/*
	 * cadastro do curso
	 */
	public static void gerenciarCursos(){
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n=== GERENCIAMENTO DE CURSOS ===");
            System.out.println("1. Cadastrar Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

			int opcao = sc.nextInt();
			sc.nextLine();

			if(opcao == 3){
				System.out.println("Voltou!");
				break;
			}
			switch (opcao) {
				case 1:
					//cadastro de curso
					cadastrarCurso();
					break;
			
				case 2:
					// listar curso
					listarCursos();
					break;

				default:
					System.out.println("Opcao invalida");
			}
		}
	}

	private static void cadastrarCurso(){

		Scanner sc = new Scanner(System.in);

		System.out.println("\nDigite o nome do curso:");
		String nome = sc.nextLine();
		System.out.println("Digite a quantidade de creditos: ");
		int creditos = sc.nextInt();
		sc.nextLine();

		boolean sucesso = sistemaCursos.cadastrarCurso(nome, creditos);

		if(sucesso){
			System.out.println("Curso cadastrado com sucesso!\n");
		}else{
			System.out.println("Disciplina ja cadastrada!");
		}
	}

	private static void listarCursos(){
		System.out.println("\n=== LISTA DE CURSOS ===");
		for(Curso curso : sistemaCursos.listarCursos()){
			System.out.println(curso);
		}
	}
}
