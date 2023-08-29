public class CalculaHora {

    public static double tempoDescanco(double hora, double minuto, double materias){
        //declarando variaveis
        double tempoConvertido;
        double tempoDescanco;

        //convertendo o tempo total em minutos
        tempoConvertido = minuto + (hora * 60);

        tempoDescanco = tempoConvertido % materias;

        return tempoDescanco;

    }

}
