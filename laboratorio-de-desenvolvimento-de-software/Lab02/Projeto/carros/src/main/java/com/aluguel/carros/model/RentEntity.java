package com.aluguel.carros.model;

import org.springframework.data.annotation.Id;

import java.security.PrivateKey;

public class RentEntity {

    @Id
    private String id;
    private String userId;
    private String carId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
