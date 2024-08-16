package com.basketservice.services;

import com.basketservice.clients.ProductServiceClient;
import com.basketservice.entities.Basket;
import com.basketservice.entities.BasketItem;
import com.basketservice.repositories.RedisRepository;
import com.etiya.common.responses.products.GetProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService{

    private final RedisRepository redisRepository;
    private final ProductServiceClient productServiceClient;


    @Override
    public void add(String customerId, UUID productId) {
        Basket basket = redisRepository.getBasketByCustomerId(customerId);
        if (basket==null){
            basket= new Basket();
            basket.setCustomerId(customerId);
        }

        GetProductResponse response = productServiceClient.getById(productId);
        BasketItem basketItem = new BasketItem();
        basketItem.setProductId(productId.toString());
        basketItem.setProductName(response.getName());
        basketItem.setPrice(response.getTotalPrice());
        basket.setCustomerId(customerId);
        basket.setTotalPrice(basket.getTotalPrice()+basketItem.getPrice());
        basket.getBasketItems().add(basketItem);
        redisRepository.addItem(basket);
    }

    @Override
    public Map<String, Basket> getItems() {
        return redisRepository.getAllItems();
    }
}
