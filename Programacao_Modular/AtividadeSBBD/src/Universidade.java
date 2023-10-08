public class Universidade extends Instituicao {
    private String sigla;
    private String campus;

    public Universidade(long cnpj, String endereco, String nome, String nomeResponsavel, String sigla, String campus) {
        super(cnpj, endereco, nome, nomeResponsavel);
        this.sigla = sigla;
        this.campus = campus;
    }


    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "Universidade{" +
                "sigla='" + sigla + '\'' +
                ", campus='" + campus + '\'' +
                '}';
    }
}