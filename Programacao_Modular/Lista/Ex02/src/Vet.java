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

    public static void imprimeVetor(int[] vetor) {
        //declarando variavel
        int i;
        //imprimindo vetor
        for (i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static int[] somaVizinho(int[] vetor){
        //declarando variaveis
        int i;

        //tamanho vetor
        int tamanho = vetor.length;

        //declarando vetor que ira somar os vizinhos
        int[] vetorSomaVizinhos;
        vetorSomaVizinhos = new int[tamanho % 2 == 0 ? tamanho / 2 : tamanho / 2 + 1]; //ternario para verificar se o tamanho eh par ou impar

        //FOR para somar os vizinhos
        for(i = 0; i < vetorSomaVizinhos.length; i++){
            if(i == vetorSomaVizinhos.length -1 && tamanho % 2 != 0){
                vetorSomaVizinhos[i] = vetor[i * 2];
            }else {
                vetorSomaVizinhos[i] = vetor[i * 2] + vetor[i * 2 + 1];
            }
        }

        return vetorSomaVizinhos;
      }

    }


