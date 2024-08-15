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
public class CreateDistrictResponse {
    private int id;
    private String name;
    private int cityId;
    private LocalDateTime createdDate;
}
