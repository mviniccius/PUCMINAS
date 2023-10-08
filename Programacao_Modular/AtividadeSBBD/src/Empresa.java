
//Classe filho de insituicao
public class Empresa extends Instituicao {              // extends usado para dar referencia a classe pai
    private String ramoAtividade;

    public Empresa(long cnpj, String endereco, String nome, String nomeResponsavel, String ramoAtividade) {
        super(cnpj, endereco, nome, nomeResponsavel); //funcao super recupera os atributos da classe pai
        this.ramoAtividade = ramoAtividade;
    }
    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }


    @Override // usado para sobrescrever o metodo
    public String toString() {
        return "Ramo de atividade: "  + ramoAtividade;
    }
}