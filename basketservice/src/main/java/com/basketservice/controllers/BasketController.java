package com.basketservice.controllers;

import com.basketservice.entities.Basket;
import com.basketservice.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping
    public void addItem(@RequestParam String customerId, @RequestParam UUID productId)
    {
     basketService.add(customerId,productId);
    }

    @GetMapping
    public Map<String, Basket> getItems(){
        return basketService.getItems();
    }
}
