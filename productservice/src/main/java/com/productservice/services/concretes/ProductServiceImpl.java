package com.productservice.services.concretes;

import com.etiya.common.responses.products.GetProductResponse;
import com.productservice.entities.Product;
import com.productservice.repositories.ProductRepository;
import com.productservice.services.abstracts.ProductService;
import com.productservice.services.dtos.requests.CreateProductRequest;
import com.productservice.services.dtos.responses.CreateProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = new Product();
        product.setDescription(request.getDescription());
        product.setName(request.getName());
        product.setTotalPrice(request.getTotalPrice());
        Product createdProduct = productRepository.save(product);

        CreateProductResponse response = new CreateProductResponse();
        response.setName(createdProduct.getName());
        response.setDescription(createdProduct.getDescription());
        response.setTotalPrice(createdProduct.getTotalPrice());
        return response;
    }

    @Override
    public GetProductResponse getById(UUID id) {
       Product product = productRepository.findById(id).get();
       GetProductResponse response = new GetProductResponse();
       response.setId(product.getId());
       response.setName(product.getName());
       response.setDescription(product.getDescription());
       response.setTotalPrice(product.getTotalPrice());
       return response;
    }
}
