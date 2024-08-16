package com.productservice.webapi.controllers;

import com.productservice.services.abstracts.ProductService;
import com.productservice.services.dtos.requests.CreateProductRequest;
import com.productservice.services.dtos.responses.CreateProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
        return productService.add(request);
    }
}
