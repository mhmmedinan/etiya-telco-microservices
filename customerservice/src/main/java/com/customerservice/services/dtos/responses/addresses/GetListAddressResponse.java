package com.customerservice.services.dtos.responses.addresses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListAddressResponse {

    private UUID id;
    private String street;
    private String flatNumber;
    private String description;
    private boolean defaultAddress;
    private String districtName;
    private String cityName;
}