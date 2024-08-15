package com.customerservice.services.dtos.responses.cities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCityResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}
