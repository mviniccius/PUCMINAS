//Classe Filho

public class Estudante extends Pessoa {
    private String matricula;
    private String curso;

    public Estudante(String nome, String sobrenome, String email, String telefone, String matricula, String curso) {
        super(nome, sobrenome, email, telefone);
        this.matricula = matricula;
        this.curso = curso;
    }

    //metodos getters e setters da classe filha
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    //Metodos depois dos Getters e Setters


    //@Override
    public void imprimirDados() {
        System.out.println("Estudante: "    + getNome() + " " + getSobrenome());
        System.out.println("Email: "        + getEmail());
        System.out.println("Telefone: "     + getTelefone());
        System.out.println("Matrícula: "    + getMatricula());
        System.out.println("Curso: "        + getCurso());
    }

    //@Override
    public String toString() {
        return "Matricula: " + this.matricula + "\nCurso: " + this.curso;
    }


    }

