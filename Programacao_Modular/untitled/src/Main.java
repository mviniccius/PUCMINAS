//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[]vetor;
        int[]vetorIvertido;
        vetor = Vet.criaVetor();

        //imprimindo vetor original
        Vet.imprimeVetor(vetor);

        System.out.println();
        //invertendo vetor
       vetorIvertido = Vet.inverteVetor(vetor);

        //imprimindo vetor invertido
        Vet.imprimeVetor(vetorIvertido);

    }
}

