package com.customerservice.services.dtos.responses.individualCustomers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteIndividualCustomerResponse {
    private UUID id;
    private String firstName;
    private String lastName;
}
