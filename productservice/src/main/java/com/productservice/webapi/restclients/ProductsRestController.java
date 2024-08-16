package com.productservice.webapi.restclients;

import com.etiya.common.responses.products.GetProductResponse;
import com.productservice.services.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductsRestController {

    private final ProductService productService;

    @GetMapping("{id}")
    public GetProductResponse getById(@PathVariable UUID id){
        return productService.getById(id);
    }
}
