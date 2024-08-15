package com.customerservice.services.dtos.responses.districts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListDistrictResponse {
    private int id;
    private String name;
    private String cityName;
    private LocalDateTime createdDate;
}