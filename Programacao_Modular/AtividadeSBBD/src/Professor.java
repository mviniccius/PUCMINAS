/*

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    private int matricula;
    private String departamento;
    List<SessaoTecnica> sessoesTecnicasAgendadas;
    public Professor(String nome, String sobrenome, String email, String telefone, String departamento, int matricula) {
        super(nome, sobrenome, email, telefone);
        this.matricula=matricula;
        this.departamento=departamento;
        this.sessoesTecnicasAgendadas = new ArrayList<>();
    }

    public boolean isHorarioDisponivel(LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
        for (SessaoTecnica sessaoTecnica : sessoesTecnicasAgendadas) {
            if (sessaoTecnica.getData().isEqual(data) && (
                    (horarioInicio.isAfter(sessaoTecnica.getHorarioInicio()) && horarioInicio.isBefore(sessaoTecnica.getHorarioFim())) ||
                            (horarioFim.isAfter(sessaoTecnica.getHorarioInicio()) && horarioFim.isBefore(sessaoTecnica.getHorarioFim())))) {
                return false;
            }
        }
        return true;
    }

    public boolean agendarSessaoTecnica(SessaoTecnica sessaoTecnica) {
        if (isHorarioDisponivel(sessaoTecnica.getData(), sessaoTecnica.getHorarioInicio(), sessaoTecnica.getHorarioFim())) {
            sessaoTecnica.setMediador(this);
            sessoesTecnicasAgendadas.add(sessaoTecnica);
            return true;
        }
        return false;
    }
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void apresentar() {
        System.out.println("Nome: " + getNome() + " " + getSobrenome());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Departamento: " + getDepartamento());
    }

    @Override
    public String toString() {
        return "Professor{" +
                "matricula=" + matricula +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}

 */