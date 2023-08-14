public class CalculaHora {

    public static int tempoDescanco(int hora, int minuto, int materias){
        //declarando variaveis
        int tempoConvertido;
        int tempoDescanco;

        //convertendo o tempo total em minutos
        tempoConvertido = minuto + (hora * 60);

        tempoDescanco = tempoConvertido % materias;

        return tempoDescanco;

    }


}
