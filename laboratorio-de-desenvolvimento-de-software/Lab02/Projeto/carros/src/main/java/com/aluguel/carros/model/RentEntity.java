package com.aluguel.carros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "rent")
public class RentEntity {

    @Id
    private String id;
    private String carId; //rlacionamento com carro
    private String userId; // relacionamento com usuario



    //Get e set
    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userID) {
        this.userId = userID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carID) {
        this.carId = carID;
    }

}
