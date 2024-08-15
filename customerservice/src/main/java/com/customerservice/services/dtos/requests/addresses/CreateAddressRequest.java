package com.customerservice.services.dtos.requests.addresses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {

    private String street;
    private String flatNumber;
    private String description;
    private boolean defaultAddress;
    private int districtId;
    private UUID customerId;
}
