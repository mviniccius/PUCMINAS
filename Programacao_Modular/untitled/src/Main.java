import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declarando Scanner
        Scanner scanner = new Scanner(System.in);

        //Declarando vetor
        int [] vetor;
        int [] vetorA;
        vetor = new int[5];
        vetorA = new int[5];

        //declarando variaveis
        int i;
        int controle = 0;

        //populando o vetor
        for(i = 0; i < vetor.length; i++){
            vetor[i] = scanner.nextInt();
        }
        //imprimindo vetor
        for(i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }

        //invertendo vetor;
        for(i = vetor.length - 1; i >= 0; i--){
            vetorA[controle] = vetor[i];
            controle++;
        }

        //imprimindo vetor invertido
        //imprimindo vetor
        for(i = 0; i < vetor.length; i++){
            System.out.println(vetorA[i]);
        }

    }
}

