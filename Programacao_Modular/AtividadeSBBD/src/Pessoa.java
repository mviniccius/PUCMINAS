//Classe pai
public class Pessoa {
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;

    //Metodo construtor
    public Pessoa(String nome, String sobrenome, String email, String telefone) {
        this.nome       = nome;
        this.sobrenome  = sobrenome;
        this.email      = email;
        this.telefone   = telefone;
    }

    // Getters e Setters para os atributos

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //Metodo para imprimir os dados
    public void dadosPessoais(){
        System.out.println("Nome: "         + this.nome);
        System.out.println("Sobrenome: "    + this.sobrenome);
        System.out.println("Email: "        + this.email);
        System.out.println("Telefone: "     + this.telefone);
    }

}
