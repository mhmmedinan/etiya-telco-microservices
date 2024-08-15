package com.etiya.common.events.customers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedIndividualCustomerEvent {
    private UUID id;
    private String firstName;
    private String lastName;
    private String nationalityId;
    private String gender;
}

