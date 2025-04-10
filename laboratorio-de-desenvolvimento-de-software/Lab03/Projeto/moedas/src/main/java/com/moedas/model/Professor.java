package com.moedas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "professores")
public class Professor extends UsuarioEntity {

    @Id
    private String id;
    private String departamento;
    private String instituicao;

    private int saldoMoedas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getSaldoMoedas() {
        return saldoMoedas;
    }

    public void setSaldoMoedas(int saldoMoedas) {
        this.saldoMoedas = saldoMoedas;
    }
}
