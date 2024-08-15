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
public class CreateIndividualCustomerResponse {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nationalityId;
    private String birthDate;
    private String motherName;
    private String fatherName;
    private String gender;
    private String mobilePhone;
    private String email;
}