package com.basketservice.services;

import com.basketservice.entities.Basket;

import java.util.Map;
import java.util.UUID;

public interface BasketService {
    void add(String customerId, UUID productId);
    Map<String, Basket> getItems();
}
