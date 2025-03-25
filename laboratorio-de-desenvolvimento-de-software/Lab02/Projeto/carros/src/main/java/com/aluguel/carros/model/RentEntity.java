package com.aluguel.carros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "rents")
public class RentEntity {

    @Id
    private String id;
    private String carID;
    private LocalDate dataInicio;
    private LocalDate DataFim;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return DataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        DataFim = dataFim;
    }
}
