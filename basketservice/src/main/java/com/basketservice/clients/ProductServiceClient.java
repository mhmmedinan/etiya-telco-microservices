package com.basketservice.clients;

import com.etiya.common.responses.products.GetProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(url = "http://localhost:8091/product-service",name = "product-service")
public interface ProductServiceClient {

    @RequestMapping(method = RequestMethod.GET,value = "api/v1/products/{id}")
    GetProductResponse getById(@PathVariable UUID id);
}
