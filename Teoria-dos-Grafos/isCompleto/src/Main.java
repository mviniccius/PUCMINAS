//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.Scanner;

public class Main {

    //----------------------------------------------
    // Declaracao de variaveis com valores contantes
    //-----------------------------------------------
    public static final int MAX_VERTICE = 500;
    public static final int NULO = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //declarando grafo
        Grafo grafo = new Grafo();
        //valor da quantidade de vertice
        int vertice;
        vertice = scanner.nextInt();
        while (vertice != 0) {

            grafo.isCompleto(vertice);

            //condicao para ler o grafo ate condicao de parada
            vertice = scanner.nextInt();
        }


    }

    //------------------------
    //Declaracao do Grafo
    //------------------------
    public static class Grafo {
        private int numVertice, numAresta;
        private int[][] matriz = new int[MAX_VERTICE][MAX_VERTICE];
        Scanner scanner = new Scanner(System.in);

        public void Grafo() {
            numVertice = 0;
            excluirTodasArestas();
        }

        //--------------------------------------------------------------------
        //          lerGrafo: Realiza a leitura do grafo.
        //--------------------------------------------------------------------
        public void lerGrafo(int vertice) {
            Scanner scanner = new Scanner(System.in);
            int temp;
            excluirTodasArestas();

            //Ler o numero de vertices
            setNumVertice(vertice);

            for (int i = 0; i < numVertice; i++) {
                inserirAresta(i, i, NULO);
                for (int j = i + 1; j < numVertice; j++) {

                    temp = scanner.nextInt();

                    inserirAresta(i, j, temp);
                    inserirAresta(j, i, temp);
                }
            }


        }

        //--------------------------------------------------------------------
        //                      Imprimir: Imprime o grafo.
        //--------------------------------------------------------------------
        public void imprimir() {
            int i, j;

            System.out.printf("\nN = (%d)\n    \t", numVertice);
            for (i = 0; i < numVertice; i++) {
                if (i >= 100) {
                    System.out.printf("\t(%d) ", i);
                } else if (i >= 10) {
                    System.out.printf("\t(0%d) ", i);
                } else {
                    System.out.printf("\t(00%d) ", i);
                }
            }

            for (i = 0; i < numVertice; i++) {
                if (i >= 100) {
                    System.out.printf("\n(%d) - ", i);
                } else if (i >= 10) {
                    System.out.printf("\n(0%d) - ", i);
                } else {
                    System.out.printf("\n(00%d) - ", i);
                }

                for (j = 0; j < numVertice; j++) {
                    if (matriz[i][j] == NULO) {
                        System.out.printf("\t\t. ");
                    } else {
                        System.out.printf("\t\t%d ", matriz[i][j]);
                    }
                }
            }

            System.out.printf("\n");
        }

        //--------------------------------------------------------------------
        // excluirAresta: Exclui uma aresta.
        //--------------------------------------------------------------------
        private void excluirAresta(int v1, int v2) {
            if (v1 > numVertice) {
                System.out.printf("ERRO! Vertice %d nao existe no grafico", v1);
                return;
            }
            if (v2 > numVertice) {
                System.out.printf("ERRO! Vertice %d nao existe no grafico", v2);
                return;
            }
            if (matriz[v1][v2] != NULO) {
                matriz[v1][v2] = NULO;
                numAresta--;
            }
        }

        //--------------------------------------------------------------------
        // excluirTodasArestas: Atribui NULO para todas as arestas.
        //--------------------------------------------------------------------
        private void excluirTodasArestas() {
            for (int i = 0; i < MAX_VERTICE; i++) {
                matriz[i][i] = NULO;
                for (int j = i + 1; j < MAX_VERTICE; j++) {
                    matriz[i][j] = matriz[j][i] = NULO;
                }
            }
            numAresta = 0;
        }

        //--------------------------------------------------------------------
        // isAresta: Retorna true se existe a aresta.
        //--------------------------------------------------------------------
        private boolean isAresta(int v1, int v2) {
            return (matriz[v1][v2] != NULO);
        }

        //--------------------------------------------------------------------
        // getAresta: Retorna o peso da aresta.
        //--------------------------------------------------------------------

        private int getAresta(int v1, int v2) {
            return (matriz[v1][v2]);
        }

        //--------------------------------------------------------------------
        // setNumVertice: Altera a variavel numVertice.
        //--------------------------------------------------------------------
        private void setNumVertice(int nVertice) {
            if (nVertice > MAX_VERTICE) {
                System.out.printf("ERRO: Numero de vertices\n");
                return;
            }
            numVertice = nVertice;
        }

        //--------------------------------------------------------------------
        // inserirAresta: Insere uma nova aresta.
        //--------------------------------------------------------------------
        private void inserirAresta(int v1, int v2, int peso) {

            if (v1 > MAX_VERTICE) {
                System.out.printf("ERRO! Vertice %i nao existe no grafico", v1);
                return;
            }
            if (v2 > MAX_VERTICE) {
                System.out.printf("ERRO! Vertice %i nao existe no grafico", v2);
                return;
            }
            if (matriz[v1][v2] == NULO) {
                matriz[v1][v2] = peso;
                numAresta++;
            }
        }

        public void imprimirVerticeAresta() {
            System.out.println(numVertice + " " + numAresta);
        }

        //----------------------------------------------------
        //      isCompleto: quando construir o grafo posso fazer uma verificacao para saber se o grafo esta completo
        //----------------------------------------------------
        public void isCompleto(int vertice) {

            int temp;
            excluirTodasArestas();

            //definir numero de vertice
            setNumVertice(vertice);
            for (int i = 0; i < numVertice; i++) {
                inserirAresta(i, i, NULO);
                for (int j = i + 1; j < numVertice; j++) {

                    temp = scanner.nextInt();
                    if (temp == -1) {
                        inserirAresta(i, j, temp);
                        System.out.println("NAO");
                        break;
                    }
                }
            }
            //aqui termina o isCompleto

        }
    }
}