package com.customerservice.services.dtos.requests.individualCustomers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteIndividualCustomerRequest {
    private UUID id;
}
