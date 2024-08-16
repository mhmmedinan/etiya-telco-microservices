package com.basketservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class BasketItem {
    private String id;
    private String productId;
    private String productName;
    private double price;

    public BasketItem(){
        this.id = UUID.randomUUID().toString();
    }
}
