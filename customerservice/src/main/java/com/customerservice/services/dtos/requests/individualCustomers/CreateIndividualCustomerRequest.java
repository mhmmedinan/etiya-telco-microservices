package com.customerservice.services.dtos.requests.individualCustomers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequest {
    private String email;
    private String mobilePhone;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nationalityId;
    private String birthDate;
    private String motherName;
    private String fatherName;
    private String gender;
}
