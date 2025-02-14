public class NumeroSorteado {

    public static int numeroSorteado(int primeiro, int segundo){

        int num1, num2, numInteiro;

        //tres ultimos digitos do primeiro numero
        num1 = primeiro % 1000;
        //tres primeiros do segundo numero
        num2 = segundo / 100;

        numInteiro = (num2 * 1000) + num1;

        return numInteiro;
    }
}
