import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        int maxVertice = 100;
        int [][] grafo = new int[maxVertice][maxVertice];
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File("in.txt"));
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
             grafo[i][i] = -1;
             for (int j = i + 1; j < maxVertice; j++){
                 //System.out.println("Valor da Aresta posicao: " + i + " " + " " + j);
                 temp = scanner.nextInt();
                 grafo[i][j] = temp;
                 grafo[j][i] = temp;
             }
            }
            //imprimirMatriz(grafo,maxVertice);
            //System.out.println("isSimples: " + isSimples(grafo, maxVertice) + "\nisRegular: " + isRegular(grafo, maxVertice) + "\nisCompleto "+ isCompleto(grafo, maxVertice) + " \nisNulo "+ isNulo(grafo, maxVertice) + "\nisLinear " + isLinear(grafo, maxVertice)); //
            //System.out.println(boolToInt(isSimples(grafo, maxVertice)) + " " + boolToInt(isRegular(grafo, maxVertice)) + " " + boolToInt(isCompleto(grafo, maxVertice)) + " " +boolToInt(isNulo(grafo, maxVertice))  + " " + boolToInt(isLinear(grafo, maxVertice)));
            System.out.println(boolToInt(isConexo(grafo, maxVertice))+ " " + boolToInt(isBipartido(grafo, maxVertice)) + " "+boolToInt(hasCiclo(grafo, maxVertice))+" " + boolToInt(isBipartidoCompleto(grafo, maxVertice)));
        /*
        isConexo
        isBipartido
        hasCiclo
        isBipartidoCompleto
         */
        }


            scanner.close();
    }

    static void imprimirMatriz(int [][] m, int tamanhoVertice){
        for(int i = 0; i < tamanhoVertice; i++){
            for (int j = 0; j < tamanhoVertice; j++){
                System.out.print(m[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    static boolean isSimples(int [][]m, int tamanhoVertice){

        for (int i = 0; i < tamanhoVertice; i++){
            if (m[i][i] != -1){
                return false;
            }
        }
        return true;
    }

    static boolean isRegular(int [][]m , int tamanhoVertice){

        int grauEsperado = -1;

        for(int i = 0; i < tamanhoVertice; i++){
            int count = 0;
            for (int j = 0; j < tamanhoVertice; j++){
                if(i == j){
                    continue; //ignora a diagonal principal
                }
                if (m[i][j] != -1){
                    count++; //conta se tem aresta
                }
            }

            if (grauEsperado == -1){
                grauEsperado = count; //define grau da primeira linha;
            }else if (count != grauEsperado){
                return false;
            }
        }

        return true;
    }
    static boolean isCompleto(int [][]m, int tamanhoVertice){
        int count = 0;
        int resp;
        for(int i = 0; i < tamanhoVertice; i++){
            for (int j = i + 1; j < tamanhoVertice; j++){
                if (m[i][j] != -1){
                    count ++;
                }
            }
        }

        resp = (tamanhoVertice * (tamanhoVertice -1))/2;

        if (resp == count){
            return true;
        }else {
            return false;
        }
    }

    static boolean isNulo(int [][]m, int tamanhoVertice){
        for(int i = 0; i < tamanhoVertice; i++){
            for (int j = i + 1; j < tamanhoVertice; j++){
                if (m[i][j] != -1){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isLinear(int [][]m, int tamanhoVertice){
        int count = 0;
        if(tamanhoVertice == 1){
            return true;
        }
        //verificar se o grafo tem mais de 1 componente:
        for(int i = 0; i < tamanhoVertice; i++){
            for (int j = i + 1; j < tamanhoVertice; j++){
                if (m[i][j] != -1){
                    count++;
                }
            }
        }
        if (count == 0){
            return false; // grafo com mais de um componente
        } else if (count == (tamanhoVertice - 1)){
            return true;
        }
        return false;
    }

    //segunda parte
    static boolean isConexo(int [][]m, int tamanhoVertice){

        if (tamanhoVertice == 1){
            return true; // grafo somente com um componente
        }
        for (int i = 0 ; i < tamanhoVertice; i++){
            int count = 0;
            for (int j = 0; j < tamanhoVertice; j++){
                if (m[i][j] == -1){
                    count++;
                }
            }
            if (count == tamanhoVertice){
                return false;
            }
        }
        return true;
    }

    static boolean isBipartido(int [][]m, int tamanhoVertice){

        //0: nao colorido, 1: cor 1, 2:cor 2
        int [] cores = new int[tamanhoVertice];
        for (int i = 0; i< tamanhoVertice; i++){
            //se o vértice ainda não foi colorido
            if (cores[i] == 0){
                Queue<Integer> fila = new LinkedList<>();
                fila.add(i);
                cores[i] = 1; // Atribuindo a primeira cor

                while (!fila.isEmpty()){
                    int u = fila.poll();

                    for (int v = 0; v < tamanhoVertice; v++) {
                        // Se existe uma aresta entre u e v
                        if (m[u][v] != -1) {
                            // Se o vizinho não tem cor
                            if (cores[v] == 0) {
                                cores[v] = 3 - cores[u]; // Atribui a cor oposta
                                fila.add(v);
                            }
                            // Se o vizinho tem a mesma cor que o vértice atual, não é bipartido
                            else if (cores[v] == cores[u]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }


    static boolean isBipartidoCompleto(int[][] m, int tamanhoVertice) {
        // Passo 1: Chama a sua função isBipartido para uma verificação rápida
        if (!isBipartido(m, tamanhoVertice)) {
            return false;
        }

        // Passo 2: Repete a lógica de bipartição para obter os tamanhos das partições
        int[] cores = new int[tamanhoVertice];
        int tamanhoParticao1 = 0;
        int tamanhoParticao2 = 0;

        for (int i = 0; i < tamanhoVertice; i++) {
            if (cores[i] == 0) {
                Queue<Integer> fila = new LinkedList<>();
                fila.add(i);
                cores[i] = 1;
                tamanhoParticao1++;

                while (!fila.isEmpty()) {
                    int u = fila.poll();
                    for (int v = 0; v < tamanhoVertice; v++) {
                        if (m[u][v] != -1) {
                            if (cores[v] == 0) {
                                cores[v] = 3 - cores[u];
                                fila.add(v);
                                if (cores[v] == 1) {
                                    tamanhoParticao1++;
                                } else {
                                    tamanhoParticao2++;
                                }
                            }
                            // Não precisa verificar se cores[v] == cores[u]
                        }
                    }
                }
            }
        }

        // Passo 3: Contar o número real de arestas
        int arestasContadas = 0;
        for (int i = 0; i < tamanhoVertice; i++) {
            for (int j = i + 1; j < tamanhoVertice; j++) {
                if (m[i][j] != -1) {
                    arestasContadas++;
                }
            }
        }

        // Passo 4: Comparar a contagem de arestas com o valor esperado (n * m)
        long arestasEsperadas = (long) tamanhoParticao1 * tamanhoParticao2;

        return arestasContadas == arestasEsperadas;
    }

    static boolean hasCiclo(int [][]m, int tamanhoVertice){
        if(tamanhoVertice < 3){
            return false;
        }
        for(int i = 0; i < tamanhoVertice; i++){
           int count = 0;
           for(int j = 0; j < tamanhoVertice; j++){
               if(m[i][j] != -1){
                   count++;
               }
           }
           if (count > 2){
               return true;
           }
        }
        return true;
    }

    static int boolToInt(boolean b){
        return b? 1: 0;
    }
}