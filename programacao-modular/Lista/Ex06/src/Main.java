import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int primeirosNumeros;
        int ultimosNumeros;

        System.out.println("Digite o primeiro numero");
        primeirosNumeros = scanner.nextInt();
        System.out.println("Digite o segundo numero");
        ultimosNumeros = scanner.nextInt();

        System.out.println("O numero sorteado foi: " + NumeroSorteado.numeroSorteado(primeirosNumeros, ultimosNumeros));

    }
}