//Main do programa

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //---------------------------------------------------
        //                testando construtores
        //---------------------------------------------------

        Scanner scanner = new Scanner(System.in); // funcao para pegar informacoes do teclado
        //---------------------------------------------------
        //                 Declarando variaveis
        //---------------------------------------------------

        int menu;
        int contador = 0;



        //Variavel do tipo objeto
        Estudante[] estudantes = new Estudante[2];

        //---------------------------------------------------
        //                 Menu da aplicacao
        //---------------------------------------------------


        do {
            System.out.println("*********SBBD*********");
            System.out.println("Escolha a opcao desejada!");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Mostrar alunos");
            System.out.println("3 - Caso de teste");
            System.out.println("0 - Sair");
            menu = scanner.nextInt();

            switch (menu){


                case 1:
                    //declaracao de variaveis para criar o objeto
                    String nome;
                    String sobrenome;
                    String email;
                    String curso;
                    String telefone;
                    String matricula;

                    System.out.println("Cadastro de aluno!");


                    System.out.println("Digite o primeiro nome:");
                    nome = scanner.nextLine();

                    scanner.nextLine();// para nao pular para segunda linha

                    System.out.println("Digite o segundo nome:");
                    sobrenome = scanner.nextLine();

                    System.out.println("Digite seu telefone:");
                    telefone = scanner.nextLine();

                    System.out.println("Digite o e-mail:");
                    email= scanner.nextLine();

                    System.out.println("Digite a matricula:");
                    matricula = scanner.nextLine();

                    System.out.println("Digite o curso:");
                    curso = scanner.nextLine();

                    //cirando o objeto que vai receber os paramtros
                    Estudante estudante = new Estudante(nome, sobrenome, email, telefone, matricula, curso);

                    estudantes[contador] = estudante;
                    contador++;
                    break;
                case 2:
                    System.out.println("Mostrar alunos cadastrados");
                    for(int i = 0; i < contador; i++){
                        estudantes[i].imprimirDados();
                        System.out.println();
                    }
                    break;
                case 3:

                    Instituicao padaria = new Instituicao(12341234, "Rua Linda 332", "Pao Bao", "Marcao");
                    Empresa padaria2 = new Empresa(12341234, "Rua Linda 332", "Pao Bao", "Marcao", "Panificacao");

                    Pessoa eu = new Pessoa("Marcao", "Viniccius", "Marcao@bunitao.com", "9999999999");
                    Estudante eu2 = new Estudante("Marcao", "Viniccius", "Marcao@bunitao.com", "9999999999", "1234", "Engenharia");

                    //variaveis para guardar dados variavel para guardar metodo toString
                    String dadosPadaria;
                    String dadosEstudante;

                    padaria.dadosInstituicao();         // testando metodos da classe pai

                    System.out.println();

                    eu.dadosPessoais();                 // testando metodos da classe pai

                    System.out.println();

                    dadosPadaria = padaria2.toString(); // testando metodos da classe Filha
                    System.out.println(dadosPadaria);   // testando metodos da classe Filha

                    System.out.println();

                    dadosEstudante = eu2.toString();
                    System.out.println(dadosEstudante);
                    break;


                default:
                    System.out.println("Opcao invalida! tente novamente");
                    break;
            }

            System.out.println();
        }while (menu != 0);


        System.out.println("Obrigado");
        scanner.close();
    }
}