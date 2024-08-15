package com.customerservice.services.dtos.requests.districts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDistrictRequest {
    private String name;
    private int cityId;
}
