/*
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int codigo;
    private int idPredio;
    private List<Atividade> atividadesAgendadas; // Usar a classe abstrata Atividade

    public Sala() {
    }

    public Sala(int codigo, int idPredio) {
        this.codigo = codigo;
        this.idPredio = idPredio;
        this.atividadesAgendadas = new ArrayList<>();
    }

    public boolean isHorarioDisponivel(LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
        for (Atividade atividade : atividadesAgendadas) {
            if (atividade.getData().isEqual(data) && (
                    (horarioInicio.isAfter(atividade.getHorarioInicio()) && horarioInicio.isBefore(atividade.getHorarioFim())) ||
                            (horarioFim.isAfter(atividade.getHorarioInicio()) && horarioFim.isBefore(atividade.getHorarioFim())))) {
                return false;
            }
        }
        return true;
    }

    public boolean agendarAtividade(Atividade atividade) {
        if (isHorarioDisponivel(atividade.getData(), atividade.getHorarioInicio(), atividade.getHorarioFim())) {
            atividade.setSalaAssociada(this);
            atividadesAgendadas.add(atividade);
            return true;
        }
        return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(int idPredio) {
        this.idPredio = idPredio;
    }

    public List<Atividade> getAtividadesAgendadas() {
        return atividadesAgendadas;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "codigo=" + codigo +
                ", idPredio=" + idPredio +
                ", atividades=" + atividadesAgendadas +
                '}';
    }
}

 */