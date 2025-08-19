import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int maxVertice = 100;
        int [][] grafo = new int[maxVertice][maxVertice];
        Scanner scanner = new Scanner(new File("in.txt"));
        int temp;

        while (true){
          //leitura da primeira linha do arquivo:
            //System.out.println("Digite o numero de veritices:");
            temp = scanner.nextInt(); // ler o numero de vertices
          //verificacao de saida do loop:
            if(temp == 0){
                break;
            }
            maxVertice = temp;

        for(int i = 0; i < maxVertice; i++){
             grafo[i][i] = 0;
             for (int j = i + 1; j < maxVertice; j++){
                 //System.out.println("Valor da Aresta posicao: " + i + " " + " " + j);
                 temp = scanner.nextInt();
                 grafo[i][j] = temp;
                 grafo[j][i] = temp;
             }
            }
            imprimirMatriz(grafo,maxVertice);
            System.out.println("isSimples: " + isSimples(grafo, maxVertice)); // + "isRegular: " + + "isCompleto "+ + "isNulo "+ + "isLinear "
        }


            scanner.close();
    }

    static void imprimirMatriz(int [][] m, int tamanhoVertice){
        for(int i = 0; i < tamanhoVertice; i++){
            for (int j = 0; j < tamanhoVertice; j++){
                System.out.print(m[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static boolean isSimples(int [][]m, int tamanhoVertice){

        for (int i = 0; i < tamanhoVertice; i++){
            if (m[i][i] != 0){
                return false;
            }
        }
        return true;
    }
    static boolean isRegular(int [][]m , int tamanhoVertice){

        return true;
    }
}