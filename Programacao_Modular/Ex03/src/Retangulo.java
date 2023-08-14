public class Retangulo {

    public static void ratanguloVazado(int largura, int altura){
        //declarando variaveis
        int i, j;
        for(i = 1; i <= altura; i++){
            for(j = 1; j <= largura; j++){
                if (i == 1 || i == altura || j == 1 || j == largura) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static void retanguloCheio(int largura, int altura){
        //declaracao de variaveis
        int i, j;

        for(i = 1; i <= altura; i++){
            for(j = 1; j <= largura; j++){
                System.out.print("X");
            }
            System.out.println();
        }

    }



}
