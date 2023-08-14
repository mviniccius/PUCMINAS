import java.util.Scanner;

public class Vet {

    //funcao para criar e retornar um vetor
    public static int [] criaVetor(){
        //variaveis
        int tamanho, i;
        int vetor[];
        Scanner scanner = new Scanner(System.in);

        //definindo o tamanho do vetor
        System.out.println("Digite o tamanho do vetor:");
        tamanho = scanner.nextInt();
        //inicializando o vetor que sera retornado
        vetor = new int[tamanho];
        //populando o vetor
        for(i = 0; i < vetor.length; i++){
            // vetor[i] = scanner.nextInt();
            vetor[i] = i;
        }
        scanner.close();
        return vetor;
    }



    //funcao que recebe vetor e retorna ele invertido
    public static int[] inverteVetor(int[] vetor){

        //declarando variaveis
        int [] vetorInvertido;
        int i, controle = 0;

        vetorInvertido = new int[vetor.length];

        //invertendo vetor;
        for(i = vetor.length - 1; i >= 0; i--){
            vetorInvertido[controle] = vetor[i];
            controle++;
        }
        return vetorInvertido;
    }

    public static void imprimeVetor(int[] vetor){
        //declarando variavel
        int i;
        //imprimindo vetor
        for(i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }

    }

}
