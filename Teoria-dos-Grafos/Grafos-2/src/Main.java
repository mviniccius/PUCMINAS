import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int maxVertice = 100;
        int [][] grafo = new int[maxVertice][maxVertice];
        Scanner scanner = new Scanner(System.in);

        int temp;
        System.out.println("Digite o numero de veritices:");
        temp = scanner.nextInt(); // ler o numero de vertices
        maxVertice = temp;

        for(int i = 0; i < maxVertice; i++){
             grafo[0][0] = -1;
             for (int j = i + 1; j < maxVertice; j++){
                 System.out.println("Valor da Areste: ");
                 temp = scanner.nextInt();
                 grafo[i][j] = temp;
                 grafo[j][i] = temp;
             }

        }
        
        //imprimir
        for(int i = 0; i < maxVertice; i++){
            for (int j = 0; j < maxVertice; j++){
                System.out.print(grafo[i][j]+ " ");
            }
            System.out.println();
        }

    }
}