package com.etiya.common.responses.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
    private UUID id;
    private String name;
    private String description;
    private double totalPrice;
}
