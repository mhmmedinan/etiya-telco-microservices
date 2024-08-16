package com.productservice.services.abstracts;

import com.etiya.common.responses.products.GetProductResponse;
import com.productservice.services.dtos.requests.CreateProductRequest;
import com.productservice.services.dtos.responses.CreateProductResponse;

import java.util.UUID;

public interface ProductService {
    CreateProductResponse add(CreateProductRequest request);
    GetProductResponse getById(UUID id);
}
