
public class Main {
    public static void main(String[] args) {
        //Declarando vetor:
        int[] vetor;
        int[] vetorSomado;

        vetor = Vet.criaVetor();
        System.out.println("Vetor Original");
        Vet.imprimeVetor(vetor);
        System.out.println("Vetor somado com o vizinho");
        vetorSomado = Vet.somaVizinho(vetor);
        Vet.imprimeVetor(vetorSomado);

    }
}