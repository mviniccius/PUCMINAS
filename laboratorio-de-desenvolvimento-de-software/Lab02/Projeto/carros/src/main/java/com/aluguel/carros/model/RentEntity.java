package com.aluguel.carros.model;

import org.springframework.data.annotation.Id;

public class RentEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
