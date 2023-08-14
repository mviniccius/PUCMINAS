import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declarando variaveis:
        String frase;
        String invertida;

        System.out.println("Inverter frase ou palavra");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Digite uma frase ou 'fim'para sair");

            frase = scanner.nextLine();

            if(frase.equals("fim")){
                System.out.println("Fim do programa");
                break;
            }
            invertida = inverterFrase(frase);
            System.out.println("A frase invertida: " + invertida);

        }
        scanner.close();
    }
    public static String inverterFrase(String frase) {
        StringBuilder sb = new StringBuilder(frase);
        return sb.reverse().toString();
    }

}